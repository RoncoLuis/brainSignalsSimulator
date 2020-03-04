package app.model;

import app.model.InfoPrueba;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InfoPruebaDAO {

    private Conexion conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    private final String SQL_INSERT = "INSERT INTO info_prueba(nombre_archivo,autor,fcreacion,tamanio,duracion,"
            + "capturas,comentarios,fecha_bitacora,inf_id_usuario)VALUES(?,?,?,?,?,?,?,?,?)";
    private final String SQL_SELECT = "SELECT id_inf,nombre_archivo,autor,fcreacion,tamanio,duracion,capturas,comentarios,fecha_bitacora FROM info_prueba WHERE inf_id_usuario =?";
    private final String SELECT_PRUEBA = "SELECT nombre_archivo,autor,fcreacion,tamanio,duracion,capturas,comentarios,fecha_bitacora FROM info_prueba WHERE id_inf =?";
    private final String SELECT_nombrearchivo = "SELECT nombre_archivo,autor,fcreacion,tamanio,duracion,capturas,comentarios,fecha_bitacora FROM info_prueba WHERE nombre_archivo =?";
    private final static String SQL_DELETE = "DELETE FROM info_prueba WHERE id_inf = ?";

    public InfoPruebaDAO() {
        conn = new Conexion();
    }

    
     public InfoPrueba retornarpruebapornombrearchivo(String nombre_archivo) {
        InfoPrueba info = null;
        boolean existe = false;

        try {
            String consulta = SELECT_nombrearchivo;
            Connection accesobd = conn.getConnetion();
            ps = accesobd.prepareStatement(consulta);
            ps.setString(1,nombre_archivo);
            rs = ps.executeQuery();
            while (rs.next()) {
                String archivo = rs.getString("nombre_archivo");
                String autor = rs.getString("autor");
                String f_creacion = rs.getString("fcreacion");
                String tam = rs.getString("tamanio");
                String duracion = rs.getString("duracion");
                String capturas = rs.getString("capturas");
                String comentario = rs.getString("comentarios");
                Date f_reg = rs.getDate("fecha_bitacora");
                info = new InfoPrueba();                
                info.setNombreArchivo(archivo);
                info.setAutor(autor);
                info.setFcreacion(f_creacion);
                info.setTamanio(tam);
                info.setDuracion(duracion);
                info.setCapturas(capturas);
                info.setComentarios(comentario);
                info.setFecha_bitacora(f_reg);
                existe = true;
            }
            System.out.println("¿existe informacion de la prueba? " + existe);

        } catch (SQLException ex) {
            System.err.println("Error Code:" + ex.getErrorCode() + "\n" + ex.getMessage());
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return info;
    }
    
    public InfoPrueba retornaPrueba(int id_prueba) {
        InfoPrueba info = null;
        boolean existe = false;

        try {
            String consulta = SELECT_PRUEBA;
            Connection accesobd = conn.getConnetion();
            ps = accesobd.prepareStatement(consulta);
            ps.setInt(1, id_prueba);
            rs = ps.executeQuery();
            while (rs.next()) {
                String archivo = rs.getString("nombre_archivo");
                String autor = rs.getString("autor");
                String f_creacion = rs.getString("fcreacion");
                String tam = rs.getString("tamanio");
                String duracion = rs.getString("duracion");
                String capturas = rs.getString("capturas");
                String comentario = rs.getString("comentarios");
                Date f_reg = rs.getDate("fecha_bitacora");
                info = new InfoPrueba();
                info.setIdInf(id_prueba);
                info.setNombreArchivo(archivo);
                info.setAutor(autor);
                info.setFcreacion(f_creacion);
                info.setTamanio(tam);
                info.setDuracion(duracion);
                info.setCapturas(capturas);
                info.setComentarios(comentario);
                info.setFecha_bitacora(f_reg);
                existe = true;
            }
            System.out.println("¿existe la prueba? " + existe);

        } catch (SQLException ex) {
            System.err.println("Error Code:" + ex.getErrorCode() + "\n" + ex.getMessage());
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return info;
    }

    public boolean insertInfoPrueba(InfoPrueba ip) {
        boolean respuesta = false;
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(SQL_INSERT);
            int index = 1;
            ps.setString(index++, ip.getNombreArchivo());
            ps.setString(index++, ip.getAutor());
            ps.setString(index++, ip.getFcreacion());
            ps.setString(index++, ip.getTamanio());
            ps.setString(index++, ip.getDuracion());
            ps.setString(index++, ip.getCapturas());
            ps.setString(index++, ip.getComentarios());
            ps.setDate(index++, (Date) ip.getFecha_bitacora());            
            ps.setInt(index++, ip.getInf_id_usuario());
            int columnas_afectadas = ps.executeUpdate();
            if (columnas_afectadas > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + respuesta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede insertar informacion de la prueba cod.error:" + ex.getErrorCode());
        }
        return respuesta;
    }

    public ArrayList<InfoPrueba> listarPruebas(int id_usuario) {
        ArrayList<InfoPrueba> lista_pruebas = new ArrayList<>();
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(SQL_SELECT);
            ps.setInt(1, id_usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_prueba = rs.getInt("id_inf");
                String archivo = rs.getString("nombre_archivo");
                String autor = rs.getString("autor");
                String f_creacion = rs.getString("fcreacion");
                String tam = rs.getString("tamanio");
                String duracion = rs.getString("duracion");
                String capturas = rs.getString("capturas");
                String comentario = rs.getString("comentarios");
                Date f_reg = rs.getDate("fecha_bitacora");
                InfoPrueba info = new InfoPrueba();
                info.setIdInf(id_prueba);
                info.setNombreArchivo(archivo);
                info.setAutor(autor);
                info.setFcreacion(f_creacion);
                info.setTamanio(tam);
                info.setDuracion(duracion);
                info.setCapturas(capturas);
                info.setComentarios(comentario);
                info.setFecha_bitacora(f_reg);
                lista_pruebas.add(info);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
        } finally {
            //conn.cierraConexion();
        }
        return lista_pruebas;
    }

    public boolean borrarRegistro(int id) {
        boolean resp = false;
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareCall(SQL_DELETE);
            int index = 1;
            ps.setInt(index++, id);
            int columnas_afectadas = ps.executeUpdate();

            if (columnas_afectadas > 0) {
                resp = true;
                JOptionPane.showMessageDialog(null, "El registro se ha borrado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + resp);
            }
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
        }
        return resp;
    }

}
