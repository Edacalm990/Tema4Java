/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase;

import java.util.Objects;

/**
 * titulo, genero (accion, comedia, Scifi, drama), sinopsis, nº temporadas, productor
 * @author elisabet
 */
public class Serie {
    
    // Atributos de clase (son estatic)
    // Atributos de instanacia (no son static)
    private String titulo;
    private String genero;
    private String sinopsis;
    private String productor;
    private int numeroTemporadas; 
    private int numeroLikes;

    public Serie(String titulo, String genero, String sinopsis, String productor, int numeroTemporadas) {
        this.titulo = titulo;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.productor = productor;
        this.numeroTemporadas = numeroTemporadas;
        this.numeroLikes=numeroLikes;
    }

    public Serie(String titulo, String genero, String sinopsis, String productor, int numeroTemporadas, int numeroLikes) {
        this.titulo = titulo;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.productor = productor;
        this.numeroTemporadas = numeroTemporadas;
        this.numeroLikes = numeroLikes;
    }

    
    public Serie() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public int getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(int numeroLikes) {
        this.numeroLikes = numeroLikes;
    }
    
    public void darLike(){
        this.numeroLikes++;
    }
    
    

    @Override
    public String toString() {
        return """
               Nombre: %s
               Genero: %s
               Sinopsis: %s
               Productor: %s
               Nº de Temporadas: %s
               Nº e Likes %s
               """.formatted(titulo, genero, sinopsis, productor, numeroTemporadas, numeroLikes);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.titulo);
        hash = 79 * hash + Objects.hashCode(this.genero);
        hash = 79 * hash + Objects.hashCode(this.sinopsis);
        hash = 79 * hash + Objects.hashCode(this.productor);
        hash = 79 * hash + this.numeroTemporadas;
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
        final Serie other = (Serie) obj;
        if (this.numeroTemporadas != other.numeroTemporadas) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.sinopsis, other.sinopsis)) {
            return false;
        }
        return Objects.equals(this.productor, other.productor);
    }
    
    
    
}
