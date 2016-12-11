/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;



import edu.eci.pdsw.samples.entities.Certificado;
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
 * @author hcadavid
 */
public class CertificadoTest {

    public CertificadoTest() {
    }

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
     * Test Realizar Solicitud 
     * Se verifican los datos del certificado insertado
     * @throws java.sql.SQLException
    */
    @Test
    public void ValidarCertificado() throws SQLException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
        
        Certificado ce= new Certificado(11, "Usuario","Ok");
        
        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (123,'CC')");
        stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('Usuario', '123', 'Estudiante', 'Ok', 123,'CC','2001-01-01','2001-01-01')"); 
        stmt.execute("INSERT INTO `Certificado` (`id`, `Usuario_nombre`, `valido`) VALUES (11,'Usuario','Ok')");

        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        Servicios servicios=Servicios.getInstance("h2-applicationconfig.properties");
        
        //
        
        try {
            Certificado c=servicios.getCertificado(11);
            
            assertEquals("No concuerdan los ids de los certificados",ce.getId(),c.getId());
            assertEquals("No concuerda el dueño del certificado",ce.getUsuario_nombre(),c.getUsuario_nombre());
            assertEquals("No concuerda la validacion del certificado",c.getValido(),ce.getValido());


        } catch (PersistenceException ex) {
            System.out.println(ex.getCause());
            assertTrue("No se obtuvo el certificado que se esperaba obtener",false);
        }
        
       
        
        
        
    }    
    

}