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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Eric
 */
@Entity
public class DetalleInformeTecnico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    private String concepto;
    
    private Double valor;
    
    private String conclusion;
    

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
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the conclusion
     */
    public String getConclusion() {
        return conclusion;
    }

    /**
     * @param conclusion the conclusion to set
     */
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    /*
    public InformeTecnico getInformeTecnico() {
        return informeTecnico;
    }

    
    public void setInformeTecnico(InformeTecnico informeTecnico) {
        this.informeTecnico = informeTecnico;
    }
*/
    
    
}
