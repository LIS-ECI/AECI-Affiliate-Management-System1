/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Grupo 3 Pdsw
 */

@ManagedBean(name="BeanReporteAfiliaciones")
@SessionScoped



public class ReportesBean implements Serializable {
    
    private long numero_identificacion;
    private String base="applicationconfig.properties";
    private List<Solicitud> afiliaciones;
    private Date fecha = Date.valueOf(LocalDate.MAX);   
    private String tipo_identificacion;
    private String nombre;
    private String direccion;
    private String correoElectronico;
    
    
    
    public ReportesBean() throws PersistenceException{
      List<Solicitud> a = getAfiliaciones();
    }
    
    
    public List<Solicitud> getAfiliaciones() throws PersistenceException {
        List<Solicitud> a =Servicios.getInstance(base).consultarSolicitud();
        for(int i=0; i < a.size();i++){
            if(a.get(i).getFechaAfiliacion().getDay() - fecha.getDay() < 30 ){
                afiliaciones.add(a.get(i));
            }
        }
        return afiliaciones;
    }
    
    public Estudiante getEstudiante() throws PersistenceException{
        Estudiante est = Servicios.getInstance(base).consultarEstudiante(numero_identificacion, tipo_identificacion);
        return est;
    }
    
    public Egresado getEgresado() throws PersistenceException{
        Egresado egre = Servicios.getInstance(base).consultarEgresado(numero_identificacion, tipo_identificacion);
        return egre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String name){
        nombre = name;
    }
    
    public long getDocIdentificacion(){
        return this.numero_identificacion;
    }
    
    public void setDocIdentificacion(long in){
        numero_identificacion = in;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
    
    public void setDireccion(String dir){
        direccion =dir;
    }
    
    public String getCorreoElectronico(){
        return this.correoElectronico;
    }
    
    public void getCorreoElectronico(String coel){
        correoElectronico=coel;
    }
    
    
}
