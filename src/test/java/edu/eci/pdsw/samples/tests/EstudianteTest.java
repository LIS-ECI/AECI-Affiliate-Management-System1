/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 2103216
 */
public class EstudianteTest {
    
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
    
    @Test
    public void ValidarCarguedeEstudiante() throws SQLException {
    Connection conn=getConnection();
    Statement stmt = conn.createStatement();
    Estudiante es=new Estudiante("Masculino", "Suarez",2103216 , 12345, "Luis", 8, "CC","Ingenieria Civil", 452789,301232181, null , "Calle 52", "carjet");
    
    stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (12345,'CC')");
    stmt.execute("INSERT INTO `Datos_Estudiante` (`Cedula_Numero`, `Cedula_Tipo`, `codigo_estudiante`, `nombre`"
            + ", `semestre_ponderado`,`telefono_fijo`,`celular`,`direccion_vivienda`,`Programas_nombre`,`genero`,`apellido`"
            + ",`IMAGENES_name`) VALUES (12345, 'CC', 2103216, 'Luis', 8,452789,3012321819,'Calle 52','Ingenieria Civil','Masculino','Suarez','carnet')"); 
        conn.commit();
        conn.close();
	
 
        
        Servicios servicios=Servicios.getInstance("h2-applicationconfig.properties");
        
    try {
        
        Estudiante e2= servicios.consultarEstudiante(12345,"CC");
        assertEquals("No concuerdan las identificaciones",es.getNumero_identificacion(),e2.getNumero_identificacion());
        assertEquals("No concuerda el tipo de identificacion",es.getTipo_identificacion(),e2.getTipo_identificacion());
        assertEquals("No concuerda el nombre del usuario",es.getNombre(),e2.getNombre());
    } 
    catch (PersistenceException ex) {
        assertTrue("No se cargo el Estudiante adecuadamente",false);    }
        

    }
}
