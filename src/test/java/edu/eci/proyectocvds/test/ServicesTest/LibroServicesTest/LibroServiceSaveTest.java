package edu.eci.proyectocvds.test.ServicesTest.LibroServicesTest;

import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.errors.IntegrityException;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.errors.PersistenceException;
import edu.eci.proyectocvds.errors.ExcepcionServiciosRecurso;
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
     * Que el recurso no posea: name, author, location, genre, id, info
     */

    @Test
    public void given_Book_when_NoExist_then_SaveCorrectly() throws ExcepcionServiciosRecurso, IntegrityException, PersistenceException {
        //ARRANGE
        Libro libro = new Libro("1234", "1", "ACADEMICO", 2, "123", "1234",
                1, 2, "DISPONIBLE", "yo", false, 1);
        Mockito.when(daoLibroTest.save(libro)).thenReturn(true);
        //ACT
        boolean test = serviciosLibro.save(libro);
        //ASSERT
        assertTrue(test);
    }

    @Test(expected = ExcepcionServiciosRecurso.class)
    public void given_Book_when_Exist_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException{
        Libro libro = new Libro("1234", "1", "ACADEMICO", 2, "123", "1234",  1, 2,
                "DISPONIBLE", "yo", false, 1);
        Mockito.when(daoLibroTest.save(libro)).thenThrow(new PersistenceException("Ya_Existe"));
        //ACT
        boolean test = serviciosLibro.save(libro);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Book_When_NoName_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Libro libro = new Libro("", "1", "ACADEMICO", 2, "123", "1234",  1, 2,
                "DISPONIBLE", "yo", false, 1);
        Mockito.when(daoLibroTest.save(libro)).thenReturn(true);
        //ACT
        boolean test = serviciosLibro.save(libro);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Book_When_NoLocation_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Libro libro = new Libro("asdf", "", "ACADEMICO", 2, "123", "1234",  1, 2,
                "DISPONIBLE", "yo", false, 1);
        Mockito.when(daoLibroTest.save(libro)).thenReturn(true);
        //ACT
        boolean test = serviciosLibro.save(libro);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Book_When_NoId_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Libro libro = new Libro("asd", "1", "ACADEMICO", 2, "", "1234",  1, 2,
                "DISPONIBLE", "yo", false, 1);
        Mockito.when(daoLibroTest.save(libro)).thenReturn(true);
        //ACT
        boolean test = serviciosLibro.save(libro);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Book_When_NoInfo_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Libro libro = new Libro("asdf", "1", "ACADEMICO", 2, "123", "",  1, 2,
                "DISPONIBLE", "yo", false, 1);
        Mockito.when(daoLibroTest.save(libro)).thenReturn(true);
        //ACT
        boolean test = serviciosLibro.save(libro);
        //ASSERT
    }

    @Test(expected = IntegrityException.class)
    public void given_Book_When_NoAuthor_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso, IntegrityException {
        Libro libro = new Libro("asdf", "1", "ACADEMICO", 2, "123", "1234",  1, 2,
                "DISPONIBLE", "", false, 1);
        Mockito.when(daoLibroTest.save(libro)).thenReturn(true);
        //ACT
        boolean test = serviciosLibro.save(libro);
        //ASSERT
    }
}
