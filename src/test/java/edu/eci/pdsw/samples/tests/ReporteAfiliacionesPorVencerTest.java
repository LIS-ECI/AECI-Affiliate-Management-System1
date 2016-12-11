/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;


import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author User
 */
public class ReporteAfiliacionesPorVencerTest {
    
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
    
     /**
     * Test cantidad De Afiliaciones Test
     * Se comprueba que se muestren la cantidad real de afiliaciones por vencer
     * @throws java.sql.SQLException
    */
    @Test
    public void cantidadDeAfiliacionesTest() throws SQLException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();  
        

        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (99,'CC')");
        stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioVencido', 'Usuario1', 'Estudiante', 'Ok', 99,'CC','2014-11-12','2015-11-12')"); 
        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (999,'CC')");
        stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioSinVencer', 'Usuario1', 'Estudiante', 'Ok', 999,'CC','2014-11-12','2017-11-12')"); 
        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (9999,'CC')");
        stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioVencido2', 'Usuario1', 'Estudiante', 'Ok', 9999,'CC','2014-11-12','2015-01-12')"); 
        stmt.execute("INSERT INTO `Identificacion` (`Numero`, `Tipo`) VALUES (9990,'CC')");
        stmt.execute("INSERT INTO `Usuario` (`nombre`, `clave`, `tipo`, `estado`, `identificacion`,`tipo_identificacion`,`fechaInicio`,`fechaFin`) VALUES ('UsuarioVencido3', 'Usuario1', 'Egresado', 'Ok', 9990,'CC','2014-11-12','2016-11-12')"); 
        
        
        ResultSet rs=stmt.executeQuery("select count(nombre) from Usuario where DAY(fechafin) - DAY(SYSDATE()) BETWEEN 0 AND 30\n" +
"        AND YEAR(SYSDATE()) = YEAR(fechafin)\n" +
"        AND MONTH(SYSDATE()) = MONTH(fechafin) ");
        int resultado=0;
        while (rs.next()){
            resultado = rs.getInt(1);
        }
        
        
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        Servicios servicios=Servicios.getInstance("h2-applicationconfig.properties");
        List<Usuario> listaAfiliacionesPorVencer;
        try {
            listaAfiliacionesPorVencer = servicios.consultarUsuarios();
            assertEquals("No concuerdan la cantidad de afiliaciones por vencer",resultado,listaAfiliacionesPorVencer.size());

        } catch (PersistenceException ex) {
assertTrue("No se realizo adecuadamente la consulta de afiliaciones por vencer",false);
        }

        
    
    
}
}
