package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bullseye implements Juego {
    private JugadorBullseye jugador;
    private List<Caballo> caballos;
    private int caballoElegido;
    private int apuestaElegida;
    private int[] apuestas = {500, 1000, 5000, 10000, 25000, 50000};
    private int[] multiplicadores = {2, 3, 4, 5, 7, 10};

    public Bullseye(JugadorBullseye jugador, int caballoElegido, int apuestaElegida) {
        this.jugador = jugador;
        this.caballoElegido = caballoElegido;
        this.apuestaElegida = apuestaElegida;
        this.caballos = crearCaballos();
    }

    public void setCaballoElegido(int caballoElegido) {
        this.caballoElegido = caballoElegido;
    }

    public void setApuestaElegida(int apuestaElegida) {
        this.apuestaElegida = apuestaElegida;
    }

    public void mostrarCaballos() {
        System.out.println("Lista de Caballos:");
        for (Caballo caballo : caballos) {
            System.out.println(caballo.getNumero() + ". " + caballo.getNombre());
        }
    }

    public void mostrarApuestas() {
        System.out.println("Lista de Apuestas:");
        for (int i = 0; i < apuestas.length; i++) {
            System.out.println((i + 1) + ". " + apuestas[i]);
        }
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
        if (!Validaciones.esOpcionValida(caballoElegido, 1, caballos.size())) {
            System.out.println("Selección de caballo inválida. Inténtalo nuevamente.");
            return;
        }

        if (!Validaciones.esOpcionValida(apuestaElegida, 1, apuestas.length)) {
            System.out.println("Selección de apuesta inválida. Inténtalo nuevamente.");
            return;
        }

        jugador.setCaballo(caballos.get(caballoElegido - 1));
        int apuesta = apuestas[apuestaElegida - 1];
        int multiplicador = multiplicadores[apuestaElegida - 1];

        // Validar que se tengan suficientes fondos para la apuesta
        if (!Validaciones.tieneSuficientesFondos(apuesta, jugador.getDinero())) {
            System.out.println("No tienes suficientes fondos para realizar esa apuesta.");
            return;
        }

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
