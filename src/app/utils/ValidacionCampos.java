package app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ValidacionCampos {

    char clave;
    byte contNumero = 0;
    byte contLetraMay = 0;
    byte contLetraMin = 0;
    private Pattern pattern;
    private Matcher matcher;
    final String regexusuario = "^[a-z0-9_-]{3,16}$";

    public boolean validausuario(String usuario) {
        boolean resp = false;
        pattern = Pattern.compile(regexusuario, Pattern.MULTILINE);
        matcher = pattern.matcher(usuario);
        
        if (matcher.find()) {
            resp = true;
            System.out.println(resp);
        } else {
            System.out.println(resp);
        }

        return resp;
    }
    
    public boolean camposVacios( String texto ){
    return texto.equals("");
    }
    

    public boolean validapass(String password) {
        boolean resp = false;

        for (byte i = 0; i < password.length(); i++) {
            clave = password.charAt(i);
            String passValue = String.valueOf(clave);
            if (passValue.matches("[A-Z]")) {
                contLetraMay++;
            } else if (passValue.matches("[a-z]")) {
                contLetraMin++;
            } else if (passValue.matches("[0-9]")) {
                contNumero++;
            }
        }
        if (password.length() < 8) {
            System.out.println("al menos 8 carateres");
        } else {
            if (contLetraMay >= 2 && contNumero >= 1) {
                System.out.println("contraseña válida");
                resp = true;
            } else {
                System.out.println("Cantidad de letras mayusculas:" + contLetraMay);
                System.out.println("Cantidad de numeros:" + contNumero);
                JOptionPane.showMessageDialog(null, "la contraseña no es válida, al menos dos mayúscula y un número");
                System.out.println(password);
            }
        }
        return resp;
    }

    public boolean validaEmail(String correo) {
        boolean valido = false;
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // El email a validar
        Matcher mather = pattern.matcher(correo);

        if (mather.find() == true) {
            valido = true;
            System.out.println("El email ingresado es válido.");
        } else {
            JOptionPane.showMessageDialog(null, "El correo ingresado no se acepto como válido, intente de nuevo");
        }
        return valido;
    }

}
