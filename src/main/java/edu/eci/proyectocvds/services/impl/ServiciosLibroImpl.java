package edu.eci.proyectocvds.services.impl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.errors.IntegrityException;
import edu.eci.proyectocvds.managedBeans.TipoBusqueda;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.errors.PersistenceException;
import edu.eci.proyectocvds.errors.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;

import java.util.List;

public class ServiciosLibroImpl implements ServicioRecurso<Libro> {

    DAORecurso<Libro> daoLibro;

    @Inject
    public ServiciosLibroImpl(DAORecurso<Libro> daoLibro){
        this.daoLibro = daoLibro;
    }

    @Override
    public boolean save(Libro recurso) throws ExcepcionServiciosRecurso, IntegrityException {
        try {
            if(validateSaveInput(recurso)){
                throw new IntegrityException(IntegrityException.DATOS_BAURA_ENTRADA_LIBROS);
            }
            return daoLibro.save(recurso);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso(ex.getLocalizedMessage(), ex);
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

    private boolean validateSaveInput(Libro recurso){
        return recurso.getName().equals("") || recurso.getLocation().equals("") || recurso.getId().equals("") ||
                recurso.getInfo().equals("") || recurso.getAuthor().equals("");
    }
}
