package app.utils;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Arduino {

    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    List<String> listapuertos = null;
    byte bytes[];

    public boolean conexionTX(String puerto, int data_range) {
        boolean conexion = false;
        try {
            arduino.arduinoTX(puerto, data_range);
            conexion = true;
            System.out.println("conexion establecida puerto -->" + puerto);
        } catch (ArduinoException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public boolean conexionRX(String puerto, int data, SerialPortEventListener evento) {
        boolean resp = false;
        try {
            arduino.arduinoRX(puerto, data, evento);
            resp = true;
        } catch (ArduinoException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public boolean terminarConexion() {
        boolean resp = false;
        try {
            arduino.killArduinoConnection();
            resp = true;
        } catch (ArduinoException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int puertosActivos() {
        int puertos = 0;
        puertos = arduino.getPortsAvailable();
        return puertos;
    }

    public List<String> listaPuertos() {
        listapuertos = new ArrayList<>();
        listapuertos = arduino.getSerialPorts();        
        return listapuertos;
    }

    public boolean msjDisponible() {
        boolean resp = false;
        try {
            resp = arduino.isMessageAvailable();
        } catch (SerialPortException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArduinoException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public String mensaje() {
        String mensaje = "";
        try {
            mensaje = arduino.printMessage();
        } catch (SerialPortException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArduinoException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

    public void enviarDato(String dato) {
        try {
            arduino.sendData(dato);
        } catch (ArduinoException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Arduino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
