package app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDAO {

    private final static String CANTIDAD_USUARIOS = "SELECT COUNT(*) FROM usuario";
    private final static String CANTIDADXTIPO = "SELECT COUNT(*) FROM usuario WHERE u_tipo = ?";
    private Conexion conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public AdminDAO() {
        conn = new Conexion();
    }

    public int cantidadUsuarios() {
        int cantidad = 0;
        Connection acceso = conn.getConnetion();
        try {
            ps = acceso.prepareStatement(CANTIDAD_USUARIOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidad;
    }

    public int cantidadXTipo(int tipo) {
        int cantidad = 0;
        Connection acceso = conn.getConnetion();
        try {
            ps = acceso.prepareStatement(CANTIDADXTIPO);
            ps.setInt(1, tipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cantidad;
    }

}
