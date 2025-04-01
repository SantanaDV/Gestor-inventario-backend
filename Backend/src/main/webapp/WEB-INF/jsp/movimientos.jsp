<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Movimientos de Productos</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <!-- Estilos personalizados -->

</head>
<body>
    <%@ include file="./components/header.jsp" %>
    <div class="container my-5">
                 <h1 class="text-center">
                 <c:choose>
                 <c:when test="${not empty productosEntrantes or not empty productosSalientes}">
                        Movimientos
                 </c:when>
                 <c:otherwise>
                        Sin movimientos 😔
                 </c:otherwise>
                </c:choose>
                </h1>
        <c:if test="${not empty productosEntrantes}">
            <h2 class="mt-5 fw-light">Lista de Productos Entrantes</h2>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class='bg-dark text-white'>Fecha de Entrada</th>
                            <th class='bg-dark text-white'>Nombre</th>
                            <th class='bg-dark text-white'>Cantidad</th>
                            <th class='bg-dark text-white'>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productosEntrantes}">
                            <tr>
                                <td>${producto.fecha}</td>
                                <td>${producto.nombre}</td>
                                <td>${producto.cantidad}</td>
                                <td>${producto.estado}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>

        <c:if test="${not empty productosSalientes}">
            <h2 class="mt-5 fw-light">Lista de Productos Salientes</h2>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class='bg-black text-white'>Fecha de Entrada</th>
                            <th class='bg-black text-white'>Nombre</th>
                            <th class='bg-black text-white'>Cantidad</th>
                            <th class='bg-black text-white'>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productosSalientes}">
                            <tr>
                                <td>${producto.fecha}</td>
                                <td>${producto.nombre}</td>
                                <td>${producto.cantidad}</td>
                                <td>${producto.estado}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>

    <!-- Bootstrap JS (opcional para componentes interactivos) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
