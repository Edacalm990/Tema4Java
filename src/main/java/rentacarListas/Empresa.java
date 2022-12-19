/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author eli
 */
public class Empresa {

    // atributos empresa encapsulados;
    private String cif;
    private String nombre;
    private CatalogoVehiculos catVehiculo;
    private CatalogoClientes catCliente;
    private CatalogoAlquileres catAlquiler;

    public Empresa(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
        // se crea un catálogo aleatorio de cada categoria
        // alquileres estará vacio, cliente y vehiculo objetos aleatorios
        this.catAlquiler = new CatalogoAlquileres(5);
        this.catCliente = new CatalogoClientes(5);
        this.catVehiculo = new CatalogoVehiculos(5);
    }

    // getter y setter
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

    // serán iguales si el cif es el mismo
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

    // añadimos un vehiculo al catálogo de vehiculos, modificará el bastidor y la mátricula si el usuario pone datos
    public void addVehiculo(String bastidor, String matricula) {

        VehiculoEnum aux = new VehiculoEnum();
        if (!bastidor.isBlank()) {
            aux.setBastidor(bastidor);
        } else if (!matricula.isBlank()) {
            aux.setMatricula(bastidor);
        }
        catVehiculo.anadirVehiculo(aux);
    }

    // añadimos cliente a catálogo clientes, si los datos están en blanco se crearán de forma aleatoria
    public void addCliente(String nif, String nombre, String apellido) {
        ClienteEnum aux = new ClienteEnum();
        if (!nif.isBlank() && !nombre.isBlank() && !apellido.isBlank()) {
            catCliente.addCliente(new ClienteEnum(nombre, nif, apellido));
        } else {
            catCliente.addCliente(aux);
        }

    }

    // se llama al método de catalagoVehiculos de buscar vehiculo
    public VehiculoEnum buscarVehiculo(String bastidor) {
        return catVehiculo.buscarVehiculo(bastidor);
    }

    // se llama al método de catálogo de clientes de buscar cliente
    public ClienteEnum buscarCliente(String nif) {
        return catCliente.buscarCliente(nif);
    }

    // s ellama al método de catálogo de alquileres de buscar alquiler
    private Alquiler buscarAlquiler(int id) {
        return catAlquiler.buscarAlquiler(id);
    }

    // se registra un alquiler solo si los datos son correctos
    public boolean registrarAlquiler(LocalDate fechaInicio, String bastidor, String nif, int duracionDias) {
        VehiculoEnum vehiculo = buscarVehiculo(bastidor);
        ClienteEnum cliente = buscarCliente(nif);
        if (vehiculo == null || cliente == null || fechaInicio.isBefore(LocalDate.now()) || duracionDias <= 0 || !vehiculo.isDisponible()) {
            return false;
        } else {
            Alquiler aux = new Alquiler(cliente, vehiculo, fechaInicio, duracionDias);
            // se llama al método addAlquiler de catalogo de alquiler para añadir el alquiler
            catAlquiler.addAlquiler(aux);
            aux.getVehiculo().setDisponible(false);
            return true;
        }
    }

    // método que cambia el estado del vehiculo que se ha alquilado a true porque ya se ha devuelto
    public boolean recibirVehiculo(int id) {
        Alquiler aux = buscarAlquiler(id);
        if (aux != null) {
            aux.getVehiculo().setDisponible(true);
            return true;
        } else {
            return false;
        }

    }

}
