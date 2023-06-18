package org.example;

import java.util.Scanner;

import java.util.Scanner;

public class Casino {
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al casino! Por favor, ingresa tu nombre:");
        String nombre = scanner.nextLine();

        JugadorBullseye jugadorBullseye = null; // Inicialización predeterminada

        boolean salir = false;

        while (!salir) {
            System.out.println("Hola, " + nombre + ". ¿A qué juego deseas jugar?");
            System.out.println("1. Blackjack");
            System.out.println("2. Bullseye");
            System.out.println("3. Salir");

            String opcionStr = scanner.nextLine();
            if (!Validaciones.esOpcionValida(opcionStr, 1, 3)) {
                System.out.println("Opción inválida. Por favor, elige nuevamente.");
                continue;
            }

            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    JugadorBlackjack jugadorBlackjack = new JugadorBlackjack(nombre);
                    Blackjack blackjack = new Blackjack(jugadorBlackjack);
                    blackjack.jugar();
                    break;
                case 2:
                    if (jugadorBullseye == null) {
                        jugadorBullseye = new JugadorBullseye(nombre, 50000, new Caballo("Rayo", 1, "Rojo"));
                    }
                    Bullseye bullseye = new Bullseye(jugadorBullseye, 0, 0);

                    boolean juegoBullseye = true;
                    while (juegoBullseye) {
                        System.out.println("Elige un caballo (1-6):");
                        bullseye.mostrarCaballos();
                        String caballoElegidoStr = scanner.nextLine();
                        if (!Validaciones.esOpcionValida(caballoElegidoStr, 1, 6)) {
                            System.out.println("Selección de caballo inválida. Inténtalo nuevamente.");
                            continue;
                        }
                        int caballoElegido = Integer.parseInt(caballoElegidoStr);

                        System.out.println("Elige una apuesta (1-6):");
                        bullseye.mostrarApuestas();
                        String apuestaElegidaStr = scanner.nextLine();
                        if (!Validaciones.esOpcionValida(apuestaElegidaStr, 1, 6)) {
                            System.out.println("Selección de apuesta inválida. Inténtalo nuevamente.");
                            continue;
                        }
                        int apuestaElegida = Integer.parseInt(apuestaElegidaStr);

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




