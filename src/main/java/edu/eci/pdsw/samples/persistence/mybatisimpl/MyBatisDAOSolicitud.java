
/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.persistence.mybatisimpl;

import edu.eci.pdsw.samples.entities.Certificado;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;

import org.apache.ibatis.session.SqlSession;
import edu.eci.pdsw.samples.persistence.DaoSolicitud;
import edu.eci.pdsw.samples.persistence.PersistenceException;

import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.SolicitudMapper;
import java.util.List;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.SimpleByteSource;

/**
 *
 * @author hcadavid
 */
public class MyBatisDAOSolicitud implements DaoSolicitud {

    private SqlSession currentSession = null;

    public MyBatisDAOSolicitud(SqlSession session) {
        this.currentSession = session;
    }

    @Override
    public List<Solicitud> consultarSolicitud() throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        return somap.consultarSolicitud();
    }
    
    @Override
    public List<Usuario> consultarUsuarios() throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        
        return somap.consultarAfiliacion();
    }

   
    @Override
    public Estudiante consultarEstudiante(long identificacion, String tipo_identificacion) throws PersistenceException{
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        return somap.consultarEstudiante(identificacion,tipo_identificacion);
    }

    @Override
    public void InsertarUsuario(Usuario u) throws PersistenceException{
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        u.setClave(MyBatisDAOSolicitud.generateHash(u.getClave()));
        somap.InsertarUsuario(u);
    }

    @Override
    public void ModificarSolicitud(String u, long ced, String tic) throws PersistenceException{
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        somap.ModificarSolicitud(u,ced,tic);
    }

    @Override
    public void enviarSolicitudEstudiante(Estudiante est, Solicitud sol) throws PersistenceException{
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        somap.insertarIdentificacion(est.getNumero_identificacion(), est.getTipo_identificacion());
        somap.insertarDatosEstudiante(est);
        somap.insertarSolicitud(sol);
        for (int i=0;i<est.getCorreo().size();i++){
            somap.insertarCorreoEstudiante(est,est.getCorreo().get(i).getCorreo());
        }
        
    }

    @Override
    public void enviarSolicitudEgresado(Egresado egr, Solicitud sol) throws PersistenceException{
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        somap.insertarIdentificacion(egr.getNumero_identificacion(), egr.getTipo_identificacion());
        somap.insertarDatosEgresado(egr);
        somap.insertarSolicitud(sol);        
        for (int i=0;i<egr.getCorreo().size();i++){
            somap.insertarCorreoEgresado(egr,egr.getCorreo().get(i).getCorreo());
        }
    }

    @Override
    public Egresado consultarEgresado(long identificacion, String tipo_identificacion) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        return somap.consultarEgresado(identificacion,tipo_identificacion);
    }

    @Override
    public Usuario getUsuario(String username) throws PersistenceException {
       SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
       return somap.getUsuario(username);
    }

    @Override
    public int cantidadCertificados() throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
       return somap.cantidadCertificados();
    }

    @Override
    public void putCertificado(int codigo, String nombre,String valido) throws PersistenceException{
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        somap.putCertificado(codigo,nombre,valido);
    }

    @Override
    public Certificado getCertificado(int codigo) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        return somap.getCertificado(codigo);
    }

    @Override
    public void invalidarCertificado(int codigo) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        somap.invalidarCertificado(codigo);

    }

    
    public static String generateHash(String password){
        DefaultHashService hashService = new DefaultHashService();
        hashService.setHashIterations(500000); // 500000
        hashService.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        
        // Same salt as in shiro.ini, but NOT base64-encoded!!
        hashService.setPrivateSalt(new SimpleByteSource("myprivatesalt")); 
        hashService.setGeneratePublicSalt(true);

        DefaultPasswordService passwordService = new DefaultPasswordService();
        passwordService.setHashService(hashService);
        String encryptedPassword = passwordService.encryptPassword(password);
        
        return encryptedPassword;
        
    }
  
    
    

    

}