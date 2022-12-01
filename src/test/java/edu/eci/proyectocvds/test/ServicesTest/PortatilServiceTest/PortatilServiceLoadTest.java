package edu.eci.proyectocvds.test.ServicesTest.PortatilServiceTest;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.managedBeans.TipoBusqueda;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;
import edu.eci.proyectocvds.services.impl.ServiciosPortatilImpl;
import org.apache.ibatis.jdbc.Null;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class PortatilServiceLoadTest {
    @Mock
    DAORecurso<Portatil> daoPortatilTest;

    ServicioRecurso<Portatil> serviciosPortatil;


    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
        serviciosPortatil = new ServiciosPortatilImpl(daoPortatilTest);
    }

    @Test
    public void given_DataPortatil_when_NoExistMatch_then_ReturnEmptyList() throws PersistenceException, ExcepcionServiciosRecurso {
            //ARRANGE
            Portatil portatil = new Portatil("1234", "1", 2, "1", "123", 1,  2,
                    "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
            ArrayList<Portatil> list = new ArrayList<>();
            list.add(portatil);
            Mockito.when(daoPortatilTest.load("1234", "pos1", TipoBusqueda.Portatil, 2)).thenReturn(list);
            //ACT
            List<Portatil> test = serviciosPortatil.load("124", "pos1", TipoBusqueda.Portatil, 2);
            //ASSERT
            assertEquals(0, test.size());
    }

    @Test
    public void given_DataBook_when_ExistMatch_then_ReturnList() throws PersistenceException, ExcepcionServiciosRecurso {
        //ARRANGE
        Portatil portatil_1 = new Portatil("124", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Portatil portatil_2 = new Portatil("12345", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        ArrayList<Portatil> list = new ArrayList<>();
        list.add(portatil_1);
        list.add(portatil_2);
        Mockito.when(daoPortatilTest.load("1234", "pos1", TipoBusqueda.Libro, 2)).thenReturn(list);
        //ACT
        List<Portatil> test = serviciosPortatil.load("1234", "pos1", TipoBusqueda.Libro, 2);
        //ASSERT
        assertEquals(2, test.size());
    }

    @Test(expected = ExcepcionServiciosRecurso.class)
    public void given_DataBook_when_IncorrectQuery_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso {
        //ARRANGE
        Portatil portatil = new Portatil("124", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        ArrayList<Portatil> list = new ArrayList<>();
        list.add(portatil);
        Mockito.when(daoPortatilTest.load("1234", "pos1", TipoBusqueda.Portatil, 2)).thenReturn(list);
        Mockito.when(daoPortatilTest.load("1234", "pos1", TipoBusqueda.Libro, 2)).thenThrow(new PersistenceException("Mal_Query"));
        //ACT
        List<Portatil> test = serviciosPortatil.load("1234", "pos1", TipoBusqueda.Libro, 2);
        //ASSERT
    }
}
