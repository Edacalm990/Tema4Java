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
public class Alquiler {
    
    private int alquilerID;
    private ClienteEnum cliente;
    private VehiculoEnum vehiculo;
    private LocalDate fechaInicio;
    private int duracionDias;
    
    private static int contador = 0;

    public Alquiler(ClienteEnum cliente, VehiculoEnum vehiculo, LocalDate fechaInicio, int duracionDias) {
        contador++;
        this.alquilerID= contador;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.duracionDias = duracionDias;
    }

    public Alquiler() {
    }

    public void setAlquilerID(int alquilerID) {
        this.alquilerID = alquilerID;
    }
    
    

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public ClienteEnum getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEnum cliente) {
        this.cliente = cliente;
    }

    public VehiculoEnum getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEnum vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getAlquilerID() {
        return alquilerID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("""
                  ID Alquiler -> %d
                        NIF DEL CLIENTE -> %s
                        BASTIDOR DEL VEHICULO -> %s
                        FECHA -> %s
                        DURACION -> %d dias
                  """.formatted(alquilerID, cliente.getNif(), vehiculo.getBastidor(), fechaInicio, duracionDias));
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.alquilerID;
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
        final Alquiler other = (Alquiler) obj;
        return this.alquilerID == other.alquilerID;
    }
    
    
 
    
}
