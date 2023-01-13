/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.arraysMultidimensionales;

import javax.swing.JOptionPane;

/**
 *
 * @author eli
 */
public class Arbol {
    public static void main(String[] args) {
        int altura = Integer.parseInt(JOptionPane.showInputDialog("Que altura tiene la copa del arbol?"));
        int tronco = Integer.parseInt(JOptionPane.showInputDialog("Que altura tiene el tronco del arbol?"));
        int [][] arbol = new int [altura][altura+2];
        for (int i = 0; i < arbol.length; i++) {
            int[] is = arbol[i];
            
        }
        
    }
}
