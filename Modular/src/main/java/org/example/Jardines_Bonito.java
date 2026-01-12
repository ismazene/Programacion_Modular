package org.example;

import java.util.Scanner;

/**
 * Los jardines de La Alhambra
 *
 * Programa que calcula cuantos cortacespedes se necesitan
 *
 * Autor: Ismael Zeneddine Ouahidi
 * Version: 1.1
 */
public class Jardines_Bonito {

    /**
     * Metodo principal que ejecuta el programa.
     * Muestra mensajes de bienvenida, pide al usuario el tamanio del jardin,
     * llama a los metodos y dice cuantos cortacespedes se necesitan
     *
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Mensaje de bienvenida
        System.out.println("*************************************");
        System.out.println("★ BIENVENIDO AL CORTACESPED CON GPS ★");
        System.out.println("*************************************");

        // Leer casos mientras haya datos
        while (true) {

            int filas = 0;
            int columnas = 0;

            // Leer filas y columnas con reintentos
            boolean valido = false;
            while (!valido) {
                System.out.println("Introduce el numero de filas y columnas:");
                try {
                    filas = teclado.nextInt();
                    columnas = teclado.nextInt();
                    teclado.nextLine();
                    if (filas < 2 || filas > 100 || columnas < 2 || columnas > 100) {
                        System.err.println("Las filas y columnas deben estar entre 2 y 100.");
                    } else {
                        valido = true;
                    }
                } catch (Exception e) {
                    System.err.println("ERROR: Introduce numeros enteros validos.");
                    teclado.nextLine();
                }
            }

            // Leer la matriz del jardin
            char[][] jardin = leerJardin(teclado, filas, columnas);

            // Contar cortacespedes
            int cortacesped = contarCesped(jardin, filas, columnas);

            // Mostrar resultado
            System.out.println("Numero de cortacespedes necesarios: " + cortacesped);
            System.out.println("****************************************");
        }
    }

    /**
     * Metodo para leer la matriz del jardin.
     * Pide al usuario cada fila hasta que sea valida.
     *
     * @param teclado Scanner para leer la entrada del usuario
     * @param filas numero de filas del jardin
     * @param columnas numero de columnas del jardin
     *
     * @return matriz del jardin
     */
    public static char[][] leerJardin(Scanner teclado, int filas, int columnas) {
        char[][] jardin = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            boolean filaValida = false;
            while (!filaValida) {
                String linea = teclado.nextLine();

                if (linea.length() != columnas) {
                    System.err.println("ERROR: La fila debe tener exactamente " + columnas);
                    continue;
                }

                // Validar que solo haya '#' o '.'
                boolean soloCaracteresValidos = true;
                for (char caracter : linea.toCharArray()) {
                    if (caracter != '#' && caracter != '.') {
                        soloCaracteresValidos = false;
                        break;
                    }
                }

                if (!soloCaracteresValidos) {
                    System.err.println("ERROR: Solo se permiten (#) o (.) en la fila.");
                } else {
                    jardin[i] = linea.toCharArray();
                    filaValida = true;
                }
            }
        }

        return jardin;
    }

    /**
     * Metodo para contar cuantos cortacespedes se necesitan
     *
     * @param jardin matriz del jardin
     * @param filas numero de filas del jardin
     * @param columnas numero de columnas del jardin
     *
     * @return numero de cortacespedes necesarios
     */
    public static int contarCesped(char[][] jardin, int filas, int columnas) {
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
                                            case 0: // arriba
                                                if (filaActual > 0 && jardin[filaActual - 1][columnaActual] == '.'){
                                                    borrar = true;
                                                }
                                                break;
                                            case 1: // abajo
                                                if (filaActual < filas - 1 && jardin[filaActual + 1][columnaActual] == '.'){
                                                    borrar = true;
                                                }
                                                break;
                                            case 2: // izquierda
                                                if (columnaActual > 0 && jardin[filaActual][columnaActual - 1] == '.'){
                                                    borrar = true;
                                                }
                                                break;
                                            case 3: // derecha
                                                if (columnaActual < columnas - 1 && jardin[filaActual][columnaActual + 1] == '.'){
                                                    borrar = true;
                                                }
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

        return cortacesped;
    }
}
