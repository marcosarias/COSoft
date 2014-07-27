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
import modelo.Conexion;
import modelo.Factura;
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
    
    public static void getFacturas(ArrayList<Factura> facturas){
        
        try {
            String consultaSQL = "SELECT * FROM vistafacturas";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Factura factura = new Factura();
                    factura.setNroFactura(resultado.getString("nfactura"));
                    factura.setFecha(resultado.getString("fecha"));
                    factura.setMatricula(resultado.getInt("matricula"));
                    factura.setDetalle(resultado.getString("detalle"));
                    factura.setImporte(resultado.getFloat("importe"));
                    factura.setNombre(resultado.getString("nombre"));
                    facturas.add(factura);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void getMaterialesFactura(ArrayList<Material> materiales, String nroFactura){
    
        try {
            String consultaSQL = "SELECT descripcion, marca, cantidad, precio FROM ventamaterial inner join material on ventamaterial.idmaterial=material.idmaterial inner join tipomaterial on material.idtipomaterial=tipomaterial.idtipomaterial WHERE facturaventa = \"" + nroFactura + "\"";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Material material = new Material();
                    material.setCantidadCompra(resultado.getInt("cantidad"));
                    material.setTipo(resultado.getString("descripcion"));
                    material.setMarca(resultado.getString("marca"));
                    material.setPrecio(resultado.getFloat("precio"));
                    materiales.add(material);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String asignarFactura(int idCuota, int matricula, String nroFactura, int mes, int anio, float importe){
    
        Calendar calendar = Calendar.getInstance();
        String fecha = String.valueOf(calendar.get(Calendar.YEAR) + "-" + ((int)calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
        
        String consultaSQL = "INSERT INTO factura (nfactura, matricula, detalle, fecha, importe) VALUES (\"" + nroFactura + "\", " + matricula + ", \"\", \"" + fecha + "\", " + importe + ");";
        
        consultaSQL += "INSERT INTO cuentacuotas (matricula, idcuota, importe, mes, anio, idfactura) VALUES (" + matricula + ", " + idCuota + ", " + importe + ", " + mes + ", " + anio + ", \""+ nroFactura + "\");";
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
}
