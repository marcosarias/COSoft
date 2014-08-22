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
public class Condonacion {
    
    private int id;
    private int idCuota;
    private String fecha;

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
     * @return the idCuota
     */
    public int getIdCuota() {
        return idCuota;
    }

    /**
     * @param idCuota the idCuota to set
     */
    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
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
    
}
