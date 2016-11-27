/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Correo;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Observacion;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Servicio;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




/**
 *
 * @author Grupo 3 Pdsw
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
private Solicitud soli;  
private String correos="";
private String pagina="solicitud";
private String respuestaSolicitud;
private String base="applicationconfig.properties";


    public SolicitudesBean(){}

   /**
    * Metodo de obtener solicitudes
     * @return lista de solicitudes
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException 
    */
    public List<Solicitud> getSolicitudes() throws PersistenceException {
        List<Solicitud> a=Servicios.getInstance(base).consultarSolicitud();
        return a;

    }
    
    
    public Solicitud getSoli() {
        return soli;
    }

    public void setSoli(Solicitud soli) {
        this.soli = soli;
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

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }
    
    public String getPagina() throws PersistenceException {
        if (!(soli == null)){
        correos="";
        
        if (soli.getTipo().equals("Estudiante")) {
            this.est = Servicios.getInstance(base).consultarEstudiante(soli.getNumero_identificacion(), soli.getTipo_cedula());
            this.pagina = "detallesEstudiante";
            for (int i=0;i<est.getCorreo().size();i++){
                correos+="      "+est.getCorreo().get(i).getCorreo();
            }
            this.est.setNombre(est.getNombre()+' '+est.getApellido());
        }
        else{
            this.egr = Servicios.getInstance(base).consultarEgresado(soli.getNumero_identificacion(), soli.getTipo_cedula());
            this.pagina = "detallesEgresado";
            for (int i=0;i<egr.getCorreo().size();i++){
                correos+="      "+egr.getCorreo().get(i).getCorreo();
            }
            this.egr.setNombre(egr.getNombre()+' '+egr.getApellido());
        }
        }
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


    public void aprobarEst() throws PersistenceException{
        Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Calendar calendar = Calendar.getInstance();	
        calendar.setTime(fecha); 	
        calendar.add(Calendar.DAY_OF_YEAR, 183); 		
        Date fecha2=  new java.sql.Date(calendar.getTime().getTime());
        Usuario sa= new Usuario(fecha,fecha2,String.valueOf(est.getNumero_identificacion()),String.valueOf( est.getNumero_identificacion()), "Estudiante", "Activo", est.getNumero_identificacion(), est.getTipo_identificacion(), null, null, null );
        Servicios.getInstance(base).InsertarUsuario(sa);
        Servicios.getInstance(base).ModificarSolicitud("OK",est.getNumero_identificacion(),est.getTipo_identificacion());
        //Enviar Correo indicando usuario y contraseña
    }
    
    public void rechazarEst() throws PersistenceException{
        Servicios.getInstance(base).ModificarSolicitud("NOOK",est.getNumero_identificacion(),est.getTipo_identificacion());
        enviarCorreo(this.respuestaSolicitud,est.getCorreo().get(0).getCorreo());
        this.respuestaSolicitud="";
    }
    
     public void aprobarEgr() throws PersistenceException{
        Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Calendar calendar = Calendar.getInstance();	
        calendar.setTime(fecha); 	
        calendar.add(Calendar.DAY_OF_YEAR, 366); 		
        Date fecha2=  new java.sql.Date(calendar.getTime().getTime());
        Usuario s= new Usuario(fecha,fecha2,String.valueOf(egr.getNumero_identificacion()),String.valueOf( egr.getNumero_identificacion()), "Egresado", "Inactivo", egr.getNumero_identificacion(), egr.getTipo_identificacion(), null, null, null );
        Servicios.getInstance(base).InsertarUsuario(s);
        Servicios.getInstance(base).ModificarSolicitud("OK",egr.getNumero_identificacion(),egr.getTipo_identificacion());
        //Enviar Correo indicando usuario y contraseña
    }
    
    public void rechazarEgr() throws PersistenceException{
        Servicios.getInstance(base).ModificarSolicitud("NOOK",egr.getNumero_identificacion(),egr.getTipo_identificacion());
        enviarCorreo(this.respuestaSolicitud,egr.getCorreo().get(0).getCorreo());
        this.respuestaSolicitud="";

    }
    
    
    public void setRespuestaSolicitud(String respuesta){
        this.respuestaSolicitud = respuesta;
    }
    
    public String getRespuestaSolicitud(){
        return this.respuestaSolicitud;
    }
    
    public void enviarCorreo(String mensaje,String correo){
        Correo correo1 = new Correo();
        correo1.setMessage(mensaje);
        correo1.setTo(correo);
        correo1.enviarCorreo(); 
        
        
    }
}
