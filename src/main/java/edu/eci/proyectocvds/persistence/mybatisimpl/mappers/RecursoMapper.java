package edu.eci.proyectocvds.persistence.mybatisimpl.mappers;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.entities.TipoRecurso;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecursoMapper {
    void setNewRecurso(@Param("name") String name, @Param("location") String location, @Param("type") TipoRecurso type,
                       @Param("capacity")int capacity, @Param("id") String id, @Param("info") String info, @Param("bookingScheduleStart") int bookingScheduleStart,
                       @Param("bookingScheduleEnd") int bookingScheduleEnd, @Param("resourceState") EstadoRecurso resourceState);

    List<Recurso> getResource(@Param("name") String name, @Param("location") String location, @Param("type") TipoRecurso type,
                              @Param("capacity") int capacity);

    void updateResourceState(@Param("id") String id, @Param("estadoRecurso") EstadoRecurso estadoRecurso);
}
