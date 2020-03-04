/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import app.model.Investigador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LR21
 */
public class InvestigadorDAO {

    private final static String SQL_INSERT = "INSERT INTO investigador(inv_laboratorio,inv_titulo,inv_institucion,inv_id_usuario)VALUES(?,?,?,?)";
    private final static String SQL_SELECT = "SELECT * FROM investigador WHERE inv_id_usuario = ?";
    private final static String SQL_UPDATE
            = "UPDATE investigador SET inv_laboratorio = ?, inv_titulo = ?,inv_institucion= ?"
            + " WHERE inv_id_usuario = ?";
    private Conexion conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public InvestigadorDAO() {
        conn = new Conexion();
    }

    public boolean updateInvestigador(String laboratorio, String titulo, String institucion, int id_usuario) {
        boolean respuesta = false;
        String consulta = SQL_UPDATE;
        try {
            Connection acceso = conn.getConnetion();
            ps = acceso.prepareStatement(consulta);
            int index = 1;
            ps.setString(index++, laboratorio);
            ps.setString(index++, titulo);
            ps.setString(index++, institucion);
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

    public Investigador retornaInvestigador(int id_usuario) {
        Investigador i = null;
        boolean existe = false;
        try {
            String consulta = SQL_SELECT;
            Connection acceso_bd = conn.getConnetion();
            int index = 1;
            ps = acceso_bd.prepareStatement(consulta);
            ps.setInt(index++, id_usuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                String laboratorio = rs.getString("inv_laboratorio");
                String titulo = rs.getString("inv_titulo");
                String institucion = rs.getString("inv_institucion");
                i = new Investigador();
                i.setInvLaboratorio(laboratorio);
                i.setInvTitulo(titulo);
                i.setInvInstitucion(institucion);
                existe = true;
            }

            System.out.println("¿investigador existe? " + existe);
        } catch (SQLException sqle) {
            System.err.println("Error Code:" + sqle.getErrorCode() + "\n" + sqle.getMessage());
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return i;
    }

    public boolean insertInvestigador(Investigador i) {
        boolean respuesta = false;
        try {
            Connection acceso_bd = conn.getConnetion();
            ps = acceso_bd.prepareStatement(SQL_INSERT);
            int index = 1;
            ps.setString(index++, i.getInvLaboratorio());
            ps.setString(index++, i.getInvTitulo());
            ps.setString(index++, i.getInvInstitucion());
            ps.setInt(index++, i.getIdUsuario());

            int columnas_afectadas = ps.executeUpdate();
            if (columnas_afectadas > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + respuesta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "no se puede insertar investigador cod.error:" + ex.getErrorCode());
        }
        return respuesta;
    }
}
