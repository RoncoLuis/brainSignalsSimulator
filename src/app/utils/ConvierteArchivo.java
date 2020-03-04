package app.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvierteArchivo {

    public static void main(String args[]) {

        File archivo = new File("C:\\Users\\LR21\\Downloads\\prueba1.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String reemplazo = null;
        String reemplazo2 = null;
        ArrayList<String> lista = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).             
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            lista = new ArrayList<>();

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                reemplazo = linea.replaceAll("\\[", "");
                reemplazo2 = reemplazo.replaceAll("\\]", "");
                lista.add(reemplazo2);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConvierteArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConvierteArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ConvierteArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Escritura
        try {
            FileWriter w = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            for (int i = 0; i < lista.size(); i++) {
                String linea = lista.toString().trim();
                wr.write(linea);//escribimos en el archivo 

            }
            //concatenamos en el archivo sin borrar lo existente
            //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
            //de no hacerlo no se escribirá nada en el archivo
            wr.close();
            bw.close();
        } catch (IOException e) {
            e.getMessage();
        };
    }

}
