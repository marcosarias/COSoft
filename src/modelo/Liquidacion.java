/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author COCO
 */
public class Liquidacion {
    
    private int idLiquidacion;
    private int idObraSocial;
    private String fechaRecibida;
    private String fechaPago;
    private String importe;
    
    private ArrayList<DetalleLiquidacion> detalles;

    /**
     * @return the idLiquidacion
     */
    public int getIdLiquidacion() {
        return idLiquidacion;
    }

    /**
     * @param idLiquidacion the idLiquidacion to set
     */
    public void setIdLiquidacion(int idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    /**
     * @return the idObraSocial
     */
    public int getIdObraSocial() {
        return idObraSocial;
    }

    /**
     * @param idObraSocial the idObraSocial to set
     */
    public void setIdObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    /**
     * @return the fechaRecibida
     */
    public String getFechaRecibida() {
        return fechaRecibida;
    }

    /**
     * @param fechaRecibida the fechaRecibida to set
     */
    public void setFechaRecibida(String fechaRecibida) {
        this.fechaRecibida = fechaRecibida;
    }

    /**
     * @return the fechaPago
     */
    public String getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * @return the importe
     */
    public String getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(String importe) {
        this.importe = importe;
    }

    /**
     * @return the detalles
     */
    public ArrayList<DetalleLiquidacion> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(ArrayList<DetalleLiquidacion> detalles) {
        this.detalles = detalles;
    }
    
}
