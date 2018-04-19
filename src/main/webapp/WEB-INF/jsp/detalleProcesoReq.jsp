<%-- 
    Document   : detalleProcesoReq
    Created on : 05/04/2018, 01:33:03 PM
    Author     : Eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>      

        <title>Detalle Requerimiento Procesado</title>
    </head>
    <body>
        <fmt:setLocale value="es_PE" scope="session"/>
        <div class="container">
            <%@include file="includes/navbar.jsp" %>
            <div class="card">
                <div class="card-body">
                    <h2>Detalle de Requerimiento</h2>
                </div>
                <!-- Row 1 Presentacion-->
                <div class="row">
                    <div class="col-sm-8">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Nombre:
                            </div>
                            <div class="card-body">
                                ${requerimiento.nombre}
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Identificador:
                            </div>
                            <div class="card-body">
                                ${requerimiento.identificador}
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Tipo de Proyecto:
                                    <span class="float-right">
                                        ${requerimiento.tipo}
                                    </span>
                                </li>
                                <li class="list-group-item">Impuesto a la renta:
                                    <span class="float-right">
                                        % <fmt:formatNumber type="number" maxFractionDigits="2" value="${requerimiento.requerimientoEvaluado.impuestoRenta}" />
                                    </span>
                                </li>
                                <li class="list-group-item">Costo mano de obra calificada:
                                    <span class="float-right">
                                        <fmt:formatNumber type="currency" maxFractionDigits="0" value="${requerimiento.requerimientoEvaluado.cManoObraCalificada}" />
                                    </span>
                                </li>
                                <li class="list-group-item">Costo mano de obra no calificada:
                                    <span class="float-right">
                                        <fmt:formatNumber type="currency" maxFractionDigits="0" value="${requerimiento.requerimientoEvaluado.cManoObraNoCalificada}" />
                                    </span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Factor mano de obra calificada:
                                    <span class="float-right">
                                        <fmt:formatNumber type="currency" maxFractionDigits="2" value="${requerimiento.requerimientoEvaluado.factorManoObraCalificada}" />

                                    </span>
                                </li>
                                <li class="list-group-item">Factor mano de obra no calificada:
                                    <span class="float-right">
                                        <fmt:formatNumber type="currency" maxFractionDigits="2" value="${requerimiento.requerimientoEvaluado.factorManoObraNoCalificada}" />

                                    </span>
                                </li>
                                <li class="list-group-item">Fecha de creación:
                                    <span class="float-right">
                                        <fmt:formatDate pattern = "yyyy-MM-dd" value = "${requerimiento.fechaCreacion}" />
                                    </span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-3  text-center">
                        <button type="button" class="btn btn-danger btn-lg" onclick="javascript:history.back();">
                            Retornar
                        </button>
                    </div>
                </div>


            </div>

        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
