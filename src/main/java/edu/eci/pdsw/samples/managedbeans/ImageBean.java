/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;


import edu.eci.pdsw.samples.entities.Image;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author 2107803
 */
@ManagedBean(name = "imagen")
@SessionScoped
public class ImageBean implements Serializable{
    
    private Servicios serv = Servicios.getInstance("applicationconfig.properties");
    private String nombre;
    private Image ima;

    public Servicios getServ() {
        return serv;
    }

    public void setServ(Servicios serv) {
        this.serv = serv;
    }

    public Image getIma() {
        return ima;
    }

    public void setIma(Image ima) {
        this.ima = ima;
    }
    private UploadedFile file;
    
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
    

 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        file = event.getFile();
        
    }
     
    public void upload() throws IOException {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            byte[] img = IOUtils.toByteArray(file.getInputstream());
        ima= new Image(img,"prueba");
        }
        
    }
    
}