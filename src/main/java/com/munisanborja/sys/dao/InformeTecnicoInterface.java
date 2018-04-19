/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.model.entities.InformeTecnico;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Eric
 */
public interface InformeTecnicoInterface {
    public List<InformeTecnico> listarInformeTecnico();
    public List<InformeTecnico> listarInformeTecnico(String fechaInicio, String fechaFinal);
    public InformeTecnico get(Integer id);
}
