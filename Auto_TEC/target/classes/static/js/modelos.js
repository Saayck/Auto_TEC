// ===========================
// Manejo de favoritos
// ===========================
document.querySelectorAll(".btn-favorite").forEach(btn => {
  btn.addEventListener("click", () => {
    btn.classList.toggle("active");
    if (btn.classList.contains("active")) {
      btn.innerHTML = '<i class="fa fa-star text-dark"></i>';
      alert("Añadido a favoritos ⭐");
    } else {
      btn.innerHTML = '<i class="fa fa-star"></i>';
      alert("Eliminado de favoritos ❌");
    }
  });
});

// ===========================
// Modal de compra
// ===========================
const buyButtons = document.querySelectorAll(".btn-buy");
const carModelSpan = document.getElementById("carModel");

buyButtons.forEach(button => {
  button.addEventListener("click", () => {
    const model = button.getAttribute("data-model");
    carModelSpan.textContent = model;
  });
});

// ===========================
// Animación de scroll
// ===========================
window.addEventListener("scroll", () => {
  const nav = document.querySelector(".navbar");
  if (window.scrollY > 50) {
    nav.classList.add("shadow-lg");
  } else {
    nav.classList.remove("shadow-lg");
  }
});
// ===========================
// Confirmar compra
// ===========================
const confirmBuyBtn = document.getElementById("confirmBuy");

confirmBuyBtn.addEventListener("click", () => {
  const car = carModelSpan.textContent;
  if (car) {
    alert(`🚗 Has iniciado la compra del ${car}. Nuestro equipo se pondrá en contacto contigo.`);
    // Aquí podrías enviar la compra a una API o backend
    const modal = bootstrap.Modal.getInstance(document.getElementById("buyModal"));
    modal.hide(); // cierra el modal luego de confirmar
  }
});
