package edu.eci.proyectoCVDS.entities;

import java.sql.Date;

public class Recurso {
    private String name;
    private String location;
    private TipoRecurso type;
    private int capacity;
    private String id;
    private Date bookingScheduleStart;
    private Date bookingScheduleEnd;

    public Recurso(String name, String location, TipoRecurso type, int capacity, String id, Date bookingScheduleStart, Date bookingScheduleEnd){
        this.name = name;
        this.location = location;
        this.type = type;
        this.capacity = capacity;
        this.id = id;
        this.bookingScheduleStart = bookingScheduleStart;
        this.bookingScheduleEnd = bookingScheduleEnd;
    }

    public Date getBookingScheduleEnd() {
        return bookingScheduleEnd;
    }

    public Date getBookingScheduleStart() {
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

    public void setBookingScheduleEnd(Date bookingScheduleEnd) {
        this.bookingScheduleEnd = bookingScheduleEnd;
    }

    public void setBookingScheduleStart(Date bookingScheduleStart) {
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
