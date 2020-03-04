package app.model;

import java.util.Date;

public class Usuario {

    private Integer idUsuario;

    private int uTipo;

    private String uNombre;

    private String uCorreo;

    private String uPassword;

    private Date uFechaReg;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(int uTipo, String uNombre, String uCorreo, String uPassword, Date uFechaReg) {
        this.uTipo = uTipo;
        this.uNombre = uNombre;
        this.uCorreo = uCorreo;
        this.uPassword = uPassword;
        this.uFechaReg = uFechaReg;
    }

    public Usuario(Integer idUsuario, int uTipo, String uNombre, String uCorreo, String uPassword, Date uFechaReg) {
        this.idUsuario = idUsuario;
        this.uTipo = uTipo;
        this.uNombre = uNombre;
        this.uCorreo = uCorreo;
        this.uPassword = uPassword;
        this.uFechaReg = uFechaReg;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getUTipo() {
        return uTipo;
    }

    public void setUTipo(int uTipo) {
        this.uTipo = uTipo;
    }

    public String getUNombre() {
        return uNombre;
    }

    public void setUNombre(String uNombre) {
        this.uNombre = uNombre;
    }

    public String getUCorreo() {
        return uCorreo;
    }

    public void setUCorreo(String uCorreo) {
        this.uCorreo = uCorreo;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Date getUFechaReg() {
        return uFechaReg;
    }

    public void setUFechaReg(Date uFechaReg) {
        this.uFechaReg = uFechaReg;
    }

}
