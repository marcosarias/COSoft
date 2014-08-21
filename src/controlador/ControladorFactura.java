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
import utilidades.Conexion;
import modelo.Factura;
import modelo.Material;
import modelo.TipoCuota;

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
    
    public static void obtenerCuotasFactura(ArrayList<TipoCuota> cuotas, String nroFactura){
    
        try {
            String consultaSQL = "SELECT nombre, cuentacuotas.importe FROM cuentacuotas inner join tipocuota on cuentacuotas.idcuota = tipocuota.idcuota where cuentacuotas.idcuota <> 1 AND idfactura = '" + nroFactura + "'";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    TipoCuota cuota = new TipoCuota();
                    cuota.setImporte(resultado.getInt("importe"));
                    cuota.setNombre(resultado.getString("nombre"));
                    cuotas.add(cuota);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String generarCuota(int idCuota, int matricula, String nroFactura, int mes, int anio, float importe, String fecha){
            
        String consultaSQL = "";

        if(!nroFactura.equals("")){
            consultaSQL += "INSERT INTO factura (nfactura, matricula, detalle, fecha, importe) VALUES (\"" + nroFactura + "\", " + matricula + ", \"\", \"" + fecha + "\", " + importe + ");";
            consultaSQL += "INSERT INTO cuentacuotas (matricula, idcuota, importe, mes, anio, idfactura, fechadebito) VALUES (" + matricula + ", " + idCuota + ", " + importe + ", " + mes + ", " + anio + ", \"" + nroFactura + "\", \"" + fecha + "\");";
        }
        else consultaSQL += "INSERT INTO cuentacuotas (matricula, idcuota, importe, mes, anio, fechadebito) VALUES (" + matricula + ", " + idCuota + ", " + importe + ", " + mes + ", " + anio + ", \"" + fecha + "\");"; 
            
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static String generarCuotas(int idCuota, String fecha, int mes, int anio, float importe){
    
        ArrayList<Integer> matriculas = ControladorProfesional.getProfesionalesActivoDeCuota(idCuota);
        
        String consultaSQL = "";
        for(int matricula : matriculas){
        
            consultaSQL += "INSERT INTO cuentacuotas (matricula, idcuota, importe, mes, anio, fechadebito) VALUES (" + matricula + ", " + idCuota + ", " + importe + ", " + mes + ", " + anio + ", \"" + fecha + "\");"; 
        
        }
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
}
