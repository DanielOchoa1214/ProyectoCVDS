package edu.eci.proyectocvds.test.ServicesTest.PortatilServiceTest;

import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;
import edu.eci.proyectocvds.services.impl.ServiciosPortatilImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;

public class PortatilServiceSaveTest {

    @Mock
    DAORecurso<Portatil> daoLibroTest;

    ServicioRecurso<Portatil> serviciosLibro;


    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
        serviciosLibro = new ServiciosPortatilImpl(daoLibroTest);
    }

    /**
     * Clases de equivalencia
     * Que el recurso guarde
     * Que el recurso ya exista
     */

    @Test
    public void given_DataPortatil_when_NoExist_then_SaveCorrectly() {
        try {
            //ARRANGE
            Portatil portatil = new Portatil("1234", "1", 2, "1", "123", 1,  2,
                    "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
            Mockito.when(daoLibroTest.saveRecurso(portatil)).thenReturn(true);
            //ACT
            boolean test = serviciosLibro.save(portatil);
            //ASSERT
            assertTrue(test);
        } catch (PersistenceException | ExcepcionServiciosRecurso e) {
            throw new RuntimeException(e);
        }
    }

    @Test(expected = ExcepcionServiciosRecurso.class)
    public void given_DataPortatil_when_Exist_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso{
        Portatil portatil = new Portatil("1234", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoLibroTest.saveRecurso(portatil)).thenThrow(new PersistenceException("Ya_Existe"));
        //ACT
        boolean test = serviciosLibro.save(portatil);
        //ASSERT
    }
}
