package org.example;

import java.util.Scanner;

public class Casino {
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("¡Bienvenido al casino! Por favor, ingresa tu nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Hola, " + nombre + ". ¿A qué juego deseas jugar?");
            System.out.println("1. Blackjack");
            System.out.println("2. Bullseye");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea después de leer un entero

            switch (opcion) {
                case 1:
                    JugadorBlackjack jugadorBlackjack = new JugadorBlackjack(nombre);
                    Blackjack blackjack = new Blackjack(jugadorBlackjack);
                    blackjack.jugar();
                    break;
                case 2:
                    JugadorBullseye jugadorBullseye = new JugadorBullseye(nombre, 50000, new Caballo("Rayo", 1, "Rojo"));
                    Bullseye bullseye = new Bullseye(jugadorBullseye, 0, 0);

                    boolean juegoBullseye = true;
                    while (juegoBullseye) {
                        System.out.println("Elige un caballo (1-6):");
                        bullseye.mostrarCaballos();
                        int caballoElegido = scanner.nextInt();
                        scanner.nextLine(); // Consumir nueva línea después de leer un entero

                        System.out.println("Elige una apuesta (1-6):");
                        bullseye.mostrarApuestas();
                        int apuestaElegida = scanner.nextInt();
                        scanner.nextLine(); // Consumir nueva línea después de leer un entero

                        bullseye.setCaballoElegido(caballoElegido);
                        bullseye.setApuestaElegida(apuestaElegida);
                        bullseye.jugar();

                        System.out.println("¿Quieres jugar nuevamente? (s/n)");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("n")) {
                            juegoBullseye = false;
                        }
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elige nuevamente.");
                    break;
            }
        }

        System.out.println("¡Gracias por jugar en el casino!");
    }
}


