/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;




import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class ControlArduino {

    private static PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    private static final SerialPortEventListener listener = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (arduino.isMessageAvailable()) {
                    System.out.println(arduino.receiveData());
                }
            } catch (SerialPortException ex) {
                Logger.getLogger(ControlArduino.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ArduinoException ex) {
                Logger.getLogger(ControlArduino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    public static void main(String args[]) {

        try {
            arduino.arduinoTX("COM3", 9600);
            String dato = JOptionPane.showInputDialog(null,"encender? 1-0");
            arduino.sendData(dato);
            int resp = JOptionPane.showConfirmDialog(null, "terminar");
            if (resp == 0) {
                //String apagar = JOptionPane.showInputDialog(null,"apagar? 2");
                arduino.sendData("2");
                arduino.killArduinoConnection();
            }
        } catch (ArduinoException ex) {
            Logger.getLogger(ControlArduino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(ControlArduino.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
//virtualSerialPortDriver