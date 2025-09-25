// -------------------- ELEMENTOS --------------------
const loader = document.getElementById("loader");
const contenido = document.getElementById("contenido");
// loginContainer eliminado porque no existe en esta página
const saludoBanner = document.getElementById("saludo-banner");
const saludoNombre = document.getElementById("saludo-nombre");
const btnCerrarSaludo = document.getElementById("btn-cerrar-saludo");
const loginForm = document.getElementById("loginForm");
const loginError = document.getElementById("login-error");
const toastNotif = document.getElementById("toast-notificacion");
const toastMsg = document.getElementById("toast-mensaje");
const modalCotizacion = new bootstrap.Modal(document.getElementById('modalCotizacion'));
const modalDetalles = new bootstrap.Modal(document.getElementById("modalDetalles")); // instancia global
const formCotizacion = document.getElementById('formCotizacion');
const autoSeleccionadoInput = document.getElementById('autoSeleccionado');

// -------------------- LOADER --------------------
window.addEventListener("load", () => {
  loader.style.opacity = "0";
  setTimeout(() => {
    loader.style.display = "none";
  }, 1200);
});

// -------------------- MOSTRAR DETALLES --------------------
function mostrarDetalles(modelo) {
  const detalle = detallesAutos[modelo];
  if (!detalle) return;

  const modalTitulo = document.getElementById("modalTitulo");
  const modalCuerpo = document.getElementById("modalCuerpo");

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
    </div>
  `;

  modalDetalles.show();
}

// -------------------- COTIZACIÓN --------------------
function solicitarCotizacion(modelo) {
  autoSeleccionadoInput.value = modelo;
  modalCotizacion.show();
}

formCotizacion.addEventListener("submit", e => {
  e.preventDefault();
  const nombre = document.getElementById("cotizacionNombre").value.trim();
  const correo = document.getElementById("cotizacionCorreo").value.trim();

  if (nombre.length < 3) {
    mostrarToast("Por favor ingresa un nombre válido.", 4000);
    return;
  }
  if (!correo || !correo.includes("@")) {
    mostrarToast("Por favor ingresa un correo válido.", 4000);
    return;
  }

  modalCotizacion.hide();
  mostrarToast("¡Gracias por solicitar la cotización! Nuestro equipo contactará pronto.");
  formCotizacion.reset();
});

// -------------------- TOAST --------------------
function mostrarToast(mensaje, tiempo = 3000) {
  toastMsg.textContent = mensaje;
  toastNotif.classList.add("visible");
  setTimeout(() => {
    toastNotif.classList.remove("visible");
  }, tiempo);
}

// -------------------- SCROLL SUAVE --------------------
// Ya implementado por CSS scroll-behavior

// -------------------- NAV LINK ACTIVO --------------------
window.addEventListener("scroll", () => {
  let current = "";
  document.querySelectorAll("section").forEach(sec => {
    const top = sec.offsetTop - 130;
    if (window.pageYOffset >= top) current = sec.id;
  });
  document.querySelectorAll(".nav-link").forEach(link => {
    link.classList.remove("active");
    if (link.getAttribute("href") === "#" + current) link.classList.add("active");
  });
});

// -------------------- ANIMAR CARDS --------------------
const cards = document.querySelectorAll(".card.card-anim");
const observerOptions = { threshold: 0.15 };

const observer = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('visible');
      observer.unobserve(entry.target);
    }
  });
}, observerOptions);

cards.forEach(card => observer.observe(card));

// -------------------- DATOS AUTOS --------------------
const detallesAutos = {
  "Koenigsegg Jesko": {
    precio: "$3,000,000",
    motor: "V8 Twin-Turbo 5.0L",
    potencia: "1,600 HP",
    velocidad: "480 km/h",
    aceleracion: "0-100 km/h en 2.5s",
  },
  "Bugatti Chiron": {
    precio: "$3,500,000",
    motor: "W16 Quad-Turbo 8.0L",
    potencia: "1,500 HP",
    velocidad: "420 km/h",
    aceleracion: "0-100 km/h en 2.4s",
  },
  "Koenigsegg Agera": {
    precio: "$2,800,000",
    motor: "V8 Twin-Turbo 5.0L",
    potencia: "1,360 HP",
    velocidad: "447 km/h",
    aceleracion: "0-100 km/h en 2.8s",
  },
  "McLaren P1": {
    precio: "$1,200,000",
    motor: "V8 Twin-Turbo Híbrido 3.8L",
    potencia: "903 HP",
    velocidad: "350+ km/h",
    aceleracion: "0-100 km/h en 2.8s",
  },
  "Ferrari LaFerrari": {
    precio: "$1,500,000",
    motor: "V12 Híbrido 6.3L",
    potencia: "963 HP",
    velocidad: "350 km/h",
    aceleracion: "0-100 km/h en 2.6s",
  },
  "Lamborghini Aventador": {
    precio: "$800,000",
    motor: "V12 6.5L",
    potencia: "770 HP",
    velocidad: "350 km/h",
    aceleracion: "0-100 km/h en 2.8s",
  },
  "Porsche 911 Turbo S": {
    precio: "$250,000",
    motor: "Bóxer 3.8L Biturbo",
    potencia: "640 HP",
    velocidad: "330 km/h",
    aceleracion: "0-100 km/h en 2.7s",
  },
  "Aston Martin DBS": {
    precio: "$350,000",
    motor: "V12 5.2L Biturbo",
    potencia: "715 HP",
    velocidad: "340 km/h",
    aceleracion: "0-100 km/h en 3.4s",
  },
  "Bugatti La Voiture Noire": {
    precio: "$18,700,000",
    motor: "W16 Quad-Turbo 8.0L",
    potencia: "1,479 HP",
    velocidad: "420 km/h",
    aceleracion: "0-100 km/h en 2.5s",
  },
  "Rimac Concept One": {
    precio: "$1,000,000",
    motor: "Eléctrico 4 Motores",
    potencia: "1,224 HP",
    velocidad: "355 km/h",
    aceleracion: "0-100 km/h en 2.6s",
  },
  "SF90": {
    precio: "$625,000",
    motor: "V8 Híbrido 4.0L",
    potencia: "986 HP",
    velocidad: "340 km/h",
    aceleracion: "0-100 km/h en 2.5s",
  }
};
