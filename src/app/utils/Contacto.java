package app.utils;

import java.io.IOException;
import java.net.URISyntaxException;

public class Contacto {

    public void goToURL(String url) {
        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(url);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    ex.getMessage();
                }
            }
        }
    }
    
    public String url (){
    String pagina= "https://residencias2018.webcindario.com/";
    return pagina;
    }

}