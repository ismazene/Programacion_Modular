package org.example.RECURSIVIDAD;

public class Ejercicio2 {
    static int limite = 10;

    static void main() {
        imprimir(1);
        System.out.println(10);
    }

    public static void imprimir(int num) {
        if (num < limite){
            System.out.println(num);
            imprimir(num + 1);
        }

    }

    public static int suma (int num){

        if (num==0){
            return 0;
        } else {
            return num +suma (num-1);
        }

    }
}
