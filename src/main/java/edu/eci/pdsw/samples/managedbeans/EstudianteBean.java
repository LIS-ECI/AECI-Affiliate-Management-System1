/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.services.Servicios;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;


/**
 *
 * @author 21
 */
@ManagedBean(name="beanEstudiante")

@SessionScoped
public class EstudianteBean  implements Serializable{
    
    private long numero_identificacion;
    private String tipo_identificacion;
    private int codigo;
    private String nombre;
    private int semestre=8;
    private int telefono_fijo;
    private long celular=0;
    private String direccion;
    private String carrera;
    
    
    
    private String correo;
    private String enter;

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
    
     public void enviarSolicitud (){
        Estudiante est = new Estudiante(codigo, numero_identificacion,  nombre, semestre, tipo_identificacion, carrera, telefono_fijo, celular,  correo, direccion );
        Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Solicitud sol = new Solicitud(fecha,(int)est.getNumero_identificacion(), est.getTipo_identificacion(),"Estudiante","Pend");
        Servicios.getInstance().enviarSolicitudEstudiante(est,sol);

    }

}