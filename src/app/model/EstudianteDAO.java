package app.model;

import app.model.Estudiante;
import app.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EstudianteDAO {

    private final static String SQL_INSERT = "INSERT INTO estudiante(e_matricula,e_carrera,e_semestre,e_id_usuario)VALUES(?,?,?,?)";
    private final static String SQL_SELECT = "SELECT * FROM estudiante WHERE e_id_usuario = ?";
    private final static String SQL_UPDATE
            = "UPDATE estudiante SET e_matricula = ?,e_carrera= ?,e_semestre= ?"
            + " WHERE e_id_usuario = ?";
    private Conexion conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public EstudianteDAO() {
        conn = new Conexion();
    }

    public boolean updateEstudiante(int matricula, String carrera, int semestre, int id_usuario) {
        boolean respuesta = false;
        String consulta = SQL_UPDATE;
        try {
            Connection acceso = conn.getConnetion();
            ps = acceso.prepareStatement(consulta);
            int index = 1;
            ps.setInt(index++, matricula);
            ps.setString(index++, carrera);
            ps.setInt(index++, semestre);
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

    public Estudiante retornaEstudiante(Usuario u) {
        Estudiante e = null;
        boolean existe = false;
        try {
            String consulta = SQL_SELECT;
            Connection acceso_bd = conn.getConnetion();
            int index = 1;
            ps = acceso_bd.prepareStatement(consulta);
            ps.setInt(index++, u.getIdUsuario());
            rs = ps.executeQuery();

            while (rs.next()) {
                int matricula = rs.getInt("e_matricula");
                String carrera = rs.getString("e_carrera");
                int semestre = rs.getInt("e_semestre");
                e = new Estudiante();
                e.setEMatricula(matricula);
                e.setECarrera(carrera);
                e.setESemestre(semestre);
                existe = true;
            }
            System.out.println("¿estudiante existe? " + existe);
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return e;
    }

    public boolean insertEstudiante(Estudiante e) {
        boolean respuesta = false;
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(SQL_INSERT);
            int index = 1;
            ps.setInt(index++, e.getEMatricula());
            ps.setString(index++, e.getECarrera());
            ps.setInt(index++, e.getESemestre());
            ps.setInt(index++, e.getIdUsuario());

            int columnas_afectadas = ps.executeUpdate();
            if (columnas_afectadas > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + respuesta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede insertar estudiante cod.error:" + ex.getErrorCode());
        }

        return respuesta;
    }

}
