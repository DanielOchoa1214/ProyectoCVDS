package edu.eci.proyectoCVDS.entities;

import org.h2.util.StringUtils;

import java.time.LocalTime;

public class Recurso {
    private String name;
    private String location;
    private TipoRecurso type;
    private int capacity;
    private String id;
    private int bookingScheduleStart;
    private int bookingScheduleEnd;

    EstadoRecurso resourceState;

    public Recurso(String name, String location, String type, int capacity, String id, int bookingScheduleStart, int bookingScheduleEnd, String resourceState){
        this.name = name;
        this.location = location;
        this.type = TipoRecurso.valueOf(type);
        this.capacity = capacity;
        this.id = id;
        this.bookingScheduleStart = bookingScheduleStart;
        this.bookingScheduleEnd = bookingScheduleEnd;
        this.resourceState = EstadoRecurso.valueOf(resourceState);
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
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public TipoRecurso getType() {
        return type;
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

    public void setType(TipoRecurso type) {
        this.type = type;
    }

    public boolean notAvailableForBooking(){
        return !resourceState.equals(EstadoRecurso.DISPONIBLE);
    }

    @Override
    public String toString() {
        return "{nombre: " + this.name + "}";
    }
}
