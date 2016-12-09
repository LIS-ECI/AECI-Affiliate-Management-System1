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
    private byte[] foto;
    private String validacion;
    private String Usuario_nombre;
    private java.sql.Date fechaRegistro;
    private String tipoTramite;
    private String nombrePersonal;
    private String apellidoPersonal;
    private String identificacionPersonal;

    /**
    * Constructor Clase Pago
     * @param id_pago identificador del pago
     * @param tipo tipo de pago, si es virtual o consignacion.
     * @param validacion validación, si ya fue tramitado o no.
     * @param Usuario_nombre usuario que realizo el pago
     * @param fecharegistro fecha en la que se realizo el pago
     * @param tipotramite si es un pago para afiliacion o renovacion.
     * @param nombrePersonal nombre del dueño del pago
     * @param apellidoPersonal apellido del dueño del pago
     * @param identificacionPersonal identificacion del dueño del pago
     * 
    */
    public Pago(String id_pago, String tipo, String validacion, String Usuario_nombre, java.sql.Date fecharegistro, String tipotramite, String nombrePersonal, String apellidoPersonal, String identificacionPersonal) {
        this.id_pago = id_pago;
        this.tipo = tipo;
        this.validacion = validacion;
        this.Usuario_nombre= Usuario_nombre;
        this.fechaRegistro=fecharegistro;
        this.tipoTramite=tipotramite;
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
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
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

    /**
     * @return the fechaRegistro
     */
    public java.sql.Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(java.sql.Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the tipoTramite
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * @param tipoTramite the tipoTramite to set
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * @return the nombrePersonal
     */
    public String getNombrePersonal() {
        return nombrePersonal;
    }

    /**
     * @param nombrePersonal the nombrePersonal to set
     */
    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    /**
     * @return the apellidoPersonal
     */
    public String getApellidoPersonal() {
        return apellidoPersonal;
    }

    /**
     * @param apellidoPersonal the apellidoPersonal to set
     */
    public void setApellidoPersonal(String apellidoPersonal) {
        this.apellidoPersonal = apellidoPersonal;
    }

    /**
     * @return the identificacionPersonal
     */
    public String getIdentificacionPersonal() {
        return identificacionPersonal;
    }

    /**
     * @param identificacionPersonal the identificacionPersonal to set
     */
    public void setIdentificacionPersonal(String identificacionPersonal) {
        this.identificacionPersonal = identificacionPersonal;
    }
    
    
            
}
