package org.example;

import java.util.Scanner;

public class Jardines_Juez {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNext()) {
            int filas = teclado.nextInt();
            int columnas = teclado.nextInt();

            char[][] jardin = new char[filas][columnas];

            teclado.nextLine();

            for (int i = 0; i < filas; i++) {
                char[] filaJardin = teclado.nextLine().toCharArray();
                for (int j = 0; j < columnas; j++) {
                    jardin[i][j] = filaJardin[j];
                }
            }

            int cortacesped = 0;

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

    static void verificar(char[][] jardin, int fila, int columna) {
        if (fila < 0 || fila == jardin.length || columna < 0 || columna == jardin[fila].length || jardin[fila][columna] != '#') {
            return;
        }

        jardin[fila][columna] = '.';

        verificar(jardin, fila + 1, columna);
        verificar(jardin, fila - 1, columna);
        verificar(jardin, fila, columna + 1);
        verificar(jardin, fila, columna - 1);
    }
}
