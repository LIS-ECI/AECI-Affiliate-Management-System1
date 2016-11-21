/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import edu.eci.pdsw.sample.bean.security.ShiroLoginBean;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;



/**
 *
 * @author Grupo 3 Pdsw
 */
@ManagedBean(name="beanUsuario")

@SessionScoped
public class UsuarioBean  implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private StreamedContent streamedContent;
    
    private String base="applicationconfig.properties";

    @PostConstruct
    public void init() {
        try {
            //----------------------------------
            Document doc = new Document();

            OutputStream out = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(doc, out);

            doc.open();
            doc.add(new Paragraph("Hello World. ok........"));
            doc.close();
            out.close();

            InputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray());

            streamedContent = new DefaultStreamedContent(in, "application/pdf");
            //-------
            Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            byte[] b = (byte[]) session.get("reportBytes");
            if (b != null) {
                streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(b), "application/pdf");
            }
        } catch (Exception e) {
        }

    }

    //==================================================================
    public StreamedContent getStreamedContent() {
        if (FacesContext.getCurrentInstance().getRenderResponse()) {
            return new DefaultStreamedContent();
        } else {
            return streamedContent;
        }
    }

    //==================================================================
    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }
    
     @ManagedProperty(value="#{ShiroLoginBean}")
    private ShiroLoginBean neededBean;

    public ShiroLoginBean getNeededBean()
    {
    return neededBean;
    }

    public void setNeededBean(ShiroLoginBean neededBean)
    {
    this.neededBean = neededBean;
    }

   

    public Usuario getUsuario(){
        Usuario u=null;
        
        try {
            Servicios.getInstance(base).getUsuario(neededBean.getUsername());
        } catch (PersistenceException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    
   
}

