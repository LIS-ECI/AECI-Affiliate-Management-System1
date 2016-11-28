/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 2107641
 */
public class Test1 {


        //@Test
        public void EntradaForoTest1()  throws PersistenceException, IOException{
        Properties properties=new PropertiesLoader().readProperties("applicationconfig.properties");
        DaoFactory daof=DaoFactory.getInstance(properties);
        
        daof.beginSession();
        //Prueba load de MyBatisDAoSolicitud
        System.out.println("Prueba LOAD  "+daof.getDaoSolicitud().consultarSolicitud().get(0));
        daof.commitTransaction();
        daof.endSession();
    }
        
 class PropertiesLoader {

    public Properties readProperties(String fileName) throws IOException {
        InputStream input = null;
        Properties properties = new Properties();
        input = this.getClass().getClassLoader().getResourceAsStream(fileName);
        properties.load(input);
        return properties;
    }
  }
        
}

