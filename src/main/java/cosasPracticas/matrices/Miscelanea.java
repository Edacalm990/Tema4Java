/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosasPracticas.matrices;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author eli
 */
public class Miscelanea {

    public static Random random = new Random();

    public static void main(String[] args) {
        int [][] matriz = new int [4][4];
        rellenarMatrizNumAleatorio(matriz, 0, 9);
        imprimirMatrizForEach(matriz);
        List<Casilla> casillasVecinas = casillasVecinas(2, 2, matriz);
        for (int i = 0; i < casillasVecinas.size(); i++) {
            Casilla get = casillasVecinas.get(i);
            System.out.println(get.valor());
        }
    }

    public static int[][] rellenarMatrizNumAleatorio(int[][] matriz, int min, int max) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(min, max + 1);
            }

        }
        return matriz;
    }

    public static void imprimirMatrizForEach(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print("| " + valor + " | ");
            }
            System.out.println("");
        }
    }

    public static String imprimirMatrizFor(int[][] matriz) {
        String tmp = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                tmp += "| " + matriz[i][j] + " |" + " ";

            }
            tmp += "\n";
        }
        return tmp;
    }

    public static List<Integer> elementosDiagonalPrincipal(int[][] matriz) {
        List<Integer> lista = new ArrayList();
        for (int i = 0; i < matriz.length; i++) {
            lista.add(matriz[i][i]);
        }
        return lista;
    }
    
    public static int[] elementosDiagonalSecundaria(int[][] matriz) {
        int[] array = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            array[i] = matriz[i][matriz.length - 1 - i];
        }
        return array;
    }
    
    // Array.toString(array)
    
    public static List<Casilla> casillasVecinas (int fila, int columna, int [][] matriz) {
        List<Casilla> lista = new ArrayList<>();
        // comprobamos fila columna
        if (filaValida(fila, matriz) && columnaValida(columna, matriz)){
            
            for (int i = fila-1; i <= fila+1; i++) {
                for (int j = columna-1; j <=columna+1; j++) {
                    if (filaValida(i, matriz)
                            && columnaValida(j, matriz)
                            && (fila!=i || columna!=j)) {
                        Casilla casilla = new Casilla(i, j, matriz[i][j]);
                        lista.add(casilla);
                    }
                }
            }
        }
        return lista;
    }
    
    public static boolean filaValida(int fila, int [][] matriz) {
        return fila>=0&&fila<matriz.length;
    }
    
    public static boolean columnaValida(int columna, int [][] matriz) {
        return columna>=0&&columna<matriz.length;
    }
}

// numero, asiento, identificador, reservado o libre