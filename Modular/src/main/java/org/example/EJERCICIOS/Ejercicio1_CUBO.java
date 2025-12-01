package org.example.EJERCICIOS;

import java.util.Scanner;

public class Ejercicio1_CUBO {
    static void main(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame un numero...");
        int numero = teclado.nextInt();
        // Validar numero

        int resultado = cubo(numero);
        System.out.println(resultado);
    }

    public static int cubo (int numero){
        return numero*numero*numero;
    }
}
