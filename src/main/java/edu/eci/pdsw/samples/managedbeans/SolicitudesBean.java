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
private Solicitud s;  
private String correos="";
private String pagina="solicitud";
private String respuestaSolicitud;


    public SolicitudesBean(){}

   
    public List<Solicitud> getSolicitudes() {
        List<Solicitud> a=Servicios.getInstance().consultarSolicitud();
        return a;

    }
    
    
    public Solicitud getS() {
        return s;
    }

    public void setS(Solicitud s) {
        this.s = s;
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
    
    public String getPagina() {
        if (!(s == null)){
        correos="";
        
        if (s.getTipo().equals("Estudiante")) {
            this.est = Servicios.getInstance().consultarEstudiante(s.getCedula(), s.getTipo_cedula());
            this.pagina = "detallesEstudiante";
            for (int i=0;i<est.getCorreo().size();i++){
                correos+="      "+est.getCorreo().get(i).getCorreo();
            }
        }
        else{
            this.egr = Servicios.getInstance().consultarEgresado(s.getCedula(), s.getTipo_cedula());
            System.out.println(s.getCedula()+ s.getTipo_cedula()+"  EGRESADO  ");
            this.pagina = "detallesEgresado";
            for (int i=0;i<egr.getCorreo().size();i++){
                correos+="      "+egr.getCorreo().get(i).getCorreo();
            }
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


    public void aprobarEst(){
        Usuario sa= new Usuario(String.valueOf(est.getNumero_identificacion()),String.valueOf( est.getNumero_identificacion()), "Estudiante", "Activo", est.getNumero_identificacion(), est.getTipo_identificacion(), null, null, null );
        Servicios.getInstance().InsertarUsuario(sa);
        Servicios.getInstance().ModificarSolicitud("OK",est.getNumero_identificacion(),est.getTipo_identificacion());
        //Enviar Correo indicando usuario y contraseña
    }
    
    public void rechazarEst(){
        Servicios.getInstance().ModificarSolicitud("NOOK",est.getNumero_identificacion(),est.getTipo_identificacion());
        enviarCorreo(this.respuestaSolicitud,est.getCorreo().get(0).getCorreo());
        this.respuestaSolicitud="";
    }
    
     public void aprobarEgr(){
        Usuario s= new Usuario(String.valueOf(egr.getCedula()),String.valueOf( egr.getCedula()), "Egresado", "Inactivo", egr.getCedula(), egr.getCedula_tipo(), null, null, null );
        Servicios.getInstance().InsertarUsuario(s);
        Servicios.getInstance().ModificarSolicitud("OK",egr.getCedula(),egr.getCedula_tipo());
        //Enviar Correo indicando usuario y contraseña
    }
    
    public void rechazarEgr(){
        Servicios.getInstance().ModificarSolicitud("NOOK",egr.getCedula(),egr.getCedula_tipo());
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
