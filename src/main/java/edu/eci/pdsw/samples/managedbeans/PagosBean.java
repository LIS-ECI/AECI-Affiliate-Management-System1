/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */

@ManagedBean(name="BeanPagos")

@SessionScoped
public class PagosBean implements Serializable{
    
    
    private Pago pagoselec;
    private String base="applicationconfig.properties";
    private byte[] foto; 
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
    
    public void setFoto(byte[] foto){
        this.foto = foto;
    }
    
    public byte[] getFoto(){
        return this.foto;
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
}
