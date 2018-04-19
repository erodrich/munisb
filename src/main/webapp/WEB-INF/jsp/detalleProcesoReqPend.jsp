<%-- 
    Document   : detalleProcesoReqPend
    Created on : 05/04/2018, 03:12:27 PM
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

            <div class="card">
                <div class="card-body">   
                    <h2>Evaluar Proceso de Requerimiento</h2>
                </div>
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
                    <div class="col-md-4">
                        <div class="card">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Identificador:
                                    <span class="float-right">
                                        ${requerimiento.identificador}
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
                <form:form method="POST" modelAttribute="busquedareq">
                    <input type="hidden" name="codigo" value="${requerimiento.codigo}"/>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="tipoProyecto" class="col-sm-10 col-form-label">Tipo de Proyecto</label>
                                <div class="col-md-12">
                                    <form:select path="sector" id="select_id" cssClass="form-control">
                                        <form:options items="${sectores}" itemValue="nombre" itemLabel="nombre" />
                                    </form:select>
                                </div>
                                <label for="impuestorenta" class="col-sm-10 col-form-label">Impuesto a la renta</label>
                                <div class="col-md-12">
                                    <input type="number" path="impuestorenta" name="impuestorenta"
                                           min="0"
                                           max="100"
                                           step="0.01"
                                           class="form-control" 
                                           id="impuestorenta" 
                                           placeholder="">
                                </div>
                                <label for="costomanoobrac" class="col-sm-10 col-form-label">Costo mano de obra calificada</label>
                                <div class="col-md-12">
                                    <input type="number" path="costomanoobrac" name="costomanoobrac"
                                           min="0"
                                           step="0.01"
                                           class="form-control" 
                                           id="costomanoobrac" placeholder="">
                                </div>
                                <label  for="costomanoobranc" class="col-sm-10 col-form-label">Costo mano de obra no calificada</label>
                                <div class="col-md-12">
                                    <input type="number" path="costomanoobranc" name="costomanoobranc"
                                           min="0"
                                           step="0.01"
                                           class="form-control" 
                                           id="costomanoobranc" placeholder="">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label  for="fcostomanoobrac" class="col-sm-10 col-form-label">Factor mano de obra calificada:</label>
                                <div class="col-md-12">
                                    <input type="number" path="fcostomanoobrac" name="fcostomanoobrac"
                                           min="0"
                                           step="0.01"
                                           class="form-control" 
                                           id="fcostomanoobrac" 
                                           placeholder=""
                                           readonly="true">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  for="fcostomanoobranc" class="col-sm-10 col-form-label">Factor mano de obra no calificada:</label>
                                <div class="col-md-12">
                                    <input type="number" path="fcostomanoobranc" name="fcostomanoobranc"
                                           min="0"
                                           step="0.01"
                                           class="form-control" 
                                           id="fcostomanoobranc" 
                                           readonly="true">
                                </div>
                            </div>
                            <div class="form-group ">
                                <div class="row-md-8 ">
                                    <button type="submit" class="btn btn-primary btn-lg" formaction="${pageContext.request.contextPath}/ejecutarEvaluarProceso.htm" id="btnguardar">Guardar</button>
                                    <button type="button" class="btn btn-info btn-lg" onclick="javascript:calculo_factores();">Calcular</button>&nbsp;
                                    <button type="button" class="btn btn-danger btn-lg" onclick="javascript:history.back();">Retornar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>                

            </form:form>
        </div>
        <script type="text/javascript">
            function calculo_factores() { //costo mano obra califica * (1/(1+impuesto a la renta));
                ir = document.getElementById("impuestorenta").value;
                cmoc = document.getElementById("costomanoobrac").value;
                cmonc = document.getElementById("costomanoobranc").value;

                document.getElementById("fcostomanoobrac").value = ir * cmoc / 100;
                document.getElementById("fcostomanoobranc").value = ir * cmonc / 100;

                //alert(ir * cmoc / 100);
            }
        </script>

        <%@include file="includes/footer.jsp" %>
    </body>
</html>
