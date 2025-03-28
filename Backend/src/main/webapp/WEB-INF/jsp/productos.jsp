<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="./components/header.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Estadísticas de Inventario de Productos</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Fuentes modernas -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <!-- Estilos personalizados -->
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Roboto', sans-serif;
        }
        h1, h2, h5 {
            font-weight: 700;
        }
        .card {
            border: none;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            transition: transform 0.2s;
        }
        .card:hover {
            transform: translateY(-5px);
        }
        .table {
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .table th {
            background-color: #343a40;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="container my-5">
    <h1 class="text-center mb-4">Estadísticas de Inventario de Productos</h1>
    <!-- Lista de productos -->
    <h2 class="mt-5">Lista de Productos</h2>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Estado</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="producto" items="${listarProductos}">
                <tr>
                    <td>${producto.id_producto}</td>
                    <td>${producto.nombre}</td>
                    <td>${producto.cantidad}</td>
                    <td>${producto.estado}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row g-4">
        <div class="col-md-6 col-lg-4">
            <div class="card bg-primary text-white">
                <div class="card-body">
                    <h5 class="card-title">Productos en stock</h5>
                    <p class="card-text">Cantidad total de productos almacenados: ${totalStock}</p>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card bg-warning text-white">
                <div class="card-body">
                    <h5 class="card-title">Productos <u>activos</u> con stock bajo</h5>
                    <div class="table-responsive">
                        <table class="table table-bordered mb-0">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Cantidad</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="producto1" items="${stockBajo}">
                                <tr>
                                    <td>${producto1.id_producto}</td>
                                    <td>${producto1.nombre}</td>
                                    <td>${producto1.cantidad}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card bg-danger text-white">
                <div class="card-body">
                    <h5 class="card-title">Productos con stock crítico</h5>
                    <div class="table-responsive">
                        <table class="table table-bordered mb-0">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Cantidad</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="producto2" items="${stockCritico}">
                                <tr>
                                    <td>${producto2.id_producto}</td>
                                    <td>${producto2.nombre}</td>
                                    <td>${producto2.cantidad}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap JS (opcional para componentes interactivos) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>