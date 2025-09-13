function mostrarFormularioCotizacion() {
  document.getElementById("formContainerVentas").style.display = "block";
  document.getElementById("agendaContainerVentas").style.display = "none";
  resetForms();
}

function mostrarAgendaVentas() {
  document.getElementById("agendaContainerVentas").style.display = "block";
  document.getElementById("formContainerVentas").style.display = "none";
  resetForms();
}

function resetForms() {
  const forms = document.querySelectorAll("#formCotizacionVentas, #formAgendaVentas");
  forms.forEach(form => {
    form.classList.remove("was-validated");
    form.reset();
  });
  document.getElementById("ventasResultado").style.display = "none";
  document.getElementById("agendaResultado").style.display = "none";
}

document.getElementById("formCotizacionVentas").addEventListener("submit", function (e) {
  e.preventDefault();
  const form = e.target;
  form.classList.add("was-validated");
  if (!form.checkValidity()) return;

  const nombre = document.getElementById("ventasNombre").value.trim();
  const modelo = document.getElementById("ventasModelo").value.trim();
  const precio = parseFloat(document.getElementById("ventasPrecio").value);
  const cuota = parseFloat(document.getElementById("ventasCuota").value);
  const meses = parseInt(document.getElementById("ventasMeses").value);

  if (cuota >= precio) {
    alert("La cuota inicial no puede ser mayor o igual al precio del vehículo.");
    return;
  }

  const montoFinanciar = precio - cuota;
  const cuotaMensual = (montoFinanciar / meses).toFixed(2);

  const resultado = document.getElementById("ventasResultado");
  resultado.innerHTML = `
    <strong>Hola ${nombre}</strong>, tu cotización para el <strong>${modelo}</strong> es:
    <ul class="mb-0 mt-2">
      <li>Precio: $${precio.toLocaleString()}</li>
      <li>Cuota Inicial: $${cuota.toLocaleString()}</li>
      <li>Monto a financiar: $${montoFinanciar.toLocaleString()}</li>
      <li>Plazo: ${meses} meses</li>
      <li><strong>Cuota mensual aproximada: $${cuotaMensual}</strong></li>
    </ul>`;
  resultado.style.display = "block";
  resultado.focus();
});

document.getElementById("formAgendaVentas").addEventListener("submit", function (e) {
  e.preventDefault();
  const form = e.target;
  form.classList.add("was-validated");
  if (!form.checkValidity()) return;

  const nombre = document.getElementById("agendaNombre").value.trim();
  const fecha = document.getElementById("agendaFecha").value;
  const hora = document.getElementById("agendaHora").value;

  const res = document.getElementById("agendaResultado");
  res.innerHTML = `<strong>Hola ${nombre}</strong>, tu cita fue agendada para <strong>${fecha}</strong> a las <strong>${hora}</strong>. ¡Nos pondremos en contacto contigo!`;
  res.style.display = "block";
  res.focus();
});

// Mostrar por defecto formulario de cotización
mostrarFormularioCotizacion();
