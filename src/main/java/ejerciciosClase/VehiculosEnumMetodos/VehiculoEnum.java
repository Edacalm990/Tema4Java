/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import ejerciciosClase.Modelo;
import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author eli
 */
// he puesto vehiculoEnum para diferenciarlo del primer ejercicio que hicimos que se llamaba vehiculo
public class VehiculoEnum {

    // atributos encapsulados de vehiculo
    private String bastidor;
    private String matricula;
    private ColorVehiculo color;
    private Modelo modelo;
    private boolean disponible;
    private double tarifa;

    // contructor por defecto con datos generados de forma aleatoria
    public VehiculoEnum() {
        this.bastidor = RandomStringUtils.randomAlphanumeric(10);
        this.matricula = RandomStringUtils.randomNumeric(4) + RandomStringUtils.randomAlphabetic(3);
        this.color = ColorVehiculo.getAleatorio();
        this.modelo = Modelo.getAleatorio();
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "VehiculoEnum{" + "bastidor=" + bastidor + ", matricula=" + matricula + ", color=" + color + ", modelo=" + modelo + ", disponible=" + disponible + ", tarifa=" + tarifa + '}';
    }

    //getter y setter
    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ColorVehiculo getColor() {
        return color;
    }

    public void setColor(ColorVehiculo color) {
        this.color = color;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.bastidor);
        return hash;
    }

    // dos vehiculos serán iguales si tienen el mismo bastidor
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
        final VehiculoEnum other = (VehiculoEnum) obj;
        return Objects.equals(this.bastidor, other.bastidor);
    }

}
