/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.model.logic;

import com.munisanborja.sys.dao.ProyectoPreInversionDao;
import com.munisanborja.sys.model.entities.ProyectoPreInversion;

/**
 *
 * @author OPERADOR
 */
public class GestionProyecto {

    ProyectoPreInversion proyecto;
    ProyectoPreInversionDao pDao;
    private Double total;

    public GestionProyecto(ProyectoPreInversion p) {
        this.proyecto = p;
        //setTotal();
    }

    public void setTotal() {
        Double total = this.proyecto.getMontoComprometido() - this.proyecto.getMontoDevengado() - this.proyecto.getMontoEjecutado();
    }

    public Double getTotal() {
        return this.total;
    }

    public void ComprometerPresupuesto(Double presupuesto) {

        pDao = new ProyectoPreInversionDao();
        this.proyecto.setMontoComprometido(presupuesto);
        pDao.update(this.proyecto);

    }

}
