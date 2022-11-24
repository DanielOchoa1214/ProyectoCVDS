package edu.eci.proyectoCVDS.entities;

import org.h2.util.StringUtils;

import java.time.LocalTime;
import java.util.Objects;

public abstract class Recurso {
    protected String name;
    protected String location;
    protected TipoRecurso type;
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

    @Override
    public boolean equals(Object p){
        return this.equals(p);
    }
}
