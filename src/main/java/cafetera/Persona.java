/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafetera;

/**
 *
 * @author eli
 */
// contructor persona
public class Persona {
    // atributos encapsulados
    private int edad;
    private String nombre;

    // constructor por defecto
    public Persona() {
    }

    // contructor parametrizado
    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }
    
    // getters

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    // toString

    @Override
    public String toString() {
        return "Persona{" + "edad=" + edad + ", nombre=" + nombre + '}';
    }
    
    // métodos pedidos en el ejercicio
    // llenar cafetera    
    public void hacerCafe (Cafetera cafetera) {
    cafetera.llenarCafetera();
    }
    // beber café
    public void beberCafe(Cafetera cafetera, int cantidad) {
    cafetera.servirTaza(cantidad);
    }
    
    // dos métodos extra fuera del ejercicio
    public void tirarCafe(Cafetera cafetera) { 
    cafetera.vaciarCafetera(); 
    }
    
    public void addCafe (Cafetera cafetera, double cantidadAgregar) {
    cafetera.agregarCafe(cantidadAgregar);
    }
}
