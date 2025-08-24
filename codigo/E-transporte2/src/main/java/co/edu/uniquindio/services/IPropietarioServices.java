package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Propietario;

public interface IPropietarioServices {


    boolean agregarPropietario(String nombre,
                               String numeroIdentificacion,
                               String email,
                               String numeroCelular);

    Propietario obtenerPropietario(String numeroIdentificacion);

    boolean eliminarPropietario(String numeroIdentificacion);


    boolean actualizarPropietario(String nombre,
                                  String numeroIdentificacionActual,
                                  String numeroIdentificacion,
                                  String email,
                                  String numeroCelular);

}//oe sara entonces el usuario seria el pasajero, ni idea el muestra el diagrama en una diapo pero no se, y creo que el vehiculo de carga tambien debe de tener esas interfaces :(