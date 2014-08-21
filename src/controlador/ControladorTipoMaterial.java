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
import modelo.TipoMaterial;

/**
 *
 * @author COCO
 */
public class ControladorTipoMaterial {
    
    public static void getTipos(ArrayList<TipoMaterial> tipos){
                
        try {
            String consultaSQL = "SELECT * FROM tipomaterial";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    TipoMaterial tipo = new TipoMaterial();
                    tipo.setIdtipomaterial(resultado.getInt("idtipomaterial"));
                    tipo.setDescripcion(resultado.getString("descripcion"));
                    tipos.add(tipo);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String insertar(TipoMaterial tipo){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO tipomaterial (descripcion) VALUES (\"");
        sqlbuild.append(tipo.getDescripcion());
        sqlbuild.append("\")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
}
