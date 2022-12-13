/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import ejerciciosClase.Modelo;

/**
 *
 * @author eli
 */
public class EjemploVehiculoEnum {
    public static void main(String[] args) {
        Modelo aleatorio = Modelo.getAleatorio();
        System.out.println(aleatorio.toString());
        System.out.println("Color " + ColorVehiculo.getAleatorio());
        CatalogoVehiculos catalogo= new CatalogoVehiculos(10);
        catalogo.mostrarVehiculo();
        System.out.println("---------------------------------------------------------");
        catalogo.getListaVehiculos()[1].setBastidor("AAAA");
        catalogo.mostrarVehiculo();
        VehiculoEnum v = new VehiculoEnum();
        v.setBastidor("123A");
        System.out.println(v);
        int pos = catalogo.buscarVehiculo(v);
        System.out.println(pos);
        catalogo.borrarVehiculo(catalogo.getListaVehiculos()[4]);
        System.out.println("--------------Después de borrar-------------------");
        catalogo.mostrarVehiculo();
        
        System.out.println("Nº vehiculos" + catalogo.getNumeroVehiculos()); // nº vehiculos que hay dentro del catálogo;
        System.out.println(catalogo);

        catalogo.anadirVehiculo(v);
        System.out.println(catalogo);
        catalogo.anadirVehiculo(v);
        System.out.println(catalogo);
        
        catalogo.anadirVehiculo(v);
        System.out.println(catalogo);
        
        ClienteEnum clienteUno = new ClienteEnum();
        System.out.println("--------------------------------");
        System.out.println(clienteUno);
        System.out.println("--------------------------------");
        CatalogoClientes catalogoClientes = new CatalogoClientes(5);
        catalogoClientes.mostrarClientes();
        catalogoClientes.addCliente(clienteUno);
        System.out.println("Número de clientes del catálogo " + catalogoClientes.getNumeroClientes());
        System.out.println("------------------------------");
        catalogoClientes.mostrarClientes();
        System.out.println("--------------------");
        
        catalogoClientes.borrarCliente(clienteUno);
        catalogoClientes.mostrarClientes();
        System.out.println("--------------------");
        System.out.println("Número de clientes del catálogo " + catalogoClientes.getNumeroClientes());
    }
  
}
