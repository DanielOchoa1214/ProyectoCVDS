package edu.eci.proyectocvds.persistence;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Recurso;

import java.util.List;

public interface DAORecurso<T> {
    boolean saveRecurso(T recurso) throws PersistenceException;

    List<T> loadResource(String name, String location, Genero genre, int capacity) throws PersistenceException;

    void updateResourceState(String id, EstadoRecurso estadoRecurso) throws PersistenceException;
}
