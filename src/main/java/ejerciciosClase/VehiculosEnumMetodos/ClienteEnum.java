/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import java.util.Objects;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author eli
 */
// clase cliente
public class ClienteEnum {
    // atributos encapsulados
    private String nombre;
    private String nif;
    private String apellido;

    // contructor por defecto con parametros aleatorios
    public ClienteEnum() {
        // nif aleatorio 8 numeros y una letra
        this.nif=RandomStringUtils.randomNumeric(8)+RandomStringUtils.randomAlphabetic(1);
        // nombre aleatorio con una lista de nombres de una clase Enum
        this.nombre = RandomStringUtils.randomAlphabetic(8);
        // nombre aleatorio con una lista de apellidos de una clase Enum
        this.apellido = RandomStringUtils.randomAlphabetic(8);
    }

    // contructor pasandole parámetros
    public ClienteEnum(String nombre, String nif, String apellido) {
        this.nombre = nombre;
        this.nif = nif;
        this.apellido = apellido;
    }
    
    // setter para cambiar el nif
    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.nif);
        hash = 29 * hash + Objects.hashCode(this.apellido);
        return hash;
    }

    // solo será igual si los nifs son iguales
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
        final ClienteEnum other = (ClienteEnum) obj;
        return Objects.equals(this.nif, other.nif);
    }

    // to String por defecto
    @Override
    public String toString() {
        return """
               Cliente
                    NIF -> %s
                    NOMBRE -> %s
                    APELLIDO -> %s
               """.formatted(nif,nombre,apellido);
    }

    // solo getters
    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public String getApellido() {
        return apellido;
    }
 
    
    
    
}
