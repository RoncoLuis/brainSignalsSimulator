package app.utils;

import java.util.Date;

public class FechaActual {

    public java.sql.Date obtenerFechaActual() {
        java.sql.Date fechaActual = null;
        java.util.Date date = new Date();
        fechaActual = new java.sql.Date(date.getTime());
        return fechaActual;
    }
}
