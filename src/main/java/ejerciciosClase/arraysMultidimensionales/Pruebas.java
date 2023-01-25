/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eli
 */
public class Pruebas {

    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        matriz[0] = new int[]{1, 2, 3};
        matriz[1] = new int[]{4, 5, 6};
        matriz[2] = new int[]{7, 8, 9};

        int fila = -1;
        int[] coordenada = new int[]{0,2};
        ArrayList<Integer> resultado = new ArrayList<>();
        int columna = -1;
        do {
            if (coordenada[0] + fila >= 0 && fila+coordenada[0]<matriz.length) {
                for (int i = coordenada[0] + fila; fila < 2 && fila+coordenada[0]<matriz.length; i++) {
                    
                    if (coordenada[1] + columna >= 0) {
                        for (int j = (columna + coordenada[1]); columna<= 1 && columna + coordenada[1]<matriz[0].length; ) {
                            
                            resultado.add(matriz[coordenada[0] + fila][coordenada[1] + columna]);
                            columna++;
                        }
                        fila++;
                        columna=-1;
                    } else {
                        resultado.add(-1);
                        columna++;
                    }
                }

            } else {
                resultado.add(-1);
                resultado.add(-1);
                resultado.add(-1);
                fila++;
                
            }
        } while (resultado.size() <=6);
        
        for (int i = 0; i < resultado.size(); i++) {
            Integer get = resultado.get(i);
            if (get!=-1){
                System.out.println(get);
            }
        }
    }
}
