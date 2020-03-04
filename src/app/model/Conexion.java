/*
* @author: Luis Eduardo Ronquillo
* @date: 9-16-2018
* @version: v.2
* clase de conexión a la base de datos, metodos para abrir y cerrar la conexón

*/
package app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private String USERNAME = "root";
    private String PASSWORD = "";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE_NAME = "bd_psnl";
    private String DRIVER = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE_NAME + "?useSSL=false";
    private Connection conn;

    public Conexion() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error de conexion:{0}", e.getMessage());
        }

    }

    public Connection getConnetion() {
        return conn;
    }

    public void cierraConexion() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
