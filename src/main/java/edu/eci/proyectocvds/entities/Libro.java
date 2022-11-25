package edu.eci.proyectocvds.entities;

public class Libro extends Recurso{

    private String author;
    private boolean hardCover;
    private int pages;


    public Libro(String name, String location, String type, int capacity, String id, String info, int bookingScheduleStart, int bookingScheduleEnd, String resourceState, String author, boolean hardCover, int pages){
        this.name = name;
        this.location = location;
        this.type = TipoRecurso.valueOf(type);
        this.capacity = capacity;
        this.id = id;
        this.info = info;
        this.bookingScheduleStart = bookingScheduleStart;
        this.bookingScheduleEnd = bookingScheduleEnd;
        this.resourceState = EstadoRecurso.valueOf(resourceState);
        this.author = author;
        this.hardCover = hardCover;
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getHardCover(){
        return hardCover;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setHardCover(boolean hardCover) {
        this.hardCover = hardCover;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object p){
        if (p == null)
            return false;
        if (this.getClass() != p.getClass())
            return false;
        return this.equals((Libro) p);
    }

    private boolean equals(Libro r){
        return this.id.equals(r.id);
    }
}
