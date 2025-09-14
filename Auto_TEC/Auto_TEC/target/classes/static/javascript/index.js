// ====== VARIABLES ======
const loader = document.getElementById("loader");
const contenido = document.getElementById("contenido");
const loginContainer = document.getElementById("login-container");
const saludoBanner = document.getElementById("saludo-banner");
const saludoNombre = document.getElementById("saludo-nombre");
const btnCerrarSaludo = document.getElementById("btn-cerrar-saludo");
const loginForm = document.getElementById("loginForm");
const loginError = document.getElementById("login-error");
const toastNotif = document.getElementById("toast-notificacion");
const toastMsg = document.getElementById("toast-mensaje");
const modalCotizacion = document.getElementById("modalCotizacion")
  ? new bootstrap.Modal(document.getElementById("modalCotizacion"))
  : null;
const formCotizacion = document.getElementById("formCotizacion");
const autoSeleccionadoInput = document.getElementById("autoSeleccionado");

// ====== LOADER ======
window.addEventListener("load", () => {
  if (loader) {
    loader.style.opacity = "0";
    setTimeout(() => {
      loader.style.display = "none";
      if (loginContainer) loginContainer.classList.add("visible");
    }, 1200);
  }
});

// ====== TOAST ======
function mostrarToast(mensaje) {
  if (!toastNotif || !toastMsg) return;
  toastMsg.textContent = mensaje;
  toastNotif.hidden = false;
  toastNotif.classList.add("show");

  setTimeout(() => {
    toastNotif.classList.remove("show");
    setTimeout(() => (toastNotif.hidden = true), 500);
  }, 2500);
}

// ====== LOGIN ======
if (loginForm) {
  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    if (username === "admin" && password === "1234") {
      loginError.style.display = "none";
      loginContainer.style.display = "none";
      saludoBanner.style.display = "flex";
      saludoNombre.textContent = username;
      contenido.style.display = "block";
      mostrarToast("Inicio de sesión exitoso ✅");
    } else {
      loginError.style.display = "block";
      mostrarToast("❌ Usuario o contraseña incorrectos");
    }
  });
}

if (btnCerrarSaludo) {
  btnCerrarSaludo.addEventListener("click", () => {
    saludoBanner.style.display = "none";
  });
}

// ====== DETALLES DE AUTOS ======
const detallesAutos = {
  "Nissan GT-R": {
    precio: "$120,000",
    motor: "3.8L V6 Twin Turbo",
    potencia: "565 HP",
    velocidad: "315 km/h",
    aceleracion: "2.9s (0-100 km/h)",
  },
  "Toyota Supra": {
    precio: "$55,000",
    motor: "3.0L V6 Twin Turbo",
    potencia: "382 HP",
    velocidad: "250 km/h",
    aceleracion: "4.1s (0-100 km/h)",
  },
  "Mazda RX-7": {
    precio: "$45,000",
    motor: "1.3L Twin Turbo Rotary",
    potencia: "276 HP",
    velocidad: "250 km/h",
    aceleracion: "5.3s (0-100 km/h)",
  },
};

function mostrarDetalles(modelo) {
  const detalle = detallesAutos[modelo];
  if (!detalle) return;

  const modalTitulo = document.getElementById("modalTitulo");
  const modalCuerpo = document.getElementById("modalCuerpo");

  if (modalTitulo && modalCuerpo) {
    modalTitulo.textContent = modelo;
    modalCuerpo.innerHTML = `
      <div class="row g-3">
        <div class="col-md-6">
          <h6>Especificaciones</h6>
          <ul class="list-unstyled mb-0">
            <li><strong>Precio:</strong> ${detalle.precio}</li>
            <li><strong>Motor:</strong> ${detalle.motor}</li>
            <li><strong>Potencia:</strong> ${detalle.potencia}</li>
            <li><strong>Velocidad máxima:</strong> ${detalle.velocidad}</li>
            <li><strong>Aceleración:</strong> ${detalle.aceleracion}</li>
          </ul>
        </div>
        <div class="col-md-6">
          <p>Este excepcional vehículo representa la cúspide de la ingeniería automotriz.</p>
          <p class="mb-1"><strong>Disponible para:</strong></p>
          <ul class="mb-0">
            <li>Venta directa</li>
            <li>Financiamiento</li>
            <li>Leasing</li>
          </ul>
        </div>
      </div>`;
    const modal = new bootstrap.Modal(document.getElementById("modalDetalles"));
    modal.show();
  }
}

// ====== COTIZACIÓN ======
function abrirCotizacion(modelo) {
  if (autoSeleccionadoInput) autoSeleccionadoInput.value = modelo;
  if (modalCotizacion) modalCotizacion.show();
}

if (formCotizacion) {
  formCotizacion.addEventListener("submit", (e) => {
    e.preventDefault();
    mostrarToast("📩 Cotización enviada con éxito");
    modalCotizacion.hide();
    formCotizacion.reset();
  });
}

// ====== SCROLL SUAVE ======
document.querySelectorAll('a[href^="#"]').forEach((anchor) => {
  anchor.addEventListener("click", function (e) {
    e.preventDefault();
    const destino = document.querySelector(this.getAttribute("href"));
    if (destino) {
      destino.scrollIntoView({ behavior: "smooth" });
    }
  });
});
