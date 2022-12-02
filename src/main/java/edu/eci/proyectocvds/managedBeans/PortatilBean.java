package edu.eci.proyectocvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.errors.ExcepcionServiciosRecurso;
import edu.eci.proyectocvds.errors.IntegrityException;
import edu.eci.proyectocvds.setup.SetUpInjector;
import edu.eci.proyectocvds.services.impl.ServiciosPortatilImpl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "portatilMB")
@SessionScoped
public class PortatilBean {

    @Inject
    ServiciosPortatilImpl service;
    EstadoRecurso estadoRecurso;
    List<Portatil> searchedPortatiles;
    boolean success;
    boolean searchingPortatiles;

    public PortatilBean(){
        this.service = new SetUpInjector().getInjector().getInstance(ServiciosPortatilImpl.class);
        success = false;
        searchingPortatiles = false;
    }
    public boolean savePortatil(String name, String capacity, String id, String info,
                               String bookingScheduleStart, String bookingScheduleEnd, String ramModel, String hardDriveModel,
                               String processor, String screenResolution, String brand){
        try {
            int cap = (int) Double.parseDouble(capacity);
            int start =  bookingScheduleStart.equals("") ? 0 : Integer.parseInt(bookingScheduleStart);
            int end = bookingScheduleEnd.equals("") ? 0 : Integer.parseInt(bookingScheduleEnd);
            String smallName = name.toLowerCase();
            String buildId = id;
            for(int i = 0; i < cap; i++){
                Portatil inserting = new Portatil(smallName, "Pedir en ventanilla", cap, buildId, info, start, end, estadoRecurso.toString(), ramModel,
                        hardDriveModel, processor, screenResolution, brand);
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

    public boolean loadPortatil(String name, String tipoBusqueda, String location, String capacity){
        try{
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            updateSearchingPortatiles(TipoBusqueda.valueOf(tipoBusqueda));
            String lowerName = name.toLowerCase();
            searchedPortatiles =  service.load(lowerName, location, TipoBusqueda.valueOf(tipoBusqueda), cap);
            return true;
        }catch (Exception e){
            return sendFail(e);
        }
    }

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Portatil añadido correctamente"));
    }

    public void error(String err) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", err));
    }

    private boolean sendFail(Exception e){
        e.printStackTrace();
        success = false;
        return false;
    }

    private void updateSearchingPortatiles(TipoBusqueda tipoBusqueda){
        searchingPortatiles = tipoBusqueda.equals(TipoBusqueda.Portatil) || tipoBusqueda.equals(TipoBusqueda.Todo);
    }

    private String createNewId(String id){
        int idNumber = Integer.parseInt(id.split("-")[1]);
        idNumber++;
        return id.split("-")[0] + "-" + idNumber;
    }

    public List<Portatil> getSearchedPortatiles() {
        return searchedPortatiles;
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

    public boolean isSearchingPortatiles(){
        return this.searchingPortatiles;
    }

    public void setSearchingPortatiles(boolean searchingPortatiles) {
        this.searchingPortatiles = searchingPortatiles;
    }
}
