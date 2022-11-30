/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafetera;

/**
 *
 * @author eli
 */
public class Main {
    public static void main(String[] args) {
        // probando tipos de cafeteras y comprobando si funcionan las restricciones
        Cafetera uno=new Cafetera();
        Cafetera dos=new Cafetera(500);
        Cafetera tres= new Cafetera (450, 200);
        Cafetera cuatroDesbordada = new Cafetera (500, 750);
        Cafetera cincoNegativo=new Cafetera ((-500), 750);
        
        // mostrando resultado
        System.out.println(uno.toString());
        System.out.println(dos.toString());
        System.out.println(tres.toString());
        System.out.println(cuatroDesbordada.toString());
        System.out.println(cincoNegativo.toString());
        
        Persona uno=new Persona(87, "Pepe");
        
    }
}
