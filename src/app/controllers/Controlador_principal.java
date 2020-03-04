package app.controllers;

import app.model.DocenteDAO;
import app.model.EstudianteDAO;
import app.model.InfoPruebaDAO;
import app.model.InvestigadorDAO;
import app.model.PersonaDAO;
import app.model.Docente;
import app.model.Estudiante;
import app.model.InfoPrueba;
import app.model.Investigador;
import app.model.Persona;
import app.model.Usuario;
import app.utils.Contacto;
import app.utils.FechaActual;
import app.views.View_principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador_principal extends MouseAdapter implements ActionListener {

    private View_principal jfprincipal = null;
    private Usuario usuario = null;
    private Persona persona = null;
    private Docente docente = null;
    private Estudiante estudiante = null;
    private Investigador investigador = null;
    private DefaultTableModel model;
    private InfoPruebaDAO pruebaDAO = null;
    private EstudianteDAO edao = null;
    private DocenteDAO ddao = null;
    private InvestigadorDAO idao = null;
    private PersonaDAO pdao = null;
    FechaActual fecha = new FechaActual();

    public Controlador_principal(Usuario usuario) {
        this.usuario = usuario;

    }

    public void iniciarFrame() {
        jfprincipal = new View_principal();
        jfprincipal.setVisible(true);
        jfprincipal.lblPrincipal.addMouseListener(this);
//        jfprincipal.lblUsMenu.addMouseListener(this);
        jfprincipal.lblPerfil.addMouseListener(this);
        jfprincipal.lblContacto.addMouseListener(this);
        jfprincipal.lblCerrar.addMouseListener(this);
        /*jfprincipal.lblCorreo.addMouseListener(this);
        jfprincipal.lblUsuario.addMouseListener(this);
        jfprincipal.lblFecha.addMouseListener(this);
        jfprincipal.lblPass.addMouseListener(this);*/
        jfprincipal.btnComenzar.addActionListener(this);
        jfprincipal.btnEliminar.addActionListener(this);

        setTextos();
        registros();
    }

    private void setTextos() {
        jfprincipal.lblNombreUsuario.setText(usuario.getUNombre());
        jfprincipal.lblTipoUsuario.setText(tipoUsuario(usuario.getUTipo()));
        jfprincipal.lblFechaAct.setText(fecha.obtenerFechaActual().toString());
        jfprincipal.lblDescTabla.setText(usuario.getUCorreo() + " este es tu registro de pruebas realizadas");

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

    public void registros() {
        pruebaDAO = new InfoPruebaDAO();//para llenar el jtable debo pasar como referencia el usuarioDAO
        String titulos[] = {"id", "archivo", "autor", "fecha creacion", "tamaño", "duracion", "capturas", "comentarios", "fecha bitacora"};
        model = new DefaultTableModel(null, titulos);
        String fila[] = new String[10];
        ArrayList<InfoPrueba> lista = pruebaDAO.listarPruebas(usuario.getIdUsuario());
        lista.forEach((u) -> {
            fila[0] = u.getIdInf().toString();
            fila[1] = u.getNombreArchivo();
            fila[2] = u.getAutor();
            fila[3] = u.getFcreacion();
            fila[4] = u.getTamanio();
            fila[5] = u.getDuracion();
            fila[6] = u.getCapturas();
            fila[7] = u.getComentarios();
            fila[8] = u.getFecha_bitacora().toString();
            model.addRow(fila);
        });
        jfprincipal.jtableRegistros.setModel(model);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        persona = new Persona();
        estudiante = new Estudiante();
        docente = new Docente();
        investigador = new Investigador();
        pdao = new PersonaDAO();
        edao = new EstudianteDAO();
        ddao = new DocenteDAO();
        idao = new InvestigadorDAO();

        if (e.getSource() == jfprincipal.lblCerrar) {
            //jfprincipal.setVisible(false);
            jfprincipal.dispose();
            Controlador_inicioSesion inicio_Sesion = new Controlador_inicioSesion();
            inicio_Sesion.iniciarFrame();
        }
        if (e.getSource() == jfprincipal.lblPerfil) {
            switch (usuario.getUTipo()) {
                case 1:
                    //persona y estudiante
                    persona = pdao.retornaPersona(usuario.getIdUsuario());
                    estudiante = edao.retornaEstudiante(usuario);
                    if (persona == null && estudiante == null) {
                        //jfprincipal.setVisible(false);
                        jfprincipal.dispose();
                        Controlador_informacionEstudiante perfilestudiante = new Controlador_informacionEstudiante(usuario);
                        perfilestudiante.iniciarFrame();
                    } else {
                        //jfprincipal.setVisible(false);
                        jfprincipal.dispose();
                        Controlador_informacionEstudiante perfilestudiante = new Controlador_informacionEstudiante(usuario, persona, estudiante);
                        perfilestudiante.iniciarFrameModificar();

                    }
                    break;
                case 2:
                    //persona y docente
                    persona = pdao.retornaPersona(usuario.getIdUsuario());
                    docente = ddao.retornaDocente(usuario.getIdUsuario());
                    if (persona == null && docente == null) {
                        //jfprincipal.setVisible(false);
                        jfprincipal.dispose();
                        Controlador_informacionDocente perfildocente = new Controlador_informacionDocente(usuario);
                        perfildocente.iniciarFrame();
                    } else {
                        //jfprincipal.setVisible(false);
                        jfprincipal.dispose();
                        Controlador_informacionDocente perfildocente = new Controlador_informacionDocente(usuario, persona, docente);
                        perfildocente.iniciarFrameModificar();
                    }

                    break;
                case 3:
                    //persona e investigador
                    persona = pdao.retornaPersona(usuario.getIdUsuario());
                    investigador = idao.retornaInvestigador(usuario.getIdUsuario());
                    if (persona == null && investigador == null) {
                        //jfprincipal.setVisible(false);
                        jfprincipal.dispose();
                        Controlador_informacionInvestigador perfilinvestigador = new Controlador_informacionInvestigador(usuario);
                        perfilinvestigador.iniciarFrame();
                    } else {
                        //jfprincipal.setVisible(false);
                        jfprincipal.dispose();
                        Controlador_informacionInvestigador perfilinvestigador = new Controlador_informacionInvestigador(usuario, persona, investigador);
                        perfilinvestigador.iniciarFrameModificar();
                    }

                    break;
            }
        }
        if (e.getSource() == jfprincipal.lblContacto) {
            Contacto contacto = new Contacto();
            contacto.goToURL(contacto.url());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pdao = new PersonaDAO();
        if (e.getSource() == jfprincipal.btnComenzar) {
            if (pdao.retornaPersonaBoolean(usuario.getIdUsuario())) {
                jfprincipal.dispose();
                Controlador_informacionPruebasAdquisicion cfip = new Controlador_informacionPruebasAdquisicion(usuario);
                cfip.IniciarFrame();

            } else {
                JOptionPane.showMessageDialog(null, "Para continuar, complete su información de perfil");
            }

        }
        if (e.getSource() == jfprincipal.btnEliminar) {
            int inicio = jfprincipal.jtableRegistros.getSelectedRow();
            if (inicio > -1) {
                String id = String.valueOf(jfprincipal.jtableRegistros.getValueAt(inicio, 0));
                int respuesta = JOptionPane.showConfirmDialog(null, "!Advertencia¡\nse eliminara el registro de su historial");
                int id_inf = Integer.parseInt(id);
                if (respuesta == 0) {
                    pruebaDAO = new InfoPruebaDAO();
                    pruebaDAO.borrarRegistro(id_inf);
                    registros();
                }
            }
        }

    }
}
