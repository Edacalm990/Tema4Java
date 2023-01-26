/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenconbusqueda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author eli
 */
public class OrdenacionBusqueda {
    public static void main(String[] args) {
        List<Pais> paises= new ArrayList<>();
        paises.add(new Pais("españa", 48, 505400, "EUR"));
        paises.add(new Pais("portugal", 23, 25400, "EUR"));
        paises.add(new Pais("EEUU", 146, 1505400, "DOL A"));
        paises.add(new Pais("italia", 48, 505400, "EUR"));
        
        System.out.println("------------Lista de paises------------");
        paises.forEach(System.out::println);
        System.out.println("");
        
        // ordenar por nombre con orden natural
        // requiere que pais implemente compare
        System.out.println("------------Lista de paises ordenador por nombre------------");
        Collections.sort(paises);
        
        paises.forEach(System.out::println);
        System.out.println("");
        
        // ordenar por poblacion
        System.out.println("------------Lista de paises ordenador por poblacion------------");
        Collections.sort(paises, (p1,p2)->Long.compare(p1.getPoblacion(), p2.getPoblacion()));
        
        paises.forEach(System.out::println);
        
        // ordenar por poblacion 2
        System.out.println("------------Lista de paises ordenador por poblacion (al reves)------------");
        Comparator<Pais> criterioPoblacion = (p1,p2)->Long.compare(p1.getPoblacion(), p2.getPoblacion());
        Collections.sort(paises, criterioPoblacion.reversed());
        paises.forEach(System.out::println);
        System.out.println("-----------------------");
        
        // ordenar por superficie y nombre
        System.out.println("------------Lista de paises ordenados por superficie y nombre------------");
        Comparator<Pais> criterioNombre = (p1,p2)->p1.getNombre().compareToIgnoreCase(p2.getNombre());
        Comparator<Pais> criterioSuperficie = (p1,p2)->Long.compare(p1.getSuperficie(), p2.getSuperficie());
        Collections.sort(paises, criterioSuperficie.thenComparing(criterioNombre));
        paises.forEach(System.out::println);
        
        // collection.binarySearch
        // la lista debe estar ordenada previamente según el criterio de orden
        // hay que pasar lista, key(objeto con lo que hay que buscar, criterio)
        // busqueda por orden natural (nombre en este caso)
        System.out.println("------------Lista de paises probadno binarySearch------------");
        Collections.sort(paises); // lo ordeno por orden natural
        paises.forEach(System.out::println);
        int buscarNombrePortugal = Collections.binarySearch(paises, new Pais("portugal", 0, 0, "EUR"));
        System.out.println(buscarNombrePortugal);
        System.out.println("------------Lista de paises probadno binarySearch por poblacion------------");
        Collections.sort(paises, (p1,p2)->Long.compare(p1.getPoblacion(), p2.getPoblacion()));
        paises.forEach(System.out::println);
        int buscarPoblacion23 = Collections.binarySearch(paises, new Pais ("", 23, 0, ""), criterioPoblacion);
        System.out.println(buscarPoblacion23);
        
        // que pasa si intento buscar en la lista con un valor que no es nombre se puede obtener una posicion erronea
        List<Perro> perros= new ArrayList<>();
        perros.add(new Perro("Laika", LocalDate.of(2000, 10, 5), "podenco", 10, null));
        perros.add(new Perro("Paco", LocalDate.of(2020, 6, 15), "podenco", 5, LocalDate.of(2022, 12, 3)));
        perros.add(new Perro("Akira", LocalDate.of(2017, 4, 15), "podenco", 4, null));
        System.out.println("------------Lista de perros por peso------------");
        Collections.sort(perros);
        perros.forEach(System.out::println);
       int buscarPerroAkiraporFecha= Collections.binarySearch(perros, new Perro("", LocalDate.of(2017, 4, 15), "", 0, null));
        System.out.println(buscarPerroAkiraporFecha);
        
        
        System.out.println("------------Lista de perros por Nombre------------");
        Collections.sort(perros, (p1,p2)->p1.getNombre().compareToIgnoreCase(p2.getNombre()));
        perros.forEach(System.out::println);
        int buscarPerroAkiraPorNombre= Collections.binarySearch(
                perros, 
                new Perro("akira", null, null, 0, null), 
                (p1,p2)->p1.getNombre().compareToIgnoreCase(p2.getNombre()));
        System.out.println(buscarPerroAkiraPorNombre);
    }
}
