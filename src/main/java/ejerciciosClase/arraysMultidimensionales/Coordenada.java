/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

/**
 *
 * @author eli
 */
public class Coordenada {

    private int[] cordenada;

    public Coordenada(int[][] matriz) {
        this.cordenada = obtenerCoordenada(matriz);
    }

    public int[] getCordenada() {
        return cordenada;
    }

    public void setCordenada(int[][] matriz) {
        this.cordenada = obtenerCoordenada(matriz);
    }

    @Override
    public String toString() {
        return """
               Coordenada: 
                    Fila: %d
                    Columna: %d
               """.formatted(cordenada[0], cordenada[1]);
    }

    private int[] obtenerCoordenada(int[][] matriz) {
        if (matriz != null) {
            int[] coordenada = new int[2];
            for (int fila = 0; fila < matriz.length; fila++) {
                int[] mayorFila = mayorFila(matriz[fila]);
                boolean resultado = esMenorColumna(fila, mayorFila, matriz);
                if (resultado) {
                    coordenada[0] = fila;
                    coordenada[1] = mayorFila[0];
                    return coordenada;
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean esMenorColumna(int fila, int[] mayorFila, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][mayorFila[0]] <= mayorFila[1] && i != fila) {
                return false;
            }
        }
        return true;
    }

    private int[] mayorFila(int[] fila) {
        int[] mayor = new int[2];
        for (int i = 0; i < fila.length; i++) {
            if (fila[i] > mayor[1]) {
                mayor[0] = i;
                mayor[1] = fila[i];
            }
        }
        return mayor;
    }

}
