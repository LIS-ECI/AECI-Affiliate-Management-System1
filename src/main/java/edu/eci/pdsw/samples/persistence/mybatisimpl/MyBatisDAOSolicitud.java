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

import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.EstudianteMapper;
import org.apache.ibatis.session.SqlSession;
import edu.eci.pdsw.samples.persistence.DaoSolicitud;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.EgresadoMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.SolicitudMapper;
import java.util.List;

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
    public List<Solicitud> consultarSolicitud() {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        return somap.consultarSolicitud();
    }

   
    @Override
    public Estudiante consultarEstudiante(long identificacion, String tipo_identificacion) {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        return somap.consultarEstudiante(identificacion,tipo_identificacion);
    }

    @Override
    public void InsertarUsuario(Usuario u) {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        somap.InsertarUsuario(u);
    }

    @Override
    public void ModificarSolicitud(String u, long ced, String tic) {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        somap.ModificarSolicitud(u,ced,tic);
    }

    @Override
    public void enviarSolicitudEstudiante(Estudiante est, Solicitud sol) {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        somap.insertarIdentificacion(est.getNumero_identificacion(), est.getTipo_identificacion());
        somap.insertarDatosEstudiante(est);
        somap.insertarSolicitud(sol);
    }

    @Override
    public void enviarSolicitudEgresado(Egresado egr, Solicitud sol) {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        System.out.println(egr.getCedula()+ egr.getCedula_tipo());
        somap.insertarIdentificacion(egr.getCedula(), egr.getCedula_tipo());
        somap.insertarDatosEgresado(egr);
        somap.insertarSolicitud(sol);
    }

    @Override
    public Egresado consultarEgresado(long identificacion, String tipo_identificacion) {
        SolicitudMapper somap = currentSession.getMapper(SolicitudMapper.class);
        return somap.consultarEgresado(identificacion,tipo_identificacion);
    }
    
    

    

}
