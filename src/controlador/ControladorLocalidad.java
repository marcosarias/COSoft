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
import modelo.Localidad;
import modelo.ObraSocial;
import modelo.TipoMaterial;

/**
 *
 * @author COCO
 */
public class ControladorLocalidad {
    
    public static void getLocalidades(ArrayList<Localidad> localidades){
                
        try {
            String consultaSQL = "SELECT * FROM localidad";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Localidad localidad = new Localidad();
                    localidad.setIdlocalidad(resultado.getInt("codigopostal"));
                    localidad.setNombre(resultado.getString("nombre"));
                    localidades.add(localidad);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String insertar(Localidad localidad){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO localidad (codigopostal, nombre) VALUES (");
        sqlbuild.append(localidad.getIdlocalidad());
        sqlbuild.append(", \"");
        sqlbuild.append(localidad.getNombre());
        sqlbuild.append("\")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
}
