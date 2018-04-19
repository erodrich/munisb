/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Eric
 */
@Entity
public class RequerimientoEvaluado {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo;

    private Double impuestoRenta;

    private Double cManoObraCalificada;

    private Double cManoObraNoCalificada;

    private Double factorManoObraCalificada;

    private Double factorManoObraNoCalificada;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the impuestoRenta
     */
    public Double getImpuestoRenta() {
        return impuestoRenta;
    }

    /**
     * @param impuestoRenta the impuestoRenta to set
     */
    public void setImpuestoRenta(Double impuestoRenta) {
        this.impuestoRenta = impuestoRenta;
    }

    /**
     * @return the cManoObraCalificada
     */
    public Double getcManoObraCalificada() {
        return cManoObraCalificada;
    }

    /**
     * @param cManoObraCalificada the cManoObraCalificada to set
     */
    public void setcManoObraCalificada(Double cManoObraCalificada) {
        this.cManoObraCalificada = cManoObraCalificada;
    }

    /**
     * @return the cManoObraNoCalificada
     */
    public Double getcManoObraNoCalificada() {
        return cManoObraNoCalificada;
    }

    /**
     * @param cManoObraNoCalificada the cManoObraNoCalificada to set
     */
    public void setcManoObraNoCalificada(Double cManoObraNoCalificada) {
        this.cManoObraNoCalificada = cManoObraNoCalificada;
    }

    /**
     * @return the factorManoObraCalificada
     */
    public Double getFactorManoObraCalificada() {
        return factorManoObraCalificada;
    }

    /**
     * @param factorManoObraCalificada the factorManoObraCalificada to set
     */
    public void setFactorManoObraCalificada(Double factorManoObraCalificada) {
        this.factorManoObraCalificada = factorManoObraCalificada;
    }

    /**
     * @return the factorManoObraNoCalificada
     */
    public Double getFactorManoObraNoCalificada() {
        return factorManoObraNoCalificada;
    }

    /**
     * @param factorManoObraNoCalificada the factorManoObraNoCalificada to set
     */
    public void setFactorManoObraNoCalificada(Double factorManoObraNoCalificada) {
        this.factorManoObraNoCalificada = factorManoObraNoCalificada;
    }

}
