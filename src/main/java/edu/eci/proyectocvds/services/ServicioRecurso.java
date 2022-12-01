package edu.eci.proyectocvds.services;

import edu.eci.proyectocvds.managedBeans.TipoBusqueda;

import java.util.List;

public interface ServicioRecurso<T> {
    boolean save(T recurso) throws ExcepcionServiciosRecurso;
    List<T> load(String name, String location, TipoBusqueda type, int capacity) throws ExcepcionServiciosRecurso;
}
