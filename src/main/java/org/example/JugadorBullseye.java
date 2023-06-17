package org.example;

public class JugadorBullseye extends Jugador {
    private int dinero;
    private Caballo caballo;

    public JugadorBullseye(String nombre, int dinero, Caballo caballo) {
        super(nombre);
        this.dinero = dinero;
        this.caballo = caballo;
    }
    public Caballo getCaballo() {
        return caballo;
    }
    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }
    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
}
