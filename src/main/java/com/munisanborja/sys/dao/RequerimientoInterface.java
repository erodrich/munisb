/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.model.entities.Requerimiento;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eric
 */
public interface RequerimientoInterface {
    public List<Requerimiento> listarRequerimiento();
    public List<Requerimiento> listarRequerimiento(Date fechaInicio, Date fechaFinal);
    public List<Requerimiento> listarRequerimiento(String fechaInicio, String fechaFinal);
    public List<Requerimiento> listarProcesoReq(String fechaInicio, String fechaFinal);
    public List<Requerimiento> listarProcesoReqPend(String fechaInicio, String fechaFinal);
    public Requerimiento get(Integer id);
    public Requerimiento get(String id);
    public void create(Requerimiento c);
    public void update(Requerimiento c);
    public void delete(Requerimiento c);
}
