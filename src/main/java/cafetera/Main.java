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
        Cafetera uno = new Cafetera(); // constructor vacio
        Cafetera dos = new Cafetera(500);
        Cafetera tres = new Cafetera(450, 200);
        Cafetera cuatroDesbordada = new Cafetera(500, 750);
        Cafetera cincoNegativo = new Cafetera((-500), 750);

        // mostrando resultado
        System.out.println("Constructor por defecto: cafetera uno");
        System.out.println(uno.toString());
        System.out.println("Constructor con parametro capacidad máxima: cafetera dos");
        System.out.println(dos.toString());
        System.out.println("Constructor con parametro capacidad máxima y cantidadActual: cafetera tres");
        System.out.println(tres.toString());
        System.out.println("Constructor con parametro capacidad máxima y cantidadActual mayor que capacidad máxima (probando que no lo permita): cafetera cuatroDesbordada");
        System.out.println(cuatroDesbordada.toString());
        System.out.println("Constructor con parametro capacidad máxima y cantidadActual mayor que capacidad máxima (probando que no lo permita)  y número negativo (lo convierta en positivo): cafetera cincoNegativo");
        System.out.println(cincoNegativo.toString());
        
        // pruebas dentro de los parametros sin persona
        uno.llenarCafetera();
        System.out.println("""
                           -------------------------------------------------------
                           Pruebas con clase cafetera sin persona
                           -------------------------------------------------------
                           Lleno cafetera uno. 
                                Capacidad Actual -> %.2f
                           
                           """.formatted(uno.getCantidadActual()));

        uno.servirTaza(500);
        System.out.println("""
                           Sirvo una taza de 500ml de la cafetera uno. 
                                Capacidad Actual -> %.2f
                           
                           """.formatted(uno.getCantidadActual()));

        uno.vaciarCafetera();
        System.out.println("""
                           Vacio la cafetera uno. 
                                Capacidad Actual -> %.2f
                           
                           """.formatted(uno.getCantidadActual()));

        uno.agregarCafe(200);
        System.out.println("""
                           Añado 200ml a la cafetera uno. 
                                Capacidad Actual -> %.2f
                           
                           """.formatted(uno.getCantidadActual()));


        // pruebas fuera de los parametros sin persona
        uno.servirTaza(10000);
        System.out.println("""
                           ---------------------------------------------------------------------------
                           Pruebas con clase cafetera sin persona intendando fallar
                           ---------------------------------------------------------------------------
                           Sirvo una taza de 10000ml de la cafetera uno. 
                                Capacidad Actual -> %.2f
                                Capacidad Máxima -> %.2f
                           -----------------------------------------
                           
                           """.formatted(uno.getCantidadActual(), uno.getCapacidadMaxima()));


        uno.agregarCafe(20000);
        System.out.println("""
                           Añado 20000ml a la cafetera uno. 
                                Capacidad Actual -> %.2f
                                Capacidad Máxima -> %.2f
                           -----------------------------------------
                           
                           """.formatted(uno.getCantidadActual(), uno.getCapacidadMaxima()));

        // creando persona
        Persona pUno = new Persona(87, "Pepe");

        // realizando pruebas usando persona
        // uno hace cafe
        pUno.hacerCafe(uno);
        // mostrando si cantidadActual ha cambiado
        System.out.println("Pepe hace café");
        System.out.println(uno.toString());

        // uno bebe café dentro de los parámetros establecidos
        pUno.beberCafe(uno, 300);
        // mostrando si cantidadActual ha cambiado
        System.out.println("Pepe se bebe 300ml de café");
        System.out.println(uno.toString());

        // uno bebe café fuera de los parámetros establecidos
        pUno.beberCafe(uno, 5000);
        // mostrando si cantidadActual ha cambiado
        System.out.println("Pepe intenta beber 5000ml de café pero la capacidad máxima es de 1000 por tanto se vacia la cafetera");
        System.out.println(uno.toString());

        pUno.addCafe(uno, 200);
        System.out.println("Pepe añade 200ml de café a la cafetera");
        System.out.println(uno.toString());

        pUno.tirarCafe(uno);
        System.out.println("Pepe tira el café de la cafetera");
        System.out.println(uno.toString());

        // PRUEBAS REALIZADAS EN CLASE SOBRE JAVA RECORD
        PersonaR pepe = new PersonaR("pepe", 87);
        pepe.hacerCafe(uno);
        System.out.println(uno);
        pepe.beberCafe(uno, 200);
        System.out.println(uno);
        
        // PROBANDO EQUALS CON JAVA RECORD
        PersonaR anabel= new PersonaR("pepe", 87);
        
        System.out.println(pepe.equals(anabel));
        
    }
}
