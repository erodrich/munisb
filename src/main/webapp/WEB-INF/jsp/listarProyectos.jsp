<%-- 
    Document   : reasignarPresupuesto
    Created on : 27/03/2018, 02:52:47 AM
    Author     : OPERADOR
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
        <title>Listar Proyectos</title>
    </head>
    <body>
<fmt:setLocale value="es_PE" scope="session"/>
        <div class="container">
            <%@include file="includes/navbar.jsp" %>
            <c:if test="${not empty errorPIP}">
                <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                    <strong>${errorPIP}</strong>
                </div>
            </c:if>            

            <form:form action="buscarProyecto.htm" method="POST" modelAttribute="busquedareq">

                <div class="input-group">
                    <label for="fechaInicio" class="col-form-label">Fecha Inicio:&nbsp;&nbsp;&nbsp;</label>
                    <form:input type="text" class="form-control-sm" path="fechaInicio" placeholder="YYYY-MM-DD" />
                    <form:errors path="fechaInicio" cssClass="error"><span style="color: red; font-weight: bold; ">Campo requerido</span></form:errors>
                        <label for="fechaInicio" class="col-form-label">&nbsp;&nbsp;&nbsp;Fecha Final:&nbsp;&nbsp;&nbsp;</label>
                    <form:input type="text" class="form-control-sm" path="fechaFinal" placeholder="YYYY-MM-DD" />
                    <form:errors path="fechaFinal" cssClass="error"><span style="color: red; font-weight: bold; ">Campo requerido</span></form:errors>
                        <button type="submit" class="btn btn-primary  btn-sm">Buscar</button>
                    </div>

                    <br/>
                    <table class="table table-striped" style="font-size: smaller; padding-left: 10px; padding-right: 10px;">
                        <thead>
                            <tr style="text-align: center;">
                                <th>Identificador</th>
                                <th>Nombre</th>
                                <th>Comprometido</th>
                                <th>Devengado</th>
                                <th>Ejecutado</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                    <c:forEach var="proyecto" items="${list}">
                        <tr style="text-align: center;">
                            <td>${proyecto.identificador}</td>
                            <td>${proyecto.requerimiento.nombre}</td>
                            <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${proyecto.montoComprometido}" /></td>
                            <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${proyecto.montoDevengado}" /></td>
                            <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${proyecto.montoEjecutado}" /></td>
                            <td><fmt:formatNumber type="currency" maxFractionDigits="2" value="${proyecto.montoComprometido - proyecto.montoDevengado- proyecto.montoEjecutado}" /></td>
                        </tr>
                    </c:forEach>
                </table>
            </form:form>

        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
