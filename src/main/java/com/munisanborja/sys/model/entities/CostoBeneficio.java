/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Eric
 */
@Entity
public class CostoBeneficio {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="codigo")
    private int codigo;
    
    private Double valorActualNeto;
    
    private Double tasaInternaRetorno;

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
     * @return the valorActualNeto
     */
    public Double getValorActualNeto() {
        return valorActualNeto;
    }

    /**
     * @param valorActualNeto the valorActualNeto to set
     */
    public void setValorActualNeto(Double valorActualNeto) {
        this.valorActualNeto = valorActualNeto;
    }

    /**
     * @return the tasaInternaRetorno
     */
    public Double getTasaInternaRetorno() {
        return tasaInternaRetorno;
    }

    /**
     * @param tasaInternaRetorno the tasaInternaRetorno to set
     */
    public void setTasaInternaRetorno(Double tasaInternaRetorno) {
        this.tasaInternaRetorno = tasaInternaRetorno;
    }
    
    
}
