function mostrarInfoCliente() {
    const select = document.getElementById('clienteSelect');
    const option = select.options[select.selectedIndex];
    
    if (option.value) {
        document.getElementById('clienteEmail').textContent = option.getAttribute('data-email');
        document.getElementById('clienteTelefono').textContent = option.getAttribute('data-telefono');
        document.getElementById('infoCliente').style.display = 'block';
    } else {
        document.getElementById('infoCliente').style.display = 'none';
    }
}

function mostrarInfoAuto() {
    const select = document.getElementById('autoSelect');
    const option = select.options[select.selectedIndex];
    
    if (option.value) {
        const precio = parseFloat(option.getAttribute('data-precio'));
        document.getElementById('autoPrecio').textContent = '$' + precio.toLocaleString('es-PE', {minimumFractionDigits: 2});
        document.getElementById('autoColor').textContent = option.getAttribute('data-color');
        document.getElementById('autoVin').textContent = option.getAttribute('data-vin');
        document.getElementById('infoAuto').style.display = 'block';
        
        // Autocompletar precio final con el precio del auto
        if (!document.getElementById('precioFinal').value) {
            document.getElementById('precioFinal').value = precio.toFixed(2);
            actualizarPrecioDisplay();
        }
    } else {
        document.getElementById('infoAuto').style.display = 'none';
    }
}

function actualizarPrecioDisplay() {
    const precio = parseFloat(document.getElementById('precioFinal').value) || 0;
    document.getElementById('totalDisplay').textContent = '$' + precio.toLocaleString('es-PE', {minimumFractionDigits: 2});
}

function validarFormulario() {
    const cliente = document.getElementById('clienteSelect').value;
    const auto = document.getElementById('autoSelect').value;
    const precio = document.getElementById('precioFinal').value;
    
    if (!cliente || !auto) {
        alert('Por favor, seleccione un cliente y un auto');
        return false;
    }
    
    if (!precio || parseFloat(precio) <= 0) {
        alert('El precio final debe ser mayor a 0');
        return false;
    }
    
    return confirm('¿Está seguro de registrar esta venta? Esta acción no se puede deshacer fácilmente.');
}
