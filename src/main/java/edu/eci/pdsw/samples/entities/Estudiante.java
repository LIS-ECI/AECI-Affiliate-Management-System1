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
public class Estudiante extends Afiliado {

    private List<CorreoPersonal> correo;
    private String direccion_vivienda;
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

    public Estudiante(){}
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
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
     * @param direccion_vivienda direccion del estudiante
     * @param correo correo del estudiante
    */
    public Estudiante(String genero,String apellido,int codigo, long numero_identificacion, String nombre, int semestre, String tipo_identificacion, String carrera, int telefono_fijo, long celular, List<CorreoPersonal> correo, String direccion_vivienda) {
        this.codigo = codigo;
        this.numero_identificacion = numero_identificacion;
        this.carrera = carrera;
        this.celular = celular;
        this.correo = new LinkedList<>();
        this.correo = correo;
        this.semestre = semestre;
        this.telefono_fijo = telefono_fijo;
        this.tipo_identificacion = tipo_identificacion;
        this.direccion_vivienda = direccion_vivienda;
        this.nombre = nombre;
        this.apellido=apellido;
        this.genero=genero;
    }

    /**
     * @return the correo
     */
    public List<CorreoPersonal> getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(List<CorreoPersonal> correo) {
        this.correo = correo;
    }

    /**
     * @return the direccion_vivienda
     */
    public String getDireccion_vivienda() {
        return direccion_vivienda;
    }

    /**
     * @param direccion_vivienda the direccion_vivienda to set
     */
    public void setDireccion_vivienda(String direccion_vivienda) {
        this.direccion_vivienda = direccion_vivienda;
    }

    /**
     * @return the numero_identificacion
     */
    public long getNumero_identificacion() {
        return numero_identificacion;
    }

    /**
     * @param numero_identificacion the numero_identificacion to set
     */
    public void setNumero_identificacion(long numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo_identificacion
     */
    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    /**
     * @param tipo_identificacion the tipo_identificacion to set
     */
    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the telefono_fijo
     */
    public int getTelefono_fijo() {
        return telefono_fijo;
    }

    /**
     * @param telefono_fijo the telefono_fijo to set
     */
    public void setTelefono_fijo(int telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    /**
     * @return the celular
     */
    public long getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(long celular) {
        this.celular = celular;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

}
