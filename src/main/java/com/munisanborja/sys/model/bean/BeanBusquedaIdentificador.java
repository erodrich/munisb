/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.model.bean;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Eric
 */
public class BeanBusquedaIdentificador {
    

    private String identificador;
    private int codigo;
    private Float porcentaje;
    private Double total;
    private String sector;
    private Double impuestorenta;
    private Double costomanoobrac;
    private Double costomanoobranc;
    private Double fcostomanoobrac;
    private Double fcostomanoobranc;
    private Double comprometer;
    

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

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
     * @return the porcentaje
     */
    public Float getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * @return the sector
     */
    public String getSector() {
        return sector;
    }

    /**
     * @param sector the sector to set
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * @return the impuestorenta
     */
    public Double getImpuestorenta() {
        return impuestorenta;
    }

    /**
     * @param impuestorenta the impuestorenta to set
     */
    public void setImpuestorenta(Double impuestorenta) {
        this.impuestorenta = impuestorenta;
    }

    /**
     * @return the costomanoobrac
     */
    public Double getCostomanoobrac() {
        return costomanoobrac;
    }

    /**
     * @param costomanoobrac the costomanoobrac to set
     */
    public void setCostomanoobrac(Double costomanoobrac) {
        this.costomanoobrac = costomanoobrac;
    }

    /**
     * @return the costomanoobranc
     */
    public Double getCostomanoobranc() {
        return costomanoobranc;
    }

    /**
     * @param costomanoobranc the costomanoobranc to set
     */
    public void setCostomanoobranc(Double costomanoobranc) {
        this.costomanoobranc = costomanoobranc;
    }

    /**
     * @return the fcostomanoobrac
     */
    public Double getFcostomanoobrac() {
        return fcostomanoobrac;
    }

    /**
     * @param fcostomanoobrac the fcostomanoobrac to set
     */
    public void setFcostomanoobrac(Double fcostomanoobrac) {
        this.fcostomanoobrac = fcostomanoobrac;
    }

    /**
     * @return the fcostomanoobranc
     */
    public Double getFcostomanoobranc() {
        return fcostomanoobranc;
    }

    /**
     * @param fcostomanoobranc the fcostomanoobranc to set
     */
    public void setFcostomanoobranc(Double fcostomanoobranc) {
        this.fcostomanoobranc = fcostomanoobranc;
    }

    /**
     * @return the comprometer
     */
    public Double getComprometer() {
        return comprometer;
    }

    /**
     * @param comprometer the comprometer to set
     */
    public void setComprometer(Double comprometer) {
        this.comprometer = comprometer;
    }

    
}
