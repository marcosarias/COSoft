/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author COCO
 */
public class Cheque {
    
    private int idCheque;
    private String fechaCobro;
    private String fechaEmision;
    private String destinatario;
    private String detalle;

    /**
     * @return the idcheque
     */
    public int getIdCheque() {
        return idCheque;
    }

    /**
     * @param idcheque the idcheque to set
     */
    public void setIdCheque(int idCheque) {
        this.idCheque = idCheque;
    }

    /**
     * @return the fechaCobro
     */
    public String getFechaCobro() {
        return fechaCobro;
    }

    /**
     * @param fechaCobro the fechaCobro to set
     */
    public void setFechaCobro(String fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    /**
     * @return the fechaEmision
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
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
