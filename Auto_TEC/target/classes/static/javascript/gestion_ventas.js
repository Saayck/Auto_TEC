function filtrarPorEstado() {
  const estado = document.getElementById('filtroEstado').value.toUpperCase();
  filtrarTabla(7, estado);
}

function filtrarPorMetodo() {
  const metodo = document.getElementById('filtroMetodo').value.toUpperCase();
  filtrarTabla(5, metodo);
}

function filtrarTabla(columnIndex, filterValue) {
  const table = document.getElementById('ventasTable');
  const rows = table.getElementsByTagName('tr');
  for (let i = 1; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName('td');
    if (cells.length > 0) {
      const textValue = cells[columnIndex].innerText;
      rows[i].style.display = (filterValue === '' || textValue.toUpperCase().includes(filterValue)) ? '' : 'none';
    }
  }
}

function filtrarPorFecha() {
  const inicio = new Date(document.getElementById('fechaInicio').value);
  const fin = new Date(document.getElementById('fechaFin').value);
  if (!inicio || !fin) { alert('Seleccione ambas fechas'); return; }

  const rows = document.getElementById('ventasTable').getElementsByTagName('tr');
  for (let i = 1; i < rows.length; i++) {
    const fechaCell = rows[i].getElementsByTagName('td')[6]?.innerText.split(' ')[0];
    if (fechaCell) {
      const [dia, mes, anio] = fechaCell.split('/');
      const fechaVenta = new Date(anio, mes - 1, dia);
      rows[i].style.display = (fechaVenta >= inicio && fechaVenta <= fin) ? '' : 'none';
    }
  }
}

function limpiarFiltros() {
  document.getElementById('filtroEstado').value = '';
  document.getElementById('filtroMetodo').value = '';
  document.getElementById('fechaInicio').value = '';
  document.getElementById('fechaFin').value = '';
  const rows = document.getElementById('ventasTable').getElementsByTagName('tr');
  for (let i = 1; i < rows.length; i++) rows[i].style.display = '';
}

function verDetalle(btn) {
  const contenido = `
    <p><strong>ID Venta:</strong> #${btn.dataset.id}</p>
    <p><strong>Cliente:</strong> ${btn.dataset.cliente}</p>
    <p><strong>Auto:</strong> ${btn.dataset.auto}</p>
    <p><strong>Precio Final:</strong> $${parseFloat(btn.dataset.precio).toLocaleString()}</p>
    <p><strong>Método de Pago:</strong> ${btn.dataset.metodo}</p>
  `;
  document.getElementById('detalleContenido').innerHTML = contenido;
  document.getElementById('modalDetalle').style.display = 'flex';
}

function cerrarModal() {
  document.getElementById('modalDetalle').style.display = 'none';
}

window.onload = function() {
  const alert = document.querySelector('.alert');
  if (alert) {
    setTimeout(() => {
      alert.style.transition = 'opacity 0.5s';
      alert.style.opacity = '0';
      setTimeout(() => alert.remove(), 500);
    }, 5000);
  }
};
