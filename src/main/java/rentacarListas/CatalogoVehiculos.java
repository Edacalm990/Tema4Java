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
public class CatalogoVehiculos {

    private List<VehiculoEnum> lista;

    // el contructor recibe el tamaño del catálogo e
    // inicializa la estructura de datos con vehiculos aleatorios
    public CatalogoVehiculos(int tamanio) {
        tamanio = Math.abs(tamanio);
        this.lista = new ArrayList<>(tamanio);

        // una vez creada la estructura de datos le damos valor a caa elemento de manera aleatorio (por VehiculoEnum)
        for (int i = 0; i < tamanio; i++) {
            this.lista.add(new VehiculoEnum());
        }
    }

    // método privado para buscar a vehiculo
    private int buscar(VehiculoEnum vehiculo) {
        if (vehiculo != null) {
            for (int i = 0; i < lista.size(); i++) {
                // si no es null y su bastidor es igual devolverá la posicion
                if (lista.contains(vehiculo)) {
                    return i;
                };
            }
        }
        return -1;
    }

    // s ebusca un vehiculo por el bastidor, si no lo encuentra devuelve un vehiculo con valor null
    public VehiculoEnum buscarVehiculo(String bastidor) {
        VehiculoEnum aux = new VehiculoEnum();
        aux.setBastidor(bastidor);
        int posicion = buscar(aux);
        VehiculoEnum resultado = (posicion >= 0) ? this.lista.get(posicion): null;
        return resultado;
    }

    public String toString() {
        String tmp = "";
        for (VehiculoEnum v : lista) {
                tmp += v.toString() + "\n";
        }
        return tmp;
    }

    public int getNumeroVehiculos() {
        return lista.size();
    }

    // se borra un vehiculo poniendo en la posicion donde estaba el vehiculo a null
    public boolean borrarVehiculo(VehiculoEnum v) {
        int pos = buscar(v);
        if (pos >= 0) {
            this.lista.remove(pos);
            return true;
        };
        return false;
    }

    // se añade un vehiculo en la primera posicion null que encuentre 
    public void anadirVehiculo(VehiculoEnum v) {
        // si hay espacio
        this.lista.add(v);
    }


}
