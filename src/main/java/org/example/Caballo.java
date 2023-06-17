package org.example;

class Caballo {
    private String nombre;
    private int numero;
    private String color;

    public Caballo(String nombre, int numero, String color) {
        this.nombre = nombre;
        this.numero = numero;
        this.color = color;
    }

    public int getNumero() {
        return numero;
    }
    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

}