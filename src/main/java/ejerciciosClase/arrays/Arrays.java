/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import javax.swing.JOptionPane;

/**
 *
 * @author eli
 */
public class Arrays {
    public static void main(String[] args) {
        // Inicialización con valores
        int [] numeros = {1,2,3,4,5,6,7,8,9,10,11,12};
        
        System.out.println("""
                           El elemento 6 tiene %d con indice 5
                           """.formatted(numeros[5]));
        
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            System.out.println(numero);
            
        }
        
        for (int num : numeros) {
            System.out.println(num); 
        }
        
        // cambiar valor
        numeros [5] =90;
        
        // Ejercicio 1
        
        /*Escribe un programa que muestre cada elemento de un array de enteros y sume todos sus elementos. 
        Instancia e inicializa el array en el programa, sin leer nada por teclado, con los siguientes valores {1, 2, 3, 4, 5, 6}.*/
        int [] num = {1,2,3,4,5,6};
        int aux=0;
        for (int i = 0 ; i < num.length; i++) {
            int x = num[i];
            System.out.println(x);
            aux+=x;
        }
        System.out.println(aux);
        
        int aux2=0;
        for (int i : num) {
            System.out.println(i);
            aux2+=i;
        }
        
        System.out.println(aux2);
        
        // Ejercicio 2
        /*Escribe un programa para leer la altura de un número determinado de personas y calcular la altura media. 
        El número de personas se pide por teclado y debe ser entero un entero mayor que cero. 
        Posteriormente el programa irá pidiendo la altura, en cm, de cada una de las personas y las guardará 
        en una estructura de almacenamiento. Si la altura leída no es positiva, el programa la pasará a número positivo. 
        También es necesario saber cuántas personas tienen una altura superior a la media e inferior a la media. */
        
        
        int numPersonas=Math.abs(Integer.parseInt(JOptionPane.showInputDialog("Cuantas personas quieres calcular la altura media")));
        int [] alturas= new int [numPersonas];
        for (int i = 0; i < numPersonas; i++) {
            int altura=0;
            do {
                try {
                    altura = Integer.parseInt(JOptionPane.showInputDialog("Dame tu altura en cm"));
                    if (altura < 0) {
                    throw new Exception();
                    }
                    alturas[i]=altura;  
                } catch (Exception e) {
                    System.out.println("El dato debe ser un número entero y positivo");
                }                
            } while (altura<=0);            
            
        }
        
        double alturaMedia=0;
        for (int altura : alturas) {
            alturaMedia+=altura;
        }
        
        alturaMedia/=(double)numPersonas;
        System.out.println(alturaMedia);
        int superiorMedia=porEncimaMedia(alturas, alturaMedia);
        int inferiorMedia=Math.abs(superiorMedia - numPersonas);
        int [] arraysupinf=media(alturas, alturaMedia);
        int superior=arraysupinf[0];
        int inferior= arraysupinf[1];
        
        /*for (int altura : alturas ) {
            if(altura<alturaMedia) {
            inferiorMedia++;
            } else if (altura>alturaMedia) {
            superiorMedia+=1;
            }
        }*/
        
        System.out.println("""
                           Media de altura %.2f
                           Personas superior a la media %d
                           Personas inferior a la media %d
                           """.formatted(alturaMedia, inferiorMedia, superiorMedia));
        
        System.out.println(superior + "" + inferior);
    }
    
    public static int porEncimaMedia(int [] alturasPersonas, double alturaMedia) {
        int porEncima=0;
        for (int altura : alturasPersonas) {
            if (altura>alturaMedia) {
            porEncima++;
            }
        }
    return porEncima;
    };
    
    public static int [] media(int[] alturaPersonas, double alturaMedia) {
    int [] porEncimaPorDebajo = new int [2];
        for (int altura : alturaPersonas) {
            if(altura>alturaMedia) {
            porEncimaPorDebajo[0]++;
            } else if (altura<alturaMedia) {
            porEncimaPorDebajo[1]++;
            }
        }
        return porEncimaPorDebajo;
    }
    
    // ejercicio 5
    /*
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
    
    
}
