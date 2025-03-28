<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 class="text-center">Estadísticas de Tareas</h1>
<div class="row mt-4">
    <div class="col-md-4">
        <div class="card text-white bg-primary mb-3">
            <div class="card-body">
                <h5 class="card-title">Tareas en proceso o Por Hacer</h5>

                    <table class="table table-bordered">
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

    <div class="col-md-4">
        <div class="card text-white bg-success mb-3">
            <div class="card-body">
                <h5 class="card-title">Tareas finalizadas hoy</h5>
                <p class="card-text">Cantidad de tareas finalizadas hoy: ${tareasFinalizadasHoy}</p>
            </div>
        </div>
    </div>
</div>

<!-- Lista de tareas -->
<h2 class="mt-5">Lista de Tareas</h2>
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


