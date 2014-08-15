/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author COCO
 */
public class ControladorProfesional {
    
    public static String insertar(Profesional profesional){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO profesional (matricula, nombre, telefonos, direccion, localidad, cbu, banco, activo) VALUES (");
        sqlbuild.append(profesional.getMatricula());
        sqlbuild.append(", \"");
        sqlbuild.append(profesional.getNombre());
        sqlbuild.append("\", \"");
        sqlbuild.append(profesional.getTelefonos());
        sqlbuild.append("\", \"");
        sqlbuild.append(profesional.getDireccion());
        sqlbuild.append("\", ");
        sqlbuild.append(profesional.getIdlocalidad());
        sqlbuild.append(", \"");
        sqlbuild.append(profesional.getCbu());
        sqlbuild.append("\", \"");
        sqlbuild.append(profesional.getBanco());
        sqlbuild.append("\", ");
        sqlbuild.append(profesional.getActivo());
        sqlbuild.append(")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static void getDatos(Profesional profesional){
        try {
            String consultaSQL = "SELECT * FROM profesional where matricula = " + profesional.getMatricula();
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    profesional.setNombre(resultado.getString("nombre"));
                    profesional.setDireccion(resultado.getString("direccion"));
                    profesional.setTelefonos(resultado.getString("telefonos"));
                    profesional.setCbu(resultado.getString("cbu"));
                    profesional.setBanco(resultado.getString("banco"));
                    profesional.setIdlocalidad(resultado.getInt("localidad"));
                    profesional.setActivo(resultado.getInt("activo"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void getDatosNombre(Profesional profesional){
        try {
            String consultaSQL = "SELECT * FROM profesional where nombre = '" + profesional.getNombre() + "'";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    profesional.setMatricula(resultado.getInt("matricula"));
                    profesional.setDireccion(resultado.getString("direccion"));
                    profesional.setTelefonos(resultado.getString("telefonos"));
                    profesional.setCbu(resultado.getString("cbu"));
                    profesional.setBanco(resultado.getString("banco"));
                    profesional.setIdlocalidad(resultado.getInt("localidad"));
                    profesional.setActivo(resultado.getInt("activo"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public static void getProfesionales(ArrayList<Profesional> profesionales){
                
        try {
            String consultaSQL = "SELECT * FROM vistaprofesionales";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Profesional profesional = new Profesional();
                    profesional.setMatricula(resultado.getInt("matricula"));
                    profesional.setNombre(resultado.getString("nombre"));
                    profesional.setDireccion(resultado.getString("direccion"));
                    profesional.setTelefonos(resultado.getString("telefonos"));
                    profesional.setCbu(resultado.getString("cbu"));
                    profesional.setBanco(resultado.getString("banco"));
                    profesional.setLocalidad(resultado.getString("localidad"));
                    profesional.setActivo(resultado.getInt("activo"));
                    profesionales.add(profesional);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void getProfesionales(ArrayList<Profesional> profesionales, String obrasocial){
        
        int idobrasocial = ControladorObraSocial.getIdObraSocial(obrasocial);
        try {
            String consultaSQL = "SELECT * FROM vistaprofesionales WHERE vistaprofesionales.matricula IN (SELECT robrasocial.matricula FROM robrasocial WHERE robrasocial.idrobrasocial = "+idobrasocial+")";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Profesional profesional = new Profesional();
                    profesional.setMatricula(resultado.getInt("matricula"));
                    profesional.setNombre(resultado.getString("nombre"));
                    profesional.setDireccion(resultado.getString("direccion"));
                    profesional.setTelefonos(resultado.getString("telefonos"));
                    profesional.setCbu(resultado.getString("cbu"));
                    profesional.setBanco(resultado.getString("banco"));
                    profesional.setLocalidad(resultado.getString("localidad"));
                    profesional.setActivo(resultado.getInt("activo"));
                    profesionales.add(profesional);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void getProfesionalesBusqueda(ArrayList<Profesional> profesionales, String buscar){
                
        try {
            String consultaSQL = "SELECT * FROM vistaprofesionales WHERE nombre LIKE '%"+buscar+"%'";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Profesional profesional = new Profesional();
                    profesional.setMatricula(resultado.getInt("matricula"));
                    profesional.setNombre(resultado.getString("nombre"));
                    profesional.setDireccion(resultado.getString("direccion"));
                    profesional.setTelefonos(resultado.getString("telefonos"));
                    profesional.setCbu(resultado.getString("cbu"));
                    profesional.setBanco(resultado.getString("banco"));
                    profesional.setLocalidad(resultado.getString("localidad"));
                    profesional.setActivo(resultado.getInt("activo"));
                    profesionales.add(profesional);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String editar(Profesional profesional){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("update profesional set nombre=\"");
        sqlbuild.append(profesional.getNombre());
        sqlbuild.append("\", direccion=\"");
        sqlbuild.append(profesional.getDireccion());
        sqlbuild.append("\", telefonos=\"");
        sqlbuild.append(profesional.getTelefonos());
        sqlbuild.append("\", cbu=\"");
        sqlbuild.append(profesional.getCbu());
        sqlbuild.append("\", banco=\"");
        sqlbuild.append(profesional.getBanco());
        sqlbuild.append("\", localidad=");
        sqlbuild.append(profesional.getIdlocalidad());
        sqlbuild.append(", activo=");
        sqlbuild.append(profesional.getActivo());
        
        sqlbuild.append(" where matricula = ");
        sqlbuild.append(profesional.getMatricula());
        String consultaSQL = sqlbuild.toString();
                
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static String eliminar(int id){
    
        String consultaSQL = "delete from profesional where matricula = " + id;
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static ArrayList<Integer> getCuotasProfesional(int matricula){
                
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            String consultaSQL = "SELECT * FROM rcuotas where matricula = " + matricula;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    ids.add(resultado.getInt("idcuota"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ids;
    
    }
    
    public static ArrayList<Integer> getObrasProfesional(int matricula){
                
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            String consultaSQL = "SELECT * FROM robrasocial where matricula = " + matricula;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    ids.add(resultado.getInt("idrobrasocial"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ids;
    
    }

    public static String actualizarCuotas(ArrayList<Integer> ids, int matricula) {
        
        String consultaSQL = "delete from rcuotas where matricula = " + matricula + ";";
        
        for(Integer idCuota : ids){
        
            if(ids.contains(idCuota))
                consultaSQL += "INSERT INTO rcuotas (idcuota, matricula) VALUES (" + idCuota + ", " + matricula + ");";
        
        }
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
        
    }
    
    public static ArrayList<Integer> getProfesionalesActivoDeCuota(int idcuota){
    
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            String consultaSQL = "select rcuotas.matricula from rcuotas inner join profesional on rcuotas.matricula = profesional.matricula where activo=1 and idcuota = " + idcuota;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    ids.add(resultado.getInt("matricula"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ids;
    
    }

    public static String actualizarObras(ArrayList<Integer> ids, int matricula) {
        
        String consultaSQL = "delete from robrasocial where matricula = " + matricula + ";";
        
        for(Integer idObra : ids){
        
            if(ids.contains(idObra))
                consultaSQL += "INSERT INTO robrasocial (idrobrasocial, matricula) VALUES (" + idObra + ", " + matricula + ");";
        
        }
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
        
    }
    
}
