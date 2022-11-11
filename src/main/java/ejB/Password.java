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
        // se declara e instancia 
        final char[] LISTACARACTERES = {'a', 'e', 'i', 'o', 'u', '!', '@', '#', '~', '½'};
        final String[] OPCIONES = {"pin", "password", "secuencia"};
        String opcion=null;
        
        
        do {
            // pedimos la opcion
            opcion = menuOpciones(OPCIONES);
            // si la opcion no es cancelar
            if (opcion != null) {
                String respuesta = switch (opcion) {
                    case "pin" ->
                        // genera números pin aleatorios de 4 digitos
                        pinMovil();
                    case "password" ->
                        // genera contraseñas para usuarios de un sistema operativo con 8 caracteres, incluyendo números y letras;
                        passwordSeguro();
                    case "secuencia" ->
                        // genera una secuencia de "n" caracteres aleatorios del conjunto LISTACARACTERES
                        secuencia(pedirNumeroIntEntreRangos(1, 50), LISTACARACTERES);
                    default ->
                        "Error";
                };
                // se muestra el resultado
                JOptionPane.showMessageDialog(null, """
                                                %s -> %s
                                                """.formatted(opcion, respuesta));
            }
            // se vuelve a ejectutar hasta que el usuario ponga cancelar
        } while (opcion != null);

    }

    private static String pinMovil() {
        // String random de 4 digitos
        return RandomStringUtils.randomNumeric(4);
    }
       
    private static String passwordSeguro() {
        // String random alphanumerico de 8 digitos
        return RandomStringUtils.randomAlphanumeric(8);
    }

    private static String secuencia(int n, char[] elementos) {
        // una secuencia de "n" caracteres aleatorios del conjunto LISTACARACTERES
        return RandomStringUtils.random(n, elementos);
    }

    private static int pedirNumeroIntEntreRangos(int min, int max) {
        int numero = 0;
        do {
            try {
                // se solicita el numero de caracteres
                numero = Integer.parseInt(JOptionPane.showInputDialog(
                        "Cuantos caracteres quieres que tenga tu secuencia?"));

            } catch (NumberFormatException e) {
                JOptionPane.showConfirmDialog(null, """
                                                    Error: %s el dato introducido no es correcto
                                                    """.formatted(e));
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            // se repite mientras no esté en el rango
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
                                       """.formatted(opciones[0], opciones[1], opciones[2])).toLowerCase();
            // si la opcion elegida  no esta en las opciones disponibles y no es cancelar
            if (!Arrays.asList(opciones).contains(opcion) && opcion != null) {
                JOptionPane.showMessageDialog(null, "El opcion no es correcta");
            };
            // se vuleve a solicitar si no esta en las opciones disponibles o no es cancelar
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
