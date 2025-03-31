<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="./components/header.jsp" %>

<div class="container mt-5">
    <!-- Este lugar se actualizará con el contenido específico para cada página -->
</div>
<style>
    div{
        display:flex;
        flex-direction:column;
        width:97%;
        align-items:center;
        justify-content:center;
    }
    canvas{
        width:95%;
    }
</style>
<div>
    <canvas id="myChart"></canvas>
    <canvas id="myChart"></canvas>
    <canvas id="myChart"></canvas>
</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
    const labels = [];
    const data = [];

    <c:forEach var="entry" items="${mapaDatos}">
        labels.push('<c:out value="${entry.key}" />');
        data.push(<c:out value="${entry.value}" />);
    </c:forEach>

    const ctx = document.getElementById('myChart');
    new Chart(ctx, {
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
                indexAxis: 'y',  // Esto hará que el gráfico sea horizontal (eje X se convierte en Y)
                scales: {
                    x: {
                        beginAtZero: true  // Esto asegura que el gráfico horizontal comience desde cero en el eje X
                    },
                    y: {
                        beginAtZero: true  // Asegura que las barras comiencen desde cero en el eje Y
                    }
                }
            }
    });
</script>

</body>
</html>
