/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

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
        CalculosCuenta.retirarEfectivo(cliente1, 200);
        
        System.out.println(cliente1);
        
        CalculosCuenta.ingresarDinero(cliente2, 600);
        CalculosCuenta.ingresarIntereses(cliente2);
        CalculosCuenta.retirarEfectivo(cliente2, 500000);
        
        System.out.println(cliente2);
        
    }
}
