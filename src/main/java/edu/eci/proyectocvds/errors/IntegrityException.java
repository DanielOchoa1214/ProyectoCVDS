package edu.eci.proyectocvds.errors;

public class IntegrityException extends Exception{

    public static final String DATOS_BAURA_ENTRADA_LIBROS = "Los campos de nombre, ubicación, id, información y autor no pueden estar vacíos";

    public static final String DATOS_BAURA_ENTRADA_PORTATILES = "Los campos de nombre, ubicación, id, información, ram, modelo del disco, procesador, resolución de pantalla y marca no pueden estar vacíos";

    public IntegrityException() {
        super();
    }

    public IntegrityException(String message) {
        super(message);
    }
}
