package edu.eci.proyectocvds.services;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.entities.TipoRecurso;

import java.util.List;

public interface ServiciosRecurso {
    public void saveNewResource(String name, String location, TipoRecurso type, int capacity, String id, String info, int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState) throws ExcepcionServiciosRecurso;
    public List<Recurso> loadResource(String name, String location, TipoRecurso type, int capacity) throws ExcepcionServiciosRecurso;
    public void updateResourceState(String id, EstadoRecurso estadoRecurso) throws ExcepcionServiciosRecurso;
}
