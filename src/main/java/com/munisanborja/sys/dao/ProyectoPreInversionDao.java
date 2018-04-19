/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.HibernateUtil;
import com.munisanborja.sys.model.entities.ProyectoPreInversion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Eric
 */
public class ProyectoPreInversionDao implements ProyectoPreInversionInterface {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<ProyectoPreInversion> listarProyectoPreInversion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProyectoPreInversion get(Integer id) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        ProyectoPreInversion rd = (ProyectoPreInversion) session.get(ProyectoPreInversion.class, id);
        ss.getTransaction().commit();
        return rd;
    }

    @Override
    public ProyectoPreInversion get(String id) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ProyectoPreInversion rd = new ProyectoPreInversion();
        try {
            Criteria cr = ss.createCriteria(ProyectoPreInversion.class)
                    .add(Restrictions.eq("identificador", id));
            rd = (ProyectoPreInversion) cr.uniqueResult();
            t.commit();

        } catch (Exception ex) {
            t.rollback();
            ex.printStackTrace();

        } finally {
            if (ss.isOpen()) {
                ss.close();
            }
        }

        return rd;
    }

    @Override
    public List<ProyectoPreInversion> listarProyectoPreInversion(Date fechaInicio, Date fechaFinal) {
        List<ProyectoPreInversion> list = new ArrayList<>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(ProyectoPreInversion.class)
                .add(Restrictions.between("fechaInicio", fechaInicio, fechaFinal))
                .addOrder(Order.desc("fechaInicio"));
        list = cr.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<ProyectoPreInversion> listarProyectoPreInversion(String fechaInicio, String fechaFinal) {
        List<ProyectoPreInversion> list = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            try {
                Criteria cr = session.createCriteria(ProyectoPreInversion.class)
                        .add(Restrictions.between("fechaInicio", df.parse(fechaInicio), df.parse(fechaFinal)))
                        .addOrder(Order.desc("fechaInicio"));
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
    public void create(ProyectoPreInversion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ProyectoPreInversion c) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        ss.update(c);
        ss.getTransaction().commit();
    }

    @Override
    public void delete(ProyectoPreInversion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
