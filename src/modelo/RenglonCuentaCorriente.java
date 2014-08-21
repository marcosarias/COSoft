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
public class RenglonCuentaCorriente {
    
    public static final int FACTURA = 0;
    public static final int RECIBO = 1;
    public static final int LIQUIDACION = 2;
    
    private String idFactura;
    private String idRecibo;
    private int idLiquidacion;
    private int tipo;

    public RenglonCuentaCorriente(int tipo, String id){
    
        this.tipo = tipo;
        if(tipo == RECIBO)
            this.idRecibo = id;
        else if(tipo == FACTURA)
                this.idFactura = id;
    
    }
    
    public RenglonCuentaCorriente(int tipo, int id){
    
        this.tipo = tipo;
        idLiquidacion = id;
    
    }

    /**
     * @return the idFactura
     */
    public String getIdFactura() {
        return idFactura;
    }

    /**
     * @param idFactura the idFactura to set
     */
    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * @return the idRecibo
     */
    public String getIdRecibo() {
        return idRecibo;
    }

    /**
     * @param idRecibo the idRecibo to set
     */
    public void setIdRecibo(String idRecibo) {
        this.idRecibo = idRecibo;
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
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
