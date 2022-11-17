package edu.eci.proyectoCVDS.entities;

import java.time.LocalTime;

public class Recurso {
    private String name;
    private String location;
    private TipoRecurso type;
    private int capacity;
    private String id;
    private LocalTime bookingScheduleStart;
    private LocalTime bookingScheduleEnd;

    EstadoRecurso resourceState;

    public Recurso(String name, String location, TipoRecurso type, int capacity, String id, LocalTime bookingScheduleStart, LocalTime bookingScheduleEnd, EstadoRecurso resourceState){
        this.name = name;
        this.location = location;
        this.type = type;
        this.capacity = capacity;
        this.id = id;
        this.bookingScheduleStart = bookingScheduleStart;
        this.bookingScheduleEnd = bookingScheduleEnd;
        this.resourceState = resourceState;
    }

    public LocalTime getBookingScheduleEnd() {
        return bookingScheduleEnd;
    }

    public LocalTime getBookingScheduleStart() {
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
        return name;
    }

    public TipoRecurso getType() {
        return type;
    }

    public void setBookingScheduleEnd(LocalTime bookingScheduleEnd) {
        this.bookingScheduleEnd = bookingScheduleEnd;
    }

    public void setBookingScheduleStart(LocalTime bookingScheduleStart) {
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

}
