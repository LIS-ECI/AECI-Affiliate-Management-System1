/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;


import edu.eci.pdsw.samples.services.Servicios;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author 2107803
 */
@ManagedBean(name = "imagen")
@SessionScoped
public class ImageBean implements Serializable{
    
    private Servicios serv = Servicios.getInstance("applicationconfig.properties");
    private String nombre;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public StreamedContent getImage(){
        try{
            return new DefaultStreamedContent(new ByteArrayInputStream(serv.loadImagenByNombre(nombre).getImg()));
        }catch(Exception ex){
            System.out.println("error al cargar la imagen "+ex.toString());
            return null;
        }
    }
}