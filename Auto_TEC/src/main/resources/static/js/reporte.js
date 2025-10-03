// Gráfico de Ventas por Mes
const ctxMes = document.getElementById('ventasMesChart').getContext('2d');
new Chart(ctxMes, {
    type: 'line',
    data: {
        labels: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        datasets: [{
            label: 'Ventas ($)',
            data: [120000, 190000, 150000, 220000, 180000, 250000, 280000, 200000, 240000, 300000, 270000, 350000],
            borderColor: '#f39c12',
            backgroundColor: 'rgba(243, 156, 18, 0.1)',
            tension: 0.4,
            fill: true
        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: {
                display: true,
                position: 'bottom',
                labels: { color: '#fff' }
            }
        },
        scales: {
            x: { ticks: { color: '#fff' } },
            y: {
                beginAtZero: true,
                ticks: {
                    color: '#fff',
                    callback: function(value) {
                        return '$' + value.toLocaleString();
                    }
                }
            }
        }
    }
});

// Gráfico de Ventas por Empleado
const ctxEmpleado = document.getElementById('ventasEmpleadoChart').getContext('2d');
new Chart(ctxEmpleado, {
    type: 'bar',
    data: {
        labels: ['Ana Torres', 'Luis Ramos', 'Sofia Mendoza', 'Carlos Díaz'],
        datasets: [{
            label: 'Cantidad de Ventas',
            data: [15, 8, 22, 12],
            backgroundColor: ['#9b59b6', '#27ae60', '#e74c3c', '#f39c12']
        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: { display: false }
        },
        scales: {
            x: { ticks: { color: '#fff' } },
            y: {
                beginAtZero: true,
                ticks: { color: '#fff', stepSize: 5 }
            }
        }
    }
});

// Función para filtrar reporte
function filtrarReporte() {
    const mes = document.getElementById('filtroMes').value;
    const fechaInicio = document.getElementById('fechaInicio').value;
    const fechaFin = document.getElementById('fechaFin').value;

    console.log('Filtrando:', { mes, fechaInicio, fechaFin });
    alert('Aplicando filtros... (implementar en el backend)');
}

