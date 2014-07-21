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
public class DetalleLiquidacion {
    
    private int idDetalleLiquidacion;
    private int matricula;
    private int idLiquidacion;
    private float atributo;
    private String valor;
    
    private ArrayList<ConceptoLiquidacion> conceptos;

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
     * @return the atributo
     */
    public float getAtributo() {
        return atributo;
    }

    /**
     * @param atributo the atributo to set
     */
    public void setAtributo(float atributo) {
        this.atributo = atributo;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the conceptos
     */
    public ArrayList<ConceptoLiquidacion> getConceptos() {
        return conceptos;
    }

    /**
     * @param conceptos the conceptos to set
     */
    public void setConceptos(ArrayList<ConceptoLiquidacion> conceptos) {
        this.conceptos = conceptos;
    }
    
}
