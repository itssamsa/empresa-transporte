package co.edu.uniquindio.model;

import co.edu.uniquindio.services.IEmpresaTransporteServices;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte implements IEmpresaTransporteServices {
    private String nombre;

    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();
    private List<Usuario> listaUsuarios = new ArrayList<>();

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

    public String buscarVehiculoCargaPlaca(String placa) {
        String resultado = "";
        for (VehiculoCarga vehiculo : getListaVehiculosCarga()) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                resultado = vehiculo.toString();
                break;
            }
        }

        return resultado;
    }

    //------------------------
    //a
    public List<Propietario> propietariosMayorPeso() {
        List<Propietario> resultado = new ArrayList<>();
        for (Propietario p : listaPropietarios) {
            if (p.getVehiculo() instanceof VehiculoCarga vc) {
                if (vc.getCapacidadCarga() > 5000) {
                    resultado.add(p);
                }
            }
        }
        return resultado;
    }

    //b
    public Integer numUsuariosPlaca(String placa) {
        for (VehiculoPasajero vehiculo : listaVehiculosPasajeros) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo.getNumeroMaximoPasajeros();
            }
        }
        return null;
    }

    //c
    public int propietariosMayores40() {
        int contador = 0;
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getEdad() > 40) {
                contador++;
            }
        }
        return contador;
    }

    //crud-propietario

    public String buscarPropietarioNombre(String nombre) {
        String resultado = "";
        for (Propietario propietario : getListaPropietarios()) {
            if (propietario.getNombre().equalsIgnoreCase(nombre)) {
                resultado = propietario.toString();
                break;
            }
        }

        return resultado;
    }

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular) {
        Propietario propietario = obtenerPropietario(numeroIdentificacion);
        if (propietario == null) {
            propietario = new Propietario();
            propietario.setNombre(nombre);
            propietario.setNumeroIdentificacion(numeroIdentificacion);
            propietario.setEmail(email);
            propietario.setNumeroCelular(numeroCelular);
            getListaPropietarios().add(propietario);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) {
        Propietario propietarioEncontrado = null;
        for (Propietario propietario : getListaPropietarios()) {
            if (propietario.getNumeroIdentificacion().equalsIgnoreCase(numeroIdentificacion)) {
                propietarioEncontrado = propietario;
                break;
            }
        }

        return propietarioEncontrado;
    }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) {
        Propietario propietario = obtenerPropietario(numeroIdentificacion);
        if (propietario != null) {
            getListaPropietarios().remove(propietario);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion, String email, String numeroCelular) {
        Propietario propietario = obtenerPropietario(numeroIdentificacionActual);
        if (propietario != null) {
            propietario.setNombre(nombre);
            propietario.setNumeroIdentificacion(numeroIdentificacion);
            propietario.setEmail(email);
            propietario.setNumeroCelular(numeroCelular);

            return true;
        } else {
            return false;
        }
    }

    //crud-veiculo pasajeros

    @Override
    public boolean agregarVehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximoPasajeros) {
        VehiculoPasajero vehiculo = obtenerVehiculoPasajero(placa);
        if (vehiculo == null) {
            vehiculo = new VehiculoPasajero(placa, modelo, marca, color, numeroMaximoPasajeros);
            listaVehiculosPasajeros.add(vehiculo);
            return true;
        }
        return false;
    }

    @Override
    public VehiculoPasajero obtenerVehiculoPasajero(String placa) {
        VehiculoPasajero vehiculoEncontrado = null;
        for (VehiculoPasajero vehiculo : listaVehiculosPasajeros) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoEncontrado = vehiculo;
                break;
            }
        }
        return vehiculoEncontrado;
    }

    @Override
    public boolean eliminarVehiculoPasajero(String placa) {
        VehiculoPasajero vehiculo = obtenerVehiculoPasajero(placa);
        if (vehiculo != null) {
            listaVehiculosPasajeros.remove(vehiculo);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarVehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximoPasajeros) {
        VehiculoPasajero vehiculo = obtenerVehiculoPasajero(placa);
        if (vehiculo != null) {
            vehiculo.setModelo(modelo);
            vehiculo.setMarca(marca);
            vehiculo.setColor(color);
            vehiculo.setNumeroMaximoPasajeros(numeroMaximoPasajeros);
            return true;
        }
        return false;
    }

    //crud-vehivuloCarga
    public boolean existeVehiculoCarga(String placa) {
        for (VehiculoCarga v : listaVehiculosCarga) {
            if (placa.equals(v.getPlaca())) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarVehiculoCarga(VehiculoCarga v) {
        boolean estado = existeVehiculoCarga(v.getPlaca());
        if (estado != true) {
            listaVehiculosCarga.add(v);
            return true;
        }
        return false;
    }

    public VehiculoCarga buscarObjetoVehiculoCarga(String placa) {
        for (VehiculoCarga v : listaVehiculosCarga) {
            if (placa.equals(v.getPlaca())) {
                return v;
            }
        }
        return null;
    }

    public boolean eliminarVehiculoCarga(String placa) {
        VehiculoCarga v = buscarObjetoVehiculoCarga(placa);
        if (v != null) {
            listaVehiculosCarga.remove(v);
            return true;
        }
        return false;
    }

    public boolean actualizarVehiculoCarga(String placaActual, String placa, String modelo, String marca, String color, double capacidadCarga, int NumeroEjes) {
        VehiculoCarga existeVehiculo = buscarObjetoVehiculoCarga(placaActual);
        if (existeVehiculo != null) {
            existeVehiculo.setPlaca(placa);
            existeVehiculo.setModelo(modelo);
            existeVehiculo.setMarca(marca);
            existeVehiculo.setColor(color);
            existeVehiculo.setCapacidadCarga(capacidadCarga);
            existeVehiculo.setNumeroEjes(NumeroEjes);

        }
        return false;
    }

    //crud-usuario
    public boolean existeUsuario(String id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarUsuario(Usuario u) {
        boolean estado = existeUsuario(u.getId());
        if (estado != true) {
            listaUsuarios.add(u);
            return true;
        }
        return false;
    }

    public Usuario buscarUsuario(String id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean eliminarUsuario(String id) {
        Usuario u = buscarUsuario(id);
        if (u != null) {
            listaUsuarios.remove(u);
            return true;
        }
        return false;
    }

    public boolean actualizarUsuario(String idActual, String id, int edad) {
        Usuario u = buscarUsuario(idActual);
        if (u != null) {
            u.setId((id));
            u.setEdad(edad);
            return true;
        }
        return false;
    }

}
