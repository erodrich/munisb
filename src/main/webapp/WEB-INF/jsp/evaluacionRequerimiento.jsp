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

        <title>Evaluar - Sistema de Gestión Municipal - Versión 1.1</title>
    </head>
    <body>

        <fmt:setLocale value="es_PE" scope="session"/>
        <div class="container">
            <%@include file="includes/navbar.jsp" %>
            <!-- Outter Card-->
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

                <!-- Row 2 -->
                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Costo de operación: 
                                    <span class="float-right">
                                        <fmt:formatNumber type="currency" maxFractionDigits="0" value="${requerimiento.costoOperacion}" />
                                    </span> 
                                </li>
                                <li class="list-group-item">Costo de Mantenimiento: 
                                    <span class="float-right">
                                        <fmt:formatNumber type="currency" maxFractionDigits="0" value="${requerimiento.costoMantenimiento}" />
                                    </span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Unidad Ejecutora: 
                                    <span class="float-right">
                                        ${requerimiento.unidadEjecutoraRecomendada}
                                    </span> 
                                </li>
                                <li class="list-group-item">Programa de Inversión: 
                                    <span class="float-right">
                                        <c:choose>
                                            <c:when test="${requerimiento.programaInversion}">
                                                Si
                                            </c:when>
                                            <c:otherwise>
                                                No
                                            </c:otherwise>
                                        </c:choose>
                                    </span> 
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- Row 3 Full Width -->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Objetivo:
                            </div>
                            <div class="card-body">
                                ${requerimiento.objetivo}
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Row 3 Full Width -->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Problemática:
                            </div>
                            <div class="card-body">
                                ${requerimiento.problema}
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Row 3 Full Width -->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Análisis de sostenibilidad:
                            </div>
                            <div class="card-body">
                                ${requerimiento.analisisSostenibilidad}
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Row 4 Full Width -->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Fuente de Financiamiento:
                            </div>
                            <div class="card-body">
                                ${requerimiento.fuenteFinanciamiento}
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Row 4 Fechas -->
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Fecha Aprobación: 
                                    <span class="float-right">
                                        <fmt:formatDate pattern = "yyyy-MM-dd" value = "${requerimiento.fechaAprobacion}" />
                                    </span> 
                                </li>
                                <li class="list-group-item">Fecha Creación: 
                                    <span class="float-right">
                                        <fmt:formatDate pattern = "yyyy-MM-dd" value = "${requerimiento.fechaCreacion}" />
                                    </span> 
                                </li>
                                <li class="list-group-item">Fecha Rechazo: 
                                    <span class="float-right">
                                        <fmt:formatDate pattern = "yyyy-MM-dd" value = "${requerimiento.fechaRechazo}" />
                                    </span> 
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Aprobado por: <span class="float-right">${requerimiento.aprobadoPor}</span> </li>
                                <li class="list-group-item">Elaborado por: <span class="float-right">${requerimiento.elaboradoPor}</span> </li>
                                <li class="list-group-item">Revisado por: <span class="float-right">${requerimiento.revisadoPor}</span> </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4 align-self-center">
                      <a href="${pageContext.request.contextPath}/resumenEvaluacion/${requerimiento.codigo}.htm">
                        <button type="button" class="btn btn-primary btn-lg">
                          Evaluar Requerimiento
                        </button>
                      </a>
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