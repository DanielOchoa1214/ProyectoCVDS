package edu.eci.proyectoCVDS.persistence;

import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

public interface DAORecurso {
    void saveRecurso(String name, String location, TipoRecurso type, int capacity, String id, LocalTime bookingScheduleStart, LocalTime bookingScheduleEnd) throws PersistenceException;

    List<Recurso> loadResource(String name, String location, TipoRecurso type, int capacity) throws PersistenceException;
}
