package edu.eci.proyectocvds.test.ServicesTest.PortatilServiceTest;

import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.errors.IntegrityException;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.errors.PersistenceException;
import edu.eci.proyectocvds.errors.ExcepcionServiciosRecurso;
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
    DAORecurso<Portatil> daoPortatilTest;

    ServicioRecurso<Portatil> serviciosPortatil;


    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
        serviciosPortatil = new ServiciosPortatilImpl(daoPortatilTest);
    }

    /*
     * Clases de equivalencia
     * Que el recurso guarde
     * Que el recurso ya exista
     * Que el recurso le falte algun atributo: name, location, id, info, ram, hard drive model, processor, screen resolution, brand
     */

    @Test
    public void given_Portatil_when_NoExist_then_SaveCorrectly() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        //ARRANGE
        Portatil portatil = new Portatil("1234", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
        assertTrue(test);
    }

    @Test(expected = ExcepcionServiciosRecurso.class)
    public void given_Portatil_when_Exist_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException{
        Portatil portatil = new Portatil("1234", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenThrow(new PersistenceException("Ya_Existe"));
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoName_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoLocation_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("asdf", "", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoId_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("asdf", "1", 2, "", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoInfo_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("", "1", 2, "1", "", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoRam_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("asdf", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "", "SSD 250GB","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoDrive_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("asdf", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "","Intel 9 12Gen", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoProcessor_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("asdf", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","", "1920x1080", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoResolution_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "", "Lenovo");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Portatil_when_NoBrand_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Portatil portatil = new Portatil("", "1", 2, "1", "123", 1,  2,
                "DISPONIBLE", "8GB RAM", "SSD 250GB","Intel 9 12Gen", "1920x1080", "");
        Mockito.when(daoPortatilTest.save(portatil)).thenReturn(true);
        //ACT
        boolean test = serviciosPortatil.save(portatil);
        //ASSERT
    }
}

