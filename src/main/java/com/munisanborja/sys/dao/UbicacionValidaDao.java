package com.munisanborja.sys.dao;


import com.munisanborja.sys.HibernateUtil;
import com.munisanborja.sys.dao.UbicacionValidaInterface;
import com.munisanborja.sys.model.entities.Requerimiento;
import com.munisanborja.sys.model.entities.UbicacionValida;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric
 */
public class UbicacionValidaDao implements UbicacionValidaInterface{

    @Override
    public List<UbicacionValida> listarUbicacionValida() {
        List<UbicacionValida> list = null;
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();

        try {
            list = ss.createCriteria(UbicacionValida.class).list();
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
