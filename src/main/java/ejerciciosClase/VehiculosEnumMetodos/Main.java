/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author eli
 */
public class Main {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        // Creamos una empresa ficticia
        Empresa rentacar = new Empresa("1234", "rentacar");
        String opcion = "";
        do {
            // pedimos la opcion del menú, si es 7 el programa saldrá
            opcion = menu();
            
            switch (opcion) {
                case "1": // si es la primera opción mostraremos una lista con todos los vehiculos    
                    System.out.println(rentacar.getCatVehiculo());
                    break;
                case "2":// si es la opcion 2 mostraremos lista de clientes
                    System.out.println(rentacar.getCatCliente());
                    break;
                case "3": // si es la opcion 3 mostraremos lista de Alquileres
                    if (rentacar.getCatAlquiler().getNumeroAlquileres()==0){
                        System.out.println("""
                                           NO HAY ALQUILERES ACTUALMENTE
                                           """);
                    } else {
                        System.out.println(rentacar.getCatAlquiler());
                        
                    }
                            
                    break;
                case "4": // si es la opcion 4 se llamara al método que da de alta a un cliente
                    darAltaCliente(rentacar);
                    break;
                case "5": // si es la opcion 5 se llamara al método que da de alta a un vehiculo
                    darAltaVehiculos(rentacar);
                    break;
                case "6": // si es la opcion 6 se llamara al método para registrar un alquiler
                    resgistrarAlquiler(rentacar); 
                    break;
                default:
                    System.out.println("Adios!");;
            }
            // se sale del programa si se introduce un 7
        } while (!opcion.equals("7"));

    }

    private static String menu() {
        // se crea un menú con 7 opciones y solo te dejará introducir un valor válido
        String opcion = "";
        do {
            try {
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
                opcion=teclado.nextLine();
                if (!opcion.equals("1")
                        && !opcion.equals("2")
                        && !opcion.equals("3")
                        && !opcion.equals("4")
                        && !opcion.equals("5")
                        && !opcion.equals("6")
                        && !opcion.equals("7")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Debe ser una opcion del menú");
            }

        } while (!opcion.equals("1")
                && !opcion.equals("2")
                && !opcion.equals("3")
                && !opcion.equals("4")
                && !opcion.equals("5")
                && !opcion.equals("6")
                && !opcion.equals("7"));

        return opcion;
    }

    // método para pedir un dato
    private static String pedirDato(String texto) {
        System.out.println(texto);
        return teclado.nextLine();
    }

    // método para dar de alta un cliente
    private static void darAltaCliente(Empresa empresa) {
        System.out.println("********************** DAR DE ALTA CLIENTE **********************");
        String nombre = pedirDato("Nombre: ");
        String apellido = pedirDato("Apellido: ");
        String nif = pedirDato("Nif: ");
        empresa.addCliente(nif, nombre, apellido);
        System.out.println("""
                           Se ha añadido un cliente correctamente
                           Nombre: %s
                           Apellido: %s
                           Nif: %s
                           """.formatted(nombre,apellido, nif));
    }

    // método para dar de alta un vehiculo
    private static void darAltaVehiculos(Empresa empresa) {
        System.out.println("********************** DAR DE ALTA VEHICULO **********************");
        String bastidor = pedirDato("Bastidor del coche: ");
        String matricula = pedirDato("Cual es su matricula: ");
        empresa.addVehiculo(bastidor, matricula);
        // si no se introducen datos se crean de forma aleatoria
        System.out.println("""
                           Se ha añadido un cliente correctamente
                           Bastidor: %s
                           Matricula: %s
                           """.formatted(empresa.buscarVehiculo(bastidor).getBastidor(), 
                                   empresa.buscarVehiculo(bastidor).getMatricula()));
    }

    // método para registrar un vehiculo
    private static void resgistrarAlquiler(Empresa empresa) {
        System.out.println("********************** REGISTRAR ALQUILER **********************");
        LocalDate fecha = LocalDate.now();
        String bastidor="";
        String nif="";
        int dias = -1;
        do {
            try {
                // controlamos que el dato sea correcto sino devolvemos una excepcion
                String fechaString= pedirDato("Fecha del incio del alquiler: ");
                fecha = LocalDate.parse(fechaString);
            } catch (DateTimeParseException e) {
                System.out.println(e+"\n"+"Debe tener el siguiente formato YYYY-MM-DD");
                teclado.nextLine();
            }
        } while (fecha.isBefore(LocalDate.now()));
        
        do {
             // controlamos que el dato sea correcto sino devolvemos una excepcion
            bastidor= pedirDato("Bastidor del coche: ");
            if (empresa.buscarVehiculo(bastidor)==null) {
                System.out.println("El vehiculo no existe porfavor pon un bastidor válido");
            }
        } while (empresa.buscarVehiculo(bastidor)==null);
        
        do {
             // controlamos que el dato sea correcto sino devolvemos una excepcion
            nif = pedirDato("Nif del cliente: ");
            if (empresa.buscarCliente(nif)==null) {
                System.out.println("El cliente no existe porfavor pon un cliente válido");
            }
        } while ( empresa.buscarCliente(nif)==null);
        
        do {
            try {
                 // controlamos que el dato sea correcto sino devolvemos una excepcion
                dias = Integer.parseInt(pedirDato("Días de alquiler: "));
                if (dias<=0){
                throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {                    
                System.out.println(e+"\n"+"Dias debe ser un número entero y positivo");
                teclado.nextLine();
            }
        } while (dias < 0);
        // se registra y se muestra
        empresa.registrarAlquiler(fecha, bastidor, nif, dias);
        System.out.println("""
                           Se ha añadido el registro correctamente. 
                           Fecha: %s
                           Bastidor: %s
                           Nif: %s
                           Dias: %d
                           """.formatted(fecha,bastidor,nif,dias));
    }

}
