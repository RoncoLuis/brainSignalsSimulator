package app.model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private final static String SQL_INSERT = "INSERT INTO usuario(u_tipo,u_nombre,u_correo,u_password,u_fecha_reg) VALUES(?,?,?,?,?)";
    private final static String SQL_SELECT = "SELECT * FROM usuario ORDER BY id_usuario";
    private final static String SQL_SELECT_USUARIO = "SELECT * FROM usuario WHERE id_usuario = ?";
    private final static String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    private final static String SQL_SEARCH = "SELECT * FROM usuario WHERE u_correo=?";
    private Conexion conn = null; //TODO si hay error regresar esta linea a final y quitar el null
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public UsuarioDAO() {
        conn = new Conexion();
    }

    public Usuario retornaUsuario(int id_usuario) {
        Usuario u = null;
        try {
            String consulta = SQL_SELECT_USUARIO;
            Connection acceso_bd = conn.getConnetion();
            int index = 1;
            ps = acceso_bd.prepareStatement(consulta);
            ps.setInt(index++, id_usuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                String u_nombre = rs.getString("u_nombre");
                String u_correo = rs.getString("u_correo");
                String u_pass = rs.getString("u_password");
                u = new Usuario();
                u.setUNombre(u_nombre);
                u.setUCorreo(u_correo);
                u.setUPassword(u_pass);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return u;
    }
    
    /*metodo provisional*/
        public Usuario retornaUsuario2(int id_usuario) {
        Usuario u = null;
        try {
            String consulta = SQL_SELECT_USUARIO;
            Connection acceso_bd = conn.getConnetion();
            int index = 1;
            ps = acceso_bd.prepareStatement(consulta);
            ps.setInt(index++, id_usuario);
            rs = ps.executeQuery();

            while (rs.next()) {                
                int tipo = rs.getInt("u_tipo");
                String u_nombre = rs.getString("u_nombre");
                String u_correo = rs.getString("u_correo");
                String u_pass = rs.getString("u_password");
                Date f_reg = rs.getDate("u_fecha_reg");
                u = new Usuario();
                u.setIdUsuario(id_usuario);
                u.setUTipo(tipo);
                u.setUNombre(u_nombre);
                u.setUCorreo(u_correo);
                u.setUPassword(u_pass);
                u.setUFechaReg(f_reg);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return u;
    }
    
    
    

    public Usuario accesoUsuario(String usuario, String pass) {
        Usuario u = null;
        try {
            String consulta = "SELECT * FROM usuario WHERE u_nombre=? AND u_password=?";
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(consulta);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                int tipo_usuario = rs.getInt("u_tipo");
                String u_nombre = rs.getString("u_nombre");
                String u_correo = rs.getString("u_correo");
                Date fecha_reg = rs.getDate("u_fecha_reg");
                u = new Usuario(id_usuario, tipo_usuario, u_nombre, u_correo, pass, fecha_reg);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
        }
        return u;
    }

    public ArrayList<Usuario> buscarUsuario(String correo) {
        ArrayList<Usuario> us_encontrado = new ArrayList<>();
        Connection acceso_bd = conn.getConnetion();
        try {
            ps = acceso_bd.prepareStatement(SQL_SEARCH);
            int index = 1;
            ps.setString(index++, correo);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                int tipo = rs.getInt("u_tipo");
                String u_nombre = rs.getString("u_nombre");
                String u_correo = rs.getString("u_correo");
                String u_pass = rs.getString("u_password");
                Date f_reg = rs.getDate("u_fecha_reg");
                Usuario u = new Usuario();
                u.setIdUsuario(id_usuario);
                u.setUTipo(tipo);
                u.setUNombre(u_nombre);
                u.setUCorreo(u_correo);
                u.setUPassword(u_pass);
                u.setUFechaReg(f_reg);
                us_encontrado.add(u);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
            // Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return us_encontrado;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                int tipo = rs.getInt("u_tipo");
                String u_nombre = rs.getString("u_nombre");
                String u_correo = rs.getString("u_correo");
                String u_pass = rs.getString("u_password");
                Date f_reg = rs.getDate("u_fecha_reg");
                Usuario u = new Usuario();
                u.setIdUsuario(id_usuario);
                u.setUTipo(tipo);
                u.setUNombre(u_nombre);
                u.setUCorreo(u_correo);
                u.setUPassword(u_pass);
                u.setUFechaReg(f_reg);
                usuarios.add(u);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
        } finally {
            //conn.cierraConexion();
        }
        return usuarios;
    }

    public boolean borrarUsuario(int u) {
        boolean resp = false;
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareCall(SQL_DELETE);
            int index = 1;
            ps.setInt(index++, u);
            int columnas_afectadas = ps.executeUpdate();

            if (columnas_afectadas > 0) {
                resp = true;
                JOptionPane.showMessageDialog(null, "El usuario se ha borrado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + resp);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
        }
        return resp;
    }

    public boolean insertaUsuario(Usuario u) {
        boolean respuesta = false;
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(SQL_INSERT);
            int index = 1;
            ps.setInt(index++, u.getUTipo());
            ps.setString(index++, u.getUNombre());
            ps.setString(index++, u.getUCorreo());
            ps.setString(index++, u.getUPassword());
            ps.setDate(index++, (Date) u.getUFechaReg());
            int columnas_afectadas = ps.executeUpdate();

            if (columnas_afectadas > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + respuesta);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
        } finally {
            //conn.cierraConexion();
        }
        return respuesta;
    }
}
