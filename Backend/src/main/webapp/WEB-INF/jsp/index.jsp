<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="./components/header.jsp" %>

<div class="container mt-5">
    <!-- Este lugar se actualizará con el contenido específico para cada página -->
</div>

<style>
    div {
        display: flex;
        width: 100%;
        flex-direction: row ;
        gap:20px;
        flex-wrap:wrap;
        align-items: center;
        justify-content: center;
        margin-bottom: 10px;
    }
    canvas{
        width: 80% !important;
        height: 75% !important;
    }
    #graficos2 canvas{
        width: 30% !important;
        flex-direction: row;
        gap: 20px;
        justify-content: space-between;
    }
    #graficos2 #myChart2{
        align-self: end;
        width: 50% !important;
    }

</style>

<div id="graficos1">
    <canvas id="myChart"></canvas>
</div>
<div id="graficos2">
    <canvas id="myChart1"></canvas>
    <canvas id="myChart2"></canvas>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
    function getRandomColor() {
        const letters = '0123456789ABCDEF';
        let color = '#';
        for (let i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }


    const labels = [];
    const data = [];



    <c:forEach var="entry" items="${mapaDatos}">
    labels.push('<c:out value="${entry.key}" />');
    data.push(<c:out value="${entry.value}" />);
    </c:forEach>

    // Gráfico de Barras
    const ctx1 = document.getElementById('myChart');
    new Chart(ctx1, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Stock por Categoria',
                data: data,
                borderWidth: 1
            }]
        },
        options: {
            indexAxis: 'y',
            scales: {
                x: {
                    beginAtZero: true
                },
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    const ctx2 = document.getElementById('myChart1');
    new Chart(ctx2, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                label: 'Distribucion de productos',
                data: data,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.6)',   // Rojo
                    'rgba(54, 162, 235, 0.6)',   // Azul
                    'rgba(255, 206, 86, 0.6)',   // Amarillo
                    'rgba(75, 192, 192, 0.6)',   // Verde agua
                    'rgba(153, 102, 255, 0.6)',  // Púrpura
                    'rgba(255, 159, 64, 0.6)',   // Naranja
                    'rgba(199, 199, 199, 0.6)',  // Gris
                    'rgba(83, 102, 255, 0.6)',   // Azul violeta
                    'rgba(255, 102, 178, 0.6)',  // Rosa
                    'rgba(204, 255, 102, 0.6)',  // Verde lima
                    'rgba(102, 255, 255, 0.6)',  // Celeste
                    'rgba(255, 153, 102, 0.6)',  // Salmón
                    'rgba(153, 255, 204, 0.6)',  // Verde menta
                    'rgba(255, 102, 102, 0.6)',  // Rojo claro
                    'rgba(102, 102, 255, 0.6)',  // Azul oscuro
                    'rgba(178, 102, 255, 0.6)',  // Lila
                    'rgba(255, 204, 102, 0.6)',  // Mostaza
                    'rgba(102, 255, 178, 0.6)',  // Verde turquesa
                    'rgba(255, 102, 229, 0.6)',  // Magenta
                    'rgba(102, 178, 255, 0.6)'   // Azul cielo
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,  // Asegura que el gráfico sea flexible y se ajuste bien
            plugins: {
                legend: {
                    labels: {
                        font: {
                            size: 15  // Aumenta el tamaño de las etiquetas de la leyenda
                        }
                    }
                },
                tooltip: {
                    callbacks: {
                        label: function(tooltipItem) {
                            return tooltipItem.label + ': ' + tooltipItem.raw;  // Personaliza el tooltip si lo deseas
                        }
                    }
                }
            }
        }
    });
    const labels2 = [];
    const data2 = [];
    const ctx = document.getElementById('myChart2').getContext('2d');

    <c:forEach var="entry" items="${meses}">
    labels2.push('<c:out value="${entry}" />');
    </c:forEach>

    <c:forEach var="entry" items="${cantidades}">
    data2.push('<c:out value="${entry}" />');
    </c:forEach>

    new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels2,
            datasets: [{
                label: 'Evolucion de Stock',
                data: data2,
                borderColor: 'blue',
                backgroundColor: 'rgba(0, 0, 255, 0.2)',
                borderWidth: 2,
                fill: true
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                x: {
                    beginAtZero: true
                },
                y: {
                    beginAtZero: true
                }
            }
        }
    });


</script>

</body>
</html>
