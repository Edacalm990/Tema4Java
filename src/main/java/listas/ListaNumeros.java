/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

import java.util.ArrayList;

/**
 *
 * @author eli
 */
public class ListaNumeros {
    public static void main(String[] args) {
        ArrayList<Integer> listaEnteros = new ArrayList<>();
        
        listaEnteros.add(10);
        listaEnteros.add(9);
        listaEnteros.add(8);
        listaEnteros.add(7);
        listaEnteros.add(6);
        
        System.out.println(listaEnteros.size());
        
        for (int i = 0; i < listaEnteros.size(); i++) {
            Integer get = listaEnteros.get(i);
            System.out.println(get);
            
        }
        if (listaEnteros.contains(7)){
            System.out.println("El 7 está en la lista");
        };
        
        int posicion =  listaEnteros.indexOf(6);
        System.out.println(posicion);
        
        listaEnteros.remove(new Integer(10));
        for (int i = 0; i < listaEnteros.size(); i++) {
            Integer get = listaEnteros.get(i);
            System.out.println(get);
            
        }
        
        listaEnteros.forEach(e->System.out.println(e));
        listaEnteros.forEach(System.out::println);
        
        for (Integer num : listaEnteros) {
            System.out.println("Lista de numeros "+num);
        }
        
        
    }
    
}
