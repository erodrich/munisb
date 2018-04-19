/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Eric
 */
@Entity
public class InformeTecnico {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo;
    
    private String nombre;
    
    private Date fechaCreacion;
    
    private Date fechaAprobacion;
    
    private Date fechaActualizacion;
    
    private String elaboradoPor;
    
    private String revisadoPor;
    
    private String aprobadoPor;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="informeTecnico_codigo", nullable=false)
    private Collection<DetalleInformeTecnico> detalleInformeTecnico = new LinkedHashSet<>();
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ProyectoPreInversion_codigo", referencedColumnName="codigo")
    private ProyectoPreInversion proyectoPreInversion;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the fechaAprobacion
     */
    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    /**
     * @param fechaAprobacion the fechaAprobacion to set
     */
    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    /**
     * @return the fechaActualizacion
     */
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @param fechaActualizacion the fechaActualizacion to set
     */
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * @return the elaboradoPor
     */
    public String getElaboradoPor() {
        return elaboradoPor;
    }

    /**
     * @param elaboradoPor the elaboradoPor to set
     */
    public void setElaboradoPor(String elaboradoPor) {
        this.elaboradoPor = elaboradoPor;
    }

    /**
     * @return the revisadoPor
     */
    public String getRevisadoPor() {
        return revisadoPor;
    }

    /**
     * @param revisadoPor the revisadoPor to set
     */
    public void setRevisadoPor(String revisadoPor) {
        this.revisadoPor = revisadoPor;
    }

    /**
     * @return the aprobadoPor
     */
    public String getAprobadoPor() {
        return aprobadoPor;
    }

    /**
     * @param aprobadoPor the aprobadoPor to set
     */
    public void setAprobadoPor(String aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    /**
     * @return the proyectoPreInversion
     */
    public ProyectoPreInversion getProyectoPreInversion() {
        return proyectoPreInversion;
    }

    /**
     * @param proyectoPreInversion the proyectoPreInversion to set
     */
    public void setProyectoPreInversion(ProyectoPreInversion proyectoPreInversion) {
        this.proyectoPreInversion = proyectoPreInversion;
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
     * @return the detalleInformeTecnico
     */
    public Collection<DetalleInformeTecnico> getDetalleInformeTecnico() {
        return detalleInformeTecnico;
    }

    /**
     * @param detalleInformeTecnico the detalleInformeTecnico to set
     */
    public void setDetalleInformeTecnico(Collection<DetalleInformeTecnico> detalleInformeTecnico) {
        this.detalleInformeTecnico = detalleInformeTecnico;
    }
}
