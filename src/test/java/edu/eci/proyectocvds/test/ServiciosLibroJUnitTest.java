package edu.eci.proyectocvds.test;


import edu.eci.proyectocvds.entities.Genero;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.entities.Recurso;
import edu.eci.proyectocvds.services.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.services.ServiciosLibro;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ServiciosLibroJUnitTest {
     @Test
     public void testingMockito() throws ExcepcionServiciosRecurso {
          try {
               //ARRANGE
               ServiciosLibro servicioRecursoTest = Mockito.mock(ServiciosLibro.class);
               Mockito.when(servicioRecursoTest.loadResource("Test", "Test location", Genero.Academico, 2))
                       .thenReturn(new ArrayList<>(Collections.singletonList(new Libro("Test", "Test location",
                               "Academico", 2, "ABC-123", "Información del Test", 10, 11,
                               "DISPONIBLE", "Test", true, 1000))));
               //ACT

               Recurso recursoTesting = new Libro("Test", "Test location", "Academico", 2,
                       "ABC-123", "Información del Test", 10, 11,
                       "DISPONIBLE", "Test", true, 1000);

               //ASSERT
               assertEquals(recursoTesting, servicioRecursoTest.loadResource("Test", "Test location", Genero.Academico, 2).get(0));
          } catch (ExcepcionServiciosRecurso e) {
               fail("Algo mal sucedio en la consulta" + e);
          }

     }
}
