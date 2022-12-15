/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

/**
 *
 * @author eli
 */
// clase catalogoClientes
public class CatalogoClientes {

    // número de clientes disponibles
    private int numeroClientes;
    // lista de clientes
    private ClienteEnum[] listaClientes;

    // constructor por defecto donde se le indica el tamaño
    public CatalogoClientes(int tamanio) {
        // lo ponemos en positivo por si acaso
        tamanio = Math.abs(tamanio);
        // ponemos el numero de clientes igual al tamaño
        this.numeroClientes = tamanio;
        // creamos la lista de clientes del tamaño correspondiente
        this.listaClientes = new ClienteEnum[tamanio];

        // añadimos los clientes con el contructor por defecto que creará a los clientes de forma aleatoria
        for (int i = 0; i < listaClientes.length; i++) {
            this.listaClientes[i] = new ClienteEnum();
        }

    }

    public int getNumeroClientes() {
        return numeroClientes;
    }

    public String toString() {
        String tmp = "";
        for (ClienteEnum v : listaClientes) {
            if (v != null) {
                tmp += v.toString() + "\n";
            }
        }
        return tmp;
    }

    // método privado para buscar a un cliente
    private int buscar(ClienteEnum cliente) {
        if (cliente != null) {
            for (int i = 0; i < listaClientes.length; i++) {
                // si no es null y su nif es igual devolverá la posicion
                if (listaClientes[i] != null && listaClientes[i].equals(cliente)) {
                    return i;
                };
            }
        }
        return -1;
    }

    public ClienteEnum buscarCliente(String nif) {
        ClienteEnum aux = new ClienteEnum();
        aux.setNif(nif);
        int posicion = buscar(aux);
        if (posicion>=0 ){
        return this.listaClientes[posicion];
        } else {
        return null;
        }
        
    }

    // borrará al cliente poniendo en su posicion null (llamando al método privado de buscar)
    public void borrarCliente(ClienteEnum cliente) {
        int posicion = buscar(cliente);
        if (posicion != -1) {
            listaClientes[posicion] = null;
            numeroClientes--;
            // los sout son solamnete meramente informativos para mi, para saber que el código funciona correctamente
            System.out.println("Se ha borrado el cliente de la posicion " + posicion);
        }
    }

    // método para crear una lista nueva de un tamaño mayor y copiar los datos en la nueva lista
    private ClienteEnum[] copiarListaClientes(int tamanio) {
        // ponemos el tamaño en positivo por si acaso
        tamanio = Math.abs(tamanio);
        // comprueba el tamaño, si el tamaño no es mayor pone por lo menos el mismo tamaño que tenía
        int size = (tamanio > this.listaClientes.length) ? tamanio : this.listaClientes.length;
        // crea la lista nueva
        ClienteEnum[] listaNueva = new ClienteEnum[size];
        // copia a cada cliente
        for (int i = 0; i < listaClientes.length; i++) {
            listaNueva[i] = listaClientes[i];
        }

        return listaNueva;
    }

    // método que añade un cliente 
    public void addCliente(ClienteEnum cliente) {
        // comprueba que la lista es suficientemente grande
        if (numeroClientes < this.listaClientes.length) {
            // busca la primera posición null, he puesto la búsqueda invertida porque es más probable que haya una posición disponible al final de la lista
            for (int i = listaClientes.length - 1; i >= 0; i--) {
                if (listaClientes[i] == null) {
                    listaClientes[i] = cliente;
                    // los sout son solamente meramente informativos para mi, para saber que el código funciona correctamente
                    System.out.println("Se ha añadido un cliente en la posicion " + i);
                    numeroClientes++;
                    break;
                };

            }
            // si no es suficientemente grande, crea una lista el doble de grande y vuelve a llamar al método
        } else {
            this.listaClientes = copiarListaClientes(listaClientes.length * 2);
            addCliente(cliente);
        }
    }
}
