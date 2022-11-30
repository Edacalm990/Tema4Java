/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafetera;

/**
 *
 * @author eli
 */
/*Añade una clase Persona, con los atributos típicos de edad y nombre, constructor, getters, setters, toString. 
Añade dos métodos, el método hacerCafe(Cafetera c) que rellena la cafetera c de café y 
el método beberCafé(Cafetera c, int cantidad), que supone disminuir la cantidad de café indicada de la cafetera c.
Añade un método main() y realiza pruebas de la clase Cafetera y la clase Persona.*/
public class Persona {
    private int edad;
    private String nombre;

    public Persona() {
    }

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "edad=" + edad + ", nombre=" + nombre + '}';
    }
    
    public void hacerCafe (Cafetera cafetera) {
    cafetera.llenarCafetera();
    }
    
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
