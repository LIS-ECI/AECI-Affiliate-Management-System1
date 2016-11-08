/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Solicitud;
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
@SessionScoped
@ManagedBean(name="BeanSolicitudes")

public class SolicitudesBean {
    

private String usuario;
private String clave;
private Date Fecha;
private Date fecha;
private List<Solicitud> listaDeSolicitudes = new ArrayList<Solicitud>();
    
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
    
}
