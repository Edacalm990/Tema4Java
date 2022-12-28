/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eli
 */
// catálogo alquileres es una clase que hereda de catálogo
public class CatalogoAlquileres extends Catalogo<Alquiler> {

    // contructor por defecto donde se introduce un tamaño
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

    // busca el alquiler por nif del cliente
    public CatalogoAlquileres buscarAlquiler(String cNif) {
        CatalogoAlquileres aux = new CatalogoAlquileres(10);
        // recorre la lista y comprueba si hay algún cliente con ese nif
        for (Alquiler alquiler : lista) {
            if (alquiler.getCliente().getNif().equalsIgnoreCase(cNif)) {
                aux.anadirElemento(alquiler);
            }
        }
        // si no hay alquiler devuelve un null
        return (aux.lista.isEmpty()) ? null : aux;
    }
    
    // busca alquileres que contengan un bastidor
    public CatalogoAlquileres buscarAlquileresBastidor(String bastidor) {
        CatalogoAlquileres aux = new CatalogoAlquileres(10);
        for (Alquiler alquiler : lista) {
            // recorre la lista y comprueba si hay algún alquiler con ese bastidor
            if (alquiler.getVehiculo().getBastidor().equalsIgnoreCase(bastidor)) {
                aux.anadirElemento(alquiler);
            }
        }
        // si no hay alquiler devuelve un null
        return (aux.lista.isEmpty()) ? null : aux;
    }

    // se borra un alquiler por id
    public boolean borrarAlquiler(int id) {
        Alquiler aux = buscarAlquiler(id);
        if (aux != null) {
            // si borramos un alquiler ponemos el vehiculo a disponible, sino se quedaría bloquedado aun que el alquiler no existiera
            aux.getVehiculo().setDisponible(true);
            this.lista.remove(aux);
            return true;
        } else {
            return false;
        }
    }

    // buscar alquileres activos, es decir donde el vehiculo no se ha devuelto
    // este es un método extra que me ha parecido más realista, ya que cuando alquilas un vehiculo puedes devolverlo más tarde de lo previsto 
    public CatalogoAlquileres buscarAlquileresActivos() {
        CatalogoAlquileres aux = new CatalogoAlquileres(10);
        for (Alquiler alquiler : lista) {
            // si no tiene fecha de devolucion se añade el alquiler al catalogo aux
            if (alquiler.getFechaFin() == null) {
                aux.anadirElemento(alquiler);
            }
        }
        return aux;
    }



}
