/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author eli
 */
public class Cancion {
    private int duracion;
    private String autor;
    private String nombre;

    public Cancion() {
        this.autor=RandomStringUtils.randomAlphanumeric(8);
        this.duracion=Integer.parseInt(RandomStringUtils.random(8));
        this.nombre=RandomStringUtils.randomAlphanumeric(8);
    }

    public Cancion(int duracion, String autor, String nombre) {
        this.duracion = duracion;
        this.autor = autor;
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.duracion;
        hash = 17 * hash + Objects.hashCode(this.autor);
        hash = 17 * hash + Objects.hashCode(this.nombre);
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
        final Cancion other = (Cancion) obj;
        if (this.duracion != other.duracion) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return """
               Cancion:
                    Nombre -> %s
                    Duración -> %b
                    Autor -> %s
               
               """.formatted(nombre,duracion, autor);
    }
    
    
    
}
