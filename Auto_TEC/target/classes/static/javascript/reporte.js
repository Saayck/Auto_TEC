const solicitudes = [
  { id: 1, cliente: "Carlos López", auto: "Ferrari SF90", estado: "Pendiente", fecha: "2025-09-20" },
  { id: 2, cliente: "Ana Torres", auto: "Lamborghini Huracán", estado: "Aprobada", fecha: "2025-09-21" },
  { id: 3, cliente: "Pedro Castillo", auto: "Bugatti Divo", estado: "Rechazada", fecha: "2025-09-23" },
  { id: 4, cliente: "María Díaz", auto: "Porsche Taycan", estado: "Aprobada", fecha: "2025-09-25" }
];

let solicitudesFiltradas = [...solicitudes];

function actualizarIndicadores() {
  const total = solicitudesFiltradas.length;
  const pendientes = solicitudesFiltradas.filter(s => s.estado === "Pendiente").length;
  const aprobadas = solicitudesFiltradas.filter(s => s.estado === "Aprobada").length;
  const rechazadas = solicitudesFiltradas.filter(s => s.estado === "Rechazada").length;

  document.getElementById("totalSolicitudes").textContent = `Total Solicitudes: ${total}`;
  document.getElementById("pendientes").textContent = `Pendientes: ${pendientes}`;
  document.getElementById("aprobadas").textContent = `Aprobadas: ${aprobadas}`;
  document.getElementById("rechazadas").textContent = `Rechazadas: ${rechazadas}`;
}

function renderTabla() {
  const tbody = document.getElementById("tablaSolicitudes");
  tbody.innerHTML = "";
  solicitudesFiltradas.forEach(s => {
    const row = `<tr>
      <td>${s.id}</td>
      <td>${s.cliente}</td>
      <td>${s.auto}</td>
      <td>${s.estado}</td>
      <td>${s.fecha}</td>
    </tr>`;
    tbody.innerHTML += row;
  });
}

function aplicarFiltros() {
  const cliente = document.getElementById("filtroCliente").value.toLowerCase();
  const estado = document.getElementById("filtroEstado").value;
  const fechaInicio = document.getElementById("filtroFechaInicio").value;
  const fechaFin = document.getElementById("filtroFechaFin").value;

  solicitudesFiltradas = solicitudes.filter(s => {
    const coincideCliente = s.cliente.toLowerCase().includes(cliente);
    const coincideEstado = estado ? s.estado === estado : true;
    const dentroRango = (!fechaInicio || s.fecha >= fechaInicio) && (!fechaFin || s.fecha <= fechaFin);
    return coincideCliente && coincideEstado && dentroRango;
  });

  renderTabla();
  actualizarIndicadores();
  renderCharts();
}

function exportarCSV() {
  let csv = "ID,Cliente,Auto,Estado,Fecha\n";
  solicitudesFiltradas.forEach(s => {
    csv += `${s.id},${s.cliente},${s.auto},${s.estado},${s.fecha}\n`;
  });

  const blob = new Blob([csv], { type: "text/csv;charset=utf-8;" });
  const link = document.createElement("a");
  link.href = URL.createObjectURL(blob);
  link.download = "reporte_solicitudes.csv";
  link.click();
}

function renderCharts() {
  if (window.chartEstado) window.chartEstado.destroy();
  if (window.chartMes) window.chartMes.destroy();

  // Solicitudes por estado
  const estados = { Pendiente: 0, Aprobada: 0, Rechazada: 0 };
  solicitudesFiltradas.forEach(s => {
    estados[s.estado]++;
  });

  window.chartEstado = new Chart(document.getElementById("solicitudesEstado"), {
    type: "pie",
    data: {
      labels: Object.keys(estados),
      datasets: [{
        data: Object.values(estados),
        backgroundColor: ["#0ff", "#0f0", "#f00"]
      }]
    }
  });

  // Solicitudes por mes
  const solicitudesPorMes = {};
  solicitudesFiltradas.forEach(s => {
    const mes = s.fecha.slice(0, 7);
    solicitudesPorMes[mes] = (solicitudesPorMes[mes] || 0) + 1;
  });

  window.chartMes = new Chart(document.getElementById("solicitudesMes"), {
    type: "bar",
    data: {
      labels: Object.keys(solicitudesPorMes),
      datasets: [{
        label: "Solicitudes por Mes",
        data: Object.values(solicitudesPorMes),
        backgroundColor: "#0ff"
      }]
    }
  });
}

// Inicializar
renderTabla();
actualizarIndicadores();
renderCharts();
