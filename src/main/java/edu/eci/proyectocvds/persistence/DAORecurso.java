package edu.eci.proyectocvds.persistence;

import edu.eci.proyectocvds.errors.PersistenceException;
import edu.eci.proyectocvds.managedbeans.TipoBusqueda;

import java.util.List;

public interface DAORecurso<T> {
    boolean save(T recurso) throws PersistenceException;

    List<T> load(T recurso) throws PersistenceException;
}
