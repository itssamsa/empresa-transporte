package co.edu.uniquindio.factory;

import co.edu.uniquindio.model.EmpresaTransporte;
import co.edu.uniquindio.model.Propietario;
import co.edu.uniquindio.model.VehiculoCarga;
import co.edu.uniquindio.services.IModelFactoryServices;

//patron singleton
public class ModelFactory implements IModelFactoryServices {
    private static ModelFactory instance;

    EmpresaTransporte empresaTransporte;

    private ModelFactory() {
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public EmpresaTransporte inicializarDatos() {
        empresaTransporte = new EmpresaTransporte();

        // Crear propietarios
        Propietario propietario1 = new Propietario();
        propietario1.setNombre("Pedro");
        propietario1.setNumeroIdentificacion("978978798");

        Propietario propietario2 = new Propietario();
        propietario2.setNombre("Ana");
        propietario2.setNumeroIdentificacion("234242323");

        // Crear vehículos de carga
        VehiculoCarga vehiculoCarga1 = new VehiculoCarga();
        vehiculoCarga1.setPlaca("RRD098");
        vehiculoCarga1.setNumeroEjes(5);

        VehiculoCarga vehiculoCarga2 = new VehiculoCarga();
        vehiculoCarga2.setPlaca("XXX096");
        vehiculoCarga2.setNumeroEjes(3);

        VehiculoCarga vehiculoCarga3 = new VehiculoCarga();
        vehiculoCarga3.setPlaca("77X096");
        vehiculoCarga3.setNumeroEjes(5);

        // Asociar propietario con vehículos
        propietario1.setVehiculo(vehiculoCarga1);
        propietario1.getListaVehiculosAsociados().add(vehiculoCarga2);
        propietario1.getListaVehiculosAsociados().add(vehiculoCarga3);
        propietario2.setVehiculo(vehiculoCarga2);

        // Agregar a empresa
        empresaTransporte.getListaPropietarios().add(propietario1);
        empresaTransporte.getListaPropietarios().add(propietario2);

        empresaTransporte.getListaVehiculosCarga().add(vehiculoCarga1);
        empresaTransporte.getListaVehiculosCarga().add(vehiculoCarga2);
        empresaTransporte.getListaVehiculosCarga().add(vehiculoCarga3);

        return empresaTransporte;
    }

    public EmpresaTransporte getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void crearPropietarioVehiculoCarga(String propietario, String vehiculo) {
        getEmpresaTransporte().crearPropietarioVehiculoCarga(propietario, vehiculo);
    }

    @Override
    public String buscarVehiculoCargaPlaca(String placa) {
        return empresaTransporte.buscarVehiculoCargaPlaca(placa);
    }

    @Override
    public String buscarPropietarioNombre(String nombre) {
        return empresaTransporte.buscarPropietarioNombre(nombre);
    }

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular) {
        return empresaTransporte.agregarPropietario(nombre, numeroIdentificacion, email, numeroCelular);
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) {
        return null;
    }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) {
        return false;
    }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion, String email, String numeroCelular) {
        return false;
    }

    @Override
    public boolean agregarVehiculoPasajero(String placa, String modelo, String marca, String color, int capacidad) {
        return false;
    }

    @Override
    public boolean obtenerVehiculoPasajero(String placa) {
        return false;
    }

    @Override
    public boolean eliminarVehiculoPasajero(String placa) {
        return false;
    }

    @Override
    public boolean actualizarVehiculoPasajero(String placaActual, String placaNueva, String modelo, String marca, String color, int capacidad) {
        return false;
    }


    public boolean agregarVehiculoCarga(String placa, String modelo, String marca, String color, double capacidadCar){
        VehiculoCarga v = new VehiculoCarga(placa, modelo, marca, color, capacidadCar);
        return empresaTransporte.agregarVehiculoCarga(v);
    }

}


