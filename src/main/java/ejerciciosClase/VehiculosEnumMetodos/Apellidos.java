/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import java.util.Random;

/**
 *
 * @author eli
 */
public enum Apellidos {
    MARTINEZ, FERNANDEZ, CASTAÑO, SAMPALO, ALMIRON;
    
    public static Apellidos getAleatorio () {
        var r=new Random();
        Apellidos [] apellido=Apellidos.values();
        int posicion = r.nextInt(0, apellido.length);
        return apellido[posicion];
    }
}

