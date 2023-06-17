package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bullseye implements Juego {
    private JugadorBullseye jugador;
    private List<Caballo> caballos;
    private int[] apuestas = {500, 1000, 5000, 10000, 25000, 50000};
    private int[] multiplicadores = {2, 3, 4, 5, 7, 10};

    public Bullseye(JugadorBullseye jugador) {
        this.jugador = jugador;
        this.caballos = crearCaballos();
    }

    public List<Caballo> crearCaballos() {
        List<Caballo> caballos = new ArrayList<>();
        String[] nombres = {"Rayo", "Cometa", "Blitz", "Viento", "Relámpago", "Tormenta"};
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Negro", "Blanco"};
        for (int i = 0; i < nombres.length; i++) {
            caballos.add(new Caballo(nombres[i], i+1, colores[i]));
        }
        return caballos;
    }

    public void jugar() {
        // Supongamos que el jugador siempre apuesta el monto máximo
        int apuesta = apuestas[apuestas.length-1];
        int multiplicador = multiplicadores[apuestas.length-1];

        // Generar un caballo ganador aleatorio
        int caballoGanador = (int)(Math.random() * 6 + 1);

        if (jugador.getCaballo().getNumero() == caballoGanador) {
            int ganancia = apuesta * multiplicador;
            jugador.setDinero(jugador.getDinero() + ganancia);
            System.out.println("¡" + jugador.getNombre() + " gana! Ahora tienes $" + jugador.getDinero());
        } else {
            jugador.setDinero(jugador.getDinero() - apuesta);
            System.out.println("Perdiste. Ahora tienes $" + jugador.getDinero());
        }
    }
}
