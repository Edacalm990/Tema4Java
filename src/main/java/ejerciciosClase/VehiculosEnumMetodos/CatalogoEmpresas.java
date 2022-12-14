/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosClase.VehiculosEnumMetodos;

import java.util.Arrays;

/**
 *
 * @author eli
 */
//registrarEmpresas
//registrarVehiculos
//buscarCliente(nif)
//buscarVehiculo(bastidor)
public class CatalogoEmpresas {

    private int numeroEmpresas;
    private Empresa[] listaEmpresas;

    public CatalogoEmpresas(int tamanio) {
        tamanio = Math.abs(tamanio);
        this.numeroEmpresas = tamanio;
        this.listaEmpresas = new Empresa[tamanio];
    }

    public String toString() {
        String tmp = "";
        for (Empresa v : listaEmpresas) {
            if (v != null) {
                tmp += v.toString() + "\n";
            }
        }
        return tmp;
    }

    public void registrarEmpresa(String cif, String nombre) {
        Empresa aux = new Empresa(cif, nombre);
        if (listaEmpresas.length > numeroEmpresas) {
            for (int i = 0; i < listaEmpresas.length; i++) {
                if (listaEmpresas[i] == null) {
                    numeroEmpresas++;
                    listaEmpresas[i] = aux;
                    break;
                }
            }
        } else {
            this.listaEmpresas = Arrays.copyOf(listaEmpresas, listaEmpresas.length * 2);
            registrarEmpresa(cif, nombre);
        }
    }

    public void resgistrarVehiculo(String cif, String bastidor) {
        Empresa aux = new Empresa(cif, "aux");

        for (int i = 0; i < listaEmpresas.length; i++) {
            if (listaEmpresas[i].equals(aux)) {
                listaEmpresas[i].addVehiculo(bastidor);
                break;
            };
        }
    }
    
        public void resgistrarCliente(String cif, String nif) {
        Empresa aux = new Empresa(cif, "aux");

        for (int i = 0; i < listaEmpresas.length; i++) {
            if (listaEmpresas[i].equals(aux)) {
                listaEmpresas[i].addCliente(nif);
                break;
            };
        }
    }

    public VehiculoEnum buscarVehiculo(String bastidor) {
        VehiculoEnum aux = new VehiculoEnum();
        for (int i = 0; i < listaEmpresas.length; i++) {
            if (listaEmpresas[i] != null && listaEmpresas[i].buscarVehiculo(bastidor) != null) {
                aux = listaEmpresas[i].buscarVehiculo(bastidor);
                break;
            }
        }
        return aux;
    }

    public ClienteEnum buscarCliente(String nif) {
        ClienteEnum aux = new ClienteEnum();
        for (int i = 0; i < listaEmpresas.length; i++) {
            if (listaEmpresas[i] != null && listaEmpresas[i].buscarCliente(nif) != null) {
                aux = listaEmpresas[i].buscarCliente(nif);
                break;
            }
            
        }
        return aux;
    }

}
