<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<<<<<<< HEAD
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<head>
    <title>Página JSP en Spring Boot</title>
</head>
<body>
<nav class="navbar bg-success opacity-50 navbar-expand-lg navbar-light bg-ligth d-flex justify-content-center">
    <div class="collapse navbar-collapse justify-content-center" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-link p-2" href="#">Home</a>
            <a class="nav-link p-2" href="#">Productos</a>
            <a class="nav-link p-2" href="#">Tareas</a>
            <a class="nav-link p-2" href="#" >Graficos</a>
            <a class="nav-link p-2" href="#" >Calendario</a>
        </div>
    </div>
</nav>
<h1>Lista de productos</h1>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Cantidad</th>
        <th>Estado</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="pro" items="${productos}">
        <tr>
            <td>${pro.id}</td>
            <td>${pro.nombre}</td>
            <td>${pro.cantidad}</td>
            <td>${pro.estado}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Página JSP en Spring Boot</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-success bg-opacity-75">
  <div class="collapse navbar-collapse d-flex justify-content-center" id="navbarNav">
    <ul class="navbar-nav fw-bold">
      <li class="nav-item">
        <a class="nav-link text-white" href="#">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
        <a class="nav-link">Disabled</a>
      </li>
    </ul>
  </div>
</nav>

 <c:choose>
     <c:when test="${not empty listaUsuariosWeb}">
         <ul>
             <c:forEach var="item" items="${listaUsuariosWeb}">
                 <li>${item.nombre}</li>
             </c:forEach>
         </ul>
     </c:when>
     <c:otherwise>
         <b>NO DATA</b>
     </c:otherwise>
 </c:choose>

</body>
</html>
>>>>>>> rama_manuel
