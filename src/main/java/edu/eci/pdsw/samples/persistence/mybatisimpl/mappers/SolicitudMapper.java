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

import edu.eci.pdsw.samples.entities.Certificado;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Image;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Param;



/**
 *
 * @author hcadavid
 */
public interface SolicitudMapper {
    
    public List<Solicitud> consultarSolicitud() throws Exception;
    
    public List<Pago> consultarPagos() throws Exception;

    public Estudiante consultarEstudiante(@Param("id") long identificacion, @Param("tipoid") String tipo_identificacion) throws Exception;

    public void InsertarUsuario(@Param("u") Usuario u) throws Exception;

    public void ModificarSolicitud(@Param("u") String u, @Param("ced") long ced, @Param("tic") String tic) throws Exception;

    public abstract void insertarIdentificacion(@Param("id") long id, @Param("tipoid") String tipoid) throws Exception;

    public abstract void insertarDatosEstudiante(@Param("est") Estudiante est) throws Exception;
    
    public abstract void insertarDatosEgresado(@Param("egr") Egresado egr) throws Exception;

    public abstract void insertarSolicitud(@Param("sol") Solicitud sol) throws Exception;

    public Egresado consultarEgresado(@Param("id") long identificacion, @Param("tipoid") String tipo_identificacion) throws Exception;

    public void insertarCorreoEstudiante(@Param("est") Estudiante est,@Param("cor") String cor) throws Exception;

    public void insertarCorreoEgresado(@Param ("egr") Egresado egr,@Param ("correo") String correo) throws Exception;

    public Usuario getUsuario(@Param("un") String username) throws Exception;

    //public List<Pago> getPagos(@Param("uname") String username) throws Exception;

    public int cantidadCertificados() throws Exception;

    public void putCertificado(@Param("codigo") int codigo,@Param("nombre") String nombre,@Param("val") String valido) throws Exception;
    
    public void invalidarCertificado(@Param("id") int id) throws Exception;

    public Certificado getCertificado(@Param("codigo") int codigo) throws Exception;

    public List<Usuario> consultarAfiliacion() throws Exception;
    
    public void deleteId(@Param("id") long id,@Param("tipoid") String tipoid);

    public void deleteCorreo(@Param("c") String correo);

    public void InsertarPago(@Param ("p") Pago p) throws Exception;
    
    public Image load(@Param("nombre") String nombre);
    
    public void save(@Param("nombre") String nombre, @Param("image") byte[] image);
    
}