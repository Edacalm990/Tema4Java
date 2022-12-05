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
    public static  Random random = new Random ();
    public static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Dame el tamaño de los arrays");
        int tamano = teclado.nextInt();
        int [] arrayPrueba= generarArray(tamano);
        int [] arraypruebCopia = generarArray(tamano);
        

        
    }
    
    public static int [] generarArray (int tamano){
    int [] resultado= new int [tamano];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i]=random.nextInt(0, 101);  
        }
 {
        }
    return resultado;
    };
    
}
