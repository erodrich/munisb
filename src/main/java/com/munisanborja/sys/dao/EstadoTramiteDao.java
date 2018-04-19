/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.HibernateUtil;
import com.munisanborja.sys.model.entities.EstadoTramite;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Eric
 */
public class EstadoTramiteDao implements EstadoTramiteInterface{
    Session session;
    
    @Override
    public List<EstadoTramite> listarEstadosTramite() {
         throw new UnsupportedOperationException("Not supported yet.");//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(EstadoTramite c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(EstadoTramite c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(EstadoTramite c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstadoTramite get(Integer id) {
        
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        EstadoTramite rd = (EstadoTramite) session.get(EstadoTramite.class, id);
        session.getTransaction().commit();
        return rd;
    }
}
