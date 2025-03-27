<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Fecha de Alta</th>
                </tr>
            </thead>
            <c:if test="${empty listarUsuarios}">
                <p>No hay usuarios para mostrar.</p>
            </c:if>
            <c:forEach items="${listarUsuarios}" var="card">
                <tr>
                    <td>${card.id}</td>
                    <td>${card.nombre}</td>
                    <td>${card.email}</td>
                    <td>${card.fechaAlta}</td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
