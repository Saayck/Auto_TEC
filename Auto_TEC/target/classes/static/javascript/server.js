const express = require("express");
const { Pool } = require("pg");
const bcrypt = require("bcrypt");
const bodyParser = require("body-parser");
const cors = require("cors");

const app = express();
const port = 3000;

// Configura conexión a PostgreSQL
const pool = new Pool({
  user: "tu_usuario",
  host: "localhost",
  database: "tu_base_de_datos",
  password: "tu_contraseña",
  port: 5432,
});

// Middleware
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Ruta para registrar usuarios
app.post("/register", async (req, res) => {
  const { username, email, password, confirm_password } = req.body;

  // Validaciones básicas
  if (!username || !email || !password || !confirm_password) {
    return res.status(400).json({ message: "Faltan datos obligatorios." });
  }
  if (password !== confirm_password) {
    return res.status(400).json({ message: "Las contraseñas no coinciden." });
  }

  try {
    // Encriptar contraseña
    const hashedPassword = await bcrypt.hash(password, 10);

    // Insertar usuario
    const result = await pool.query(
      "INSERT INTO usuarios (username, email, password) VALUES ($1, $2, $3) RETURNING id",
      [username, email, hashedPassword]
    );

    res.status(201).json({ message: "Usuario creado correctamente", userId: result.rows[0].id });
  } catch (err) {
    console.error(err);
    if (err.code === '23505') { // error de violación de clave única (username o email duplicados)
      return res.status(409).json({ message: "El usuario o email ya está registrado." });
    }
    res.status(500).json({ message: "Error del servidor" });
  }
});

// Iniciar servidor
app.listen(port, () => {
  console.log(`Servidor corriendo en http://localhost:${port}`);
});
