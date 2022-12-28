/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

/**
 *
 * @author eli
 */
// catálogo vehiculos es una clase que hereda de catálogo
public class CatalogoVehiculos extends Catalogo<VehiculoEnum> {

    // contructor por defecto que crea el catalogo del tamaño que le hemos pasado y lo rellena con coches aleatorios
    public CatalogoVehiculos(int tam) {
        super(tam);
        for (int i = 0; i < tam; i++) {
            this.anadirElemento(new VehiculoEnum());
        }
    }

    // busca un vehiculo por el bastidor, si la posicion es -1 devuelve un null
    public VehiculoEnum buscarVehiculo(String bastidor) {
        VehiculoEnum aux = new VehiculoEnum();
        aux.setBastidor(bastidor);
        int posicion = buscarPosicionElemento(aux);
        VehiculoEnum resultado = (posicion >= 0) ? this.lista.get(posicion) : null;
        return resultado;
    }



}
