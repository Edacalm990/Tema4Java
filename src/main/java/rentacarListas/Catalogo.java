/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eli
 */
// clase genérica, para cualquier tipo de Objeto
public class Catalogo<T>{
    // Catalogo es una List de elementos llamada lista
    protected List<T> lista;
    
    // cuando se llame al contructor creara un ArrayList(hija de List) del tamaño especificado
    public Catalogo(int tam) {
        this.lista = new ArrayList<>(tam);
        
    }

    // to String genérico
    public String toString() {
        String tmp = "";
        for (T t : this.lista) {
            // por cada elmento se añade el String y se hace un salto de linea
                tmp += t.toString() + "\n";
        }
        return tmp;
    }
    
    // buscar una posicion de un elemento dentro del catálogo
    public int buscarPosicionElemento(T elemento) {
        if (elemento != null) {
            return lista.indexOf(elemento);
        }
        return -1;
    } 

    // devuelve el tamaño
    public int getNumeroElementos() {
        return lista.size();
    }

    // borra un elemento
    public boolean borrarElemento(T elemento) {
        // primero busca la posicion
        int pos = buscarPosicionElemento(elemento);
        if (pos >= 0) {
            // borra el elemento dada la posición
            this.lista.remove(pos);
            // devuelve un true si lo ha borrado con éxito
            return true;
        };
        // devuelve un false si no ha borrado nada
        return false;
    }

    // añade un elemento al catálogo
    public void anadirElemento(T elemento) {
        this.lista.add(elemento);
    }

    
}
