package edu.eci.proyectoCVDS.persistence;

import edu.eci.proyectoCVDS.entities.TipoRecurso;

import java.sql.Date;

public interface DAORecurso {
    void saveRecurso(String name, String location, TipoRecurso type, int capacity, String id, Date bookingScheduleStart, Date bookingScheduleEnd) throws PersistenceException;
}
