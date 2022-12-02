package edu.eci.proyectocvds.managedbeans;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.*;
import edu.eci.proyectocvds.errors.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.errors.IntegrityException;
import edu.eci.proyectocvds.setup.SetUpInjector;
import edu.eci.proyectocvds.services.impl.ServiciosLibroImpl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "libroMB")
@SessionScoped
public class LibroBean {

    @Inject
    ServiciosLibroImpl service;
    boolean success ;
    Genero generoLibro;
    EstadoRecurso estadoRecurso;
    List<Libro> searchedLibros;
    Libro booking;
    TipoBusqueda tipoBusqueda;
    boolean searchingBooks;
    public LibroBean(){
        service = new SetUpInjector().getInjector().getInstance(ServiciosLibroImpl.class);
        success = true;
        searchingBooks = false;
    }

    public boolean saveLibro(String name, String location, String capacity, String id, String info,
                          String bookingScheduleStart, String bookingScheduleEnd, String autor,
                          boolean hardCover, String pages) throws Exception{
        try {
            int cap = (int) Double.parseDouble(capacity);
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
                info();
            }
            return success;
        } catch (IntegrityException | ExcepcionServiciosRecurso e){
            error(e.getMessage());
            return sendFail(e);
        }
    }
    public boolean loadLibro(String name, String tipoBusqueda, String location, String capacity){
        try {
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            updateSearchingBooks(TipoBusqueda.valueOf(tipoBusqueda));
            String lowerName = name.toLowerCase();
            searchedLibros =  service.load(lowerName, location, TipoBusqueda.valueOf(tipoBusqueda), cap);
            return true;
        } catch (Exception e){
            return  sendFail(e);
        }
    }

    private boolean sendFail(Exception e){
        e.printStackTrace();
        success = false;
        return false;
    }

    private String createNewId(String id){
        int idNumber = Integer.parseInt(id.split("-")[1]);
        idNumber++;
        return id.split("-")[0] + "-" + idNumber;
    }

    private void updateSearchingBooks(TipoBusqueda tipoBusqueda){
        searchingBooks = tipoBusqueda.equals(TipoBusqueda.LIBRO) || tipoBusqueda.equals(TipoBusqueda.TODO);
    }

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Libro añadido correctamente"));
    }

    public void error(String err) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", err));
    }

    public Recurso getBooking() {
        return booking;
    }

    public void setBooking(Libro booking) {
        this.booking = booking;
    }

    public List<Libro> getSearchedLibros() {
        return searchedLibros;
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

    public void setSearchedLibros(List<Libro> searchedLibros) {
        this.searchedLibros = searchedLibros;
    }

    public TipoBusqueda getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(TipoBusqueda tiposBusqueda) {
        this.tipoBusqueda = tiposBusqueda;
    }

    public boolean isSearchingBooks() {
        return searchingBooks;
    }

    public TipoBusqueda[] getTiposBusqueda() { return TipoBusqueda.values(); }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
