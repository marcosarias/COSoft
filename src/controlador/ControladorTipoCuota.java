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
import modelo.Conexion;
import modelo.TipoCuota;

/**
 *
 * @author COCO
 */
public class ControladorTipoCuota {
    
    public static String insertar(TipoCuota tipo){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO tipocuota (nombre, importe, frecuencia) VALUES (\"");
        sqlbuild.append(tipo.getNombre());
        sqlbuild.append("\", ");
        sqlbuild.append(tipo.getImporte());
        sqlbuild.append(", ");
        sqlbuild.append(tipo.getFrecuencia());
        sqlbuild.append(")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static void getDatos(TipoCuota tipo){
        
        try {
            String consultaSQL = "SELECT * FROM tipocuota where idcuota = " + tipo.getIdCuota();
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    tipo.setNombre(resultado.getString("nombre"));
                    tipo.setImporte(resultado.getFloat("importe"));
                    tipo.setFrecuencia(resultado.getInt("frecuencia"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void getTipos(ArrayList<TipoCuota> tipos){
                
        try {
            String consultaSQL = "SELECT * FROM tipocuota where idcuota <> 1";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                TipoCuota tipo = new TipoCuota();
                tipo.setIdCuota(resultado.getInt("idcuota"));
                tipo.setNombre(resultado.getString("nombre"));
                tipo.setImporte(resultado.getFloat("importe"));
                tipo.setFrecuencia(resultado.getInt("frecuencia"));
                tipos.add(tipo);

            }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String editar(TipoCuota tipo){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("update tipocuota set nombre=\"");
        sqlbuild.append(tipo.getNombre());
        sqlbuild.append("\", importe=");
        sqlbuild.append(tipo.getImporte());
        sqlbuild.append(", frecuencia=");
        sqlbuild.append(tipo.getFrecuencia());
        
        sqlbuild.append(" where idcuota = ");
        sqlbuild.append(tipo.getIdCuota());
        String consultaSQL = sqlbuild.toString();
                
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static String eliminar(int id){
    
        String consultaSQL = "delete from tipocuota where idcuota = " + id;
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static String registrarCuota(int idcuota, int mes, int anio, float importe){
    
        ArrayList<Integer> ids = getProfesionalesDeUnaCuota(idcuota);
        
        String consultaSQL = "";
        
        for(Integer i : ids){
        
            consultaSQL += "INSERT INTO cuentacuotas(idcuota, matricula, mes, anio, importe) VALUES(" + idcuota + ", " + i + ", " + mes + ", " + anio + ", " + importe + ")";
        
        }
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    private static ArrayList<Integer> getProfesionalesDeUnaCuota(int idcuota){

        ArrayList<Integer> ids = new ArrayList<>();
        
        try {
            String consultaSQL = "SELECT matricula from rcuotas where idcuota = " + idcuota;
            
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
    
}
