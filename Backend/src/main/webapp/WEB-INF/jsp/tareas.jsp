<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <h1 class="text-center mb-4">Estadísticas de Tareas</h1>
    <div class="row g-4">
        <div class="col-md-6 col-lg-4">
            <div class="card bg-primary text-white">
                <div class="card-body">
                    <h5 class="card-title">Tareas en proceso o Por Hacer</h5>
                    <div class="table-responsive">
                        <table class="table table-bordered mb-0">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Descripción</th>
                                <th>Empleado Asignado</th>
                                <th>Fecha de Asignación</th>
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
                                <th>ID</th>
                                <th>Descripción</th>
                                <th>Empleado Asignado</th>
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

    <!-- Lista de tareas -->
    <h2 class="mt-5">Lista de Tareas</h2>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Descripción</th>
                <th>Estado</th>
                <th>Empleado Asignado</th>
                <th>Fecha de Asignación</th>
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
</div>
<!-- Bootstrap JS (opcional para componentes interactivos) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<canvas id="myChart"></canvas>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

 <script>
   const ctx = document.getElementById('myChart');

   new Chart(ctx, {
     type: 'bar',
     data: {
       labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
       datasets: [{
         label: '# of Votes',
         data: [12, 19, 3, 5, 2, 3],
         borderWidth: 1
       }]
     },
     options: {
       scales: {
         y: {
           beginAtZero: true
         }
       }
     }
   });
 </script>


