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
        margin: 10px;
    }
    canvas{
        width: 80% !important;
        height: 75% !important;
    }
    #graficos2 canvas{
        width: 30% !important;
        flex-direction: row;
        gap: 40px;
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
                label: '# of Votes',
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
                label: 'Distribución',
                data: data,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)',
                    'rgba(255, 159, 64, 0.6)'
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

    // Gráfico de Línea (opcional)
    const ctx3 = document.getElementById('myChart2');
    new Chart(ctx3, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: 'Tendencia',
                data: data,
                borderColor: 'rgba(54, 162, 235, 1)',
                backgroundColor: 'rgba(54, 162, 235, 0.2)',
                borderWidth: 2,
                fill: true
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            },
            plugins: {
                legend: {
                    labels: {
                        font: {
                            size: 25  // Aumenta el tamaño de las etiquetas de la leyenda
                        }
                    }
                }
            }
        }
    });
</script>

</body>
</html>
