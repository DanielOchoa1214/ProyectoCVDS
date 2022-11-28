package edu.eci.proyectocvds.services.impl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.managedBeans.TipoBusqueda;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;

import java.util.List;

public class ServiciosLibroImpl implements ServicioRecurso<Libro> {

    DAORecurso<Libro> daoLibro;

    @Inject
    public ServiciosLibroImpl(DAORecurso<Libro> daoLibro){
        this.daoLibro = daoLibro;
    }

    public List<Libro> loadResource(String name, String location, TipoBusqueda genre, int capacity) throws ExcepcionServiciosRecurso {
        try {
            return daoLibro.load(name, location, genre, capacity);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    public void updateResourceState(String id, EstadoRecurso estadoRecurso) throws ExcepcionServiciosRecurso{
        try {
            daoLibro.updateResourceState(id, estadoRecurso);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public boolean save(Libro recurso) throws ExcepcionServiciosRecurso {
        try {
            return daoLibro.save(recurso);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Libro> load(String name, String location, TipoBusqueda type, int capacity) throws ExcepcionServiciosRecurso {
        try {
            return daoLibro.load(name, location, type, capacity);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public boolean update(Libro recurso) {
        return false;
    }
}
