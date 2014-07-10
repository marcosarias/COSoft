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

/**
 *
 * @author COCO
 */
public class ControladorCuentaCorriente {
    
    public static void obtenerCuotas(ArrayList<ConceptoCuentaCorriente> conceptos, int matricula){
    
        try {
            String consultaSQL = "SELECT matricula, mes, anio, cuentacuotas.importe, nombre FROM cuentacuotas inner join tipocuota on cuentacuotas.idcuota=tipocuota.idcuota where matricula = " + matricula;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    ConceptoCuentaCorriente concepto = new ConceptoCuentaCorriente();
                    concepto.setMes(resultado.getInt("mes"));
                    concepto.setAnio(resultado.getInt("anio"));
                    concepto.setImporte(resultado.getFloat("importe"));
                    concepto.setDetalle(resultado.getString("nombre"));
                    concepto.setFecha(resultado.getInt("anio") + "-" + resultado.getInt("mes") + "-01");
                    conceptos.add(concepto);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String consultaSQL = "SELECT * FROM factura where matricula = " + matricula;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    ConceptoCuentaCorriente concepto = new ConceptoCuentaCorriente();
                    concepto.setFecha(resultado.getString("fecha"));
                    concepto.setImporte(resultado.getFloat("importe"));
                    concepto.setDetalle("Compra de materiales");
                    conceptos.add(concepto);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Collections.sort(conceptos);
    
    }
    
}
