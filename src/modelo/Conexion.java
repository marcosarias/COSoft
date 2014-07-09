/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author COCO
 */

public class Conexion {
    
    final String base = "cosoft";
    final String usuario = "root";
    final String passwd = "";
    final String url = "jdbc:mysql://localhost:3306/" + base + "?allowMultiQueries=true";
    Connection conn = null;
    Statement consulta;
    
    public void Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection(url, usuario, passwd);
            consulta = (Statement) conn.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Cerrar_conexion() {
        try {
            if(consulta!=null)
                consulta.close();
            if(conn!=null)
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String ejecutarSentenciaSQL(String consultaSQL){
        try {
            consulta.executeUpdate(consultaSQL);
            return "";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    
    }
    
    public ResultSet ejecutarConsultaSQL(String consultaSQL){

        try {
            return consulta.executeQuery(consultaSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return null;
        
    }
    
    public String ejecutarTransaccionSQL(String transaccionSQL){

        Statement stmt = null;
        String resultado = "";
        
        try{
            
            stmt = conn.createStatement();
        
            conn.setAutoCommit(false);
            stmt.executeUpdate(transaccionSQL);
            conn.commit();
        
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
            if (conn != null) {
                try {
                    conn.rollback();
                    resultado = e.getMessage();
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException excep) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } finally {
            try {
                
                conn.setAutoCommit(true);
                if(stmt != null)
                    stmt.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        return resultado;
        
    }
    
}
