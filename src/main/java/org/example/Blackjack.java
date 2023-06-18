package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blackjack implements Juego {
    private JugadorBlackjack jugador;
    private final int CARTA_MAXIMA = 21;
    private List<Carta> mazo;

    public Blackjack(JugadorBlackjack jugador) {
        this.jugador = jugador;
        this.mazo = crearMazo();
    }

    public List<Carta> crearMazo() {
        String[] pintas = {"Corazón", "Trébol", "Diamante", "Pica"};
        List<Carta> mazo = new ArrayList<>();

        for (String pinta : pintas) {
            for (int i = 1; i <= 13; i++) {
                int valor = i > 10 ? 10 : i; // Jota, Quina y Kaiser tienen valor 10
                if (i == 1) valor = 11; // As tiene valor 11
                mazo.add(new Carta(pinta, valor));
            }
        }
        Collections.shuffle(mazo); // Barajamos el mazo
        return mazo;
    }

    public void jugar() {
        List<Carta> manoJugador = new ArrayList<>();
        List<Carta> manoCasa = new ArrayList<>();

        // Dar tres cartas al jugador y a la casa
        for (int i = 0; i < 3; i++) {
            manoJugador.add(darCarta());
            manoCasa.add(darCarta());
        }

        // Calcular el valor de la mano del jugador y de la casa
        int valorManoJugador = calcularValorMano(manoJugador);
        int valorManoCasa = calcularValorMano(manoCasa);

        // Mostrar las cartas del jugador
        System.out.println(jugador.getNombre() + " tiene las siguientes cartas:");
        for (Carta carta : manoJugador) {
            System.out.println(carta.getPinta() + " - Valor: " + carta.getValor());
        }

        // Mostrar las cartas de la casa
        System.out.println("La casa tiene las siguientes cartas:");
        for (Carta carta : manoCasa) {
            System.out.println(carta.getPinta() + " - Valor: " + carta.getValor());
        }

        // Determinar el ganador
        if (valorManoJugador > CARTA_MAXIMA) {
            System.out.println("¡La casa gana! El jugador se pasó de 21.");
        } else if (valorManoCasa > CARTA_MAXIMA) {
            System.out.println("¡" + jugador.getNombre() + " gana! La casa se pasó de 21.");
        } else if (valorManoJugador > valorManoCasa) {
            System.out.println("¡" + jugador.getNombre() + " gana! Su mano es mayor que la de la casa.");
        } else if (valorManoCasa > valorManoJugador) {
            System.out.println("¡La casa gana! Su mano es mayor que la del jugador.");
        } else {
            System.out.println("Es un empate. Nadie gana.");
        }
    }


    private Carta darCarta() {
        return mazo.remove(mazo.size() - 1);
    }

    private int calcularValorMano(List<Carta> mano) {
        int valorMano = 0;
        int ases = 0;

        for (Carta carta : mano) {
            valorMano += carta.getValor();
            if (carta.getValor() == 11) {
                ases++;
            }
        }

        // Ajustar el valor de los ases si se supera 21
        while (valorMano > CARTA_MAXIMA && ases > 0) {
            valorMano -= 10;
            ases--;
        }

        return valorMano;
    }
}

