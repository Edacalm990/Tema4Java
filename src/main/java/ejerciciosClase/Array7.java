/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author eli
 */
/*Escribir un programa que lea del teclado el tamaño de dos arrays de enteros (el mismo tamaño para los dos arrays). 
El programa inicializará los arrays con números aleatorios entre 1 y 100. 
Existirá un método llamado multiplicar que recibirá los dos arrays e irá multiplicando los elementos dos a dos, 
empezando por los elementos que ocupan la posición cero, luego la uno, etc, guardando el resultado en otro array, 
que será devuelto por el método. Además existirá un método para imprimir por pantalla los valores de los arrays.*/
public class Array7 {

    public static Random random = new Random();
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int tamano = -1;

        do {
            try {
                System.out.println("Dame el tamaño de los arrays");
                tamano = teclado.nextInt();
                if (tamano <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                teclado.nextLine();
                System.out.println("Debe ser un número entero y positivo mayor que 0");
            }
        } while (tamano <= 0);

        int[] arrayUno = generarArray(tamano);
        int[] arrayDos = generarArray(tamano);
        int[] arrayResultadoMultiplicar = multiplicarArrays(arrayUno, arrayDos);

        imprimirArray(arrayUno, "El array uno es: ");
        imprimirArray(arrayDos, "El array dos es: ");
        imprimirArray(arrayResultadoMultiplicar, "Los arrays multiplicando sus elementos: ");
    }

    public static int[] generarArray(int tamano) {
        int[] resultado = new int[tamano];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = random.nextInt(0, 101);
        }

        return resultado;
    }

    public static int[] multiplicarArrays(int[] arrayUno, int[] arrayDos) {
        int[] resultado = new int[arrayUno.length];
        for (int i = 0; i < arrayUno.length; i++) {
            resultado[i] = arrayUno[i] * arrayDos[i];
        }
        return resultado;
    }

    public static void imprimirArray(int[] array, String mensaje) {
        System.out.println(mensaje + Arrays.toString(array));
    }

;

}
