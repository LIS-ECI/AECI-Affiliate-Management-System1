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
import java.time.LocalDate;
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
    private Date fecha = Date.valueOf(LocalDate.MAX);   
    private String tipo_identificacion;
    private String nombre;
    private String direccion;
    private String correoElectronico;
    private Usuario selectedAfiliado;
    private List<Usuario> selectedAfiliados;
    private List<Usuario> UsuariosFIltrados;
    
   
  
    
    
    public List<Usuario> getUsuarios() throws PersistenceException  {
        List<Usuario> a =Servicios.getInstance(base).consultarUsuarios();

        return a;
    }
    
    
    

    public void setAfiliaciones( List<Solicitud>  afiliaciones){
        this.afiliaciones=afiliaciones;
    }


    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String name){
        nombre = name;
    }
    
    public long getDocIdentificacion(){
        return this.numero_identificacion;
    }
    
    public void setDocIdentificacion(long in){
        numero_identificacion = in;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    public void setDireccion(String dir){
        direccion =dir;
    }
    
    public String getCorreoElectronico(){
        return this.correoElectronico;
    }
    
    public void getCorreoElectronico(String coel){
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
    
    public void enviarCorreo(String mensaje,String correo){
        Correo correo1 = new Correo();
        correo1.setMessage(mensaje);
        correo1.setTo(correo);
        correo1.enviarCorreo();     
        
    }
    
}
