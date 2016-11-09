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
import edu.eci.pdsw.samples.persistence.DaoEgresado;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.EstudianteMapper;
import org.apache.ibatis.session.SqlSession;
import edu.eci.pdsw.samples.persistence.DaoEstudiante;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.EgresadoMapper;

/**
 *
 * @author hcadavid
 */

public class MyBatisDAOEgresado implements DaoEgresado{

    
    private SqlSession currentSession=null;

    public MyBatisDAOEgresado(SqlSession session) {
        this.currentSession=session;
    }


    @Override
    public void enviarSolicitudEgresado(Egresado egr, Solicitud sol) throws PersistenceException {
        EgresadoMapper egmap = currentSession.getMapper(EgresadoMapper.class);
        egmap.enviarSolicitudEgresado(egr,sol);
    }

}
