/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Grupo 3 Pdsw
 */
public class Solicitud{

    private java.sql.Date fecha;
    private long numero_identificacion;
    private String tipo_cedula;
    private String tipo;
    private String estado; 
    private java.sql.Date fechaAfiliacion;

    /**
    * Constructor Clase Correo
     * @param fecha fecha solicitud
     * @param cedula cedula 
     * @param tipo_cedula tipo cedula
     * @param tipo tipo
     * @param estado estado
    */
    public Solicitud(java.sql.Date  fecha, long cedula, String tipo_cedula, String tipo,String estado) {
        this.fecha = fecha;
        this.numero_identificacion= cedula;
        this.tipo_cedula = tipo_cedula;
        this.tipo = tipo;
        this.estado=estado;
    }

    public Solicitud() {
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * @return the fecha
     */
    public java.sql.Date  getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(java.sql.Date  fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cedula
     */
    public long getNumero_identificacion() {
        return numero_identificacion;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setNumero_identificacion(long cedula) {
        this.numero_identificacion = cedula;
    }

    /**
     * @return the tipo_cedula
     */
    public String getTipo_cedula() {
        return tipo_cedula;
    }

    /**
     * @param tipo_cedula the tipo_cedula to set
     */
    public void setTipo_cedula(String tipo_cedula) {
        this.tipo_cedula = tipo_cedula;
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
     * @return the tipo
     */
    public java.sql.Date getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    /**
     * @param fAfiliacion the tipo to set
     */
    public void setFechaAfiliacion(java.sql.Date fAfiliacion){
        this.fechaAfiliacion = fAfiliacion;
    }
    
    
    
}
