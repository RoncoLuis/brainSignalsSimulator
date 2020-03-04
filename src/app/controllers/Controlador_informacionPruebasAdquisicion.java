package app.controllers;

import app.model.InfoPruebaDAO;
import app.model.InfoPrueba;
import app.model.Usuario;
import app.utils.FechaActual;
import app.utils.FiltroFileChooser;
import app.utils.FiltroPDF;
import app.utils.VisualizadorPDF;
import app.views.View_informacionPruebasAdquisicion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Controlador_informacionPruebasAdquisicion extends MouseAdapter implements ActionListener {

    View_informacionPruebasAdquisicion jfip = null;
    private Usuario u = null;
    private Runtime objRun = null;
    private final String MATLAB_EXE = "C:/Program Files/MATLAB/R2013b/bin/matlab.exe";
    private final String MATLAB_TXT = "C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/pruebas_de_adquisicion";
    private final String MATLAB_PDF = "C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/reportes_generados";
//private File file = null;
    private File fichero = null;
    private JFileChooser fileChooser = null;
    private InfoPrueba ip = null;
    private InfoPruebaDAO ipdao = null;

    public Controlador_informacionPruebasAdquisicion(Usuario u) {
        this.u = u;
    }

    public void IniciarFrame() {
        jfip = new View_informacionPruebasAdquisicion();
        jfip.setVisible(true);
        jfip.setLocationRelativeTo(null);
        jfip.btn_continuar.setEnabled(false);
        jfip.lblDatos.addMouseListener(this);
        jfip.lblTxt.addMouseListener(this);
        jfip.lblPdf.addMouseListener(this);
        jfip.lblTotales.addMouseListener(this);
        jfip.btn_continuar.addActionListener(this);
        jfip.btnRegresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ipdao = new InfoPruebaDAO();
        if (e.getSource() == jfip.btn_continuar) {
            if (jfip.btn_continuar.isEnabled()) {
                ip = infoPrueba();
                boolean resp = ipdao.insertInfoPrueba(ip);
                if (resp == true) {
                    jfip.dispose();
                    Controlador_graficas cgyr = new Controlador_graficas(u, fichero);
                    cgyr.iniciarFrame();
                } else {
                    System.out.println("error en btn continuar");
                }
            }
        }
        if (e.getSource() == jfip.btnRegresar) {
            //jfip.setVisible(false);
            jfip.dispose();
            Controlador_principal principal = new Controlador_principal(u);
            principal.iniciarFrame();

        }
    }

    private InfoPrueba infoPrueba() {
        ip = new InfoPrueba();
        FechaActual fechaActual = new FechaActual();
        ip.setNombreArchivo(jfip.txtNombreArchivo.getText());
        ip.setAutor(jfip.txtAutor.getText());
        ip.setFcreacion(jfip.txt_fcreacion.getText());
        ip.setTamanio(jfip.txt_tamArch.getText());
        ip.setDuracion(jfip.txt_duracionP.getText());
        ip.setCapturas(jfip.txt_ncapturas.getText());
        ip.setComentarios(jfip.txt_comentarios.getText());
        ip.setFecha_bitacora(fechaActual.obtenerFechaActual());
        ip.setInf_id_usuario(u.getIdUsuario());
        return ip;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jfip.lblDatos) {
            //TODO sino funciona quitar el boolean al metodo inciar frame de C_Arduino.java
            //realizar esta accion si iniciar frame retorna true
            Controlador_lucesArduino arduino = new Controlador_lucesArduino();
            if (arduino.iniciarFrame()) {
                objRun = Runtime.getRuntime();
                try {
                    objRun.exec(MATLAB_EXE);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador_informacionPruebasAdquisicion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error!, por favor asegure que el arduino esta conectado en COM3");
            }

        }

        if (e.getSource() == jfip.lblTxt) {
            FiltroFileChooser filtro = new FiltroFileChooser();
            Date fechaCreacion;
            SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");

            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(MATLAB_TXT));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

//            fileChooser.setFileFilter(filtro);
            int correcto = fileChooser.showOpenDialog(jfip);

            if (correcto == JFileChooser.APPROVE_OPTION) {
                fichero = fileChooser.getSelectedFile();
                if (filtro.accept(fichero)) {
                    try {
                        //------------ obteniendo datos del archivo ------------------
                        // nombre del archivo
                        String nombre_archivo = fichero.getName();
                        Path path = Paths.get(fichero.getAbsolutePath());
                        //Path path = FileSystems.getDefault().getPath(MATLAB_TXT, nombre_archivo);
                        BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

                        //fecha de creacion del archivo                        
                        Long fechamilis = basicView.readAttributes().creationTime().toMillis();
                        fechaCreacion = new Date(fechamilis);
                        String fecha_creacion = formato_fecha.format(fechaCreacion);

                        //tamaño en KBytes del archivo
                        DecimalFormat df = new DecimalFormat("0.00");
                        Long tamkB = basicView.readAttributes().size() / (1024);
                        String archivo_KB = df.format(tamkB) + "KB";

                        //obteniendo autor,duracion de la prueba,numero de capturas
                        String partes[] = nombre_archivo.split(",");
                        String autor = partes[0];
                        String duracion = partes[1];
                        String capturas = partes[2];
//                        String tipoluz = partes[3];
//                        String fecha = partes[4];

                        jfip.txtNombreArchivo.setText(nombre_archivo);
                        jfip.txtAutor.setText(autor);
                        jfip.txt_fcreacion.setText(fecha_creacion);
                        jfip.txt_tamArch.setText(archivo_KB);
                        jfip.txt_duracionP.setText(duracion);
                        jfip.txt_ncapturas.setText(capturas);
                        int totales = Integer.parseInt(capturas) * 16;
                        jfip.lblTotales.setText(String.valueOf(totales));
                        jfip.btn_continuar.setEnabled(true);
                    } catch (IOException ex) {
                        Logger.getLogger(Controlador_informacionPruebasAdquisicion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El archivo seleccionado no es de tipo .txt", "Upss!!", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

        if (e.getSource() == jfip.lblPdf) {
            FiltroPDF filtro = new FiltroPDF();
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(MATLAB_PDF));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.setFileFilter(filtro);

            int correcto = fileChooser.showOpenDialog(jfip);
            if (correcto == JFileChooser.APPROVE_OPTION) {
                fichero = fileChooser.getSelectedFile();
                
                if (filtro.accept(fichero)) {
                   // System.out.println(fichero.getAbsolutePath());
                    VisualizadorPDF pdf = new VisualizadorPDF();
                    pdf.visualizarReporte(fichero.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(fileChooser, "Archivo no válido, seleccione PDF");
                }

            }
        }

    }

}
