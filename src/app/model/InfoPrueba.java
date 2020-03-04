package app.model;

import java.util.Date;

public class InfoPrueba {

    private Integer idInf;

    private String nombreArchivo;

    private String autor;

    private String fcreacion;

    private String tamanio;

    private String duracion;

    private String capturas;

    private String comentarios;

    private Integer inf_id_usuario;

    private Date fecha_bitacora;

    public InfoPrueba() {
    }

    public InfoPrueba(Integer idInf) {
        this.idInf = idInf;
    }

    public InfoPrueba(String nombreArchivo, String autor, String fcreacion, String tamanio, String duracion, String capturas, String comentarios, Date fecha_bitacora, Integer inf_id_usuario) {
        this.nombreArchivo = nombreArchivo;
        this.autor = autor;
        this.fcreacion = fcreacion;
        this.tamanio = tamanio;
        this.duracion = duracion;
        this.capturas = capturas;
        this.comentarios = comentarios;
        this.fecha_bitacora = fecha_bitacora;
        this.inf_id_usuario = inf_id_usuario;
    }

    public Integer getIdInf() {
        return idInf;
    }

    public void setIdInf(Integer idInf) {
        this.idInf = idInf;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(String fcreacion) {
        this.fcreacion = fcreacion;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCapturas() {
        return capturas;
    }

    public void setCapturas(String capturas) {
        this.capturas = capturas;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFecha_bitacora() {
        return fecha_bitacora;
    }

    public void setFecha_bitacora(Date fecha_bitacora) {
        this.fecha_bitacora = fecha_bitacora;
    }

    public Integer getInf_id_usuario() {
        return inf_id_usuario;
    }

    public void setInf_id_usuario(Integer inf_id_usuario) {
        this.inf_id_usuario = inf_id_usuario;
    }

}
