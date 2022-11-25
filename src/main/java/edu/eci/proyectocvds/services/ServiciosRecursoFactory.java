package edu.eci.proyectocvds.services;

import com.google.inject.Injector;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.mybatisimpl.MyBatisDAORecurso;
import edu.eci.proyectocvds.services.impl.ServiciosRecursoImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServiciosRecursoFactory {
    private static ServiciosRecursoFactory instance = new ServiciosRecursoFactory();

    private static Injector injector;

    private ServiciosRecursoFactory() {
        injector = createInjector(new XMLMyBatisModule() {
              @Override
              protected void initialize() {
                  install(JdbcHelper.MySQL);
                  setClassPathResource("mybatis-config.xml");
                  bind(ServiciosRecurso.class).to(ServiciosRecursoImpl.class);
                  bind(DAORecurso.class).to(MyBatisDAORecurso.class);
              }

          }
        );
    }

    public ServiciosRecurso getForumsServices() {
        return injector.getInstance(ServiciosRecurso.class);
    }

    public static ServiciosRecursoFactory getInstance() {
        return instance;
    }

    public static void main(String[] args) throws ExcepcionServiciosRecurso {
        //ServiciosRecursoFactory.getInstance().getForumsServices().saveNewResource("Test", "Test", TipoRecurso.Academico, 2, "123", LocalTime.NOON, LocalTime.MIDNIGHT);
    }

}
