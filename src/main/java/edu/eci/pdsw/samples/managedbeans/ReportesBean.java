/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Afiliado;
import edu.eci.pdsw.samples.entities.Correo;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.Serializable;
import java.sql.Date;
//import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Grupo 3 Pdsw
 */

@ManagedBean(name="BeanReporteAfiliaciones")
@SessionScoped



public class ReportesBean implements Serializable {
    
    private long numero_identificacion;
    private String base="applicationconfig.properties";
    private List<Solicitud> afiliaciones;
    //private Date fecha = Date.valueOf(LocalDate.MAX);   
    private String tipo_identificacion;
    private String nombre;
    private String Apellido;
    private String direccion;
    private String correoElectronico;
    private Usuario selectedAfiliado;
    private List<Usuario> selectedAfiliados;
    private List<Usuario> UsuariosFIltrados;
    private String Correo;
    
   
  
    
    
    public List<Usuario> getUsuarios() throws PersistenceException  {
        List<Usuario> a =Servicios.getInstance(base).consultarUsuarios();

        return a;
    }
    
    
    public String getCorreo() throws PersistenceException{
        Correo= "";
        if(selectedAfiliado.getTipo().equals("Estudiante")){
        Estudiante e= Servicios.getInstance(base).consultarEstudiante(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        for (int i=0;i<e.getCorreo().size();i++){
                Correo+="      "+e.getCorreo().get(i).getCorreo();
            }
        } 
        else{
        Egresado e= Servicios.getInstance(base).consultarEgresado(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        for (int i=0;i<e.getCorreo().size();i++){
                Correo+="      "+e.getCorreo().get(i).getCorreo();
            }
        
        }
        return Correo;
    
    }
    
    public void setAfiliaciones( List<Solicitud>  afiliaciones){
        this.afiliaciones=afiliaciones;
    }


    public String getNombre() throws PersistenceException{
        nombre="";
        if(selectedAfiliado.getTipo().equals("Estudiante")){
        Estudiante e= Servicios.getInstance(base).consultarEstudiante(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        nombre=e.getNombre();
        }else {
        Egresado eg= Servicios.getInstance(base).consultarEgresado(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        nombre=eg.getNombre();
        }        
        return nombre;
    }
    
    public void setNombre(String name){
        nombre = name;
    }
    
    public String getApellido() throws PersistenceException{
    Apellido="";
     if(selectedAfiliado.getTipo().equals("Estudiante")){
        Estudiante e= Servicios.getInstance(base).consultarEstudiante(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        Apellido=e.getApellido();
        }else {
        Egresado eg= Servicios.getInstance(base).consultarEgresado(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        Apellido=eg.getApellido();
        }        
        return Apellido;
    }
    
    public void setApellido(String Apell){
        Apellido= Apell;
    }
    
    public long getDocIdentificacion(){
        return this.numero_identificacion;
    }
    
    public void setDocIdentificacion(long in){
        numero_identificacion = in;
    }
    
    public String getDireccion() throws PersistenceException{
        direccion="";
        if(selectedAfiliado.getTipo().equals("Estudiante")){
        Estudiante e= Servicios.getInstance(base).consultarEstudiante(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        direccion=e.getDireccion_vivienda();
        
    }
        else {
        Egresado eg= Servicios.getInstance(base).consultarEgresado(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        direccion=eg.getDireccion_vivienda();
        }
        return direccion;
        }
    
    public void setDireccion(String dir){
        direccion =dir;
    }
    
    public String getCorreoElectronico(){
        return this.correoElectronico;
    }
    
    public void setCorreoElectronico(String coel){
        correoElectronico=coel;
    }
    
    public Usuario getSelectedAfiliado() {
        return selectedAfiliado;
    }
 
    public void setSelectedAfiliado(Usuario selectedAfiliado) {
        this.selectedAfiliado = selectedAfiliado;
    }
    
    public List<Usuario> getSelectedAfiliados() {
        return selectedAfiliados;
    }
 
    public void setSelectedAfiliados(List<Usuario> selectedAfiliados) {
        this.selectedAfiliados = selectedAfiliados;
    }
    
    public void EnviarAdvertencia() throws PersistenceException{
        //Servicios.getInstance(base).ModificarSolicitud("NOOK",egr.getNumero_identificacion(),egr.getTipo_identificacion());
        //enviarCorreo(this.respuestaSolicitud,egr.getCorreo().get(0).getCorreo());
        //this.respuestaSolicitud="";
        String Mensaje;
        String Correo1="";
        String Genero = "";
        if(selectedAfiliado.getTipo().equals("Estudiante")){
        Estudiante e= Servicios.getInstance(base).consultarEstudiante(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
            if(e.getGenero().equals("Masculino")){
             Genero="Apreciado "+e.getNombre(); 
            }
            else{
            Genero="Apreciada "+e.getNombre();  
            }
        }
        else {
        Egresado e= Servicios.getInstance(base).consultarEgresado(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
            if(e.getGenero().equals("Masculino")){
            Genero="Apreciado "+e.getNombre();
            }
            else{
            Genero="Apreciada "+e.getNombre();  
            }
        }
        Mensaje=Genero +"le recordamos que su afiliacion se vencera pronto, no olvide realizar su pago oportunamente";
        if(selectedAfiliado.getTipo().equals("Estudiante")){
        Estudiante e= Servicios.getInstance(base).consultarEstudiante(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        Correo1=e.getCorreo().get(0).getCorreo();
        }
        else{
        Egresado eg= Servicios.getInstance(base).consultarEgresado(selectedAfiliado.getCedula_numero(),selectedAfiliado.getCedula_tipo());
        Correo1=eg.getCorreo().get(0).getCorreo();
        }
        enviarCorreo(Mensaje, Correo1);
    }
    
    
    
    public void enviarCorreo(String mensaje,String correo){
        Correo correo1 = new Correo();
        correo1.setMessage(mensaje);
        correo1.setTo(correo);
        correo1.enviarCorreo();     
        
    }
    
}
