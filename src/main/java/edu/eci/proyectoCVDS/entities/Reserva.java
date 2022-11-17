package edu.eci.proyectoCVDS.entities;

import java.sql.Date;

public class Reserva {
    Recurso resource;
    String infoResource;
    Date requestDate;
    Date initialDate;
    Date finalDate;
    boolean recurrent;
    Date nextBookingDate;
    private String id;

    public Reserva (String id, Recurso resource, String infoResource, Date requestDate, Date initialDate, Date finalDate) {
        this.resource = resource;
        this.infoResource = infoResource;
        this.requestDate = requestDate;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.id = id;
    }

    public Reserva (String id, Recurso resource, String infoResource, Date requestDate, Date initialDate, Date finalDate, boolean recurrent, Date nextBookingDate) {
        this.resource = resource;
        this.infoResource = infoResource;
        this.requestDate = requestDate;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.recurrent = recurrent;
        this.nextBookingDate = nextBookingDate;
        this.id = id;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public Date getNextBookingDate() {
        return nextBookingDate;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Recurso getResource() {
        return resource;
    }

    public String getInfoResource() {
        return infoResource;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public void setInfoResource(String infoResource) {
        this.infoResource = infoResource;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public void setNextBookingDate(Date nextBookingDate) {
        this.nextBookingDate = nextBookingDate;
    }

    public void setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setResource(Recurso resource) {
        this.resource = resource;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
}

