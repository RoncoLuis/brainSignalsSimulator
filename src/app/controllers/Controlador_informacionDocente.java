package app.controllers;

import app.controllers.Controlador_principal;
import app.model.DocenteDAO;
import app.model.PersonaDAO;
import app.model.Docente;
import app.model.Persona;
import app.model.Usuario;
import app.views.View_informacionDocente;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Controlador_informacionDocente extends MouseAdapter {

    private View_informacionDocente perfil;
    private Usuario usuario = null;
    private Persona persona = null;
    private Docente docente = null;
    private PersonaDAO personaDAO = null;
    private DocenteDAO docenteDAO = null;

    public Controlador_informacionDocente(Usuario usuario) {
        this.usuario = usuario;
    }

    public Controlador_informacionDocente(Usuario usuario, Persona persona, Docente docente) {
        this.usuario = usuario;
        this.persona = persona;
        this.docente = docente;
    }

    public void iniciarFrame() {
        perfil = new View_informacionDocente();
        perfil.setVisible(true);
        perfil.lblModificar.setEnabled(false);
        perfil.lblGuardar.addMouseListener(this);
        perfil.lblSalir.addMouseListener(this);
    }

    public void iniciarFrameModificar() {
        perfil = new View_informacionDocente();
        perfil.setVisible(true);
        perfil.txtNombre.setText(persona.getPNombre());
        perfil.txtAp_paterno.setText(persona.getPApPaterno());
        perfil.txtAp_materno.setText(persona.getPApMaterno());
        perfil.itmGenero.setSelectedItem(persona.getPGenero());
        perfil.chsrFechaNacimiento.setDate(persona.getPFechaNacimiento());

        perfil.txtTitulo.setText(docente.getDocTitulo());
        perfil.itmDpto.setSelectedItem(docente.getDocDepartamento());

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
            //informacion de la tabla docente
            String titulo = perfil.txtTitulo.getText();
            String departamento = perfil.itmDpto.getSelectedItem().toString();

            //se crea el objeto persona
            persona = new Persona(nombre, paterno, materno, genero, fecha_nacimiento, id_usuario);
            docente = new Docente(departamento, titulo, id_usuario);
            //se hacen los insert a la tabla
            personaDAO = new PersonaDAO();
            docenteDAO = new DocenteDAO();

            boolean resp1 = personaDAO.insertPersona(persona);
            boolean resp2 = docenteDAO.insertDocente(docente);
            if (resp1 && resp2 == true) {
                JOptionPane.showMessageDialog(null, "registrado con exito");
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
            //informacion de la tabla docente            
            String titulo = perfil.txtTitulo.getText();
            String departamento = perfil.itmDpto.getSelectedItem().toString();
            personaDAO = new PersonaDAO();
            docenteDAO = new DocenteDAO();
            boolean resp1 = personaDAO.updatePersona(nombre, paterno, materno, genero, fecha_nacimiento, id_usuario);
            boolean resp2 = docenteDAO.updateEstudiante(departamento, titulo, id_usuario);
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
