package app.controllers;

import app.controllers.Controlador_principal;
import app.model.InvestigadorDAO;
import app.model.PersonaDAO;
import app.model.Investigador;
import app.model.Persona;
import app.model.Usuario;
import app.views.View_informacionInvestigador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Controlador_informacionInvestigador extends MouseAdapter {

    private View_informacionInvestigador perfil;
    private Usuario usuario = null;
    private Persona persona = null;
    private Investigador investigador = null;
    private PersonaDAO personaDAO = null;
    private InvestigadorDAO investigadorDAO = null;

    public Controlador_informacionInvestigador(Usuario usuario) {
        this.usuario = usuario;
    }

    public Controlador_informacionInvestigador(Usuario usuario, Persona persona, Investigador investigador) {
        this.usuario = usuario;
        this.persona = persona;
        this.investigador = investigador;
    }

    public void iniciarFrame() {
        perfil = new View_informacionInvestigador();
        perfil.setVisible(true);
        perfil.lblModificar.setEnabled(false);
        perfil.lblGuardar.addMouseListener(this);
        perfil.lblSalir.addMouseListener(this);
    }

    public void iniciarFrameModificar() {
        perfil = new View_informacionInvestigador();
        perfil.setVisible(true);
        perfil.txtNombre.setText(persona.getPNombre());
        perfil.txtAp_paterno.setText(persona.getPApPaterno());
        perfil.txtAp_materno.setText(persona.getPApMaterno());
        perfil.itmGenero.setSelectedItem(persona.getPGenero());
        perfil.chsrFechaNacimiento.setDate(persona.getPFechaNacimiento());

        perfil.itmLaboratorio.setSelectedItem(investigador.getInvLaboratorio());
        perfil.txtTitulo.setText(investigador.getInvTitulo());
        perfil.txtInstitucion.setText(investigador.getInvInstitucion());

        perfil.lblGuardar.setEnabled(false);
        perfil.lblModificar.addMouseListener(this);
        perfil.lblSalir.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == perfil.lblGuardar) {
            int id_usuario = usuario.getIdUsuario();
            String nombre = perfil.txtNombre.getText();
            String paterno = perfil.txtAp_paterno.getText();
            String materno = perfil.txtAp_materno.getText();
            String genero = perfil.itmGenero.getSelectedItem().toString();
            java.util.Date date = perfil.chsrFechaNacimiento.getDate();
            java.sql.Date fecha_nacimiento = new java.sql.Date(date.getTime());
            //informacion de la tabla estudiante
            String titulo = perfil.txtTitulo.getText();
            String institucion = perfil.txtInstitucion.getText();
            String laboratorio = perfil.itmLaboratorio.getSelectedItem().toString();

            //se crea el objeto persona
            persona = new Persona(nombre, paterno, materno, genero, fecha_nacimiento, id_usuario);
            investigador = new Investigador(laboratorio, titulo, institucion, id_usuario);
            //se hacen los insert a la tabla
            personaDAO = new PersonaDAO();
            investigadorDAO = new InvestigadorDAO();

            boolean resp1 = personaDAO.insertPersona(persona);
            boolean resp2 = investigadorDAO.insertInvestigador(investigador);
            if (resp1 && resp2 == true) {
                System.out.println("exito en registro");
                //this.perfil.setVisible(false);
                perfil.dispose();
                Controlador_principal principal = new Controlador_principal(usuario);
                principal.iniciarFrame();
            } else {
                System.out.println("error en registro");
            }

        }
        if (e.getSource() == perfil.lblModificar) {
            int id_usuario = usuario.getIdUsuario();
            String nombre = perfil.txtNombre.getText();
            String paterno = perfil.txtAp_paterno.getText();
            String materno = perfil.txtAp_materno.getText();
            String genero = perfil.itmGenero.getSelectedItem().toString();
            java.util.Date date = perfil.chsrFechaNacimiento.getDate();
            java.sql.Date fecha_nacimiento = new java.sql.Date(date.getTime());
            //informacion de la tabla investigador            
            String laboratorio = perfil.itmLaboratorio.getSelectedItem().toString();
            String titulo = perfil.txtInstitucion.getText();
            String institucion = perfil.txtInstitucion.getText();

            personaDAO = new PersonaDAO();
            investigadorDAO = new InvestigadorDAO();
            boolean resp1 = personaDAO.updatePersona(nombre, paterno, materno, genero, fecha_nacimiento, id_usuario);
            boolean resp2 = investigadorDAO.updateInvestigador(laboratorio, titulo, institucion, id_usuario);
            if (resp1 == true && resp2 == true) {
                System.out.println("modficado con exito");
                //perfil.setVisible(false);
                perfil.dispose();
                Controlador_principal principal = new Controlador_principal(usuario);
                principal.iniciarFrame();
            } else {
                System.out.println("error modificando");
            }
        }
        if (e.getSource() == perfil.lblSalir) {
            perfil.dispose();
            Controlador_principal principal = new Controlador_principal(usuario);
            principal.iniciarFrame();
        }

    }

}
