package edu.eci.proyectocvds.services.impl;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.entities.TipoRecurso;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServiciosRecurso;

import java.util.List;

public class ServiciosRecursoImpl implements ServiciosRecurso {

    @Inject
    DAORecurso daoRecurso;

    @Override
    public void saveNewResource(String name, String location, TipoRecurso type, int capacity, String id, String info, int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState) throws ExcepcionServiciosRecurso {
        try {
            daoRecurso.saveRecurso(name, location, type, capacity, id, info, bookingScheduleStart, bookingScheduleEnd, resourceState);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Recurso> loadResource(String name, String location, TipoRecurso type, int capacity) throws ExcepcionServiciosRecurso {
        try {
            return daoRecurso.loadResource(name, location, type, capacity);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void updateResourceState(String id, EstadoRecurso estadoRecurso) throws ExcepcionServiciosRecurso{
        try {
            daoRecurso.updateResourceState(id, estadoRecurso);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ ex.getLocalizedMessage(), ex);
        }
    }
}
