/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Objects;

/**
 *
 * @author eli
 */
/*
Además, debes añadir la siguiente funcionalidad en la clase Empresa:

    Devolver una lista con todos Alquileres de un cliente, usando su NIF.
    Devolver una lista con todos Alquileres de un vehiculo, usando su bastidor.
    Borrar un alquiler por id.
    Borrar un cliente del catálogo, si no tiene alquileres grabados.
    Borrar un vehículo del catálogo, si no tiene alquileres grabados.
    Obtener la lista de vehículos que deben ser devueltos en una fecha dada.
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
    public boolean addVehiculo(String bastidor, String matricula) {
        VehiculoEnum aux = new VehiculoEnum();
        aux.setBastidor(bastidor);
        aux.setMatricula(matricula);
        if (catVehiculo.buscarVehiculo(bastidor) == null) {
            catVehiculo.anadirElemento(aux);
            return true;
        } else {
            return false;
        }

    }

    //mostramos alquileres activos (es decir si que no tengan fechaFin, ya que eso significa que el coche no ha sido devuelto)
    public CatalogoAlquileres mostrarAlquileresActivos() {
        CatalogoAlquileres aux = catAlquiler.buscarAlquileresActivos();
        if (aux.lista.isEmpty()) {
            return null;
        } else {
            return aux;
        }
    }

    // añadimos cliente a catálogo clientes, si los datos están en blanco se crearán de forma aleatoria
    // si ya hay un cliente registrado no se registrará
    public boolean addCliente(String nif, String nombre, String apellido) {
        ClienteEnum aux = new ClienteEnum(nombre, nif, apellido);
        ClienteEnum cliente = buscarCliente(nif);
        if ((cliente == null)) {
            catCliente.anadirElemento(aux);
            return true;
        } else {
            return false;
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
            catAlquiler.anadirElemento(aux);
            aux.getVehiculo().setDisponible(false);
            return true;
        }
    }

    // método que cambia el estado del vehiculo que se ha alquilado a true porque ya se ha devuelto
    // y pone fecha de fin
    public boolean recibirVehiculo(int id, LocalDate fecha) {
        Alquiler aux = buscarAlquiler(id);
        if (aux != null) {
            aux.getVehiculo().setDisponible(true);
            aux.setDuracionDiasTotal(DAYS.between(aux.getFechaInicio(), fecha));
            aux.setFechaFin(fecha);
            return true;
        } else {
            return false;
        }
    }

    // Devolver una lista con todos Alquileres de un cliente, usando su NIF.
    public CatalogoAlquileres alquilerCliente(String nif) {
        if (this.catAlquiler.lista.isEmpty()) {
            return null;
        }
        return this.catAlquiler.buscarAlquiler(nif);
    }

    //  Devolver una lista con todos Alquileres de un vehiculo, usando su bastidor.
    public CatalogoAlquileres alquilerBastidor(String bastidor) {
        if (this.catAlquiler.lista.isEmpty()) {
            return null;
        }
        return this.catAlquiler.buscarAlquileresBastidor(bastidor);
    }

    //   Borrar un alquiler por id.
    public boolean borrarAlquiler(int id) {
        return this.catAlquiler.borrarAlquiler(id);
    }
    
    //   Borrar un cliente del catálogo, si no tiene alquileres grabados con el nif
    public boolean borrarClienteSinAlquiler(String nif) {
        if(catAlquiler.buscarAlquiler(nif)==null){
        return catCliente.borrarElemento(buscarCliente(nif));
        }
        return false;
    }

    //   Borrar TODOS LOS clienteS del catálogo, si no tiene alquileres grabados.
    public CatalogoClientes borrarClientesSinAlquiler() {
        // creamos un catalogo con todos los clientes a eliminar
        CatalogoClientes aux = new CatalogoClientes(0);
        // recorremos el catalogo de clientes y añadimos a aux el cliente que no esté en un alquiler
        for (int i = 0; i < catCliente.lista.size(); i++) {
            if (catAlquiler.buscarAlquiler(catCliente.lista.get(i).getNif()) == null) {
                aux.anadirElemento(catCliente.lista.get(i));
            }
        }
        // eliminamos todos los elementos de catalogo clientes que esten en aux
        catCliente.lista.removeAll(aux.lista);
        // devolvemos la lista de clientes eliminada, no tendríamos porque pero me ha parecido mejor mostrar la lista que no mandar un true o false o no mandar nada
        return aux;
    }

    //    Borrar un vehículo del catálogo, si no tiene alquileres grabados.
    public boolean borrarVehiculoSinAlquiler(String bastidor){
        if (catAlquiler.buscarAlquileresBastidor(bastidor)==null){
        return catVehiculo.borrarElemento(catVehiculo.buscarVehiculo(bastidor));
        }
        return false;
    }
    
//    Obtener la lista de vehículos que deben ser devueltos en una fecha dada.
    public CatalogoVehiculos vehiculosParaDevolver(LocalDate fechaDevolucion){
    CatalogoVehiculos vehiculosParaDevolver = new CatalogoVehiculos(0);
        for (int i = 0; i < catAlquiler.lista.size(); i++) {
            // si la fecha de inicio del alquiler más los dias previstos es igual a la fecha que se pasa como parámetro me lo añades al catalogo vehiculosParaDevolver
            if (catAlquiler.lista.get(i).getFechaInicio().plusDays(catAlquiler.lista.get(i).getDuracionDiasPrevista()).isEqual(fechaDevolucion)){
            vehiculosParaDevolver.anadirElemento(catAlquiler.lista.get(i).getVehiculo());
            } 
        }
        // si la lista está vacia me devuelves un null, sino me devuelves el catalogo
    return (vehiculosParaDevolver.lista.isEmpty()) ? null : vehiculosParaDevolver;
    }
}
