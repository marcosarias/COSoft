/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConceptoCuentaCorriente;
import modelo.Conexion;
import modelo.CuentaCuotas;

/**
 *
 * @author COCO
 */
public class ControladorCuentaCorriente {
    
    public static void obtenerCuotas(ArrayList<ConceptoCuentaCorriente> conceptos, int matricula, String filtro){
    
        try {
            String consultaSQL = "SELECT * FROM vistacuentacorriente where matricula = " + matricula + filtro;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            while(resultado.next()){
                
                    ConceptoCuentaCorriente concepto = new ConceptoCuentaCorriente();
                    concepto.setMes(resultado.getInt("mes"));
                    concepto.setAnio(resultado.getInt("anio"));
                    concepto.setImporte(resultado.getFloat("importe"));
                    concepto.setDetalle(resultado.getString("nombre"));
                    concepto.setFecha(resultado.getString("fecha"));
                    concepto.setIdliquidacion(resultado.getInt("idliquidacion"));
                    concepto.setIdrecibo(resultado.getString("idrecibo"));
                    concepto.setIdfactura(resultado.getString("idfactura"));
                    conceptos.add(concepto);
                    
                }
            
            conexion.Cerrar_conexion();
                             
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Collections.sort(conceptos);
        for(ConceptoCuentaCorriente concepto : conceptos){
        
            if(concepto.getIdliquidacion() != 0)
                concepto.setNombreliquidacion(ControladorLiquidacion.getNombreLiquidacion(concepto.getIdliquidacion()));
        
        }
    
    }
          
    public static void obtenerCuotasSinRecibo(ArrayList<ConceptoCuentaCorriente> conceptos, int matricula){
    
        try {
            String consultaSQL = "SELECT * FROM vistacuentacorriente where idrecibo is null and matricula = " + matricula;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                    
                    ConceptoCuentaCorriente concepto = new ConceptoCuentaCorriente();
                    concepto.setId(resultado.getInt("id"));
                    concepto.setImporte(resultado.getFloat("importe"));
                    concepto.setDetalle(resultado.getString("nombre"));
                    concepto.setFecha(resultado.getString("fecha"));
                    conceptos.add(concepto);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     public static void obtenerCuotasAdeudadas(ArrayList<CuentaCuotas> cuentacuotas, int matricula){
    
        try {
            String consultaSQL = "SELECT * FROM cuentacuotas where idliquidacion = null and matricula = " + matricula;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                    CuentaCuotas cuentacuota = new CuentaCuotas();
                    
                    cuentacuota.setIdCuentaCuotas(resultado.getInt("idcuentacuotas"));
                    cuentacuota.setMatricula(matricula);
                    cuentacuota.setIdCuota(resultado.getInt("idcuota"));
                    cuentacuota.setMes(resultado.getString("mes"));
                    cuentacuota.setAnio(resultado.getString("anio"));
                    cuentacuota.setImporte(resultado.getFloat("importe"));
                    
                    cuentacuotas.add(cuentacuota);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static void obtenerCuotasAdeudadasImporte(ArrayList<CuentaCuotas> cuentacuotas, int matricula, float importe){
    
        try {
            String consultaSQL = "SELECT * FROM cuentacuotas where idliquidacion = null and matricula = " + matricula + " and importe <= " + String.valueOf(importe);
            // + Order by mes ? 
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                    CuentaCuotas cuentacuota = new CuentaCuotas();
                    
                    cuentacuota.setIdCuentaCuotas(resultado.getInt("idcuentacuotas"));
                    cuentacuota.setMatricula(matricula);
                    cuentacuota.setIdCuota(resultado.getInt("idcuota"));
                    cuentacuota.setMes(resultado.getString("mes"));
                    cuentacuota.setAnio(resultado.getString("anio"));
                    cuentacuota.setImporte(resultado.getFloat("importe"));
                    
                    cuentacuotas.add(cuentacuota);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
