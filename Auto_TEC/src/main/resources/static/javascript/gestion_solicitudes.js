let solicitudes = [
  { id: 1, cliente: "Carlos Pérez", descripcion: "Solicitud de prueba 1", estado: "Pendiente", fecha: "2025-09-20" },
  { id: 2, cliente: "María Gómez", descripcion: "Solicitud de repuesto", estado: "Aprobada", fecha: "2025-09-21" },
  { id: 3, cliente: "Juan Torres", descripcion: "Solicitud de mantenimiento", estado: "Rechazada", fecha: "2025-09-22" },
  { id: 4, cliente: "Ana Rodríguez", descripcion: "Solicitud de prueba 2", estado: "Pendiente", fecha: "2025-09-23" }
];

const tabla = document.getElementById("tablaSolicitudes");
const modal = document.getElementById("modalSolicitud");
const form = document.getElementById("formSolicitud");
const btnNueva = document.getElementById("btnNuevaSolicitud");
const btnExportar = document.getElementById("btnExportar");
const closeModal = document.querySelector(".close");
const buscar = document.getElementById("buscar");
const filtroEstado = document.getElementById("filtroEstado");

function renderTabla() {
  tabla.innerHTML = "";
  let filtro = filtroEstado.value;
  let texto = buscar.value.toLowerCase();

  let datos = solicitudes.filter(s =>
    (filtro === "todos" || s.estado === filtro) &&
    s.cliente.toLowerCase().includes(texto)
  );

  datos.forEach(s => {
    let tr = document.createElement("tr");
    tr.innerHTML = `
      <td>${s.id}</td>
      <td>${s.cliente}</td>
      <td>${s.descripcion}</td>
      <td>${s.estado}</td>
      <td>${s.fecha}</td>
      <td>
        <button class="btnEditar" onclick="editarSolicitud(${s.id})">Editar</button>
        <button class="btnEliminar" onclick="eliminarSolicitud(${s.id})">Eliminar</button>
      </td>
    `;
    tabla.appendChild(tr);
  });

  actualizarIndicadores();
}

function actualizarIndicadores() {
  document.querySelector("#totalSolicitudes p").textContent = solicitudes.length;
  document.querySelector("#pendientes p").textContent = solicitudes.filter(s => s.estado === "Pendiente").length;
  document.querySelector("#aprobadas p").textContent = solicitudes.filter(s => s.estado === "Aprobada").length;
  document.querySelector("#rechazadas p").textContent = solicitudes.filter(s => s.estado === "Rechazada").length;
}

btnNueva.onclick = () => {
  document.getElementById("modalTitulo").textContent = "Nueva Solicitud";
  form.reset();
  document.getElementById("solicitudId").value = "";
  modal.style.display = "flex";
};

closeModal.onclick = () => modal.style.display = "none";
window.onclick = e => { if (e.target == modal) modal.style.display = "none"; };

form.onsubmit = e => {
  e.preventDefault();
  const id = document.getElementById("solicitudId").value;
  const nueva = {
    id: id ? parseInt(id) : Date.now(),
    cliente: document.getElementById("cliente").value,
    descripcion: document.getElementById("descripcion").value,
    estado: document.getElementById("estado").value,
    fecha: document.getElementById("fecha").value
  };

  if (id) {
    const index = solicitudes.findIndex(s => s.id == id);
    solicitudes[index] = nueva;
  } else {
    solicitudes.push(nueva);
  }

  modal.style.display = "none";
  renderTabla();
};

function editarSolicitud(id) {
  const s = solicitudes.find(s => s.id == id);
  document.getElementById("modalTitulo").textContent = "Editar Solicitud";
  document.getElementById("solicitudId").value = s.id;
  document.getElementById("cliente").value = s.cliente;
  document.getElementById("descripcion").value = s.descripcion;
  document.getElementById("estado").value = s.estado;
  document.getElementById("fecha").value = s.fecha;
  modal.style.display = "flex";
}

function eliminarSolicitud(id) {
  if (confirm("¿Seguro que quieres eliminar esta solicitud?")) {
    solicitudes = solicitudes.filter(s => s.id !== id);
    renderTabla();
  }
}

btnExportar.onclick = () => {
  let csv = "ID,Cliente,Descripción,Estado,Fecha\n";
  solicitudes.forEach(s => {
    csv += `${s.id},${s.cliente},${s.descripcion},${s.estado},${s.fecha}\n`;
  });
  const blob = new Blob([csv], { type: "text/csv" });
  const link = document.createElement("a");
  link.href = URL.createObjectURL(blob);
  link.download = "solicitudes.csv";
  link.click();
};

buscar.oninput = renderTabla;
filtroEstado.onchange = renderTabla;

renderTabla();
