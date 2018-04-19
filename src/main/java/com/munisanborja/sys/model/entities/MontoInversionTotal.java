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
public class MontoInversionTotal {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo;
    
    private Double precioMercado;
    
    private Double precioSocial;

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
     * @return the precioMercado
     */
    public Double getPrecioMercado() {
        return precioMercado;
    }

    /**
     * @param precioMercado the precioMercado to set
     */
    public void setPrecioMercado(Double precioMercado) {
        this.precioMercado = precioMercado;
    }

    /**
     * @return the precioSocial
     */
    public Double getPrecioSocial() {
        return precioSocial;
    }

    /**
     * @param precioSocial the precioSocial to set
     */
    public void setPrecioSocial(Double precioSocial) {
        this.precioSocial = precioSocial;
    }
    
    
    
    
}
