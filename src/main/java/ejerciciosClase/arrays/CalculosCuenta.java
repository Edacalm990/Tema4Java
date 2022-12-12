/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import ejerciciosClase.Cuenta;

/**
 *
 * @author elisabet
 */
/*
Clase CalculosCuenta:
Métodos:
    - ingresarIntereses(Cuenta cuenta): Aumento ek saldo de la cuenta 
        - saldo= saldo+saldo*interes
    - ingresarDinero(Cuenta cuenta, double cantidad). Añadir dinero al saldo de la cuenta
    - retirarEfectivo(Cuenta cuenta, double cantidad, double saldo). Restar dinero al saldo de la cuenta (tener en cuenta el máximo)

*/
public class CalculosCuenta {
    public static void ingresarIntereses(Cuenta cuenta) {
        double saldoNuevo=cuenta.getSaldo()+(cuenta.getSaldo()*cuenta.getInteres());
        cuenta.setSaldo(saldoNuevo);
    }
    // paso por referencia
    public static void ingresarDinero(Cuenta cuenta, double cantidad) {
        double cantidadPositiva= Math.abs(cantidad);
        cuenta.setSaldo(cuenta.getSaldo()+cantidadPositiva);
    }
    
    public static boolean retirarEfectivo(Cuenta cuenta, double cantidad) {
        if (cuenta.getSaldo()>=cantidad){  
        cuenta.setSaldo(cuenta.getSaldo()-cantidad);
        return true;
        } else {
        return false;
        }
    }
}
