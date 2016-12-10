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
    
    
    
}
