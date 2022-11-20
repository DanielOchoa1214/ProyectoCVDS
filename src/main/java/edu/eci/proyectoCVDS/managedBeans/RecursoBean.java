package edu.eci.proyectoCVDS.managedBeans;

import edu.eci.proyectoCVDS.entities.EstadoRecurso;
import edu.eci.proyectoCVDS.entities.Recurso;
import edu.eci.proyectoCVDS.entities.TipoRecurso;
import edu.eci.proyectoCVDS.services.ServiciosRecursoFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "mb")
@SessionScoped
public class RecursoBean {

    TipoRecurso tipoRecurso;
    EstadoRecurso estadoRecurso;
    List<Recurso> searchedRecursos = new ArrayList<>(Arrays.asList(new Recurso("Test", "Pasillo 2", "Academico", 3, "123", 10, 15, "DISPONIBLE")));

    // String name, String location, TipoRecurso type, int capacity, String id, String bookingScheduleStart, String bookingScheduleEnd
    public void saveRecurso(String name, String location, String capacity, String id, String bookingScheduleStart, String bookingScheduleEnd) throws Exception{
        try {
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            int start =  bookingScheduleStart.equals("") ? 0 : Integer.parseInt(bookingScheduleStart);
            int end = bookingScheduleEnd.equals("") ? 0 : Integer.parseInt(bookingScheduleEnd);
            ServiciosRecursoFactory.getInstance().getForumsServices().saveNewResource(name, location, tipoRecurso, cap, id, start, end, estadoRecurso);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loadRecurso(String name, String location, String capacity) throws Exception{
        try {
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            String lowerName = name.toLowerCase();
            searchedRecursos =  ServiciosRecursoFactory.getInstance().getForumsServices().loadResource(lowerName, location, tipoRecurso, cap);
            System.out.println(searchedRecursos);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateRecursoState(String id) throws Exception{
        try {
            ServiciosRecursoFactory.getInstance().getForumsServices().updateResourceState(id, this.estadoRecurso);
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

    public EstadoRecurso getEstadoRecurso() {
        return estadoRecurso;
    }

    public void setEstadoRecurso(EstadoRecurso estadoRecurso) {
        this.estadoRecurso = estadoRecurso;
    }

    public EstadoRecurso[] getEstadosRecurso(){
        return EstadoRecurso.values();
    }
}
