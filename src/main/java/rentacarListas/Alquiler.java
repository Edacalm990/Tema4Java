/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

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
    private int duracionDiasPrevista;
    private long duracionDiasTotal;
    // este es un atributo añadido para comprobar si un alquiler está en activo o no
    // es decir si un coche no ha sido devuelto el alquiler sigue activo y no tiene fechaFin si ha sido devuelto el alquiler esta inactivo y si tiene fechaFin
    private LocalDate fechaFin;
    
    private static int contador = 0;

    public Alquiler(ClienteEnum cliente, VehiculoEnum vehiculo, LocalDate fechaInicio, int duracionDias) {
        contador++;
        this.alquilerID= contador;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.duracionDiasPrevista = duracionDias;
    }

    public Alquiler() {
    }

    public long getDuracionDiasTotal() {
        return duracionDiasTotal;
    }

    public void setDuracionDiasTotal(long duracionDiasTotal) {
        this.duracionDiasTotal = duracionDiasTotal;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setAlquilerID(int alquilerID) {
        this.alquilerID = alquilerID;
    }

    public int getDuracionDiasPrevista() {
        return duracionDiasPrevista;
    }

    public void setDuracionDiasPrevista(int duracionDiasPrevista) {
        this.duracionDiasPrevista = duracionDiasPrevista;
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
                        FECHA DE INICIO -> %s
                        FECHA DE FIN -> %s
                        DURACION PREVISTA -> %d dias
                  DURACION TOTAL -> %d dias
                  """.formatted(alquilerID, cliente.getNif(), vehiculo.getBastidor(), fechaInicio, fechaFin, duracionDiasPrevista, duracionDiasTotal));
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
