-- Tabla de roles de usuario
CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(20) UNIQUE NOT NULL CHECK (nombre IN ('CLIENTE', 'VENDEDOR', 'ADMIN', 'GERENTE'))
);

-- Tabla de usuarios
CREATE TABLE usuarios (
  id BIGSERIAL PRIMARY KEY,
  roles_id INTEGER REFERENCES roles(id),
  username VARCHAR(50) UNIQUE NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  activo BOOLEAN NOT NULL DEFAULT TRUE,
  fecha_registro TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
  ultimo_login TIMESTAMPTZ
);

-- Tabla de administradores (esta es la nueva tabla muchacho para administradores)
CREATE TABLE administradores (
  id BIGSERIAL PRIMARY KEY,
  usuario_id BIGINT REFERENCES usuarios(id) UNIQUE NOT NULL,
  departamento VARCHAR(50),
  fecha_creacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
  activo BOOLEAN DEFAULT TRUE
);

-- Tabla de logs administrativos (NUEVA TABLA)
CREATE TABLE logs_administrativos (
  id BIGSERIAL PRIMARY KEY,
  administrador_id BIGINT REFERENCES administradores(id),
  accion VARCHAR(100) NOT NULL,
  tabla_afectada VARCHAR(50),
  registro_id BIGINT,
  detalles JSONB,
  fecha_accion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
  ip_address VARCHAR(45)
);

-- Tabla de sesiones de usuario (Tabla mejorada)
CREATE TABLE sesiones (
  id BIGSERIAL PRIMARY KEY,
  usuario_id BIGINT REFERENCES usuarios(id),
  session_token VARCHAR(255) UNIQUE NOT NULL,
  fecha_creacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
  fecha_expiracion TIMESTAMPTZ NOT NULL,
  activa BOOLEAN DEFAULT TRUE,
  ip_address VARCHAR(45),
  user_agent TEXT
);

-- Tabla de clientes (igualmente muchacho tabla mejorada)
CREATE TABLE clientes (
  id BIGSERIAL PRIMARY KEY,
  usuario_id BIGINT REFERENCES usuarios(id) UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  telefono VARCHAR(20),
  direccion TEXT,
  tipo_documento VARCHAR(20) DEFAULT 'DNI',
  numero_documento VARCHAR(20),
  fecha_nacimiento DATE,
  fecha_registro TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de modelos de vehículos (mejora de la tabala uwu)
CREATE TABLE modelos (
  id BIGSERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  marca VARCHAR(50) NOT NULL,
  descripcion TEXT,
  motor VARCHAR(100),
  potencia VARCHAR(50),
  velocidad_max VARCHAR(50),
  aceleracion VARCHAR(50),
  precio DECIMAL(12,2) NOT NULL,
  imagen_url VARCHAR(255),
  destacado BOOLEAN DEFAULT FALSE,
  stock INTEGER DEFAULT 1,
  categoria VARCHAR(20) DEFAULT 'hypercar',
  activo BOOLEAN DEFAULT TRUE,
  fecha_creacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
  fecha_actualizacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de inventario de vehículos (control detallado de stock - mejorada)
CREATE TABLE inventario (
  id BIGSERIAL PRIMARY KEY,
  modelo_id BIGINT REFERENCES modelos(id),
  cantidad INTEGER NOT NULL DEFAULT 0,
  ubicacion VARCHAR(100),
  fecha_actualizacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
  UNIQUE(modelo_id, ubicacion)
);

-- Tabla de ventas (igualmente mejorada)
CREATE TABLE ventas (
  id BIGSERIAL PRIMARY KEY,
  cliente_id BIGINT REFERENCES clientes(id),
  modelo_id BIGINT REFERENCES modelos(id),
  vendedor_id BIGINT REFERENCES usuarios(id),
  fecha_venta TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
  precio_venta DECIMAL(12,2) NOT NULL,
  estado VARCHAR(20) DEFAULT 'reservado' CHECK (estado IN ('reservado', 'confirmado', 'entregado', 'cancelado')),
  metodo_pago VARCHAR(50),
  comision_vendedor DECIMAL(10,2),
  notas TEXT
);

-- Tabla de cotizaciones/solicitudes
CREATE TABLE cotizaciones (
  id SERIAL PRIMARY KEY,
  cliente_id INTEGER REFERENCES clientes(id),
  modelo_id INTEGER REFERENCES modelos(id),
  nombre_solicitante VARCHAR(100) NOT NULL,
  email_solicitante VARCHAR(100) NOT NULL,
  modelo_interes VARCHAR(100) NOT NULL,
  fecha_solicitud TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado VARCHAR(20) DEFAULT 'pendiente' CHECK (estado IN ('pendiente', 'contactado', 'completado')),
  notas TEXT
);

-- Tabla de carrito de compras (temporal por sesión)
CREATE TABLE carrito (
  id SERIAL PRIMARY KEY,
  session_id VARCHAR(100) NOT NULL,
  modelo_id INTEGER REFERENCES modelos(id),
  cantidad INTEGER DEFAULT 1,
  fecha_agregado TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de favoritos
CREATE TABLE favoritos (
  id SERIAL PRIMARY KEY,
  session_id VARCHAR(100) NOT NULL,
  modelo_id INTEGER REFERENCES modelos(id),
  fecha_agregado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UNIQUE(session_id, modelo_id)
);

-- Tabla de servicios
CREATE TABLE servicios (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT,
  icono VARCHAR(50),
  categoria VARCHAR(50) CHECK (categoria IN ('financiamiento', 'mantenimiento', 'garantia', 'personalizacion', 'seguro', 'entrega')),
  precio DECIMAL(10,2),
  duracion_estimada VARCHAR(50),
  disponible BOOLEAN DEFAULT TRUE,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de financiamiento
CREATE TABLE financiamiento (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  descripcion TEXT,
  tasa_interes DECIMAL(5,2) NOT NULL,
  plazo_min INTEGER NOT NULL,
  plazo_max INTEGER NOT NULL,
  enganche_minimo DECIMAL(5,2) NOT NULL,
  requisitos TEXT,
  activo BOOLEAN DEFAULT TRUE
);

-- Tabla de empleados
CREATE TABLE empleados (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  puesto VARCHAR(100) NOT NULL,
  departamento VARCHAR(50) CHECK (departamento IN ('gerencia', 'ventas', 'marketing', 'administracion', 'servicio_cliente')),
  email VARCHAR(100),
  telefono VARCHAR(20),
  extension VARCHAR(10),
  activo BOOLEAN DEFAULT TRUE,
  fecha_contratacion DATE
);

-- Tabla de citas
CREATE TABLE citas (
  id SERIAL PRIMARY KEY,
  cliente_id INTEGER REFERENCES clientes(id),
  empleado_id INTEGER REFERENCES empleados(id),
  tipo_cita VARCHAR(50) CHECK (tipo_cita IN ('venta', 'servicio', 'financiamiento', 'general', 'prueba_manejo')),
  fecha_cita TIMESTAMP NOT NULL,
  duracion_estimada INTEGER DEFAULT 60,
  estado VARCHAR(20) DEFAULT 'pendiente' CHECK (estado IN ('pendiente', 'confirmada', 'completada', 'cancelada')),
  notas TEXT,
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de cálculos de financiamiento
CREATE TABLE calculos_financiamiento (
  id SERIAL PRIMARY KEY,
  cliente_id INTEGER REFERENCES clientes(id),
  modelo_vehiculo VARCHAR(100) NOT NULL,
  precio_vehiculo DECIMAL(12,2) NOT NULL,
  cuota_inicial DECIMAL(12,2) NOT NULL,
  plazo_meses INTEGER NOT NULL,
  tasa_interes DECIMAL(5,2) NOT NULL,
  cuota_mensual DECIMAL(10,2) NOT NULL,
  total_financiado DECIMAL(12,2) NOT NULL,
  fecha_calculo TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de contactos de gestión
CREATE TABLE contactos_gestion (
  id SERIAL PRIMARY KEY,
  nombre_solicitante VARCHAR(100) NOT NULL,
  email_solicitante VARCHAR(100) NOT NULL,
  departamento VARCHAR(50) CHECK (departamento IN ('gerencia', 'marketing', 'administracion', 'ventas', 'servicios')),
  asunto VARCHAR(200) NOT NULL,
  mensaje TEXT,
  fecha_contacto TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado VARCHAR(20) DEFAULT 'pendiente' CHECK (estado IN ('pendiente', 'respondido', 'completado'))
);

-- Tabla de solicitudes de financiamiento
CREATE TABLE solicitudes_financiamiento (
  id SERIAL PRIMARY KEY,
  cliente_id INTEGER REFERENCES clientes(id),
  nombre_solicitante VARCHAR(100) NOT NULL,
  email_solicitante VARCHAR(100) NOT NULL,
  modelo_interes VARCHAR(100) NOT NULL,
  mensaje TEXT,
  plan_financiamiento VARCHAR(100),
  fecha_solicitud TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado VARCHAR(20) DEFAULT 'pendiente' CHECK (estado IN ('pendiente', 'evaluando', 'aprobado', 'rechazado'))
);

-- Tabla de contactos generales
CREATE TABLE contactos_general (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefono VARCHAR(20),
  asunto VARCHAR(200) NOT NULL,
  mensaje TEXT NOT NULL,
  tipo_consulta VARCHAR(50) CHECK (tipo_consulta IN ('venta', 'servicio', 'financiamiento', 'general', 'soporte')),
  fecha_contacto TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado VARCHAR(20) DEFAULT 'nuevo' CHECK (estado IN ('nuevo', 'en_proceso', 'respondido', 'cerrado'))
);

-- Tabla de historial de actividad para auditoría
CREATE TABLE historial_actividad (
  id SERIAL PRIMARY KEY,
  usuario_id INTEGER REFERENCES usuarios(id),
  accion VARCHAR(255) NOT NULL,
  descripcion TEXT,
  fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de notificaciones
CREATE TABLE notificaciones (
  id SERIAL PRIMARY KEY,
  usuario_id INTEGER REFERENCES usuarios(id),
  mensaje TEXT NOT NULL,
  leida BOOLEAN DEFAULT FALSE,
  fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de métodos de pago
CREATE TABLE metodos_pago (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion TEXT
);

-- Tabla de pagos realizados
CREATE TABLE pagos (
  id SERIAL PRIMARY KEY,
  venta_id INTEGER REFERENCES ventas(id),
  metodo_pago_id INTEGER REFERENCES metodos_pago(id),
  monto DECIMAL(12,2) NOT NULL,
  fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado_pago VARCHAR(20) CHECK (estado_pago IN ('pendiente', 'completado', 'fallido')) DEFAULT 'pendiente'
);

-- Tabla de configuraciones generales del sistema
CREATE TABLE configuraciones (
  id SERIAL PRIMARY KEY,
  clave VARCHAR(100) UNIQUE NOT NULL,
  valor TEXT NOT NULL,
  descripcion TEXT
);
