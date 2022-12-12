/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.series;

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
        Serie simpson = ServicioSerie.leerTecladoSerie();
        Serie copiaSimpson = ServicioSerie.copia(simpson);
        System.out.println("Los ismpson son iguales a peaky blinders?" + peakeBlinders.equals(simpson));
        System.out.println("Los ismpson son iguales a copiaSimpson?" + simpson.equals(copiaSimpson));
        
    }
}
