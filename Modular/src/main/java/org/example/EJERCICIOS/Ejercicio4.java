package org.example.EJERCICIOS;

import java.util.Scanner;

public class Ejercicio4 {

    static Scanner teclado;
    static void main() {

        double recaudacion[] = introducirRecaudacion();

        for (double reca : recaudacion) {
            System.out.println(reca + " ");
        }
        System.out.println(diaMaximo(recaudacion) + " " + diaMinimo(recaudacion));
        double media = media(recaudacion);
        System.out.println(media);
        double domingo = domingo(recaudacion);
        System.out.println(domingo);

        if (domingo > media){
            System.out.println("SI");
        } else {
            System.out.println("NO");

        }
    }

    public static double[] introducirRecaudacion() {
        double recaudacion[] = new double[6];

        for (int i = 0; i < recaudacion.length; i++) {
            recaudacion[i] = teclado.nextDouble();
        }
        return recaudacion;
    }

    public static String diaMaximo(double recaudacion[]) {

        double maximo = recaudacion[0];
        int dia = 0;

        for (int i = 0; i < recaudacion.length; i++) {
            if (recaudacion[i] > maximo) {
                maximo = recaudacion[i];
                dia = i;
            }
        }
        return diaSemana(dia);
    }

    public static String diaMinimo(double recaudacion[]) {

        double minimo = recaudacion[0];
        int dia = 0;

        for (int i = 0; i < recaudacion.length; i++) {
            if (recaudacion[i] < minimo) {
                minimo = recaudacion[i];
                dia = i;
            }
        }
        return diaSemana(dia);
    }

    public static String diaSemana(int dia_numero) {

        switch (dia_numero) {

            case 0:
                return "MARTES";
            case 1:
                return "MIÉRCOLES";
            case 2:
                return "JUEVES";
            case 3:
                return "VIERNES";
            case 4:
                return "SÁBADO";

            case 5:
                return "DOMINGO";
        }

        return " ";
    }

    public static double media (double recaudacion[]){

        int acumulador = 0;
        for (int i = 0; i < recaudacion.length; i++) {
            acumulador += recaudacion[i];
        }
        return (acumulador/recaudacion.length);
    }

    public static double domingo(double recaudacion[]){
        //Chuto la utlima posicion (-1 menos del tamaño)
        return recaudacion[recaudacion.length-1];
    }


}

