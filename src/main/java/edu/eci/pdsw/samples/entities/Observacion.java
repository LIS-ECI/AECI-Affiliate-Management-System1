/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

/**
 *
 * @author 2089340
 */
class Observacion {
       private int numero_observacion;
       private String comentario;

       
    public Observacion(int numero_observacion, String comentario) {
        this.numero_observacion = numero_observacion;
        this.comentario = comentario;
    }

    /**
     * @return the numero_observacion
     */
    public int getNumero_observacion() {
        return numero_observacion;
    }

    /**
     * @param numero_observacion the numero_observacion to set
     */
    public void setNumero_observacion(int numero_observacion) {
        this.numero_observacion = numero_observacion;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
       
}