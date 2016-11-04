/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.services;


import edu.eci.pdsw.entities.Solicitud;
import edu.eci.pdsw.persistence.DaoFactory;
import java.util.List;
import java.util.Properties;


/**
 *
 * @author 2106088
 */
public class ServiciosDao extends Servicios{

    //private SqlSession currentSession=null;
    Properties properties;
    DaoFactory daof;

    public ServiciosDao(){
        
    }

    @Override
    public List<Solicitud> consultarSolicitud() {
        List<Solicitud> Solicitudes=null;
        //Solicitudes = daof.getDaoSolicitud().loadAll();
        return Solicitudes;
    }
}

