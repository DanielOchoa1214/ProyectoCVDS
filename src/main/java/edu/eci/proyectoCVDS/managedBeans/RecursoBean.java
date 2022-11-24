package edu.eci.proyectoCVDS.managedBeans;

import edu.eci.proyectoCVDS.entities.*;
import edu.eci.proyectoCVDS.services.ServiciosRecursoFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.util.List;

@ManagedBean(name = "mb")
@SessionScoped
public class RecursoBean {

    TipoRecurso tipoRecurso;
    EstadoRecurso estadoRecurso;
    List<Recurso> searchedRecursos = new ArrayList<>(Arrays.asList(new Libro("Test", "Pasillo 2", "Academico", 3, "123", "Holi", 10, 15, "DISPONIBLE")));
    Libro booking = (Libro) searchedRecursos.get(0);
    RecurrenciaReserva recurrenciaReserva;

    // String name, String location, TipoRecurso type, int capacity, String id, String bookingScheduleStart, String bookingScheduleEnd
    public void saveRecurso(String name, String location, String capacity, String id, String info, String bookingScheduleStart, String bookingScheduleEnd) throws Exception{
        try {
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            int start =  bookingScheduleStart.equals("") ? 0 : Integer.parseInt(bookingScheduleStart);
            int end = bookingScheduleEnd.equals("") ? 0 : Integer.parseInt(bookingScheduleEnd);
            String buildId = id;
            for(int i = 0; i < cap; i++){
                String smallName = name.toLowerCase();
                ServiciosRecursoFactory.getInstance().getForumsServices().saveNewResource(smallName, location, tipoRecurso, cap, buildId, info, start, end, estadoRecurso);
                buildId = createNewId(id);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String createNewId(String id){
        int idNumber = Integer.parseInt(id.split("-")[1]);
        idNumber++;
        return id.split("-")[0] + "-" + idNumber;
    }

    public Recurso getBooking() {
        return booking;
    }

    public void setBooking(Libro booking) {
        this.booking = booking;
    }

    public void loadRecurso(String name, String location, String capacity) throws Exception{
        try {
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            String lowerName = name.toLowerCase();
            searchedRecursos =  ServiciosRecursoFactory.getInstance().getForumsServices().loadResource(lowerName, location, tipoRecurso, cap);
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

    public void saveReserva(LocalDate initialDate, LocalDate finalDate, String bookingUser, String userProgram, RecurrenciaReserva bookingRecurrence){
        try {
            Date sqlInitial = Date.valueOf(initialDate);
            Date sqlFinal = Date.valueOf(finalDate);
            // Date nextDate = recurrenciaReserva.equals(RecurrenciaReserva.UNICA_VEZ) ? null : getNextDate(initialDate, bookingRecurrence);
            //ServiciosRecursoFactory.getInstance().getForumsServices().saveReserva(booking.getId(), booking.getInfo(), Date.valueOf(LocalDate.now()), sqlInitial, sqlFinal, recurrenciaReserva, );
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getNextDate(LocalDate initialDate, RecurrenciaReserva bookingRecurrence){
        //return Date.valueOf(initialDate.plus());
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

    public RecurrenciaReserva getRecurrenciaReserva() {
        return recurrenciaReserva;
    }

    public void setRecurrenciaReserva(RecurrenciaReserva recurrenciaReserva) {
        this.recurrenciaReserva = recurrenciaReserva;
    }

    public void setSearchedRecursos(List<Recurso> searchedRecursos) {
        this.searchedRecursos = searchedRecursos;
    }

    public RecurrenciaReserva[] getRecurrenciasReserva() {
        return RecurrenciaReserva.values();
    }

}
