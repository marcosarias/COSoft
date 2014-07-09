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
public class Profesional {
 
    private int matricula;
    private String nombre;
    private String telefonos;
    private String direccion;
    private String cbu;
    private String banco;
    private String localidad;
    private int idlocalidad;
    private TipoCuota tipoCuota;
    
    private ArrayList<ObraSocial> obrasSociales;

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
     * @return the tipoCuota
     */
    public TipoCuota getTipoCuota() {
        return tipoCuota;
    }

    /**
     * @param tipoCuota the tipoCuota to set
     */
    public void setTipoCuota(TipoCuota tipoCuota) {
        this.tipoCuota = tipoCuota;
    }

    /**
     * @return the obrasSociales
     */
    public ArrayList<ObraSocial> getObrasSociales() {
        return obrasSociales;
    }

    /**
     * @param obrasSociales the obrasSociales to set
     */
    public void setObrasSociales(ArrayList<ObraSocial> obrasSociales) {
        this.obrasSociales = obrasSociales;
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
     * @return the cbu
     */
    public String getCbu() {
        return cbu;
    }

    /**
     * @param cbu the cbu to set
     */
    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the idlocalidad
     */
    public int getIdlocalidad() {
        return idlocalidad;
    }

    /**
     * @param idlocalidad the idlocalidad to set
     */
    public void setIdlocalidad(int idlocalidad) {
        this.idlocalidad = idlocalidad;
    }
    
}
