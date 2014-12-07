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
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConceptoCuentaCorriente;
import modelo.Condonacion;
import utilidades.Conexion;
import modelo.CuentaCuotas;
import modelo.Debito;
import modelo.Material;
import utilidades.Fecha;

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
                    concepto.setId(resultado.getInt("id"));
                    concepto.setMes(resultado.getInt("mes"));
                    concepto.setAnio(resultado.getInt("anio"));
                    concepto.setImporte(resultado.getFloat("importe"));
                    if(resultado.getString("descripcion") == null)
                        concepto.setDetalle(resultado.getString("nombre"));
                    else concepto.setDetalle(resultado.getString("nombre") + " - " +resultado.getString("descripcion"));
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
            String consultaSQL = "SELECT * FROM vistacuentacorriente where idrecibo is null and id not in (select cuota from condonaciones) and matricula = " + matricula;
            
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
    
    public static void obtenerCuotasSinFactura(ArrayList<ConceptoCuentaCorriente> conceptos, int matricula){
    
        try {
            String consultaSQL = "SELECT * FROM vistacuentacorriente where idfactura is null and id not in (select cuota from condonaciones) and matricula = " + matricula;
            
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
            String consultaSQL = "SELECT * FROM cuentacuotas where idliquidacion is null and id not in (select cuota from condonaciones) and matricula = " + matricula + " and importe <= " + String.valueOf(importe);
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
     
    public static void obtenerCuotasLiquidacion(ArrayList<CuentaCuotas> cuentacuotas, int matricula, int idLiquidacion){
    
        try {
            String consultaSQL = "SELECT * FROM cuentacuotas where idliquidacion = " + idLiquidacion + " and matricula = " + matricula;
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
     
    public static void obtenerDebitos(ArrayList<Debito> debitos, String fecha){
    
        try {
            String consultaSQL = "select idcuentacuotas, cuentacuotas.matricula, nombre, telefonos, direccion, sum(importe) as montototal from cuentacuotas inner join profesional on cuentacuotas.matricula = profesional.matricula where fechadebito < '" + fecha + "' and idrecibo is null and idcuentacuotas not in (select cuota from condonaciones) group by cuentacuotas.matricula";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                    
                Debito debito = new Debito();
                debito.setMatricula(resultado.getInt("matricula"));
                debito.setDireccion(resultado.getString("direccion"));
                debito.setNombre(resultado.getString("nombre"));
                debito.setTelefonos(resultado.getString("telefonos"));
                debito.setMontototal(resultado.getFloat("montototal"));
                debitos.add(debito);
                    
            }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public static String condonarDebito(int idDebito, String fecha){
        
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO condonaciones (cuota, fecha) VALUES (");
        sqlbuild.append(idDebito);
        sqlbuild.append(", \"");
        sqlbuild.append(fecha);
        sqlbuild.append("\")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }    

    public static void obtenerCondonaciones(ArrayList<Condonacion> condonaciones, int matricula) {
        
        try {
            String consultaSQL = "select idcondonaciones, cuota, fecha, matricula from condonaciones inner join cuentacuotas on condonaciones.cuota = cuentacuotas.idcuentacuotas where matricula = " + matricula;
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                    
                Condonacion condonacion = new Condonacion();
                condonacion.setId(resultado.getInt("idcondonaciones"));
                condonacion.setIdCuota(resultado.getInt("cuota"));
                condonacion.setFecha(resultado.getString("fecha"));
                condonaciones.add(condonacion);
                    
            }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static String generarCuotasAFuturo(int matricula, String fecha, int cantidad, float importe, String descripcion) {
        
        String fechas[] = Fecha.getFechasInvertidas(fecha, cantidad);
        
        String consultaSQL = "";
        
        for(int i = 0; i < cantidad; i++){
        
            consultaSQL += "INSERT INTO cuentacuotas (matricula, idcuota, importe, fechadebito, descripcion) VALUES (" + matricula + ", 2, " + importe + ", \"" + fechas[i] + "\", \"" + descripcion + "\");";
        
        }
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
        
    }
    
    public static void obtenerCuotasAFuturo(ArrayList<ConceptoCuentaCorriente> conceptos, int matricula, String fecha){
    
        try {
            String consultaSQL = "SELECT * FROM vistacuentacorriente where matricula = " + matricula + " AND fecha > '" + fecha + "'";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            while(resultado.next()){
                
                    ConceptoCuentaCorriente concepto = new ConceptoCuentaCorriente();
                    concepto.setId(resultado.getInt("id"));
                    concepto.setImporte(resultado.getFloat("importe"));
                    concepto.setFecha(resultado.getString("fecha"));
                    if(resultado.getString("descripcion") == null)
                        concepto.setDetalle(resultado.getString("nombre"));
                    else concepto.setDetalle(resultado.getString("nombre") + " - " +resultado.getString("descripcion"));
                    conceptos.add(concepto);
                    
                }
            
            conexion.Cerrar_conexion();
                             
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Collections.sort(conceptos);
        
    }

    public static void quitarCuotasLiquidacion(int id) {
        String consultaSQL = "UPDATE cuentacuotas SET  idliquidacion = NULL WHERE idcuentacuotas = " + id;
        Conexion conexion = new Conexion();
        conexion.Conectar();
        conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
    }

    public static void agregarCuotasLiquidacion(int idCuentaCuotas, int idLiquidacion) {
       String consultaSQL = "UPDATE cuentacuotas SET  idliquidacion = " + idLiquidacion + " WHERE idcuentacuotas = " + idCuentaCuotas;
        Conexion conexion = new Conexion();
        conexion.Conectar();
        conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
    }
    
	    public static void eliminarLiquidacionCuentaCuotas(int idLiquidacion) {
                
        String consultaSQL = "UPDATE cuentacuotas SET  idliquidacion = NULL WHERE idliquidacion = " + idLiquidacion;
        Conexion conexion = new Conexion();
        conexion.Conectar();
        conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
    }
	
}
