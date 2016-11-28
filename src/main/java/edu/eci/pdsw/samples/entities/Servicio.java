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
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
    * Constructor Clase Servicio
     * @param tDeServicio tipo de servicio
     * @param fecha fecha
    */
    public Servicio(String tDeServicio, Date fecha,String username) {
        this.tDeServicio = tDeServicio;
        this.username=username;
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
