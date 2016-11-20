/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.Date;

/**
 *
 * @author Grupo 3 Pdsw
 */
public class Servicio {

    private String tDeServicio;
    private Date fecha;

    
    /**
    * Constructor Clase Servicio
     * @param tDeServicio
     * @param fecha
    */
    public Servicio(String tDeServicio, Date fecha) {
        this.tDeServicio = tDeServicio;
        this.fecha = fecha;
    }

    public Servicio(){}
    
    /**
     * @return the tDeServicio - tipo del servicio
     */
    public String gettDeServicio() {
        return tDeServicio;
    }

    /**
     * @param tDeServicio the tDeServicio to set
     */
    public void settDeServicio(String tDeServicio) {
        this.tDeServicio = tDeServicio;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
