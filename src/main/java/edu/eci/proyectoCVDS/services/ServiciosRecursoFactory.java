package edu.eci.proyectoCVDS.services;

import com.google.inject.Injector;
import edu.eci.proyectoCVDS.persistence.DAORecurso;
import edu.eci.proyectoCVDS.persistence.mybatisimpl.MyBatisDAORecurso;
import edu.eci.proyectoCVDS.services.impl.ServiciosRecursoImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServiciosRecursoFactory {
    private static ServiciosRecursoFactory instance = new ServiciosRecursoFactory();

    private static Injector injector;
    private static Injector testingInjector;

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

    public ServiciosRecurso getTestingForumServices() {
        return testingInjector.getInstance(ServiciosRecurso.class);
    }

    public static ServiciosRecursoFactory getInstance() {
        return instance;
    }

}
