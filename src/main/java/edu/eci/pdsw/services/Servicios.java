/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.services;

import edu.eci.pdsw.entities.Solicitud;
import java.util.List;
import java.util.Set;



/**
 *
 * @author 2107641
 */
public abstract class Servicios {
    
    private static Servicios instance=new ServiciosDao();
    
    
    protected Servicios(){        

    }
    
    public static Servicios getInstance() throws RuntimeException{        
        return instance;
    }


    /**
     * Consulta todas las Solicitudes registradas
     * @return el conjunto de las entradas al foro disponibles
     * @throws ExcepcionServiciosForos si se presento un error de persistencia
     */
    public abstract List<Solicitud> consultarSolicitud();


}
