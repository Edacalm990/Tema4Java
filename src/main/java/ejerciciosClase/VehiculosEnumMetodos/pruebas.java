/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author eli
 */
/*
menu mostrar vehiculos, mostrar clientes, mostrar alquileres
Dar de alta clientes, dar de alta vehiculos, registrar alquileres

 */
public class pruebas {
    
    public static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        Empresa rentacar = new Empresa("1234", "rentacar");
        int opcion = 0;
        do {
            
            opcion = menu();
            switch (opcion) {
                case 1:
                    System.out.println(rentacar.getCatVehiculo());
                    teclado.nextLine();
                    break;
                case 2:
                    System.out.println(rentacar.getCatCliente());
                    teclado.nextLine();
                    break;
                case 3:
                    System.out.println(rentacar.getCatAlquiler());
                    teclado.nextLine();
                    break;
                case 4:
                    darAltaCliente(rentacar);
                    teclado.nextLine();
                    break;
                case 5:
                    darAltaVehiculos(rentacar);
                    teclado.nextLine();
                    break;
                case 6:                
                    resgistrarAlquiler(rentacar);
                    teclado.nextLine();
                    break;
                default:
                    teclado.nextLine();
                    throw new AssertionError();
            }
        } while (opcion != 7);
        
    }
    
    private static int menu() {
        int opcion = 0;
        do {
            System.out.println("""
                           ********************** RENTACAR **********************
                           Elige una opción:
                                1. Mostrar Vehiculos
                                2. Mostrar Clientes
                                3. Mostrar Alquileres
                           
                                4. Dar de alta Clientes
                                5. Dar de alta Vehiculos
                                6. Registrar Alquileres
                                
                                7. SALIR
                           """);
            try {
                opcion = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Debe ser un número entero y positivo");
            }
            
        } while (opcion < 1 || opcion > 7);
        
        return opcion;
    }
    
    private static String pedirDato(String texto) {
        System.out.println(texto);
        return teclado.nextLine();
    }
    
    private static void darAltaCliente(Empresa empresa) {
        teclado.nextLine();
        System.out.println("********************** DAR DE ALTA CLIENTE **********************");
        String nombre = pedirDato("Nombre: ");
        String apellido = pedirDato("Apellido: ");
        String nif = pedirDato("Nif: ");
        empresa.addCliente(nif, nombre, apellido);
    }
    
    private static void darAltaVehiculos(Empresa empresa) {
        System.out.println("********************** DAR DE ALTA VEHICULO **********************");
        String bastidor = pedirDato("Bastidor del coche: ");
        empresa.addVehiculo(bastidor);
    }
    
    private static void resgistrarAlquiler(Empresa empresa) {
        System.out.println("********************** REGISTRAR ALQUILER **********************");
        LocalDate fecha=LocalDate.now();
        do {
            try {
                fecha = LocalDate.parse(pedirDato("Fecha del incio del alquiler: "));                
            } catch (Exception e) {
                System.out.println("Debe tener el siguiente formato YYYY-MM-DD");
                teclado.nextLine();
            }
        } while (fecha.isBefore(LocalDate.now()));
        String bastidor = pedirDato("Bastidor del coche: ");
        String nif = pedirDato("Nif del cliente: ");
        int dias=0;
        do {
            try {
                dias= Integer.parseInt(pedirDato("Días de alquiler: "));
            } catch (Exception e) {
                System.out.println("Dias debe ser un número entero y positivo");
            }
        } while (dias>0);
        
        empresa.registrarAlquiler(fecha,bastidor,nif,dias);
    }
    
}
