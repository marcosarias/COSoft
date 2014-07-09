/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Material;

/**
 *
 * @author COCO
 */
public class ControladorFactura {
    
    public static int obtenerNroFactura(){
    
        int i = 0;
        try {
            String consultaSQL = "SELECT nfactura FROM factura ORDER BY nfactura DESC LIMIT 1";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                i = Integer.parseInt(resultado.getString("nfactura")) + 1;
                    
            }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    
    }
    
}
