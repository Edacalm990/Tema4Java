/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import java.util.Scanner;

/**
 *
 * @author eli
 */
/*Realizar un programa que lea de la entrada un número y utilice ese número para crear un array de enteros de ese tamaño. 
A continuación, el programa inicializa el array con los valores que el usuario introduzca por teclado. 
Finalmente, se deberá recorrer el array e imprimir tantos caracteres ‘*’ como indique el valor de cada elemento del array. 
Ejemplo: los valores 5,4,3,2 producirán la siguiente salida:
*****
****
***
**
 */
public class Array8 {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int size = pedirNumero("Dame el tamaño del array");
        int [] array = new int [size];
        
        for (int i = 0; i < array.length; i++) {
            array[i]=pedirNumero(""); 
        }
        
        imprimirAsterisco(array);
        
    }

    public static int pedirNumero(String mensaje) {
        String texto = (mensaje.isBlank()) ? "Dame un número" : mensaje;
        int numero = -1;
        do {
            try {
                System.out.println(texto);
                numero = teclado.nextInt();
                if (numero <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("El número debe ser un número entero y positivo mayor de 0");
                teclado.nextLine();
            }
        } while (numero <= 0);

        return numero;
    }
    
    public static void imprimirAsterisco(int [] array) {
        
        for (int numero : array) {
            StringBuilder cadena = new StringBuilder();
            for (int i = 0; i < numero; i++) {
                cadena.append("*");
            }
            System.out.println(cadena);
        }
        
    }

}
