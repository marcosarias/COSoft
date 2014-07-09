/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author COCO
 */
public class Recibo {
    
    private int idRecibo;
    private String nroRecibo;
    private int matricula;
    private String detalle;

    /**
     * @return the idRecibo
     */
    public int getIdRecibo() {
        return idRecibo;
    }

    /**
     * @param idRecibo the idRecibo to set
     */
    public void setIdRecibo(int idRecibo) {
        this.idRecibo = idRecibo;
    }

    /**
     * @return the nroRecibo
     */
    public String getNroRecibo() {
        return nroRecibo;
    }

    /**
     * @param nroRecibo the nroRecibo to set
     */
    public void setNroRecibo(String nroRecibo) {
        this.nroRecibo = nroRecibo;
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
