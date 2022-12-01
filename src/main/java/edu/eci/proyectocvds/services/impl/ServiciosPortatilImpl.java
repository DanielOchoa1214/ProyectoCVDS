package edu.eci.proyectocvds.services.impl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.managedBeans.TipoBusqueda;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;

import java.util.List;

public class ServiciosPortatilImpl implements ServicioRecurso<Portatil> {

    DAORecurso<Portatil> daoPortatil;

    @Inject
    public ServiciosPortatilImpl(DAORecurso<Portatil> daoPortatil){
        this.daoPortatil = daoPortatil;
    }

    @Override
    public boolean save(Portatil recurso) throws ExcepcionServiciosRecurso {
        try {
            return daoPortatil.save(recurso);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Portatil> load(String name, String location, TipoBusqueda type, int capacity) throws ExcepcionServiciosRecurso {
        try {
            return daoPortatil.load(name, location, type, capacity);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }
}
