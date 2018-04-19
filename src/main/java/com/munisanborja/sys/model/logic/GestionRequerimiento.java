/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.model.logic;

import com.munisanborja.sys.dao.UbicacionValidaDao;
import com.munisanborja.sys.dao.UnidadEjecutoraValidaDao;
import com.munisanborja.sys.model.entities.Requerimiento;
import com.munisanborja.sys.model.entities.UbicacionValida;
import com.munisanborja.sys.model.entities.UnidadEjecutoraValida;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eric
 */
public class GestionRequerimiento {
    
    private boolean nombreValid;
    private boolean objetivoValid;
    private boolean problemaValid;
    private boolean ubicacionValid;
    private boolean unidadFormuladoraValid;
    private boolean unidadEjecutoraValid;
    
    
    public void validarRequerimiento(Requerimiento r){
        setNombreValid(r);
        setObjetivoValid(r);
        setProblemaValid(r);
        setUbicacionValid(r);
        setUnidadFormuladoraValid(r);
        setUnidadEjecutoraValid(r);
    }
    
    public boolean setNombreValid(Requerimiento r){
        
        this.nombreValid = false;
        if(!r.getNombre().isEmpty()){
            this.nombreValid = true;
        }
        
        return this.isNombreValid();
                   
    }
    public boolean setObjetivoValid(Requerimiento r){
        
        this.objetivoValid = false;
        if(!r.getObjetivo().isEmpty()){
            this.objetivoValid = true;
        }
        
        return this.isObjetivoValid();
                   
    }
    public boolean setProblemaValid(Requerimiento r){
        
        this.problemaValid = false;
        
        if(!r.getProblema().isEmpty()){
            this.problemaValid = true;
        }
        
        return this.isProblemaValid();
                   
    }
    
    public boolean setUbicacionValid(Requerimiento r){
        
        this.ubicacionValid = false;
        
        UbicacionValidaDao uvd = new UbicacionValidaDao();
        List<UbicacionValida> list = new ArrayList();
        list = uvd.listarUbicacionValida();
        
        for(UbicacionValida uv : list){
            if(r.getUbicacion().getDepartamento().equals(uv.getNombre())){
                this.ubicacionValid = true;
            }
        }
        return this.isUbicacionValid();
                   
    }
    
    public boolean setUnidadFormuladoraValid(Requerimiento r){
        
        this.unidadFormuladoraValid = false;
        
        if(r.getUnidadFormuladora() != null){
            this.unidadFormuladoraValid = true;
        }
        return this.isUnidadFormuladoraValid() ;
                   
    }
    
    public boolean setUnidadEjecutoraValid(Requerimiento r){
        
        this.unidadEjecutoraValid = false;
        
        UnidadEjecutoraValidaDao uevd = new UnidadEjecutoraValidaDao();
        List<UnidadEjecutoraValida> list = uevd.listarUnidadEjecutoraValida();
        
        for(UnidadEjecutoraValida uev : list){
            if(!r.getUnidadEjecutoraRecomendada().isEmpty() && r.getUnidadEjecutoraRecomendada().equals(uev.getNombre())){
                this.unidadEjecutoraValid = true;
            }
        }
        
        return this.unidadEjecutoraValid;
                   
    }

    /**
     * @return the nombreValid
     */
    public boolean isNombreValid() {
        return nombreValid;
    }

    /**
     * @return the objetivoValid
     */
    public boolean isObjetivoValid() {
        return objetivoValid;
    }

    /**
     * @return the problemaValid
     */
    public boolean isProblemaValid() {
        return problemaValid;
    }

    /**
     * @return the ubicacionValid
     */
    public boolean isUbicacionValid() {
        return ubicacionValid;
    }

    /**
     * @return the unidadFormuladoraValid
     */
    public boolean isUnidadFormuladoraValid() {
        return unidadFormuladoraValid;
    }

    /**
     * @return the unidadEjecutoraValid
     */
    public boolean isUnidadEjecutoraValid() {
        return unidadEjecutoraValid;
    }
    
}
