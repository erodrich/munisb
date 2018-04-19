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
        <title>Sistema de Gestión Municipal</title>
    </head>
    <body>

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

            <h2>Listar Informe Técnico</h2>
            <p>
                <form:form action="buscarInformeTecnico.htm" method="POST" modelAttribute="busquedait">

                <div class="input-group">
                    <label for="fechaInicio" class="col-form-label">Fecha Inicio:&nbsp;&nbsp;&nbsp;</label>
                    <form:input type="text" class="form-control-sm" path="fechaInicio" placeholder="YYYY-MM-DD" />
                    <form:errors path="fechaInicio" cssClass="error"><span style="color: red; font-weight: bold; ">Campo requerido</span></form:errors>
                        <label for="fechaInicio" class="col-form-label">&nbsp;&nbsp;&nbsp;Fecha Final:&nbsp;&nbsp;&nbsp;</label>
                    <form:input type="text" class="form-control-sm" path="fechaFinal" placeholder="YYYY-MM-DD" />
                    <form:errors path="fechaFinal" cssClass="error"><span style="color: red; font-weight: bold; ">Campo requerido</span></form:errors>
                        <button type="submit" class="btn btn-primary  btn-sm">Buscar</button>
                    </div>

            </form:form>
                
            </p>
            
            <br />
            <table class="table table-striped" style="font-size: smaller; padding-left: 10px; padding-right: 10px;">
                <thead>
                    <tr style="text-align: center;">
                        <th>Identificador PIP</th>
                        <th>Nombre</th>
                        <th>Fecha Creación</th>
                        <th>Fecha Aprobacion</th>
                        <th>Estado Tramite</th>
                    </tr>
                </thead>
                <c:forEach var="epip" items="${list}">
                    <tr style="text-align: center;">
                        <td><a href="${pageContext.request.contextPath}/detalleInformeTecnico/${epip.codigo}.htm">${epip.proyectoPreInversion.identificador}</a></td>
                        <td>${epip.nombre}</td>
                        <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${epip.fechaCreacion}" /></td>
                        <td><fmt:formatDate pattern = "yyyy-MM-dd" value = "${epip.fechaAprobacion}" /></td>
                        <td>${epip.proyectoPreInversion.estadoTramite.nombre}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
            <%@include file="includes/footer.jsp" %>
    </body>
</html>

