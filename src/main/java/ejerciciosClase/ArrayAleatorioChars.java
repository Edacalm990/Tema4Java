/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

import static ejerciciosClase.Capicua.teclado;
import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author eli
 */
// ejercicio 2
// Rellenar array char desde "A-Z"
// Generar un tamaño aleatorio entre 15 y 25
// Crear un array de ese tamaño y rellenarlo con posiciones válidas aleatorias
public class ArrayAleatorioChars {

    public static Random random = new Random();

    public static void main(String[] args) {
        String  [] prueba = generarString(pedirNumero());
        System.out.println(Arrays.toString(prueba));

    }

    public static String[] generarString(int numeroStrings) {
        int longitud = 'Z'-'A';
        char [] valores = new char [longitud];
        int contador=0;
        /*
        char [] valores = new char [26];
        for (int i = 65; i < 90; i++) {
            valores[contador]= (char)i;
            contador ++;
        }
        */
        
        for (int i='A'; i< 'Z'; i++) {
            valores[contador]= (char)i;
            contador ++;
        }
       
        String [] array = new String[numeroStrings];

        for (int i = 0; i < numeroStrings; i++) {
            String palabra = "";
            
            int numAleatorio=random.nextInt(15, 26);
            int [] aleatorio = new int [numAleatorio];     
            
            
            for (int y=0; y< numAleatorio; y++) {
                aleatorio[y] = random.nextInt(valores.length-1);
            }

            for (int x: aleatorio) {
                palabra += valores[x];   
            }
            
            array[i]=palabra;
        }

        return array;

    }
    
     public static int pedirNumero() {
        int numero = -1;
        do {
            try {
                System.out.println("Dame un número");
                numero = teclado.nextInt();
                if (numero <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Debe ser un número enteo positivo mayor de 0");
                teclado.nextLine();
            }
        } while (numero <= 0);
        return numero;
    }
}
