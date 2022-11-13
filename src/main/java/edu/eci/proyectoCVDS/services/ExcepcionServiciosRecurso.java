package edu.eci.proyectoCVDS.services;

public class ExcepcionServiciosRecurso extends Exception {

    public ExcepcionServiciosRecurso() {
    }

    public ExcepcionServiciosRecurso(String message) {
        super(message);
    }

    public ExcepcionServiciosRecurso(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionServiciosRecurso(Throwable cause) {
        super(cause);
    }
}
