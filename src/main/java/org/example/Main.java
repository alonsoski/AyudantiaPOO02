package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ingresoDeDatos();
    }

    private static void ingresoDeDatos() {
        String[] nombres=new String[3];
        double[] pesos =new double[3];
        double[] alturas = new double[3];
        niño(nombres,pesos,alturas,0);
        niño(nombres,pesos,alturas,1);
        niño(nombres,pesos,alturas,2);
        veredictos(nombres,pesos,alturas);
    }

    private static void veredictos(String[] nombres, double[] pesos, double[] alturas) {
        imprimirImc(nombres[0],pesos[0],alturas[0]);
        imprimirImc(nombres[1],pesos[1],alturas[1]);
        imprimirImc(nombres[2],pesos[2],alturas[1]);
        System.out.println("el promedio de peso es:"+calcularPromedioPesos(pesos));
        System.out.println("el promedio de altura es:"+calcularPromedioAlturas(alturas));

    }

    private static double calcularPromedioAlturas(double[] alturas) {
        int cantidad=alturas.length;
        double acumulador=0;
        for (int i = 0; i < alturas.length ; i++) {
            acumulador+=alturas[i];
        }
        return acumulador/cantidad;
    }

    private static double calcularPromedioPesos(double[] pesos) {
        int cantidad=pesos.length;
        double acumulador=0;
        for (int i = 0; i < pesos.length ; i++) {
            acumulador+=pesos[i];
        }
        return acumulador/cantidad;
    }

    private static void imprimirImc(String nombre, double peso, double altura) {
        System.out.println("nombre:"+nombre);
        System.out.println("peso:"+peso);
        System.out.println("altura:"+altura);
        System.out.println("el imc es:"+getImc(peso,altura));
        System.out.println("esta dentro del rango de:"+rango(getImc(peso,altura)));
        System.out.println("------------------------------------------");
    }

    private static String rango(double imc) {
        if (imc<18.5){
            return "bajo peso";
        }else if (imc>=18.5 && imc<25){
            return "normal";
        }else if (imc>=25 && imc<30){
            return "sobrepeso";
        }else{
            return "obesidad";
        }
    }

    public static double getImc(double peso, double altura) {
        double imc=peso/(Math.pow(altura,2));
        return imc;
    }

    private static void niño(String[] nombres, double[] pesos, double[] alturas, int i) {
        nombreNino(nombres,i);
        pesoNino(pesos,i,nombres[i]);
        alturaNino(alturas,i,nombres[i]);
    }

    private static void alturaNino(double[] alturas, int i, String nombre) {
        Scanner t = new Scanner(System.in);
        double altura;

        altura = validacionAltura(nombre);
        alturas[i]=altura;
    }

    private static double validacionAltura(String nombre) {

        double altura=0;
        while (altura<1.2 || altura >1.9){
            try {
                Scanner t = new Scanner(System.in);
                System.out.println(altura);
                System.out.println("Ingrese la altura de:"+nombre+ " en metros");
                System.out.println("rango: 1.2m--1.9m");
                altura = t.nextDouble();
                if (altura>1.9 || altura<1.2){
                    System.out.println("debe estar dentro del rango");
                }

            }catch (InputMismatchException e){
                System.out.println("solo numeros");
            }

        }
        return altura;

    }

    private static void pesoNino(double[] pesos, int i,String nombre) {
        Scanner t = new Scanner(System.in);
        double peso;

        peso = validacionPeso(nombre);
        pesos[i]=peso;
    }

    private static double validacionPeso(String nombre) {
        double peso=0;
        while (peso<10 || peso >80){
            try {
                Scanner t = new Scanner(System.in);
                System.out.println("Ingrese el peso de:"+nombre);
                System.out.println("rango: 10-80 kg");
                peso = t.nextDouble();
            }catch (InputMismatchException e){
                System.out.println("solo numeros");
                continue;
            }
            if (peso>80 || peso<10){
                System.out.println("debe estar dentro del rango");
            }
        }
        return peso;
    }

    private static void nombreNino(String[] nombres, int i) {
        Scanner t= new Scanner(System.in);
        System.out.println("ingrese el nombre del niño n°"+(i+1)+" porfavor");
        String nombre=t.nextLine();
        nombres[i]=nombre;
    }

}