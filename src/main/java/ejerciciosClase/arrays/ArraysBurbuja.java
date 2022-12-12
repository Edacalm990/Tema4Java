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
public class ArraysBurbuja {

    public static void main(String[] args) {
        int numeros[] = {6, 2, 8, 4, 1};
        System.out.println(Arrays.binarySearch(numeros, 8));
        
        ordenarBurbuja(numeros);
        System.out.println("""
                           La posicion esta en %s
                           """.formatted(
                                   (busquedaBurbuja(numeros, 54)!=-1)
                                           ? busquedaBurbuja(numeros, 54) 
                                           :"no se encuenta"));

        int posicionOrdenada = Arrays.binarySearch(numeros, 8);
        System.out.println(posicionOrdenada);
    }

    // ordenar array de - a +
    public static void ordenarBurbuja(int[] numeros) {
        int tem;
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] > numeros[j]) {
                    tem = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = tem;
                }
            }
        }
        for (int numero : numeros) {
            System.out.println(numero);

        }

    }
    
    // posicion en el array donde se encuentra el elemento
    // si hay varios devuelve la primera
    // si no exite devuelve -1
    public static int busquedaBurbuja (int[] numeros, int numeroBuscar) {
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            if (numero==numeroBuscar) {
            return i;
            }
        }
    return -1;
    };
    
    
    
}
