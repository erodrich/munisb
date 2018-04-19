/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.HibernateUtil;
import com.munisanborja.sys.model.entities.EstadoViabilidad;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eric
 */
public class EstadoViabilidadDao implements EstadoViabilidadInterface {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<EstadoViabilidad> listarEstadosViabilidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstadoViabilidad get(Integer id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        EstadoViabilidad rd = (EstadoViabilidad) session.get(EstadoViabilidad.class, id);
        session.getTransaction().commit();
        return rd;
    }

    @Override
    public void create(EstadoViabilidad c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(EstadoViabilidad c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(EstadoViabilidad c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
