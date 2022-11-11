/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

import java.util.Scanner;

/**
 *
 * @author elisabet
 */
public class MisVehiculos {
    public static void main(String[] args) {
        // Instancia de la clase Scanner, llamada teclado
        Scanner teclado = new Scanner(System.in);
        
        Vehiculos ferrari=new Vehiculos("8778fghb", "872626376", "ferrari", "murcielago", "rojo", 200, true);
        
        System.out.println(ferrari.toString());
        
        ferrari.setColor("verde");
        
        System.out.println(ferrari.toString());
        
    }
}
