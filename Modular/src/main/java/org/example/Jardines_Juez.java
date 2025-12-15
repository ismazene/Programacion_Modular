package org.example;

import java.util.Scanner;

/**
 * Los jardines de La Alhambra (769)
 *
 * @author Ismael
 * @version 1.0
 */
public class Jardines_Juez {

    /**
     * Metodo principal, lee las filas y columnas y calcula donde esta el cesped.
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Leer filas y columnas mientras haya datos
        while (teclado.hasNext()) {
            int filas = teclado.nextInt();
            int columnas = teclado.nextInt();

            // Crear la matriz (jardin)
            char[][] jardin = new char[filas][columnas];

            teclado.nextLine();

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
        // Comprar el rango de cesped (no puede ser mayor o menor que loque se pone al principio)
        if (fila < 0 || fila == jardin.length || columna < 0 || columna == jardin[fila].length || jardin[fila][columna] != '#') {
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
