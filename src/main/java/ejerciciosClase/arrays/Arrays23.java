/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author eli
 */
/*
Se desea manejar dos listas (ArrayList) de Integer. 
La cantidad de elementos de la lista 1 debe ser un número aleatorio entre 5 y 15. 
La cantidad de elementos de la lista 2 debe ser un número aleatorio entre 10 y 20. 
El rango de los números que serán agregados a la lista DEBE estar entre 50 y 100. 
Se pide construir una aplicación en Java que permita cumplir con la siguiente funcionalidad:
Imprimir las listas que han sido generadas. Usa for-each.
Crear una tercera lista que contenga los elementos que están en la lista 1 y NO ESTÁN en la lista 2 
Imprimir la tercera lista. 
Crear una cuarta lista que contenga los elementos de la lista 1 que son pares y los elementos de la lista 2 que son impares 
Imprimir la cuarta lista. Usa una expresión lambda.
*/
public class Arrays23 {
    public static Random random = new Random();
    public static void main(String[] args) {
        
        ArrayList<Integer> listaUno = new ArrayList<>(random.nextInt(5, 16));
        ArrayList<Integer> listaDos = new ArrayList<>(random.nextInt(10, 21));
        
        listaUno.forEach(e->listaUno.set(e, random.nextInt(10)));
        
        
    }
}
