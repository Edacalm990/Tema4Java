/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

/**
 *
 * @author eli
 */
public class CatalogoAlquileres {
    

    private int numeroAlquileres;

    private Alquiler[] listaAlquileres;

    // constructor por defecto donde se le indica el tamaño
    public CatalogoAlquileres(int tamanio) {
        // lo ponemos en positivo por si acaso
        tamanio = Math.abs(tamanio);
        // ponemos el numero de clientes igual al tamaño
        this.numeroAlquileres = 0;
        // creamos la lista de clientes del tamaño correspondiente
        this.listaAlquileres = new Alquiler[tamanio];

        
    }

    public int getNumeroAlquileres() {
        return numeroAlquileres;
    }

    public String toString() {
        String tmp = "";
        for (Alquiler v : listaAlquileres) {
            if (v != null) {
                tmp += v.toString() + "\n";
            }
        }
        return tmp;
    }



    // método privado para buscar a un cliente
    private int buscar(Alquiler vehiculo) {
        if (vehiculo!= null) {
            for (int i = 0; i < listaAlquileres.length; i++) {
                // si no es null y su nif es igual devolverá la posicion
                if (listaAlquileres[i] != null && listaAlquileres[i].equals(vehiculo)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Alquiler buscarAlquiler(int id) {
        Alquiler aux = new Alquiler();
        aux.setAlquilerID(id);
        int posicion = buscar(aux);
       return (posicion >= 0) ? this.listaAlquileres[posicion] : null;
    }

    // borrará al cliente poniendo en su posicion null (llamando al método privado de buscar)
    public void borrarAlquiler(Alquiler alquiler) {
        int posicion = buscar(alquiler);
        if (posicion != -1) {
            listaAlquileres[posicion] = null;
            numeroAlquileres--;

        }
    }

    
    private Alquiler[] copiarListaAlquires(int tamanio) {
        // ponemos el tamaño en positivo por si acaso
        tamanio = Math.abs(tamanio);
        // comprueba el tamaño, si el tamaño no es mayor pone por lo menos el mismo tamaño que tenía
        int size = (tamanio > this.listaAlquileres.length) ? tamanio : this.listaAlquileres.length;
        // crea la lista nueva
        Alquiler[] listaNueva = new Alquiler[size];
        // copia a cada cliente
        for (int i = 0; i < listaAlquileres.length; i++) {
            listaNueva[i] = listaAlquileres[i];
        }

        return listaNueva;
    }

    // método que añade un cliente 
    public void addAlquiler(Alquiler alquiler) {
        // comprueba que la lista es suficientemente grande
        if (numeroAlquileres < this.listaAlquileres.length) {
            // busca la primera posición null, he puesto la búsqueda invertida porque es más probable que haya una posición disponible al final de la lista
            for (int i = listaAlquileres.length - 1; i >= 0; i--) {
                if (listaAlquileres[i] == null) {
                    listaAlquileres[i] = alquiler;
                    // los sout son solamente meramente informativos para mi, para saber que el código funciona correctamente
                    System.out.println("Se ha añadido un cliente en la posicion " + i);
                    numeroAlquileres++;
                    break;
                };

            }
            // si no es suficientemente grande, crea una lista el doble de grande y vuelve a llamar al método
        } else {
            this.listaAlquileres = copiarListaAlquires(listaAlquileres.length * 2);
            addAlquiler(alquiler);
        }
    }
}
