    let citas = [];
    let idCita = 1;

    function renderCitas(){
      const tbody = document.getElementById('tabla-citas');
      tbody.innerHTML = '';
      citas.forEach(cita => {
        tbody.innerHTML += `
          <tr>
            <td>${cita.id}</td>
            <td>${cita.cliente}</td>
            <td>${cita.fecha}</td>
            <td>${cita.hora}</td>
            <td>${cita.servicio}</td>
            <td>${cita.estado}</td>
            <td>
              <button class="btn btn-edit" onclick="editarCita(${cita.id})">Editar</button>
              <button class="btn btn-delete" onclick="eliminarCita(${cita.id})">Eliminar</button>
            </td>
          </tr>`;
      });
    }

    function abrirModal(){
      document.getElementById('modal').style.display = 'flex';
    }
    function cerrarModal(){
      document.getElementById('modal').style.display = 'none';
    }

    function guardarCita(){
      const cliente = document.getElementById('cliente').value;
      const fecha = document.getElementById('fecha').value;
      const hora = document.getElementById('hora').value;
      const servicio = document.getElementById('servicio').value;
      const estado = document.getElementById('estado').value;

      citas.push({ id: idCita++, cliente, fecha, hora, servicio, estado });
      cerrarModal();
      renderCitas();
    }

    function eliminarCita(id){
      citas = citas.filter(c => c.id !== id);
      renderCitas();
    }

    function editarCita(id){
      alert('Función de edición pendiente para Cita ID: ' + id);
    }

    renderCitas();