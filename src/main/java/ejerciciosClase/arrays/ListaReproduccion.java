/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author eli
 */
/*
Desarrolla una clase ListaReproduccion con los siguientes atributos y métodos. 
Es necesario implementar la clase Cancion:

Atributos:
canciones: una lista de objetos de la clase Cancion.
	Métodos (recuerda implementar equals y hashcode en Cancion)
constructor predeterminado (creará e inicializará la lista).
numeroCanciones(): devuelve el número de canciones de la lista.
estaVacia(): devuelve si la lista de reproducción está vacía.
escucharCancion(int): devuelve la Cancion que se encuentra en la posición indicada.
cambiarCancion(int, Cancion): cambia la Cancion de la posición indicada por la nueva Cancion proporcionada.
grabarCancion(Cancion): agrega al final de la lista la Cancion proporcionada.
eliminaCancion(int): elimina la Cancion que se encuentra en la posición indicada.
eliminaCancion(Cancion c), elimina el objeto c si se encuentra en la lista de reproducción. Usa el método remove(Cancion)
imprimirLista (ListaReproduccion tmp). Método de clase que imprime los nombres de las canciones contenidas en tmp.
buscarCancion(Cancion c), busca la canción c en la lista de reproducción y devuelve la posición en la que se encuentra. Usa el método indexOf.
Incluye un par de métodos de ordenación (por ejemplo, por título y por cantante) usando el método Collections.sort(lista, criterioComparator)
Añade también métodos para buscar, usando Collections.binarySearch(lista, objeto, criterioComparator)

*/
public class ListaReproduccion {
    private List<Cancion> lista;

    public ListaReproduccion() {
        lista=new ArrayList<>();
    }
    
    //numeroCanciones(): devuelve el número de canciones de la lista.
    public int numeroCanciones(){
    return lista.size();
    }
    
    //estaVacia(): devuelve si la lista de reproducción está vacía.
    public boolean estaVacia(){
    return (lista.size()==0) ? true : false;
    }
    
    // escucharCancion(int): devuelve la Cancion que se encuentra en la posición indicada.
    public Cancion escucharCancion(int posicion){
        return lista.get(posicion);
    }
    
    // cambiarCancion(int, Cancion): cambia la Cancion de la posición indicada por la nueva Cancion proporcionada.
    public void cambiarCancion(int posicion, Cancion cancion){
        lista.set(posicion, cancion);
    }
    
    // grabarCancion(Cancion): agrega al final de la lista la Cancion proporcionada.
    public void grabarCancion(Cancion cancion){
        lista.add(cancion);
    }
    
    //eliminaCancion(int): elimina la Cancion que se encuentra en la posición indicada.
    public void eliminarCancion(int posicion){
        lista.remove(posicion);
    }
    
    //eliminaCancion(Cancion c), elimina el objeto c si se encuentra en la lista de reproducción. Usa el método remove(Cancion)
    public void eliminarCancion(Cancion c){
        lista.remove(c);
    }
    
    //imprimirLista (ListaReproduccion tmp). Método de clase que imprime los nombres de las canciones contenidas en tmp.
    public static void imprimirLista(ListaReproduccion tmp){
        tmp.lista.forEach(System.out::println);
    }
    
    //buscarCancion(Cancion c), busca la canción c en la lista de reproducción y devuelve la posición en la que se encuentra. Usa el método indexOf.
    public int buscarCancion(Cancion c){
        return lista.indexOf(c);
    }
    
    // ncluye un par de métodos de ordenación (por ejemplo, por título y por cantante) 
    //usando el método Collections.sort(lista, criterioComparator)
    public void ordenarCancionTitulo(){
       // Collections.sort(lstEmployees, (x, y) -> x.getName().compareToIgnoreCase(y.getName()));
       Collections.sort(lista, (x,y) -> x.getNombre().compareToIgnoreCase(y.getNombre()));
    }
    
    public void ordenarCancionAutor(){
        Collections.sort(lista, (cancionUno, cancionDos)-> cancionUno.getAutor().compareToIgnoreCase(cancionDos.getAutor()));
    }
    
}
