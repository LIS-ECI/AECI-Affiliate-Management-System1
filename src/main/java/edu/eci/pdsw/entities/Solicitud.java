/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

import java.util.Date;

/**
 *
 * @author 2106088
 */
public class Solicitud {

    private Date fecha;
    private int cedula;
    private String tipo_cedula;
    private String tipo;

    public Solicitud(Date fecha, int cedula, String tipo_cedula, String tipo) {
        this.fecha = fecha;
        this.cedula = cedula;
        this.tipo_cedula = tipo_cedula;
        this.tipo = tipo;
    }

   

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getTipo_cedula() {
        return tipo_cedula;
    }

    public void setTipo_cedula(String tipo_cedula) {
        this.tipo_cedula = tipo_cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
