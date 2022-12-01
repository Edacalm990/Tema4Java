/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafetera;

/**
 *
 * @author eli
 */
// onstructor cafetera
public class Cafetera {
    private double capacidadMaxima;
    private double cantidadActual;

    // contructor por defecto
    public Cafetera() {
        this.capacidadMaxima=1000;
        this.cantidadActual=0;
    }

    // contructor con capacidad maxima
    public Cafetera(double capacidadMaxima) {
        this.capacidadMaxima = (capacidadMaxima<0) ? 0 : capacidadMaxima;
        this.cantidadActual = capacidadMaxima;
    }
    
    // contructor con capacidad maxima y cantidad actual
    public Cafetera(double capacidadMaxima, double cantidadActual) {
        this.capacidadMaxima = (capacidadMaxima<0) ? 0 : capacidadMaxima;
        this.cantidadActual = (cantidadActual>this.capacidadMaxima) ?this.capacidadMaxima :cantidadActual;
    }

    // getter
    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }
    
    
    // to string
    @Override
    public String toString() {
        return "Cafetera{" + "capacidadMaxima=" + capacidadMaxima + ", cantidadActual=" + cantidadActual + '}';
    }
    
    // metodo para que cantidad actual sea igual a cantidad maxima
    public void llenarCafetera() {
    this.cantidadActual=this.capacidadMaxima;
    }
    
    // método para que la cantidad actual sea 0
    public void vaciarCafetera() {
    this.cantidadActual=0;
    }
    
    // método actual para desminuir la cantidad actual (con restricciones)
    public void servirTaza(double cantidadAServir) {
        double cantidadServirPositivo=Math.abs(cantidadAServir);
        this.cantidadActual=(cantidadServirPositivo<=this.capacidadMaxima) ? (this.cantidadActual-cantidadServirPositivo) : 0;   
    }
    
    // método para añadir contenido a la cantidad actual (con restricciones)
    public void agregarCafe(double cantidadAgregar) {
        double cantidadAgregarPositivo=Math.abs(cantidadAgregar);
        this.cantidadActual=(cantidadAgregarPositivo+this.cantidadActual>this.capacidadMaxima) ? this.capacidadMaxima : cantidadAgregarPositivo+this.cantidadActual;
    }
}
