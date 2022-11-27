package edu.eci.proyectocvds.services;

public interface ServicioRecurso<T> {
    boolean save(T recurso) throws ExcepcionServiciosRecurso;
    T load(T recurso);
    boolean update(T recurso);
}
