package app.controllers;

import app.utils.Arduino;
import app.views.View_controlLuces;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Controlador_lucesArduino extends MouseAdapter {

    private View_controlLuces frame = null;
    private final Arduino arduino;

    public Controlador_lucesArduino() {
        this.arduino = new Arduino();
    }

    public boolean iniciarFrame() {
        boolean resp = false;
        if (arduino.conexionTX("COM3", 9600)) {
            resp = true;
            frame = new View_controlLuces();
            frame.setVisible(true);

            switchsInicio();

            //atrapar acciones de los switchs
            frame.switch1.addMouseListener(this);
            frame.switch2.addMouseListener(this);
            frame.switch3.addMouseListener(this);
            frame.switch4.addMouseListener(this);
            frame.switch5.addMouseListener(this);

            //atrapar acciones de label apagar y salir
            frame.lblApagar.addMouseListener(this);
            frame.lblSalir.addMouseListener(this);
        }
        return resp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == frame.switch1) {
            if (frame.switch1.isOnOff()) {
                int resp = JOptionPane.showConfirmDialog(frame, "enviar intermitencia 1?");
                if (resp == 0) {
                    arduino.enviarDato("1");
                    frame.switch2.setEnabled(false);
                    frame.switch3.setEnabled(false);
                    frame.switch4.setEnabled(false);
                    frame.switch5.setEnabled(false);
                } else {
                    frame.switch1.setOnOff(false);
                    frame.switch1.repaint();
                }

            }
        }
        if (e.getSource() == frame.switch2) {
            if (frame.switch2.isOnOff()) {
                int resp = JOptionPane.showConfirmDialog(frame, "enviar intermitencia 2?");
                if (resp == 0) {
                    arduino.enviarDato("2");
                    frame.switch1.setEnabled(false);
                    frame.switch3.setEnabled(false);
                    frame.switch4.setEnabled(false);
                    frame.switch5.setEnabled(false);
                } else {
                    frame.switch2.setOnOff(false);
                    frame.switch2.repaint();
                }
            }
        }
        if (e.getSource() == frame.switch3) {
            if (frame.switch3.isOnOff()) {
                int resp = JOptionPane.showConfirmDialog(frame, "enviar intermitencia 3?");
                if (resp == 0) {
                    arduino.enviarDato("3");
                    frame.switch1.setEnabled(false);
                    frame.switch2.setEnabled(false);
                    frame.switch4.setEnabled(false);
                    frame.switch5.setEnabled(false);
                } else {
                    frame.switch3.setOnOff(false);
                    frame.switch3.repaint();
                }
            }
        }
        if (e.getSource() == frame.switch4) {
            if (frame.switch4.isOnOff()) {
                int resp = JOptionPane.showConfirmDialog(frame, "enviar intermitencia 4?");
                if (resp == 0) {
                    arduino.enviarDato("4");
                    frame.switch1.setEnabled(false);
                    frame.switch2.setEnabled(false);
                    frame.switch3.setEnabled(false);
                    frame.switch5.setEnabled(false);
                } else {
                    frame.switch4.setOnOff(false);
                    frame.switch4.repaint();
                }
            }
        }
        if (e.getSource() == frame.switch5) {
            if (frame.switch5.isOnOff()) {
                int resp = JOptionPane.showConfirmDialog(frame, "enviar intermitencia 5?");
                if (resp == 0) {
                    arduino.enviarDato("5");
                    frame.switch1.setEnabled(false);
                    frame.switch2.setEnabled(false);
                    frame.switch3.setEnabled(false);
                    frame.switch4.setEnabled(false);
                } else {
                    frame.switch5.setOnOff(false);
                    frame.switch5.repaint();
                }
            }
        }
        if (e.getSource() == frame.lblApagar) {
            arduino.enviarDato("0");
            switchsInicio();
        }
        if (e.getSource() == frame.lblSalir) {
            arduino.enviarDato("0");
            if (arduino.terminarConexion()) {

                this.frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "No se ha podido cerrar conexion, debe apagar primero");
            }

        }

    }

    private void switchsInicio() {
        frame.switch1.setEnabled(true);
        frame.switch1.setOnOff(false);
        frame.switch1.repaint();

        frame.switch2.setEnabled(true);
        frame.switch2.setOnOff(false);
        frame.switch2.repaint();

        frame.switch3.setEnabled(true);
        frame.switch3.setOnOff(false);
        frame.switch3.repaint();

        frame.switch4.setEnabled(true);
        frame.switch4.setOnOff(false);
        frame.switch4.repaint();

        frame.switch5.setEnabled(true);
        frame.switch5.setOnOff(false);
        frame.switch5.repaint();
    }

}
