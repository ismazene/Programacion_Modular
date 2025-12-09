package org.example.EJERCICIOS;

import java.util.Scanner;

public class Ejercicio3 {

    static void main() {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce una cadena...");
        String cadena = teclado.nextLine();
        cadena = mayusculas(cadena);
        System.out.println(cadena);
        System.out.println("Hay " + contarVocales(cadena) + " vocales");


    }

    /**
     * @author Ismael
     * @version 1.0
     * Metodo pasar a mayasculas a una cadena
     * @param
     * @return
     */

    public static String mayusculas(String cadena){

        return cadena.toUpperCase();

    }

    public static int contarVocales(String cadena){

        int numero_vocales = 0 ;

        for (int i = 0; i < cadena.length(); i++) {

            switch (cadena.charAt(i)){
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    numero_vocales++;
                    break;
            }

        }
        return numero_vocales;

    }
}