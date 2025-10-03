function filtrarPorEstado() {
  const estado = document.getElementById('filtroEstado').value.toUpperCase();
  filtrarTabla(5, estado);
}

function filtrarPorTipo() {
  const tipo = document.getElementById('filtroTipo').value.toUpperCase();
  filtrarTabla(4, tipo);
}

function filtrarTabla(columnIndex, filterValue) {
  const table = document.getElementById('citasTable');
  const rows = table.getElementsByTagName('tr');

  for (let i = 1; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName('td');
    if (cells.length > 0) {
      const cell = cells[columnIndex];
      const textValue = cell.textContent || cell.innerText;

      rows[i].style.display = (filterValue === '' || textValue.toUpperCase().indexOf(filterValue) > -1) ? '' : 'none';
    }
  }
}

function filtrarPorFecha() {
  const fechaInicio = document.getElementById('fechaInicio').value;
  const fechaFin = document.getElementById('fechaFin').value;

  if (!fechaInicio || !fechaFin) {
    alert('Por favor seleccione ambas fechas');
    return;
  }

  const table = document.getElementById('citasTable');
  const rows = table.getElementsByTagName('tr');

  const inicio = new Date(fechaInicio);
  const fin = new Date(fechaFin);

  for (let i = 1; i < rows.length; i++) {
    const cells = rows[i].getElementsByTagName('td');
    if (cells.length > 0) {
      const fechaCell = cells[3].textContent;
      const partes = fechaCell.split(' ')[0].split('/');
      const fechaCita = new Date(partes[2], partes[1] - 1, partes[0]);

      rows[i].style.display = (fechaCita >= inicio && fechaCita <= fin) ? '' : 'none';
    }
  }
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
