<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="./components/header.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Estadísticas de Tareas</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Fuentes modernas (opcional) -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <!-- Estilos personalizados -->
<body>
<div class="container my-5">
    <h1 class="text-center mb-4">Estadísticas de Tareas</h1>
    <!-- Lista de tareas -->
    <h2 class="mt-5 fw-light">Lista de Tareas</h2>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th class='bg-dark text-white'>ID</th>
                <th class='bg-dark text-white'>Descripción</th>
                <th class='bg-dark text-white'>Estado</th>
                <th class='bg-dark text-white'>Empleado Asignado</th>
                <th class='bg-dark text-white'>Fecha de Asignación</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tarea" items="${listarTareas}">
                <tr>
                    <td>${tarea.id}</td>
                    <td>${tarea.descripcion}</td>
                    <td>${tarea.estado}</td>
                    <td>${tarea.empleado_asignado}</td>
                    <td>${tarea.fecha_asignacion}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row g-4">
        <div class="col-md-6 col-lg-4">
            <div class="card bg-primary text-white">
                <div class="card-body">
                    <h5 class="card-title">Tareas en proceso o Por Hacer</h5>
                    <div class="table-responsive">
                        <table class="table table-bordered mb-0">
                            <thead>
                            <tr>
                                <th class='bg-dark text-white'>ID</th>
                                <th class='bg-dark text-white'>Descripción</th>
                                <th class='bg-dark text-white'>Empleado Asignado</th>
                                <th class='bg-dark text-white'>Fecha de Asignación</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="tarea1" items="${tareasProHaz}">
                                <tr>
                                    <td>${tarea1.id}</td>
                                    <td>${tarea1.descripcion}</td>
                                    <td>${tarea1.empleado_asignado}</td>
                                    <td>${tarea1.fecha_asignacion}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="card bg-success text-white">
                <div class="card-body">
                    <h5 class="card-title">Tareas finalizadas hoy</h5>
                    <div class="table-responsive">
                        <table class="table table-bordered mb-0">
                            <thead>
                            <tr>
                                <th class='bg-dark text-white'>ID</th>
                                <th class='bg-dark text-white'>Descripción</th>
                                <th class='bg-dark text-white'>Empleado Asignado</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="tarea2" items="${tareasFinalizadasHoy}">
                                <tr>
                                    <td>${tarea2.id}</td>
                                    <td>${tarea2.descripcion}</td>
                                    <td>${tarea2.empleado_asignado}</td>
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


