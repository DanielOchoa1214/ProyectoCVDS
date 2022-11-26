package edu.eci.proyectocvds.test;


import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.persistence.DAOLibro;
import edu.eci.proyectocvds.persistence.PersistenceException;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServiciosLibro;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ServiciosLibroJUnitTest {

     @Mock
     DAOLibro daoLibroTest;

     ServiciosLibroImpl serviciosLibro;

     @Before
     public void beforeTest(){
          MockitoAnnotations.initMocks(this);
          serviciosLibro = new ServiciosLibroImpl(daoLibroTest);
     }

     @Test
     public void testingMockito() throws ExcepcionServiciosRecurso {
          try {
               //ARRANGE
               Mockito.when(daoLibroTest.loadResource("Test", "Test", Genero.Academico, 2)).thenReturn(new ArrayList<>());

               //ACT
               List<Recurso> test = serviciosLibro.loadResource("Test", "Test", Genero.Academico, 2);

               //ASSERT
               assertEquals(test, new ArrayList<>());
          } catch (PersistenceException e) {
               throw new RuntimeException(e);
          }

     }
}
