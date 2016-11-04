/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.entities;

/**
 *
 * @author 2107641
 */

public class Estudiante {
    
    private int codigo;
    private int numero_identificacion;
    private String nombre;
    private int semestre;
    private String tipo_identificacion;
    private String carrera;
    private int telefono_fijo;
    private int celular;
    private String correo;
    private String direccion;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(int numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(int telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public Estudiante() {
    }

    public Estudiante(int codigo, int numero_identificacion,  String nombre, int semestre, String tipo_identificacion, String carrera, int telefono_fijo, int celular, String correo, String direccion ) {
        this.codigo = codigo;
        this.numero_identificacion = numero_identificacion;
        this.carrera=carrera;
        this.celular=celular;
        this.correo=correo;
        this.semestre=semestre;
        this.telefono_fijo=telefono_fijo;
        this.tipo_identificacion=tipo_identificacion;
        this.direccion=direccion;
        this.nombre=nombre;
    }
    
    
    
}
