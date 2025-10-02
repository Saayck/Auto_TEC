// ========== FUNCIONES GLOBALES ==========

// Confirmar eliminación
function confirmarEliminar(id, nombre, tipo) {
    if (confirm(`¿Estás seguro de eliminar ${tipo} "${nombre}"?`)) {
        eliminar(id, tipo);
    }
}

// Eliminar elemento
function eliminar(id, tipo) {
    let url;
    switch(tipo) {
        case 'modelo':
            url = `/admin/modelos/eliminar/${id}`;
            break;
        case 'venta':
            url = `/admin/ventas/eliminar/${id}`;
            break;
        case 'cliente':
            url = `/admin/clientes/eliminar/${id}`;
            break;
        default:
            url = `/admin/${tipo}/eliminar/${id}`;
    }
    
    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        }
    })
    .then(response => {
        if (response.ok) {
            mostrarNotificacion('✅ Eliminado correctamente', 'success');
            setTimeout(() => location.reload(), 1500);
        } else {
            mostrarNotificacion('❌ Error al eliminar', 'error');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        mostrarNotificacion('❌ Error de conexión', 'error');
    });
}

// Cambiar estado (activo/inactivo)
function toggleEstado(id, tipo, estadoActual) {
    const nuevoEstado = !estadoActual;
    const url = `/admin/${tipo}/${id}/estado`;
    
    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ activo: nuevoEstado })
    })
    .then(response => {
        if (response.ok) {
            mostrarNotificacion('✅ Estado actualizado', 'success');
            setTimeout(() => location.reload(), 1000);
        } else {
            mostrarNotificacion('❌ Error al actualizar', 'error');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        mostrarNotificacion('❌ Error de conexión', 'error');
    });
}

// Marcar como destacado
function toggleDestacado(id) {
    fetch(`/admin/modelos/${id}/destacado`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        }
    })
    .then(response => {
        if (response.ok) {
            mostrarNotificacion('✅ Actualizado', 'success');
            setTimeout(() => location.reload(), 1000);
        } else {
            mostrarNotificacion('❌ Error', 'error');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        mostrarNotificacion('❌ Error de conexión', 'error');
    });
}

// Cambiar estado de venta
function cambiarEstadoVenta(ventaId, nuevoEstado) {
    if (confirm(`¿Cambiar estado a ${nuevoEstado}?`)) {
        fetch(`/admin/ventas/${ventaId}/estado`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ estado: nuevoEstado })
        })
        .then(response => {
            if (response.ok) {
                mostrarNotificacion(`✅ Estado cambiado a ${nuevoEstado}`, 'success');
                setTimeout(() => location.reload(), 1500);
            } else {
                mostrarNotificacion('❌ Error al cambiar estado', 'error');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            mostrarNotificacion('❌ Error de conexión', 'error');
        });
    }
}

// Actualizar stock
function actualizarStock(id, cantidad) {
    fetch(`/admin/modelos/${id}/stock`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ stock: cantidad })
    })
    .then(response => {
        if (response.ok) {
            mostrarNotificacion('✅ Stock actualizado', 'success');
            setTimeout(() => location.reload(), 1000);
        } else {
            mostrarNotificacion('❌ Error al actualizar stock', 'error');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        mostrarNotificacion('❌ Error de conexión', 'error');
    });
}

// Búsqueda en tabla
function buscarEnTabla(inputId, tableId) {
    const input = document.getElementById(inputId);
    const filter = input.value.toUpperCase();
    const table = document.getElementById(tableId);
    const tr = table.getElementsByTagName('tr');
    
    for (let i = 1; i < tr.length; i++) {
        let encontrado = false;
        const td = tr[i].getElementsByTagName('td');
        
        for (let j = 0; j < td.length; j++) {
            if (td[j]) {
                const txtValue = td[j].textContent || td[j].innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    encontrado = true;
                    break;
                }
            }
        }
        
        tr[i].style.display = encontrado ? '' : 'none';
    }
}

// Filtrar por estado
function filtrarPorEstado(estado) {
    if (estado === 'TODOS') {
        window.location.href = '/admin/gestion_ventas';
    } else {
        window.location.href = `/admin/gestion_ventas/estado/${estado}`;
    }
}

// Mostrar modal
function mostrarModal(modalId) {
    const modal = document.getElementById(modalId);
    if (modal) {
        modal.style.display = 'flex';
        document.body.style.overflow = 'hidden';
    }
}

// Cerrar modal
function cerrarModal(modalId) {
    const modal = document.getElementById(modalId);
    if (modal) {
        modal.style.display = 'none';
        document.body.style.overflow = 'auto';
    }
}

// Cerrar modal al hacer clic fuera
window.onclick = function(event) {
    const modals = document.getElementsByClassName('modal');
    for (let modal of modals) {
        if (event.target === modal) {
            modal.style.display = 'none';
            document.body.style.overflow = 'auto';
        }
    }
}

// Mostrar notificación
function mostrarNotificacion(mensaje, tipo = 'info') {
    // Crear elemento de notificación
    const notificacion = document.createElement('div');
    notificacion.className = `notificacion notificacion-${tipo}`;
    notificacion.innerHTML = `
        <span>${mensaje}</span>
        <button onclick="this.parentElement.remove()">✕</button>
    `;
    
   
        document.head.appendChild(style);
    }
    
    // Agregar al body
    document.body.appendChild(notificacion);
    
    // Auto-eliminar después de 5 segundos
    setTimeout(() => {
        notificacion.style.animation = 'slideOut 0.3s ease-in';
        setTimeout(() => notificacion.remove(), 300);
    }, 5000);

// Previsualizar imagen
function previsualizarImagen(input) {
    if (input.files && input.files[0]) {
        const reader = new FileReader();
        
        reader.onload = function(e) {
            const preview = document.getElementById('preview-imagen');
            if (preview) {
                preview.src = e.target.result;
                preview.style.display = 'block';
            }
        }
        
        reader.readAsDataURL(input.files[0]);
    }
}

// Validar formulario
function validarFormulario(formId) {
    const form = document.getElementById(formId);
    if (!form) return false;
    
    const inputs = form.querySelectorAll('[required]');
    let valido = true;
    
    inputs.forEach(input => {
        if (!input.value.trim()) {
            input.style.borderColor = '#dc3545';
            valido = false;
        } else {
            input.style.borderColor = '#28a745';
        }
    });
    
    if (!valido) {
        mostrarNotificacion('❌ Por favor completa todos los campos obligatorios', 'error');
    }
    
    return valido;
}

// Formatear precio
function formatearPrecio(precio) {
    return new Intl.NumberFormat('es-PE', {
        style: 'currency',
        currency: 'PEN'
    }).format(precio);
}
