package pruebas;

import app.utils.Coordenadas;
import app.utils.Graficador;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.JFreeChart;

public class PruebaReportes {

    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage imagenRedimensionada = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = imagenRedimensionada.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return imagenRedimensionada;
    }

    public BufferedImage createImage(JPanel panel) {

        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return (bi);
    }

    public static void main(String[] args) throws IOException {

        Graficador graficar = new Graficador(1, "grafica 1", "tiempo", "voltaje");
        File fichero = new File("C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/pruebas_de_adquisicion/luisronquillo,May 07 2018  9.19.04.750 PM/luisronquillo,63.68s,200,SOS.txt");

        ArrayList<Coordenadas> lista = graficar.transformafichero(fichero);
        graficar.agregarGrafica(lista);
        JFreeChart chart = graficar.obtenerChart();
        BufferedImage imagen = chart.createBufferedImage(400, 400);

        Map<String, Object> parametros = new HashMap();
        parametros.put("nombre", "Luis");
        parametros.put("ap_paterno", "RONQUILLO");
        parametros.put("ap_materno", "ORDOÑEZ");
        parametros.put("correo_electronico", "luis@luis.com");
        parametros.put("usuario", "Luis");
        parametros.put("nombre_archivo", "Luis,prueba,103.txt");
        parametros.put("fecha_creacion", "27-02-1994");
        parametros.put("autor", "LuisR");
        parametros.put("tamanio", "50kb");
        parametros.put("capturas", "200");
        parametros.put("total_capturas", "1200");
        parametros.put("duracion", "103s");
        parametros.put("comentarios", "este comentario es una prueba para la generacion de los reportes");
        parametros.put("chart", resize(imagen, 1020, 800));

        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("C:/Users/LR21/JaspersoftWorkspace/Reportes/formato1.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());

            JasperViewer view = new JasperViewer(jasperPrint);
            view.setVisible(true);

            /*descomentar esta linea para exportar los reportes a formato pdf*/
            //JasperExportManager.exportReportToPdfFile(jasperPrint,"nuevo.pdf");
        } catch (JRException ex) {
            Logger.getLogger(PruebaReportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
