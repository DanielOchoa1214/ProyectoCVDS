package edu.eci.proyectocvds.persistence;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Recurso;

import java.util.List;

public interface DAOLibro {
    void saveLibro(String name, String location, Genero genre, int capacity, String id, String info, int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState, String author, boolean hardCover, int pages) throws PersistenceException;

    List<Recurso> loadResource(String name, String location, Genero genre, int capacity) throws PersistenceException;

    void updateResourceState(String id, EstadoRecurso estadoRecurso) throws PersistenceException;
}
