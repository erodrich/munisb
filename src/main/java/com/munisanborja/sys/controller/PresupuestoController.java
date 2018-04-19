/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.controller;

import com.munisanborja.sys.dao.ProyectoPreInversionDao;
import com.munisanborja.sys.dao.RubroDao;
import com.munisanborja.sys.model.bean.BeanBusquedaFecha;
import com.munisanborja.sys.model.bean.BeanBusquedaIdentificador;
import com.munisanborja.sys.model.entities.ProyectoPreInversion;
import com.munisanborja.sys.model.entities.Rubro;
import com.munisanborja.sys.model.logic.GestionProyecto;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author OPERADOR
 */
@Controller
public class PresupuestoController {

    ProyectoPreInversionDao ppid;
    RubroDao rd;

    @RequestMapping(value = "/listarProyectos.htm", method = RequestMethod.GET)
    public String listarProyectos(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BeanBusquedaFecha busquedareq = new BeanBusquedaFecha();
        model.addAttribute("busquedareq", busquedareq);

        return "listarProyectos";

    }

    @RequestMapping(value = "/buscarProyecto.htm", method = RequestMethod.POST)
    public String buscarProyecto(@ModelAttribute("busquedareq") BeanBusquedaFecha busquedareq,
            BindingResult result, Model model) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (busquedareq.getFechaInicio() == null || busquedareq.getFechaFinal() == null) {
            model.addAttribute("errorPIP", "Las fechas no pueden estar vacías");
        } else {

            if (busquedareq.getFechaFinal().getTime() < busquedareq.getFechaInicio().getTime()) {
                model.addAttribute("errorPIP", "El rango final debe ser superior al rango inicial");
            } else {
                ppid = new ProyectoPreInversionDao();
                List<ProyectoPreInversion> list = ppid.listarProyectoPreInversion(df.format(busquedareq.getFechaInicio()), df.format(busquedareq.getFechaFinal()));
                model.addAttribute("busquedareq", busquedareq);

                model.addAttribute("list", list);
            }

        }

        return "listarProyectos";

    }

    @RequestMapping(value = "/reasignarPresupuesto.htm", method = RequestMethod.GET)
    public String reasignarPresupuesto(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        rd = new RubroDao();

        List<Rubro> sectores = new ArrayList<>();
        sectores = rd.listarRubro();
        model.addAttribute("sectorList", sectores);
        BeanBusquedaIdentificador busquedareq = new BeanBusquedaIdentificador();

        model.addAttribute("busquedareq", busquedareq);

        return "reasignarPresupuesto";

    }

    @RequestMapping(value = "/buscarProyectoIdentificador.htm", method = RequestMethod.POST)
    public String buscarProyectoIdentificador(@ModelAttribute("busquedareq") BeanBusquedaIdentificador busquedareq,
            BindingResult result, Model model) {
        rd = new RubroDao();

        List<Rubro> sectores = new ArrayList<>();
        sectores = rd.listarRubro();
        model.addAttribute("sectorList", sectores);

        if (!busquedareq.getIdentificador().isEmpty()) {
            ppid = new ProyectoPreInversionDao();
            ProyectoPreInversion p = ppid.get(busquedareq.getIdentificador());
            if(p != null){
                 model.addAttribute("proyecto", p);
            } else {
                model.addAttribute("errorPIP", "El identificador no es válido");
            }
        } else {
            model.addAttribute("errorPIP", "El identificador no puede estar vacio");
        }

        return "reasignarPresupuesto";

    }

    @RequestMapping(value = "/ejecutarReasignar.htm", method = RequestMethod.POST)
    public String ejecutarReasignar(@ModelAttribute("busquedareq") BeanBusquedaIdentificador busquedareq,
            BindingResult result, Model model) {

        if (!(busquedareq == null)) {
            if (busquedareq.getCodigo() > 0
                    && (!(busquedareq.getTotal() == null) && busquedareq.getTotal() >= 0)) {
                ppid = new ProyectoPreInversionDao();
                ProyectoPreInversion p = ppid.get(busquedareq.getCodigo());
                p.setMontoComprometido(busquedareq.getTotal());
                ppid.update(p);
                model.addAttribute("errorPIP", "Se han guardado los cambios con éxito.");
                return "success";
            } else {
                rd = new RubroDao();
                List<Rubro> sectores = new ArrayList<>();
                sectores = rd.listarRubro();
                model.addAttribute("sectorList", sectores);
                BeanBusquedaIdentificador busquedareq2 = new BeanBusquedaIdentificador();
                if (busquedareq.getCodigo() > 0) {
                    ppid = new ProyectoPreInversionDao();
                    ProyectoPreInversion p = ppid.get(busquedareq.getIdentificador());
                    model.addAttribute("proyecto", p);
                }

                model.addAttribute("busquedareq", busquedareq2);
                model.addAttribute("errorPIP", "Faltan datos necesarios.");

                return "reasignarPresupuesto";
            }
        }
        return "reasignarPresupuesto";

    }

    @RequestMapping(value = "/comprometerPresupuesto.htm", method = RequestMethod.GET)
    public String comprometerPresupuesto(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        rd = new RubroDao();
        BeanBusquedaIdentificador busquedareq = new BeanBusquedaIdentificador();

        List<Rubro> sectores = new ArrayList<>();
        sectores = rd.listarRubro();

        model.addAttribute("busquedareq", busquedareq);
        model.addAttribute("sectorList", sectores);

        return "comprometerPresupuesto";

    }

    @RequestMapping(value = "/ejecutarComprometer.htm", method = RequestMethod.POST)
    public String ejecutarComprometer(@ModelAttribute("busquedareq") BeanBusquedaIdentificador busquedareq,
            BindingResult result, Model model) {
        if (busquedareq.getComprometer() == null || busquedareq.getComprometer() <= 0 || busquedareq.getCodigo() == 0) {
            rd = new RubroDao();

            List<Rubro> sectores = new ArrayList<>();
            sectores = rd.listarRubro();
            model.addAttribute("sectorList", sectores);
            model.addAttribute("busquedareq", busquedareq);
            model.addAttribute("errorPIP", "Debe indicar montos para los campos indicados");
            return "comprometerPresupuesto";

        } else {
            ppid = new ProyectoPreInversionDao();
            ProyectoPreInversion p = ppid.get(busquedareq.getCodigo());

            GestionProyecto gp = new GestionProyecto(p);
            gp.ComprometerPresupuesto(busquedareq.getComprometer());
            model.addAttribute("errorPIP", "Se han guardado los cambios con éxito.");

        }
        return "success";

    }

    @RequestMapping(value = "/buscarProyectoIdNoPresup.htm", method = RequestMethod.POST)
    public String buscarProyectoIdNoPresup(@ModelAttribute("busquedareq") BeanBusquedaIdentificador busquedareq,
            BindingResult result, Model model) {
        rd = new RubroDao();
        List<Rubro> sectores = new ArrayList<>();
        sectores = rd.listarRubro();
        model.addAttribute("sectorList", sectores);

        ppid = new ProyectoPreInversionDao();
        if (!busquedareq.getIdentificador().isEmpty()) {
            ProyectoPreInversion p = ppid.get(busquedareq.getIdentificador());
            if (p != null) {
                if (p.getMontoComprometido() != null && p.getMontoComprometido() > 0) {
                    model.addAttribute("errorPIP", "El proyecto ya tiene presupuesto asignado. Ir a Reasignar Presupuesto");
                } else {
                    model.addAttribute("proyecto", p);
                }
            } else {
                model.addAttribute("errorPIP", "Debe ingresar un identificador de proyecto válido");
            }
        } else {
            model.addAttribute("errorPIP", "El identificador no puede estar vacio");
        }

        return "comprometerPresupuesto";

    }
}
