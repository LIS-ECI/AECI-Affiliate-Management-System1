/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.sql.Blob;

/**
 *
 * @author  Grupo 3 Pdsw
 */
public class Pago {
    
    private String id_pago;
    private String tipo;
    private Blob foto;
    private String validacion;
    private String Usuario_nombre;

    /**
    * Constructor Clase Pago
     * @param id_pago identificador del pago
     * @param tipo tipo de pago
     * @param validacion validacion
     * @param Usuario_nombre usuario que realizo el pago
    */
    public Pago(String id_pago, String tipo, String validacion, String Usuario_nombre) {
        this.id_pago = id_pago;
        this.tipo = tipo;
        this.validacion = validacion;
        this.Usuario_nombre= Usuario_nombre;
    }

    public Pago(){}
    
    /**
     * @return the id_pago
     */
    public String getId_pago() {
        return id_pago;
    }

    /**
     * @param id_pago the id_pago to set
     */
    public void setId_pago(String id_pago) {
        this.id_pago = id_pago;
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
     * @return the foto
     */
    public Blob getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    /**
     * @return the validacion
     */
    public String getValidacion() {
        return validacion;
    }

    /**
     * @param validacion the validacion to set
     */
    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public String getUsuario_nombre() {
        return Usuario_nombre;
    }

    public void setUsuario_nombre(String Usuario_nombre) {
        this.Usuario_nombre = Usuario_nombre;
    }
    
    
            
}
