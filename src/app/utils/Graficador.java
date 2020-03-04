package app.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * serie de graficas para tipo de datos x,y
 */
public class Graficador {

    JFreeChart graficas;
    XYSeriesCollection datos = new XYSeriesCollection();
    String titulo;
    String titulox;
    String tituloy;
    final static int LINEAL = 1;
    final static int POLAR = 2;
    final static int DISPERSION = 3;
    final static int AREA = 4;
    final static int LOGARITMICA = 5;
    final static int SERIETIEMPO = 6;
    final static int PASO = 7;
    final static int PASOAREA = 8;

    public Graficador(int tipo, String titulo, String titulox, String tituloy) {
        this.titulo = titulo;
        this.titulox = titulox;
        this.tituloy = tituloy;
        tipoGrafica(tipo);

    }

    private void tipoGrafica(int tipo) {
        switch (tipo) {
            case LINEAL:
                graficas = ChartFactory.createXYLineChart(titulo, titulox, tituloy, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case POLAR:
                graficas = ChartFactory.createPolarChart(titulo, datos, true, true, true);
                break;
            case DISPERSION:
                graficas = ChartFactory.createScatterPlot(titulo, titulox, tituloy, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case AREA:
                graficas = ChartFactory.createXYAreaChart(titulo, titulox, tituloy, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case LOGARITMICA:
                graficas = ChartFactory.createXYLineChart(titulo, titulox, tituloy, datos, PlotOrientation.VERTICAL, true, true, true);
                XYPlot ejes = graficas.getXYPlot();
                NumberAxis rango = new LogarithmicAxis(tituloy);
                ejes.setRangeAxis(rango);
                break;
            case SERIETIEMPO:
                graficas = ChartFactory.createTimeSeriesChart(titulo, titulox, tituloy, datos, true, true, true);
                break;
            case PASO:
                graficas = ChartFactory.createXYStepChart(titulo, titulox, tituloy, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case PASOAREA:
                graficas = ChartFactory.createXYStepAreaChart(titulo, titulox, tituloy, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
        }
    }

    public ArrayList<Coordenadas> transformafichero(File fichero) {
        ArrayList<Coordenadas> lista = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(fichero);
            while (scanner.hasNext()) {
                String linea = scanner.nextLine();
                String[] cortaString = linea.split(",");
                Coordenadas c = new Coordenadas();
                c.setX(Double.parseDouble(cortaString[0]));
                c.setY(Double.parseDouble(cortaString[1]));
                c.setGrupo(Integer.parseInt(cortaString[2]));
                lista.add(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (scanner != null) {
                    scanner.close();
                }
            } catch (Exception ex) {
                ex.getLocalizedMessage();
            }
        }
        return lista;
    }

    public void agregarGrafica(ArrayList<Coordenadas> lista) {
        CrearDataSet dataset = new CrearDataSet();
        ArrayList<Coordenadas> v0 = new ArrayList<>();
        ArrayList<Coordenadas> v1 = new ArrayList<>();
        ArrayList<Coordenadas> v2 = new ArrayList<>();
        ArrayList<Coordenadas> v3 = new ArrayList<>();
        ArrayList<Coordenadas> v4 = new ArrayList<>();
        ArrayList<Coordenadas> v5 = new ArrayList<>();
        ArrayList<Coordenadas> v6 = new ArrayList<>();
        ArrayList<Coordenadas> v7 = new ArrayList<>();
        ArrayList<Coordenadas> v8 = new ArrayList<>();
        ArrayList<Coordenadas> v9 = new ArrayList<>();
        ArrayList<Coordenadas> v10 = new ArrayList<>();
        ArrayList<Coordenadas> v11 = new ArrayList<>();
        ArrayList<Coordenadas> v12 = new ArrayList<>();
        ArrayList<Coordenadas> v13 = new ArrayList<>();
        ArrayList<Coordenadas> v14 = new ArrayList<>();
        ArrayList<Coordenadas> v15 = new ArrayList<>();

        lista.stream().filter((c) -> (c.getGrupo() == 1)).forEachOrdered((c) -> {
            v0.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 2)).forEachOrdered((c) -> {
            v1.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 3)).forEachOrdered((c) -> {
            v2.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 4)).forEachOrdered((c) -> {
            v3.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 5)).forEachOrdered((c) -> {
            v4.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 6)).forEachOrdered((c) -> {
            v5.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 7)).forEachOrdered((c) -> {
            v6.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 8)).forEachOrdered((c) -> {
            v7.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 9)).forEachOrdered((c) -> {
            v8.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 10)).forEachOrdered((c) -> {
            v9.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 11)).forEachOrdered((c) -> {
            v10.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 12)).forEachOrdered((c) -> {
            v11.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 13)).forEachOrdered((c) -> {
            v12.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 14)).forEachOrdered((c) -> {
            v13.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 15)).forEachOrdered((c) -> {
            v14.add(c);
        });
        lista.stream().filter((c) -> (c.getGrupo() == 16)).forEachOrdered((c) -> {
            v15.add(c);
        });

        XYSeries V0 = dataset.serieXY("V1", v0);
        XYSeries V1 = dataset.serieXY("V2", v1);
        XYSeries V2 = dataset.serieXY("V3", v2);
        XYSeries V3 = dataset.serieXY("V4", v3);
        XYSeries V4 = dataset.serieXY("V5", v4);
        XYSeries V5 = dataset.serieXY("V6", v5);
        XYSeries V6 = dataset.serieXY("V7", v6);
        XYSeries V7 = dataset.serieXY("V8", v7);
        XYSeries V8 = dataset.serieXY("9", v8);
        XYSeries V9 = dataset.serieXY("V10", v9);
        XYSeries V10 = dataset.serieXY("V11", v10);
        XYSeries V11 = dataset.serieXY("V12", v11);
        XYSeries V12 = dataset.serieXY("V13", v12);
        XYSeries V13 = dataset.serieXY("V14", v13);
        XYSeries V14 = dataset.serieXY("V15", v14);
        XYSeries V15 = dataset.serieXY("V16", v15);

        datos.addSeries(V0);
        datos.addSeries(V1);
        datos.addSeries(V2);
        datos.addSeries(V3);
        datos.addSeries(V4);
        datos.addSeries(V5);
        datos.addSeries(V6);
        datos.addSeries(V7);
        datos.addSeries(V8);
        datos.addSeries(V9);
        datos.addSeries(V10);
        datos.addSeries(V11);
        datos.addSeries(V12);
        datos.addSeries(V13);
        datos.addSeries(V14);
        datos.addSeries(V15);

    }

    public JPanel obtenerGrafica() {
        return new ChartPanel(obtenerChart());
    }
    
    public JFreeChart obtenerChart(){
    JFreeChart chart = graficas;
    
    /*definir propiedades de la grafica*/
    chart.setBorderPaint(Color.WHITE);
    chart.setBorderPaint(Color.BLACK);    
    chart.setBorderStroke(new BasicStroke(1));
    chart.setBorderVisible(true);
    
    return chart;
    }
}
