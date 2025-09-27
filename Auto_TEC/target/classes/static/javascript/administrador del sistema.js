
    // Datos de ejemplo (se puede reemplazar por llamadas a API)
    const sampleUsers = [
      { id: 1, name: 'María Gómez', email: 'maria@example.com', role: 'admin', status: 'Activo' },
      { id: 2, name: 'José Pérez', email: 'jose@example.com', role: 'editor', status: 'Activo' },
      { id: 3, name: 'Luisa Fernández', email: 'luisa@example.com', role: 'viewer', status: 'Inactivo' },
    ];

    // Estado local
    let users = [...sampleUsers];

    // Elementos DOM
    const usersTbody = document.getElementById('usersTbody');
    const totalUsersEl = document.getElementById('totalUsers');
    const cardEls = document.querySelectorAll('.card');
    const modalBackdrop = document.getElementById('modalBackdrop');
    const openAddUserBtn = document.getElementById('openAddUser');
    const modalCancel = document.getElementById('modalCancel');
    const modalSave = document.getElementById('modalSave');
    const toast = document.getElementById('toast');
    const searchInput = document.getElementById('searchInput');
    const filterRole = document.getElementById('filterRole');

    // Campos modal
    const fieldName = document.getElementById('fieldName');
    const fieldEmail = document.getElementById('fieldEmail');
    const fieldRole = document.getElementById('fieldRole');
    const fieldStatus = document.getElementById('fieldStatus');

    // Inicialización
    document.addEventListener('DOMContentLoaded', () => {
      renderUsers(users);
      updateStats();
      // animar cards
      setTimeout(() => cardEls.forEach(c => c.classList.add('visible')), 120);
    });

    function renderUsers(list){
      usersTbody.innerHTML = '';
      if(!list.length){
        usersTbody.innerHTML = '<tr><td colspan="5" style="color:#999; padding:18px">No hay usuarios</td></tr>';
        return;
      }
      list.forEach(u => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
          <td>${escapeHtml(u.name)}</td>
          <td>${escapeHtml(u.email)}</td>
          <td style="text-transform:capitalize">${escapeHtml(u.role)}</td>
          <td>${escapeHtml(u.status)}</td>
          <td style="text-align:right" class="table-actions">
            <button class="btn" data-action="edit" data-id="${u.id}">Editar</button>
            <button class="btn btn-warning" data-action="toggle" data-id="${u.id}">${u.status === 'Activo' ? 'Desactivar' : 'Activar'}</button>
            <button class="btn btn-cyan" data-action="delete" data-id="${u.id}">Eliminar</button>
          </td>
        `;
        usersTbody.appendChild(tr);
      });
    }

    // Safe escape
    function escapeHtml(unsafe){
      return (''+unsafe).replace(/[&<>"']/g, function(m){ return ({'&':'&amp;','<':'&lt;','>':'&gt;','"':'&quot;',"'":"&#39;"})[m]; });
    }

    function updateStats(){
      totalUsersEl.textContent = users.length;
    }

    // Eventos delegados tabla
    usersTbody.addEventListener('click', (e) =>{
      const btn = e.target.closest('button');
      if(!btn) return;
      const action = btn.dataset.action;
      const id = Number(btn.dataset.id);
      if(action === 'edit') return openEditUser(id);
      if(action === 'toggle') return toggleStatus(id);
      if(action === 'delete') return deleteUser(id);
    });

    // BUSCAR / FILTRAR
    searchInput.addEventListener('input', applyFilters);
    filterRole.addEventListener('change', applyFilters);

    function applyFilters(){
      const q = (searchInput.value || '').toLowerCase().trim();
      const role = filterRole.value;
      const filtered = users.filter(u => {
        const matchesQ = q === '' || u.name.toLowerCase().includes(q) || u.email.toLowerCase().includes(q) || u.role.toLowerCase().includes(q);
        const matchesRole = role === '' || u.role === role;
        return matchesQ && matchesRole;
      });
      renderUsers(filtered);
    }

    // Modal
    openAddUserBtn.addEventListener('click', ()=>{
      openCreateUser();
    });
    modalCancel.addEventListener('click', closeModal);
    modalBackdrop.addEventListener('click', (e)=>{ if(e.target === modalBackdrop) closeModal(); });

    function openCreateUser(){
      modalBackdrop.style.display = 'flex';
      document.getElementById('modalTitle').textContent = 'Crear Usuario';
      fieldName.value = '';
      fieldEmail.value = '';
      fieldRole.value = 'viewer';
      fieldStatus.value = 'Activo';
      modalSave.dataset.editId = '';
    }

    function openEditUser(id){
      const u = users.find(x=>x.id===id); if(!u) return showToast('Usuario no encontrado');
      modalBackdrop.style.display = 'flex';
      document.getElementById('modalTitle').textContent = 'Editar Usuario';
      fieldName.value = u.name;
      fieldEmail.value = u.email;
      fieldRole.value = u.role;
      fieldStatus.value = u.status;
      modalSave.dataset.editId = id;
    }

    function closeModal(){ modalBackdrop.style.display = 'none'; }

    modalSave.addEventListener('click', ()=>{
      const name = fieldName.value.trim();
      const email = fieldEmail.value.trim();
      const role = fieldRole.value;
      const status = fieldStatus.value.trim() || 'Activo';
      if(!name || !email){ showToast('Completa nombre y correo'); return; }

      const editId = modalSave.dataset.editId;
      if(editId){ // editar
        const idx = users.findIndex(x=>x.id===Number(editId));
        if(idx>-1){ users[idx] = { ...users[idx], name, email, role, status }; showToast('Usuario actualizado'); }
      } else { // crear
        const newId = users.length ? Math.max(...users.map(u=>u.id)) + 1 : 1;
        users.push({ id:newId, name, email, role, status });
        showToast('Usuario creado');
      }
      closeModal(); renderUsers(users); updateStats();
    });

    function toggleStatus(id){
      const idx = users.findIndex(x=>x.id===id); if(idx===-1) return showToast('Usuario no encontrado');
      users[idx].status = users[idx].status === 'Activo' ? 'Inactivo' : 'Activo';
      renderUsers(users); showToast('Estado actualizado');
    }

    function deleteUser(id){
      if(!confirm('¿Eliminar usuario? Esta acción no se puede deshacer.')) return;
      users = users.filter(u=>u.id!==id);
      renderUsers(users); updateStats(); showToast('Usuario eliminado');
    }

    // Export CSV simple
    document.getElementById('exportCSV').addEventListener('click', ()=>{
      const csvRows = [];
      const headers = ['id','name','email','role','status'];
      csvRows.push(headers.join(','));
      users.forEach(u=> csvRows.push([u.id, `"${u.name.replace(/"/g,'""')}")`, u.email, u.role, u.status].join(',')));
      const csv = csvRows.join('\n');
      const blob = new Blob([csv], { type: 'text/csv' });
      const url = URL.createObjectURL(blob);
      const a = document.createElement('a'); a.href = url; a.download = 'usuarios.csv'; document.body.appendChild(a); a.click(); a.remove(); URL.revokeObjectURL(url);
    });

    // Toast
    function showToast(text, ms=2000){
      toast.textContent = text; toast.style.display = 'block';
      setTimeout(()=> toast.style.display = 'none', ms);
    }

    // Accessibility: keyboard shortcuts
    document.addEventListener('keydown', (e)=>{
      if(e.key === 'n' && (e.ctrlKey || e.metaKey)) { e.preventDefault(); openCreateUser(); }
    });

  