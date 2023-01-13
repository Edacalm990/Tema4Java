/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

import java.util.Random;

/**
 *
 * @author eli
 */
/*
Escribe un programa que dada una matriz de 3x3 enteros y realice las siguientes funciones:

Rellenar aleatoriamente todas las casillas de la matriz con números enteros entre 1 y 100
Calcular la media de todos los valores
Calcular el valor mínimo y el máximo de todos los valores

 */
public class ejercicio14 {

    public static Random random = new Random();

    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        rellenarMatriz(matriz);
        System.out.println("-----------------MATRIZ-----------------");
        imprimirMatriz(matriz);
        System.out.println("-----------------MEDIA MATRIZ-----------------");
        System.out.println(mediaMatriz(matriz));

        int[] minMax = minMaxMatriz(matriz);
        System.out.println("""
                           -----------------MÍNIMO Y MÁXIMO DE LA MATRIZ-----------------
                           El mínimo es %d
                           El máximo es %d
                           """.formatted(minMax[0], minMax[1]));
    }

    public static int[] minMaxMatriz(int[][] matriz) {
        int[] minMax = new int[2];
        int[] posicionMin = new int[2];
        int[] posicionMax = new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == 0 && j == 0) {
                    minMax[0] = matriz[i][j];
                    
                }
                if (matriz[i][j] < minMax[0]) {
                    minMax[0] = matriz[i][j];
                    posicionMin[0] = i;
                    posicionMin[1] = j;
                } else if (matriz[i][j] > minMax[1]) {
                    minMax[1] = matriz[i][j];
                    posicionMax[0] = i;
                    posicionMax[1] = j;
                }
            }

        }
        return minMax;
    }

    public static double mediaMatriz(int[][] matriz) {
        double numero = 0;
        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                numero += matriz[i][j];
                contador++;
            }
        }
        return numero / contador;
    }

    public static void rellenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(0, 101);
            }
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int numero = matriz[i][j];
                System.out.println(numero);
            }
        }
    }
}
