/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;



import edu.eci.pdsw.samples.entities.CorreoPersonal;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hcadavid
 */
public class SolicitudTest {

    public SolicitudTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from CONSULTAS");
        stmt.execute("delete from PACIENTES");
        
        conn.commit();
        conn.close();
    }

    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");        
    }
    
    //@Test
    public void pruebaCeroTest() throws SQLException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
        
        /**
         * Comprobar si la funcionalidad de agregar solicitudes esta funcionando
         * 
         */
        
        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (9876,'CC')");
        stmt.execute("INSERT INTO `Solicitud` (`fecha`, `Cedula_Numero`, `Cedula_Tipo`, `tipo`, `aprobado`) VALUES ('2001-01-01 00:00:00',9876,'CC','Estudiante','OK')"); 
        
        
        ResultSet rs=stmt.executeQuery("select count(*) from Solicitud");
        int resultado=0;
        while (rs.next()){
            resultado = rs.getInt(1);
        }
        
        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        Servicios servicios=Servicios.getInstance("h2-applicationconfig.properties");
        
        //servicios.topNPacientesPorAnyo(2, 2005);	
        CorreoPersonal cp = new CorreoPersonal("pruba@hotmail.com",123456,"CC");
        List<CorreoPersonal> lisc = new ArrayList<>();
        lisc.add(cp);
        Egresado egr = new Egresado(123456, "CC", "NombreDePrueba",2001, 2, "CargoDePrueba", "CarreraDePrueba","DireccionDePrueba", "NombreEmpresa", "DireccionDeEmpresa",1234,1234,4321, lisc);
        java.sql.Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Solicitud sol = new Solicitud(fecha,egr.getCedula(), egr.getCedula_tipo(),"Egresado","Pend");
        try {
            servicios.enviarSolicitudEgresado(egr,sol);
            List<Solicitud> ls = servicios.consultarSolicitud();
            assertEquals("No realizó la solicitud adecuadamente",ls.size(),resultado);
        } catch (PersistenceException ex) {
            Logger.getLogger(SolicitudTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    

}