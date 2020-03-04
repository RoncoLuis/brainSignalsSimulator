package app.model;

public class Investigador {

    private Integer idInvestigador;

    private String invLaboratorio;

    private String invTitulo;

    private String invInstitucion;

    private int IdUsuario;

    public Investigador() {
    }

    public Investigador(String invLaboratorio, String invTitulo, String invInstitucion, int IdUsuario) {
        this.invLaboratorio = invLaboratorio;
        this.invTitulo = invTitulo;
        this.invInstitucion = invInstitucion;
        this.IdUsuario = IdUsuario;
    }

    public Investigador(Integer idInvestigador) {
        this.idInvestigador = idInvestigador;
    }

    public Investigador(Integer idInvestigador, String invLaboratorio, String invTitulo, String invInstitucion) {
        this.idInvestigador = idInvestigador;
        this.invLaboratorio = invLaboratorio;
        this.invTitulo = invTitulo;
        this.invInstitucion = invInstitucion;
    }

    public Integer getIdInvestigador() {
        return idInvestigador;
    }

    public void setIdInvestigador(Integer idInvestigador) {
        this.idInvestigador = idInvestigador;
    }

    public String getInvLaboratorio() {
        return invLaboratorio;
    }

    public void setInvLaboratorio(String invLaboratorio) {
        this.invLaboratorio = invLaboratorio;
    }

    public String getInvTitulo() {
        return invTitulo;
    }

    public void setInvTitulo(String invTitulo) {
        this.invTitulo = invTitulo;
    }

    public String getInvInstitucion() {
        return invInstitucion;
    }

    public void setInvInstitucion(String invInstitucion) {
        this.invInstitucion = invInstitucion;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

}
