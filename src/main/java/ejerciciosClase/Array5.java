/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

import javax.swing.JOptionPane;

/**
 *
 * @author eli
 */
/*
    // ejercicio 5
    
    Implementa un programa que guarde en un array 10 números enteros que se leen por teclado. 
    A continuación se recorre el array y calcula el número total de positivos, de negativos y de ceros. 
    Calcula y muestra la media aritmética de los valores positivos y la de los valores negativos del array.
    Implementar métodos para:
        Leer valores por teclado y almacenarlos en el array. Se le pasará el array como parámetro y no devolverá nada.
        Contar positivos, se le pasará el array como parámetro y devolverá el número de positivos almacenados en el array. 
        Contar negativos, se le pasará el array como parámetro y devolverá el número de negativos almacenados en el array. 
        Contar ceros, se le pasará el array como parámetro y devolverá el número de ceros almacenados en el array. 
        Mostrar array, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla el array.
        Calcular media positivos, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla la media aritmética de los positivos.
        Calcular media negativos, se le pasará el array como parámetro y no devolverá nada, sólo imprimirá por pantalla la media aritmética de los negativos.
    
 */
public class Array5 {

    public static void main(String[] args) {
        int[] array = new int[10];
        addNumero(array);
        int numPositivos=numPositivos(array);
        int numNegativos=numNegativos(array);
        int ceros=ceros(array);
        mostrarArray(array);
        mediaPositivos(array);
        mediaNegativos(array);
        
    }

    public static void addNumero(int[] array) {
        int numero = 0;
        JOptionPane.showMessageDialog(null, "Te voy a pedir 10 números");
        for (int i = 0; i < array.length; i++) {

            do {
                try {
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Dame un número"));
                    array[i] = numero;
                    JOptionPane.showMessageDialog(null, """
                                                        Llevas %d  numeros
                                                        """.formatted(i+1));
                } catch (Exception e) {
                    System.out.println("Debe ser un número entero");
                }

            } while (array.length!=10);
        }
    }
    
    public static int numPositivos(int [] array){
    int positivos=0;
        for (int numero : array) {
            if (numero>0) {
            positivos++;
            }
        }
    return positivos;
    }
    
    public static int numNegativos ( int[] array) {
    int negativos=0;
        for (int numero : array) {
            if(numero>0) {
            negativos++;
            }
        }
    return negativos;
    }
    
    public static int ceros (int [] array){
    int ceros=0;
        for (int numero : array) {
            if(numero==0){
            ceros++;
            }
        }
    return ceros;
    }
    
    public static void mostrarArray ( int [] array) {
        int c=0;
        for (int numero : array) {
            System.out.println("""
                               La posicion %d es el numero %d
                               """.formatted(c, numero));
            c++;
        }
    }
    
    public static void mediaPositivos(int [] array){
        int sumNumeros=0;
        int contador=0;
        for (int numero : array) {
            if(numero>0){
                contador++;
                sumNumeros+=numero;
            }
        }
        double resultado = sumNumeros/(double)contador;
        System.out.println("""
                           Hay %d de positivos y la media es de %.2f
                           """.formatted(contador, resultado));
    }
    
    public static void mediaNegativos(int [] array){
        int sumNumeros=0;
        int contador=0;
        for (int numero : array) {
            if(numero<0){
                contador++;
                sumNumeros+=numero;
            }
        }
        double resultado = sumNumeros/(double)contador;
        System.out.println("""
                           Hay %d de negativos y la media es de %.2f
                           """.formatted(contador, resultado));
    }
    
    
}
