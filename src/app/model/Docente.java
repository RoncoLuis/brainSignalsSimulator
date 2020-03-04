package app.model;

public class Docente {

    private Integer idDocente;

    private String docDepartamento;

    private String docTitulo;

    private int IdUsuario;

    public Docente() {
    }

    public Docente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Docente(String docDepartamento, String docTitulo, int IdUsuario) {
        this.docDepartamento = docDepartamento;
        this.docTitulo = docTitulo;
        this.IdUsuario = IdUsuario;
    }

    public Docente(Integer idDocente, String docDepartamento, String docTitulo) {
        this.idDocente = idDocente;
        this.docDepartamento = docDepartamento;
        this.docTitulo = docTitulo;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public String getDocDepartamento() {
        return docDepartamento;
    }

    public void setDocDepartamento(String docDepartamento) {
        this.docDepartamento = docDepartamento;
    }

    public String getDocTitulo() {
        return docTitulo;
    }

    public void setDocTitulo(String docTitulo) {
        this.docTitulo = docTitulo;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

}
