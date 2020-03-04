package pruebas;

import app.controllers.Controlador_informacionPruebasAdquisicion;
import app.controllers.Controlador_lucesArduino;
import app.controllers.Controlador_graficas;
import app.controllers.Controlador_registro;
import app.controllers.ControladorJFrameGraficas;
import app.controllers.Controlador_inicioSesion;
import app.model.DocenteDAO;
import app.model.EstudianteDAO;
import app.model.InfoPruebaDAO;
import app.model.InvestigadorDAO;
import app.model.PersonaDAO;
import app.model.UsuarioDAO;
import app.model.InfoPrueba;
import app.model.Persona;
import app.model.Usuario;
import app.utils.Arduino;
import app.utils.Coordenadas;
import app.utils.FechaActual;
import app.utils.GenerarPDF;
import app.utils.Graficador;
import app.views.View_informacionPruebasAdquisicion;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortException;
import org.jfree.chart.JFreeChart;

public class PruebaRegistroUsuario {

    public static void main(String arg[]) {

        
        PersonaDAO pdao = new PersonaDAO();
        pdao.retornaPersonaBoolean(29);
//            InfoPruebaDAO dao = new InfoPruebaDAO();
//            InfoPrueba info = new InfoPrueba();
//        Graficador graficar = new Graficador(1, "grafica 1", "tiempo", "voltaje");
//        File fichero = new File("C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/pruebas_de_adquisicion/luisronquillo,May 07 2018  9.19.04.750 PM/luisronquillo,63.68s,200,SOS.txt");
//        InfoPruebaDAO infodao = new InfoPruebaDAO();
//        InfoPrueba prueba = infodao.retornarpruebapornombrearchivo(fichero.getName());
//        System.out.println("nombre "+ prueba.getNombreArchivo());
//        System.out.println("autor "+ prueba.getAutor());
//        System.out.println("nombre "+ prueba.getCapturas());
//        System.out.println("nombre "+ prueba.getComentarios());
//        ArrayList<Coordenadas> lista = graficar.transformafichero(fichero);
//        graficar.agregarGrafica(lista);
//        JFreeChart chart = graficar.obtenerChart();                                     
//        UsuarioDAO udao = new UsuarioDAO();
//        Usuario usuario = udao.retornaUsuario2(11);
//        InfoPruebaDAO infodao = new InfoPruebaDAO();
//        InfoPrueba info = infodao.retornaPrueba(20);
//        GenerarPDF pdf = new GenerarPDF(usuario, info, chart);      
//        pdf.generaPDF();
        

//        PersonaDAO dao = new PersonaDAO();
//        Persona p = dao.retornaPersona(usuario.getIdUsuario());
//        System.out.println("nombre " + p.getPNombre());
//            
//            
//            System.out.println("nombre "+info.getAutor());
//        C_Arduino control = new C_Arduino();
//        control.iniciarFrame();
//        Arduino arduino = new Arduino();
//        if (arduino.conexionTX("COM3", 9600)) {
//            arduino.enviarDato("1");
//        }
//        C_GraficasyReportes cgyr = new C_GraficasyReportes();
//        cgyr.iniciarFrame();
//        C_Inicio_Sesion c = new C_Inicio_Sesion();
//        c.iniciarFrame();
//        Usuario u = new Usuario();
//        u.setIdUsuario(7);
//
//PersonaDAO p = new PersonaDAO();
//        EstudianteDAO e = new EstudianteDAO();
//        //FechaActual fecha = new FechaActual();
//        boolean r = e.updateEstudiante(12345670, "Insdustrial", 12, 19);
//        System.out.println(r);
//boolean resp = p.updatePersona("nuevo", "modificado", "modificado", "M", fecha.obtenerFechaActual(), 19);
//System.out.println(resp);
//        EstudianteDAO e = new EstudianteDAO();
//        e.retornaEstudiante(u);
//        
//        DocenteDAO d= new DocenteDAO();
//        d.retornaDocente(12);
////        
//        InvestigadorDAO i = new InvestigadorDAO();
//        i.retornaInvestigador(11);
//        C_Inicio_Sesion cis = new C_Inicio_Sesion();
//        cis.iniciarFrame();
//        
//          InfoPruebaDAO info = new InfoPruebaDAO();
//          ArrayList<InfoPrueba> listaPruebas=   info.listarPruebas(11);
//          for (int i = 0; i < listaPruebas.size(); i++) {
//              System.out.println("usuario"+listaPruebas.get(i).getAutor());
//        }
//        java.util.Date date = new Date();
//        java.sql.Date fechaActual = new java.sql.Date(date.getTime());
//        Usuario usuario = new Usuario(1, "luis", "correo", "passs", fechaActual);
//        CJFPrincipalEstudiante cjfpe = new CJFPrincipalEstudiante(usuario);
//        cjfpe.iniciarFrame();
//        File fichero = new File("C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/CursoMatlab/luisRonquiollo,95.68s,300,Intermitente_2.txt");
//        ControladorJFrameGraficas cjfg = new ControladorJFrameGraficas(fichero);
//        CFrameIniciarPruebas cfip = new CFrameIniciarPruebas(jfip);
//        InfoPrueba ip = new InfoPrueba("prueba","luis","2018-04-15","3.00KB","9.98s","500","este es un comentario de prueba, debe poder insertarse desde la aplicacion en java",000011);
//        InfoPruebaDAO aO = new InfoPruebaDAO();
//        aO.insertInfoPrueba(ip);
//
//
// Usuario u = new Usuario(3, "Probando", "Prueba@gmail.com", "prueba", fechaActual);   
//        Usuario u = new Usuario();
//        String correo = "luis@luis.com";
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//        ArrayList<Usuario> usuarios = usuarioDAO.buscarUsuario(correo);
//        if (usuarios.isEmpty()) {
//            System.out.println("no encontrado");
//        } else {
//            for (int i = 0; i < usuarios.size(); i++) {
//                int id_usuario = usuarios.get(i).getIdUsuario();
//                String nombre = usuarios.get(i).getUNombre();
//                String mail = usuarios.get(i).getUCorreo();
//                int tipo = usuarios.get(i).getUTipo();
//                Date fecha = usuarios.get(i).getUFechaReg();
//                System.out.println(id_usuario);
//                System.out.println(nombre);
//                System.out.println(mail);
//                System.out.println(tipo);
//                System.out.println(fecha);
//            }
//        }
//        usuarioDAO.borrarUsuario(u);
//        Persona p = new Persona("prueba","pruebaPat","pruebaMat","F", fechaActual,9);
//        PersonaDAO personaDAO = new PersonaDAO();
//        personaDAO.insertPersona(p);
//         List<Usuario> usuarios = usuarioDAO.datosUsuario("MarthaR", "martha");
//               int id_usuario =  usuarios.get(0).getIdUsuario();
//               String nombre = usuarios.get(0).getUNombre();
//               String correo = usuarios.get(0).getUCorreo();
//               int tipo = usuarios.get(0).getUTipo();
//               System.out.println(id_usuario);
//               System.out.println(nombre);
//               System.out.println(correo);
//               System.out.println(tipo);
//int tipo = usuarioDAO.accesoUsuario("MarthaR", "martha");
//int id_usuario = usuarioDAO.retornaID("MarthaR");
//System.out.println("tipo de usuario: "+tipo+"\n");
// System.out.println("id_usuario: "+id_usuario);
//        List<Usuario> us = usuarioDAO.listarUsuarios();
//        us.forEach((u) -> {
//            System.out.println(u.getIdUsuario() + "," + u.getUNombre() + "," + u.getUCorreo()
//            +","+u.getUTipo()+","+u.getUFechaReg());
//        });
//usuarioDAO.insertaUsuario(u);
//ControladorFrameRegistro cfr = new ControladorFrameRegistro(usuarioDAO);
//        ControladorFrameInicioSesion cfis = new ControladorFrameInicioSesion(usuarioDAO);
    }
}
