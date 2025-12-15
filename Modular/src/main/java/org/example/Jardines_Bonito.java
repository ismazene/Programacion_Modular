package org.example;

import java.util.Scanner;

/**
 * Los jardines de La Alhambra (769)
 *
 * @author Ismael
 * @version 1.0
 */
public class Jardines_Bonito {

    /**
     * Metodo principal, lee las filas y columnas y calcula donde esta el cesped.
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Leer filas y columnas mientras haya datos
        System.out.println("*************************************");
        System.out.println("★ BIENVENIDO AL CORTACESPED CON GPS ★");
        System.out.println("*************************************");

        System.out.println("");
        System.out.println("Porfavor introduce el numero de filas y columnas que tiene tu jardin :)");

        //Esto podria ser un metodo en el que se verifique todo hay que verlo en casa
        while (teclado.hasNext()) {

            int filas = 0;
            try {
                filas = teclado.nextInt();
            } catch (Exception e) {
                System.err.println("EL formato es incorrecto");
                return;
            }

            int columnas = 0;
            try {
                columnas = teclado.nextInt();
            } catch (Exception e) {
                System.err.println("El formato es incorrecto");
                return;
            }


            // Crear la matriz
            char[][] jardin = new char[filas][columnas];

            teclado.nextLine();

            ///Esto podria ser un metodo (no????)
            // Llenar las filas y columans del jardin (la matriz)
            for (int i = 0; i < filas; i++) {
                char[] filaJardin = teclado.nextLine().toCharArray();
                for (int j = 0; j < columnas; j++) {
                    jardin[i][j] = filaJardin[j];
                }
            }

            // Contador
            int cortacesped = 0;

            // Recorrer la matriz para contar las zonas de cesped
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (jardin[i][j] == '#') {
                        cortacesped++;
                        verificar(jardin, i, j);
                    }
                }
            }

            System.out.println(cortacesped);
        }
    }

    /**
     * Metodo para mirar todas las celdas conectadas con cesped
     *
     * @param jardin La matriz total
     * @param fila Fila en la que se encuentra la celda de cesped
     * @param columna Columna en la que se encuentra la celda de césped
     */
    static void verificar(char[][] jardin, int fila, int columna) {
        // Verificacion de donde esta el ceped en la matriz o jardin
        if (fila < 0 || fila == jardin.length || columna < 0 ||
        columna == jardin[fila].length || jardin[fila][columna] != '#') {
            return;
        }

        // Marcar la celda como visitada
        jardin[fila][columna] = '.';

        // Explorar las celdas arriba, abajo, izquierda, derecha
        verificar(jardin, fila + 1, columna);
        verificar(jardin, fila - 1, columna);
        verificar(jardin, fila, columna + 1);
        verificar(jardin, fila, columna - 1);
    }
}
