const ventas = [
  { id: 1, cliente: "Carlos López", auto: "Ferrari SF90", monto: 500000, fecha: "2025-09-20" },
  { id: 2, cliente: "Ana Torres", auto: "Lamborghini Aventador", monto: 450000, fecha: "2025-09-21" },
  { id: 3, cliente: "Pedro Castillo", auto: "Bugatti Chiron", monto: 3000000, fecha: "2025-09-25" },
  { id: 4, cliente: "María Díaz", auto: "Porsche 911 Turbo", monto: 200000, fecha: "2025-09-26" }
];

let ventasFiltradas = [...ventas];

function actualizarIndicadores() {
  const totalVentas = ventasFiltradas.length;
  const ingresos = ventasFiltradas.reduce((sum, v) => sum + v.monto, 0);
  const promedio = totalVentas > 0 ? ingresos / totalVentas : 0;

  const hoy = new Date().toISOString().split("T")[0];
  const ventasHoy = ventasFiltradas.filter(v => v.fecha === hoy).length;

  document.getElementById("totalVentas").textContent = `Total Ventas: ${totalVentas}`;
  document.getElementById("ingresos").textContent = `Ingresos: $${ingresos.toLocaleString()}`;
  document.getElementById("promedio").textContent = `Promedio: $${promedio.toFixed(2)}`;
  document.getElementById("ventasHoy").textContent = `Ventas Hoy: ${ventasHoy}`;
}

function renderTabla() {
  const tbody = document.getElementById("tablaVentas");
  tbody.innerHTML = "";
  ventasFiltradas.forEach(v => {
    const row = `<tr>
      <td>${v.id}</td>
      <td>${v.cliente}</td>
      <td>${v.auto}</td>
      <td>$${v.monto.toLocaleString()}</td>
      <td>${v.fecha}</td>
    </tr>`;
    tbody.innerHTML += row;
  });
}

function aplicarFiltros() {
  const cliente = document.getElementById("filtroCliente").value.toLowerCase();
  const fechaInicio = document.getElementById("filtroFechaInicio").value;
  const fechaFin = document.getElementById("filtroFechaFin").value;

  ventasFiltradas = ventas.filter(v => {
    const coincideCliente = v.cliente.toLowerCase().includes(cliente);
    const dentroRango = (!fechaInicio || v.fecha >= fechaInicio) && (!fechaFin || v.fecha <= fechaFin);
    return coincideCliente && dentroRango;
  });

  renderTabla();
  actualizarIndicadores();
  renderCharts();
}

function exportarCSV() {
  let csv = "ID,Cliente,Auto,Monto,Fecha\n";
  ventasFiltradas.forEach(v => {
    csv += `${v.id},${v.cliente},${v.auto},${v.monto},${v.fecha}\n`;
  });

  const blob = new Blob([csv], { type: "text/csv;charset=utf-8;" });
  const link = document.createElement("a");
  link.href = URL.createObjectURL(blob);
  link.download = "reporte_ventas.csv";
  link.click();
}

function renderCharts() {
  // Destruir gráficos previos
  if (window.chartMes) window.chartMes.destroy();
  if (window.chartCliente) window.chartCliente.destroy();

  // Ventas por mes
  const ventasPorMes = {};
  ventasFiltradas.forEach(v => {
    const mes = v.fecha.slice(0, 7); // YYYY-MM
    ventasPorMes[mes] = (ventasPorMes[mes] || 0) + v.monto;
  });

  window.chartMes = new Chart(document.getElementById("ventasMes"), {
    type: "bar",
    data: {
      labels: Object.keys(ventasPorMes),
      datasets: [{
        label: "Ingresos por Mes",
        data: Object.values(ventasPorMes),
        backgroundColor: "#0ff"
      }]
    }
  });

  // Ventas por cliente
  const ventasPorCliente = {};
  ventasFiltradas.forEach(v => {
    ventasPorCliente[v.cliente] = (ventasPorCliente[v.cliente] || 0) + v.monto;
  });

  window.chartCliente = new Chart(document.getElementById("ventasCliente"), {
    type: "pie",
    data: {
      labels: Object.keys(ventasPorCliente),
      datasets: [{
        label: "Ventas por Cliente",
        data: Object.values(ventasPorCliente),
        backgroundColor: ["#0ff", "#0f0", "#f0f", "#ff0", "#f00"]
      }]
    }
  });
}

// Inicializar
renderTabla();
actualizarIndicadores();
renderCharts();
