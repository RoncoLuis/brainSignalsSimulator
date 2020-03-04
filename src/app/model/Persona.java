package app.model;

import java.util.Date;

public class Persona {

    private Integer idPersona;

    private String pNombre;

    private String pApPaterno;

    private String pApMaterno;

    private String pGenero;

    private Date pFechaNacimiento;
    private Integer idUsuario;

    public Persona() {
    }

    public Persona(String pNombre, String pApPaterno, String pApMaterno, String pGenero, Date pFechaNacimiento, Integer idUsuario) {
        this.pNombre = pNombre;
        this.pApPaterno = pApPaterno;
        this.pApMaterno = pApMaterno;
        this.pGenero = pGenero;
        this.pFechaNacimiento = pFechaNacimiento;
        this.idUsuario = idUsuario;
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String pNombre, String pApPaterno, String pApMaterno) {
        this.idPersona = idPersona;
        this.pNombre = pNombre;
        this.pApPaterno = pApPaterno;
        this.pApMaterno = pApMaterno;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getPNombre() {
        return pNombre;
    }

    public void setPNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getPApPaterno() {
        return pApPaterno;
    }

    public void setPApPaterno(String pApPaterno) {
        this.pApPaterno = pApPaterno;
    }

    public String getPApMaterno() {
        return pApMaterno;
    }

    public void setPApMaterno(String pApMaterno) {
        this.pApMaterno = pApMaterno;
    }

    public String getPGenero() {
        return pGenero;
    }

    public void setPGenero(String pGenero) {
        this.pGenero = pGenero;
    }

    public Date getPFechaNacimiento() {
        return pFechaNacimiento;
    }

    public void setPFechaNacimiento(Date pFechaNacimiento) {
        this.pFechaNacimiento = pFechaNacimiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}
