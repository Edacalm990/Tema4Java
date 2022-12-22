/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

/**
 *
 * @author venganzaalchocolate
 */
public class mainCancion {
    public static void main(String[] args) {
        Cancion cancionUno= new Cancion(1, "blabla", "bla");
        Cancion cancionDos= new Cancion(2, "prrrrr", "pr");
        Cancion cancionTres= new Cancion (3, "z", "a");
        ListaReproduccion lista = new ListaReproduccion();
        System.out.println("""
                           La lista está vacia? %b
                           """.formatted(lista.estaVacia()));
        lista.grabarCancion(cancionUno);
        lista.grabarCancion(cancionDos);
        lista.grabarCancion(cancionTres);
        System.out.println("Lista de Canciones");
        ListaReproduccion.imprimirLista(lista);
        
         System.out.println("""
                           La lista está vacia? %b
                           """.formatted(lista.estaVacia()));
         System.out.println("""
                            La lista tiene %d canciones
                            """.formatted(lista.numeroCanciones()));
        System.out.println("""
                           La cancion de la posicion 1 es: 
                           %s
                           """.formatted(lista.escucharCancion(1)));
        lista.cambiarCancion(0, cancionDos);
        System.out.println("""
                           He cambiado la posicion de las canciones ahora en la posicion 0 
                           está la cancion de la posicion 1
                           Posicion 0: 
                           %s
                           """.formatted(lista.escucharCancion(0)));
        System.out.println("Eliminar la cancion 2");
        lista.eliminarCancion(cancionDos);
        ListaReproduccion.imprimirLista(lista);
        System.out.println("----------- Ordenar por Autor ----------");
        lista.ordenarCancionAutor();
        ListaReproduccion.imprimirLista(lista);
        System.out.println("----------- Ordenar por Título ----------");
        lista.ordenarCancionTitulo();
        ListaReproduccion.imprimirLista(lista);
    }
}
