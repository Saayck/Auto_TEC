const canvas = document.getElementById("c");
const ctx = canvas.getContext("2d");
let W = canvas.width = innerWidth;
let H = canvas.height = innerHeight;

window.addEventListener("resize", () => {
  W = canvas.width = innerWidth;
  H = canvas.height = innerHeight;
});

class Particle {
  constructor(x, y) {
    this.x = x; this.y = y;
    this.vx = (Math.random() - 0.5) * 4;
    this.vy = (Math.random() - 0.5) * 4;
    this.size = Math.random() * 3 + 1;
    this.life = 80 + Math.random() * 60;
    this.color = Math.random() < 0.5 ? "#e63946" : "#6ee7f6";
  }
  update() {
    this.x += this.vx; this.y += this.vy; this.life--;
  }
  draw() {
    ctx.fillStyle = this.color;
    ctx.beginPath();
    ctx.arc(this.x, this.y, this.size, 0, Math.PI * 2);
    ctx.fill();
  }
}

let particles = [];

function animate() {
  ctx.clearRect(0, 0, W, H);
  particles.forEach((p, i) => {
    p.update(); p.draw();
    if (p.life <= 0) particles.splice(i, 1);
  });
  requestAnimationFrame(animate);
}
animate();

// Control de secuencia
const ignite = document.getElementById("ignite");
const ui = document.getElementById("ui");
const car = document.getElementById("car");
const engine = document.getElementById("engine");
const mainContent = document.getElementById("mainContent");

ignite.addEventListener("click", () => {
  ui.style.display = "none";
  engine.currentTime = 0; engine.play(); // arranca el audio

  // Pulso inicial de partículas
  for (let i = 0; i < 200; i++) {
    particles.push(new Particle(W / 2, H / 2));
  }

  // Mostrar coche
  setTimeout(() => {
    car.style.opacity = 1;
    car.style.filter = "brightness(1)";
  }, 800);

  // Explosión de partículas alrededor del coche
  setTimeout(() => {
    for (let i = 0; i < 400; i++) {
      const angle = Math.random() * Math.PI * 2;
      const radius = Math.random() * 150;
      const x = W / 2 + Math.cos(angle) * radius;
      const y = H / 2 + Math.sin(angle) * radius;
      particles.push(new Particle(x, y));
    }
  }, 2000);

  // Logo final
  setTimeout(() => {
    car.style.opacity = 0;
    mainContent.classList.add("visible");
  }, 4000);

  // 🔗 Redirección automática
  setTimeout(() => {
    window.location.href = "index.html";
  }, 6000);
});
