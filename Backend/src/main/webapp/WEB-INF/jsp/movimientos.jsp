<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Inventarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<!-- Barra de navegación -->
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <a class="navbar-brand" href="#">Gestión de Inventarios</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="nav-link active" href="/">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/productosWeb">Productos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/tareasWeb">Tareas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contacto</a>
            </li>
        </ul>
    </div>
</nav>


<div class="container mt-5">
    <h1 class='text-center'>Movimientos</h1>
</div>
<h2 class="mt-5">Lista de Productos Entrantes</h2>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Fecha de Entrada</th>
        <th>Nombre</th>
        <th>Cantidad</th>
        <th>Estado</th>
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

<h2 class="mt-5">Lista de Productos Salientes</h2>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Fecha de Entrada</th>
        <th>Nombre</th>
        <th>Cantidad</th>
        <th>Estado</th>
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





</body>
</html>