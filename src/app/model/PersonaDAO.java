/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.model.Persona;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PersonaDAO {

    private final static String SQL_INSERT
            = "INSERT INTO persona(p_nombre,p_ap_paterno,p_ap_materno,p_genero,p_fecha_nacimiento,p_id_usuario)"
            + "VALUES(?,?,?,?,?,?)";
    private final static String SQL_SELECT = "SELECT * FROM persona WHERE p_id_usuario = ?";
    private final static String SQL_UPDATE
            = "UPDATE persona SET p_nombre = ?, p_ap_paterno = ?,p_ap_materno= ?,p_genero= ?,p_fecha_nacimiento = ?"
            + " WHERE p_id_usuario = ?";
    private Conexion conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public PersonaDAO() {
        conn = new Conexion();
    }

    public boolean updatePersona(String nombre, String paterno, String materno, String genero, Date fecha, int id_usuario) {
        boolean respuesta = false;
        String consulta = SQL_UPDATE;
        try {
            Connection acceso = conn.getConnetion();
            ps = acceso.prepareStatement(consulta);
            int index = 1;
            ps.setString(index++, nombre);
            ps.setString(index++, paterno);
            ps.setString(index++, materno);
            ps.setString(index++, genero);
            ps.setDate(index++, (Date) fecha);
            ps.setInt(index++, id_usuario);
            int afectada = ps.executeUpdate();
            if (afectada > 0) {
                System.out.println("registro modificado");
                respuesta = true;
            } else {
                System.out.println("error");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    public Persona retornaPersona(int id_usuario) {
        Persona p = null;
        boolean existe = false;
        try {
            String consulta = SQL_SELECT;
            Connection accesobd = conn.getConnetion();
            ps = accesobd.prepareStatement(consulta);
            ps.setInt(1, id_usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("p_nombre");
                String paterno = rs.getString("p_ap_paterno");
                String materno = rs.getString("p_ap_materno");
                String genero = rs.getString("p_genero");
                Date nacimiento = rs.getDate("p_fecha_nacimiento");
                p = new Persona();
                p.setPNombre(nombre);
                p.setPApPaterno(paterno);
                p.setPApMaterno(materno);
                p.setPGenero(genero);
                p.setPFechaNacimiento(nacimiento);
                existe = true;
            }
            System.out.println("¿persona existe? " + existe);

        } catch (SQLException ex) {
            System.err.println("Error Code:" + ex.getErrorCode() + "\n" + ex.getMessage());
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }
    
    public boolean retornaPersonaBoolean(int id_usuario) {
        Persona p = null;
        boolean existe = false;
        try {
            String consulta = SQL_SELECT;
            Connection accesobd = conn.getConnetion();
            ps = accesobd.prepareStatement(consulta);
            ps.setInt(1, id_usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("p_nombre");
                String paterno = rs.getString("p_ap_paterno");
                String materno = rs.getString("p_ap_materno");
                String genero = rs.getString("p_genero");
                Date nacimiento = rs.getDate("p_fecha_nacimiento");
                p = new Persona();
                p.setPNombre(nombre);
                p.setPApPaterno(paterno);
                p.setPApMaterno(materno);
                p.setPGenero(genero);
                p.setPFechaNacimiento(nacimiento);
                existe = true;
            }
            System.out.println("¿persona existe? " + existe);

        } catch (SQLException ex) {
            System.err.println("Error Code:" + ex.getErrorCode() + "\n" + ex.getMessage());
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }
    
    
    
    

    public boolean insertPersona(Persona p) {
        boolean respuesta = false;
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(SQL_INSERT);
            int index = 1;
            ps.setString(index++, p.getPNombre());
            ps.setString(index++, p.getPApPaterno());
            ps.setString(index++, p.getPApMaterno());
            ps.setString(index++, p.getPGenero());
            ps.setDate(index++, (Date) p.getPFechaNacimiento());
            ps.setInt(index++, p.getIdUsuario());
            int columnas_afectadas = ps.executeUpdate();
            if (columnas_afectadas > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + respuesta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede insertar persona cod.error:" + ex.getErrorCode());
        }

        return respuesta;
    }

}
