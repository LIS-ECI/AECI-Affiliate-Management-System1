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
    private String apellido;
    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
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
    * Constructor Clase Estudiante
     * @param genero genero del estudiante
     * @param apellido apellido del estudiante
     * @param codigo codigo del estudiante
     * @param numero_identificacion numero de identificacion del estudiante
     * @param nombre nombre del estudiante
     * @param semestre semestre del estudiante
     * @param tipo_identificacion tipo de identificacion
     * @param carrera carrera del estudiante
     * @param telefono_fijo telefono del estudiante
     * @param celular celular del estudiante
     * @param direccion direccion del estudiante
     * @param correo correo del estudiante
    */
    public Estudiante(String genero,String apellido,int codigo, long numero_identificacion, String nombre, int semestre, String tipo_identificacion, String carrera, int telefono_fijo, long celular, List<CorreoPersonal> correo, String direccion) {
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
        this.apellido=apellido;
        this.genero=genero;
    }

}
