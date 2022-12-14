/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import java.util.Arrays;

/**
 *
 * @author eli
 */
public class CatalogoVehiculos {

    private int numeroVehiculos;
    private VehiculoEnum[] listaVehiculos;

    // el contructor recibe el tamaño del catálogo e
    // inicializa la estructura de datos con vehiculos aleatorios
    public CatalogoVehiculos(int tamanio) {
        tamanio = Math.abs(tamanio);
        this.numeroVehiculos = tamanio;
        this.listaVehiculos = new VehiculoEnum[tamanio];

        // una vez creada la estructura de datos le damos valor a caa elemento de manera aleatorio (por VehiculoEnum)
        for (int i = 0; i < listaVehiculos.length; i++) {
            this.listaVehiculos[i] = new VehiculoEnum();

        }
    }

    // método privado para buscar a un cliente
    private int buscar(VehiculoEnum vehiculo) {
        if (vehiculo != null) {
            for (int i = 0; i < listaVehiculos.length; i++) {
                // si no es null y su nif es igual devolverá la posicion
                if (listaVehiculos[i] != null && listaVehiculos[i].equals(vehiculo)) {
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
        VehiculoEnum resultado = (posicion >= 0) ? this.listaVehiculos[posicion] : null;
        return resultado;
    }

    public String toString() {
        String tmp = "";
        for (VehiculoEnum v : listaVehiculos) {
            if (v != null) {
                tmp += v.toString() + "\n";
            }
        }
        return tmp;
    }

    public int getNumeroVehiculos() {
        return numeroVehiculos;
    }

    public VehiculoEnum[] getListaVehiculos() {
        return listaVehiculos;
    }

    // se borra un vehiculo poniendo en la posicion donde estaba el vehiculo a null
    public boolean borrarVehiculo(VehiculoEnum v) {
        int pos = buscar(v);
        if (pos >= 0) {
            this.listaVehiculos[pos] = null;
            this.numeroVehiculos--;
            return true;
        };
        return false;
    }

    // se añade un vehiculo en la primera posicion null que encuentre 
    public void anadirVehiculo(VehiculoEnum v) {
        // si hay espacio
        if (this.listaVehiculos.length > this.getNumeroVehiculos()) {
            for (int i = 0; i < listaVehiculos.length; i++) {
                if (listaVehiculos[i] == null) {
                    listaVehiculos[i] = v;
                    this.numeroVehiculos++;
                    break;
                };
            }
            // si no hay espacio crea y copia el array existente con un tamaño mayor y pone el nuevo vehiculo 
            // en la siguiente posicion valida
        } else {
            this.listaVehiculos = copiarListaVehiculos(this.numeroVehiculos * 2);
            this.listaVehiculos[numeroVehiculos] = v;
            ++this.numeroVehiculos;
        }
    }

    // método copiar propio, crea un array nuevo vacio del tamaño que se le indique y asigna en cada posicion el dato del anterior array
    private VehiculoEnum[] copiarListaVehiculos(int tamanio) {
        VehiculoEnum[] aux = new VehiculoEnum[tamanio];
        for (int i = 0; i < this.listaVehiculos.length; i++) {
            aux[i] = listaVehiculos[i];
        }
        return aux;
    }

}
