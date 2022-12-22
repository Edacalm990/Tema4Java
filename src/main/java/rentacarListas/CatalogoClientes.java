/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentacarListas;

/**
 *
 * @author eli
 */
// clase catalogoClientes
public class CatalogoClientes extends Catalogo<ClienteEnum>{

       public CatalogoClientes(int tam) {
        super(tam);
        for (int i = 0; i < tam; i++) {
            this.anadirElemento(new ClienteEnum());
        }
    }



    // método que busca a un cliente llamando al método que encuentra la posicion y devuelve al cliente
    public ClienteEnum buscarCliente(String nif) {
        ClienteEnum aux = new ClienteEnum();
        aux.setNif(nif);
        int posicion = buscarPosicionElemento(aux);
        ClienteEnum resultado = (posicion >= 0) ? this.lista.get(posicion): null;
        return resultado;
    }
    

}
