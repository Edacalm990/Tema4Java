/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

/**
 *
 * @author eli
 */
public class Test {
    public static void main(String[] args) {
        EstadoAnimal estadoPerro = EstadoAnimal.COMIENDO;
        System.out.println("""
                           Estado perro tiene de codigo %d
                           Y tiene el estado "%s"
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           """.formatted(estadoPerro.getCodigoEstado(), estadoPerro.getEstado()));
    }
}
