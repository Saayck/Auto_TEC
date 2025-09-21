// Configuración del canvas y contexto
const canvas = document.getElementById("c");
const ctx = canvas.getContext("2d");
let W = canvas.width = window.innerWidth;
let H = canvas.height = window.innerHeight;

window.addEventListener("resize", () => {
  W = canvas.width = window.innerWidth;
  H = canvas.height = window.innerHeight;
});

// Partículas de explosión
class Particle {
  constructor(x, y) {
    this.x = x;
    this.y = y;
    this.vx = (Math.random() - 0.5) * 8;
    this.vy = (Math.random() - 0.5) * 8;
    this.size = Math.random() * 4 + 1;
    this.life = 100 + Math.random() * 60;
    this.colors = ["#d4af37", "#a855f7", "#6ee7f6", "#e63946"];
    this.color = this.colors[Math.floor(Math.random() * this.colors.length)];
    this.alpha = 1;
  }
  update() {
    this.x += this.vx;
    this.y += this.vy;
    this.life--;
    this.alpha = this.life / 160;
    this.size *= 0.99;
  }
  draw() {
    ctx.globalAlpha = this.alpha;
    ctx.fillStyle = this.color;
    ctx.beginPath();
    ctx.arc(this.x, this.y, this.size, 0, Math.PI * 2);
    ctx.fill();
    ctx.globalAlpha = 1;
  }
}

let particles = [];

// Rayos de luz
class LightBeam {
  constructor() {
    this.angle = Math.random() * Math.PI * 2;
    this.speed = 2 + Math.random() * 2;
    this.length = 50 + Math.random() * 100;
    this.width = 2 + Math.random() * 3;
    this.x = W / 2;
    this.y = H / 2;
    this.color = `hsl(${Math.random() * 60 + 180}, 100%, 70%)`;
    this.life = 50 + Math.random() * 100;
  }
  update() {
    this.x += Math.cos(this.angle) * this.speed;
    this.y += Math.sin(this.angle) * this.speed;
    this.life--;
  }
  draw() {
    ctx.globalAlpha = this.life / 150;
    ctx.strokeStyle = this.color;
    ctx.lineWidth = this.width;
    ctx.beginPath();
    ctx.moveTo(this.x, this.y);
    ctx.lineTo(
      this.x + Math.cos(this.angle) * this.length,
      this.y + Math.sin(this.angle) * this.length
    );
    ctx.stroke();
    ctx.globalAlpha = 1;
  }
}

let lightBeams = [];

// Animación principal
function animate() {
  ctx.fillStyle = "rgba(10, 10, 10, 0.2)";
  ctx.fillRect(0, 0, W, H);

  particles.forEach((p, i) => {
    p.update();
    p.draw();
    if (p.life <= 0) particles.splice(i, 1);
  });

  lightBeams.forEach((beam, i) => {
    beam.update();
    beam.draw();
    if (beam.life <= 0) lightBeams.splice(i, 1);
  });

  if (Math.random() < 0.1) {
    lightBeams.push(new LightBeam());
  }

  requestAnimationFrame(animate);
}

animate();

// Secuencia al presionar Ignition
const ignite = document.getElementById("ignite");
const ui = document.getElementById("ui");
const carContainer = document.getElementById("car-container");
const mirrorEffect = document.querySelector(".mirror-effect");
const mainContent = document.getElementById("mainContent");
const roadLine = document.querySelector(".road-line");

ignite.addEventListener("click", () => {
  ui.style.opacity = "0";
  setTimeout(() => ui.style.display = "none", 800);

  for (let i = 0; i < 300; i++) {
    particles.push(new Particle(W / 2, H / 2));
  }

  let roadOffset = 0;
  const roadAnimation = setInterval(() => {
    roadOffset += 10;
    roadLine.style.backgroundPositionX = -roadOffset + "px";
  }, 50);

  setTimeout(() => {
    carContainer.style.opacity = "1";
    setTimeout(() => {
      mirrorEffect.style.opacity = "0.7";
    }, 500);
  }, 1000);

  setTimeout(() => {
    for (let i = 0; i < 500; i++) {
      const angle = Math.random() * Math.PI * 2;
      const radius = Math.random() * 200;
      const x = W / 2 + Math.cos(angle) * radius;
      const y = H / 2 + Math.sin(angle) * radius;
      particles.push(new Particle(x, y));
    }
  }, 2500);

  setTimeout(() => {
    carContainer.style.opacity = "0";
    mirrorEffect.style.opacity = "0";
    mainContent.classList.add("visible");
  }, 4500);

  setTimeout(() => {
     window.location.href = "/index";
    console.log("Redirección a página principal");
  }, 6500);
});

// Centelleos aleatorios
function createSparkles() {
  const sparkle = document.createElement('div');
  sparkle.classList.add('sparkle');
  sparkle.style.left = Math.random() * 100 + 'vw';
  sparkle.style.top = Math.random() * 100 + 'vh';
  document.body.appendChild(sparkle);

  setTimeout(() => {
    sparkle.style.opacity = '1';
    setTimeout(() => {
      sparkle.style.opacity = '0';
      setTimeout(() => {
        document.body.removeChild(sparkle);
      }, 1000);
    }, 800);
  }, 100);
}

setInterval(createSparkles, 300);

