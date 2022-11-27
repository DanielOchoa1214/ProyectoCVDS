package edu.eci.proyectocvds.entities;

public class Portatil extends Recurso{

    private String ram;
    private String hardDriveModel;
    private String processor;
    private String screenResolution;
    private String brand;

    public Portatil(String name, String location, int capacity, String id, String info,
                    int bookingScheduleStart, int bookingScheduleEnd, String resourceState, String ram, String hardDriveModel,
                    String processor, String screenResolution, String brand){
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.id = id;
        this.info = info;
        this.bookingScheduleStart = bookingScheduleStart;
        this.bookingScheduleEnd = bookingScheduleEnd;
        this.resourceState = EstadoRecurso.valueOf(resourceState);
        this.ram = ram;
        this.hardDriveModel = hardDriveModel;
        this.processor = processor;
        this.screenResolution = screenResolution;
        this.brand = brand;
    }

    public String getRam() {
        return ram;
    }

    public String getHardDriveModel() {
        return hardDriveModel;
    }

    public String getProcessor() {
        return processor;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public String getBrand() {
        return brand;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setHardDriveModel(String hardDriveModel) {
        this.hardDriveModel = hardDriveModel;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
