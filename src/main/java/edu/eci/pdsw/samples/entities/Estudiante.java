/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author  Grupo 3 Pdsw
 */
public class Estudiante {

    private List<CorreoPersonal> correo;
    private String direccion;
    private int codigo;
    private long numero_identificacion;
    private String nombre;
    private int semestre;
    private String tipo_identificacion;
    private String carrera;
    private int telefono_fijo;
    private long celular=12345;

    
    public Estudiante(){}
    
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

    public long getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(long numero_identificacion) {
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

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public List<CorreoPersonal> getCorreo() {
        return correo;
    }

    public void setCorreo(List<CorreoPersonal> correo) {
        this.correo=correo;
    }

     /**
    * Constructor Clase Egresado
     * @param codigo
     * @param numero_identificacion
     * @param nombre
     * @param semestre
     * @param tipo_identificacion
     * @param carrera
     * @param telefono_fijo
     * @param celular
     * @param direccion
     * @param correo
    */
    public Estudiante(int codigo, long numero_identificacion, String nombre, int semestre, String tipo_identificacion, String carrera, int telefono_fijo, long celular, List<CorreoPersonal> correo, String direccion) {
        this.codigo = codigo;
        this.numero_identificacion = numero_identificacion;
        this.carrera = carrera;
        this.celular = celular;
        this.correo = new LinkedList<>();
        this.correo = correo;
        this.semestre = semestre;
        this.telefono_fijo = telefono_fijo;
        this.tipo_identificacion = tipo_identificacion;
        this.direccion = direccion;
        this.nombre = nombre;
    }

}
