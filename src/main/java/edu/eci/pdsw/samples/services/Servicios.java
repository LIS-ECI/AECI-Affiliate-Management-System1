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
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.util.List;
import java.util.Set;



/**
 *
 * @author Grupo 3 Pdsw
 */
public abstract class Servicios {
    private static Servicios instance;
    
    protected Servicios(){        

    }
    
    public static Servicios getInstance(String base) throws RuntimeException{    
        instance = new ServiciosDao(base);        
        return instance;
    }

    /**
    * Metodo consultar Estudiante
     * @param identificacion
     * @param tipo_identificacion
     * @return Estudiante con la identificacion ingresada por parametro
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException
    */
    public abstract Estudiante consultarEstudiante(long identificacion, String tipo_identificacion) throws PersistenceException;

    /**
    * Metodo consultar Egresado
     * @param identificacion
     * @param tipo_identificacion
     * @return 
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException 
    */
    public abstract Egresado consultarEgresado(long identificacion, String tipo_identificacion) throws PersistenceException;

    /**
    * Metodo consultar Solicitud
     * @return 
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException 
    */
    public abstract List<Solicitud> consultarSolicitud() throws PersistenceException;

    /**
    * Metodo enviar Solicitud Estudiante
     * @param est
     * @param sol
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException
    */
    public abstract void enviarSolicitudEstudiante(Estudiante est,Solicitud sol) throws PersistenceException;

    /**
    * Metodo enviar Solicitud Egresado
     * @param egr
     * @param sol
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException
    */
    public abstract void enviarSolicitudEgresado(Egresado egr, Solicitud sol) throws PersistenceException;

    /**
    * Metodo Insertar Usuario
     * @param u
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException
    */
    public abstract void InsertarUsuario(Usuario u) throws PersistenceException;

    /**
    * Metodo Modificar Solicitud
     * @param u
     * @param ced
     * @param tic
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException
    */
    public abstract void ModificarSolicitud(String u, long ced, String tic) throws PersistenceException;

    /**
    * Metodo obtener usuario
     * 
     * @param username
     * @return usuario con el username 
     * 
     * @throws edu.eci.pdsw.samples.persistence.PersistenceException
    */
    public abstract Usuario getUsuario(String username) throws PersistenceException;

}
