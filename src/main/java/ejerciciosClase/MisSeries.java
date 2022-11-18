/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

/**
 *
 * @author elisabet
 */
public class MisSeries {
    
    
    
    public static void main(String[] args) {
        
        
        // crear un objeto serie leyendo los datos por teclado
        Serie peakeBlinders = ServicioSerie.leerTecladoSerie();
        System.out.println(peakeBlinders);
        ServicioSerie.darLike(peakeBlinders);
        
    }
}
