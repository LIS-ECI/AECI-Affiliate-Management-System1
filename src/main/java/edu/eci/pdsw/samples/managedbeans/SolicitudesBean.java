/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author 2103216
 */

/* Intento Commit con correccion de autor */
@ManagedBean(name="BeanSolicitudes")
@SessionScoped


public class SolicitudesBean implements Serializable{
    

private String usuario;
private String clave;
private Date Fecha;
private Date fecha;
private List<Solicitud> listaDeSolicitudes = new ArrayList<Solicitud>();

//Botones disponibles
private boolean botonIndex=false;
private boolean botonSolicitud=false;
private boolean botonInformacionEgresados=false;
private boolean botonInformacionEstudiantes=false;
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    /**
     * @return the botonIndex
     */
    public boolean isBotonIndex() {
        return botonIndex;
    }

    /**
     * @param botonIndex the botonIndex to set
     */
    public void setBotonRegistrarUnPrestamo(boolean botonIndex) {
        this.botonIndex = botonIndex;
    }
    
    /**
     * @return the botonSolicitud
     */
    public boolean isBotonSolicitud() {
        return botonSolicitud;
    }

    /**
     * @param botonSolicitud the botonSolicitud to set
     */
    public void setBotonSolicitud(boolean botonSolicitud) {
        this.botonSolicitud = botonSolicitud;
    }
    
    /**
     * @return the botonInformacionEgresados
     */
    public boolean isBotonInformacionEgresados() {
        return botonInformacionEgresados;
    }

    /**
     * @param botonInformacionEgresados the botonInformacionEgresados to set
     */
    public void setBotonInformacionEgresados(boolean botonInformacionEgresados) {
        this.botonInformacionEgresados = botonInformacionEgresados;
    }
    
    /**
     * @return the botonInformacionEstudiantes
     */
    public boolean isBotonInformacionEstudiantes() {
        return botonInformacionEstudiantes;
    }

    /**
     * @param botonInformacionEstudiantes the botonInformacionEstudiantes to set
     */
    public void setBotonInformacionEstudiantes(boolean botonInformacionEstudiantes) {
        this.botonInformacionEstudiantes = botonInformacionEstudiantes;
    }
    
    public List<Solicitud> getSolicitudes(){
        return Servicios.getInstance().consultarSolicitud();
    }
    
}
