package app.controllers;

import app.model.Usuario;
import app.pdf.PDFDocument;
import app.utils.Coordenadas;
import app.utils.Graficador;
import app.utils.ValidaNumero;
import app.views.View_graficas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controlador_graficas extends MouseAdapter {

    private View_graficas gyr = null;
    private Graficador graficador = null;
    private File fichero = null;
    private Usuario usuario = null;
    private ArrayList<Coordenadas> lista = null;

    public Controlador_graficas(Usuario usuario, File fichero) {
        this.usuario = usuario;
        this.fichero = fichero;
    }

    public void iniciarFrame() {
        gyr = new View_graficas();
        //gyr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //gyr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        gyr.setLocationRelativeTo(null);
        gyr.setVisible(true);        
        gyr.lblGraficar.addMouseListener(this);
        gyr.lblReporte.addMouseListener(this);
        gyr.lblSalir.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == gyr.lblGraficar) {
            String tipog = JOptionPane.showInputDialog("ingrese tipo de gráfica \n1.Lineal"
                    + "\n2.Polar\n3.Dispersión\n4.Área\n5.Logarítmica\n6.Serie de tiempo\n7.Paso\n8.Paso Área");
            if (tipoGrafica(tipog)) {
                int tipo = Integer.parseInt(tipog);
                String nombreg = nombreGrafica(tipo);
                graficador = new Graficador(tipo, nombreg, "Tiempo(s)", "Voltaje(v)");
                lista = graficador.transformafichero(fichero);
                graficador.agregarGrafica(lista);
                gyr.pnl_chart.add(graficador.obtenerGrafica());
                gyr.pnl_chart.validate();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese solo los numero listados en el menú", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == gyr.lblReporte) {
            /*generar el reporte*/
            PDFDocument reporte = new PDFDocument(usuario, fichero, gyr.pnl_chart);
            reporte.generarPDF();

        }

        if (e.getSource() == gyr.lblSalir) {
            gyr.dispose();
            Controlador_informacionPruebasAdquisicion pruebas = new Controlador_informacionPruebasAdquisicion(usuario);
            pruebas.IniciarFrame();
        }
    }

    private String nombreGrafica(int tipog) {
        String tipo = "";
        switch (tipog) {
            case 1:
                tipo = "Lineal";
                break;
            case 2:
                tipo = "Polar";
                break;
            case 3:
                tipo = "Dispersión";
                break;
            case 4:
                tipo = "Área";
                break;
            case 5:
                tipo = "Logarítmica";
                break;
            case 6:
                tipo = "Serie de tiempo";
                break;
            case 7:
                tipo = "Paso";
                break;
            case 8:
                tipo = "Paso Área";
                break;

        }
        return tipo;
    }

    private boolean tipoGrafica(String tipog) {
        boolean resp = false;
        ValidaNumero validar = new ValidaNumero();
        if (validar.valida(tipog)) {
            int tipo = Integer.parseInt(tipog);
            switch (tipo) {
                case 1:
                    resp = true;
                    break;
                case 2:
                    resp = true;
                    break;
                case 3:
                    resp = true;
                    break;
                case 4:
                    resp = true;
                    break;
                case 5:
                    resp = false;
                    break;
                case 6:
                    resp = true;
                    break;
                case 7:
                    resp = true;
                    break;
                case 8:
                    resp = true;
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese sólo uno de los numeros listados en el menú", "Advertencia!", JOptionPane.WARNING_MESSAGE);
        }

        return resp;
    }
}
