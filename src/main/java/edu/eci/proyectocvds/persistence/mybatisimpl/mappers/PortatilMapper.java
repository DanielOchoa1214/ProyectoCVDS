package edu.eci.proyectocvds.persistence.mybatisimpl.mappers;

import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.managedbeans.TipoBusqueda;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PortatilMapper {
    void setNewPortatil(@Param("recurso") Portatil recurso);
    List<Portatil> getResource(@Param("recurso") Portatil recurso);
}
