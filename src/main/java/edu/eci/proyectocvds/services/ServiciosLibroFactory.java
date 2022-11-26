package edu.eci.proyectocvds.services;

import com.google.inject.Injector;
import edu.eci.proyectocvds.persistence.DAOLibro;
import edu.eci.proyectocvds.persistence.mybatisimpl.MyBatisDAOLibro;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServiciosLibroFactory {
    private static ServiciosLibroFactory instance = new ServiciosLibroFactory();

    private static Injector injector;

    private ServiciosLibroFactory() {
        injector = createInjector(new XMLMyBatisModule() {
              @Override
              protected void initialize() {
                  install(JdbcHelper.MySQL);
                  setClassPathResource("mybatis-config.xml");
                  bind(ServiciosLibro.class).to(ServiciosLibroImpl.class);
                  bind(DAOLibro.class).to(MyBatisDAOLibro.class);
              }

          }
        );
    }

    public ServiciosLibro getForumsServices() {
        return injector.getInstance(ServiciosLibro.class);
    }

    public static ServiciosLibroFactory getInstance() {
        return instance;
    }

    public static void main(String[] args) throws ExcepcionServiciosRecurso {
        //ServiciosRecursoFactory.getInstance().getForumsServices().saveNewResource("Test", "Test", TipoRecurso.Academico, 2, "123", LocalTime.NOON, LocalTime.MIDNIGHT);
    }

}
