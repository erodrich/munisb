/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.munisanborja.sys.controller;

import com.munisanborja.sys.dao.RequerimientoDao;
import com.munisanborja.sys.dao.RubroDao;
import com.munisanborja.sys.model.bean.BeanBusquedaFecha;
import com.munisanborja.sys.model.bean.BeanBusquedaIdentificador;
import com.munisanborja.sys.model.entities.Requerimiento;
import com.munisanborja.sys.model.entities.RequerimientoEvaluado;
import com.munisanborja.sys.model.entities.Rubro;
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
 * @author Eric
 */
@Controller
public class ProcesoController {

    RequerimientoDao rd;
    RubroDao st;

    @RequestMapping(value = "/listarProceso.htm", method = RequestMethod.GET)
    public String listarRequerimiento(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BeanBusquedaFecha busquedareq = new BeanBusquedaFecha();
        model.addAttribute("busquedareq", busquedareq);

        return "listarProceso";

    }

    @RequestMapping(value = "/detalleProcesoReq/{codigo}.htm", method = RequestMethod.GET)
    public String detalleRequerimiento(Model model, HttpServletRequest request, HttpServletResponse response, @PathVariable String codigo) {
        rd = new RequerimientoDao();
        Requerimiento requerimiento = rd.get(Integer.parseInt(codigo));

        model.addAttribute("requerimiento", requerimiento);

        return "detalleProcesoReq";

    }

    @RequestMapping(value = "/buscarProcesoReq.htm", method = RequestMethod.POST)
    public String buscarProcesoReq(@ModelAttribute("busquedareq") BeanBusquedaFecha busquedareq,
            BindingResult result, Model model) {

        rd = new RequerimientoDao();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (busquedareq.getFechaInicio() == null || busquedareq.getFechaFinal() == null) {
            model.addAttribute("errorPIP", "Las fechas no pueden estar vacías");
        } else {

            if (busquedareq.getFechaFinal().getTime() < busquedareq.getFechaInicio().getTime()) {
                model.addAttribute("errorPIP", "El rango final debe ser superior al rango inicial");
            } else {

                //List<Requerimiento> list = rd.listarRequerimiento(df.format(busquedareq.getFechaInicio()), df.format(busquedareq.getFechaFinal()));
                List<Requerimiento> list = rd.listarProcesoReq(df.format(busquedareq.getFechaInicio()), df.format(busquedareq.getFechaFinal()));
                model.addAttribute("busquedareq", busquedareq);

                model.addAttribute("list", list);
            }

        }
        return "listarProceso";
    }

    @RequestMapping(value = "/evaluarProceso.htm", method = RequestMethod.GET)
    public String evaluarProceso(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BeanBusquedaFecha busquedareq = new BeanBusquedaFecha();
        model.addAttribute("busquedareq", busquedareq);

        return "evaluarProceso";

    }

    @RequestMapping(value = "/buscarProcesoReqPend.htm", method = RequestMethod.POST)
    public String buscarProcesoReqPend(@ModelAttribute("busquedareq") BeanBusquedaFecha busquedareq,
            BindingResult result, Model model) {

        rd = new RequerimientoDao();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (busquedareq.getFechaInicio() == null || busquedareq.getFechaFinal() == null) {
            model.addAttribute("errorPIP", "Las fechas no pueden estar vacías");
        } else {

            if (busquedareq.getFechaFinal().getTime() < busquedareq.getFechaInicio().getTime()) {
                model.addAttribute("errorPIP", "El rango final debe ser superior al rango inicial");
            } else {

                //List<Requerimiento> list = rd.listarRequerimiento(df.format(busquedareq.getFechaInicio()), df.format(busquedareq.getFechaFinal()));
                List<Requerimiento> list = rd.listarProcesoReqPend(df.format(busquedareq.getFechaInicio()), df.format(busquedareq.getFechaFinal()));
                model.addAttribute("busquedareq", busquedareq);

                model.addAttribute("list", list);
            }

        }
        return "evaluarProceso";
    }

    @RequestMapping(value = "/detalleProcesoReqPend/{codigo}.htm", method = RequestMethod.GET)
    public String detalleProcesoReqPend(Model model, HttpServletRequest request, HttpServletResponse response, @PathVariable String codigo) {
        rd = new RequerimientoDao();
        Requerimiento requerimiento = rd.get(Integer.parseInt(codigo));

        List<Rubro> sectores = new RubroDao().listarRubro();

        BeanBusquedaIdentificador busquedareq = new BeanBusquedaIdentificador();

        model.addAttribute("busquedareq", busquedareq);
        model.addAttribute("sectores", sectores);
        model.addAttribute("requerimiento", requerimiento);

        return "detalleProcesoReqPend";

    }

    @RequestMapping(value = "/ejecutarEvaluarProceso.htm", method = RequestMethod.POST)
    public String ejecutarEvaluarProceso(@ModelAttribute("busquedareq") BeanBusquedaIdentificador busquedareq,
            BindingResult result, Model model) {
        st = new RubroDao();
        rd = new RequerimientoDao();

        if ((busquedareq.getImpuestorenta() == null || busquedareq.getImpuestorenta() <= 0)
                || (busquedareq.getCostomanoobrac() == null || busquedareq.getCostomanoobrac() <= 0)
                || (busquedareq.getCostomanoobranc() == null || busquedareq.getCostomanoobranc() <= 0)) {
            model.addAttribute("errorPIP", "Debe indicar montos para los campos indicados");
            
        } else {
            Requerimiento req = rd.get(busquedareq.getCodigo());
            req.setTipo(busquedareq.getSector());

            RequerimientoEvaluado rEv = new RequerimientoEvaluado();
            rEv.setImpuestoRenta(busquedareq.getImpuestorenta());
            rEv.setcManoObraCalificada(busquedareq.getCostomanoobrac());
            rEv.setcManoObraNoCalificada(busquedareq.getCostomanoobranc());

            rEv.setFactorManoObraCalificada(busquedareq.getFcostomanoobrac());
            rEv.setFactorManoObraNoCalificada(busquedareq.getFcostomanoobranc());

            req.setRequerimientoEvaluado(rEv);
            rd.update(req);
            return "redirect:/detalleProcesoReq/" + busquedareq.getCodigo() + ".htm";
        }
        return "error";

    }

}
