/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

import ejerciciosClase.arrays.CalculosCuenta;

/**
 *
 * @author elisabet
 */
// Clase Main
// Creamos un par de objetos y probamos los métodos de Calculos Cuenta
public class Main {
    public static void main(String[] args) {
        Cuenta cliente1=new Cuenta("40451990g", "Pepe", 300,  2.3);
        Cuenta cliente2= new Cuenta("77458565l", "Maria", 100, -6);
        
        System.out.println(cliente1);
        System.out.println(cliente2);
        
        CalculosCuenta.ingresarDinero(cliente1, 500);
        CalculosCuenta.ingresarIntereses(cliente1);
        
        boolean comprobarOperacion=CalculosCuenta.retirarEfectivo(cliente1, 200);
        if (!comprobarOperacion){
           System.out.println("No se ha podido realizar la operación, saldo insuficiente");
        } else {
            System.out.println("""
                               El nuevo saldo de la cuenta es %.2f
                               """.formatted(cliente1.getSaldo()));
        }
        
        
        System.out.println(cliente1);
        
        CalculosCuenta.ingresarDinero(cliente2, 600);
        CalculosCuenta.ingresarIntereses(cliente2);
        
        if (!CalculosCuenta.retirarEfectivo(cliente2, 500000)){
            System.out.println("No se ha podido realizar la operación, saldo insuficiente");
        };
        
        System.out.println(cliente2);
        
    }
}
