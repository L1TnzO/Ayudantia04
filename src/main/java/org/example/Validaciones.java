package org.example;

public class Validaciones {

    public static boolean esOpcionValida(int opcion, int minOpcion, int maxOpcion) {
        return opcion >= minOpcion && opcion <= maxOpcion;
    }

    public static boolean esOpcionValida(String opcion, int minOpcion, int maxOpcion) {
        try {
            int valor = Integer.parseInt(opcion);
            return valor >= minOpcion && valor <= maxOpcion;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean tieneSuficientesFondos(int cantidad, int dineroDisponible) {
        return cantidad <= dineroDisponible;
    }
}

