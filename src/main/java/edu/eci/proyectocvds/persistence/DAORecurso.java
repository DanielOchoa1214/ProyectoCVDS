package edu.eci.proyectocvds.persistence;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.entities.TipoRecurso;

import java.util.List;

public interface DAORecurso {
    void saveRecurso(String name, String location, TipoRecurso type, int capacity, String id, String info, int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState) throws PersistenceException;

    List<Recurso> loadResource(String name, String location, TipoRecurso type, int capacity) throws PersistenceException;

    void updateResourceState(String id, EstadoRecurso estadoRecurso) throws PersistenceException;
}
