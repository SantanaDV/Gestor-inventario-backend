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
        const letters = '89ABCDEF'; // Solo usa valores altos para tonos claros
        let color = '#';
        for (let i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * letters.length)];
        }
        return color;
    }


    const labels = [];
    const data = [];
    const colores=[];


    <c:forEach var="entry" items="${mapaDatos}">
    labels.push('<c:out value="${entry.key}" />');
    data.push(<c:out value="${entry.value}" />);
    colores.push(getRandomColor());
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
                borderWidth: 1,
                backgroundColor : '#FF6961',
                borderColor: 'black'
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
                backgroundColor:colores,
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
                label: 'Evolucion Total Stock/Mes',
                data: data2,
                borderColor: 'black',
                backgroundColor: '#FF6961',
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
