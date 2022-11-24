package edu.eci.proyectoCVDS.entities;

public class Libro extends Recurso{

    private String author;


    public Libro(String name, String location, String type, int capacity, String id, String info, int bookingScheduleStart, int bookingScheduleEnd, String resourceState){
        this.name = name;
        this.location = location;
        this.type = TipoRecurso.valueOf(type);
        this.capacity = capacity;
        this.id = id;
        this.info = info;
        this.bookingScheduleStart = bookingScheduleStart;
        this.bookingScheduleEnd = bookingScheduleEnd;
        this.resourceState = EstadoRecurso.valueOf(resourceState);
    }

    @Override
    public boolean equals(Object p){
        return this.equals((Libro) p);
    }

    private boolean equals(Libro r){
        return this.id.equals(r.id);
    }
}
