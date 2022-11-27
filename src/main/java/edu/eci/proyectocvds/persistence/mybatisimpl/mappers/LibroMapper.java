package edu.eci.proyectocvds.persistence.mybatisimpl.mappers;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LibroMapper {
    void setNewLibro(@Param("recurso") Recurso recurso);

    List<Recurso> getResource(@Param("name") String name, @Param("location") String location, @Param("genre") Genero genre,
                              @Param("capacity") int capacity);

    void updateResourceState(@Param("id") String id, @Param("estadoRecurso") EstadoRecurso estadoRecurso);
}
