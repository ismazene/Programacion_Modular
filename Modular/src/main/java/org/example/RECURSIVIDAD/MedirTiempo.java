package org.example.RECURSIVIDAD;

public class MedirTiempo {

    public static void main(String[] args) {
        System.gc(); // Limpia lo que pueda antes de medir

        long inicioEjecucion = System.nanoTime();
        long memoriaAntes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // PROGRAMA A REALIZAR
        imprimir(0);
        int resultado = suma(10);
        System.out.println("Suma: " + resultado);

        long finEjecucion = System.nanoTime();
        long memoriaDespues = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Tiempo: " + (finEjecucion - inicioEjecucion) + " ns");
        System.out.println("Memoria consumida: " + (memoriaDespues - memoriaAntes) + " bytes");
    }

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
