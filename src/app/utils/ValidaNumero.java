package app.utils;

public class ValidaNumero {

    int numero;

    public boolean valida(String cadena) {
        boolean resp = false;

        try {
            numero = Integer.parseInt(cadena);
            resp = true;
        } catch (NumberFormatException ex) {
            ex.getMessage();

        }
        return resp;
    }
}
