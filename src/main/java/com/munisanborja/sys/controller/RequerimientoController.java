/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.controller;

import com.munisanborja.sys.dao.RequerimientoDao;
import com.munisanborja.sys.model.bean.BeanBusquedaFecha;
import com.munisanborja.sys.model.bean.BeanBusquedaIdentificador;
import com.munisanborja.sys.model.entities.Requerimiento;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author Eric
 */
@Controller
public class RequerimientoController {

    RequerimientoDao rd = new RequerimientoDao();

    @RequestMapping(value = "/listarRequerimiento.htm", method = RequestMethod.GET)
    public String listarRequerimiento(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println("Pruebaaaaaaa");
        BeanBusquedaFecha busquedareq = new BeanBusquedaFecha();
        model.addAttribute("busquedareq", busquedareq);

        return "listarRequerimiento";

    }
    
    @RequestMapping(value = "/validarRequerimiento.htm", method = RequestMethod.GET)
    public String validarRequerimiento(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println("Pruebaaaaaaa");
        BeanBusquedaIdentificador busquedareq = new BeanBusquedaIdentificador();
        model.addAttribute("busquedareq", busquedareq);

        return "validarRequerimiento";

    }
    
    @RequestMapping(value = "/buscarRequerimientoIdentificador.htm", method = RequestMethod.POST)
    public String buscarRequerimientoIdentificador(@ModelAttribute("busquedareq") BeanBusquedaIdentificador busquedareq,
            BindingResult result, Model model) {

        rd = new RequerimientoDao();
        
        if(!busquedareq.getIdentificador().isEmpty()){
            Requerimiento r = rd.get(busquedareq.getIdentificador());
            model.addAttribute("requerimiento", r);
        } else {
            model.addAttribute("errorPIP", "El identificador no puede estar vacio");
        }
        

        return "validarRequerimiento";

    }

    @RequestMapping(value = "/buscarRequerimiento.htm", method = RequestMethod.POST)
    public String buscarRequerimiento(@ModelAttribute("busquedareq") BeanBusquedaFecha busquedareq,
            BindingResult result, Model model) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (busquedareq.getFechaInicio() == null || busquedareq.getFechaFinal() == null) {
            model.addAttribute("errorPIP", "Las fechas no pueden estar vacías");
        } else {

            if (busquedareq.getFechaFinal().getTime() < busquedareq.getFechaInicio().getTime()) {
                model.addAttribute("errorPIP", "El rango final debe ser superior al rango inicial");
            } else {

                List<Requerimiento> list = rd.listarRequerimiento(df.format(busquedareq.getFechaInicio()), df.format(busquedareq.getFechaFinal()));
                model.addAttribute("busquedareq", busquedareq);

                model.addAttribute("list", list);
            }

        }

        return "listarRequerimiento";

    }

    @RequestMapping(value = "/detalleRequerimiento/{codigo}.htm", method = RequestMethod.GET)
    public String detalleRequerimiento(Model model, HttpServletRequest request, HttpServletResponse response, @PathVariable String codigo) {
        rd = new RequerimientoDao();
        Requerimiento requerimiento = rd.get(Integer.parseInt(codigo));

        model.addAttribute("requerimiento", requerimiento);

        //BeanBusquedaRequerimiento busquedareq = new BeanBusquedaRequerimiento();
        //model.addAttribute("busquedareq", busquedareq);
        return "detalleRequerimiento";

    }
    
    @RequestMapping(value = "/evaluacionRequerimiento/{codigo}.htm", method = RequestMethod.GET)
    public String evaluacionRequerimiento(Model model, HttpServletRequest request, HttpServletResponse response, @PathVariable String codigo) {
        rd = new RequerimientoDao();
        Requerimiento requerimiento = rd.get(Integer.parseInt(codigo));

        model.addAttribute("requerimiento", requerimiento);

        //BeanBusquedaRequerimiento busquedareq = new BeanBusquedaRequerimiento();
        //model.addAttribute("busquedareq", busquedareq);
        return "evaluacionRequerimiento";
    }
    
    @RequestMapping(value = "/resumenEvaluacion/{codigo}.htm", method = RequestMethod.GET)
    public String resumenEvaluacion(Model model, HttpServletRequest request, HttpServletResponse response, @PathVariable String codigo) {

        rd = new RequerimientoDao();
        Requerimiento requerimiento = rd.get(Integer.parseInt(codigo));
        
        GestionRequerimiento gr = new GestionRequerimiento();
        gr.validarRequerimiento(requerimiento);
            
        model.addAttribute("requerimiento", requerimiento);
        model.addAttribute("gr", gr);
        
        return "resumenEvaluacion";

    }    
    
    
    @RequestMapping(value = "/cancel.htm", method = RequestMethod.GET)
    public String cancelEstudioPIP() {
        return "redirect:/listarRequerimiento.htm";
    }    
    
}
