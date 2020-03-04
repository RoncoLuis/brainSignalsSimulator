package app.controllers;

import app.views.View_registro_tmp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import app.utils.ValidacionCampos;
import java.util.Arrays;


/**
 *
 * @author LR21
 */
public class Controlador_registro_tmp extends MouseAdapter implements ActionListener {

    private View_registro_tmp viewRegistro;
    private final JLabel etiquetas[] = {viewRegistro.lbl_cerrar, viewRegistro.lbl_minimizar, viewRegistro.lbl_iniciarSesion};
    private final JButton registrate = viewRegistro.btn_registro;
    private JTextField correo;
    private JPasswordField pass, confirm_pass;
    private ValidacionCampos validar;

    public Controlador_registro_tmp() {/* constructor vacio*/ }

    public void showFrame() {
        viewRegistro = new View_registro_tmp();
        for (int i = 0; i < etiquetas.length; i++) {
            etiquetas[i].addMouseListener(this);
        }
        registrate.addActionListener(this);
        elementosView();
        viewRegistro.setVisible(true);
    }

    private void elementosView() {
        correo = viewRegistro.txt_correo;
        pass = viewRegistro.txt_password;
        confirm_pass = viewRegistro.txt_confirmarPass;

    }

    public boolean closeFrame() {
        viewRegistro.setVisible(false);
        viewRegistro = null;
        return (viewRegistro == null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validar = new ValidacionCampos();
        if (e.getSource() == registrate) {
            if (!correo.getText().equals("")) {
                if (!pass.getPassword().equals("")) {
                    if (Arrays.equals(pass.getPassword(), confirm_pass.getPassword())) {

                    } else {
                        System.out.println("no coinciden las contraseñas");
                    }
                } else {
                    System.out.println("campo de contraseña vacio");
                }
            } else {
                System.out.println("campo de correo electronico vacio");
            }

        }
    }

}
