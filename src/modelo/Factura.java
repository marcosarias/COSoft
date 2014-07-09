/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author COCO
 */
public class Factura {
    
    private String nroFactura;
    private int matricula;
    private String detalle;

    /**
     * @return the nroFactura
     */
    public String getNroFactura() {
        return nroFactura;
    }

    /**
     * @param nroFactura the nroFactura to set
     */
    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
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
    
}
