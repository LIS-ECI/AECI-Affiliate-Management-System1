/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
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
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
        
    }

   

    @Override
    public void enviarSolicitudEgresado(Egresado egr, Solicitud sol)  throws PersistenceException{

      try {
            daof.beginSession();
            daof.getDaoSolicitud().enviarSolicitudEgresado(egr, sol);
            daof.commitTransaction();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }

    @Override
    public Estudiante consultarEstudiante(long identificacion, String tipo_identificacion) throws PersistenceException {
        
        Estudiante e= null;
        try {
             daof.beginSession();
             e=daof.getDaoSolicitud().consultarEstudiante(identificacion, tipo_identificacion);
            daof.commitTransaction();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }

    @Override
    public void InsertarUsuario(Usuario u) throws PersistenceException{
        
        try {
            daof.beginSession();
            daof.getDaoSolicitud().InsertarUsuario(u);
            daof.commitTransaction();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    @Override
    public void ModificarSolicitud(String u, long ced, String tic) throws PersistenceException{
        try {
            daof.beginSession();
            daof.getDaoSolicitud().ModificarSolicitud(u,ced,tic);
            daof.commitTransaction();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }


    @Override
    public void enviarSolicitudEstudiante(Estudiante est, Solicitud sol) throws PersistenceException{
        try {
            daof.beginSession();
            daof.getDaoSolicitud().enviarSolicitudEstudiante(est, sol);
            daof.commitTransaction();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario getUsuario(String username) throws PersistenceException {
        Usuario u=null;
        try {
            daof.beginSession();
            u=daof.getDaoSolicitud().getUsuario(username);
            daof.commitTransaction();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
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