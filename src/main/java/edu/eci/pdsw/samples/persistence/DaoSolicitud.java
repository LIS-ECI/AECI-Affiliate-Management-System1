/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence;


import edu.eci.pdsw.samples.entities.Certificado;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Image;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.Date;
import java.util.List;
/**
 *
 * @author 2103216
 */
public interface DaoSolicitud {
    
    public List<Solicitud> consultarSolicitud() throws PersistenceException;
    
    public List<Pago> consultarPago() throws PersistenceException;

    public List<Usuario> consultarUsuarios() throws PersistenceException;

    public Estudiante consultarEstudiante(long identificacion, String tipo_identificacion) throws PersistenceException;

    public void InsertarUsuario(Usuario u) throws PersistenceException;
    
    public void ModificarSolicitud(String u, long ced, String tic) throws PersistenceException;
        
    public void enviarSolicitudEstudiante(Estudiante est, Solicitud sol) throws PersistenceException;
    
    public void enviarSolicitudEgresado(Egresado egr, Solicitud sol) throws PersistenceException;
    
    public Egresado consultarEgresado(long identificacion, String tipo_identificacion)throws PersistenceException; 

    public Usuario getUsuario(String username) throws PersistenceException;

    public int cantidadCertificados() throws PersistenceException;

    public void putCertificado(int codigo, String nombre,String valido) throws PersistenceException;

    public Certificado getCertificado(int codigo) throws PersistenceException;

    public void invalidarCertificado(int codigo) throws PersistenceException;

    public void insertarPago(Pago p) throws PersistenceException;
    
    public Image loadImage(String id); 
    
    public void saveImage(String name, byte[] image);

    public void validarPago(String numFac) throws PersistenceException;

    public void validarUsuario(String nombre, Date fecha2) throws PersistenceException;


}
    
    
    