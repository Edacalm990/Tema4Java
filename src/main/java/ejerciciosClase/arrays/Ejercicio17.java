/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arrays;

import java.util.stream.IntStream;
import javax.swing.JOptionPane;

/**
 *
 * @author eli
 */
// Implementa un programa que lea un String, lo pase a minúscula, lo introduzca en un array de caracteres 
//y ordene dicho array siguiendo el orden Unicode (a<b<c<d...).
public class Ejercicio17 {
    public static void main(String[] args) {
        

    }
    
    public static void ordenarCaracteres (){
//        palabra.toLowerCase();
//        IntStream p = palabra.codePoints();
//        int [] arrayCarcateresUnicode = p.sorted().toArray();
        String palabra=JOptionPane.showInputDialog("Dame una palabra");
        int [] numerosUnicode= palabra.toLowerCase().codePoints().sorted().toArray();
        char [] caracteresUnicode;
        for (int i = 0; i < numerosUnicode.length; i++) {
           palabra+=(char)numerosUnicode[i];  
        }
    }
}
