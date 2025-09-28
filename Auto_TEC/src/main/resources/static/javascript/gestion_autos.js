
    let autos = [];
    let idAuto = 1;

    function renderAutos(){
      const tbody = document.getElementById('tabla-autos');
      tbody.innerHTML = '';
      autos.forEach(auto => {
        tbody.innerHTML += `
          <tr>
            <td>${auto.id}</td>
            <td><img src="${auto.foto}" alt="${auto.modelo}" class="car-img"></td>
            <td>${auto.modelo}</td>
            <td>${auto.marca}</td>
            <td>$${auto.precio}</td>
            <td>${auto.estado}</td>
            <td>
              <button class="btn btn-edit" onclick="editarAuto(${auto.id})">Editar</button>
              <button class="btn btn-delete" onclick="eliminarAuto(${auto.id})">Eliminar</button>
            </td>
          </tr>`;
      });
      actualizarIndicadores();
    }

    function actualizarIndicadores(){
      document.getElementById('total-autos').textContent = autos.length;
      document.getElementById('autos-disponibles').textContent = autos.filter(a => a.estado === 'Disponible').length;
      document.getElementById('autos-vendidos').textContent = autos.filter(a => a.estado === 'Vendido').length;
    }

    function abrirModal(){
      document.getElementById('modal').style.display = 'flex';
    }
    function cerrarModal(){
      document.getElementById('modal').style.display = 'none';
    }

    function guardarAuto(){
      const modelo = document.getElementById('modelo').value;
      const marca = document.getElementById('marca').value;
      const precio = document.getElementById('precio').value;
      const foto = document.getElementById('foto').value;
      const estado = document.getElementById('estado').value;

      autos.push({ id: idAuto++, modelo, marca, precio, foto, estado });
      cerrarModal();
      renderAutos();
    }

    function eliminarAuto(id){
      autos = autos.filter(a => a.id !== id);
      renderAutos();
    }

    function editarAuto(id){
      alert('Función de edición pendiente para Auto ID: ' + id);
    }

    renderAutos();
  