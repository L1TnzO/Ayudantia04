package org.example;

import java.util.Scanner;

public class Casino {
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al casino! Por favor, ingresa tu nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Hola, " + nombre + ". ¿A qué juego deseas jugar? (1 para Blackjack, 2 para Bullseye)");
        int juego = scanner.nextInt();

        if (juego == 1) {
            JugadorBlackjack jugador = new JugadorBlackjack(nombre);
            new Blackjack(jugador).jugar();
        } else if (juego == 2) {
            // Supongamos que el jugador siempre elige el primer caballo
            JugadorBullseye jugador = new JugadorBullseye(nombre, 50000, new Caballo("Rayo", 1, "Rojo"));
            new Bullseye(jugador).jugar();
        }
    }
}
