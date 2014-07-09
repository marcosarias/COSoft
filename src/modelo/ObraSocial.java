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
public class ObraSocial {
    
    private int idObraSocial;
    private String nombre;
    private String direccion;
    private String telefonos;
    private String firma;
    private String fechacontrato;
    
    private ArrayList<Profesional> profesionales;

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
     * @return the profesionales
     */
    public ArrayList<Profesional> getProfesionales() {
        return profesionales;
    }

    /**
     * @param profesionales the profesionales to set
     */
    public void setProfesionales(ArrayList<Profesional> profesionales) {
        this.setProfesionales(profesionales);
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefonos
     */
    public String getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * @return the firma
     */
    public String getFirma() {
        return firma;
    }

    /**
     * @param firma the firma to set
     */
    public void setFirma(String firma) {
        this.firma = firma;
    }

    /**
     * @return the fechacontrato
     */
    public String getFechacontrato() {
        return fechacontrato;
    }

    /**
     * @param fechacontrato the fechacontrato to set
     */
    public void setFechacontrato(String fechacontrato) {
        this.fechacontrato = fechacontrato;
    }
    
}
