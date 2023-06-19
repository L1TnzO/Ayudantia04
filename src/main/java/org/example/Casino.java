package org.example;

import javax.swing.JOptionPane;

public class Casino {
    private String nombre;
    private CasinoGUI casinoGUI;

    public void iniciar() {
        casinoGUI = new CasinoGUI(this);
        casinoGUI.mostrar();
    }

    public void abrirBlackjack() {
        if (!nombre.isEmpty()) {
            new BlackjackGUI(nombre);
        } else {
            casinoGUI.mostrarError("Please enter your name!");
        }
    }

    public void abrirBullseye() {
        if (!nombre.isEmpty()) {
            new BullseyeGUI(nombre);
        } else {
            casinoGUI.mostrarError("Please enter your name!");
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

