/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

/**
 *
 * @author  Grupo 3 Pdsw
 */
    public class Observacion {
       private int numero_observacion;
       private String comentario;
       private String Usuario_nombre;

     /**
    * Constructor Clase Observacion
     * @param numero_observacion identificador observacion
     * @param comentario comentario
    */
    public Observacion(int numero_observacion, String comentario,String Usuario_nombre) {
        this.numero_observacion = numero_observacion;
        this.comentario = comentario;
        this.Usuario_nombre=Usuario_nombre;
    }
    public Observacion(){}
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

    public String getUsuario_nombre() {
        return Usuario_nombre;
    }

    public void setUsuario_nombre(String Usuario_nombre) {
        this.Usuario_nombre = Usuario_nombre;
    }
       
}
