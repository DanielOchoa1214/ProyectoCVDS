package edu.eci.proyectocvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.errors.PersistenceException;
import edu.eci.proyectocvds.persistence.mybatisimpl.mappers.LibroMapper;

import java.util.List;

public class MyBatisDAOLibro implements DAORecurso<Libro> {

    @Inject
    LibroMapper libroMapper;

    @Override
    public boolean save(Libro recurso) throws PersistenceException {
        try{
            libroMapper.setNewLibro(recurso);
            return true;
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Libro> load(Libro recurso) throws PersistenceException {
        try{
            return libroMapper.getResource(recurso);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }
}
