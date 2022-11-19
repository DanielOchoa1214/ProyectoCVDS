package edu.eci.proyectoCVDS.persistence.mybatisimpl.mappers;

import edu.eci.proyectoCVDS.entities.EstadoRecurso;
import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

public interface RecursoMapper {
    void setNewRecurso(@Param("name") String name, @Param("location") String location, @Param("type") TipoRecurso type,
                       @Param("capacity")int capacity, @Param("id") String id, @Param("bookingScheduleStart") int bookingScheduleStart,
                       @Param("bookingScheduleEnd") int bookingScheduleEnd, @Param("resourceState") EstadoRecurso resourceState);

    List<Recurso> getResource(@Param("name") String name, @Param("location") String location, @Param("type") TipoRecurso type,
                              @Param("capacity") int capacity);

    void updateResourceState(@Param("id") String id, @Param("estadoRecurso") EstadoRecurso estadoRecurso);
}
