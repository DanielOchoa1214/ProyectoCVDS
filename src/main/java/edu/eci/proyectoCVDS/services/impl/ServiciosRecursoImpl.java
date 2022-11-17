package edu.eci.proyectoCVDS.services.impl;

import com.google.inject.Inject;
import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;
import edu.eci.proyectoCVDS.persistence.DAORecurso;
import edu.eci.proyectoCVDS.persistence.PersistenceException;
import edu.eci.proyectoCVDS.services.ExcepcionServiciosRecurso;
import edu.eci.proyectoCVDS.services.ServiciosRecurso;

import java.time.LocalTime;
import java.util.List;

public class ServiciosRecursoImpl implements ServiciosRecurso {

    @Inject
    DAORecurso daoRecurso;

    @Override
    public void saveNewResource(String name, String location, TipoRecurso type, int capacity, String id, int bookingScheduleStart, int bookingScheduleEnd) throws ExcepcionServiciosRecurso {
        try {
            daoRecurso.saveRecurso(name, location, type, capacity, id, bookingScheduleStart, bookingScheduleEnd);
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
    public void saveReserva(String name, String location, TipoRecurso type, int capacity) throws ExcepcionServiciosRecurso {

    }
}
