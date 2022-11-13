package edu.eci.proyectoCVDS.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.proyectoCVDS.entities.TipoRecurso;
import edu.eci.proyectoCVDS.persistence.DAORecurso;
import edu.eci.proyectoCVDS.persistence.PersistenceException;
import edu.eci.proyectoCVDS.persistence.mybatisimpl.mappers.RecursoMapper;

import java.sql.Date;

public class MyBatisDAORecurso implements DAORecurso {

    @Inject
    RecursoMapper recursoMapper;

    @Override
    public void saveRecurso(String name, String location, TipoRecurso type, int capacity, String id, Date bookingScheduleStart, Date bookingScheduleEnd) throws PersistenceException {
        try{
            recursoMapper.setNewRecurso(name, location, type, capacity, id, bookingScheduleStart, bookingScheduleEnd);
        }
        catch(Exception e){
            throw new PersistenceException("Error al consultar los pacientes:"+e.getLocalizedMessage(), e);
        }
    }
}
