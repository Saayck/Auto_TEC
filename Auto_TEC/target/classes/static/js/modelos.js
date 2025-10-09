document.addEventListener("DOMContentLoaded", () => {
  const items = document.querySelectorAll(".modelo-item");
  const modal = new bootstrap.Modal(document.getElementById("modalModelo"));
  const modalTitulo = document.getElementById("modalModeloLabel");
  const modalImagen = document.getElementById("modalImagen");
  const modalDescripcion = document.getElementById("modalDescripcion");

  // Crear imagen de previsualización
  const preview = document.createElement("img");
  preview.className = "preview-img";
  document.body.appendChild(preview);

  items.forEach(item => {
    const imgSrc = item.getAttribute("data-img");
    const desc = item.getAttribute("data-desc");

    // Hover → mostrar previsualización
    item.addEventListener("mouseenter", e => {
      preview.src = imgSrc;
      preview.style.display = "block";
    });

    // Salir → ocultar previsualización
    item.addEventListener("mouseleave", () => {
      preview.style.display = "none";
    });

    // Click → abrir modal con info
    item.addEventListener("click", () => {
      modalTitulo.textContent = item.textContent.trim();
      modalImagen.src = imgSrc;
      modalDescripcion.textContent = desc;

      items.forEach(i => i.classList.remove("active"));
      item.classList.add("active");

      modal.show();
    });
  });
});
