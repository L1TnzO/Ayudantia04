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
        // Jugador y computadora toman una carta del mazo
        Carta cartaJugador = mazo.remove(mazo.size()-1);
        Carta cartaComputadora = mazo.remove(mazo.size()-1);

        System.out.println(jugador.getNombre() + " sacó una carta con valor " + cartaJugador.getValor());
        System.out.println("La casa sacó una carta con valor " + cartaComputadora.getValor());

        if (cartaJugador.getValor() > CARTA_MAXIMA || (cartaComputadora.getValor() <= CARTA_MAXIMA && cartaComputadora.getValor() > cartaJugador.getValor())) {
            System.out.println("¡La casa gana!");
        } else {
            System.out.println("¡" + jugador.getNombre() + " gana!");
        }
    }
}
