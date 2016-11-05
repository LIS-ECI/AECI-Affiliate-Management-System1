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
public class Usuario {
    private String nombre;
    private int clave;
    private String tipo;//tipo de usuario
    private String estado;
    private int cedula_numero;
    private String cedula_tipo;
    private List<Observacion> observaciones;
    private List<Servicio> servicios_usados;
    private List<Pago> pagos;

    public Usuario(String nombre, int clave, String tipo, String estado, int cedula_numero, String cedula_tipo, Observacion observacion, Servicio servicio, Pago pago ) {
        this.nombre = nombre;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
        this.cedula_numero = cedula_numero;
        this.cedula_tipo = cedula_tipo;
        this.observaciones = new LinkedList<>();
        this.observaciones.add(observacion);
        this.servicios_usados = new LinkedList<>();
        this.servicios_usados.add(servicio);
        this.pagos = new LinkedList<>();
        this.pagos.add(pago);
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
     * @return the clave
     */
    public int getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(int clave) {
        this.clave = clave;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cedula_numero
     */
    public int getCedula_numero() {
        return cedula_numero;
    }

    /**
     * @param cedula_numero the cedula_numero to set
     */
    public void setCedula_numero(int cedula_numero) {
        this.cedula_numero = cedula_numero;
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
     * @return the observaciones
     */
    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(List<Observacion> observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the servicios_usados
     */
    public List<Servicio> getServicios_usados() {
        return servicios_usados;
    }

    /**
     * @param servicios_usados the servicios_usados to set
     */
    public void setServicios_usados(List<Servicio> servicios_usados) {
        this.servicios_usados = servicios_usados;
    }

    /**
     * @return the pagos
     */
    public List<Pago> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    
    
}
