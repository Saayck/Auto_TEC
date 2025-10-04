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

function mostrarInfoCliente() {
    const select = document.getElementById('clienteSelect');
    const selectedOption = select.options[select.selectedIndex];
    const infoDiv = document.getElementById('infoCliente');
    
    if (selectedOption.value) {
        document.getElementById('clienteEmail').textContent = selectedOption.getAttribute('data-email');
        document.getElementById('clienteTelefono').textContent = selectedOption.getAttribute('data-telefono');
        infoDiv.style.display = 'block';
    } else {
        infoDiv.style.display = 'none';
    }
}

function mostrarInfoModelo() {
    const select = document.getElementById('modeloSelect');
    const selectedOption = select.options[select.selectedIndex];
    const infoDiv = document.getElementById('infoModelo');
    
    if (selectedOption.value) {
        const precio = selectedOption.getAttribute('data-precio');
        document.getElementById('modeloPrecio').textContent = '$' + parseFloat(precio).toLocaleString('es-ES');
        document.getElementById('modeloMarca').textContent = selectedOption.text.split(' ')[0];
        document.getElementById('modeloNombre').textContent = selectedOption.text.split(' ')[1];
        infoDiv.style.display = 'block';
        
        // Auto-completar precio si está vacío
        const precioInput = document.getElementById('precioVenta');
        if (!precioInput.value) {
            precioInput.value = precio;
            actualizarPrecioDisplay();
        }
    } else {
        infoDiv.style.display = 'none';
    }
}

function actualizarPrecioDisplay() {
    const precioInput = document.getElementById('precioVenta');
    const totalDisplay = document.getElementById('totalDisplay');
    
    if (precioInput.value) {
        const precio = parseFloat(precioInput.value);
        totalDisplay.textContent = '$' + precio.toLocaleString('es-ES', {
            minimumFractionDigits: 2,
            maximumFractionDigits: 2
        });
    } else {
        totalDisplay.textContent = '$0.00';
    }
}

function validarFormulario() {
    const precio = document.getElementById('precioVenta').value;
    if (!precio || parseFloat(precio) <= 0) {
        alert('Por favor ingrese un precio válido mayor a 0');
        return false;
    }
    return true;
}

// Inicializar display de precio
document.addEventListener('DOMContentLoaded', function() {
    actualizarPrecioDisplay();
});
