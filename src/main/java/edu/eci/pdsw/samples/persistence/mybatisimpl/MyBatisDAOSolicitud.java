/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.persistence.mybatisimpl;

import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2103216
 */
public class MyBatisDAOSolicitud {
    private SqlSession currentSession=null;

    public MyBatisDAOSolicitud(SqlSession session) {
        this.currentSession=session;
    }
    
}
