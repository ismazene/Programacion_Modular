package org.example.EJERCICIOS;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidarTest {

    // Metodo a probar
    int suma_3() {
        return 16;
    }

    @Test
    void suma_3_test() {
        // assertEquals(valorEsperado, valorObtenido);
        assertEquals(16, suma_3());
    }

    @Test
    void validar_test() {
        // Aquí deberías probar el metodo validar() cuando exista
        // Por ahora lo dejo vacío para que no falle
    }
}
