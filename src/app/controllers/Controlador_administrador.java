package app.controllers;

import app.model.AdminDAO;
import app.model.InfoPruebaDAO;
import app.model.UsuarioDAO;
import app.model.Usuario;
import app.utils.Contacto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import app.views.View_administrador;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_administrador extends MouseAdapter {

    View_administrador frame = null;
    private DefaultTableModel model;
    UsuarioDAO usuariodao;
    AdminDAO admin;

    public Controlador_administrador() {

    }

    public void inciarFrame() {
        frame = new View_administrador();
        frame.setVisible(true);

        //agregando las acciones al controlador de las etiquetas
        frame.lblNuevo.addMouseListener(this);
        frame.lblEliminar.addMouseListener(this);
        frame.lblActualizar.addMouseListener(this);
        frame.btn_close.addMouseListener(this);
        frame.lblPaginaWeb.addMouseListener(this);

        //iniciando el jtable
        registros();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frame.lblNuevo) {
            Controlador_registroAdmin registro = new Controlador_registroAdmin();
            registro.iniciarFrame();
        }
        if (e.getSource() == frame.lblEliminar) {
             int inicio = frame.jTable1.getSelectedRow();
            if (inicio > -1) {
                String id = String.valueOf(frame.jTable1.getValueAt(inicio, 0));
                int respuesta = JOptionPane.showConfirmDialog(null, "!Advertencia¡\nse eliminara el usuario:"+id);
                int id_inf = Integer.parseInt(id);
                if (respuesta == 0) {
                    usuariodao = new UsuarioDAO();
                    usuariodao.borrarUsuario(id_inf);
                    registros();
                }
            }
        }
        if (e.getSource() == frame.lblActualizar) {
            admin=new AdminDAO();
            registros();
            frame.lbl_uregistrados.setText(String.valueOf(admin.cantidadUsuarios()));
            frame.lbl_eregistrados.setText(String.valueOf(admin.cantidadXTipo(1)));
            frame.lbl_dregistrados.setText(String.valueOf(admin.cantidadXTipo(2)));
            frame.lbl_iregistrados.setText(String.valueOf(admin.cantidadXTipo(3)));
        }
        if(e.getSource() == frame.lblPaginaWeb){
            Contacto contacto = new Contacto();
            contacto.goToURL(contacto.url());
        }
        if (e.getSource() == frame.btn_close) {
            this.frame.dispose();
            Controlador_inicioSesion is = new Controlador_inicioSesion();
            is.iniciarFrame();
        }
    }

    public void registros() {
        usuariodao = new UsuarioDAO();//para llenar el jtable debo pasar como referencia el usuarioDAO
        String titulos[] = {"id", "tipo", "usuario", "correo", "password", "registro"};
        model = new DefaultTableModel(null, titulos);
        String fila[] = new String[10];
        List<Usuario> lista = usuariodao.listarUsuarios();
        lista.forEach((u) -> {
            fila[0] = u.getIdUsuario().toString();
            fila[1] = tipoUsuario(u.getUTipo());
            fila[2] = u.getUNombre();
            fila[3] = u.getUCorreo();
            fila[4] = u.getUPassword();
            fila[5] = u.getUFechaReg().toString();

            model.addRow(fila);
        });
        frame.jTable1.setModel(model);
    }

    private String tipoUsuario(int tipo) {
        String label_tipo = "";
        switch (tipo) {
            case 1:
                label_tipo = "estudiante";
                break;
            case 2:
                label_tipo = "docente";
                break;
            case 3:
                label_tipo = "investigador";
                break;
        }
        return label_tipo;
    }
}
