/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import java.util.Arrays;

/**
 *
 * @author eli
 */
/*Hacer un programa que determine si dos arrays son iguales. 
Probarlo con los arrays [1,2,3] y [1,2,3], [1,2,3,4] y [1,2,3] , [1,2,3] y [1,2,2]. 
Este ejercicio hay que hacerlo de dos formas: la primera, usando la clase Arrays; 
la segunda, creando un método que vaya comparando los valores de los arrays y devuelva true si todos son iguales o false en caso contrario.*/
public class Array6 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {1, 2, 3, 4};
        int[] array4 = {1, 2, 3};
        int[] array5 = {1, 2, 3};
        int[] array6 = {1, 2, 2};

        System.out.println("""
                           Los arrays 1 y 2 son iguales? %b
                           Los arrays 2 y 3 son iguales? %b
                           Los arrays 1 y 3 son iguales? %b
                           --------------------------------------------
                           Los arrays 4 y 5 son iguales? %b
                           Los arrays 5 y 6 son iguales? %b
                           Los arrays 4 y 6 son iguales? %b
                           """.formatted(
                Arrays.equals(array1, array2),
                Arrays.equals(array2, array3),
                Arrays.equals(array1, array3),
                Arrays.equals(array4, array5),
                Arrays.equals(array5, array6),
                Arrays.equals(array4, array6)
        ));

        System.out.println("""
                           Los arrays 1 y 2 son iguales? %b
                           Los arrays 2 y 3 son iguales? %b
                           Los arrays 1 y 3 son iguales? %b
                           --------------------------------------------
                           Los arrays 4 y 5 son iguales? %b
                           Los arrays 5 y 6 son iguales? %b
                           Los arrays 4 y 6 son iguales? %b
                           """.formatted(
                compararArray(array1, array2),
                compararArray(array2, array3),
                compararArray(array1, array3),
                compararArray(array4, array5),
                compararArray(array5, array6),
                compararArray(array4, array6)
        ));

    }

    public static boolean compararArray(int[] array1, int[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
