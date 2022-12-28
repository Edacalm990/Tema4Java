/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

import java.time.LocalDate;

/**
 *
 * @author venganzaalchocolate
 */
public class Main {

    public static void main(String[] args) {
        Empresa rentacar = new Empresa("1234", "Rentacar");

        // mostrar vehiculos
        System.out.println(rentacar.getCatVehiculo());

        // mostrar clientes
        System.out.println(rentacar.getCatCliente());

        // mostrar alquileres, si no hay me muestra una frase para saber que ha funcionado correctamente
        if (rentacar.getCatAlquiler().getNumeroElementos() == 0) {
            System.out.println("""
                                           NO HAY ALQUILERES ACTUALMENTE
                                           """);
        } else {
            System.out.println(rentacar.getCatAlquiler());
        }

        // dar de alta un cliente, si existe el nif no añadirá al cliente, si no existe el nif en el catálogo lo añadirá
        System.out.println("""
                           Añadimos un cliente correctamente: %b
                           Añadimos un cliente con el mismo nif: %b
                           """.formatted(
                rentacar.addCliente("00000000v", "Pepe", "Martinez"),
                rentacar.addCliente("00000000v", "Pepito", "Martin")
        ));
        // mostrar lista de clientes con el cliente añadido
        System.out.println(rentacar.getCatCliente());
        // añadimos un par de vehiculos más a modo de variedad para las posteriores pruebas  
        rentacar.addCliente("11111111v", "Maria", "Martinez");
        rentacar.addCliente("22222222v", "Claudia", "Martinez");

        // dar de alta un vehiculo, solo he puesto matricula y bastidor por simplicidad pero se pueden añadir todos los demás atributos de la misma forma
        // y se comprueba que no se puede añadir un vehiculo que ya esté en el catálogo de vehiculos
        System.out.println("""
                           Añadimos un vehiculo correctamente: %b
                           Añadimos un vehiculo con el mismo bastidor: %b
                           """.formatted(
                rentacar.addVehiculo("0000", "abc000"),
                rentacar.addVehiculo("0000", "prueba")
        ));
        //mostrar lista de vehiculos con el vehiculo añadido
        System.out.println(rentacar.getCatVehiculo());

        // añadimos  vehiculos de más a modo de variedad para las posteriores pruebas  
        rentacar.addVehiculo("0001", "abc111");
        rentacar.addVehiculo("0002", "abc222");
        rentacar.addVehiculo("0003", "abc333");
        rentacar.addVehiculo("0004", "abc444");
        rentacar.addVehiculo("0005", "abc444");

        // registrar alquiler con el cliente y vehiculo que cabamaos de añadir
        System.out.println("""
                           Se ha registrado el alquiler correctamente con el bastidor incorrecto? %b
                           Se ha registrado el alquiler correctamente con el nif incorrecto? %b
                           Se ha registrado el alquiler correctamente con la fecha anterior al día de hoy? %b
                           Se ha registrado el alquiler correctamente con la duración de 0 o menos días? %b
                           Se ha registrado el alquiler correctamente con todos los parametros correctos? %b
                           Una vez que se ha registrado un alquiler se puede volver a registrar otro alquiler con el mismo vehiculo si no ha sido devuelto ? %b
                           """.formatted(
                rentacar.registrarAlquiler(LocalDate.now(), "bastidorIncorrecto", "00000000v", 3),
                rentacar.registrarAlquiler(LocalDate.now(), "0000", "nifIncorrecto", 3),
                rentacar.registrarAlquiler(LocalDate.of(1989, 12, 2), "0000", "00000000v", 3),
                rentacar.registrarAlquiler(LocalDate.now(), "0000", "00000000v", -2),
                rentacar.registrarAlquiler(LocalDate.now(), "0000", "00000000v", 3),
                rentacar.registrarAlquiler(LocalDate.now(), "0000", "00000000v", 4)
        ));

        //añadimos un par de alquileres más a modo de variedad para  las posteriores pruebas
        rentacar.registrarAlquiler(LocalDate.now(), "0001", "11111111v", 2);
        rentacar.registrarAlquiler(LocalDate.now(), "0002", "11111111v", 3);
        rentacar.registrarAlquiler(LocalDate.now(), "0003", "22222222v", 2);
        rentacar.registrarAlquiler(LocalDate.now(), "0004", "22222222v", 3);

        // mostrar alquileres, para comprobar que se ha añadido correctamente
        if (rentacar.getCatAlquiler().getNumeroElementos() == 0) {
            System.out.println("""
                                           NO HAY ALQUILERES ACTUALMENTE
                                           """);
        } else {
            System.out.println(rentacar.getCatAlquiler());
        }

        // buscamos un alquiler por bastidor si es incorrecto devolverá un null sino devolverá el alquiler.
        System.out.println(
                """
                Alquiler con bastidor incorrecto: %s
                Alquiler con bastidor correcto:
                %s
                """.formatted(
                        rentacar.alquilerBastidor("bastidorIncorrecto"),
                        rentacar.alquilerBastidor("0000")
                )
        );

        // buscamos un alquiler por nif si es incorrecto devolverá un null sino devolverá el alquiler.
        System.out.println(
                """
                Alquiler con nif incorrecto: %s
                Alquiler con nif correcto:
                %s
                """.formatted(
                        rentacar.alquilerCliente("nifIncorrecto"),
                        rentacar.alquilerCliente("11111111v")
                )
        );

        
        // borramos un alquiler por id incorrecto (devolverá un false) y correcto (devolverá un true)
        // lo correcto creo yo sería poner un alquiler en finalizado en vez de borrarlo pero lo voy a dejar así por especificaciones del ejercicio
        System.out.println("""
                           Borramos un alquiler con un id incorrecto? %b
                           Borramos un alquiler con un id correcto? %b
                           Comprobamos que se ha borrado correctamente mostrando la lista de alquileres
                           %s
                           """.formatted(
                rentacar.borrarAlquiler(1287665),
                rentacar.borrarAlquiler(1),
                rentacar.getCatAlquiler()
        ));
        

        // Borrar un cliente del catálogo, si no tiene alquileres grabados con el nif.
        // Devolverá false si no existe el cliente o tiene alquileres
        // Hay una versión más abajo borrando a TODOS LOS CLIENTES QUE NO TIENEN ALQUILERES
        System.out.println("""
                           Vamos a eliminar a intentar eliminar a Maria con nif 11111111v que si tiene un alquiler
                           Se ha eliminado? %b
                           Vamos a intentar eliminar a un usuario que no existe con nif xxxx 
                           Se ha eliminado? %b
                           Vamos a eliminar un usuario que existe y no está en ningún alquiler
                           Se ha eliminado? %b
                           """.formatted(rentacar.borrarClienteSinAlquiler("11111111v"), 
                                   rentacar.borrarClienteSinAlquiler("xxx"),
                                   rentacar.borrarClienteSinAlquiler("00000000v")));

        // Borrar un vehículo del catálogo, si no tiene alquileres grabados.
        // Devolverá false si no existe el cliente o tiene alquileres
                System.out.println("""
                           Vamos a eliminar a intentar eliminar al vehiculo con bastidor 001 que si tiene un alquiler
                           Se ha eliminado? %b
                           Vamos a intentar eliminar a un vehiculo que no existe con xxxx 
                           Se ha eliminado? %b
                           Vamos a eliminar un vehiculo que existe y no está en ningún alquiler
                           Se ha eliminado? %b
                           """.formatted(rentacar.borrarVehiculoSinAlquiler("11111111v"), 
                                   rentacar.borrarVehiculoSinAlquiler("xxx"),
                                   rentacar.borrarVehiculoSinAlquiler("0005")));
        
        
        // Obtener la lista de vehículos que deben ser devueltos en una fecha dada.
        System.out.println("""
                           Probamos el método vehiculos que debmos delver dada una fecha
                           Con una fecha donde no haya que devolver nada, daría un null
                           01-01-2025 (debe salir un null)
                           %s
                           31-12-2022 (debe salir una lista con los vehiculos con bastidor 002 y 004)
                           %s
                           """.formatted(rentacar.vehiculosParaDevolver(LocalDate.of(2025, 01, 01)),
                                   rentacar.vehiculosParaDevolver(LocalDate.of(2022, 12, 31))));
        
        
        
        // AÑADIDOS MIOS NO PEDIDOS EN EL EJERCICIO        
        
        // mostrar solo alquileres activos es decir que no se haya devuelto el vehiculo
        // cuando se devuelva el vehiculo pondrá una fecha de fin y los días totales de alquiler
        // el vehiculo cambiará de estado a disponible 
        System.out.println("""
                           Vamos a devolver el vehiculo 0001
                           por tanto ya no se mostrará en alquileres activos
                           ---------- Antes de la devolucion ------------
                           ALQUILERES ACTIVOS:
                           %s
                           Devolvemos el vehiculo del alquiler 2 que tenia un bastidor 0001 = %b
                           ---------- Después de la devolucion ------------
                           ALQUILERES ACTIVOS:
                           %s
                           
                           Pero si se mostrará en total alquileres
                           --------- Todos los alquileres activos y no activos --------
                           ALQUILERES:
                           %s
                           
                           Como hemos devuelto el vehiculo podemos añadir un alquiler con ese vehiculo
                           Vehiculo añadido= %b
                           ALQUILERES ACTIVOS:
                           %s
                           """.formatted(
                rentacar.mostrarAlquileresActivos(),
                                   rentacar.recibirVehiculo(2, LocalDate.of(2023, 2, 2)),
                // en la terminal debería salir 36 días totales de alquiler y la fecha de finalizacio
                rentacar.mostrarAlquileresActivos(),
                rentacar.getCatAlquiler(),
                rentacar.registrarAlquiler(LocalDate.now(), "0001", "22222222v", 3),
                rentacar.mostrarAlquileresActivos()
                )
           );
         
        // En está parte creo que entendí mal el enunciado y cree un método para borrar a todos los clientes que no tuviesen un alquiler
        // He decidido dejarlo como método opcional
        // Te devuelve una lista con los clientes borrados
        System.out.println("""
                           -------------- LISTA DE CLIENTES BORRADOS QUE NO TENÍAN ALQUILERES ------------
                           %s
                           Comprobamos que ha funcioando mostrando la lista de clientes actual del catálogo
                           %s
                           """.formatted(rentacar.borrarClientesSinAlquiler(), rentacar.getCatCliente()));
    }

}
