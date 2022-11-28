package edu.eci.proyectocvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.proyectocvds.entities.EstadoRecurso;
import edu.eci.proyectocvds.entities.Portatil;
import edu.eci.proyectocvds.services.SetUpInjector;
import edu.eci.proyectocvds.services.impl.ServiciosPortatilImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "portatilMB")
@SessionScoped
public class PortatilBean {

    @Inject
    ServiciosPortatilImpl service;
    EstadoRecurso estadoRecurso;
    boolean success;
    boolean searchingPortatiles;

    public PortatilBean(){
        this.service = new SetUpInjector().getInjector().getInstance(ServiciosPortatilImpl.class);
    }
    public boolean savePortatil(String name, String capacity, String id, String info,
                               String bookingScheduleStart, String bookingScheduleEnd, String ramModel, String hardDriveModel,
                               String processor, String screenResolution, String brand){
        try {
            int cap = capacity.equals("") ? 0 : Integer.parseInt(capacity);
            int start =  bookingScheduleStart.equals("") ? 0 : Integer.parseInt(bookingScheduleStart);
            int end = bookingScheduleEnd.equals("") ? 0 : Integer.parseInt(bookingScheduleEnd);
            String smallName = name.toLowerCase();
            String buildId = id;
            for(int i = 0; i < cap; i++){
                Portatil inserting = new Portatil(smallName, "Pedir en ventanilla", cap, buildId, info, start, end, estadoRecurso.toString(), ramModel,
                        hardDriveModel, processor, screenResolution, brand);
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

    public void test(String a){
        System.out.println(a);
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

    public boolean getSearchingPortatiles(){
        return this.searchingPortatiles;
    }

    public void setSearchingPortatiles(boolean searchingPortatiles) {
        this.searchingPortatiles = searchingPortatiles;
    }

    private String createNewId(String id){
        int idNumber = Integer.parseInt(id.split("-")[1]);
        idNumber++;
        return id.split("-")[0] + "-" + idNumber;
    }

}
