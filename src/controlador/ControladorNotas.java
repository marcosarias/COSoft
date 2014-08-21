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

/**
 *
 * @author COCO
 */
public class ControladorNotas {
    
    public static String getNotas(){
                
        String notas = "";
        try {
            String consultaSQL = "SELECT valor FROM notas where idnotas = 1";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                notas = resultado.getString("valor");
                    
            }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return notas;
    
    }
    
    public static String editar(String notas){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("update notas set valor=\"");
        sqlbuild.append(notas);
        
        sqlbuild.append("\" where idnotas = 1");
        String consultaSQL = sqlbuild.toString();
                
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
}
