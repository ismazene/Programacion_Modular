package org.example;

import java.util.Scanner;

public class Jardines_Juez {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNext()) {
            int filas = teclado.nextInt();
            int columnas = teclado.nextInt();
            teclado.nextLine();

            char[][] jardin = new char[filas][columnas];
            for (int i = 0; i < filas; i++) {
                jardin[i] = teclado.nextLine().toCharArray();
            }

            int cortacesped = 0;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (jardin[i][j] == '#') {
                        cortacesped++;
                        jardin[i][j] = '.';

                        boolean encontrado = true;
                        while (encontrado) {
                            encontrado = false;
                            for (int filaActual = 0; filaActual < filas; filaActual++) {
                                for (int columnaActual = 0; columnaActual < columnas; columnaActual++) {
                                    if (jardin[filaActual][columnaActual] == '#') {
                                        for (int posicion = 0; posicion < 4; posicion++) {
                                            boolean borrar = false;
                                            switch (posicion) {
                                                case 0:
                                                    if (filaActual > 0 && jardin[filaActual - 1][columnaActual] == '.') borrar = true;
                                                    break;
                                                case 1:
                                                    if (filaActual < filas - 1 && jardin[filaActual + 1][columnaActual] == '.') borrar = true;
                                                    break;
                                                case 2:
                                                    if (columnaActual > 0 && jardin[filaActual][columnaActual - 1] == '.') borrar = true;
                                                    break;
                                                case 3:
                                                    if (columnaActual < columnas - 1 && jardin[filaActual][columnaActual + 1] == '.') borrar = true;
                                                    break;
                                            }
                                            if (borrar) {
                                                jardin[filaActual][columnaActual] = '.';
                                                encontrado = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cortacesped);
        }
    }
}
