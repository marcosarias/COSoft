/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Arancel;
import utilidades.Conexion;
import modelo.Material;

/**
 *
 * @author COCO
 */
public class ControladorArancel {
    
    public static String insertar(Arancel arancel){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO aranceles (descripcion, valor, obra) VALUES (\"");
        sqlbuild.append(arancel.getDescripcion());
        sqlbuild.append("\", ");
        sqlbuild.append(arancel.getValor());
        sqlbuild.append(", ");
        sqlbuild.append(arancel.getObra());
        sqlbuild.append(")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static void getDatos(Arancel arancel){
        try {
            String consultaSQL = "SELECT * FROM aranceles where idaranceles = " + arancel.getId();
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    arancel.setDescripcion(resultado.getString("descripcion"));
                    arancel.setObra(resultado.getInt("obra"));
                    arancel.setValor(resultado.getFloat("valor"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void getAranceles(ArrayList<Arancel> aranceles, int obra){
                
        try {
            String consultaSQL = "SELECT * FROM aranceles where obra = " + obra;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Arancel arancel = new Arancel();
                    arancel.setId(resultado.getInt("idaranceles"));
                    arancel.setDescripcion(resultado.getString("descripcion"));
                    arancel.setObra(resultado.getInt("obra"));
                    arancel.setValor(resultado.getFloat("valor"));
                    aranceles.add(arancel);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String editar(Arancel arancel){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("update aranceles set descripcion=\"");
        sqlbuild.append(arancel.getDescripcion());
        sqlbuild.append("\", valor=");
        sqlbuild.append(arancel.getValor());
        sqlbuild.append(", obra=");
        sqlbuild.append(arancel.getObra());
        
        sqlbuild.append(" where idaranceles = ");
        sqlbuild.append(arancel.getId());
        String consultaSQL = sqlbuild.toString();
                
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }

    public static String eliminar(int id){
    
        String consultaSQL = "delete from aranceles where idaranceles = " + id;
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
}
