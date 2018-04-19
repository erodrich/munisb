/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.model.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Requerimiento {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int codigo;
 
    private String identificador;
    
    private String nombre;
    
    private String objetivo;
    
    private String problema;
    
    private String fuenteFinanciamiento;
    
    private boolean programaInversion;
    
    private String analisisSostenibilidad;
    
    private String unidadEjecutoraRecomendada;
    
    private Double costoOperacion;
    
    private Double costoMantenimiento;
    
    @Column(updatable = false)
    private Date fechaCreacion;
    
    private Date fechaActualizacion;
    
    private Date fechaAprobacion;
    
    private Date fechaRechazo;
    
    @Column(updatable = false)
    private String elaboradoPor;
    
    private String aprobadoPor;
    
    private String revisadoPor;
    
    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                        CascadeType.REFRESH})
    @JoinColumn(name="EstadoTramite_codigo", referencedColumnName="codigo", nullable=false)
    private EstadoTramite estadoTramite;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="UnidadFormuladora_codigo", referencedColumnName="codigo")
    private UnidadFormuladora unidadFormuladora;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="MontoInversionTotal_codigo", referencedColumnName="codigo")
    private MontoInversionTotal montoInversion;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="CostoBeneficio_codigo", referencedColumnName="codigo")
    private CostoBeneficio costoBeneficio;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="CostoEfectividad_codigo", referencedColumnName="codigo")
    private CostoEfectividad costoEfectividad;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="Ubicacion_codigo", referencedColumnName="codigo")
    private Ubicacion ubicacion;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="RequerimientoEvaluado_codigo", referencedColumnName="codigo")
    private RequerimientoEvaluado requerimientoEvaluado;
    
    private String tipo;
    
    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                        CascadeType.REFRESH})
    @JoinColumn(name="persona_idPersona", referencedColumnName="idPersona")
    private Persona persona;

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
     * @return the objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * @param objetivo the objetivo to set
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * @return the problema
     */
    public String getProblema() {
        return problema;
    }

    /**
     * @param problema the problema to set
     */
    public void setProblema(String problema) {
        this.problema = problema;
    }

    /**
     * @return the fuenteFinanciamiento
     */
    public String getFuenteFinanciamiento() {
        return fuenteFinanciamiento;
    }

    /**
     * @param fuenteFinanciamiento the fuenteFinanciamiento to set
     */
    public void setFuenteFinanciamiento(String fuenteFinanciamiento) {
        this.fuenteFinanciamiento = fuenteFinanciamiento;
    }

    /**
     * @return the programaInversion
     */
    public boolean isProgramaInversion() {
        return programaInversion;
    }

    /**
     * @param programaInversion the programaInversion to set
     */
    public void setProgramaInversion(boolean programaInversion) {
        this.programaInversion = programaInversion;
    }

    /**
     * @return the analisisSostenibilidad
     */
    public String getAnalisisSostenibilidad() {
        return analisisSostenibilidad;
    }

    /**
     * @param analisisSostenibilidad the analisisSostenibilidad to set
     */
    public void setAnalisisSostenibilidad(String analisisSostenibilidad) {
        this.analisisSostenibilidad = analisisSostenibilidad;
    }

    /**
     * @return the unidadEjecutoraRecomendada
     */
    public String getUnidadEjecutoraRecomendada() {
        return unidadEjecutoraRecomendada;
    }

    /**
     * @param unidadEjecutoraRecomendada the unidadEjecutoraRecomendada to set
     */
    public void setUnidadEjecutoraRecomendada(String unidadEjecutoraRecomendada) {
        this.unidadEjecutoraRecomendada = unidadEjecutoraRecomendada;
    }

    /**
     * @return the costoOperacion
     */
    public Double getCostoOperacion() {
        return costoOperacion;
    }

    /**
     * @param costoOperacion the costoOperacion to set
     */
    public void setCostoOperacion(Double costoOperacion) {
        this.costoOperacion = costoOperacion;
    }

    /**
     * @return the costoMantenimiento
     */
    public Double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    /**
     * @param costoMantenimiento the costoMantenimiento to set
     */
    public void setCostoMantenimiento(Double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
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
     * @return the fechaRechazo
     */
    public Date getFechaRechazo() {
        return fechaRechazo;
    }

    /**
     * @param fechaRechazo the fechaRechazo to set
     */
    public void setFechaRechazo(Date fechaRechazo) {
        this.fechaRechazo = fechaRechazo;
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
     * @return the unidadFormuladora
     */
    public UnidadFormuladora getUnidadFormuladora() {
        return unidadFormuladora;
    }

    /**
     * @param unidadFormuladora the unidadFormuladora to set
     */
    public void setUnidadFormuladora(UnidadFormuladora unidadFormuladora) {
        this.unidadFormuladora = unidadFormuladora;
    }

    /**
     * @return the montoInversion
     */
    public MontoInversionTotal getMontoInversion() {
        return montoInversion;
    }

    /**
     * @param montoInversion the montoInversion to set
     */
    public void setMontoInversion(MontoInversionTotal montoInversion) {
        this.montoInversion = montoInversion;
    }

    /**
     * @return the costoBeneficio
     */
    public CostoBeneficio getCostoBeneficio() {
        return costoBeneficio;
    }

    /**
     * @param costoBeneficio the costoBeneficio to set
     */
    public void setCostoBeneficio(CostoBeneficio costoBeneficio) {
        this.costoBeneficio = costoBeneficio;
    }

    /**
     * @return the costoEfectividad
     */
    public CostoEfectividad getCostoEfectividad() {
        return costoEfectividad;
    }

    /**
     * @param costoEfectividad the costoEfectividad to set
     */
    public void setCostoEfectividad(CostoEfectividad costoEfectividad) {
        this.costoEfectividad = costoEfectividad;
    }

    /**
     * @return the ubicacion
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the requerimientoEvaluado
     */
    public RequerimientoEvaluado getRequerimientoEvaluado() {
        return requerimientoEvaluado;
    }

    /**
     * @param requerimientoEvaluado the requerimientoEvaluado to set
     */
    public void setRequerimientoEvaluado(RequerimientoEvaluado requerimientoEvaluado) {
        this.requerimientoEvaluado = requerimientoEvaluado;
    }
    
    
}
