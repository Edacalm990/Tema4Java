/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package rentacarListas;

import java.util.Random;

/**
 *
 * @author eli
 */
public enum ColorVehiculo {
    ROJO, NEGRO, AMARILLO, VERDE, AZUL, BLANCO;
    
    // método para poner de forma aleatoria un color
    public static ColorVehiculo getAleatorio () {
        var r=new Random();
        ColorVehiculo [] colores=ColorVehiculo.values();
        int posicion = r.nextInt(0, colores.length);
        return colores[posicion];
    }
}
