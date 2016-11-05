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

import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.EstudianteMapper;
import org.apache.ibatis.session.SqlSession;
import edu.eci.pdsw.samples.persistence.DaoEstudiante;

/**
 *
 * @author hcadavid
 */

public class MyBatisDAOEstudiante implements DaoEstudiante{

    
    private SqlSession currentSession=null;

    public MyBatisDAOEstudiante(SqlSession session) {
        this.currentSession=session;
    }

    @Override
    public Estudiante load(String email) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public void update(Estudiante p) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enviarSolicitudEstudiante(Estudiante est, Solicitud sol) throws PersistenceException {
        System.out.println("holaaa1");
        EstudianteMapper esmap = currentSession.getMapper(EstudianteMapper.class);
        System.out.println("holaaa2");
        esmap.enviarSolicitudEstudiante(est,sol);
        System.out.println("holaaa3");
    }

}
