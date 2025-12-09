    package org.example.EJERCICIOS;

    import java.util.Scanner;

    public class Programame_modo1 {

        static Scanner teclado;

        public static void main(String[] args) {

            teclado = new Scanner(System.in);

            int numCasos = teclado.nextInt();
            teclado.nextLine();

            for (int i = 0; i < numCasos; i++)
                casoDePrueba();
        }

        public static void casoDePrueba() {

            String persona[] = teclado.nextLine().split(" ");

            // Ejemplo: imprimir la primera palabra
            System.out.println("Hola, " + persona[1] + ".");
        }
    }
