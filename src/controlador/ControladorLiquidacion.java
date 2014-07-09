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
import modelo.Conexion;
import modelo.Liquidacion;

/**
 *
 * @author Viic
 */
public class ControladorLiquidacion {
    
 public static void getLiquidaciones(ArrayList<Liquidacion> liquidaciones){
                
        try {
            String consultaSQL = "SELECT * FROM liquidacion";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Liquidacion liquidacion = new Liquidacion();
                    liquidacion.setIdLiquidacion(resultado.getInt("idliquidacion"));
                    liquidacion.setIdObraSocial(resultado.getInt("idobrasocial"));
                    liquidacion.setFechaPago(resultado.getString("fechapago"));
                    liquidacion.setFechaRecibida(resultado.getString("fecharecibida"));
                    liquidacion.setImporte(resultado.getString("importe"));
                    liquidaciones.add(liquidacion);
     
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String insertarLiquidacion(Liquidacion liquidacion){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO liquidacion (idobrasocial,fechapago, fecharecibida, importe) VALUES (");
        sqlbuild.append(liquidacion.getIdObraSocial());
        sqlbuild.append(", \"");
        sqlbuild.append(liquidacion.getFechaPago());
        sqlbuild.append(", \"");
        sqlbuild.append(liquidacion.getFechaRecibida());
        sqlbuild.append(", \"");
        sqlbuild.append(liquidacion.getImporte());
        sqlbuild.append("\")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }

    public static String eliminar(int idLiquidacion) {
        String consultaSQL = "delete from liquidacion where idliquidacion= " + idLiquidacion;
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    }
    
}

