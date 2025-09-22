-- Crea la base de datos Auto_TEC
-- Tabla de usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de vehículos
CREATE TABLE  or replace vehiculos (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER REFERENCES usuarios(id),
    marca VARCHAR(50),
    modelo VARCHAR(50),
    anio INTEGER,
    placa VARCHAR(20) UNIQUE
);

-- Tabla de servicios
CREATE TABLE servicios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);

-- Tabla de citas de servicio
CREATE TABLE citas (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER REFERENCES usuarios(id),
    vehiculo_id INTEGER REFERENCES vehiculos(id),
    servicio_id INTEGER REFERENCES servicios(id),
    fecha TIMESTAMP NOT NULL,
    estado VARCHAR(20) DEFAULT 'pendiente'
);
--Diagrama de la base de datos