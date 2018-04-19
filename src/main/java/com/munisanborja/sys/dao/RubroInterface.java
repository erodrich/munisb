/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.model.entities.Rubro;
import java.util.List;

/**
 *
 * @author OPERADOR
 */
public interface RubroInterface {
    public List<Rubro> listarRubro();
    public Rubro get(Integer id);
}
