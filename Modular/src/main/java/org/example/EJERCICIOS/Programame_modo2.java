package org.example.EJERCICIOS;

import java.util.Scanner;

public class Programame_modo2 {

    static Scanner teclado;

    static void main(String[] args) {
        teclado = new Scanner(System.in);
        while (casoDePrueba()) {
        }
    } // main

    public static boolean casoDePrueba() {
        //  leer caso de prueba
        int x = teclado.nextInt();
        int y = teclado.nextInt();
        teclado.nextLine();
        if (x < 0 || y < 0)
            return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            int perimetro = (x+y)*2;
            System.out.println(perimetro);
            return true;
        }
    } // casoDePrueba

}

