package edu.eci.proyectocvds.services;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Recurso;

import java.util.List;

public interface ServiciosLibro {
    public void saveNewBook(String name, String location, Genero genre, int capacity, String id, String info,
                            int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState,
                            String author, boolean hardCover, int pages) throws ExcepcionServiciosRecurso;
    public List<Recurso> loadResource(String name, String location, Genero genre, int capacity) throws ExcepcionServiciosRecurso;
    public void updateResourceState(String id, EstadoRecurso estadoRecurso) throws ExcepcionServiciosRecurso;
}
