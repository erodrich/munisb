<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div class="alert alert-success alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                    <strong>${errorPIP}</strong>
                </div>
            </c:if>
            <a href="${pageContext.request.contextPath}/principal.htm">
                <button type="button" class="btn btn-success btn-lg">Ir al inicio</button>
            </a>

        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>

