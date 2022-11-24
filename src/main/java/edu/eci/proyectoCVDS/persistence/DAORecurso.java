package edu.eci.proyectoCVDS.persistence;

import edu.eci.proyectoCVDS.entities.EstadoRecurso;
import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

public interface DAORecurso {
    void saveRecurso(String name, String location, TipoRecurso type, int capacity, String id, String info, int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState) throws PersistenceException;

    List<Recurso> loadResource(String name, String location, TipoRecurso type, int capacity) throws PersistenceException;

    void updateResourceState(String id, EstadoRecurso estadoRecurso) throws PersistenceException;
}
