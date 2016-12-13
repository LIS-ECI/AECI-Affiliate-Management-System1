/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.sample.bean.security.ShiroLoginBean;
import edu.eci.pdsw.samples.entities.Image;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;




/**
 *
 * @author User
 */

@ManagedBean(name="beanPagos")

@SessionScoped
public class PagosBean implements Serializable{
    @ManagedProperty("#{loginBean}")
    private ShiroLoginBean shiroLoginBean;
    private Pago pagoselec;
    private final String base="applicationconfig.properties";
    
    private String IDpago;
    private String TipoPago="Consignacion";
    private String TipoTramite;
    
    private long codigoTransacción;

    public long getCodigoTransacción() {
        return codigoTransacción;
    }

    public void setCodigoTransacción(long codigoTransacción) {
        this.codigoTransacción = codigoTransacción;
    }

    private Date fecha;
      private Image ima;

    public Image getIma() {
        return ima;
    }

    public void setIma(Image ima) {
        this.ima = ima;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    public List<Pago> getPagos() throws PersistenceException {
        List<Pago> a=Servicios.getInstance(base).consultarPago();
        return a;

    }
    
    public StreamedContent getImage(){
        if (!(pagoselec == null)){
        try{
            return new DefaultStreamedContent(new ByteArrayInputStream(Servicios.getInstance(base).loadImagenByNombre(String.valueOf(pagoselec.getIdentificacionPersonal())).getImg())); 
        }catch(Exception ex){
            System.out.println("error al cargar la imagen "+ex.toString());
            return null;
        }
        }
        else{
            return null;
        }
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
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));

        }
        return u;
    }
    
    public void aprobar(){
        try {
            Servicios.getInstance(base).validarPago(pagoselec.getId_pago());
        } catch (PersistenceException ex) {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
        }
        Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Calendar calendar = Calendar.getInstance();	
        calendar.setTime(fecha); 	
        calendar.add(Calendar.DAY_OF_YEAR, 183); 		
        Date fecha2=  new java.sql.Date(calendar.getTime().getTime());
        try {
            Servicios.getInstance(base).validarUsuario(pagoselec.getUsuario_nombre(),fecha2);
        } catch (PersistenceException ex) {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ex.getMessage(), null));
        }
    
    }
    
}
