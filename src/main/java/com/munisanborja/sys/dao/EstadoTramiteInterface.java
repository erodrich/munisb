/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.model.entities.EstadoTramite;
import java.util.List;

/**
 *
 * @author Eric
 */
public interface EstadoTramiteInterface {
    public List<EstadoTramite> listarEstadosTramite();
    public EstadoTramite get(Integer id);
    public void create(EstadoTramite c);
    public void update(EstadoTramite c);
    public void delete(EstadoTramite c);
}
