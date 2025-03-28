<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 class="text-center">Estadísticas de Inventario de Productos</h1>

<div class="row mt-4">
    <div class="col-md-4">
        <div class="card text-white bg-primary mb-3">
            <div class="card-body">
                <h5 class="card-title">Productos en stock</h5>
                <p class="card-text">Cantidad total de productos almacenados: ${totalStock}</p>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card text-white bg-warning mb-3">
            <div class="card-body">
                <h5 class="card-title">Productos con stock bajo</h5>
                <p class="card-text">Productos con stock bajo (≤ 5): ${stockBajo}</p>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card text-white bg-danger mb-3">
            <div class="card-body">
                <h5 class="card-title">Productos con stock crítico</h5>
                <p class="card-text">Productos con stock crítico (≤ 2): ${stockCritico}</p>
            </div>
        </div>
    </div>
</div>

<!-- Lista de productos -->
<h2 class="mt-5">Lista de Productos</h2>
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
