package edu.eci.proyectocvds.persistence.mybatisimpl.mappers;

import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.managedbeans.TipoBusqueda;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PortatilMapper {
    void setNewPortatil(@Param("recurso") Recurso recurso);
    List<Portatil> getResource(@Param("name") String name, @Param("location") String location, @Param("type") TipoBusqueda type,
                               @Param("capacity") int capacity);
}
