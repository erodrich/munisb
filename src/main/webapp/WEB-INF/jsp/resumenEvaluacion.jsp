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
        <title>Evaluacion</title>
    </head>
    <body>

        <div class="container">
            <%@include file="includes/navbar.jsp" %>

            <div class="card">
                <div class="card-body">   
                    <h2>Resultado de Evaluación</h2>
                </div>
                <div class="row">
                    <div class="col-sm-10">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Nombre:
                            </div>
                            <div class="card-body">
                                ${requerimiento.nombre}
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.nombreValid}">
                                        </c:when>
                                        <c:otherwise>
                                            Nombre no corresponde
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.nombreValid}">
                                <img src="${pageContext.request.contextPath}/images/check.png" alt="" width="16"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/images/cancel.png" alt="" width="16"/>
                            </c:otherwise>
                        </c:choose>   
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-10">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Objetivo:
                            </div>
                            <div class="card-body">
                                ${requerimiento.objetivo}
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.objetivoValid}">
                                        </c:when>
                                        <c:otherwise>
                                            Objetivo no corresponde
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.objetivoValid}">
                                <img src="${pageContext.request.contextPath}/images/check.png" alt="" width="16"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/images/cancel.png" alt="" width="16"/>
                            </c:otherwise>
                        </c:choose>   
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-10">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Problema:
                            </div>
                            <div class="card-body">
                                ${requerimiento.problema}
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.problemaValid}">
                                        </c:when>
                                        <c:otherwise>
                                            Problema no corresponde
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.problemaValid}">
                                <img src="${pageContext.request.contextPath}/images/check.png" alt="" width="16"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/images/cancel.png" alt="" width="16"/>
                            </c:otherwise>
                        </c:choose>   
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-10">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Ubicación:
                            </div>
                            <div class="card-body">
                                ${requerimiento.ubicacion.departamento}
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.ubicacionValid}">
                                        </c:when>
                                        <c:otherwise>
                                            Ubicación no corresponde
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.ubicacionValid}">
                                <img src="${pageContext.request.contextPath}/images/check.png" alt="" width="16"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/images/cancel.png" alt="" width="16"/>
                            </c:otherwise>
                        </c:choose>   
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-10">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Unidad Formuladora:
                            </div>
                            <div class="card-body">
                                ${requerimiento.unidadFormuladora.nombre}
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.unidadFormuladoraValid}">
                                        </c:when>
                                        <c:otherwise>
                                            <p>Unidad formuladora no corresponde</p>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.unidadFormuladoraValid}">
                                <img src="${pageContext.request.contextPath}/images/check.png" alt="" width="16"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/images/cancel.png" alt="" width="16"/>
                            </c:otherwise>
                        </c:choose>   
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-10">
                        <!-- Inner Card-->
                        <div class="card">
                            <div class="card-header">
                                Unidad Ejecutora:
                            </div>
                            <div class="card-body">
                                ${requerimiento.unidadEjecutoraRecomendada}
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.unidadEjecutoraValid}">
                                        </c:when>
                                        <c:otherwise>
                                            Unidad ejecutora no corresponde
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.unidadEjecutoraValid}">
                                <img src="${pageContext.request.contextPath}/images/check.png" alt="" width="16"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${pageContext.request.contextPath}/images/cancel.png" alt="" width="16"/>
                            </c:otherwise>
                        </c:choose>   
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-3 text-center">
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
