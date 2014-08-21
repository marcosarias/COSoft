/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConceptoCuentaCorriente;
import utilidades.Conexion;
import modelo.Factura;
import modelo.Material;
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
    
    public static String cobrarDebitos(ArrayList<ConceptoCuentaCorriente> conceptos, float importe, int matricula, String nroRecibo, String fecha){
    
        String consultaSQL = "";
        consultaSQL += "INSERT INTO recibo (nrecibo, matricula, fecha, importe) VALUES (\"" + nroRecibo + "\", " + matricula + ", \"" + fecha + "\", " + importe + ");";
        
        for(ConceptoCuentaCorriente concepto : conceptos){
        
            consultaSQL += "UPDATE cuentacuotas SET idrecibo = '" + nroRecibo + "' where idcuentacuotas = " + concepto.getId() + ";";
        
        }
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static void obtenerDetallesRecibo(ArrayList<ConceptoCuentaCorriente> conceptos, String nroRecibo){
    
        try {
            String consultaSQL = "SELECT nombre, importe, idfactura FROM vistacuentacorriente where idrecibo = '" + nroRecibo + "'";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    ConceptoCuentaCorriente concepto = new ConceptoCuentaCorriente();
                    concepto.setIdfactura(resultado.getString("idfactura"));
                    concepto.setDetalle(resultado.getString("nombre"));
                    concepto.setImporte(resultado.getFloat("importe"));
                    conceptos.add(concepto);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public static String asignarRecibo(String nroRecibo, String nroFactura) {
        
        Calendar calendar = Calendar.getInstance();
        String fecha = String.valueOf(calendar.get(Calendar.YEAR) + "-" + ((int)calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
        
        Factura factura = new Factura();
        try {
            String consultaSQL = "SELECT * FROM factura where nfactura = \"" + nroFactura + "\"";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                factura.setNroFactura(resultado.getString("nfactura"));
                factura.setDetalle(resultado.getString("detalle"));
                factura.setFecha(resultado.getString("fecha"));
                factura.setMatricula(resultado.getInt("matricula"));
                factura.setImporte(resultado.getFloat("importe"));
                
            }
            
            conexion.Cerrar_conexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorRecibo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(factura.getNroFactura() == null)
            return "El número de factura ingresado es inexistente";
        
        String consultaSQL = "INSERT INTO recibo (nrecibo, nfactura, matricula, detalle, fecha, importe) VALUES (\"" + nroRecibo + "\", " + "\"" + nroFactura + "\", " + factura.getMatricula() + ", \"" + factura.getDetalle() + "\", \"" + fecha + "\", " + factura.getImporte() + ");";
        
        consultaSQL += "UPDATE cuentacuotas SET idrecibo = \"" + nroRecibo + "\" WHERE idfactura = \"" + nroFactura + "\"";
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
        
    }
    
}
