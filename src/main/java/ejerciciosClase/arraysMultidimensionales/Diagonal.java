/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

import static ejerciciosClase.arraysMultidimensionales.Vecinas.imprimirMatriz;
import static ejerciciosClase.arraysMultidimensionales.Vecinas.pedirNumero;
import static ejerciciosClase.arraysMultidimensionales.Vecinas.random;
import static ejerciciosClase.arraysMultidimensionales.Vecinas.rellenarMatriz;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Diagonal {
    public static void main(String[] args) {
         int sizeMatriz= pedirNumero("", 3, 15);
        int [][] matriz= rellenarMatriz(new int [sizeMatriz][sizeMatriz]);
        System.out.println(imprimirMatriz(matriz));
        System.out.println("-------------Principal Arriba-Abajo-------------");
        recorrerDiagonalPrincipal(matriz);
        System.out.println("-------------Principal Abajo-Arriba-------------");
        recorrerDiagonalPrincipalAbajoArriba(matriz);
        System.out.println("-------------Secundaria Arriba-Abajo-------------");
        recorrerDiagonalSecundariaArribaAbajo(matriz);
        System.out.println("-------------Secundaria Abajo-Arriba-------------");
        recorrerDiagonalSecundariaAbajoArriba(matriz);
    }
    public static void recorrerDiagonalPrincipalAbajoArriba(int [][] matriz){
     int contador=matriz.length-1;
        for (int fila = matriz.length-1; fila >= 0; fila--) {
            for (int columna = contador; columna>=contador ; columna--) {
                System.out.println(matriz[fila][columna]);
                
            }
            contador--;
        }
    }
    
    
    public static void recorrerDiagonalSecundariaAbajoArriba(int [][] matriz){
         int contador=0;
        for (int fila = matriz.length-1; fila >= 0; fila--) {
            for (int columna = contador; columna<=contador ; columna++) {
                System.out.println(matriz[fila][columna]);
                
            }
            contador++;
        }
    }
    
    public static void recorrerDiagonalSecundariaArribaAbajo(int [][] matriz){
         int contador=matriz.length-1;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = contador; columna>=contador ; columna--) {
                System.out.println(matriz[fila][columna]);
                
            }
            contador--;
        }
    }
    
    public static void recorrerDiagonalPrincipal(int [][] matriz){
         int contador=0;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = contador; columna<=contador ; columna++) {
                System.out.println(matriz[fila][columna]);
                
            }
            contador++;
        }
    }
    
    public static void recorrerDiagonalPrincipalComoEnClase(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i][i]);
        }
    }
    
    public static void recorrerDiagonalSecundariaComoEnClaseArribaAbajo(int [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i][matriz.length-1-i]);
            
        }
    }
    
        // imprimir matriz
    public static String imprimirMatriz(int[][] matriz) {
        String tmp = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                tmp += "| " + matriz[i][j] + " |" + " ";

            }
            tmp += "\n";
        }
        return tmp;
    }
    
    
    public static int [][] rellenarMatriz (int [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]= random.nextInt(10);
            }
            
        }
    return matriz;
    }
    
    public static int pedirNumero(String palabra, int min, int max) {
        String mensaje = (palabra.equalsIgnoreCase("pedirNumero")
                ? """
                                           Dame un numero entre %d y %d
                                           """.formatted(min, max)
                : """
                                              Que tamaño tendrá la matriz ? 
                                              Dame un número entre %d y %d
                                              """.formatted(min, max));
        int num = 0;
        do {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                if (num < min || num > max) {
                    throw new Exception();
                }
                return num;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, """
                                                    Debe ser un numero positivo entre %d y %d
                                                    """.formatted(min, max));
            }
        } while (num < min || num >= max);
        return num;
    }
}
