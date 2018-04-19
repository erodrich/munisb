/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.HibernateUtil;
import com.munisanborja.sys.model.entities.InformeTecnico;
import com.munisanborja.sys.model.entities.ProyectoPreInversion;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Eric
 */
public class InformeTecnicoDao implements InformeTecnicoInterface {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<InformeTecnico> listarInformeTecnico() {

        List<InformeTecnico> list;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        try {
            list = ss.createCriteria(InformeTecnico.class)
                    .setFetchMode("detalleInformeTecnico", FetchMode.JOIN)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();
            t.commit();

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

    @Override
    public List<InformeTecnico> listarInformeTecnico(String fechaInicio, String fechaFinal) {
        List<InformeTecnico> list = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            try {
                Criteria cr = session.createCriteria(InformeTecnico.class)
                        .add(Restrictions.between("fechaCreacion", df.parse(fechaInicio), df.parse(fechaFinal)))
                        .addOrder(Order.desc("fechaCreacion"))
                        .setFetchMode("detalleInformeTecnico", FetchMode.JOIN)
                        .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                list = cr.list();
                t.commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
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

    @Override
    public InformeTecnico get(Integer id) {
        InformeTecnico result = new InformeTecnico();
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();

        try {
            result = (InformeTecnico) ss.get(InformeTecnico.class, id);
            t.commit();
            
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
        return result;
    }

}
