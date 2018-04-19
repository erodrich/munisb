<%-- 
    Document   : reasignarPresupuesto
    Created on : 27/03/2018, 04:59:10 AM
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

        <title>Reasignar Presupuesto</title>
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

            <form:form method="POST" modelAttribute="busquedareq">
                <div class="form-group">
                    <label for="identificador" class="col-form-label">Identificador:&nbsp;&nbsp;&nbsp;</label>
                    <form:input type="text" class="form-control-sm" path="identificador" placeholder="PXXXXX" />
                    <form:errors path="identificador" cssClass="error"><span style="color: red; font-weight: bold; ">Campo requerido</span></form:errors>
                    <button type="submit" formaction="${pageContext.request.contextPath}/buscarProyectoIdentificador.htm"  class="btn btn-primary  btn-sm">Buscar</button>
                </div>
            </form:form>
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">Identificador:
                                <span class="float-right">
                                    ${proyecto.identificador}
                                </span>
                            </li>
                            <li class="list-group-item">Comprometido:
                                <span class="float-right">
                                    <fmt:formatNumber type="currency" maxFractionDigits="0" value="${proyecto.montoComprometido}" />
                                </span>
                            </li>
                            <li class="list-group-item">Devengado:
                                <span class="float-right">
                                    <fmt:formatNumber type="currency" maxFractionDigits="0" value="${proyecto.montoDevengado}" />
                                </span>
                            </li>
                            <li class="list-group-item">Ejecutado:
                                <span class="float-right">
                                    <fmt:formatNumber type="currency" maxFractionDigits="0" value="${proyecto.montoEjecutado}" />
                                </span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-6">
                    <form:form method="POST" modelAttribute="busquedareq">
                        <input type="hidden" name="codigo" value="${proyecto.codigo}"/>
                        <div class="form-group">
                            <label for="porcentaje">% a Reasignar</label>
                            <input type="number" 
                                   min="0"
                                   max="100"
                                   step="0.01"
                                   class="form-control" 
                                   id="porcentaje" 
                                   name="porcentaje"  />
                        </div>

                        <div class="form-group">
                            <label for="sector">Sector</label>
                            <form:select path="sector" id="select_id" cssClass="form-control">
                                <form:options items="${sectorList}" itemValue="codigo" itemLabel="nombre" />
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="total">Total</label>
                            <input type="number" step="0.01" class="form-control" id="total" name="total" readonly="true" />
                        </div>
                        <button type="button" class="btn btn-info btn-lg" id="calcular" onclick="calc()">Calcular</button>
                        <button type="submit" formaction="${pageContext.request.contextPath}/ejecutarReasignar.htm" class="btn btn-primary btn-lg" id="reasignar">Reasginar</button>

                    </form:form>
                </div>
            </div> 
            <script>
                function calc() {
                    //var comp = document.getElementById("comprometido").textContent;
                    var comp = ${proyecto.montoComprometido}
                    var porc = document.getElementById("porcentaje").value;
                    var x = comp - ((comp*porc)/100);
                   
                    //resultado = comprometido + (comprometido*porcentage/100)
                    document.getElementById("total").setAttribute('value', x);

                }
            </script>
            <%@include file="includes/footer.jsp" %>
    </body>
</html>
