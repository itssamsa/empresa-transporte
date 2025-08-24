package co.edu.uniquindio.services;

public interface IModelFactoryServices extends IPropietarioServices{

    String buscarVehiculoCargaPlaca(String placa);
    String buscarPropietarioNombre(String nombre);

    boolean agregarVehiculoPasajero(String placa, String modelo, String marca, String color, int capacidad);

    boolean obtenerVehiculoPasajero(String placa);

    boolean eliminarVehiculoPasajero(String placa);

    boolean actualizarVehiculoPasajero(String placaActual, String placaNueva, String modelo, String marca, String color, int capacidad);
}
