/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package com.munisanborja.sys.model.logic;

import com.munisanborja.sys.dao.UbicacionValidaDao;

import com.munisanborja.sys.dao.UnidadEjecutoraValidaDao;

import com.munisanborja.sys.model.entities.InformeTecnico;

import com.munisanborja.sys.model.entities.UbicacionValida;

import com.munisanborja.sys.model.entities.UnidadEjecutoraValida;

import java.util.ArrayList;

import java.util.List;

/**
 *
 *
 *
 * @author Eric
 *
 */
public class GestionInformeTecnico {

    private boolean manoobranocalificadaValid;

    private boolean tasadescuentoValid;

    private boolean precioSocialValid;

    private boolean valorSocialTiempoValid;

    public void validarInformeTecnico(InformeTecnico r) {

        setManoobranocalificadaValid(r);

        setTasadescuentoValid(r);

        setPrecioSocialValid(r);

        setValorSocialTiempoValid(r);

    }

    public boolean setManoobranocalificadaValid(InformeTecnico r) {

        this.manoobranocalificadaValid = false;

        if (r.getProyectoPreInversion().getRequerimiento().getCostoMantenimiento() != 0) {

            this.manoobranocalificadaValid = true;

        }

        return this.isManoobranocalificadaValid();

    }

    public boolean setTasadescuentoValid(InformeTecnico r) {

        this.tasadescuentoValid = true;

        return this.isTasadescuentoValid();

    }

    public boolean setPrecioSocialValid(InformeTecnico r) {

        this.precioSocialValid = true;

        return this.isPrecioSocialValid();

    }

    public boolean setValorSocialTiempoValid(InformeTecnico r) {

        this.valorSocialTiempoValid = true;

        return this.isValorSocialTiempoValid();

    }

///////////////////////////////////////////////////////////////////////   
    /**
     *
     * @return the nombreValid
     *
     */
    public boolean isManoobranocalificadaValid() {

        return manoobranocalificadaValid;

    }

    /**
     *
     * @return the objetivoValid
     *
     */
    public boolean isTasadescuentoValid() {

        return tasadescuentoValid;

    }

    public boolean isPrecioSocialValid() {

        return precioSocialValid;

    }

    public boolean isValorSocialTiempoValid() {

        return valorSocialTiempoValid;

    }

}
