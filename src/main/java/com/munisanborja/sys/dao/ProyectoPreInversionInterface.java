/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.dao;

import com.munisanborja.sys.model.entities.ProyectoPreInversion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eric
 */
public interface ProyectoPreInversionInterface {

    public List<ProyectoPreInversion> listarProyectoPreInversion();

    public List<ProyectoPreInversion> listarProyectoPreInversion(Date finicio, Date ffinal);

    public List<ProyectoPreInversion> listarProyectoPreInversion(String finicio, String ffinal);

    public ProyectoPreInversion get(Integer id);

    public ProyectoPreInversion get(String id);

    public void create(ProyectoPreInversion c);

    public void update(ProyectoPreInversion c);

    public void delete(ProyectoPreInversion c);
}
