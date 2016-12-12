/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.CorreoPersonal;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServicios;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 3 Pdsw
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@ManagedBean(name="beanEgresado")

@SessionScoped
public class EgresadoBean  implements Serializable{
    private long cedula;
    private String tipo_identificacion;
    private String nombre;
    private int fecha_grado=2015;
    private int periodo_grado=1;
    private String cargo;
    private String carrera; 
    private String direccion_vivienda;
    private String nombreEmpresa;
    private String direccion_empresa;
    private int telefono_oficina;
    private int telefono_fijo;
    private long celular;
    private String email;
    private String base="applicationconfig.properties";
    //base de datos
     private String genero;
     private String apellido;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
    
    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int  getFecha_grado() {
        return fecha_grado;
    }

    public void setFecha_grado(int fecha_grado) {
        this.fecha_grado = fecha_grado;
    }

    public int getPeriodo_grado() {
        return periodo_grado;
    }

    public void setPeriodo_grado(int periodo_grado) {
        this.periodo_grado = periodo_grado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDireccion_vivienda() {
        return direccion_vivienda;
    }

    public void setDireccion_vivienda(String direccion_vivienda) {
        this.direccion_vivienda = direccion_vivienda;
    }


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public int getTelefono_oficina() {
        return telefono_oficina;
    }

    public void setTelefono_oficina(int telefono_oficina) {
        this.telefono_oficina = telefono_oficina;
    }

    public int getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(int telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }
    
     private void facesMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }
    
    /**
    * Metodo enviarSolicitud egresado
    * 
     * 
    */
    public void enviarSolicitud ()  {
        if( this.nombreEmpresa.equals("")){
            this.nombreEmpresa="No Disponible";
        }
        if( this.direccion_empresa.equals("")){
            this.direccion_empresa="No Disponible";
        }
        if( this.cargo.equals("")){
            this.cargo="No Disponible";
        }
        if( this.direccion_vivienda.equals("")){
            this.direccion_vivienda="No Disponible";
        }
        CorreoPersonal cp = new CorreoPersonal(email,cedula,tipo_identificacion);
        List<CorreoPersonal> lisc = new ArrayList<>();
        lisc.add(cp);
        Egresado egr = new Egresado(genero,apellido,cedula, tipo_identificacion, nombre, fecha_grado, periodo_grado, cargo, carrera, direccion_vivienda, nombreEmpresa, direccion_empresa, telefono_oficina, telefono_fijo, celular, lisc);
        java.sql.Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Solicitud sol = new Solicitud(fecha,egr.getNumero_identificacion(), egr.getTipo_identificacion(),"Egresado","Pend");
        
        try {
            Egresado e = Servicios.getInstance(base).consultarEgresado(cedula, tipo_identificacion);
            if (e != null) {
                facesMessage("Ya existe una solicitud con el numero de identificación ingresado");
            }
            else{
                try {
                    Servicios.getInstance(base).enviarSolicitudEgresado(egr,sol);
                    this.nombreEmpresa="";
                this.direccion_empresa="";
                this.cargo="";
                this.nombre="";
                this.cedula=0;
                this.email="";
                this.direccion_vivienda="";
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Su Solicitud Ha Sido Enviada Correctamente, Pronto Llegará un Mensaje a su Correo Indicándole los pasos a seguir", null));
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

                
                } catch (PersistenceException ex) {
                    facesMessage(ex.getMessage());
                } catch (IOException ex) {
                    facesMessage(ex.getMessage());
                }
                
            }
        } catch (PersistenceException ex) {
            facesMessage("Ocurrió un error al consultar la base de datos, por favor inténtelo nuevamente");
        }

        
        
        
        
    }
}
