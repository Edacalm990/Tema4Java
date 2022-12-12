/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.series;

import java.util.Scanner;

/**
 * Me sirve como conexión entre el main y mi clase
 * @author elisabet
 */
public class ServicioSerie {
    private static Scanner teclado= new Scanner(System.in);
    
    
    
    // lee por teclado los datos de una serie y devuelve el objeto creado
    public static Serie leerTecladoSerie() {
        // creamos el objeto
        Serie respuesta;
        // Leer por eclado e instanciar
        System.out.println("Nombre de la serie");
        String nombre=teclado.nextLine();
        System.out.println("Genero de la serie");
        String genero=teclado.nextLine();
        System.out.println("Productora de la serie");
        String productora=teclado.nextLine();
        System.out.println("Sinopsis");
        String sinopsis=teclado.nextLine();
        System.out.println("Nº de temporadas");
        int temp=teclado.nextInt();
        System.out.println("Likes");
        int likes=teclado.nextInt();
        teclado.nextLine();
        
        respuesta=new Serie(nombre, genero, sinopsis, productora, temp, likes);
        
        // Devolvemos el tipo Serie
        return respuesta;
    }
        public static void darLike(Serie serie){
            System.out.println("Te ha gustado?");
            String respuesta = teclado.nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                serie.darLike();
            }
        }
        
    public static Serie copia (Serie origen ) {
    Serie aux= new Serie(origen.getTitulo(),origen.getGenero(), origen.getSinopsis(), origen.getProductor(), origen.getNumeroTemporadas(), origen.getNumeroLikes());
    return aux;
    }
}
