package co.edu.uniquindio;

import co.edu.uniquindio.factory.ModelFactory;
import co.edu.uniquindio.model.EmpresaTransporte;
import co.edu.uniquindio.model.Propietario;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ModelFactory modelFactory = ModelFactory.getInstance();

        EmpresaTransporte empresa = modelFactory.inicializarDatos();

        // a
        System.out.println("1) Propietarios con vehículos de carga mayores a 5000kg:");
        List<Propietario> propietarios = empresa.propietariosMayorPeso();
        for (Propietario p : propietarios) {
            System.out.println(" - " + p.getNombre());
        }

        //b
        System.out.println("\n2) Número de propietarios mayores de 40 años:");
        System.out.println(empresa.propietariosMayores40());

        // c
        System.out.println("\n3) Máximo de pasajeros por placa (ejemplo: ABC123):");
        System.out.println(empresa.numUsuariosPlaca("ABC123"));
    }
}

