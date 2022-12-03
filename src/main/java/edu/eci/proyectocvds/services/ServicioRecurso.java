package edu.eci.proyectocvds.services;

import edu.eci.proyectocvds.errors.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.errors.IntegrityException;

import java.util.List;

public interface ServicioRecurso<T> {
    boolean save(T recurso) throws ExcepcionServiciosRecurso, IntegrityException;
    List<T> load(T recurso) throws ExcepcionServiciosRecurso;
}
