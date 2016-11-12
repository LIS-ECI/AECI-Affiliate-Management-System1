/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Observacion;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Servicio;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
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
private Date fecha;
private Estudiante est;
private Egresado egr;
private Solicitud seleccionado;  
static private List<Solicitud> solicitudes;
private String pagina="index";


    public SolicitudesBean(){}

    public Solicitud getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Solicitud seleccionado) {
        this.seleccionado = seleccionado;
        if (seleccionado.getTipo().equals("Estudiante")){
            est=Servicios.getInstance().consultarEstudiante(seleccionado.getCedula(),seleccionado.getTipo_cedula());
            
        }
        else if (seleccionado.getTipo().equals("Egresado")){
            egr=Servicios.getInstance().consultarEgresado(seleccionado.getCedula(),seleccionado.getTipo_cedula());
        }
        
    }
    
    public List<Solicitud> getSolicitudes() {
        
        return Servicios.getInstance().consultarSolicitud();

    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

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
    
    public String getPagina() {
          this.pagina="detallesEstudiante";

        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina="detallesEstudiante";

    }


    
    public Estudiante getEst() {
        return est;
    }

    public void setEst(Estudiante est) {
        this.est = est;
    }

    public Egresado getEgr() {
        return egr;
    }

    public void setEgr(Egresado egr) {
        this.egr = egr;
    }

    
    
    public void aprobar(){
        Usuario s= new Usuario(String.valueOf(est.numero_identificacion),String.valueOf( est.numero_identificacion), "Estudiante", "Activo", est.numero_identificacion, est.tipo_identificacion, null, null, null );
        Servicios.getInstance().InsertarUsuario(s);
        Servicios.getInstance().ModificarSolicitud("OK",est.numero_identificacion,est.tipo_identificacion);
        //Enviar Correo indicando usuario y contraseña
    }
    
    public void rechazar(){}
}
