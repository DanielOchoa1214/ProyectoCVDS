package edu.eci.proyectocvds.services;

import com.google.inject.Injector;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.mybatisimpl.MyBatisDAOLibro;
import edu.eci.proyectocvds.persistence.mybatisimpl.MyBatisDAOPortatil;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;
import edu.eci.proyectocvds.services.impl.ServiciosPortatilImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServicesFactory<T> {

    private ServicioRecurso service;

    public ServicesFactory(){ /* Constructor solo para  */ }

    public ServicioRecurso setService(ServiceType serviceType){
        Injector injector;
        switch (serviceType){
            case LIBRO:
                injector = createInjector(new XMLMyBatisModule() {
                                              @Override
                                              protected void initialize() {
                                                  install(JdbcHelper.MySQL);
                                                  setClassPathResource("mybatis-config.xml");
                                                  bind(ServicioRecurso.class).to(ServiciosLibroImpl.class);
                                                  bind(DAORecurso.class).to(MyBatisDAOLibro.class);
                                              }

                                          }
                );
                service = injector.getInstance(ServicioRecurso.class);
                break;
            case PORTATIL:
                injector = createInjector(new XMLMyBatisModule() {
                                              @Override
                                              protected void initialize() {
                                                  install(JdbcHelper.MySQL);
                                                  setClassPathResource("mybatis-config.xml");
                                                  bind(ServicioRecurso.class).to(ServiciosPortatilImpl.class);
                                                  bind(DAORecurso.class).to(MyBatisDAOPortatil.class);
                                              }

                                          }
                );
                service = injector.getInstance(ServicioRecurso.class);
                break;
        }
        return service;
    }
}
