/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Test;

/**
 *
 * @author eli
 */
public enum EstadoAnimal {
    
    DESPIERTO(1, "Despierto"), 
    JUGANDO(2, " Jugando"), 
    COMIENDO (3, "Comiendo"), 
    DURMIENDO (4, "Durmiendo");
    
    private int codigoEstado;
    private String estado;
    // contructor privado
    
    private EstadoAnimal(int codigoEstado,String estado){
        this.codigoEstado=codigoEstado;
        this.estado=estado;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public String getEstado() {
        return estado;
    }
    
    
}
