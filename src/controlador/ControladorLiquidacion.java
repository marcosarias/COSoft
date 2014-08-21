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
import modelo.ConceptoLiquidacion;
import utilidades.Conexion;
import modelo.DetalleLiquidacion;
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
    
 public static String insertarLiquidacion(Liquidacion liquidacion) {
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO liquidacion (idobrasocial, fechapago, fecharecibida, importe, nombreliquidacion) VALUES (");
        sqlbuild.append(liquidacion.getIdObraSocial());
        sqlbuild.append(", \"");
        sqlbuild.append(liquidacion.getFechaPago());
        sqlbuild.append("\", \"");
        sqlbuild.append(liquidacion.getFechaRecibida());
        sqlbuild.append("\",");
        sqlbuild.append(liquidacion.getImporte());
        sqlbuild.append(", \"");
        sqlbuild.append(liquidacion.getNombre());
        sqlbuild.append("\")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        if(resultado.equals("")){ //se insertó bien la liquidación, puedo empezar con el detalle
            ArrayList<DetalleLiquidacion> detalles;
            detalles = liquidacion.getDetalles();
            if (!detalles.isEmpty()) // inserto la lista de detalles
            {
                int idLiquidacion = ControladorLiquidacion.getIdLiquidacion(liquidacion);

                for(DetalleLiquidacion detalle : detalles){
                    resultado = ControladorLiquidacion.insertarDetalleLiquidacion(detalle, idLiquidacion);
                    
                    if (resultado.equals("")){ //se insertó bien el detalle, puedo insertar los conceptos
                        ArrayList<ConceptoLiquidacion> conceptos;
                        conceptos = detalle.getConceptos();
                        if(!conceptos.isEmpty()) //insertar los conceptos del detalle
                        {
                            int idDetalle = ControladorLiquidacion.getIdDetalle(detalle,idLiquidacion);

                            for(ConceptoLiquidacion concepto : conceptos){
                                resultado = ControladorLiquidacion.insertarConceptoLiquidacion(concepto, idDetalle);
                                
                                if (!resultado.equals("")){ //el concepto no se insertó bien, devolver error
                                    eliminar(idLiquidacion);
                                    return resultado;
                                }
                            }
                        }
                    }
                    else{ // error al insertar el detalle, devolver error
                        eliminar(idLiquidacion);
                        return resultado;
                        
                    }
                }

            }
        }
        
     return resultado;
    
    }
 
    /**
     *
     * @param liquidacion
     * @return
     */
    public static int getIdLiquidacion(Liquidacion liquidacion){
    
        int idliquidacion = -1;
        
        try{
            StringBuilder sqlbuild = new StringBuilder(); 
            sqlbuild.append("SELECT idliquidacion FROM liquidacion order by idliquidacion desc limit 1");

            String consultaSQL = sqlbuild.toString();

            Conexion conexion = new Conexion();
            conexion.Conectar();

             ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);

                while(resultado.next())
                    idliquidacion = resultado.getInt("idliquidacion");

            conexion.Cerrar_conexion();
            
        }catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idliquidacion;
    
    }
    
    public static String getNombreLiquidacion(int id){
        String nombre = "";
        
        try{
            
            String consultaSQL = "SELECT nombreliquidacion FROM liquidacion where idliquidacion = " + id;

            Conexion conexion = new Conexion();
            conexion.Conectar();

            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);

            while(resultado.next())
                nombre = resultado.getString("nombreliquidacion");

            conexion.Cerrar_conexion();
            
        }catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nombre;
    
    }
    
    public static String eliminar(int idLiquidacion) {
        String consultaSQL = "delete from liquidacion where idliquidacion= " + idLiquidacion;
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    }

    private static String insertarDetalleLiquidacion(DetalleLiquidacion detalle, int idLiquidacion) {
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO detalleliquidacion (idliquidacion,matricula, atributo) VALUES (");
        sqlbuild.append(idLiquidacion);
        sqlbuild.append(", ");
        sqlbuild.append(detalle.getMatricula());
        sqlbuild.append(", ");
        sqlbuild.append(detalle.getAtributo());
        sqlbuild.append(")");
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    }

    private static int getIdDetalle(DetalleLiquidacion detalle, int idLiquidacion) {
         int idDetalle = -1;
        
        try{
            StringBuilder sqlbuild = new StringBuilder();
            sqlbuild.append("SELECT iddetalleliquidacion FROM detalleliquidacion WHERE idliquidacion = ");
            sqlbuild.append(idLiquidacion);
            sqlbuild.append("AND matricula = '");
            sqlbuild.append(detalle.getMatricula());
            sqlbuild.append("' AND atributo = ");
            sqlbuild.append(detalle.getAtributo());

            String consultaSQL = sqlbuild.toString();

            Conexion conexion = new Conexion();
            conexion.Conectar();

             ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);

                while(resultado.next())
                    idDetalle = resultado.getInt("iddetalleliquidacion");

            conexion.Cerrar_conexion();
            
        }catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idDetalle;
    }

    private static String insertarConceptoLiquidacion(ConceptoLiquidacion concepto, int idDetalle) {
        
        //TODO: agregar idliquidacion en cuentacuotas
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO conceptosliquidacion (iddetalleliquidacion, importe, idtipocuota) VALUES (");
        sqlbuild.append(idDetalle);
        sqlbuild.append(", \"");
        sqlbuild.append(concepto.getImporte());
        sqlbuild.append(", \"");
        sqlbuild.append(concepto.getIdTipoCuota());
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    }
    
}

