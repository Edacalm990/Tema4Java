/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import java.util.Objects;

/**
 *
 * @author eli
 */
public class Empresa {

    private String cif;
    private String nombre;
    private CatalogoVehiculos catVehiculo;
    private CatalogoClientes catCliente;
    private CatalogoAlquileres catAlquiler;

    public Empresa(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        this.catAlquiler = new CatalogoAlquileres(5);
        this.catCliente = new CatalogoClientes(5);
        this.catVehiculo = new CatalogoVehiculos(5);
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CatalogoVehiculos getCatVehiculo() {
        return catVehiculo;
    }

    public void setCatVehiculo(CatalogoVehiculos catVehiculo) {
        this.catVehiculo = catVehiculo;
    }

    public CatalogoClientes getCatCliente() {
        return catCliente;
    }

    public void setCatCliente(CatalogoClientes catCliente) {
        this.catCliente = catCliente;
    }

    public CatalogoAlquileres getCatAlquiler() {
        return catAlquiler;
    }

    public void setCatAlquiler(CatalogoAlquileres catAlquiler) {
        this.catAlquiler = catAlquiler;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CIF=").append(cif);
        sb.append("\nNombre=").append(nombre);
        sb.append("\n--------------------------------------------------------------");
        sb.append("\n").append(catVehiculo);
        sb.append("--------------------------------------------------------------");
        sb.append("\n").append(catCliente);
        sb.append("--------------------------------------------------------------");
        sb.append("\n").append(catAlquiler);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        return Objects.equals(this.cif, other.cif);
    }

    public void addVehiculo(String bastidor) {
        VehiculoEnum aux = new VehiculoEnum();
        if (!bastidor.isBlank()) {
        aux.setBastidor(bastidor);
        } 
        catVehiculo.anadirVehiculo(aux);
    }
    
        public void addCliente(String cif) {
        ClienteEnum aux = new ClienteEnum();
        if (!cif.isBlank()) {
        aux.setNif(cif);
        } 
        catCliente.addCliente(aux);
    }
    
    public VehiculoEnum buscarVehiculo (String bastidor) {
    return catVehiculo.buscarVehiculo(bastidor);
    }
    
    public ClienteEnum buscarCliente (String nif) {
    return catCliente.buscarCliente(nif);
    }

}
