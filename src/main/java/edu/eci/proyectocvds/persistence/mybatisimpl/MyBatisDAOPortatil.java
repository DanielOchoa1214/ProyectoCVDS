package edu.eci.proyectocvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.errors.PersistenceException;
import edu.eci.proyectocvds.persistence.mybatisimpl.mappers.PortatilMapper;

import java.util.List;

public class MyBatisDAOPortatil implements DAORecurso<Portatil> {
    @Inject
    PortatilMapper portatilMapper;
    @Override
    public boolean save(Portatil recurso) throws PersistenceException {
        try{
            portatilMapper.setNewPortatil(recurso);
            return true;
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Portatil> load(Portatil recurso) throws PersistenceException {
        try{
            return portatilMapper.getResource(recurso);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }
}
