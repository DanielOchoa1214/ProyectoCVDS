package edu.eci.proyectocvds.persistence.mybatisimpl.mappers;

import edu.eci.proyectocvds.entities.Recurso;
import org.apache.ibatis.annotations.Param;

public interface PortatilMapper {
    void setNewPortatil(@Param("recurso") Recurso recurso);
}
