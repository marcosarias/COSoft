/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author COCO
 */
class ConceptoLiquidacion {
    
    private int idConceptoLiquidacion;
    private int idDetalleLiquidacion;
    private float importe;
    private int idTipoCuota;

    /**
     * @return the idConceptoLiquidacion
     */
    public int getIdConceptoLiquidacion() {
        return idConceptoLiquidacion;
    }

    /**
     * @param idConceptoLiquidacion the idConceptoLiquidacion to set
     */
    public void setIdConceptoLiquidacion(int idConceptoLiquidacion) {
        this.idConceptoLiquidacion = idConceptoLiquidacion;
    }

    /**
     * @return the idDetalleLiquidacion
     */
    public int getIdDetalleLiquidacion() {
        return idDetalleLiquidacion;
    }

    /**
     * @param idDetalleLiquidacion the idDetalleLiquidacion to set
     */
    public void setIdDetalleLiquidacion(int idDetalleLiquidacion) {
        this.idDetalleLiquidacion = idDetalleLiquidacion;
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
     * @return the idTipoCuota
     */
    public int getIdTipoCuota() {
        return idTipoCuota;
    }

    /**
     * @param idTipoCuota the idTipoCuota to set
     */
    public void setIdTipoCuota(int idTipoCuota) {
        this.idTipoCuota = idTipoCuota;
    }
    
}
