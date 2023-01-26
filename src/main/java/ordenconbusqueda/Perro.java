/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenconbusqueda;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author eli
 */
public class Perro implements Comparable<Perro>{
    private String nombre;
    private LocalDate fechaNacimiento;
    private String raza;
    private double peso;
    private LocalDate fallecimiento;

    public Perro() {
    }

    public Perro(String nombre, LocalDate fechaNacimiento, String raza, double peso, LocalDate fallecimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.peso = peso;
        this.fallecimiento = fallecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(LocalDate fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 47 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
//        return hash;
//    }

    

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Perro other = (Perro) obj;
//        return Double.doubleToLongBits(this.peso) == Double.doubleToLongBits(other.peso);
//    }
//



//    @Override
//    public int compareTo(Perro o) {
//        return (this.peso==o.peso) ?1 :-1;
//    }
    
        @Override
    public String toString() {
        return "Perro{" + "nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", raza=" + raza + ", peso=" + peso + ", fallecimiento=" + fallecimiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.fechaNacimiento);
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
        final Perro other = (Perro) obj;
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }
    
        @Override
    public int compareTo(Perro o) {
        return this.fechaNacimiento.compareTo(o.fechaNacimiento);
    }
    
}
