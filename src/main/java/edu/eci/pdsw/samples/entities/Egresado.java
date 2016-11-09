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
 * @author 2089340
 */
public class Egresado {
    
    private long cedula;
    private String cedula_tipo;
    private String nombre;
    private int fecha_grado;
    private int periodo_grado;
    private String cargo;
    private String programa;
    private String direccion_vivienda;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private int telefono_oficina;
    private int telefono_fijo;
    private long celular;
    private List<String> correo;

    public Egresado(long cedula, String cedula_tipo, String nombre, int fecha_grado, int periodo_grado, String cargo, String programa, String direccion_vivienda, String nombreEmpresa, String direccionEmpresa, int telefono_oficina, int telefono_fijo, long celular, String correo) {
        this.cedula = cedula;
        this.cedula_tipo = cedula_tipo;
        this.nombre = nombre;
        this.fecha_grado = fecha_grado;
        this.periodo_grado = periodo_grado;
        this.cargo = cargo;
        this.programa = programa;
        this.direccion_vivienda = direccion_vivienda;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefono_oficina = telefono_oficina;
        this.telefono_fijo = telefono_fijo;
        this.celular = celular;
        this.correo=new LinkedList<>();
        this.correo.add(correo);
    }

    /**
     * @return the cedula
     */
    public long getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the cedula_tipo
     */
    public String getCedula_tipo() {
        return cedula_tipo;
    }

    /**
     * @param cedula_tipo the cedula_tipo to set
     */
    public void setCedula_tipo(String cedula_tipo) {
        this.cedula_tipo = cedula_tipo;
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
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.programa = programa;
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
    public List<String> getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(List<String> correo) {
        this.correo = correo;
    }

    
}
