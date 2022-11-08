/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ejB;
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
        char [] ELEMENTOS= {'a','e','i','o','u','!','$','%','/', '&'};
        JOptionPane.showMessageDialog(null, secuencia(3, ELEMENTOS));
      

    }
    private static int pinMovil() {
        return Integer.parseInt(RandomStringUtils.randomNumeric(4));
    }
    private static String passwordSeguro(){
        return RandomStringUtils.randomAlphanumeric(8);
    }
    
    private static String secuencia(int n, char elementos){
        return RandomStringUtils.random(n, elementos);
    }
}
