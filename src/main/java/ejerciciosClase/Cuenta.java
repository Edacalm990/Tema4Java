/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

/**
 *
 * @author elisabet
 */
/*
Atributos:
    - nº cuenta(20 digitos) (nº de cuenta aleatorio)
    - nif
    - nombre
    - saldo actual
    - interes % (entre 0.1 y 3)
Métodos:
    - Contructor por defecto (nº de cuenta aleatorio)
    - contructor parametrizado (nº de cuenta aleatorio)
    - Getter y Setter. No hay set para el número de cuenta.
    - TOSTRING




*/
public class Cuenta {
    public static Random random=new Random();
    
    private final String NUMEROCUENTA=numeroCuenta();
    private String nif;
    private String nombre;
    private double saldo;
    private double interes;

    public Cuenta() {
    }

    public Cuenta(String nif, String nombre, double saldo, double interes) {
        this.nif = nif;
        this.nombre = nombre;
        this.saldo = saldo;
        this.interes = (interes<0.1 || interes>3) ?0.1 :interes;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "NUMEROCUENTA=" + NUMEROCUENTA + ", nif=" + nif + ", nombre=" + nombre + ", saldo=" + saldo + ", interes=" + interes + '}';
    }
    
    private String numeroCuenta() {
    String numeroCuenta= RandomStringUtils.randomNumeric(20);   
    return numeroCuenta;
    }
    
    
    
}
