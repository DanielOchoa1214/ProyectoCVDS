package edu.eci.proyectoCVDS.persistence.mybatisimpl.mappers;

import edu.eci.proyectoCVDS.entities.TipoRecurso;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;

public interface RecursoMapper {
    void setNewRecurso(@Param("name") String name, @Param("location") String location, @Param("type") TipoRecurso type,
                       @Param("capacity")int capacity, @Param("id") String id, @Param("bookingScheduleStart") Date bookingScheduleStart,
                       @Param("bookingScheduleEnd") Date bookingScheduleEnd);
}
