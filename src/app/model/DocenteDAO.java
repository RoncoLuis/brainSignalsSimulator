package app.model;

import app.model.Docente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DocenteDAO {

    private final static String SQL_INSERT = "INSERT INTO docente(doc_departamento,doc_titulo,doc_id_usuario)VALUES(?,?,?)";
    private final static String SQL_SELECT = "SELECT * FROM docente WHERE doc_id_usuario = ?";
    private final static String SQL_UPDATE
            = "UPDATE docente SET doc_departamento= ?,doc_titulo= ?"
            + " WHERE doc_id_usuario= ?";
    private Conexion conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public DocenteDAO() {
        conn = new Conexion();
    }

    public boolean updateEstudiante(String departamento, String titulo, int id_usuario) {
        boolean respuesta = false;
        String consulta = SQL_UPDATE;
        try {
            Connection acceso = conn.getConnetion();
            ps = acceso.prepareStatement(consulta);
            int index = 1;
            ps.setString(index++, departamento);
            ps.setString(index++, titulo);
            ps.setInt(index++, id_usuario);
            int afectado = ps.executeUpdate();
            if (afectado > 0) {
                respuesta = true;
            } else {
                System.out.println("error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public Docente retornaDocente(int id_usuario) {
        Docente d = null;
        boolean existe = false;
        try {
            String consulta = SQL_SELECT;
            Connection acceso_bd = conn.getConnetion();
            int index = 1;
            ps = acceso_bd.prepareStatement(consulta);
            ps.setInt(index++, id_usuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                String departamento = rs.getString("doc_departamento");
                String titulo = rs.getString("doc_titulo");
                d = new Docente();
                d.setDocDepartamento(departamento);
                d.setDocTitulo(titulo);
                existe = true;
            }
            System.out.println("¿Docente existe? " + existe);
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return d;
    }

    public boolean insertDocente(Docente d) {
        boolean respuesta = false;
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(SQL_INSERT);
            int index = 1;
            ps.setString(index++, d.getDocDepartamento());
            ps.setString(index++, d.getDocTitulo());
            ps.setInt(index++, d.getIdUsuario());
            int columnas_afectadas = ps.executeUpdate();
            if (columnas_afectadas > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + respuesta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede insertar docente cod.error:" + ex.getErrorCode());
        }
        return respuesta;
    }
}
