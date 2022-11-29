package edu.eci.proyectocvds.test.ServicesTest.LibroServicesTest;

import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;

public class LibroServiceSaveTest {

    @Mock
    DAORecurso<Libro> daoLibroTest;

    ServicioRecurso<Libro> serviciosLibro;

    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
        serviciosLibro = new ServiciosLibroImpl(daoLibroTest);
    }

    /*
     * Clases de equivalencia
     * Que el recurso guarde
     * Que el recurso ya exista
     */

    @Test
    public void given_DataBook_when_NoExist_then_SaveCorrectly() {
        try {
            //ARRANGE
            Libro libro = new Libro("1234", "1", "Academico", 2, "123", "1234",
                    1, 2, "DISPONIBLE", "yo", false, 1);
            Mockito.when(daoLibroTest.save(libro)).thenReturn(true);
            //ACT
            boolean test = serviciosLibro.save(libro);
            //ASSERT
            assertTrue(test);
        } catch (PersistenceException | ExcepcionServiciosRecurso e) {
            throw new RuntimeException(e);
        }
    }

    @Test(expected = ExcepcionServiciosRecurso.class)
    public void given_DataBook_when_Exist_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso{
            Libro libro = new Libro("1234", "1", "Academico", 2, "123", "1234",  1, 2,
                    "DISPONIBLE", "yo", false, 1);
            Mockito.when(daoLibroTest.save(libro)).thenThrow(new PersistenceException("Ya_Existe"));
            //ACT
            boolean test = serviciosLibro.save(libro);
            //ASSERT
    }
}
