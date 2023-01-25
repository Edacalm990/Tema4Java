/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenconbusqueda;

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
        Comparator<Pais> criterioNombre = (p1,p2)->p1.getNombre().compareToIgnoreCase(p2.getNombre());
        Comparator<Pais> criterioSuperficie = (p1,p2)->Long.compare(p1.getSuperficie(), p2.getSuperficie());
        Collections.sort(paises, criterioSuperficie.thenComparing(criterioNombre));
        
    }
}
