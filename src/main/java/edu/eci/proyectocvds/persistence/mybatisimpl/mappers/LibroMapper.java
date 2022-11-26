package edu.eci.proyectocvds.persistence.mybatisimpl.mappers;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LibroMapper {
    void setNewLibro(@Param("name") String name, @Param("location") String location, @Param("genre") Genero genre,
                     @Param("capacity")int capacity, @Param("id") String id, @Param("info") String info, @Param("bookingScheduleStart") int bookingScheduleStart,
                     @Param("bookingScheduleEnd") int bookingScheduleEnd, @Param("resourceState") EstadoRecurso resourceState,
                     @Param("author") String author, @Param("hardCover") boolean hardCover, @Param("pages") int pages);

    List<Recurso> getResource(@Param("name") String name, @Param("location") String location, @Param("genre") Genero genre,
                              @Param("capacity") int capacity);

    void updateResourceState(@Param("id") String id, @Param("estadoRecurso") EstadoRecurso estadoRecurso);
}
