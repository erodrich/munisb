/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.HibernateUtil;
import com.munisanborja.sys.model.entities.Requerimiento;
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
public class RequerimientoDao implements RequerimientoInterface {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Requerimiento> listarRequerimiento() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Requerimiento> list = session.createCriteria(Requerimiento.class).list();
        return list;
    }

    @Override
    public void create(Requerimiento c) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
    }

    @Override
    public void update(Requerimiento c) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            ss.beginTransaction();
            ss.update(c);
            ss.getTransaction().commit();
        }finally{
            if (ss.isOpen()) {
                ss.close();
            }
        }
    }

    @Override
    public void delete(Requerimiento c) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
    }
    
    @Override
    public Requerimiento get(String id) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Criteria cr = session.createCriteria(Requerimiento.class)
                .add(Restrictions.eq("identificador", id));
        
        Requerimiento rd = (Requerimiento) cr.uniqueResult();
        ss.getTransaction().commit();
        return rd;
    }
    
    @Override
    public Requerimiento get(Integer id) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Requerimiento rd = (Requerimiento) session.get(Requerimiento.class, id);
        ss.getTransaction().commit();
        return rd;
        
    }

    @Override
    public List<Requerimiento> listarRequerimiento(Date fechaInicio, Date fechaFinal) {
        List<Requerimiento> list = new ArrayList<>();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Requerimiento.class)
                .add(Restrictions.between("fechaCreacion", fechaInicio, fechaFinal))
                .addOrder(Order.desc("fechaCreacion"));
        list = cr.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Requerimiento> listarRequerimiento(String fechaInicio, String fechaFinal) {
        
        List<Requerimiento> list = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            try {
                Criteria cr = session.createCriteria(Requerimiento.class)
                        .add(Restrictions.between("fechaCreacion", df.parse(fechaInicio), df.parse(fechaFinal)))
                        .addOrder(Order.desc("fechaCreacion"));
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
    public List<Requerimiento> listarProcesoReq(String fechaInicio, String fechaFinal) {
        List<Requerimiento> list = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            try {
                Criteria cr = session.createCriteria(Requerimiento.class)
                        .add(Restrictions.isNotNull("requerimientoEvaluado"))
                        .add(Restrictions.between("fechaCreacion", df.parse(fechaInicio), df.parse(fechaFinal)))
                        .addOrder(Order.desc("fechaCreacion"));
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
    public List<Requerimiento> listarProcesoReqPend(String fechaInicio, String fechaFinal) {
        List<Requerimiento> list = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            try {
                Criteria cr = session.createCriteria(Requerimiento.class)
                        .add(Restrictions.isNull("requerimientoEvaluado"))
                        .add(Restrictions.between("fechaCreacion", df.parse(fechaInicio), df.parse(fechaFinal)))
                        .addOrder(Order.desc("fechaCreacion"));
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

}
