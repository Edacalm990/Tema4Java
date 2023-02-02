/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author eli
 */
/*
Implementa una Pila (Stack, en inglés) usando clases genéricas. Una pila es un almacén de datos en el que 
se sigue una política específica a la hora de introducir y sacar los elementos. Una pila sigue una política LIFO 
(Last In First Out), es decir, el último elemento en entrar (apilar) es el primero en salir (desapilar). 
La pila tiene un tamaño máximo, de forma que no se pueden guardar más elementos que los indicados en ese tamaño. 
Gráficamente, una pila de números se puede representar según la siguiente imagen:


En este ejercicio se pide implementar una clase que modele el comportamiento de una pila, para cualquier 
tipo de objetos, mediante un ArrayList, ofreciendo la siguiente funcionalidad:
La pila siempre se creará vacía.
apilar elemento (en inglés push), lo inserta donde proceda.
desapilar (en inglés pop), que saca el elemento que toque.
Saber si la pila está vacía.
Saber si la pila está llena.
Saber el número de elementos que contiene la pila.
Mostrar por consola los elementos de la pila, según el orden en el que saldrían los elementos de la pila. 
Esta operación no debe alterar la estructura de datos.
rellenar (T[] array), almacena en la pila los objetos que hay en el array. La pila se ajusta su tamaño según 
el número de elementos que tenga el array.
T[] sacarElementos(), saca los elementos de la pila y los devuelve en un array de T. La pila, después de llamar 
a este método, queda vacía.
 */
public class Pila<T> {

    private List<T> pila;
    private int tamanio;

    public Pila(int tamanio) {
        this.pila = new ArrayList<>(tamanio);
        this.tamanio = tamanio;
    }

    public boolean push(T elemento) {
        if (elemento != null && pila.size() < tamanio) {
            pila.add(elemento);
            return true;
        }
        return false;
    }

    public boolean pop() {
        if (!pila.isEmpty()) {
            pila.remove(pila.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean estaLlena() {
        return pila.size()==tamanio;
    }
    
    public boolean estaVacia() {
        return pila.isEmpty();
    }
    
    public int numElementos(){
        return pila.size();
    }
    
    public void rellenar(T[] array){
        this.pila.clear();
        for (int i = 0; i < array.length; i++) {
            pila.add(array[i]);
        }
        this.tamanio=array.length;
    }
    
    public Object [] sacarElementos(){
        Object[] tmp=pila.toArray();
        pila.clear();
        return tmp;
    }

    @Override
    public String toString() {
        String tmp="";
        for (int i = pila.size()-1; 0 < i; i--) {
            tmp+="| "+pila.get(i)+" |";
            tmp+="\n";
        }
        return tmp;
    }

    
    
}
