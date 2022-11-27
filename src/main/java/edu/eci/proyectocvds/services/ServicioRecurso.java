package edu.eci.proyectocvds.services;

import edu.eci.proyectocvds.entities.Recurso;

public interface ServicioRecurso<T> {
    boolean save(T recurso) throws ExcepcionServiciosRecurso;
    T load(T recurso);
    boolean update(T recurso);
}
