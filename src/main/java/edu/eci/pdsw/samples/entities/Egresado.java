/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.List;

/**
 *
 * @author  Grupo 3 Pdsw
 */
public class Egresado extends Afiliado{
    
    private long numero_identificacion;
    private String tipo_identificacion;
    private String nombre;
    private int fecha_grado;
    private int periodo_grado;
    private String cargo;
    private String carrera;
    private String direccion_vivienda;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private int telefono_oficina;
    private int telefono_fijo;
    private long celular;
    private List<CorreoPersonal> correo;
    private String apellido;
    private String genero;

    /**
    * Constructor Clase Egresado
     * @param genero genero
     * @param apellido apellido
     * @param numero_identificacion numero de identificacion
     * @param tipo_identificacion tipo de identificacion
     * @param nombre nombre
     * @param fecha_grado anio del grado
     * @param periodo_grado periodo grado
     * @param cargo cargo opcional
     * @param carrera carrera
     * @param direccion_vivienda direccion vivienda opcional
     * @param nombreEmpresa nombre empresa opcional
     * @param direccionEmpresa direccion de la empresa opcional
     * @param telefono_oficina telefono oficina
     * @param telefono_fijo telefono fijo
     * @param celular celular
     * @param correo correo
    */
    public Egresado(String genero, String apellido,long numero_identificacion, String tipo_identificacion, String nombre, int fecha_grado, int periodo_grado, String cargo, String carrera, String direccion_vivienda, String nombreEmpresa, String direccionEmpresa, int telefono_oficina, int telefono_fijo, long celular, List<CorreoPersonal> correo) {
        this.numero_identificacion = numero_identificacion;
        this.tipo_identificacion = tipo_identificacion;
        this.nombre = nombre;
        this.fecha_grado = fecha_grado;
        this.periodo_grado = periodo_grado;
        this.cargo = cargo;
        this.carrera = carrera;
        this.direccion_vivienda = direccion_vivienda;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefono_oficina = telefono_oficina;
        this.telefono_fijo = telefono_fijo;
        this.celular = celular;
        this.genero =genero;
        this.correo=correo;
        this.apellido=apellido;
    }
    
    public Egresado(){}

    /**
     * @return the fecha_grado
     */
    public int getFecha_grado() {
        return fecha_grado;
    }

    /**
     * @param fecha_grado the fecha_grado to set
     */
    public void setFecha_grado(int fecha_grado) {
        this.fecha_grado = fecha_grado;
    }

    /**
     * @return the periodo_grado
     */
    public int getPeriodo_grado() {
        return periodo_grado;
    }

    /**
     * @param periodo_grado the periodo_grado to set
     */
    public void setPeriodo_grado(int periodo_grado) {
        this.periodo_grado = periodo_grado;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the programa
     */
    public String getPrograma() {
        return getCarrera();
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.setCarrera(programa);
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
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * @return the direccionEmpresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * @param direccionEmpresa the direccionEmpresa to set
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * @return the telefono_oficina
     */
    public int getTelefono_oficina() {
        return telefono_oficina;
    }

    /**
     * @param telefono_oficina the telefono_oficina to set
     */
    public void setTelefono_oficina(int telefono_oficina) {
        this.telefono_oficina = telefono_oficina;
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
