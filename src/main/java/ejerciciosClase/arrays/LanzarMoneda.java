/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import java.util.Random;

/**
 *
 * @author eli
 */
/*
Escribe una clase LanzarMoneda que tenga como único atributo un array de booleanos de tamaño 1000. 
La clase tendrá los siguientes métodos: 
un método para rellenar el array, de forma que simule 1000 lanzamientos de una moneda. 
El método debe almacenar el resultado de cada tirada en el array. 
un método para saber cuántas “caras” salieron después de los lanzamientos.
un método para saber cuántas “cruces” salieron después de los lanzamientos.
un método para imprimir el resultado de los 1000 lanzamientos, 
de forma que aparezca el número de lanzamiento y el resultado (cara o cruz)

 */
public class LanzarMoneda {
    Random random = new Random();

    private boolean [] lanzarMoneda;

    public LanzarMoneda() {
        this.lanzarMoneda = new boolean [1000];
        rellenarArray();
    }

    private void rellenarArray() {
        for (int tirada = 0; tirada < lanzarMoneda.length; tirada++) {
            almacenarNumero(random.nextBoolean(), tirada);
        }
    }
    
    private void almacenarNumero(boolean resultado, int posicion){
    lanzarMoneda[posicion] = resultado;
    }
    
    public int numerCaras(){
        int resultado=0;
        for (int i = 0; i < lanzarMoneda.length; i++) {
            if(lanzarMoneda[i]){
            resultado++;
            }
        }
        return resultado;
    }
    
    public int numCruz(){
    int numCaras = numerCaras();
    return this.lanzarMoneda.length-numCaras;
    }
    
    public void imprimirResultado(){
        for (int i = 0; i < lanzarMoneda.length; i++) {
            boolean b = lanzarMoneda[i];
            System.out.println("""
                               Tirada: %d - Resultado: %s
                               """.formatted(i, (b) ?"cara" :"cruz"));
            
        }
       
    }
}
