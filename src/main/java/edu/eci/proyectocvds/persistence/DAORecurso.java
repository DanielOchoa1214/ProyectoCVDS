package edu.eci.proyectocvds.persistence;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.managedBeans.TipoBusqueda;

import java.util.List;

public interface DAORecurso<T> {
    boolean save(T recurso) throws PersistenceException;

    List<T> load(String name, String location, TipoBusqueda genre, int capacity) throws PersistenceException;

    void updateResourceState(String id, EstadoRecurso estadoRecurso) throws PersistenceException;
}
