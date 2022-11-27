package edu.eci.proyectocvds.services;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.GuiceServletContextListener;
import edu.eci.proyectocvds.entities.Libro;
import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.persistence.DAORecurso;
import edu.eci.proyectocvds.persistence.mybatisimpl.MyBatisDAOLibro;
import edu.eci.proyectocvds.persistence.mybatisimpl.MyBatisDAOPortatil;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;
import edu.eci.proyectocvds.services.impl.ServiciosPortatilImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;


public class SetUpInjector extends GuiceServletContextListener {
    private Injector injector;

    public SetUpInjector(){
        injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config.xml");
                bind(new TypeLiteral<DAORecurso<Libro>>(){}).to(MyBatisDAOLibro.class);
                bind(new TypeLiteral<DAORecurso<Portatil>>(){}).to(MyBatisDAOPortatil.class);
                bind(new TypeLiteral<ServicioRecurso<Libro>>(){}).to(ServiciosLibroImpl.class);
                bind(new TypeLiteral<ServicioRecurso<Portatil>>(){}).to(ServiciosPortatilImpl.class);
            }
        });
    }

    public Injector getInjector() {
        return injector;
    }
}
