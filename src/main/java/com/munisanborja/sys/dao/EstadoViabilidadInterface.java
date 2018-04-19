/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.model.entities.EstadoViabilidad;
import java.util.List;

/**
 *
 * @author Eric
 */
public interface EstadoViabilidadInterface {
    public List<EstadoViabilidad> listarEstadosViabilidad();
    public EstadoViabilidad get(Integer id);
    public void create(EstadoViabilidad c);
    public void update(EstadoViabilidad c);
    public void delete(EstadoViabilidad c);
}
