
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Certificado;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Grupo 3 Pdsw
 */
public class ServiciosDao extends Servicios {

    private SqlSession currentSession = null;
    private Date fecha = Date.valueOf(LocalDate.MAX);   
    Properties properties;
    DaoFactory daof;

    public ServiciosDao(String base) {

        try {
            properties = new PropertiesLoader().readProperties(base);
        } catch (IOException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        daof = DaoFactory.getInstance(properties);
        
    }

    @Override
    public List<Solicitud> consultarSolicitud() throws PersistenceException {
        
        List<Solicitud> a=null;
        try {
            daof.beginSession();
            a = daof.getDaoSolicitud().consultarSolicitud();
            daof.commitTransaction();
            daof.endSession();
            
        } catch (PersistenceException ex) {
            daof.endSession();
            throw new PersistenceException("No se efectuó la consulta de solicitudes",ex.getCause());     
        }
        return a;
    }
    
    @Override
    public List<Pago> consultarPago() throws PersistenceException {
        
        List<Pago> pagos=null;
        try {
            daof.beginSession();
            pagos = daof.getDaoSolicitud().consultarPago();
            daof.commitTransaction();
            daof.endSession();
            
        } catch (PersistenceException ex) {
            daof.endSession();
            throw new PersistenceException("No se efectuó la consulta de Pagos",ex.getCause());     
        }
        return pagos;
    }
    
    
    @Override
        public List<Usuario> consultarUsuarios() throws PersistenceException {
            List<Usuario> a=null;
            
            try {
                daof.beginSession();
                a = daof.getDaoSolicitud().consultarUsuarios();
         
                daof.commitTransaction();
                daof.endSession();
            } catch (PersistenceException ex) {
                daof.endSession();
                throw new PersistenceException("No se efectuó la consulta de usuarios",ex.getCause());
            }
            return a;

        }
   

    @Override
    public void enviarSolicitudEgresado(Egresado egr, Solicitud sol)  throws PersistenceException{


      try {
            daof.beginSession();
            daof.getDaoSolicitud().enviarSolicitudEgresado(egr, sol);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.rollbackTransaction();
            daof.endSession();
            throw new PersistenceException(ex.getMessage(),ex.getCause());
        }
      
        
        

    }

    @Override
    public Estudiante consultarEstudiante(long identificacion, String tipo_identificacion) throws PersistenceException {
        
        Estudiante e= null;
        try {
             daof.beginSession();
             e=daof.getDaoSolicitud().consultarEstudiante(identificacion, tipo_identificacion);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.endSession();
            throw new PersistenceException("No se pudo obtener el estudiante",ex.getCause());
        }
        
        return e;

    }

    @Override
    public Egresado consultarEgresado(long identificacion, String tipo_identificacion) throws PersistenceException{
        
        Egresado e=null;
        try {   
            daof.beginSession();
            e=daof.getDaoSolicitud().consultarEgresado(identificacion, tipo_identificacion);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.endSession();
            throw new PersistenceException("No se pudo obtener el egresado",ex.getCause());
        }
        
        return e;
    }

    @Override
    public void InsertarUsuario(Usuario u) throws PersistenceException{
        
        try {
            daof.beginSession();
            daof.getDaoSolicitud().InsertarUsuario(u);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.rollbackTransaction();
            daof.endSession();
            throw new PersistenceException("No se pudo guardar el usuario",ex.getCause());
        }
        
    }


    @Override
    public void ModificarSolicitud(String u, long ced, String tic) throws PersistenceException{
        try {
            daof.beginSession();
            daof.getDaoSolicitud().ModificarSolicitud(u,ced,tic);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.rollbackTransaction();
            daof.endSession();
            throw new PersistenceException("No se modificó la solicitud",ex.getCause());
        }
        
        
    }


    @Override
    public void enviarSolicitudEstudiante(Estudiante est, Solicitud sol) throws PersistenceException{
        try {
            daof.beginSession();
            daof.getDaoSolicitud().enviarSolicitudEstudiante(est, sol);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.rollbackTransaction();
            daof.endSession();
            throw new PersistenceException(ex.getMessage(),ex.getCause());
        }
    }

    @Override
    public Usuario getUsuario(String username) throws PersistenceException {
        Usuario u=null;
        try {
            daof.beginSession();
            u=daof.getDaoSolicitud().getUsuario(username);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.endSession();
            throw new PersistenceException("No se pudo obtener el usuario",ex.getCause());
        }
        return u;
    }

    @Override
    public int cantidadCertificados() throws PersistenceException {
        int cantidad=0;
        try {
            daof.beginSession();
            cantidad=daof.getDaoSolicitud().cantidadCertificados();
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.endSession();
            throw new PersistenceException("No se pudo obtener la cantidad de certificados",ex.getCause());
        }
        return cantidad;
    }

    @Override
    public void putCertificado(int codigo, String nombre,String valido) throws PersistenceException {
        try {
            daof.beginSession();
            daof.getDaoSolicitud().putCertificado(codigo,nombre,valido);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.rollbackTransaction();
            daof.endSession();
            throw new PersistenceException("No se pudo guardar el certificado",ex.getCause());
        }
    }

    @Override
    public Certificado getCertificado(int codigo) throws PersistenceException {
        Certificado c=null;
        try {
            daof.beginSession();
            c=daof.getDaoSolicitud().getCertificado(codigo);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.endSession();
            throw new PersistenceException("No se cargó el certificado",ex.getCause());
        }
        return c;
    
    }

    @Override
    public void invalidarCertificado(int codigo) throws PersistenceException {
        try {
            daof.beginSession();
            daof.getDaoSolicitud().invalidarCertificado(codigo);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            daof.rollbackTransaction();
            daof.endSession();
            throw new PersistenceException("No se llevó a cabo invalidar certificado",ex.getCause());
            
        }
    }

 


class PropertiesLoader {

    public Properties readProperties(String fileName) throws IOException {
        InputStream input = null;
        Properties properties = new Properties();
        input = this.getClass().getClassLoader().getResourceAsStream(fileName);
        properties.load(input);
        return properties;
    }
}
}
