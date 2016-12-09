/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

/**
 *
 * @author User
 */
public class Certificado {
    
    private int id;
    private String Usuario_nombre;
    private String valido;
    
    public Certificado(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Certificado(int id, String Usuario_nombre,String valido) {
        this.id = id;
        this.Usuario_nombre = Usuario_nombre;
        this.valido=valido;
    }

    public String getUsuario_nombre() {
        return Usuario_nombre;
    }

    public void setUsuario_nombre(String Usuario_nombre) {
        this.Usuario_nombre = Usuario_nombre;
    }

    public String getValido() {
        return valido;
    }

    public void setValido(String valido) {
        this.valido = valido;
    }
    
    
    
}
