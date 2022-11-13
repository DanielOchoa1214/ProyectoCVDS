package edu.eci.proyectoCVDS.services;

import edu.eci.proyectoCVDS.entities.TipoRecurso;

import java.sql.Date;

public interface ServiciosRecurso {
    public void saveNewResource(String name, String location, TipoRecurso type, int capacity, String id, Date bookingScheduleStart, Date bookingScheduleEnd) throws ExcepcionServiciosRecurso;
}
