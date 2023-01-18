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
/*
++*++
+***+
*****
boolean [][] arbol = new bolean [altura][altura+2]
contador=0;
for (int i = arbol.length; i >0 ; i--) {
            for (int j = 0; i < arbol[i].length; i++) {
            if(
            arbol[i][j];
            }
        }
        
        3+2/2=2.5 redondeando para arriba 3
*/
public class Arbol {
    public static void main(String[] args) {
        
        final int TRONCO=2;

        int copa = pedirNumero();
        imprimirArbol(crearArbol(copa, TRONCO));
        
        int tronco2=pedirNumero();
        int copa2=pedirNumero();
        imprimirArbol(crearArbol(copa2, tronco2));
        
    }
    public static int pedirNumero (){
        int altura=0;
        do {            
            try {
               altura = Integer.parseInt(JOptionPane.showInputDialog("Que altura tiene la copa del arbol?"));
               if (altura<2||altura>10) {
                   throw new Exception();
               }
               return altura;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser un número entero y positivo entre 2 y 10");
            }
        } while (altura<2||altura>10);
    return altura;
    }
    
    public static int [][] crearArbol (int copa, int tronco) {
    int [][] arbol = new int [copa+tronco][copa+tronco+(copa-tronco-1)];
        int contador=0;
        //for (int i = arbol.length-1; i>=0; i--) {
        for (int i = arbol.length-1; i>=arbol.length-1-tronco; i--) {
            arbol[i][arbol[i].length/2]=1;
        
        }
        for (int i = arbol.length-1-tronco; i>=0; i--) {
            for (int j = 0+contador; j < arbol[i].length-contador; j++) {
                arbol[i][j]=1;
            }
            contador++;
        }
        return arbol;
    }
    
    public static void imprimirArbol (int [][] arbol){
    String tmp="";
        for (int i = 0; i < arbol.length; i++) {
            for (int j = 0; j < arbol[i].length; j++) {
                int numero= arbol[i][j];
                if(numero==0){
                    tmp+=" ";
                } else {
                    tmp+=numero;
                }
                
                
            }
            tmp+="\n";
        }
        System.out.println(tmp);
    }
}
