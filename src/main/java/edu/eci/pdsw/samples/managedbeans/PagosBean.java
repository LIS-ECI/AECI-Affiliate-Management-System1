/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.sample.bean.security.ShiroLoginBean;
import edu.eci.pdsw.samples.entities.Image;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.apache.commons.io.IOUtils;



/**
 *
 * @author User
 */

@ManagedBean(name="BeanPagos")

@SessionScoped
public class PagosBean implements Serializable{
    @ManagedProperty("#{loginBean}")
    private ShiroLoginBean shiroLoginBean;
    private Pago pagoselec;
    private final String base="applicationconfig.properties";
    
    private String IDpago;
    private String TipoPago;
    private String TipoTramite;

    
    
    public List<Pago> getPagos() throws PersistenceException {
        List<Pago> a=Servicios.getInstance(base).consultarPago();
        return a;

    }

    /**
     * @return the pagoselec
     */
    public Pago getPagoselec() {
        return pagoselec;
    }

    /**
     * @param pagoselec the pagoselec to set
     */
    public void setPagoselec(Pago pagoselec) {
        this.pagoselec = pagoselec;
    }
    
    public void setIdPago(String id){
        this.IDpago = id;
    }
    
    public String getIdPago(){
        return this.IDpago;
    }
    
    public void setTipoPago(String tipo){
        this.TipoPago = tipo;
    }
    
    public String getTipoPago(){
        return this.TipoPago;
    }
    
    public void setTipoTramite(String tipo){
        this.TipoTramite = tipo;
    }
    
    public String getTipoTramite(){
        return this.TipoTramite;
    }
    
    
    
    
    private UploadedFile file;
    private Image foto; 
    
    
    public UploadedFile getFile() {
        return file;
    }
    
    public void setFile( UploadedFile File) {
        this.file=File;
    }
 
    public void handleFileUpload(FileUploadEvent event) {

        Usuario u = getUsuario(getShiroLoginBean().getUsername());
        file = event.getFile();
        byte[] imagen=null;
        try {
            imagen = IOUtils.toByteArray(file.getInputstream());
        } catch (IOException ex) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
        }
        this.foto=new Image(imagen,String.valueOf(u.getCedula_numero()));
    }
    
    public void pagar() {
        Usuario u = getUsuario(getShiroLoginBean().getUsername());
        Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Pago p = new Pago(IDpago,TipoPago,String.valueOf(u.getCedula_numero()),"NoOk",u.getNombre(),fecha,TipoTramite,"","","");
        try {
            Servicios.getInstance(base).InsertarPago(p);
            Servicios.getInstance(base).saveImage(foto);
        } catch (PersistenceException ex) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
        }
    }
      
    
    /**
     * @return the shiroLoginBean
     */
    public ShiroLoginBean getShiroLoginBean() {
        return shiroLoginBean;
    }

    /**
     * @param shiroLoginBean the shiroLoginBean to set
     */
    public void setShiroLoginBean(ShiroLoginBean shiroLoginBean) {
        this.shiroLoginBean = shiroLoginBean;
    }
    
    public Usuario getUsuario(String username) {
        Usuario u = null;

        try {
            u = Servicios.getInstance(base).getUsuario(username);

        } catch (PersistenceException ex) {

        }
        return u;
    }
    
}
