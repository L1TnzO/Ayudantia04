package org.example;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BullseyeGUI extends JFrame {
    private JTextArea textArea;
    private Bullseye bullseyeGame;
    private JComboBox<String> horseComboBox;
    private JComboBox<Integer> betComboBox;

    public BullseyeGUI(String name)  {
        super("Bullseye");

        JugadorBullseye jugador = new JugadorBullseye(name, 50000, null);  // Usamos el nombre pasado como argumento
        bullseyeGame = new Bullseye(jugador, 0, 0);

        setLayout(new BorderLayout());

        JButton playButton = new JButton("Jugar");
        playButton.addActionListener(e -> playBullseye());

        JButton backButton = new JButton("Atrás");
        backButton.addActionListener(e -> goBack());

        horseComboBox = new JComboBox<>();
        betComboBox = new JComboBox<>();
        populateHorseComboBox();
        populateBetComboBox();

        JPanel controlsPanel = new JPanel();
        controlsPanel.add(backButton);
        controlsPanel.add(horseComboBox);
        controlsPanel.add(betComboBox);
        controlsPanel.add(playButton);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(controlsPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void goBack() {
        this.setVisible(false);
        new Casino().iniciar();
    }
    private void playBullseye() {
        textArea.setText("");  // Clear the text area
        bullseyeGame.setCaballoElegido(horseComboBox.getSelectedIndex() + 1);
        bullseyeGame.setApuestaElegida(betComboBox.getSelectedIndex() + 1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldOut = System.out;
        System.setOut(printStream);

        bullseyeGame.jugar();

        System.out.flush();
        System.setOut(oldOut);

        textArea.setText(outputStream.toString());
    }

    private void populateHorseComboBox() {
        List<Caballo> caballos = bullseyeGame.crearCaballos();
        for (Caballo caballo : caballos) {
            horseComboBox.addItem(caballo.getNombre());
        }
    }

    private void populateBetComboBox() {
        int[] apuestas = {500, 1000, 5000, 10000, 25000, 50000};
        for (int apuesta : apuestas) {
            betComboBox.addItem(apuesta);
        }
    }
}

