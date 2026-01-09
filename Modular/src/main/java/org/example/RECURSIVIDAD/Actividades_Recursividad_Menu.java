package org.example.RECURSIVIDAD;

import java.util.Scanner;


public class Actividades_Recursividad_Menu {

    static Scanner teclado = new Scanner(System.in);
    static String frase = "Hola soy una frase al reves";
    static char[] frase_char = frase.toCharArray();

    static void main(String[] args) {

        imprimirMenu();
        char opcion = teclado.next().charAt(0);

        if (validar(opcion)) {
        } else {
            System.out.println("No es valido");
        }

        imprimir_menu_final();
        String opcion_final = teclado.next();

        if (validar_menu_final(opcion_final)) {
        } else {
            System.out.println("No es valido");
        }
    }

    public static void imprimirMenu() {

        System.out.println("*** Batería de ejecicios sobre recursividad ***");
        System.out.println("--------------------------------------------------");
        System.out.println("1 - Dígitos");
        System.out.println("2 - Potenciales");
        System.out.println("3 - Del Revés");
        System.out.println("4 - Binario");
        System.out.println("5 - A binario");
        System.out.println("6 - Orden alfabético");
        System.out.println("7 - Mostrar suma");
    }

    public static boolean validar(char opcion) {
        switch (opcion) {
            case '1':
                System.out.println("Dame un numero para calcular:");
                int numero = teclado.nextInt();
                System.out.println(digitos(numero));
                System.out.println("");
                return true;
            case '2':
                System.out.println("Dame la base:");
                int base = teclado.nextInt();

                System.out.println("Dame el exponente:");
                int exponente = teclado.nextInt();

                System.out.println();
                System.out.println(potencia(base, exponente));
                System.out.println();
                return true;
            case '3':
                System.out.println("Dame un numero paa ponerlo del reves:");
                int numero_reves = teclado.nextInt();

                System.out.println();
                del_reves(numero_reves);
                System.out.println();
                return true;

//            System.out.println("Frase al reves:");
//            del_reves_char(frase_char.length - 1);
//            System.out.println();
//            return true;
            case '4':

            case '5':
            case '6':
            case '7':
                return true;
            default:
                return false;
        }
    }

    public static void imprimir_menu_final() {
        System.out.println("Elige una opcion");
        System.out.println("[M] - Volver al menú principal");
        System.out.println("[X] - Salir");
    }

    public static boolean validar_menu_final(String opcion_final) {
        switch (opcion_final.toUpperCase()) {
            case "M":
            case "X":
                return true;
            default:
                return false;
        }
    }

    public static int digitos(int numero) {

        if (numero < 10) {
            return 1;
        } else {
            return 1 + digitos(numero / 10);
        }
    }

    public static int potencia(int base, int exponente) {

        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    public static void del_reves(int numero) {
        if (numero < 10) {
            System.out.println(numero);
        } else {
            System.out.println(numero % 10);
            del_reves(numero / 10);
        }
    }

    public static void del_reves_char(int posicion) {
        if (posicion >= 0) {
            System.out.println(frase_char[posicion]);
            del_reves_char(posicion - 1);
        }

    }

    
}



