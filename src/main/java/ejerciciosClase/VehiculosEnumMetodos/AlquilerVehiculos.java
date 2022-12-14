/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import java.time.LocalDate;

/**
 *
 * @author eli
 */
public class AlquilerVehiculos {

    public static void main(String[] args) {
        CatalogoVehiculos catalogoVehiculos= new CatalogoVehiculos(5);
        CatalogoClientes catalogoClientes = new CatalogoClientes(5);
        ClienteEnum clientePrueba = new ClienteEnum();
        clientePrueba.setNif("prueba");
        catalogoClientes.addCliente(clientePrueba);
        VehiculoEnum vehiculo = new VehiculoEnum();
        Alquiler alquilerUno = new Alquiler(catalogoClientes.buscarCliente("prueba"), vehiculo, LocalDate.now(), 8);
        
        System.out.println(alquilerUno);
        
        CatalogoAlquileres catalogoDos = new CatalogoAlquileres(10);
        catalogoDos.addAlquiler(alquilerUno);
        System.out.println("Lista de Alquileres");
        System.out.println(catalogoDos);
        
    }
}
