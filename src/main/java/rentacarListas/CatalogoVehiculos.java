/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

/**
 *
 * @author eli
 */
public class CatalogoVehiculos extends Catalogo<VehiculoEnum> {

    public CatalogoVehiculos(int tam) {
        super(tam);
        for (int i = 0; i < tam; i++) {
            this.anadirElemento(new VehiculoEnum());
        }
    }
    
        public VehiculoEnum buscarVehiculo(String bastidor) {
        VehiculoEnum aux = new VehiculoEnum();
        aux.setBastidor(bastidor);
        int posicion = buscarPosicionElemento(aux);
        VehiculoEnum resultado = (posicion >= 0) ? this.lista.get(posicion): null;
        return resultado;
    }
        
        
        
}
