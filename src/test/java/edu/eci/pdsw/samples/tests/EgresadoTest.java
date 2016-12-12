/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
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
public class EgresadoTest {
   /*
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
    public void ValidarCarguedeEgresado() throws SQLException {
    Connection conn=getConnection();
    Statement stmt = conn.createStatement();
    Egresado eg= new Egresado("Femenino", "Alfaro",2045877,"CC", "Laura",2012 ,2, "Administrador", "Administracion de Empresas"
            , "Calle 12", "Ibope media", "Calle 23", 5404480, 2553560, 31524789,null);

    stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (2045877,'CC')");
    stmt.execute("INSERT INTO `Datos_Estudiante` (`Cedula_Numero`, `Cedula_Tipo`, `nombre`, `anio-grado`"
            + ", `periodo_grado`,`cargo`,`direccion_vivienda`,`nombreEmpresa`,`direccion_empresa`,`telefono_oficina`,`telefono_fijo`"
            + ",`celular`,`Programas_nombre`,`genero`,`apellido`) VALUES (2045877,'CC','Laura',2012,2,'Administrador','Calle 12','Ibope media','Calle 23',5444480,2553560)"); 
        conn.commit();
        conn.close();
    
    
    Servicios servicios=Servicios.getInstance("h2-applicationconfig.properties");
        
    try {
        
        Egresado eg2= servicios.consultarEgresado(2045877,"CC");
        assertEquals("No concuerdan las identificaciones",eg.getNumero_identificacion(),eg2.getNumero_identificacion());
        assertEquals("No concuerda el tipo de identificacion",eg.getTipo_identificacion(),eg2.getTipo_identificacion());
        assertEquals("No concuerda el nombre del usuario",eg.getNombre(),eg2.getNombre());
    } 
    catch (PersistenceException ex) {
        assertTrue("No se cargo el Egresado adecuadamente",false);    }
  
    
    }
    */
}
