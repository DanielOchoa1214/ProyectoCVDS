package edu.eci.proyectocvds.entities;

public abstract class Recurso {
    protected String name;
    protected String location;
    protected int capacity;
    protected String id;
    protected int bookingScheduleStart;
    protected int bookingScheduleEnd;
    protected String info;
    protected EstadoRecurso resourceState;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public EstadoRecurso getResourceState() {
        return resourceState;
    }

    public void setResourceState(EstadoRecurso resourceState) {
        this.resourceState = resourceState;
    }

    public int getBookingScheduleEnd() {
        return bookingScheduleEnd;
    }

    public int getBookingScheduleStart() {
        return bookingScheduleStart;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return !name.equals("") ? name.substring(0, 1).toUpperCase() + name.substring(1) : "";
    }

    public void setBookingScheduleEnd(int bookingScheduleEnd) {
        this.bookingScheduleEnd = bookingScheduleEnd;
    }

    public void setBookingScheduleStart(int bookingScheduleStart) {
        this.bookingScheduleStart = bookingScheduleStart;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean notAvailableForBooking(){
        return !resourceState.equals(EstadoRecurso.DISPONIBLE);
    }
    @Override
    public String toString() {
        return "{nombre: " + this.name + "}";
    }
}
