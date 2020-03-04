package app.model;

public class Estudiante {

    private Integer idEstudiante;

    private int eMatricula;

    private String eCarrera;

    private int eSemestre;

    private int IdUsuario;

    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(int eMatricula, String eCarrera, int eSemestre, int pIdUsuario) {
        this.eMatricula = eMatricula;
        this.eCarrera = eCarrera;
        this.eSemestre = eSemestre;
        this.IdUsuario = pIdUsuario;
    }

    public Estudiante(Integer idEstudiante, int eMatricula, String eCarrera, int eSemestre) {
        this.idEstudiante = idEstudiante;
        this.eMatricula = eMatricula;
        this.eCarrera = eCarrera;
        this.eSemestre = eSemestre;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getEMatricula() {
        return eMatricula;
    }

    public void setEMatricula(int eMatricula) {
        this.eMatricula = eMatricula;
    }

    public String getECarrera() {
        return eCarrera;
    }

    public void setECarrera(String eCarrera) {
        this.eCarrera = eCarrera;
    }

    public int getESemestre() {
        return eSemestre;
    }

    public void setESemestre(int eSemestre) {
        this.eSemestre = eSemestre;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int pIdUsuario) {
        this.IdUsuario = pIdUsuario;
    }

}
