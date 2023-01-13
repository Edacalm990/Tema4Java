/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

/**
 *
 * @author eli
 */
/*
Declara e inicializa una matriz de caracteres de 2x3, con los valores que tú quieras. Implementa un método, 
en la misma clase que el método main(), que reciba una matriz de caracteres y la imprima por consola.
 */
public class ejercicio12 {

    public static void main(String[] args) {
        char[][] matrizUno = {{'a', 'b', 'c'}, 
                                          {'d', 'e', 'f'}};
        
        char[][] matrizDos = new char[2][3];
        matrizDos[0][0]='a';
        matrizDos[0][1]='b';
        matrizDos[0][2]='c';
        matrizDos[1][0]='d';
        matrizDos[1][1]='e';
        matrizDos[1][2]='f';
        
        char[][] matrizTres;
        matrizTres=new char [2][];
        matrizTres[0]=new char[3];
        matrizTres[0][0]='a';
        matrizTres[0][1]='b';
        matrizTres[0][2]='c';
        matrizTres[1]= new char [] {'d','e','f'};
        
        System.out.println("Las tres matrices son iguales, pero creadas de forma diferente");
        System.out.println("--- MATRIZ UNO ---");
        imprimirMatriz(matrizUno);
        System.out.println("--- MATRIZ DOS ---");
        imprimirMatriz(matrizDos);
        System.out.println("--- MATRIZ TRES ---");
        imprimirMatriz(matrizTres);
        
    }

    public static void imprimirMatriz(char [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                char letra= matriz[i][j];
                System.out.print(letra+" ");
                
            }
            System.out.println("");
        }
    }
}
