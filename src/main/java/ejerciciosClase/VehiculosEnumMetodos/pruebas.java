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
public class pruebas {

    public static void main(String[] args) {
//        CatalogoVehiculos catalogoVehiculos= new CatalogoVehiculos(5);
//        CatalogoClientes catalogoClientes = new CatalogoClientes(5);
//        ClienteEnum clientePrueba = new ClienteEnum();
//        clientePrueba.setNif("prueba");
//        catalogoClientes.addCliente(clientePrueba);
//        VehiculoEnum vehiculo = new VehiculoEnum();
//        Alquiler alquilerUno = new Alquiler(catalogoClientes.buscarCliente("prueba"), vehiculo, LocalDate.now(), 8);
//        
//        System.out.println(alquilerUno);
//        
//        CatalogoAlquileres catalogoDos = new CatalogoAlquileres(10);
//        catalogoDos.addAlquiler(alquilerUno);
//        System.out.println("Lista de Alquileres");
//        System.out.println(catalogoDos);
//        System.out.println(catalogoVehiculos);
//         System.out.println(catalogoClientes);
//         System.out.println(catalogoClientes);
//         Empresa prueba = new Empresa("0", "prueba");
//         System.out.println("----------------------");
//         
//         System.out.println(prueba);
         
         CatalogoEmpresas pruebaEmpresas = new CatalogoEmpresas(2);
         System.out.println(pruebaEmpresas);
        pruebaEmpresas.registrarEmpresa("2", "registroEmpresaPrueba");
        pruebaEmpresas.registrarEmpresa("3", "prueba3");
        System.out.println(pruebaEmpresas);
        pruebaEmpresas.resgistrarVehiculo("2", "1234");
        System.out.println(pruebaEmpresas);
        System.out.println(pruebaEmpresas.buscarVehiculo("1234"));
        pruebaEmpresas.resgistrarCliente("2", "cifprueba");
        System.out.println(pruebaEmpresas);
        System.out.println(pruebaEmpresas.buscarCliente("cifprueba"));
    }
}
