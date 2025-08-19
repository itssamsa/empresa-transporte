package co.edu.uniquindio.factory;

import co.edu.uniquindio.model.EmpresaTransporte;
import co.edu.uniquindio.model.Propietario;
import co.edu.uniquindio.model.VehiculoCarga;
import co.edu.uniquindio.model.VehiculoPasajero;

//patron singleton
public class ModelFactory {
    private static ModelFactory instance;

    EmpresaTransporte empresaTransporte;

    private ModelFactory() {
    }

    public static ModelFactory getInstance() {
        if(instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public EmpresaTransporte inicializarDatos() {
        EmpresaTransporte empresa = new EmpresaTransporte();
        empresa.setNombre("La carreta");
        VehiculoCarga vehiculoCarga = new VehiculoCarga();
        vehiculoCarga.setCapacidadCarga(200);
        VehiculoCarga vehiculoCarga2 = new VehiculoCarga();
        vehiculoCarga2.setCapacidadCarga(500);
        VehiculoPasajero vehiculoPasajero = new VehiculoPasajero();
        vehiculoPasajero.setNumeroMaximoPasajeros(10);
        vehiculoPasajero.setPlaca("ABC123");
        Propietario propietario = new Propietario();
        propietario.setNombre("Pedro");
        propietario.setVehiculo(vehiculoCarga);
        propietario.getListaVehiculosAsociados().add(vehiculoCarga2);
        empresa.getListaVehiculosCarga().add(vehiculoCarga);
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero);
        empresa.getListaPropietarios().add(propietario);
        this.empresaTransporte = empresa;
        //a,b,c
        empresa.propietariosMayorPeso(300);
        empresa.numUsuariosPlaca("ABC123");
        empresa.propietariosMayores40();


        return empresa;
    }

    public EmpresaTransporte getEmpresaTransporte() {
        return empresaTransporte;
    }

    public void crearPropietarioVehiculoCarga(String propietario, String vehiculo) {
        getEmpresaTransporte().crearPropietarioVehiculoCarga(propietario, vehiculo);
    }

}