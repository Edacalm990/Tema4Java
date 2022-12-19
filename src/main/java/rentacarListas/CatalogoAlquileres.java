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
public class CatalogoAlquileres {
    

    private List<Alquiler> lista;

    // constructor por defecto donde se le indica el tamaño
    public CatalogoAlquileres(int tamanio) {
        // lo ponemos en positivo por si acaso
        tamanio = Math.abs(tamanio);
        // ponemos el numero de alquileres igual al tamaño
        // creamos la lista de alquileres del tamaño correspondiente
        this.lista = new ArrayList<>();       
    }


    public String toString() {
        String tmp = "";
        for (Alquiler v : lista) {
                tmp += v.toString() + "\n";
        }
        return tmp;
    }



    // método privado para buscar alquiler
    private int buscar(Alquiler alquiler) {
        if (alquiler!= null) {
            for (int i = 0; i < lista.size(); i++) {
                // si no es null y su id es igual devolverá la posicion
                if ( lista.contains(alquiler) ){
                    return i;
                }
            }
        }
        return -1;
    }

    // busca la posicion de un alquiler
    public Alquiler buscarAlquiler(int id) {
        Alquiler aux = new Alquiler();
        aux.setAlquilerID(id);
        int posicion = buscar(aux);
       return (posicion >= 0) ? this.lista.get(posicion) : null;
    }

    // borrará el alquiler poniendo en su posicion null (llamando al método privado de buscar)
    public boolean borrarAlquiler(Alquiler alquiler) {
        int pos = buscar(alquiler);
        if (pos >= 0) {
            this.lista.remove(pos);
            return true;
        };
        return false;
    }

    public int getNumeroVehiculo(){
        return this.lista.size();
    }

    // método que añade un alquiler 
    public void addAlquiler(Alquiler alquiler) {
        lista.add(alquiler);
    }
}
