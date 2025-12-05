package org.example.EJERCICIOS;

public class Sobrecarga {
    static void main() {
        //Aunque tenga el mismo nombre los metodos, uno espera un nombre de marca
        coche("renault");
        coche();
        coche(10);
    }

    public static void coche (){
        System.out.println("brrrr brrrr");
    }
    public static void coche(String marca){
        System.out.println("Hola soy un " + marca);
    }
    public static void coche(int numero){
        System.out.println("Hola soy un " + numero);
    }
}
