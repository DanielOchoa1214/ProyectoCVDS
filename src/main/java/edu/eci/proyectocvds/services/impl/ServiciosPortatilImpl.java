package edu.eci.proyectocvds.services.impl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.errors.IntegrityException;
import edu.eci.proyectocvds.managedbeans.TipoBusqueda;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.errors.PersistenceException;
import edu.eci.proyectocvds.errors.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;

import java.util.List;

public class ServiciosPortatilImpl implements ServicioRecurso<Portatil> {

    DAORecurso<Portatil> daoPortatil;

    @Inject
    public ServiciosPortatilImpl(DAORecurso<Portatil> daoPortatil){
        this.daoPortatil = daoPortatil;
    }

    @Override
    public boolean save(Portatil recurso) throws ExcepcionServiciosRecurso, IntegrityException {
        try {
            if(validateSaveInput(recurso)){
                throw new IntegrityException(IntegrityException.DATOS_BAURA_ENTRADA_PORTATILES);
            }
            return daoPortatil.save(recurso);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Portatil> load(Portatil recurso) throws ExcepcionServiciosRecurso {
        try {
            return daoPortatil.load(recurso);
        } catch (Exception ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    private boolean validateSaveInput(Portatil recurso){
        return recurso.getName().equals("") || recurso.getLocation().equals("") || recurso.getId().equals("") ||
                recurso.getInfo().equals("") || recurso.getRam().equals("") || recurso.getHardDriveModel().equals("") ||
                recurso.getProcessor().equals("") || recurso.getScreenResolution().equals("") || recurso.getBrand().equals("");
    }
}
