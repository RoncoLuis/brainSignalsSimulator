package app.controllers;

import app.model.UsuarioDAO;
import app.model.Usuario;
import app.utils.ValidacionCampos;
import app.views.View_registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controlador_registro extends MouseAdapter implements ActionListener {

    //instanciar los objetos que voy a utilizar, jframe y el DAO
    private View_registro frameRegistro;
    private UsuarioDAO usuarioDAO;
    private ValidacionCampos vc;

    public Controlador_registro() {

    }

    public void iniciarFrame() {
        this.frameRegistro = new View_registro();
        frameRegistro.setVisible(true);
        frameRegistro.btnRegistro.addActionListener(this);
        frameRegistro.lblIniciarSesion.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frameRegistro.lblIniciarSesion) {
            this.frameRegistro.setVisible(false);
            Controlador_inicioSesion inicio_Sesion = new Controlador_inicioSesion();
            inicio_Sesion.iniciarFrame();
//            frameRegistro.setVisible(false);
//            ControladorFrameInicioSesion cfis = new ControladorFrameInicioSesion(usuarioDAO);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frameRegistro.btnRegistro) {
            vc = new ValidacionCampos();
            if (vc.validapass(frameRegistro.txtPassword.getText()) && vc.validaEmail(frameRegistro.txtCorreo.getText()) && vc.validausuario(frameRegistro.txtUsuario.getText())) {

                usuarioDAO = new UsuarioDAO();
                java.util.Date date = new Date();
                java.sql.Date fechaActual = new java.sql.Date(date.getTime());
                String u_nombre = frameRegistro.txtUsuario.getText();
                String u_correo = frameRegistro.txtCorreo.getText();
                String u_pass = frameRegistro.txtPassword.getText();
                String comboBox = frameRegistro.cmbTipo.getSelectedItem().toString();
                int tipo = retornaTipo(comboBox);
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
                    this.frameRegistro.setVisible(false);
                    Controlador_inicioSesion inicio_Sesion = new Controlador_inicioSesion();
                    inicio_Sesion.iniciarFrame();
//                    ControladorFrameInicioSesion cfis = new ControladorFrameInicioSesion(usuarioDAO);
                } else {
                    JOptionPane.showMessageDialog(frameRegistro, "Este usuario ya esta registrado");
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, resp);
                }

            } else {
                JOptionPane.showMessageDialog(frameRegistro, "Por favor verifique que los datos concuerden con las reglas");
            }

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
                //administrador
                respuesta = 0;
                break;
        }
        return respuesta;
    }

}
