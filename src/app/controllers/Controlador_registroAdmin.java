package app.controllers;

import app.model.UsuarioDAO;
import app.model.Usuario;
import app.views.View_registroAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Controlador_registroAdmin extends MouseAdapter implements ActionListener {

    //instanciar los objetos que voy a utilizar, jframe y el DAO
    private View_registroAdmin frameRegistro;
    private UsuarioDAO usuarioDAO;

    public Controlador_registroAdmin() {

    }

    public void iniciarFrame() {
        this.frameRegistro = new View_registroAdmin();
        frameRegistro.setVisible(true);

        frameRegistro.btnRegistro.addActionListener(this);
        frameRegistro.bntCerrar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frameRegistro.btnRegistro) {
            usuarioDAO = new UsuarioDAO();
            java.util.Date date = new Date();
            java.sql.Date fechaActual = new java.sql.Date(date.getTime());
            String u_nombre = frameRegistro.txtUsuario.getText();
            String u_correo = frameRegistro.txtCorreo.getText();
            String u_pass = frameRegistro.txtPassword.getText();
            String comboBox = frameRegistro.cmbTipo.getSelectedItem().toString();
            int tipo = retornaTipo(comboBox);
            if (validaEmail(u_correo) == true) {
                Usuario u = new Usuario();
                u.setUTipo(tipo);
                u.setUNombre(u_nombre);
                u.setUCorreo(u_correo);
                u.setUPassword(u_pass);
                u.setUFechaReg(fechaActual);
                boolean resp = usuarioDAO.insertaUsuario(u);

                if (resp == true) {
                    JOptionPane.showMessageDialog(null, "Registro insertado con exito");
                    limpiarCampos();
                } else {

                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, resp);
                }

            } else {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, u_correo);
            }

        }
        if (e.getSource()== frameRegistro.bntCerrar) {
            this.frameRegistro.dispose();
        }

    }

    public void limpiarCampos() {
        frameRegistro.txtUsuario.setText("");
        frameRegistro.txtCorreo.setText("");
        frameRegistro.txtPassword.setText("");
    }

    public int retornaTipo(String tipo) {
        int respuesta = 0;
        switch (tipo) {
            case "Estudiante":
                respuesta = 1;
                break;
            case "Docente":
                respuesta = 2;
                break;
            case "Investigador":
                respuesta = 3;
                break;
            default:
                break;
        }
        return respuesta;
    }

    public boolean validaEmail(String correo) {
        boolean valido = false;
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // El email a validar
        String email = frameRegistro.txtCorreo.getText();

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            valido = true;
            System.out.println("El email ingresado es válido.");
        } else {
            JOptionPane.showMessageDialog(null, "El correo ingresado no se acepto como válido, intente de nuevo");
        }
        return valido;
    }

}
