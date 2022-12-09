package ejerciciosClase;

import java.util.Scanner;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author eli
 */
// ejercicio 1
// leer nº por teclado -> int
// Decir si es capicua
// int-> String
// String -> char []

public class Capicua {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String numeroString = String.valueOf(pedirNumero());
        char[] numerosChar = creaArrayChar(numeroString);
        // numeroString.toCharArray() forma fácil;
        boolean resultado = capicua(numerosChar);
        System.out.println("""
                           El número %s es capicua? %s
                           """.formatted(numeroString, 
                                   ((resultado)
                                           ? "Si es capicua"
                                           : "No es capicua")));
    }

    public static int pedirNumero() {
        int numero = -1;
        do {
            try {
                System.out.println("Dame un número");
                numero = teclado.nextInt();
                if (numero <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Debe ser un número enteo positivo mayor de 0");
                teclado.nextLine();
            }
        } while (numero <= 0);
        return numero;
    }

    public static char[] creaArrayChar(String texto) {
        char[] array = new char[texto.length()];
        for (int i = 0; i < texto.length(); i++) {
            array[i] = texto.charAt(i);
        }
        return array;
    }

    public static boolean capicua(char[] numerosChar) {
       
        for (int i = 0; i <numerosChar.length/2; i++) {
            if (numerosChar[i] != numerosChar[numerosChar.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
