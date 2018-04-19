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
            <fmt:setLocale value="es_PE" scope="session"/>
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
                                Mano de Obra no Calificada::
                            </div>
                            <div class="card-body">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" value="31255" />
                                
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.manoobranocalificadaValid}">
                                        </c:when>
                                        <c:otherwise>
                                            <label for="nombre">&nbsp;Mano de obra no corresponde</label>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.manoobranocalificadaValid}">
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
                                Tasa de Descuento Social:
                            </div>
                            <div class="card-body">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" value="22088" />
                                
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.tasadescuentoValid}">
                                        </c:when>
                                        <c:otherwise>
                                            <label for="nombre">&nbsp;La tasa no corresponde</label>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.tasadescuentoValid}">
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
                                Precio Social:
                            </div>
                            <div class="card-body">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" value="34577" />
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.precioSocialValid}">
                                        </c:when>
                                        <c:otherwise>
                                            <label for="nombre">&nbsp;Precio social no corresponde</label>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.precioSocialValid}">
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
                                Valor social del tiempo:
                            </div>
                            <div class="card-body">
                                <fmt:formatNumber type="currency" maxFractionDigits="0" value="76001" />
                                <div class="alert-danger">
                                    <c:choose>
                                        <c:when test="${gr.valorSocialTiempoValid}">
                                        </c:when>
                                        <c:otherwise>
                                            <label for="nombre">Valor social del tiempo no cumple</label>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2 align-self-center">
                        <!-- Inner Card-->
                        <c:choose>
                            <c:when test="${gr.valorSocialTiempoValid}">
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
