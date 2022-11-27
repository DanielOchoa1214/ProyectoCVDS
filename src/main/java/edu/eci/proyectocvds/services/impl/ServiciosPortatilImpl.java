package edu.eci.proyectocvds.services.impl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;

public class ServiciosPortatilImpl implements ServicioRecurso<Portatil> {

    DAORecurso<Portatil> daoPortatil;

    @Inject
    public ServiciosPortatilImpl(DAORecurso<Portatil> daoPortatil){
        this.daoPortatil = daoPortatil;
    }

    @Override
    public boolean save(Portatil recurso) throws ExcepcionServiciosRecurso {
        try {
            return daoPortatil.saveRecurso(recurso);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public Portatil load(Portatil recurso) {
        return null;
    }

    @Override
    public boolean update(Portatil recurso) {
        return false;
    }
}
