/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafetera;

/**
 *
 * @author eli
 */
public class Cafetera {
    private double capacidadMaxima;
    private double cantidadActual;

    public Cafetera() {
        this.capacidadMaxima=1000;
        this.cantidadActual=0;
    }

    public Cafetera(double capacidadMaxima) {
        this.capacidadMaxima = (capacidadMaxima<0) ? 0 : capacidadMaxima;
        this.cantidadActual = capacidadMaxima;
    }

    public Cafetera(double capacidadMaxima, double cantidadActual) {
        this.capacidadMaxima = (capacidadMaxima<0) ? 0 : capacidadMaxima;
        this.cantidadActual = (cantidadActual>this.capacidadMaxima) ?this.capacidadMaxima :cantidadActual;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getCantidadActual() {
        return cantidadActual;
    }

    @Override
    public String toString() {
        return "Cafetera{" + "capacidadMaxima=" + capacidadMaxima + ", cantidadActual=" + cantidadActual + '}';
    }
    
    
    public void llenarCafetera() {
    this.cantidadActual=this.capacidadMaxima;
    }
    
    public void vaciarCafetera() {
    this.cantidadActual=0;
    }
    
    public void servirTaza(double cantidadAServir) {
        double cantidadServirPositivo=Math.abs(cantidadActual);
        this.cantidadActual=(cantidadServirPositivo>=this.capacidadMaxima) ? 0 : cantidadActual-cantidadServirPositivo;   
    }
    
    public void agregarCafe(double cantidadAgregar) {
        double cantidadAgregarPositivo=Math.abs(cantidadAgregar);
        this.cantidadActual=(cantidadAgregarPositivo>capacidadMaxima) ? capacidadMaxima : cantidadAgregarPositivo;
    }
}
