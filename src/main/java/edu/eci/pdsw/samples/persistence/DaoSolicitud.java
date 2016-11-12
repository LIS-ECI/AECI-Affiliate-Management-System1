/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence;


import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.List;
/**
 *
 * @author 2103216
 */
public interface DaoSolicitud {
    
    public List<Solicitud> consultarSolicitud() ;

    public Estudiante consultarEstudiante(long identificacion, String tipo_identificacion);

    public void InsertarUsuario(Usuario u) ;
    
    public void ModificarSolicitud(String u, long ced, String tic);
}
    
    
    