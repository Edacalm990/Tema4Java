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
    protected List<T> lista;
    
    public Catalogo(int tam) {
        this.lista = new ArrayList<>(tam);
        
    }

    public String toString() {
        String tmp = "";
        for (T t : this.lista) {
                tmp += t.toString() + "\n";
        }
        return tmp;
    }
    
    public int buscarPosicionElemento(T elemento) {
        if (elemento != null) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.contains(elemento)) {
                    return i;
                };
            }
        }
        return -1;
    } 

    public int getNumeroElementos() {
        return lista.size();
    }

    public boolean borrarElemento(T elemento) {
        int pos = buscarPosicionElemento(elemento);
        if (pos >= 0) {
            this.lista.remove(pos);
            return true;
        };
        return false;
    }

    public void anadirElemento(T elemento) {
        this.lista.add(elemento);
    }

    
}
