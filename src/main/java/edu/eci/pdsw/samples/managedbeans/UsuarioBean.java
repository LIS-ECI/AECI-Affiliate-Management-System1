/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import com.itextpdf.text.Document;

import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import edu.eci.pdsw.sample.bean.security.ShiroLoginBean;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.awt.Color;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Grupo 3 Pdsw
 */
@ManagedBean(name = "beanUsuario")
@SessionScoped
public class UsuarioBean implements Serializable{
    @ManagedProperty("#{loginBean}")
    private ShiroLoginBean shiroLoginBean;

    private Egresado egr ;
    private Estudiante est ;
    private static final long serialVersionUID = 1L;
    private Usuario u;
    private String nombre;
    
    private String estadoAfili;

    private StreamedContent streamedContent;

    private String base = "applicationconfig.properties";
    
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 15,
                        Font.BOLD);
    
    private void facesMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }
    
    
    public StreamedContent getStreamedContent() {
        
        try {
            //----------------------------------
            Document doc = new Document();

            int codigo = Servicios.getInstance(base).cantidadCertificados();
            OutputStream out = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(doc, out);
            doc.open();
            Image imagen = Image.getInstance("http://static.wixstatic.com/media/926fce_4cc266e8ca394a5097cc08320dc5ff73.jpg_256");
            imagen.scalePercent(32);
            imagen.setAbsolutePosition(187f, 700f);
            doc.add(imagen);
            String text = "";
            doc.add(new Paragraph("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "                                      Certificado de Afiliación AECI" + "\n"+"\n"+"\n",smallBold));
            doc.add(new Paragraph("La Asociación de Egresados de la Escuela Colombiana de Ingeniería Julio Garavito AECI, con Nit. 830.031.137- 4, certifica que "));
            if (u.getTipo().equals("Estudiante")) {
                if (est.getGenero().equals("Masculino")) {
                    text += "El Estudiante de "+est.getCarrera();
                    
                } else {
                    text += "La Estudiante de "+est.getCarrera();
                }
                text += " "+est.getNombre().toUpperCase() + " " + est.getApellido().toUpperCase();
                if (est.getGenero().equals("Masculino")) {
                    text += ", identificado ";
                } else {
                    text += ", identificada ";
                }
                text += "con " + est.getTipo_identificacion() + " " + est.getNumero_identificacion() + " " + "se encuentra";
                if (est.getGenero().equals("Masculino")) {
                    text += " afiliado ";
                } else {
                    text += " afiliada ";
                }
                text += "a la Asociación de Egresados de la Escuela Colombiana de Ingeniería Julio Garavito en condición de estudiante, cursando " + est.getSemestre() + "o. semestre.";
                doc.add(new Paragraph(text));
                doc.add(new Paragraph("  Vigencia: "+ "\n" ,smallBold));
                text="";
                
                
                Date fecha11 = new java.sql.Date(u.getFechaInicio().getTime());
                Date fecha22 = new java.sql.Date(u.getFechaFin().getTime());

                text += "   *Desde " + fecha11 + "\n" + "    *Hasta " + fecha22 + "\n" +"Es de anotar que la afiliación estudiantil es gratuita.";

            } else {

                if (egr.getGenero().equals("Masculino")) {
                    text += "El Señor ";
                } else {
                    text += "La Señora ";
                }
                text += egr.getNombre().toUpperCase() + " " + egr.getApellido().toUpperCase();
                if (egr.getGenero().equals("Masculino")) {
                    text += " identificado ";
                } else {
                    text += " identificada ";
                }
                text += "con " + egr.getNumero_identificacion() + " " + egr.getTipo_identificacion() + " " + "se encuentra";
                if (egr.getGenero().equals("Masculino")) {
                    text += " afiliado ";
                } else {
                    text += " afiliada ";
                }
                text += "a la Asociación de Egresados de la Escuela Colombiana de Ingeniería Julio Garavito en condición de egresado, cuyo periodo de grafo fue " + egr.getFecha_grado() + "-" + String.valueOf(egr.getPeriodo_grado()) + " cuya fecha de vigencia es desde ";
                Date fecha11 = new java.sql.Date(u.getFechaInicio().getTime());
                Date fecha22 = new java.sql.Date(u.getFechaFin().getTime());
                text += fecha11 + " hasta " + fecha22 + ", cuyo ultimo pago se dió el día ";

                text += u.getPagos().get(u.getPagos().size() - 1);

            }

            text += "\n" +"\n" + "La presente certificacion  se expide a solicitud del(de la) interesado(a) en Bogotá para QUIEN INTERESE a la fecha de ";
            Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
            text += fecha + "." + "\n" + "Cordialmente," + "\n" + "\n" + "\n";
            text += "Asociación de Egresados de la "
                    + "\n" + "Escuela Colombiana De Ingeniería Julio Garavito";

            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph(text));
            doc.add(new Paragraph("\n" + "\n" + "\n" + "\n" + "\n" + "código de validación: " + codigo));

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
            Servicios.getInstance(base).putCertificado(codigo, u.getNombre(), "Ok");
        } catch (Exception e) {
        }
        
        
        if (FacesContext.getCurrentInstance().getRenderResponse()) {
            return new DefaultStreamedContent();
        } else {
            
            return streamedContent;
            
        }

    }

    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }

    public Usuario getUsuario(String username) {
        Usuario u = null;

        try {
            u = Servicios.getInstance(base).getUsuario(username);

        } catch (PersistenceException ex) {

        }
        return u;
    }

    /**
     * @return the pagina
     */
    public String pagina() {
        String pagina;
        Usuario u = getUsuario(getShiroLoginBean().getUsername());
        Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        if (u.getFechaFin().compareTo(fecha)<0){
            facesMessage("Se requiere renovar la afiliación con el correspondiente pago No se puede generar certificado.");
            pagina="PrincipalUsuario";
        }
        else{
            pagina="certificado";
        }
        return pagina;
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

    /**
     * @return the nombre
     */
    public String getNombre() throws PersistenceException {
        u = getUsuario(getShiroLoginBean().getUsername());
        String gen="";
        if (u.getTipo().equals("Estudiante")) {
                est = Servicios.getInstance(base).consultarEstudiante(u.getCedula_numero(), u.getCedula_tipo());
                nombre="BIENVENID";
                if (est.getGenero().equals("Masculino")){
                    gen="O";
                }
                else{
                    gen="A";
                }
                nombre+=gen+"\n"+est.getNombre()+" "+est.getApellido();
            } else {
                egr = Servicios.getInstance(base).consultarEgresado(u.getCedula_numero(), u.getCedula_tipo());
                nombre="BIENVENID";
                if (egr.getGenero().equals("Masculino")){
                    gen="O";
                }
                else{
                    gen="A";
                }
                nombre+=gen+"\n"+egr.getNombre()+" "+egr.getApellido();
            }
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estadoAfili
     */
    public String getEstadoAfili() {
        Usuario u = getUsuario(getShiroLoginBean().getUsername());
        Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        if (u.getFechaFin().compareTo(fecha)<0){
            estadoAfili="AFILIADO INACTIVO - PENDIENTE PAGO CUOTA AFILIACIÓN"     ;       
        }
        else{
            estadoAfili="AFILIADO ACTIVO";
        }
       
        return estadoAfili;
    }
    

    /**
     * @param estadoAfili the estadoAfili to set
     */
    public void setEstadoAfili(String estadoAfili) {
        this.estadoAfili = estadoAfili;
    }

    
    /**
     * 
     * @return retorna el usuario con el que se ingreso al afiliado 
     */
    public Usuario getUsu(){
        u = getUsuario(getShiroLoginBean().getUsername());
        return u;
    }
    
    /**
     * @return the nombre
     */
    public String getNombreUsu() throws PersistenceException {
        u = getUsuario(getShiroLoginBean().getUsername());
        if (u.getTipo().equals("Estudiante")) {
                est = Servicios.getInstance(base).consultarEstudiante(u.getCedula_numero(), u.getCedula_tipo());
                nombre=est.getNombre()+" "+est.getApellido();
            } else {
                egr = Servicios.getInstance(base).consultarEgresado(u.getCedula_numero(), u.getCedula_tipo());
                nombre=egr.getNombre()+" "+egr.getApellido();
            }
        return nombre;
    }

}