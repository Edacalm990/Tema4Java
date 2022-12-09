/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

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

    public void mostrarVehiculo() {
        for (VehiculoEnum listaVehiculo : listaVehiculos) {
            System.out.println(listaVehiculo);
        }
    }

    public int buscarVehiculo(VehiculoEnum vehiculo) {
        for (int i = 0; i < this.listaVehiculos.length; i++) {
            if (vehiculo.equals(listaVehiculos[i])) {
                return i;
            };

        }
        return -1;
    }

    public VehiculoEnum[] getListaVehiculos() {
        return listaVehiculos;
    }

    public void borrarVehiculo(VehiculoEnum v) {
        int pos = buscarVehiculo(v);
        if (pos>=0) { 
            this.listaVehiculos[pos]=null;
        }; 
    }
}
