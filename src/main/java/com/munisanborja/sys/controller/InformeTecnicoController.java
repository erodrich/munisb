/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package com.munisanborja.sys.controller;

import com.munisanborja.sys.dao.InformeTecnicoDao;

import com.munisanborja.sys.dao.RequerimientoDao;

import com.munisanborja.sys.model.bean.BeanBusquedaFecha;

import com.munisanborja.sys.model.entities.InformeTecnico;

import com.munisanborja.sys.model.entities.Requerimiento;

import com.munisanborja.sys.model.logic.GestionInformeTecnico;

import com.munisanborja.sys.model.logic.GestionRequerimiento;

import java.io.IOException;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

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
 *
 *
 * @author Juanka
 *
 */
@Controller

public class InformeTecnicoController {

    InformeTecnicoDao it;

    @RequestMapping(value = "/listarInformeTecnico.htm", method = RequestMethod.GET)

    public String listarInformeTecnico(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BeanBusquedaFecha busquedait = new BeanBusquedaFecha();

        model.addAttribute("busquedait", busquedait);

        return "listarInformeTecnico";

    }

    @RequestMapping(value = "/listarInformeTecnicoValidar.htm", method = RequestMethod.GET)

    public String listarInformeTecnicoValidar(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BeanBusquedaFecha busquedait = new BeanBusquedaFecha();

        model.addAttribute("busquedait", busquedait);

        return "listarInformeTecnicoValidar";

    }

    @RequestMapping(value = "/buscarInformeTecnico.htm", method = RequestMethod.POST)

    public String buscarInformeTecnico(@ModelAttribute("busquedait") BeanBusquedaFecha busquedait,
            BindingResult result, Model model) {
        
        it = new InformeTecnicoDao();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (busquedait.getFechaInicio() == null || busquedait.getFechaFinal() == null) {

            model.addAttribute("errorPIP", "Las fechas no pueden estar vacías");

        } else {

            if (busquedait.getFechaFinal().getTime() < busquedait.getFechaInicio().getTime()) {

                model.addAttribute("errorPIP", "El rango final debe ser superior al rango inicial");

            } else {

                List<InformeTecnico> list = it.listarInformeTecnico(df.format(busquedait.getFechaInicio()), df.format(busquedait.getFechaFinal())); // rd.listarRequerimiento(df.format(busquedareq.getFechaInicio()), df.format(busquedareq.getFechaFinal()));

                model.addAttribute("busquedait", busquedait);

                model.addAttribute("list", list);

            }

        }

        return "listarInformeTecnico";

    }

    @RequestMapping(value = "/buscarInformeTecnicoValidar.htm", method = RequestMethod.POST)

    public String buscarInformeTecnicoValidar(@ModelAttribute("busquedait") BeanBusquedaFecha busquedait,
            BindingResult result, Model model) {
        it = new InformeTecnicoDao();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (busquedait.getFechaInicio() == null || busquedait.getFechaFinal() == null) {

            model.addAttribute("errorPIP", "Las fechas no pueden estar vacías");

        } else {

            if (busquedait.getFechaFinal().getTime() < busquedait.getFechaInicio().getTime()) {

                model.addAttribute("errorPIP", "El rango final debe ser superior al rango inicial");

            } else {

                List<InformeTecnico> list = it.listarInformeTecnico(df.format(busquedait.getFechaInicio()), df.format(busquedait.getFechaFinal())); // rd.listarRequerimiento(df.format(busquedareq.getFechaInicio()), df.format(busquedareq.getFechaFinal()));

                model.addAttribute("busquedait", busquedait);

                model.addAttribute("list", list);

            }

        }

        return "listarInformeTecnicoValidar";

    }

    @RequestMapping(value = "/detalleInformeTecnico/{codigo}.htm", method = RequestMethod.GET)

    public String detalleInformeTecnico(Model model, HttpServletRequest request, HttpServletResponse response, @PathVariable String codigo) {

        InformeTecnico informetecnico = it.get(Integer.parseInt(codigo));

        model.addAttribute("informetecnico", informetecnico);

        //BeanBusquedaRequerimiento busquedareq = new BeanBusquedaRequerimiento();
        //model.addAttribute("busquedareq", busquedareq);
        return "detalleInformeTecnico";

    }

    @RequestMapping(value = "/detalleInformeTecnicoValidar/{codigo}.htm", method = RequestMethod.GET)

    public String detalleInformeTecnicoValidar(Model model, HttpServletRequest request, HttpServletResponse response, @PathVariable String codigo) {

        InformeTecnico informetecnico = it.get(Integer.parseInt(codigo));

        model.addAttribute("informetecnico", informetecnico);

        //BeanBusquedaRequerimiento busquedareq = new BeanBusquedaRequerimiento();
        //model.addAttribute("busquedareq", busquedareq);
        return "detalleInformeTecnicoValidar";

    }

    @RequestMapping(value = "/resumenEvaluacionValidar/{codigo}.htm", method = RequestMethod.GET)

    public String resumenEvaluacion(Model model, HttpServletRequest request, HttpServletResponse response, @PathVariable String codigo) {

        it = new InformeTecnicoDao();

        InformeTecnico informetecnico = it.get(Integer.parseInt(codigo));

        GestionInformeTecnico gr = new GestionInformeTecnico();

        gr.validarInformeTecnico(informetecnico);

        model.addAttribute("informetecnico", informetecnico);

        model.addAttribute("gr", gr);

        return "resumenEvaluacionValidar";

    }

}
