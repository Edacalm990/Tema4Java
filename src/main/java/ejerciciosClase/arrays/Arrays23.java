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
    public static final int MIN_UNO = 5;
    public static final int MAX_UNO = 15;
    public static final int MIN_DOS = 10;
    public static final int MAX_DOS = 20;
    public static final int MIN_RANGO = 50;
    public static final int MAX_RANGO = 100;

    public static void main(String[] args) {

        ArrayList<Integer> listaUno = new ArrayList<>();
        ArrayList<Integer> listaDos = new ArrayList<>();
        ArrayList<Integer> listaTres = new ArrayList<>();
        ArrayList<Integer> listaCuatro = new ArrayList<>();

        addNumeros(MIN_RANGO, MAX_RANGO, listaUno, MIN_UNO, MAX_UNO);
        addNumeros(MIN_RANGO, MAX_RANGO, listaDos, MIN_DOS, MAX_DOS);

        mostrarLista(listaUno, "------------ LISTA UNO ------------");
        mostrarLista(listaDos, "------------ LISTA DOS ------------");

        listaNumDif(listaUno, listaDos, listaTres);
        mostrarLista(listaTres, "------------ LISTA TRES ------------");

        listaParesImpares(listaUno, listaDos, listaCuatro);
        mostrarLista(listaCuatro, "------------ LISTA CUATRO ------------");

    }

    public static void addNumeros(int origen, int fin, ArrayList array, int sizeMin, int sizeMax) {
        for (int i = 0; i < random.nextInt(sizeMin, sizeMax + 1); i++) {
            array.add(random.nextInt(origen, fin + 1));
        }
    }

    public static void mostrarLista(ArrayList array, String texto) {
        System.out.println(texto);
        array.forEach(System.out::println);
        System.out.println("-----------------------------------");
    }

    public static void listaNumDif(ArrayList<Integer> listaUno, ArrayList<Integer> listaDos, ArrayList<Integer> listaTres) {
        for (int i = 0; i < listaUno.size(); i++) {
            if (!listaDos.contains(listaUno.get(i))) {
                listaTres.add(listaUno.get(i));
            }

        }
//        for (Integer numero : listaUno) {
//            if (!listaDos.contains(numero)) {
//                listaTres.add(numero);
//            }
//        }
    }

    public static void listaParesImpares(ArrayList<Integer> listaUno, ArrayList<Integer> listaDos, ArrayList<Integer> resultado) {
        for (int i = 0; i < listaUno.size(); i++) {
            int numero = Integer.parseInt(listaUno.get(i).toString());
            if (numero % 2 == 0) {
                resultado.add(listaUno.get(i));
            }
        }
        for (Integer num : listaDos) {
            if (num % 2 != 0) {
                resultado.add(num);
            }
        }
    }

}
