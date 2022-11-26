package edu.eci.proyectocvds.services.impl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.persistence.DAOLibro;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServiciosLibro;

import java.util.List;

public class ServiciosLibroImpl implements ServiciosLibro {

    DAOLibro daoLibro;

    @Inject
    public ServiciosLibroImpl(DAOLibro daoLibro){
        this.daoLibro = daoLibro;
    }

    @Override
    public void saveNewBook(String name, String location, Genero genre, int capacity, String id, String info,
                            int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState,
                            String author, boolean hardCover, int pages) throws ExcepcionServiciosRecurso {
        try {
            daoLibro.saveLibro(name, location, genre, capacity, id, info, bookingScheduleStart, bookingScheduleEnd, resourceState, author, hardCover, pages);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Recurso> loadResource(String name, String location, Genero genre, int capacity) throws ExcepcionServiciosRecurso {
        try {
            return daoLibro.loadResource(name, location, genre, capacity);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void updateResourceState(String id, EstadoRecurso estadoRecurso) throws ExcepcionServiciosRecurso{
        try {
            daoLibro.updateResourceState(id, estadoRecurso);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }
}
