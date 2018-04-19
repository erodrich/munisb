<%-- 
    Document   : comprometerPresupuesto
    Created on : 03/04/2018, 03:18:57 AM
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
        <title>Comprometer Presupuesto</title>
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
                    <button type="submit" formaction="${pageContext.request.contextPath}/buscarProyectoIdNoPresup.htm"  class="btn btn-primary btn-sm">Buscar</button>
                </div>
            </form:form>
            <div class="card">
                <div class="card-body">
                    <c:if test="${not empty proyecto}">
                        <h5>Proyecto: </h5>
                        <h6>${proyecto.requerimiento.nombre}</h6>
                    </c:if>
                </div>
                <form:form method="POST" modelAttribute="busquedareq">
                    <div class="row">
                        <input type="hidden" name="codigo" value="${proyecto.codigo}"/>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <label for="sector">Sector</label>
                                    <form:select cssClass="form-control" path="sector" id="sector">
                                        <form:options items="${sectorList}" itemValue="codigo" itemLabel="nombre" />
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <label for="comprometer">Monto a comprometer</label>
                                    <input type="number" 
                                           min="0"
                                           step="0.01"
                                           class="form-control" 
                                           id="comprometer" 
                                           name="comprometer"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <label for="montoDisponible">Monto disponible</label>
                                    <input type="text" class="form-control" id="montoDisponible" name="montoDisponible" readonly="true" />
                                </div>
                            </div>
                            <div class="col-md-12 ">
                                <div class="text-center">
                                    <button type="submit" formaction="${pageContext.request.contextPath}/ejecutarComprometer.htm" class="btn btn-primary btn-lg" id="guardar">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>

        </div> 
        <script type="text/javascript">


            document.getElementById("sector").addEventListener("change", function () {

                var select = document.getElementById("sector").value;
                var monto = document.getElementById("montoDisponible");
                switch (select) {
                    case "1":
                        monto.value = "235,000";
                        break;
                    case "2":
                        monto.value = "150,000";
                        break;
                    case "3":
                        monto.value = "324,580";
                        break;
                    case "4":
                        monto.value = "321,098";
                        break;
                    case "5":
                        monto.value = "129,000";
                        break;
                }
            });


        </script>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
