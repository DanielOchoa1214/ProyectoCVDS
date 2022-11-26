package edu.eci.proyectocvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.persistence.DAOLibro;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.persistence.mybatisimpl.mappers.LibroMapper;

import java.util.List;

public class MyBatisDAOLibro implements DAOLibro {

    @Inject
    LibroMapper recursoMapper;

    @Override
    public void saveLibro(String name, String location, Genero genre, int capacity, String id, String info,
                          int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState, String author,
                          boolean hardCover, int pages) throws PersistenceException {
        try{
            recursoMapper.setNewLibro(name, location, genre, capacity, id, info, bookingScheduleStart, bookingScheduleEnd, resourceState, author, hardCover, pages);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Recurso> loadResource(String name, String location, Genero genre, int capacity) throws PersistenceException {
        try{
            return recursoMapper.getResource(name, location, genre, capacity);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void updateResourceState(String id, EstadoRecurso estadoRecurso) throws PersistenceException {
        try{
            recursoMapper.updateResourceState(id, estadoRecurso);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }
}
