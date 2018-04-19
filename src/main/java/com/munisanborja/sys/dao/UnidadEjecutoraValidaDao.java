/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.HibernateUtil;
import com.munisanborja.sys.model.entities.UnidadEjecutoraValida;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Eric
 */
public class UnidadEjecutoraValidaDao implements UnidadEjecutoraValidaInterface{

    @Override
    public List<UnidadEjecutoraValida> listarUnidadEjecutoraValida() {
        
        List<UnidadEjecutoraValida> list = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();

        try {
            list = ss.createCriteria(UnidadEjecutoraValida.class).list();
        } catch (Exception e) {
            try {
                t.rollback();
            } catch (RuntimeException rbe) {
                rbe.getMessage();
            }
            throw e;
        } finally {
            if (ss.isOpen()) {
                ss.close();
            }
        }
        return list;
    }
    
}
