<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion de Inventarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<style>
    img{
        width:120px;
    }
</style>
<!-- Barra de navegación -->
<nav class="navbar navbar-expand-lg bg-secondary bg-opacity-50 p-3">
    <a class="navbar-brand" href="../"><img src="${pageContext.request.contextPath}/logo-web-qualicard.png" alt="Logo QualicaRD"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto ">
            <li class="nav-item">
                <a class="nav-link active text-dark fw-bold" href="../">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-dark" href="../productosWeb">Productos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-dark" href="../tareasWeb">Tareas</a>
            </li>
             <li class="nav-item">
                 <a class="nav-link text-dark" href="../movimientosWeb">Movimientos</a>
             </li>
            <li class="nav-item">
                <a class="nav-link text-dark" href="#">Contacto</a>
            </li>
        </ul>
    </div>
</nav>