/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author eli
 */
public class VehiculoEnum {
    private String bastidor;
    private String matricula;
    private ColorVehiculo color;
    private Modelo modelo;
    private boolean disponible;
    private double tarifa;

    public VehiculoEnum() {
        this.bastidor=RandomStringUtils.randomAlphanumeric(10);
        this.matricula=RandomStringUtils.randomNumeric(4)+RandomStringUtils.randomAlphabetic(3);
        this.color= ColorVehiculo.getAleatorio();
        this.modelo= Modelo.getAleatorio();
    }
        

    @Override
    public String toString() {
        return "VehiculoEnum{" + "bastidor=" + bastidor + ", matricula=" + matricula + ", color=" + color + ", modelo=" + modelo + ", disponible=" + disponible + ", tarifa=" + tarifa + '}';
    }

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
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.bastidor);
        hash = 53 * hash + Objects.hashCode(this.matricula);
        hash = 53 * hash + Objects.hashCode(this.color);
        hash = 53 * hash + Objects.hashCode(this.modelo);
        hash = 53 * hash + (this.disponible ? 1 : 0);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.tarifa) ^ (Double.doubleToLongBits(this.tarifa) >>> 32));
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
        final VehiculoEnum other = (VehiculoEnum) obj;
        
        return this.bastidor == other.bastidor;
    }
    
    
}
