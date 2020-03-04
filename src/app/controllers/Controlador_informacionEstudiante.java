package app.controllers;

import app.controllers.Controlador_principal;
import app.model.EstudianteDAO;
import app.model.PersonaDAO;
import app.model.Estudiante;
import app.model.Persona;
import app.model.Usuario;
import app.views.View_informacionEstudiante;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Controlador_informacionEstudiante extends MouseAdapter {

    private View_informacionEstudiante perfil;
    private Usuario usuario = null;
    private Persona persona = null;
    private Estudiante estudiante = null;
    private PersonaDAO personaDAO = null;
    private EstudianteDAO estudianteDAO = null;

    public Controlador_informacionEstudiante(Usuario usuario) {
        this.usuario = usuario;
    }

    public Controlador_informacionEstudiante(Usuario usuario, Persona persona, Estudiante estudiante) {
        this.usuario = usuario;
        this.persona = persona;
        this.estudiante = estudiante;
    }

    public void iniciarFrame() {
        perfil = new View_informacionEstudiante();
        perfil.setVisible(true);
        perfil.lblModificar.setEnabled(false);
        perfil.lblGuardar.addMouseListener(this);
        perfil.lblSalir.addMouseListener(this);
    }

    public void iniciarFrameModificar() {
        perfil = new View_informacionEstudiante();
        perfil.setVisible(true);
        perfil.txtNombre.setText(persona.getPNombre());
        perfil.txtAp_paterno.setText(persona.getPApPaterno());
        perfil.txtAp_materno.setText(persona.getPApMaterno());
        perfil.itmGenero.setSelectedItem(persona.getPGenero());
        perfil.chsrFechaNacimiento.setDate(persona.getPFechaNacimiento());
        String matricula = String.valueOf(estudiante.getEMatricula());
        perfil.txtMatricula.setText(matricula);
        perfil.itmCarrera.setSelectedItem(estudiante.getECarrera());
        String semestre = String.valueOf(estudiante.getESemestre());
        perfil.itmSemestre.setSelectedItem(semestre);
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
                int matricula = Integer.parseInt(perfil.txtMatricula.getText());
                String carrera = perfil.itmCarrera.getSelectedItem().toString();
                int semestre = Integer.parseInt(perfil.itmSemestre.getSelectedItem().toString());

                //se crea el objeto persona
                persona = new Persona(nombre, paterno, materno, genero, fecha_nacimiento, id_usuario);
                estudiante = new Estudiante(matricula, carrera, semestre, id_usuario);
                //se hacen los insert a la tabla
                personaDAO = new PersonaDAO();
                estudianteDAO = new EstudianteDAO();

                boolean resp1 = personaDAO.insertPersona(persona);
                boolean resp2 = estudianteDAO.insertEstudiante(estudiante);
                if (resp1 && resp2 == true) {
                    JOptionPane.showMessageDialog(null, "registrado con exito");                    
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
            int matricula = Integer.parseInt(perfil.txtMatricula.getText());
            String carrera = perfil.itmCarrera.getSelectedItem().toString();
            int semestre = Integer.parseInt(perfil.itmSemestre.getSelectedItem().toString());
            personaDAO = new PersonaDAO();
            estudianteDAO = new EstudianteDAO();
            boolean resp1 = personaDAO.updatePersona(nombre, paterno, materno, genero, fecha_nacimiento, id_usuario);
            boolean resp2 = estudianteDAO.updateEstudiante(matricula, carrera, semestre, id_usuario);

            if (resp1 == true && resp2 == true) {
                System.out.println("modficado con exito");                
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

    private boolean camposvacios() {
        boolean resp = false;
        if (perfil.txtNombre.getText().isEmpty() && perfil.txtAp_paterno.getText().isEmpty() && perfil.txtAp_materno.getText().isEmpty()
                && perfil.chsrFechaNacimiento.getDate().toString().isEmpty() && perfil.txtMatricula.getText().isEmpty()) {
            resp = true;
        }
        return resp;

    }

    private boolean validamatricula() {
        boolean resp = false;
        if (perfil.txtMatricula.getText().length() != 8) {
            JOptionPane.showMessageDialog(perfil, "matricula no valida, solo 8 caracteres");
        }
        return resp;
    }

}
