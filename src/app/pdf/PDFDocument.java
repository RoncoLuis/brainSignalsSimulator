package app.pdf;

import app.model.InfoPruebaDAO;
import app.model.PersonaDAO;
import app.model.InfoPrueba;
import app.model.Persona;
import app.model.Usuario;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class PDFDocument {

    private final String LOGO = "C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/src/recursos/imagenes/logos/itleon.png";
    private final String reportejasper = "C:/Users/LR21/JaspersoftWorkspace/Reportes/formato1.jasper";
    private final String salidaReporte = "C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/reportes_generados/";
    private Usuario usuario = null;
    private File fichero = null;
    private JPanel panel = null;

    public PDFDocument(Usuario usuario, File fichero, JPanel panel) {
        this.usuario = usuario;
        this.fichero = fichero;
        this.panel = panel;
    }

    public void generarPDF() {
        //String partes[] = fichero.getName().split(".");
        //String nombre_archivo = partes[0];

        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportejasper);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, retornaParametros(), new JREmptyDataSource());

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea visualizar el reporte ahora?");
            if (respuesta == 0) {
                JasperViewer viewer = new JasperViewer(jasperPrint);                
                viewer.pack();
                viewer.setVisible(true);
                JasperExportManager.exportReportToPdfFile(jasperPrint, salidaReporte + fichero.getName() + ".pdf");
            } else {
                /*descomentar esta linea para exportar los reportes a formato pdf*/
                JasperExportManager.exportReportToPdfFile(jasperPrint, salidaReporte + fichero.getName() + ".pdf");
            }
        } catch (JRException ex) {
            Logger.getLogger(PDFDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Map<String, Object> retornaParametros() {
        Map<String, Object> parametros = new HashMap<>();
        Persona persona = retornaInfoPersona();
        InfoPruebaDAO infodao = new InfoPruebaDAO();
        InfoPrueba infoprueba = infodao.retornarpruebapornombrearchivo(fichero.getName());
        int captotal = Integer.parseInt(infoprueba.getCapturas()) * 16;
        String captotales = String.valueOf(captotal);
        parametros.put("nombre", persona.getPNombre());
        parametros.put("ap_paterno", persona.getPApPaterno());
        parametros.put("ap_materno", persona.getPApMaterno());
        parametros.put("correo_electronico", usuario.getUCorreo());
        parametros.put("usuario", usuario.getUNombre());
        parametros.put("nombre_archivo", infoprueba.getNombreArchivo());
        parametros.put("fecha_creacion", infoprueba.getFcreacion());
        parametros.put("autor", infoprueba.getAutor());
        parametros.put("tamanio", infoprueba.getTamanio());
        parametros.put("capturas", infoprueba.getCapturas());
        parametros.put("total_capturas", captotales);
        parametros.put("duracion", infoprueba.getDuracion());
        parametros.put("comentarios", infoprueba.getComentarios());
        parametros.put("chart", createImagen(panel));
        return parametros;
    }

    private Persona retornaInfoPersona() {
        PersonaDAO pdao = new PersonaDAO();
        Persona p = pdao.retornaPersona(usuario.getIdUsuario());
        return p;
    }

    public static BufferedImage redimensionaChart(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage imagenRedimensionada = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = imagenRedimensionada.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return imagenRedimensionada;
    }

    private BufferedImage createImagen(JPanel panel) {

        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return (bi);

    }

}
