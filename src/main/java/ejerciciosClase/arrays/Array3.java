/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author eli
 */
/*
Crea un array de doubles de tamaño 20. Usando los métodos de la clase Arrays:

Rellena el array con el valor 7.5 en todas sus posiciones.
Realiza una copia del array anterior en un nuevo array.
Imprime ambos arrays. No se usa clase Arrays
Compara ambos arrays, mostrando si son iguales.
Introduce el valor 6.3 en una posición aleatoria válida de uno de los arrays. No se usa clase Arrays
Imprime ambos arrays.
Vuelve a compararlos, indicando si son iguales o no.

 */
public class Array3 {
    
    public static Random random= new Random();

    public static void main(String[] args) {
        double[] array = new double[20];
        Arrays.fill(array, 7.5);

        double[] arrayCopia = Arrays.copyOf(array, 20);
        
        for (double numero : array) {
            System.out.println(numero);
        }
        for (double numero : arrayCopia) {
            System.out.println(numero);
        }
        
        System.out.println("""
                           Los arrays son iguales? %b
                           """.formatted(Arrays.equals(array, arrayCopia)));
        
        int posicion = random.nextInt(0, array.length);
        array[posicion]=6.3;
        
        for (double numero : array) {
            System.out.println(numero);
        }
        for (double numero : arrayCopia) {
            System.out.println(numero);
        }
        
        System.out.println("""
                           Los arrays son iguales? %b
                           """.formatted(Arrays.equals(array, arrayCopia)));
        
    }
}
