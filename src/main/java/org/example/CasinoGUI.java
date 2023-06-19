package org.example;

import javax.swing.*;
import java.awt.*;

public class CasinoGUI {
    private JFrame frame;
    private JPanel panel;
    private JButton blackjackButton;
    private JButton bullseyeButton;
    private JButton exitButton;
    private JTextField nameField;
    private JLabel nameLabel;
    private Casino casino;

    public CasinoGUI(Casino casino) {
        this.casino = casino;

        frame = new JFrame("Casino");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField();

        blackjackButton = new JButton("Blackjack");
        blackjackButton.addActionListener(e -> {
            casino.setNombre(nameField.getText());
            casino.abrirBlackjack();
        });

        bullseyeButton = new JButton("Bullseye");
        bullseyeButton.addActionListener(e -> {
            casino.setNombre(nameField.getText());
            casino.abrirBullseye();
        });

        exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(blackjackButton);
        panel.add(bullseyeButton);
        panel.add(exitButton);

        frame.add(panel, BorderLayout.CENTER);
    }

    public void mostrar() {
        frame.setVisible(true);
    }

    public void mostrarError(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}


