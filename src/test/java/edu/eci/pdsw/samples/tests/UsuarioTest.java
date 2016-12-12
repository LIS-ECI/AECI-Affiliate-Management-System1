/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Certificado;
import edu.eci.pdsw.samples.entities.CorreoPersonal;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Observacion;
import edu.eci.pdsw.samples.entities.Pago;
import edu.eci.pdsw.samples.entities.Servicio;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author User
 */
public class UsuarioTest {
    

@Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "an", "");
        Statement stmt = conn.createStatement();
        
        
        conn.commit();
        conn.close();
    }

    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL","an", "");        
    }
   
    /**
     * Test ValidarCarguedeUsuario
     * Se verifica que se cargue correctamente el usuario ingresado en la base de datos
     * @throws java.sql.SQLException
    */
    @Test
    public void ValidarCarguedeUsuario() throws SQLException {
    Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
         CorreoPersonal cp = new CorreoPersonal("p@mail",1,"CD");
        CorreoPersonal cp2 = new CorreoPersonal("p2@mail",1,"CD");
        List<CorreoPersonal> lisc = new ArrayList<>();
        lisc.add(cp);
        lisc.add(cp2);
        Estudiante est = new Estudiante("Masculino","ApellidodePrueba",123456,1, "NombreDePrueba",2, "CD", "CarreraDePrueba",343242, 12312312, lisc,"calle100","");
        java.sql.Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Solicitud sol = new Solicitud(fecha,est.getNumero_identificacion(), est.getTipo_identificacion(),"Estudiante","Pend");
        Calendar calendar = Calendar.getInstance();	
        calendar.setTime(fecha); 	
        calendar.add(Calendar.DAY_OF_YEAR, 366); 		
        Date fecha2=  new java.sql.Date(calendar.getTime().getTime());
        //Usario Ingresado a la base de datos
        Usuario u= new Usuario(fecha,fecha2, "UsuarioT", "Usuario1", "Estudiante", "Ok", 1, "CD",null , null, null );
        
        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (1,'CD')");
        stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioT', 'Usuario1', 'Estudiante', 'Ok', 1,'CD','2016-11-12','2017-11-12')"); 

        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        Servicios servicios=Servicios.getInstance("h2-applicationconfig.properties");
        
    try {
        Usuario u2= servicios.getUsuario("UsuarioT");
        assertEquals("No concuerdan las identificaciones",u.getCedula_numero(),u2.getCedula_numero());
        assertEquals("No concuerda el tipo de identificacion",u.getCedula_tipo(),u2.getCedula_tipo());
        assertEquals("No concuerda el nombre del usuario",u.getNombre(),u2.getNombre());
    } 
    catch (PersistenceException ex) {
        assertTrue("No se cargo el usuario adecuadamente",false);    }
        
}
}