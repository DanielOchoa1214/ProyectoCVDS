package edu.eci.proyectoCVDS.managedBeans;

import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;
import edu.eci.proyectoCVDS.services.ServiciosRecursoFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "mb")
@SessionScoped
public class RecursoBean {

    TipoRecurso tipoRecurso;
    List<Recurso> searchedRecursos = new ArrayList<>(Arrays.asList(new Recurso("Test", "Pasillo 2", TipoRecurso.Academico, 3, "123", LocalTime.of(10, 0), LocalTime.of(15, 0))));

    // String name, String location, TipoRecurso type, int capacity, String id, String bookingScheduleStart, String bookingScheduleEnd
    public void saveRecurso(String name, String location, int capacity, String id, String bookingScheduleStart, String bookingScheduleEnd) throws Exception{
        try {
            LocalTime start = LocalTime.of(Integer.parseInt(bookingScheduleStart), 0);
            LocalTime end = LocalTime.of(Integer.parseInt(bookingScheduleEnd), 0);
            ServiciosRecursoFactory.getInstance().getForumsServices().saveNewResource(name, location, tipoRecurso, capacity, id, start, end);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadRecurso(String name, String location, int capacity) throws Exception{
        try {
            searchedRecursos =  ServiciosRecursoFactory.getInstance().getForumsServices().loadResource(name, location, tipoRecurso, capacity);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Recurso> getSearchedRecursos() {
        return searchedRecursos;
    }

    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(TipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public TipoRecurso[] getTiposRecurso(){
        return TipoRecurso.values();
    }
}
