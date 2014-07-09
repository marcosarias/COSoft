/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author COCO
 */
public class TipoCuota {
    
    private int idCuota;
    private String nombre;
    private float importe;
    private int frecuencia;

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the frecuencia
     */
    public int getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    
}
