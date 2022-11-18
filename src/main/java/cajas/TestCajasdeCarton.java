/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajas;

/**
 * cajaGrande y cajaChica. Instancia los objetos anteriores con los siguientes
 * valores, usando el constructor y el operador new: cajaGrande: ancho 250mm,
 * alto 400mm, largo 500mm. Peso 200gr. cajaChica: ancho 25mm, alto 30mm, largo
 * 15mm. Peso 17gr. Muestra los datos de las cajas creadas usando métodos get.
 *
 * @author elisabet
 */
public class TestCajasdeCarton {

    public static void main(String[] args) {
        CajaCarton cajaGrande = new CajaCarton(250, 400, 500, 200);
        CajaCarton cajaChica = new CajaCarton(25, 30, 15, 17);

        
        System.out.println("""
                           Caja Grande
                           --------------------------------
                           Ancho -> %d mm
                           Alto -> %d mm
                           Largo -> %d mm
                           Peso -> %d grs
                           
                           """.formatted(cajaGrande.getAncho(), cajaGrande.getAlto(),
                cajaGrande.getLargo(), cajaGrande.getPeso()));
        
        System.out.println("""
                           Caja Pequeña
                           --------------------------------
                           Ancho -> %d mm 
                           Alto -> %d mm
                           Largo -> %d mm
                           Peso -> %d grs
                           """.formatted(cajaChica.getAncho(), cajaChica.getAlto(),
                cajaChica.getLargo(), cajaChica.getPeso()));
        
        System.out.println(cajaGrande.toString());
        System.out.println(cajaChica.toString());
       
    }
}
