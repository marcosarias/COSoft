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
import modelo.Recibo;

/**
 *
 * @author COCO
 */
public class ControladorRecibo {
    
    public static void getRecibos(ArrayList<Recibo> recibos){
        
        try {
            String consultaSQL = "SELECT * FROM vistarecibos";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Recibo recibo = new Recibo();
                    recibo.setNroRecibo(resultado.getString("nrecibo"));
                    recibo.setNroFactura(resultado.getString("nfactura"));
                    recibo.setFecha(resultado.getString("fecha"));
                    recibo.setMatricula(resultado.getInt("matricula"));
                    recibo.setDetalle(resultado.getString("detalle"));
                    recibo.setImporte(resultado.getFloat("importe"));
                    recibo.setNombre(resultado.getString("nombre"));
                    recibos.add(recibo);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
