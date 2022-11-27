package edu.eci.proyectocvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.persistence.mybatisimpl.mappers.LibroMapper;

import java.util.List;

public class MyBatisDAOLibro implements DAORecurso<Libro> {

    @Inject
    LibroMapper recursoMapper;

    @Override
    public boolean saveRecurso(Libro recurso) throws PersistenceException {
        try{
            recursoMapper.setNewLibro(recurso);
            return true;
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Libro> loadResource(String name, String location, Genero genre, int capacity) throws PersistenceException {
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
