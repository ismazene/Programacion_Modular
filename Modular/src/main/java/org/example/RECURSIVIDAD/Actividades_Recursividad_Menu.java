package org.example.RECURSIVIDAD;

import java.util.Scanner;

public class Actividades_Recursividad_Menu {

    static Scanner teclado = new Scanner(System.in);
    static String frase;
    static char[] frase_char;

    static void main(String[] args) {

        imprimirMenu();
        char opcion = teclado.next().charAt(0);

        if (!validar(opcion)) {
            System.out.println("No es valido");
        }

        imprimir_menu_final();
        String opcion_final = teclado.next();

        if (!validar_menu_final(opcion_final)) {
            System.out.println("No es valido");
        }
    }

    public static void imprimirMenu() {

        System.out.println("*** Batería de ejecicios sobre recursividad ***");
        System.out.println("--------------------------------------------------");
        System.out.println("1 - Dígitos");
        System.out.println("2 - Potenciales");
        System.out.println("3 - Del Revés ");
        System.out.println("4 - Binario");
        System.out.println("5 - A binario");
        System.out.println("6 - Orden alfabético");
        System.out.println("7 - Mostrar suma");
        System.out.println();
        System.out.println("Elige una opcion");
    }

    public static boolean validar(char opcion) {
        switch (opcion) {

            case '1':
                System.out.println("Dame un numero para calcular:");
                int numero1 = teclado.nextInt();
                System.out.println(digitos(numero1));
                System.out.println();
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
                System.out.println("Elige una opcion:");
                System.out.println("1 - Numero del reves");
                System.out.println("2 - Frase del reves");
                char opcion3 = teclado.next().charAt(0);

                if (opcion3 == '1') {
                    System.out.println("Dame un numero para ponerlo del reves:");
                    int numero_reves = teclado.nextInt();
                    del_reves(numero_reves);
                    System.out.println();
                } else if (opcion3 == '2') {
                    teclado.nextLine(); // limpiar buffer
                    System.out.println("Dame una frase:");
                    frase = teclado.nextLine();
                    frase_char = frase.toCharArray();

                    System.out.println("Frase al reves:");
                    del_reves_char(frase_char.length - 1);
                    System.out.println();
                } else {
                    System.out.println("Opcion no valida");
                }

                return true;


            case '4':
                System.out.println("Dame un numero: ");
                int numero = teclado.nextInt();

                if (esBinario(numero)) {
                    System.out.println("El numero es binario");
                } else {
                    System.out.println("El numero NO es binario");
                }
                System.out.println();
                return true;

            case '5':
                System.out.println("Dame un numero para convertir a binario: ");
                int numero_binario = teclado.nextInt();
                aBinario(numero_binario);
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
            System.out.print(numero);
        } else {
            System.out.print(numero % 10);
            del_reves(numero / 10);
        }
    }

    public static void del_reves_char(int posicion) {
        if (posicion >= 0) {
            System.out.print(frase_char[posicion]);
            del_reves_char(posicion - 1);
        }
    }

    public static boolean esBinario(int numero) {

        if (numero > 9) {
            if (numero % 10 != 0 && numero % 10 != 1) {
                return false;
            } else {
                return esBinario(numero / 10);
            }
        } else {
            if (numero == 0 || numero == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static String aBinario (int numero_binario){

        if (numero_binario == 0 || numero_binario == 1){
            return Integer.toString(numero_binario);
        }else{
            return aBinario(numero_binario/2)+numero_binario % 2;
        }

    }
}
