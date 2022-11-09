/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejB;

import java.util.Arrays;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author elisabet
 */
// La aplicación tendrá tres opciones: 
//la primera, genera números pin aleatorios para tarjetas SIM de teléfonos móviles; 
//la segunda opción genera contraseñas para usuarios de un sistema operativo con 8 caracteres, incluyendo números y letras; 
//la tercera opción, genera una secuencia de "n" caracteres aleatorios de un conjunto que tú elijas 
//(debes pasar un array de char de 10 elementos). El número "n" se debe solicitar por teclado.
public class Password {

    public static void main(String[] args) {
        final char[] LISTACARACTERES = {'a', 'e', 'i', 'o', 'u', '!', '@', '#', '~', '½'};
        final String[] OPCIONES = {"pin", "password", "secuencia"};
        String opcion=null;
        // pedimos la opcion
        do {
            opcion = menuOpciones(OPCIONES);
            if (opcion != null) {
                String respuesta = switch (opcion) {
                    case "pin" ->
                        pinMovil();
                    case "password" ->
                        passwordSeguro();
                    case "secuencia" ->
                        secuencia(pedirNumeroIntEntreRangos(1, 50), LISTACARACTERES);
                    default ->
                        "Error";
                };
                JOptionPane.showMessageDialog(null, """
                                                %s -> %s
                                                """.formatted(opcion, respuesta));
            }
        } while (opcion != null);

    }

    private static String pinMovil() {
        return RandomStringUtils.randomNumeric(4);
    }

    private static String passwordSeguro() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    private static String secuencia(int n, char[] elementos) {
        return RandomStringUtils.random(n, elementos);
    }

    private static int pedirNumeroIntEntreRangos(int min, int max) {
        int numero = 0;
        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog("Cuantos caracteres quieres que tenga tu secuencia?"));

            } catch (NumberFormatException e) {
                JOptionPane.showConfirmDialog(null, """
                                                    Error: %s el dato introducido no es correcto
                                                    """.formatted(e));
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
        } while (!(numero >= min && numero <= max));
        return numero;
    }

    private static String menuOpciones(String [] opciones) {
        String opcion = "";
        do {
            opcion = JOptionPane.showInputDialog("""
                                       Escriba "%s" si desea generar un pin aleatorio
                                       Escriba "%s" si desea generar un password 
                                       Escirba "%s" si desea una secuencia
                                       """.formatted(opciones[0], opciones[1], opciones[2]));
            if (!Arrays.asList(opciones).contains(opcion) && opcion != null) {
                JOptionPane.showMessageDialog(null, "El opcion no es correcta");
            };
        } while (!(Arrays.asList(opciones).contains(opcion)) && opcion != null);

        return opcion;
    }
    
//    JOptionPane.showOptionDialog(null, "Mensaje ", //contenido de la ventana
//                         "Pregunta" , //titulo de la ventana
//                         JOptionPane.YES_NO_CANCEL_OPTION, //para 3 botones si/no/cancel
//                         JOptionPane.QUESTION_MESSAGE, //tipo de ícono
//                         null,    // null para icono por defecto.
//                         new Object[] { "SO", "ESPAÑOL", "2020"},//objeto para las opciones
//                         //null para YES, NO y CANCEL
//                         "SO"); //selección predeterminada

}
