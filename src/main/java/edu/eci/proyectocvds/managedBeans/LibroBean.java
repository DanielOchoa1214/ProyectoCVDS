package edu.eci.proyectocvds.managedBeans;

import edu.eci.proyectocvds.entities.*;
import edu.eci.proyectocvds.services.ServiceType;
import edu.eci.proyectocvds.services.ServicesFactory;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "libro")
@SessionScoped
public class LibroBean {

    ServiciosLibroImpl service = (ServiciosLibroImpl) new ServicesFactory<>().setService(ServiceType.LIBRO);
    boolean success = false;
    Genero generoLibro;
    EstadoRecurso estadoRecurso;
    List<Recurso> searchedRecursos = new ArrayList<>(Arrays.asList(new Libro("Test", "Pasillo 2", "Academico", 3, "123", "Holi", 10, 15, "DISPONIBLE", "Test", true, 1000)));
    Libro booking = (Libro) searchedRecursos.get(0);
    RecurrenciaReserva recurrenciaReserva;

    // String name, String location, TipoRecurso type, int capacity, String id, String bookingScheduleStart, String bookingScheduleEnd
    public boolean saveLibro(String name, String location, String capacity, String id, String info,
                          String bookingScheduleStart, String bookingScheduleEnd, String autor,
                          boolean hardCover, String pages) throws Exception{
        try {
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            int start =  bookingScheduleStart.equals("") ? 0 : Integer.parseInt(bookingScheduleStart);
            int end = bookingScheduleEnd.equals("") ? 0 : Integer.parseInt(bookingScheduleEnd);
            int pageNum = pages.equals("") ? 0 : Integer.parseInt(pages);
            String smallName = name.toLowerCase();
            String buildId = id;
            for(int i = 0; i < cap; i++){
                Libro inserting = new Libro(smallName, location, generoLibro.toString(), cap, buildId, info, start, end,
                        estadoRecurso.toString(), autor, hardCover, pageNum);
                success = service.save(inserting);
                buildId = createNewId(buildId);
            }
            return success;
        } catch (Exception e){
            e.printStackTrace();
            success = false;
            return false;
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
            searchedRecursos =  service.loadResource(lowerName, location, generoLibro, cap);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateRecursoState(String id) throws Exception{
        try {
            service.updateResourceState(id, this.estadoRecurso);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Recurso> getSearchedRecursos() {
        return searchedRecursos;
    }

    public Genero getGeneroLibro() {
        return generoLibro;
    }

    public void setGeneroLibro(Genero genero) {
        this.generoLibro = genero;
    }

    public Genero[] getGenerosLibro(){
        return Genero.values();
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