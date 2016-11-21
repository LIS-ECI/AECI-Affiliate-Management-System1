/*
 * Copyright (C) 2015 hcadavid
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
package edu.eci.pdsw.samples.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Param;



/**
 *
 * @author hcadavid
 */
public interface SolicitudMapper {
    
    public List<Solicitud> consultarSolicitud();

    public Estudiante consultarEstudiante(@Param("id") long identificacion, @Param("tipoid") String tipo_identificacion);

    public void InsertarUsuario(@Param("u") Usuario u);

    public void ModificarSolicitud(@Param("u") String u, @Param("ced") long ced, @Param("tic") String tic);

    public abstract void insertarIdentificacion(@Param("id") long id, @Param("tipoid") String tipoid);

    public abstract void insertarDatosEstudiante(@Param("est") Estudiante est);
    
    public abstract void insertarDatosEgresado(@Param("egr") Egresado egr);

    public abstract void insertarSolicitud(@Param("sol") Solicitud sol);

    public Egresado consultarEgresado(@Param("id") long identificacion, @Param("tipoid") String tipo_identificacion);

    public void insertarCorreoEstudiante(@Param("est") Estudiante est,@Param("cor") String cor);

    public void insertarCorreoEgresado(@Param ("egr") Egresado egr,@Param ("correo") String correo);

    public Usuario getUsuario(@Param("un") String username);

}
