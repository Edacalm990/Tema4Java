/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author eli
 */
/*
Sube un proyecto llamado ej5e+tunombre, con un paquete llamado daw, que incluya las clases necesarias 
para resolver los siguientes ejercicios. En ambos ejercicios se entiende por "matriz" un array de dos dimensiones.
EJERCICIO A.- Mayor fila menor columna

Implementar un programa que permita encontrar el elemento mayor de una fila y menor de una columna 
de un array de N filas x N columnas números enteros. Para ello, el programa tendrá varias opciones: 

    a) El programa solicitará al usuario el número N (entre 3 y 6) y creará una matriz con los números 
que introduzca el usuario por teclado.
    b) El programa solicitará al usuario el número N (entre 3 y 6) y creará una matriz con los números 
aleatorios entre 0 y 20.

Una vez creada la matriz con los datos, ésta se pasará a un método que se encargará de devolver la 
Coordenada (clase que debes crear) del número que es mayor o igual a todos los de su fila y menor o igual 
a todos los de su columna, si existe. Si no existe indicará la coordenada (-1 , -1).
Se debe imprimir por consola la matriz creada en a) o b) y la coordenada generada, para comprobar que el 
resultado obtenido es correcto.
Por ejemplo, en la siguiente matriz de 3X3, la coordenada a devolver sería fila 2 columna 0.

10  9  8
9   10 11
8    8   5
 */
public class Ejercicio5E_A {

    public static Random random = new Random();

    public static void main(String[] args) {
        final int ORIGEN_ALEATORIO = 0;
        final int FIN_ALEATORIO = 20;
        final int SIZE_MIN = 3;
        final int SIZE_MAX = 6;

        int opcion = pedirOpcion();
        int[][] matriz = (opcion == 0)
                ? matrizParametrizada(SIZE_MIN, SIZE_MAX)
                : matrizAleatorio(SIZE_MIN, SIZE_MAX, ORIGEN_ALEATORIO, FIN_ALEATORIO);

        imprimirMatriz(matriz);

        for (int fila = 0; fila < matriz.length; fila++) {
            int[] mayorFila = mayorFila(matriz[fila]);
            System.out.println("""
                               mayorFila %s
                               """.formatted(mayorFila[1]));
            boolean resultado = esMenorColumna(mayorFila, matriz);
            System.out.println(resultado);

        }

    }

    public static boolean esMenorColumna(int[] mayorFila, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][mayorFila[0]]>=mayorFila[1] && i!=mayorFila[0]) {
            return false;
            }
                
        }
        return true;
    }

    public static int[] mayorFila(int[] fila) {
        int[] mayor = new int[2];
        for (int i = 0; i < fila.length; i++) {
            if (fila[i] >= mayor[1]) {
                mayor[0] = i;
                mayor[1] = fila[i];
            }
        }
        return mayor;
    }

    public static int pedirOpcion() {
        int numero = -1;
        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                      ELIJE UNA OPCIÓN
                                                                      0 - Crear matriz Parametrizada
                                                                      1 - Cear matriz Aleatoria
                                                                      """));
                if (numero != 0 && numero != 1) {
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debes elegir una opción del menú, 0 o 1");
            }
        } while (numero != 0 && numero != 1);
        return numero;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println("");
        }
    }

    public static int[][] crearMatriz(String mensaje, int min, int max) {
        int numero = pedirNumero(mensaje, min, max);
        int[][] matriz = new int[numero][numero];
        return matriz;
    }

    public static int[][] matrizParametrizada(int min, int max) {
        int[][] matriz = crearMatriz("", min, max);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = pedirNumero("pedirNumero", 0, 999999999);

            }

        }
        return matriz;
    }

    public static int[][] matrizAleatorio(int min, int max, int inicioAleatorio, int finAleatorio) {
        int[][] matriz = crearMatriz("", min, max);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(inicioAleatorio, finAleatorio + 1);
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
                if (num < min || num >= max) {
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
