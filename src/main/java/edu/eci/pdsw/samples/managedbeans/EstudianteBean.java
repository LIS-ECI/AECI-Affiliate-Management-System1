/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.CorreoPersonal;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Grupo 3 Pdsw
 */
@ManagedBean(name = "beanEstudiante")

@SessionScoped
public class EstudianteBean implements Serializable {

    private long numero_identificacion;
    private String tipo_identificacion;
    private int codigo;
    private String nombre;
    private int semestre = 8;
    private int telefono_fijo;
    private long celular = 0;
    private String direccion;
    private String carrera = "Ingenieria Civil";
    private int min = 8;
    private int max = 10;
    private String correo;
    private String enter;
    private String email_institucional;
    private String base = "applicationconfig.properties";
    private String genero;
    private String apellido;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    private void facesMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getMin() {
        if (carrera.equals("Matematicas") | carrera.equals("Administracion") | carrera.equals("Economia") | carrera.equals("Ingenieria Biomedica")) {
            this.min = 7;
        } else {
            this.min = 8;
        }
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        if (carrera.equals("Matematicas") | carrera.equals("Administracion") | carrera.equals("Economia") | carrera.equals("Ingenieria Biomedica")) {
            this.max = 9;
        } else {
            this.max = 10;
        }
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getEnter() {
        return enter;
    }

    public void setEnter(String enter) {
        this.enter = enter;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
    private int documento;

    public int getTelefono_fijo() {
        return telefono_fijo;
    }

    public long getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public long getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(long numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setTelefono_fijo(int telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    /**
     * Metodo enviarSolicitudEstudiante
     */
    public void enviarSolicitud() throws IOException {
        if (this.direccion.equals("")) {
            this.direccion = "No Disponible";
        }
        CorreoPersonal cp = new CorreoPersonal(correo, numero_identificacion, tipo_identificacion);
        CorreoPersonal cp2 = new CorreoPersonal(email_institucional, numero_identificacion, tipo_identificacion);
        List<CorreoPersonal> lisc = new ArrayList<>();
        lisc.add(cp);
        lisc.add(cp2);
        Estudiante est = new Estudiante(genero, apellido, codigo, numero_identificacion, nombre, semestre, tipo_identificacion, carrera, telefono_fijo, celular, lisc, direccion);
        Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Solicitud sol = new Solicitud((java.sql.Date) fecha, (int) est.getNumero_identificacion(), est.getTipo_identificacion(), "Estudiante", "Pend");
        try {
            Estudiante e = Servicios.getInstance(base).consultarEstudiante(numero_identificacion, tipo_identificacion);
            if (e != null) {
                facesMessage("Ya existe una solicitud con el numero de identificación ingresado");
                
            }
            else {
                try {
                    Servicios.getInstance(base).enviarSolicitudEstudiante(est, sol);
                    this.carrera = "";
                this.celular = 0;
                this.codigo = 0;
                this.correo = "";
                this.direccion = "";
                this.nombre = "";
                this.numero_identificacion = 0;
                this.telefono_fijo = 0;
                this.carrera = "Ingenieria Civil";
                
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getFlash().setKeepMessages(true);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Su Solicitud Ha Sido Enviada Correctamente, Pronto Llegará un Mensaje a su Correo Indicándole los pasos a seguir", null));

                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

                

                } 
                catch (PersistenceException ex) {
                    facesMessage(ex.getMessage());
                }
                  }
        }
    catch (PersistenceException ex){ 
            facesMessage("Ocurrió un error al consultar la base de datos, por favor inténtelo nuevamente");
    }
    

}

public String getEmail_institucional() {
        return email_institucional;
    }

    public void setEmail_institucional(String email_institucional) {
        this.email_institucional = email_institucional;
    }

}
