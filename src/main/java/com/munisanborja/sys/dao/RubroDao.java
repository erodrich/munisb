/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.HibernateUtil;
import com.munisanborja.sys.model.entities.Rubro;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author OPERADOR
 */
public class RubroDao implements RubroInterface {

    @Override
    public List<Rubro> listarRubro() {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        List<Rubro> list = null;

        try {
            list = ss.createCriteria(Rubro.class).list();
            t.commit();
        } catch (Exception ex) {
            t.rollback();
            ex.printStackTrace();
        } finally {
            if (ss.isOpen()) {
                ss.close();
            }
        }

        return list;
    }

    @Override
    public Rubro get(Integer id) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Rubro rd = (Rubro) ss.get(Rubro.class, id);
        ss.getTransaction().commit();
        return rd;
    }

}
