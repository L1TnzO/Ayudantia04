package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidacionesTest {

    @Test
    public void testEsOpcionValida_Entero_Valido() {
        int opcion = 2;
        int minOpcion = 1;
        int maxOpcion = 3;
        boolean resultado = Validaciones.esOpcionValida(opcion, minOpcion, maxOpcion);
        assertTrue(resultado);
    }

    @Test
    public void testEsOpcionValida_Entero_Invalido() {
        int opcion = 5;
        int minOpcion = 1;
        int maxOpcion = 3;
        boolean resultado = Validaciones.esOpcionValida(opcion, minOpcion, maxOpcion);
        assertFalse(resultado);
    }

    @Test
    public void testEsOpcionValida_String_Valido() {
        String opcion = "2";
        int minOpcion = 1;
        int maxOpcion = 3;
        boolean resultado = Validaciones.esOpcionValida(opcion, minOpcion, maxOpcion);
        assertTrue(resultado);
    }

    @Test
    public void testEsOpcionValida_String_Invalido() {
        String opcion = "5";
        int minOpcion = 1;
        int maxOpcion = 3;
        boolean resultado = Validaciones.esOpcionValida(opcion, minOpcion, maxOpcion);
        assertFalse(resultado);
    }

    @Test
    public void testEsOpcionValida_String_CaracteresNoNumericos() {
        String opcion = "abc";
        int minOpcion = 1;
        int maxOpcion = 3;
        boolean resultado = Validaciones.esOpcionValida(opcion, minOpcion, maxOpcion);
        assertFalse(resultado);
    }

    @Test
    public void testTieneSuficientesFondos_Suficientes() {
        int cantidad = 100;
        int dineroDisponible = 200;
        boolean resultado = Validaciones.tieneSuficientesFondos(cantidad, dineroDisponible);
        assertTrue(resultado);
    }

    @Test
    public void testTieneSuficientesFondos_Insuficientes() {
        int cantidad = 200;
        int dineroDisponible = 100;
        boolean resultado = Validaciones.tieneSuficientesFondos(cantidad, dineroDisponible);
        assertFalse(resultado);
    }

    @Test
    public void testTieneSuficientesFondos_CantidadCero() {
        int cantidad = 0;
        int dineroDisponible = 100;
        boolean resultado = Validaciones.tieneSuficientesFondos(cantidad, dineroDisponible);
        assertTrue(resultado); // La cantidad cero se considera suficiente
    }

    @Test
    public void testTieneSuficientesFondos_DineroDisponibleCero() {
        int cantidad = 100;
        int dineroDisponible = 0;
        boolean resultado = Validaciones.tieneSuficientesFondos(cantidad, dineroDisponible);
        assertFalse(resultado);
    }
}
