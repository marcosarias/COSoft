 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author COCO
 */
public class Material {

    private int idMaterial;
    private int idTipoMaterial;
    private String tipo;
    private String marca;
    private float precio;
    private int stock;
    private int cantidadCompra; //No es campo de la base, es para simplificar al realizar compra

    /**
     * @return the idMaterial
     */
    public int getIdMaterial() {
        return idMaterial;
    }

    /**
     * @param idMaterial the idMaterial to set
     */
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    /**
     * @return the idTipoMaterial
     */
    public int getIdTipoMaterial() {
        return idTipoMaterial;
    }

    /**
     * @param idTipoMaterial the idTipoMaterial to set
     */
    public void setIdTipoMaterial(int idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cantidadCompra
     */
    public int getCantidadCompra() {
        return cantidadCompra;
    }

    /**
     * @param cantidadCompra the cantidadCompra to set
     */
    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
