package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
    private String nombre;

    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();

    public EmpresaTransporte() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VehiculoCarga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }

    public void setListaVehiculosCarga(List<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }

    public List<VehiculoPasajero> getListaVehiculosPasajeros() {
        return listaVehiculosPasajeros;
    }

    public void setListaVehiculosPasajeros(List<VehiculoPasajero> listaVehiculosPasajeros) {
        this.listaVehiculosPasajeros = listaVehiculosPasajeros;
    }

    public List<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(List<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    public void crearPropietarioVehiculoCarga(String propietario, String vehiculo) {
        Propietario propietarioObj = new Propietario();
        propietarioObj.setNombre(propietario);
        VehiculoCarga vehiculoObj = new VehiculoCarga();
        vehiculoObj.setPlaca(vehiculo);
        propietarioObj.setVehiculo(vehiculoObj);
        listaPropietarios.add(propietarioObj);
    }
    //------------------------
    //a
    public void propietariosMayorPeso(double peso) {
        for (Propietario propietario : listaPropietarios) {
            Vehiculo vehiculo = propietario.getVehiculo();
            for (VehiculoCarga vehiculoCarga : listaVehiculosCarga) {
                if (vehiculo != null &&
                        vehiculo.getPlaca() != null &&
                        vehiculo.getPlaca().equals(vehiculoCarga.getPlaca()) &&
                        vehiculoCarga.getCapacidadCarga() > peso) {

                    System.out.println(propietario.getNombre());
                }
            }
        }
    }
    //b
    public void numUsuariosPlaca(String placa) {
        for (VehiculoPasajero vehiculo : listaVehiculosPasajeros) {
            if (vehiculo.getPlaca().equals(placa)) {
                System.out.println(vehiculo.getNumeroMaximoPasajeros());
                return;
            }
        }
    }
    //c
    public void propietariosMayores40() {
        int contador = 0;
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getEdad() > 40) {
                contador++;
            }
        }
        System.out.println("Número de propietarios mayores de 40: " + contador);
    }
}

