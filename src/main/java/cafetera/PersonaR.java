/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package cafetera;

/**
 *
 * @author eli
 */
public record PersonaR(String nombre, int edad) {
    // llenar cafetera    
    public void hacerCafe (Cafetera cafetera) {
    cafetera.llenarCafetera();
    }
    // beber café
    public void beberCafe(Cafetera cafetera, int cantidad) {
    cafetera.servirTaza(cantidad);
    }
}
