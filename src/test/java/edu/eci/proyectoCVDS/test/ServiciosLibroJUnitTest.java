package edu.eci.proyectoCVDS.test;


import edu.eci.proyectoCVDS.entities.EstadoRecurso;
import edu.eci.proyectoCVDS.entities.Libro;
import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;
import edu.eci.proyectoCVDS.persistence.DAORecurso;
import edu.eci.proyectoCVDS.services.ExcepcionServiciosRecurso;
import edu.eci.proyectoCVDS.services.ServiciosRecurso;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ServiciosLibroJUnitTest {
     @Test
     public void testingMockito() throws ExcepcionServiciosRecurso {
          try {
               //ARRANGE
               ServiciosRecurso servicioRecursoTest = Mockito.mock(ServiciosRecurso.class);
               Mockito.when(servicioRecursoTest.loadResource("Test", "Test location", TipoRecurso.Academico, 2))
                       .thenReturn(new ArrayList<>(Collections.singletonList(new Libro("Test", "Test location",
                               "Academico", 2, "ABC-123", "Información del Test", 10, 11,
                               "DISPONIBLE"))));
               //ACT

               Recurso recursoTesting = new Libro("Test", "Test location", "Academico", 2,
                       "ABC-123", "Información del Test", 10, 11,
                       "DISPONIBLE");

               //ASSERT
               assertEquals(recursoTesting, servicioRecursoTest.loadResource("Test", "Test location", TipoRecurso.Academico, 2).get(0));
          } catch (ExcepcionServiciosRecurso e) {
               fail("Algo mal sucedio en la consulta" + e);
          }

     }
}
