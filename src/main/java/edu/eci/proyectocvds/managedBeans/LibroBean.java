package edu.eci.proyectocvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.*;
import edu.eci.proyectocvds.services.SetUpInjector;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "libroMB")
@SessionScoped
public class LibroBean {

    @Inject
    ServiciosLibroImpl service;
    boolean success = false;
    Genero generoLibro;
    EstadoRecurso estadoRecurso;
    List<Libro> searchedRecursos;
    Libro booking;
    RecurrenciaReserva recurrenciaReserva;
    TipoBusqueda tipoBusqueda;
    boolean searchingBooks = false;
    public LibroBean(){
        service = new SetUpInjector().getInjector().getInstance(ServiciosLibroImpl.class);
    }

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

    public boolean loadRecurso(String name, String location, String capacity) throws Exception{
        try {
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            updateSearchingBooks();
            String lowerName = name.toLowerCase();
            searchedRecursos =  service.loadResource(lowerName, location, tipoBusqueda, cap);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void updateRecursoState(String id) throws Exception{
        try {
            service.updateResourceState(id, this.estadoRecurso);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Libro> getSearchedRecursos() {
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

    public void setSearchedRecursos(List<Libro> searchedRecursos) {
        this.searchedRecursos = searchedRecursos;
    }

    public RecurrenciaReserva[] getRecurrenciasReserva() {
        return RecurrenciaReserva.values();
    }

    public TipoBusqueda getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(TipoBusqueda tiposBusqueda) {
        this.tipoBusqueda = tiposBusqueda;
    }

    private void updateSearchingBooks(){
        searchingBooks = tipoBusqueda.equals(TipoBusqueda.Libro) || tipoBusqueda.equals(TipoBusqueda.Todo);
    }

    public boolean isSearchingBooks() {
        return searchingBooks;
    }

    public TipoBusqueda[] getTiposBusqueda() { return TipoBusqueda.values(); }

    public void test(String a){
        System.out.println(a);
    }
}
