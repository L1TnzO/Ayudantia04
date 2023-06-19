package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BlackjackGUI extends JFrame {

    private JTextArea textArea;
    private Blackjack blackjackGame;

    public BlackjackGUI(String name) {
        super("Blackjack");

        JugadorBlackjack jugador = new JugadorBlackjack(name);
        blackjackGame = new Blackjack(jugador);

        setLayout(new BorderLayout());

        JButton playButton = new JButton("Jugar");
        playButton.addActionListener(e -> playBlackjack());

        JButton backButton = new JButton("Atrás");
        backButton.addActionListener(e -> goBack());

        JPanel controlPanel = new JPanel();
        controlPanel.add(playButton);
        controlPanel.add(backButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void playBlackjack() {
        textArea.setText("");  // Limpiar el área de texto
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldOut = System.out;
        System.setOut(printStream);

        blackjackGame.jugar();

        System.out.flush();
        System.setOut(oldOut);

        textArea.setText(outputStream.toString());
    }

    private void goBack() {
        this.setVisible(false);
        new Casino().iniciar();
    }
}

