/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;



import edu.eci.pdsw.samples.entities.CorreoPersonal;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "an", "");
        Statement stmt = conn.createStatement();
        
        
        conn.commit();
        conn.close();
    }

    
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL","an", "");        
    }
    
    
    /**
     * Test Realizar Solicitud Egresado
     * Se comprueba que se haya insertado correctamente la solicitud y que se cargue correctamente
     * @throws java.sql.SQLException
    */
    @Test
    public void realizarSolicitudEgresadoTest() throws SQLException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
        
        
        
        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (9876,'CC')");
        stmt.execute("INSERT INTO `Solicitud` (`fecha`, `Cedula_Numero`, `Cedula_Tipo`, `tipo`, `aprobado`) VALUES ('2001-01-01',9876,'CC','Egresado','Pend')"); 
        
        
        ResultSet rs=stmt.executeQuery("select count(*) from Solicitud where `tipo`='Egresado' and `aprobado`='Pend'");
        int resultado=0;
        while (rs.next()){
            resultado +=1;
        }
        
        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        Servicios servicios=Servicios.getInstance("h2-applicationconfig.properties");
        
        //servicios.topNPacientesPorAnyo(2, 2005);	
        CorreoPersonal cp = new CorreoPersonal("prueba@hotmail.com",123,"CC");
        List<CorreoPersonal> lisc = new ArrayList<>();
        lisc.add(cp);
        Egresado egr = new Egresado("Masculino","ApellidodePrueba",123, "CC", "NombreDePrueba",2001, 2, "CargoDePrueba", "CarreraDePrueba","DireccionDePrueba", "NombreEmpresa", "DireccionDeEmpresa",1234,1234,4321, lisc);
        java.sql.Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Solicitud sol = new Solicitud(fecha,egr.getNumero_identificacion(), egr.getTipo_identificacion(),"Egresado","Pend");
        try {
            servicios.enviarSolicitudEgresado(egr,sol);
            List<Solicitud> ls = servicios.consultarSolicitud();
            int CantidadSoli=0;
            for (Solicitud s:ls){
                if (s.getTipo().equals("Egresado")){
                    CantidadSoli+=1;
                }
            }
            assertEquals("No realizó la solicitud adecuadamente",CantidadSoli,resultado+1);
        } catch (PersistenceException ex) {
            assertTrue("No se realizo adecuadamente la solicitud egresado",false);
        }
        
        
        
    }
    
     /**
     * Test Realizar Solicitud Estudiante
     * Se comprueba que se haya insertado correctamente la solicitud
     * @throws java.sql.SQLException
    */
    @Test
    public void realizarSolicitudEstudianteTest() throws SQLException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
        
        
        
        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (9,'CC')");
        stmt.execute("INSERT INTO `Solicitud` (`fecha`, `Cedula_Numero`, `Cedula_Tipo`, `tipo`, `aprobado`) VALUES ('2001-01-01',9,'CC','Estudiante','Pend')"); 
        
        
        ResultSet rs=stmt.executeQuery("select count(*) from Solicitud where `tipo`='Estudiante' and `aprobado`='Pend'");
        int resultado=0;
        while (rs.next()){
            resultado +=1 ;
        }
        
        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        Servicios servicios=Servicios.getInstance("h2-applicationconfig.properties");
        
        //
        CorreoPersonal cp = new CorreoPersonal("p@mail",1,"CD");
        CorreoPersonal cp2 = new CorreoPersonal("p2@mail",1,"CD");
        List<CorreoPersonal> lisc = new ArrayList<>();
        lisc.add(cp);
        lisc.add(cp2);
        Estudiante est = new Estudiante("Masculino","ApellidodePrueba",123456,1, "NombreDePrueba",2, "CD", "CarreraDePrueba",343242, 12312312, lisc,"calle100","");
        java.sql.Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Solicitud sol = new Solicitud(fecha,est.getNumero_identificacion(), est.getTipo_identificacion(),"Estudiante","Pend");
        try {
            servicios.enviarSolicitudEstudiante(est,sol);
            List<Solicitud> ls = servicios.consultarSolicitud();
            int CantidadSoli=0;
            for (Solicitud s:ls){
                if (s.getTipo().equals("Estudiante")){
                    CantidadSoli+=1;
                }
            }
            assertEquals("No realizó la solicitud adecuadamente",CantidadSoli,resultado+1);
        } catch (PersistenceException ex) {
            assertTrue("No se realizo adecuadamente la solicitud Estudiante",false);
        }
        
        
        
    }
    
    
    
}