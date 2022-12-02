package edu.eci.proyectocvds.test.ServicesTest.LibroServicesTest;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.managedBeans.TipoBusqueda;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.errors.PersistenceException;
import edu.eci.proyectocvds.errors.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServicioRecurso;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibroServiceUpdateTest {
    @Mock
    DAORecurso<Libro> daoLibroTest;

    ServicioRecurso<Libro> serviciosLibro;

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
        serviciosLibro = new ServiciosLibroImpl(daoLibroTest);
    }

    /*
     * Clases de equivalencia
     * No exista ningun recurso
     * Exista el recurso
     * Que falle el query
     */

    //@Test
    public void given_DataBook_when_NoExistLibro_then_ThrowException()  throws PersistenceException, ExcepcionServiciosRecurso {
            //ARRANGE
            Libro libro = new Libro("1234", "1", "ACADEMICO", 2, "123", "1234",
                    1, 2, "DISPONIBLE", "yo", false, 1);
            ArrayList<Libro> list = new ArrayList<>();
            list.add(libro);
            //Mockito.when(daoLibroTest.updateResourceState("1234", EstadoRecurso.DISPONIBLE).thenReturn(true);
            //ACT
            //List<Libro> test = serviciosLibro.update("124", "pos1", TipoBusqueda.Libro, 2);
            //ASSERT
            //assertEquals(0, test.size());
    }

    //@Test
    public void given_DataBook_when_ExistMatch_then_ReturnList() throws PersistenceException, ExcepcionServiciosRecurso {
        //ARRANGE
        Libro libro_1 = new Libro("1234", "pos1", "ACADEMICO", 2, "123", "1234",
                1, 2, "DISPONIBLE", "yo", false, 1);
        Libro libro_2 = new Libro("1234", "pos1", "ACADEMICO", 2, "123", "1234",
                1, 2, "DISPONIBLE", "yo", false, 1);
        ArrayList<Libro> list = new ArrayList<>();
        list.add(libro_1);
        list.add(libro_2);
        Mockito.when(daoLibroTest.load("1234", "pos1", TipoBusqueda.Libro, 2)).thenReturn(list);
        //ACT
        List<Libro> test = serviciosLibro.load("1234", "pos1", TipoBusqueda.Libro, 2);
        //ASSERT
        assertEquals(2, test.size());
    }

    //@Test(expected = ExcepcionServiciosRecurso.class)
    public void given_DataBook_when_IncorrectQuery_then_ThrowException() throws PersistenceException, ExcepcionServiciosRecurso {
        //ARRANGE
        Libro libro = new Libro("1234", "pos1", "ACADEMICO", 2, "123", "1234",
                1, 2, "DISPONIBLE", "yo", false, 1);
        ArrayList<Libro> list = new ArrayList<>();
        list.add(libro);
        Mockito.when(daoLibroTest.load("1234", "pos1", TipoBusqueda.Libro, 2)).thenReturn(list);
        Mockito.when(daoLibroTest.load("1234", "pos1", TipoBusqueda.Portatil, 2)).thenThrow(new PersistenceException("Mal_Query"));
        //ACT
        List<Libro> test = serviciosLibro.load("1234", "pos1", TipoBusqueda.Portatil, 2);
        //ASSERT
    }

}