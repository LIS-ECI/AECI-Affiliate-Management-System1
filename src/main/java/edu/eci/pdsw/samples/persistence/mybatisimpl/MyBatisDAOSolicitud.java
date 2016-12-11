
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            return somap.consultarSolicitud();
        } catch (Exception ex) {
            throw new PersistenceException("Error en la consulta Solicitud", ex.getCause());
        }
    }

    @Override
    public List<Pago> consultarPago() throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            return somap.consultarPagos();
        } catch (Exception ex) {
            throw new PersistenceException("Error en la consulta Pago", ex.getCause());
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);

        try {
            return somap.consultarAfiliacion();
        } catch (Exception ex) {
            throw new PersistenceException("Error en la consulta Usuarios", ex.getCause());
        }
    }

    @Override
    public Estudiante consultarEstudiante(long identificacion, String tipo_identificacion) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            return somap.consultarEstudiante(identificacion, tipo_identificacion);
        } catch (Exception ex) {
            throw new PersistenceException("Error en la consulta Estudiante", ex.getCause());
        }
    }

    @Override
    public void InsertarUsuario(Usuario u) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        u.setClave(MyBatisDAOSolicitud.generateHash(u.getClave()));
        try {
            somap.InsertarUsuario(u);
        } catch (Exception ex) {
            throw new PersistenceException("Error al insertar un usuario", ex.getCause());
        }
    }

    @Override
    public void ModificarSolicitud(String u, long ced, String tic) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            somap.ModificarSolicitud(u, ced, tic);
        } catch (Exception ex) {
            throw new PersistenceException("Error en la modificacion de la solicitud", ex.getCause());
        }
    }

    @Override
    public void enviarSolicitudEstudiante(Estudiante est, Solicitud sol) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);

        try {
            somap.insertarIdentificacion(est.getNumero_identificacion(), est.getTipo_identificacion());

        } catch (Exception ex) {

            throw new PersistenceException("El numero de indetificación ingresado ya esta en uso", ex.getCause());
        }

            try {
                somap.insertarCorreoEstudiante(est, est.getCorreo().get(0).getCorreo());
                 try {
                somap.insertarCorreoEstudiante(est, est.getCorreo().get(1).getCorreo());
            } catch (Exception ex) {
                somap.deleteCorreo(est.getCorreo().get(0).getCorreo());
                somap.deleteId(est.getNumero_identificacion(), est.getTipo_identificacion());
                throw new PersistenceException("El correo ingresado ya esta en uso", ex.getCause());
            }
            } catch (Exception ex) {
                somap.deleteId(est.getNumero_identificacion(), est.getTipo_identificacion());
                throw new PersistenceException("El correo ingresado ya esta en uso", ex.getCause());
            }
        

        try {
            somap.insertarDatosEstudiante(est);
        } catch (Exception ex) {

            throw new PersistenceException("Error al ingresas el estudiante", ex.getCause());
        }
        try {
            somap.insertarSolicitud(sol);
        } catch (Exception ex) {
            throw new PersistenceException("Error al ingresar la Solicitud", ex.getCause());
        }

    }

    @Override
    public void enviarSolicitudEgresado(Egresado egr, Solicitud sol) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            somap.insertarIdentificacion(egr.getNumero_identificacion(), egr.getTipo_identificacion());
        } catch (Exception ex) {
            throw new PersistenceException("El numero de identificacion ya esta en uso", ex.getCause());

        }
            try {
                somap.insertarCorreoEgresado(egr, egr.getCorreo().get(0).getCorreo());
                    
            } catch (Exception ex) {
                somap.deleteId(egr.getNumero_identificacion(), egr.getTipo_identificacion());
                throw new PersistenceException("El correo ingresado ya esta en uso", ex.getCause());

            }
        try {
            somap.insertarDatosEgresado(egr);
        } catch (Exception ex) {
            throw new PersistenceException("no se logró insertar los datos del egresado", ex.getCause());
        }
        try {
            somap.insertarSolicitud(sol);
        } catch (Exception ex) {
            throw new PersistenceException("no se logró crear la solicitud", ex.getCause());
        }

    }

    @Override
    public Egresado consultarEgresado(long identificacion, String tipo_identificacion) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);

        try {
            return somap.consultarEgresado(identificacion, tipo_identificacion);
        } catch (Exception ex) {
            throw new PersistenceException("Error en la consulta egresado", ex.getCause());
        }
    }

    @Override
    public Usuario getUsuario(String username) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);

        try {
            return somap.getUsuario(username);
        } catch (Exception ex) {
            throw new PersistenceException("Error en la consulta del usuario", ex.getCause());
        }
    }

    @Override
    public int cantidadCertificados() throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            return somap.cantidadCertificados();
        } catch (Exception ex) {
            throw new PersistenceException("Error en la consulta de la cantidad de certificados", ex.getCause());
        }
    }

    @Override
    public void putCertificado(int codigo, String nombre, String valido) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            somap.putCertificado(codigo, nombre, valido);
        } catch (Exception ex) {
            throw new PersistenceException("Error al guardar el id del certificado", ex.getCause());
        }
    }

    @Override
    public Certificado getCertificado(int codigo) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            return somap.getCertificado(codigo);
        } catch (Exception ex) {
            throw new PersistenceException("Error en la consulta del certificado", ex.getCause());
        }
    }

    @Override
    public void invalidarCertificado(int codigo) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            somap.invalidarCertificado(codigo);
        } catch (Exception ex) {
            throw new PersistenceException("Error al invalidar certificado", ex.getCause());

        }

    }
    
    @Override
    public void insertarPago(Pago p) throws PersistenceException {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        try {
            somap.InsertarPago(p);
        } catch (Exception ex) {
            throw new PersistenceException("Error al insertar un pago", ex.getCause());
        }
    }

    public static String generateHash(String password) {
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
