/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

/**
 *
 * @author eli
 */

// nombre
//nif
//apellido
public class CatalogoClientes {
    private int numeroClientes;
    private ClienteEnum [] listaClientes;

    public CatalogoClientes(int tamanio) {
        tamanio = Math.abs(tamanio);
        this.numeroClientes=tamanio;
        this.listaClientes=new ClienteEnum[tamanio];
        
        for (int i = 0; i < listaClientes.length; i++) {
            this.listaClientes[i]=new ClienteEnum();
        }
        
    }
    
    public void mostrarClientes() {
        for (ClienteEnum cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
    }
    
    private int buscarCliente(ClienteEnum cliente) {
        for (int i = 0; i < listaClientes.length; i++) {
            if (listaClientes[i].equals(cliente)){
            return i;
            }; 
        }
        return -1;
    }

    public void borrarCliente(ClienteEnum cliente) {
        int posicion = buscarCliente(cliente);
        if (posicion!=-1) {
        listaClientes[posicion] =  null;
        numeroClientes--;
            System.out.println("Se ha borrado el cliente de la posicion " + posicion);
        }
    }
    
    private ClienteEnum [] copiarListaClientes (int tamanio){
        ClienteEnum [] listaNueva = new ClienteEnum[tamanio];
        for (int i = 0; i < listaClientes.length; i++) {
            listaNueva[i]= listaClientes[i];
            
        }
        
        return listaNueva;
    }
    
    public void addCliente (ClienteEnum cliente){
        if (numeroClientes<this.listaClientes.length) {
            for (int i = 0; i < listaClientes.length; i++) {
                if (listaClientes[i]==null) {
                listaClientes[i]=cliente;
                numeroClientes++;
                break;
                };
                
            }
        } else {
            copiarListaClientes(listaClientes.length*2);
            addCliente(cliente);
        }
    } 
}
