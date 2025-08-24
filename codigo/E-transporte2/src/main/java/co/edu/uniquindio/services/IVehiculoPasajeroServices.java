package co.edu.uniquindio.services;

import co.edu.uniquindio.model.VehiculoPasajero;

public interface IVehiculoPasajeroServices {

    boolean agregarVehiculoPasajero(String placa,
                                    String modelo,
                                    String marca,
                                    String color,
                                    int numeroMaximoPasajeros);

    VehiculoPasajero obtenerVehiculoPasajero(String placa);

    boolean eliminarVehiculoPasajero(String placa);

    boolean actualizarVehiculoPasajero (String placa,
                                        String modelo,
                                        String marca,
                                        String color,
                                        int numeroMaximoPasajeros);

}
