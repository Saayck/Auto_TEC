 function mostrarInfo(titulo, descripcion) {
      document.getElementById("modalTitle").innerText = titulo;
      document.getElementById("modalBody").innerText = descripcion;
      new bootstrap.Modal(document.getElementById('infoModal')).show();
    }

    function mostrarPersonalizacion(modelo) {
      new bootstrap.Modal(document.getElementById('personalizacionModal')).show();
    }

    function cerrarPersonalizacion() {
      new bootstrap.Modal(document.getElementById('personalizacionModal')).hide();
    }

    function mostrarCotizacion(modelo) {
      document.getElementById("cotizacionNombre").value = "";
      document.getElementById("cotizacionCorreo").value = "";
      document.getElementById("cotizacionTelefono").value = "";
      document.getElementById("cotizacionMensaje").value = `Quiero una cotización del modelo ${modelo}.`;
      new bootstrap.Modal(document.getElementById('cotizacionModal')).show();
    }

    document.getElementById('formCotizacion').addEventListener("submit", e => {
      e.preventDefault();
      const nombre = document.getElementById("cotizacionNombre").value.trim();
      const correo = document.getElementById("cotizacionCorreo").value.trim();
      const telefono = document.getElementById("cotizacionTelefono").value.trim();
      const mensaje = document.getElementById("cotizacionMensaje").value.trim();

      if (nombre.length < 3 || !correo || !correo.includes("@") || telefono.length < 7 || mensaje.length < 5) {
        return;
      }

      new bootstrap.Modal(document.getElementById('cotizacionModal')).hide();
      document.getElementById('formCotizacion').reset();
    });
