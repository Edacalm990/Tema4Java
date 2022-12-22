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
public class CatalogoAlquileres extends Catalogo<Alquiler> {
    
    public CatalogoAlquileres(int tam) {
        super(tam);
    }

    // busca la posicion de un alquiler
    public Alquiler buscarAlquiler(int id) {
        Alquiler aux = new Alquiler();
        aux.setAlquilerID(id);
        int posicion = buscarPosicionElemento(aux);
       return (posicion >= 0) ? this.lista.get(posicion) : null;
    }
    
    public CatalogoAlquileres buscarAlquiler(String clientenNif){
        CatalogoAlquileres aux = new CatalogoAlquileres(10);
        for (Alquiler alquiler : lista) {
            System.out.println(alquiler.toString());
        }
        return aux;
    }

}
