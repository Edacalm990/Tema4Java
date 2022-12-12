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
public enum Nombres {
    PEPE, BLANCA, TATIANA, MARCO, LIA, ASUNCION;
    
    public static Nombres getAleatorio () {
        var r=new Random();
        Nombres [] nombres=Nombres.values();
        int posicion = r.nextInt(0, nombres.length);
        return nombres[posicion];
    }

}
