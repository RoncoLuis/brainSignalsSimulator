package app.controllers;

import app.model.Usuario;
import app.utils.Coordenadas;
import app.views.JFrameGraficas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ControladorJFrameGraficas implements ActionListener {

    JFrameGraficas frameGraficas = null;
    private File fichero = null;
    private Scanner scanner = null;
    private Usuario usuario = null;
    ArrayList<Coordenadas> listaCoordenadas = null;

    public ControladorJFrameGraficas(File fichero, Usuario usuario) {
        this.fichero = fichero;
        this.usuario = usuario;
    }

    public void iniciarFrame() {
        frameGraficas = new JFrameGraficas();
        frameGraficas.setVisible(true);
        frameGraficas.btnXYLine.addActionListener(this);
        frameGraficas.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frameGraficas.btnXYLine) {
            listaCoordenadas = new ArrayList<>();
            try {
                scanner = new Scanner(fichero);
                while (scanner.hasNext()) {
                    String linea = scanner.nextLine();
                    String[] cortaString = linea.split(",");
                    Coordenadas c = new Coordenadas();
                    c.setX(Double.parseDouble(cortaString[0]));
                    c.setY(Double.parseDouble(cortaString[1]));
                    c.setGrupo(Integer.parseInt(cortaString[2]));
                    listaCoordenadas.add(c);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorJFrameGraficas.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (scanner != null) {
                        scanner.close();
                    }
                } catch (Exception ex) {
                    ex.getLocalizedMessage();
                }
            }
            GraficarPanel();
        }
        if (e.getSource() == frameGraficas.btnSalir) {
            frameGraficas.dispose();
            Controlador_informacionPruebasAdquisicion iniciarp = new Controlador_informacionPruebasAdquisicion(usuario);
            iniciarp.IniciarFrame();
        }

    }

    public void GraficarPanel() {
        ArrayList<Coordenadas> v1 = new ArrayList<>();
        ArrayList<Coordenadas> v2 = new ArrayList<>();
        ArrayList<Coordenadas> v3 = new ArrayList<>();
        ArrayList<Coordenadas> v4 = new ArrayList<>();

        listaCoordenadas.stream().filter((c) -> (c.getGrupo() == 1)).forEachOrdered((c) -> {
            v1.add(c);
        });
        listaCoordenadas.stream().filter((c) -> (c.getGrupo() == 2)).forEachOrdered((c) -> {
            v2.add(c);
        });
        listaCoordenadas.stream().filter((c) -> (c.getGrupo() == 3)).forEachOrdered((c) -> {
            v3.add(c);
        });
        listaCoordenadas.stream().filter((c) -> (c.getGrupo() == 4)).forEachOrdered((c) -> {
            v4.add(c);
        });

        XYSeries V1 = new XYSeries("sensor 1");
        for (int i = 0; i < v1.size(); i++) {
            V1.add(v1.get(i).getX(), v1.get(i).getY());
        }
        XYSeries V2 = new XYSeries("sensor 2");
        for (int i = 0; i < v2.size(); i++) {
            V2.add(v2.get(i).getX(), v2.get(i).getY());
        }
        XYSeries V3 = new XYSeries("sensor 3");
        for (int i = 0; i < v3.size(); i++) {
            V3.add(v3.get(i).getX(), v3.get(i).getY());
        }
        XYSeries V4 = new XYSeries("sensor 4");
        for (int i = 0; i < v4.size(); i++) {
            V4.add(v4.get(i).getX(), v4.get(i).getY());
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(V1);
        dataset.addSeries(V2);
        dataset.addSeries(V3);
        dataset.addSeries(V4);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "XYLineChart",
                "Tiempo",
                "Voltaje",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
        );

        ChartPanel panel = new ChartPanel(chart);
        frameGraficas.pnl_grafica.setLayout(new java.awt.BorderLayout());
        frameGraficas.pnl_grafica.add(panel);
        frameGraficas.pnl_grafica.validate();
    }
}
