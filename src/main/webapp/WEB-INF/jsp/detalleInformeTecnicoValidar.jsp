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

        <title>Detalle - Sistema de Gestión Municipal - Versión 1.1</title>
    </head>
    <body>
        <fmt:setLocale value="es_PE" scope="session"/>
        <div class="container">
            <%@include file="includes/navbar.jsp" %>
            <!-- Outter Card-->
            <div class="card">
                <div class="card-body">
                    <h2>Detalle Informe Técnico</h2>
                </div>
                <!-- Row 1 -->
                <div class="row">
                    <div class="col-sm-8">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Nombre:
                            </div>
                            <div class="card-body">
                                ${informetecnico.nombre}
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Identificador de Proyecto:
                            </div>
                            <div class="card-body">
                                ${informetecnico.proyectoPreInversion.identificador}
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Row 2 -->
                <div class="row">
                    <div class="col-sm-4">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Identificador de Requerimiento:
                            </div>
                            <div class="card-body">
                                ${informetecnico.proyectoPreInversion.requerimiento.identificador}
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Monto Asignado:
                            </div>
                            <div class="card-body">
                                <fmt:formatNumber type="currency" 
                                                  maxFractionDigits="0" value="${informetecnico.proyectoPreInversion.montoComprometido}" />

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Estado Trámite:
                            </div>
                            <div class="card-body">
                                ${informetecnico.proyectoPreInversion.estadoTramite.nombre}
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Row 3 -->
                <div class="row">
                    <div class="col-md-12">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Nombre Requerimiento:
                            </div>
                            <div class="card-body">
                                ${informetecnico.proyectoPreInversion.requerimiento.nombre}
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Fecha Declaración Viabilidad: 
                                    <span class="float-right">
                                        <fmt:formatDate pattern = "yyyy-MM-dd" value = "${informetecnico.proyectoPreInversion.fechaDeclaracionViabilidad}" />
                                    </span> 
                                </li>
                                <li class="list-group-item">Fecha Creación: 
                                    <span class="float-right">
                                        <fmt:formatDate pattern = "yyyy-MM-dd" value = "${informetecnico.fechaCreacion}" />
                                    </span> 
                                </li>
                                <li class="list-group-item">Fecha Actualización: 
                                    <span class="float-right">
                                        <fmt:formatDate pattern = "yyyy-MM-dd" value = "${informetecnico.fechaActualizacion}" />
                                    </span> 
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Aprobado por: <span class="float-right">${informetecnico.aprobadoPor}</span> </li>
                                <li class="list-group-item">Elaborado por: <span class="float-right">${informetecnico.elaboradoPor}</span> </li>
                                <li class="list-group-item">Revisado por: <span class="float-right">${informetecnico.revisadoPor}</span> </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="col-md-4">
                            <a class="btn btn-primary btn-lg" 
                               href="${pageContext.request.contextPath}/resumenEvaluacionValidar/${informetecnico.codigo}.htm"
                               role="button">
                                Viabilizar Informe Técnico
                            </a>
                            <button type="button" class="btn btn-danger btn-lg" onclick="javascript:history.back();">Retornar</button>
                        </div>


                    </div>
                </div>
            </div>


        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>

