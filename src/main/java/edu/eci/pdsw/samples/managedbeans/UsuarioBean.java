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
import static edu.eci.pdsw.samples.managedbeans.UsuarioBean.getManagedBean;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Grupo 3 Pdsw
 */
@ManagedBean(name = "beanUsuario")
@RequestScoped
public class UsuarioBean {

    private static final long serialVersionUID = 1L;

    private StreamedContent streamedContent;

    private String base = "applicationconfig.properties";

    //==================================================================
    public StreamedContent getStreamedContent() {
        //1 sacar el usuaui
        //construir texto
        try {
            //----------------------------------
            Document doc = new Document();
            //ShiroLoginBean bean = (ShiroLoginBean) getManagedBean("loginBean");
            //System.out.println(bean.getUsername()+"-------------------");
            OutputStream out = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(doc, out);
            Usuario u = getUsuario("CC", 565265);
            Egresado egr = null;
            Estudiante est = null;

            doc.open();
            Image imagen = Image.getInstance("https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAAgDAAAAJDk3ZGM0MDU2LWRhNWEtNDMwNi1iOTNjLTllMDY1OWNkMjk3ZQ.png");
            imagen.scalePercent(50);
            imagen.setAbsolutePosition(240f, 710f);
            doc.add(imagen);
            String text = "";
            doc.add(new Paragraph("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "CERTIFICA QUE:"));
            if (u.getTipo().equals("Estudiante")) {
                if (est.getGenero().equals("Masculino")) {
                    text += "El Señor";
                } else {
                    text += "La Señora";
                }
                text += est.getNombre().toUpperCase() + " " + est.getApellido().toUpperCase();
                if (est.getGenero().equals("Masculino")) {
                    text += " identificado ";
                } else {
                    text += " identificada ";
                }
                text += "con " + est.getTipo_identificacion() + " " + est.getNumero_identificacion() + " " + "se encuentra";
                if (est.getGenero().equals("Masculino")) {
                    text += " afiliado ";
                } else {
                    text += " afiliada ";
                }
                text += "a la asociación de egresado de la Escuela Colombiana de Ingeniería Julio Garavito en condición de estudiante, cursando "+ est.getSemestre() + "semestre cuya fecha de vigencia es desde " ;
                text += u.getFechaInicio()+" hasta "+u.getFechaFin()+", cuya afiliación es gratuita";
     
            } else {
                
                if (egr.getGenero().equals("Masculino")) {
                    text += "El Señor";
                } else {
                    text += "La Señora";
                }
                text += egr.getNombre().toUpperCase() + " " + egr.getApellido().toUpperCase();
                if (egr.getGenero().equals("Masculino")) {
                    text += " identificado ";
                } else {
                    text += " identificada ";
                }
                text += "con " + egr.getCedula_tipo()+ " " + egr.getCedula_tipo()+ " " + "se encuentra";
                if (egr.getGenero().equals("Masculino")) {
                    text += " afiliado ";
                } else {
                    text += " afiliada ";
                }
                text += "a la asociación de egresado de la Escuela Colombiana de Ingeniería Julio Garavito en condición de egresado, cuyo periodo de grafo fue "+ egr.getFecha_grado()+"-"+ String.valueOf(egr.getPeriodo_grado()) + " cuya fecha de vigencia es desde " ;
                text += u.getFechaInicio()+" hasta "+u.getFechaFin()+", cuyo ultimo pago se dió el día ";
                List<Pago> p = Servicios.getInstance(base).getPagos(u.getNombre());
                text+=p.get(p.size()-1);
    
                
            }
            
            text += "\n"+"La presente certificacion  se expide a solicitud del(de la) interesado(a) en Bogotá para QUIEN INTERESE a la fecha de ";
                Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
                text+=fecha+"."+"\n"+"Cordialmente,"+"\n";
                text+="Asociación de Egresados de la Escuela Colombiana De Ingeniería Julio Garavito";
            

            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph(text));
            
            
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

    public Usuario getUsuario(String tipId, long identificacion) {
        Usuario u = null;

        try {
            Servicios.getInstance(base).getUsuario("");
        } catch (PersistenceException ex) {
        }
        return u;
    }

    public static Object getManagedBean(final String beanName) {
        FacesContext fc = FacesContext.getCurrentInstance();

        Object bean = null;
        try {
            ELContext elContext = fc.getELContext();
            bean = elContext.getELResolver().getValue(elContext, null, beanName);
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);

        }

        if (bean == null) {
            throw new FacesException("Managed bean with name '" + beanName + "' was not found. Check your faces-config.xml or @ManagedBean annotation.");

        }

        return bean;
    }

}
