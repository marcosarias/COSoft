/*
 * To change this template, choose Tools | Templates
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
import modelo.Material;

/**
 *
 * @author COCO
 */
public class ControladorMaterial {
    
    public static String insertar(Material material){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("INSERT INTO material (idtipomaterial, marca, stock, precio) VALUES (");
        sqlbuild.append(material.getIdTipoMaterial());
        sqlbuild.append(", \"");
        sqlbuild.append(material.getMarca());
        sqlbuild.append("\", ");
        sqlbuild.append(material.getStock());
        sqlbuild.append(", ");
        sqlbuild.append(material.getPrecio());
        sqlbuild.append(")");
        
        String consultaSQL = sqlbuild.toString();
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static void getDatos(Material material){
        try {
            String consultaSQL = "SELECT * FROM material where idmaterial = " + material.getIdMaterial();
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    material.setIdTipoMaterial(resultado.getInt("idtipomaterial"));
                    material.setMarca(resultado.getString("marca"));
                    material.setStock(resultado.getInt("stock"));
                    material.setPrecio(resultado.getFloat("precio"));
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void getMateriales(ArrayList<Material> materiales){
                
        try {
            String consultaSQL = "SELECT * FROM VistaMateriales";
            
            Conexion conexion = new Conexion();
            conexion.Conectar();
            ResultSet resultado = conexion.ejecutarConsultaSQL(consultaSQL);
            
            while(resultado.next()){
                
                    Material material = new Material();
                    material.setIdMaterial(resultado.getInt("idmaterial"));
                    material.setTipo(resultado.getString("descripcion"));
                    material.setMarca(resultado.getString("marca"));
                    material.setStock(Integer.parseInt(resultado.getString("stock")));
                    material.setPrecio(resultado.getFloat("precio"));
                    materiales.add(material);
                    
                }
            
            conexion.Cerrar_conexion();
        
        } catch (SQLException ex) {
            Logger.getLogger(ControladorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static String editar(Material material){
    
        StringBuilder sqlbuild = new StringBuilder();
        sqlbuild.append("update material set idtipomaterial=");
        sqlbuild.append(material.getIdTipoMaterial());
        sqlbuild.append(", marca=\"");
        sqlbuild.append(material.getMarca());
        sqlbuild.append("\", stock=");
        sqlbuild.append(material.getStock());
        sqlbuild.append(", precio=");
        sqlbuild.append(material.getPrecio());
        
        sqlbuild.append(" where idmaterial = ");
        sqlbuild.append(material.getIdMaterial());
        String consultaSQL = sqlbuild.toString();
                
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }

      //  public static String modificarStock(ArrayList<Material> nuevos) 
    public static String modificarStock(ArrayList<Material> materiales){
    
        String consultaSQL = "";
        
        for(Material material : materiales){
        
            consultaSQL += "update material set stock = \"" + material.getStock() + "\" where idmaterial = " + material.getIdMaterial() + ";";
        
        }
                
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    public static String eliminar(int id){
    
        String consultaSQL = "delete from material where idmaterial = " + id;
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarSentenciaSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
    
    }
    
    private static float calcularImporte(ArrayList<Material> materiales){
    
        float importe = 0;
        for(Material material : materiales){
        
            importe += material.getCantidadCompra() * material.getPrecio();
            
        }
        
        return importe;
    
    }
    
    public static String registrarCompraMaterial(ArrayList<Material> materiales, int matricula, String nroFactura, String nroRecibo) {
        
        Calendar calendar = Calendar.getInstance();
        String fecha = String.valueOf(calendar.get(Calendar.YEAR) + "-" + ((int)calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));
        
        float importe = calcularImporte(materiales);
        String consultaSQL = "INSERT INTO factura (nfactura, matricula, detalle, fecha, importe) VALUES (\"" + nroFactura + "\", " + matricula + ", \"\", \"" + fecha + "\", " + importe + ");";
        
        if(!nroRecibo.equals("")){
        
            consultaSQL += "INSERT INTO recibo (nrecibo, matricula, detalle, fecha, importe, nfactura) VALUES (\"" + nroRecibo + "\", " + matricula + ", \"\", \"" + fecha + "\", " + importe + ", \"" + nroFactura + "\");";
            consultaSQL += "INSERT INTO cuentacuotas (matricula, idcuota, importe, mes, anio, idrecibo, idfactura, fechadebito) VALUES (" + matricula + ", 1, " + importe + ", " + fecha.split("-")[1] + ", " + fecha.split("-")[0] + ", \"" + nroRecibo + "\", \"" + nroFactura + "\", \"" + fecha + "\");";
        }
        else consultaSQL += "INSERT INTO cuentacuotas (matricula, idcuota, importe, mes, anio, idfactura, fechadebito) VALUES (" + matricula + ", 1, " + importe + ", " + fecha.split("-")[1] + ", " + fecha.split("-")[0] + ", \"" + nroFactura + "\", \"" + fecha + "\");";
            
        for(Material material : materiales){
        
            consultaSQL += "INSERT INTO ventamaterial (idmaterial, fecha, cantidad, facturaventa, matricula) VALUES (" + material.getIdMaterial() + ", \"" + fecha + "\", " + material.getCantidadCompra() + ", \"" + nroFactura + "\", " + matricula + ");";
            consultaSQL += "update material set stock = \"" + material.getStock() + "\" where idmaterial = " + material.getIdMaterial() + ";";
        
        }
        
        Conexion conexion = new Conexion();
        conexion.Conectar();
        String resultado = conexion.ejecutarTransaccionSQL(consultaSQL);
        conexion.Cerrar_conexion();
        
        return resultado;
        
    }

    
}
