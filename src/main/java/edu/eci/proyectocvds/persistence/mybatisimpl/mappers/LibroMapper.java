package edu.eci.proyectocvds.persistence.mybatisimpl.mappers;

import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.managedbeans.TipoBusqueda;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LibroMapper {
    void setNewLibro(@Param("recurso") Libro recurso);

    List<Libro> getResource(@Param("recurso") Libro recurso);
}
