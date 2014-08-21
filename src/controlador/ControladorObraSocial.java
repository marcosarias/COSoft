/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Conexion;
import modelo.ObraSocial;
import modelo.Profesional;

/**
 *
 * @author COCO
 */
public class ControladorObraSocial {
    
    public static String insertar(ObraSocial obra){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO obrasocial (nombre, direccion, telefonos, responsablecontrato, fechacontrato) VALUES (\"");
        sqlbuild.append(obra.getNombre());
        sqlbuild.append("\", \"");
        sqlbuild.append(obra.getTelefonos());
        sqlbuild.append("\", \"");
        sqlbuild.append(obra.getDireccion());
        sqlbuild.append("\", \"");
        sqlbuild.append(obra.getFirma());
        sqlbuild.append("\", \"");
        sqlbuild.append(obra.getFechacontrato());
        sqlbuild.append("\")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static void getDatos(ObraSocial obra){
        try {
            String consultaSQL = "SELECT * FROM obrasocial where idobrasocial = " + obra.getIdObraSocial();
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    obra.setNombre(resultado.getString("nombre"));
                    obra.setDireccion(resultado.getString("direccion"));
                    obra.setTelefonos(resultado.getString("telefonos"));
                    obra.setFirma(resultado.getString("responsablecontrato"));
                    obra.setFechacontrato(resultado.getString("fechacontrato"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static int getIdObraSocial(String obra){
        try {
            String consultaSQL = "SELECT idobrasocial FROM obrasocial where nombre = '" +obra+"'";
            int idobrasocial = 0;
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
          
            while(resultado.next())
                idobrasocial = resultado.getInt("idobrasocial");
            
            conexion.Cerrar_conexion();
            return idobrasocial;
            
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
    }
   
    
    public static void getObrasSociales(ArrayList<ObraSocial> obras){
                
        try {
            String consultaSQL = "SELECT * FROM obrasocial";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    ObraSocial obra = new ObraSocial();
                    obra.setIdObraSocial(resultado.getInt("idobrasocial"));
                    obra.setNombre(resultado.getString("nombre"));
                    obra.setDireccion(resultado.getString("direccion"));
                    obra.setTelefonos(resultado.getString("telefonos"));
                    obra.setFirma(resultado.getString("responsablecontrato"));
                    obra.setFechacontrato(resultado.getString("fechacontrato"));
                    obras.add(obra);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void getObrasSocialesBusqueda(ArrayList<ObraSocial> obras, String busqueda){
                
        try {
            String consultaSQL = "SELECT * FROM obrasocial WHERE nombre LIKE '%"+busqueda+"%'";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    ObraSocial obra = new ObraSocial();
                    obra.setIdObraSocial(resultado.getInt("idobrasocial"));
                    obra.setNombre(resultado.getString("nombre"));
                    obra.setDireccion(resultado.getString("direccion"));
                    obra.setTelefonos(resultado.getString("telefonos"));
                    obra.setFirma(resultado.getString("responsablecontrato"));
                    obra.setFechacontrato(resultado.getString("fechacontrato"));
                    obras.add(obra);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void getObrasSocialesProfesionales(ArrayList<Profesional> profesionales, int idobrasocial){
                
        try {
            String consultaSQL = "SELECT * FROM robrasocial WHERE idobrasocial LIKE '%"+idobrasocial+"%'";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Profesional profesional  = new Profesional();
                    profesional.setMatricula(resultado.getInt("matricula"));
                    profesionales.add(profesional);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String editar(ObraSocial obra){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("update obrasocial set nombre=\"");
        sqlbuild.append(obra.getNombre());
        sqlbuild.append("\", direccion=\"");
        sqlbuild.append(obra.getDireccion());
        sqlbuild.append("\", telefonos=\"");
        sqlbuild.append(obra.getTelefonos());
        sqlbuild.append("\", responsablecontrato=\"");
        sqlbuild.append(obra.getFirma());
        sqlbuild.append("\", fechacontrato=\"");
        sqlbuild.append(obra.getFechacontrato());
        sqlbuild.append("\"");
        
        sqlbuild.append(" where idobrasocial = ");
        sqlbuild.append(obra.getIdObraSocial());
        String consultaSQL = sqlbuild.toString();
                
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static String eliminar(int id){
    
        String consultaSQL = "delete from obrasocial where idobrasocial = " + id;
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
}
