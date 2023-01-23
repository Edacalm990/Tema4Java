/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author eli
 */
public class Vecinas {
    public static Random random = new Random();
    Point coordenada = new Point();
    
    public static void main(String[] args) {
        int sizeMatriz= pedirNumero("", 3, 15);
        int [][] matriz= rellenarMatriz(new int [sizeMatriz][sizeMatriz]);
        System.out.println(imprimirMatriz(matriz));
        int [] coordenada = {1,1};
        obtenerVecinas(coordenada, matriz);
    }
    
    public static void obtenerVecinas(int [] coordenada, int [][] matriz){
        ArrayList vecinas = new ArrayList();
        if (coordenada[0]<=matriz.length && coordenada[1] <= matriz[0].length){
            String coordenadaA= (coordenada[0]<=0 && coordenada[1]<=0) 
                    ? "no hay"
                    : String.valueOf(matriz[coordenada[0]-1][coordenada[1]-1]);
            System.out.println(coordenadaA);
            
            
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
