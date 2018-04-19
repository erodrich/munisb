/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.model.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Eric
 */
@Entity
public class ProyectoPreInversion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo;
    
    private String identificador;
    
    private Date fechaInicio;
    
    private Date fechaFin;
    
    private Date fechaDeclaracionViabilidad;
    
    private Double montoComprometido;
    
    private Double montoDevengado;
    
    private Double montoEjecutado;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="EstadoTramite_codigo", referencedColumnName="codigo", nullable=false)
    private EstadoTramite estadoTramite;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Requerimiento_codigo", referencedColumnName="codigo")
    private Requerimiento requerimiento;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="EstadoViabilidad_codigo", referencedColumnName="codigo", nullable=false)
    private EstadoViabilidad estadoViabilidad;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Rubro_codigo", referencedColumnName="codigo", nullable=false)
    private Rubro rubro;

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
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the fechaDeclaracionViabilidad
     */
    public Date getFechaDeclaracionViabilidad() {
        return fechaDeclaracionViabilidad;
    }

    /**
     * @param fechaDeclaracionViabilidad the fechaDeclaracionViabilidad to set
     */
    public void setFechaDeclaracionViabilidad(Date fechaDeclaracionViabilidad) {
        this.fechaDeclaracionViabilidad = fechaDeclaracionViabilidad;
    }

    /**
     * @return the estadoTramite
     */
    public EstadoTramite getEstadoTramite() {
        return estadoTramite;
    }

    /**
     * @param estadoTramite the estadoTramite to set
     */
    public void setEstadoTramite(EstadoTramite estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    /**
     * @return the requerimiento
     */
    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    /**
     * @param requerimiento the requerimiento to set
     */
    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    /**
     * @return the estadoViabilidad
     */
    public EstadoViabilidad getEstadoViabilidad() {
        return estadoViabilidad;
    }

    /**
     * @param estadoViabilidad the estadoViabilidad to set
     */
    public void setEstadoViabilidad(EstadoViabilidad estadoViabilidad) {
        this.estadoViabilidad = estadoViabilidad;
    }

    /**
     * @return the montoComprometido
     */
    public Double getMontoComprometido() {
        return montoComprometido;
    }

    /**
     * @param montoComprometido the montoComprometido to set
     */
    public void setMontoComprometido(Double montoComprometido) {
        this.montoComprometido = montoComprometido;
    }

    /**
     * @return the montoDevengado
     */
    public Double getMontoDevengado() {
        return montoDevengado;
    }

    /**
     * @param montoDevengado the montoDevengado to set
     */
    public void setMontoDevengado(Double montoDevengado) {
        this.montoDevengado = montoDevengado;
    }

    /**
     * @return the montoEjecutado
     */
    public Double getMontoEjecutado() {
        return montoEjecutado;
    }

    /**
     * @param montoEjecutado the montoEjecutado to set
     */
    public void setMontoEjecutado(Double montoEjecutado) {
        this.montoEjecutado = montoEjecutado;
    }

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
     * @return the rubro
     */
    public Rubro getRubro() {
        return rubro;
    }

    /**
     * @param rubro the rubro to set
     */
    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }
    
}
