/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.pdsw.samples.entities.Certificado;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Image;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Grupo 3 Pdsw
 */
@ManagedBean(name = "beanIndex")

@SessionScoped
public class PrincipalBean implements Serializable {

    private String usuario;
    private String base="applicationconfig.properties";
    private String clave;
    private String validacion="";
    private boolean validador=false;
 
    
  
    
    public int getCodigo() {

        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    private int codigo=0;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
 *
 * Obtener la clave del usuario
 */
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getValidacion() {
        validar();
        return this.validacion;
        
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }
    
    public void validar(){
        validacion="";
        String nombre="";
        
        Certificado c=null;
        try {
            c = Servicios.getInstance(base).getCertificado(codigo);
        } catch (PersistenceException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
        }
        
        if (c==null){
            this.validacion="El Certificado No Es Válido";
        }
        else{
            Usuario u=null;
            try {
                u = Servicios.getInstance(base).getUsuario(c.getUsuario_nombre());
            } catch (PersistenceException ex) {
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
            }
            if(u.getTipo().equals("Estudiante")){
                Estudiante est=null;
                try {
                    est = Servicios.getInstance(base).consultarEstudiante(u.getCedula_numero(), u.getCedula_tipo());
                } catch (PersistenceException ex) {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
                }
                nombre= est.getNombre()+' '+est.getApellido();
            }
            else{
                Egresado egr=null;
                try {
                    egr = Servicios.getInstance(base).consultarEgresado(u.getCedula_numero(), u.getCedula_tipo());
                } catch (PersistenceException ex) {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
                }
                nombre= egr.getNombre()+' '+egr.getApellido();
            }
            Date fecha11 = new java.sql.Date(u.getFechaInicio().getTime());
                Date fecha22 = new java.sql.Date(u.getFechaFin().getTime());

            this.validacion="El Certificado Ingresado Pertenece a "+nombre+" identificado con "+u.getCedula_tipo()+" "+u.getCedula_numero()+" y cuya aficiacion va desde "+fecha11+" hasta "+fecha22;
            if(validador){
                try {
                    Servicios.getInstance(base).invalidarCertificado(codigo);
                } catch (PersistenceException ex) {
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
                }
                validador=false;
            }  
            else{
            validador=true;
            }
        }
    }

        
    


}