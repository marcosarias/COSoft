/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author COCO
 */
public class ConceptoCuentaCorriente implements Comparable<ConceptoCuentaCorriente>{
    
    private int id;
    private String detalle;
    private String fecha;
    private int mes;
    private int anio;
    private int debe;
    private int haber;
    private float importe;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    /**
     * @return the debe
     */
    public int getDebe() {
        return debe;
    }

    /**
     * @param debe the debe to set
     */
    public void setDebe(int debe) {
        this.debe = debe;
    }

    /**
     * @return the haber
     */
    public int getHaber() {
        return haber;
    }

    /**
     * @param haber the haber to set
     */
    public void setHaber(int haber) {
        this.haber = haber;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * @return the importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int compareTo(ConceptoCuentaCorriente o) {
        
        return fecha.compareTo(o.getFecha());
        
    }

    
}
