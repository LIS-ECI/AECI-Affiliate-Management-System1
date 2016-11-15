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
 * @author 2107641
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
     * Dado un identificador, consulta una entrada a foro especifica
     * @param id identificador de la entrada al foro
     * @return la entrada al foro
     * @throws ExcepcionServiciosForos si el identificador no corresponde a 
     * un entrada a foro existente
     */
    public abstract Estudiante consultarEstudiante(long identificacion, String tipo_identificacion) throws PersistenceException;

    public abstract Egresado consultarEgresado(long identificacion, String tipo_identificacion) throws PersistenceException;

    public abstract List<Solicitud> consultarSolicitud() throws PersistenceException;

    public abstract void enviarSolicitudEstudiante(Estudiante est,Solicitud sol) throws PersistenceException;

    public abstract void enviarSolicitudEgresado(Egresado egr, Solicitud sol) throws PersistenceException;

    public abstract void InsertarUsuario(Usuario u) throws PersistenceException;

    public abstract void ModificarSolicitud(String u, long ced, String tic) throws PersistenceException;

}
