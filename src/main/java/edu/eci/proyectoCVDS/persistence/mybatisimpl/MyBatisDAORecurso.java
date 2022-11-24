package edu.eci.proyectoCVDS.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.proyectoCVDS.entities.EstadoRecurso;
import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;
import edu.eci.proyectoCVDS.persistence.DAORecurso;
import edu.eci.proyectoCVDS.persistence.PersistenceException;
import edu.eci.proyectoCVDS.persistence.mybatisimpl.mappers.RecursoMapper;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

public class MyBatisDAORecurso implements DAORecurso {

    @Inject
    RecursoMapper recursoMapper;

    @Override
    public void saveRecurso(String name, String location, TipoRecurso type, int capacity, String id, String info, int bookingScheduleStart, int bookingScheduleEnd, EstadoRecurso resourceState) throws PersistenceException {
        try{
            recursoMapper.setNewRecurso(name, location, type, capacity, id, info, bookingScheduleStart, bookingScheduleEnd, resourceState);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Recurso> loadResource(String name, String location, TipoRecurso type, int capacity) throws PersistenceException {
        try{
            return recursoMapper.getResource(name, location, type, capacity);
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
