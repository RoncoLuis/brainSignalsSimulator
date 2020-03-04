package app.controllers;

import app.model.UsuarioDAO;
import app.model.Usuario;
import app.utils.Contacto;
import app.views.View_incioSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class Controlador_inicioSesion extends MouseAdapter implements ActionListener {

    private View_incioSesion is = null;
    private String usuario = null;
    private String pass = null;
    private Usuario u;
    private UsuarioDAO udao;

    public Controlador_inicioSesion() {

    }

    public void iniciarFrame() {
        is = new View_incioSesion();
        is.setVisible(true);
        is.setLocationRelativeTo(null);

        //acciones
        is.lblContacto.addMouseListener(this);
        is.btn_login.addActionListener(this);
        is.lblRegistrate.addMouseListener(this);
    }

    //acciones de botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == is.btn_login) {
            u = new Usuario();
            udao = new UsuarioDAO();
            usuario = is.txt_email.getText();
            char pwd[] = is.txt_pwd.getPassword();
            pass = new String(pwd);
            if (usuario.equals("admin") && pass.equals("admin")) {
                is.dispose();
                Controlador_administrador admin = new Controlador_administrador();
                admin.inciarFrame();
            } else {
                u = udao.accesoUsuario(usuario, pass);
                if (u != null) {
                    if (u.getUNombre().equals(usuario) && u.getUPassword().equals(pass)) {
                        switch (u.getUTipo()) {

                            case 1:
                                cargando();
                                break;
                            case 2:
                                cargando();
                                break;
                            case 3:
                                cargando();
                                break;

                        }
                    } else {
                        JOptionPane.showMessageDialog(is, "¡Lo sentimos!\nel usuario/contraseña son incorrectos\n"
                                + "sino recuerda su contraseña porfavor contacte al administrador");
                    }

                } else {
                    JOptionPane.showMessageDialog(is, "¡Lo sentimos!\nel usuario/contraseña son incorrectos\n"
                            + "sino recuerda su contraseña porfavor contacte al administrador");
                }
            }
        }

    }

    private void cargando() {
        is.loader.setVisible(true);
        is.login.setVisible(false);
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //is.setVisible(false);
                is.dispose();
                Controlador_principal cpe = new Controlador_principal(u);
                cpe.iniciarFrame();
            }
        }, 1000 * 5);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == is.lblRegistrate) {
            this.is.dispose();
            Controlador_registro frameRegistro = new Controlador_registro();
            frameRegistro.iniciarFrame();
        }
        if (e.getSource() == is.lblContacto) {
            Contacto contacto = new Contacto();
            contacto.goToURL(contacto.url());
        }

    }

}
