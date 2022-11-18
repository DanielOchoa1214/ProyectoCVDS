package edu.eci.proyectoCVDS.services;

import edu.eci.proyectoCVDS.entities.EstadoRecurso;
import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;

import java.time.LocalTime;
import java.util.List;

public interface ServiciosRecurso {
    public void saveNewResource(String name, String location, TipoRecurso type, int capacity, String id, int bookingScheduleStart, int bookingScheduleEnd) throws ExcepcionServiciosRecurso;
    public List<Recurso> loadResource(String name, String location, TipoRecurso type, int capacity) throws ExcepcionServiciosRecurso;
    public void updateResourceState(String id, EstadoRecurso estadoRecurso) throws ExcepcionServiciosRecurso;
}
