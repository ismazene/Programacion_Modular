package org.example.EJERCICIOS.RECURSIVIDAD;

import java.util.Scanner;

public class Ejercicio2 {
    static int limite = 10;

    static void main() {
        imprimir(1);
    }

    public static void imprimir(int num) {
        if (num < limite) return;
        else System.out.println(num);
        imprimir(num + 1);
    }
}
