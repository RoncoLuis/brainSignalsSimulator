package app.utils;

import app.model.PersonaDAO;
import app.model.InfoPrueba;
import app.model.Persona;
import app.model.Usuario;
import com.itextpdf.awt.DefaultFontMapper;

import com.itextpdf.text.BadElementException;
import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.JFreeChart;

public class GenerarPDF {

    private final String LOGO = "C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/src/recursos/imagenes/logos/itleon.png";
    private final String PATH = "C:/Users/LR21/Documents/NetBeansProjects/Sistema Proyecto Residencias/reportes_generados/";
    private Usuario usuario = null;
    private InfoPrueba archivo_entrada = null;
    private File archivo_salida = null;
    private JFreeChart chart = null;
    PdfWriter writer;

    public GenerarPDF(Usuario usuario, InfoPrueba archivo_entrada, JFreeChart chart) {
        this.usuario = usuario;
        this.archivo_entrada = archivo_entrada;
        this.chart = chart;
    }

    public void generaPDF() {

        Document document = new Document(PageSize.A4);
        try {
            archivo_salida = new File(PATH + cortaString(archivo_entrada.getNombreArchivo()));
            writer = PdfWriter.getInstance(document, new FileOutputStream(archivo_salida));
            // writer.getInstance(document, new FileOutputStream(archivo_salida)).setStrictImageSequence(true); 
            document.open();

            document.add(getLogo());
            document.add(Chunk.NEWLINE);
            document.add(getHeader());
            document.add(Chunk.NEWLINE);
            document.add(getInformacionUsuario());
            document.add(Chunk.NEWLINE);
            document.add(getInformacionPrueba());
            document.add(Chunk.NEWLINE);
            document.add(insertarChart(chart));
            document.add(getFooter());

            document.close();

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*cambiar a private*/
    public Image insertarChart(JFreeChart chart) throws BadElementException {
        Image image = null;        
        PdfContentByte cb = writer.getDirectContent();
        float width = PageSize.A4.getWidth() / 2;
        float height = PageSize.A4.getHeight() / 2;
        PdfTemplate plantillaGrafica = cb.createTemplate(width, height);
        //Graphics2D g2d1 = plantillaGrafica.createGraphics(width, height, new DefaultFontMapper());
        Graphics2D g2d1 = new PdfGraphics2D(plantillaGrafica, width, height,new DefaultFontMapper());        
        Rectangle2D r2d1 = new Rectangle2D.Double(0, 0, width, height);
        chart.draw(g2d1, r2d1);
        g2d1.dispose();
        image = Image.getInstance(plantillaGrafica);
        //cb.addTemplate(plantillaGrafica,0, height);
        return image;
    }

    private Paragraph getHeader() {
        Paragraph p = new Paragraph();
        p.add(new Phrase("Tecnológico Nacional de México\nInstituto Tecnológico de León"
                + "\nLaboratorio de Creatividad e Innovación Tecnológica", tipoContenido(1)));
        p.setAlignment(Element.ALIGN_CENTER);
        return p;
    }

    private Paragraph getInformacionUsuario() {
        Paragraph p = new Paragraph();
        PersonaDAO pdao = new PersonaDAO();
        Persona persona = pdao.retornaPersona(usuario.getIdUsuario());
        p.add(new Phrase("Informacion del autor del reporte", tipoContenido(2)));
        p.add(new Phrase(Chunk.NEWLINE));
        p.add(new Phrase("Autor: " + persona.getPNombre() + " " + persona.getPApPaterno() + " " + persona.getPApMaterno()
                + "\nUsuario: " + usuario.getUNombre()
                + "\nCorreo electronico: " + usuario.getUCorreo() + "\n", tipoContenido(3)));
        return p;
    }

    private Paragraph getInformacionPrueba() {
        Paragraph p = new Paragraph();
        int totalCapturas = Integer.parseInt(archivo_entrada.getCapturas()) * 16;

        p.add(new Phrase("Información de la prueba de adquisición", tipoContenido(2)));
        p.add(new Phrase(Chunk.NEWLINE));

        p.add(new Phrase("Nombre de la prueba: " + archivo_entrada.getNombreArchivo() + "\n"
                + "Fecha de creación: " + archivo_entrada.getFcreacion() + "\n"
                + "Autor de la prueba: " + archivo_entrada.getAutor() + "\n"
                + "Tamaño del archivo: " + archivo_entrada.getTamanio() + "\n"
                + "Número de capturas por sensor: " + archivo_entrada.getCapturas() + "\n"
                + "Número total de capturas analizadas: " + totalCapturas + "\n"
                + "Duración de la prueba: " + archivo_entrada.getDuracion(), tipoContenido(3)));
        return p;
    }

    private Paragraph getFooter() {
        Paragraph p = new Paragraph();
        p.add(new Phrase("Av.Tecnológico S/N Fracc. Industrial de Obregón. León, Guanajuato C.P. 37290.", tipoContenido(4)));
        return p;
    }

    private PdfPTable getLogo() {
        PdfPTable table = new PdfPTable(1);
        Image logo = null;
        try {
            logo = Image.getInstance(LOGO);
            logo.setAlignment(Image.ALIGN_CENTER);
            logo.setBorder(Image.BOX);
            logo.setBorderWidth(10);
            logo.setBorderColor(BaseColor.YELLOW);
            logo.scaleToFit(1000, 72);
            //logo.scaleAbsolute(130f, 130f);
            PdfPCell cell = new PdfPCell(logo);
            cell.setColspan(1);
            cell.setBorderColor(BaseColor.WHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

        } catch (BadElementException ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }

    private String cortaString(String fichero_entrada) {
        String fichero = "";
        String nombre_fichero = fichero_entrada;
        String[] cortar = nombre_fichero.split("\\.");
        fichero = cortar[0] + ".pdf";
        return fichero;
    }

    private Font tipoContenido(int tipo) {
        Font tipoContenido = null;
        switch (tipo) {
            case 1://titulos
                tipoContenido = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Font.UNDERLINE,
                        BaseColor.BLUE);
                break;
            case 2://subtitulo
                tipoContenido = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD,
                        BaseColor.DARK_GRAY);
                break;

            case 3://contenido
                tipoContenido = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL,
                        BaseColor.BLACK);
                break;

            case 4://pie de pagina
                tipoContenido = FontFactory.getFont(FontFactory.TIMES_ITALIC, 8, Font.UNDERLINE,
                        BaseColor.BLUE);
                break;
        }
        return tipoContenido;
    }

}
