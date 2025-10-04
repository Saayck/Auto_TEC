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

function mostrarInfoModelo() {
    const select = document.getElementById('modeloSelect');
    const option = select.options[select.selectedIndex];
    
    if (option.value) {
        const precio = parseFloat(option.getAttribute('data-precio'));
        document.getElementById('modeloPrecio').textContent = '$' + precio.toLocaleString('es-PE', {minimumFractionDigits: 2});
        document.getElementById('modeloMarca').textContent = option.getAttribute('data-marca');
        document.getElementById('modeloNombre').textContent = option.getAttribute('data-nombre');
        document.getElementById('infoModelo').style.display = 'block';
        
        // Autocompletar precio venta con el precio del modelo
        const precioVentaInput = document.getElementById('precioVenta');
        if (!precioVentaInput.value || precioVentaInput.value === '0') {
            precioVentaInput.value = precio.toFixed(2);
            actualizarPrecioDisplay();
            calcularComisionRecomendada();
        }
    } else {
        document.getElementById('infoModelo').style.display = 'none';
    }
}

function mostrarInfoVendedor() {
    const select = document.getElementById('vendedorSelect');
    const option = select.options[select.selectedIndex];
    const infoVendedorDiv = document.getElementById('infoVendedor');
    
    if (option.value) {
        const email = option.getAttribute('data-email');
        const telefono = option.getAttribute('data-telefono');
        const comisionBase = parseFloat(option.getAttribute('data-comision-base')) || 5;
        const ventasMes = option.getAttribute('data-ventas-mes') || '0';
        
        document.getElementById('vendedorEmail').textContent = email || 'No disponible';
        document.getElementById('vendedorTelefono').textContent = telefono || 'No disponible';
        document.getElementById('vendedorComisionBase').textContent = comisionBase + '%';
        document.getElementById('vendedorVentasMes').textContent = ventasMes;
        
        infoVendedorDiv.style.display = 'block';
        
        // Calcular comisión recomendada
        calcularComisionRecomendada();
        
    } else {
        infoVendedorDiv.style.display = 'none';
    }
}

function calcularComisionRecomendada() {
    const precio = parseFloat(document.getElementById('precioVenta').value) || 0;
    const vendedorSelect = document.getElementById('vendedorSelect');
    const option = vendedorSelect.options[vendedorSelect.selectedIndex];
    
    if (option.value && precio > 0) {
        const comisionBase = parseFloat(option.getAttribute('data-comision-base')) || 5;
        const comisionRecomendada = precio * (comisionBase / 100);
        
        document.getElementById('comisionRecomendada').textContent = 
            '$' + comisionRecomendada.toLocaleString('es-PE', {minimumFractionDigits: 2});
        
        // Autocompletar campo de comisión si está vacío
        const comisionInput = document.querySelector('[th\\:field="*{comisionVendedor}"]');
        if (!comisionInput.value || comisionInput.value === '0') {
            comisionInput.value = comisionRecomendada.toFixed(2);
        }
    }
}

function actualizarPrecioDisplay() {
    const precio = parseFloat(document.getElementById('precioVenta').value) || 0;
    document.getElementById('totalDisplay').textContent = '$' + precio.toLocaleString('es-PE', {minimumFractionDigits: 2});
    
    // Recalcular comisión cuando cambia el precio
    calcularComisionRecomendada();
}

function validarFormulario() {
    const cliente = document.getElementById('clienteSelect').value;
    const modelo = document.getElementById('modeloSelect').value;
    const vendedor = document.getElementById('vendedorSelect').value;
    const precio = document.getElementById('precioVenta').value;
    const metodoPago = document.querySelector('[th\\:field="*{metodoPagoId}"]').value;
    const estado = document.querySelector('[th\\:field="*{estado}"]').value;
    const comision = document.querySelector('[th\\:field="*{comisionVendedor}"]').value;
    
    // Validaciones básicas
    if (!cliente) {
        alert('Por favor, seleccione un cliente');
        return false;
    }
    
    if (!modelo) {
        alert('Por favor, seleccione un modelo de auto');
        return false;
    }
    
    if (!vendedor) {
        alert('Por favor, seleccione un vendedor responsable');
        return false;
    }
    
    if (!precio || parseFloat(precio) <= 0) {
        alert('El precio de venta debe ser mayor a 0');
        return false;
    }
    
    if (!metodoPago) {
        alert('Por favor, seleccione un método de pago');
        return false;
    }
    
    if (!estado) {
        alert('Por favor, seleccione un estado para la venta');
        return false;
    }
    
    // Validación adicional: comisión no puede ser mayor al 30% del precio
    if (comision && parseFloat(comision) > (parseFloat(precio) * 0.3)) {
        alert('La comisión no puede ser mayor al 30% del precio de venta');
        return false;
    }
    
    return confirm('¿Está seguro de registrar esta venta? Esta acción no se puede deshacer fácilmente.');
}

// Función para formatear input de precio en tiempo real
function formatearPrecioInput(event) {
    const input = event.target;
    let value = input.value.replace(/[^\d.]/g, '');
    
    // Permitir solo un punto decimal
    const parts = value.split('.');
    if (parts.length > 2) {
        value = parts[0] + '.' + parts.slice(1).join('');
    }
    
    // Limitar a 2 decimales
    if (parts.length === 2 && parts[1].length > 2) {
        value = parts[0] + '.' + parts[1].substring(0, 2);
    }
    
    input.value = value;
    actualizarPrecioDisplay();
}

// Función para sugerir vendedor basado en el modelo seleccionado
function sugerirVendedor() {
    const modeloSelect = document.getElementById('modeloSelect');
    const vendedorSelect = document.getElementById('vendedorSelect');
    
    if (modeloSelect.value && vendedorSelect.value === "") {
        // Aquí podrías implementar lógica para sugerir vendedores especializados
        // Por ejemplo, basado en la marca del auto o tipo de vehículo
        console.log('Podría sugerir un vendedor especializado para este modelo');
    }
}

// Event listeners para actualización en tiempo real
document.addEventListener('DOMContentLoaded', function() {
    const precioVentaInput = document.getElementById('precioVenta');
    const vendedorSelect = document.getElementById('vendedorSelect');
    const modeloSelect = document.getElementById('modeloSelect');
    
    // Actualizar precio mientras se escribe
    precioVentaInput.addEventListener('input', formatearPrecioInput);
    
    // Actualizar cuando cambia el modelo
    modeloSelect.addEventListener('change', function() {
        setTimeout(actualizarPrecioDisplay, 100);
        sugerirVendedor();
    });
    
    // Mostrar info del vendedor cuando se selecciona
    vendedorSelect.addEventListener('change', mostrarInfoVendedor);
    
    // Actualizar comisión cuando cambia manualmente
    const comisionInput = document.querySelector('[th\\:field="*{comisionVendedor}"]');
    if (comisionInput) {
        comisionInput.addEventListener('change', function() {
            // Validar que la comisión no sea excesiva
            const precio = parseFloat(document.getElementById('precioVenta').value) || 0;
            const comision = parseFloat(this.value) || 0;
            
            if (comision > (precio * 0.3)) {
                alert('Advertencia: La comisión es mayor al 30% del precio de venta');
            }
        });
    }
    
    // Inicializar el display del precio
    actualizarPrecioDisplay();
});

// Función para calcular comisión automática
function calcularComisionAutomatica() {
    const precio = parseFloat(document.getElementById('precioVenta').value) || 0;
    const comisionInput = document.querySelector('[th\\:field="*{comisionVendedor}"]');
    
    if (precio > 0 && (!comisionInput.value || comisionInput.value === '0')) {
        calcularComisionRecomendada();
    }
}

// Llamar a calcular comisión cuando cambie el precio
document.addEventListener('DOMContentLoaded', function() {
    const precioVentaInput = document.getElementById('precioVenta');
    precioVentaInput.addEventListener('change', calcularComisionAutomatica);
});

// Función para resetear el formulario
function resetearFormulario() {
    if (confirm('¿Está seguro de que desea limpiar todos los campos?')) {
        document.getElementById('infoCliente').style.display = 'none';
        document.getElementById('infoModelo').style.display = 'none';
        document.getElementById('infoVendedor').style.display = 'none';
        document.getElementById('totalDisplay').textContent = '$0.00';
    }
}