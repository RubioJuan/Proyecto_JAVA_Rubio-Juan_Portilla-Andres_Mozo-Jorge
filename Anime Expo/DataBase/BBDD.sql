# **************************************
# *** Base de datos - Anime Expo ***
# **************************************

create database AnimeExpo;

use AnimeExpo;

-- Tabla Eventos
CREATE TABLE Eventos (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    pais VARCHAR(100),
    ciudad VARCHAR(100),
    direccion VARCHAR(255),
    aforo_maximo INT,
    fecha_hora DATETIME,
    organizador VARCHAR(255),
    clasificacion_edad VARCHAR(50),
    estado ENUM('activo', 'finalizado', 'pendiente') NOT NULL,
    edad_minima_con_acompaniante INT DEFAULT NULL, -- Edad mínima para ingresar con un adulto
    edad_minima_sin_acompaniante INT DEFAULT NULL -- Edad mínima para ingresar solo
);

-- Tabla Personal_Eventos
CREATE TABLE Personal_Eventos (
    id_personal_evento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    identificacion VARCHAR(100),
    fecha_nacimiento DATE,
    rol VARCHAR(100),
    estado ENUM('asignado', 'sin tarea', 'despedido', 'incapacitado') NOT NULL,
    id_evento INT,
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento)
);

-- Tabla Roles_Personal
CREATE TABLE Roles_Personal (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    actividad_1 VARCHAR(255),
    actividad_2 VARCHAR(255)
);

-- Tabla Inventario_Eventos
CREATE TABLE Inventario_Eventos (
    id_inventario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    cantidad INT,
    estado ENUM('En almacén', 'En sitio'),
    id_evento INT,
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento)
);

-- Tabla Taquillas
CREATE TABLE Taquillas (
    id_taquilla INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT,
    ubicacion VARCHAR(255),
    numero_contacto VARCHAR(100),
    personal_encargado INT,
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento),
    FOREIGN KEY (personal_encargado) REFERENCES Personal_Eventos(id_personal_evento)
);

-- Tabla Tipos_Boletos
CREATE TABLE Tipos_Boletos (
    id_boleto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    precio DECIMAL(10, 2),
    clasificacion_edad VARCHAR(50),
    costos_adicionales DECIMAL(10, 2) DEFAULT 0,
    estado ENUM('pagado', 'reservado') NOT NULL
);

-- Tabla Boletos
CREATE TABLE Boletos (
    id_boleto INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_boleto INT,
    cliente VARCHAR(255),
    FOREIGN KEY (id_tipo_boleto) REFERENCES Tipos_Boletos(id_boleto)
);

-- Tabla Visitantes
CREATE TABLE Visitantes (
    id_visitante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    documento_identificacion VARCHAR(100),
    genero ENUM('masculino', 'femenino', 'otro'),
    fecha_nacimiento DATE,
    correo_electronico VARCHAR(255),
    numero_telefono VARCHAR(50),
    id_taquilla INT,
    FOREIGN KEY (id_taquilla) REFERENCES Taquillas(id_taquilla)
);

-- Tabla Actividades
CREATE TABLE Actividades (
    id_actividad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    tipo ENUM('Cosplay', 'Trivia'),
    categoria VARCHAR(100),
    numero_participantes INT,
    id_evento INT,
    hora_inicio TIME,
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento)
);

-- Tabla Premios
CREATE TABLE Premios (
    id_premio INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(100),
    descripcion TEXT,
    valor DECIMAL(10, 2),
    estado ENUM('disponible', 'entregado'),
    id_actividad INT,
    id_participante INT,
    FOREIGN KEY (id_actividad) REFERENCES Actividades(id_actividad),
    FOREIGN KEY (id_participante) REFERENCES Visitantes(id_visitante)
);

-- Tabla Feedback_Visitantes
CREATE TABLE Feedback_Visitantes (
    id_feedback INT AUTO_INCREMENT PRIMARY KEY,
    id_evento INT,
    id_visitante INT,
    comentario TEXT,
    calificacion INT CHECK (calificacion BETWEEN 1 AND 5),
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento),
    FOREIGN KEY (id_visitante) REFERENCES Visitantes(id_visitante)
);

-- Tabla Historial_Boletos
CREATE TABLE Historial_Boletos (
    id_historial INT AUTO_INCREMENT PRIMARY KEY,
    id_boleto INT,
    estado_anterior ENUM('pagado', 'reservado'),
    estado_nuevo ENUM('pagado', 'reservado'),
    fecha_cambio DATETIME,
    FOREIGN KEY (id_boleto) REFERENCES Boletos(id_boleto)
);

-- Tabla Historial_Inventario
CREATE TABLE Historial_Inventario (
    id_historial INT AUTO_INCREMENT PRIMARY KEY,
    id_inventario INT,
    cantidad_anterior INT,
    cantidad_nueva INT,
    fecha_cambio DATETIME,
    FOREIGN KEY (id_inventario) REFERENCES Inventario_Eventos(id_inventario)
);

-- Tabla Usuarios
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(255) UNIQUE,
    contrasena VARCHAR(255),
    rol ENUM('admin', 'encargado', 'visitante')
);

-- Tabla Cajas
CREATE TABLE Cajas (
    id_caja INT AUTO_INCREMENT PRIMARY KEY,
    estado ENUM('activa', 'inactiva') DEFAULT 'inactiva',
    operario INT,
    monto_apertura DECIMAL(10, 2),
    monto_cierre DECIMAL(10, 2),
    FOREIGN KEY (operario) REFERENCES Personal_Eventos(id_personal_evento)
);

-- Tabla Tiendas
CREATE TABLE Tiendas (
    id_tienda INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    promociones enum("Combos","2X1","Mejor precio por cantidad","Pague 2 lleve 1"),
    responsable INT,
    FOREIGN KEY (responsable) REFERENCES Personal_Eventos(id_personal_evento)
);

-- Tabla Pedidos
CREATE TABLE Pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_tienda INT,
    id_caja INT,
    cajero INT,
    valor_total DECIMAL(10, 2),
    estado ENUM('registrado', 'pagado', 'entregado'),
    FOREIGN KEY (id_tienda) REFERENCES Tiendas(id_tienda),
    FOREIGN KEY (id_caja) REFERENCES Cajas(id_caja),
    FOREIGN KEY (cajero) REFERENCES Personal_Eventos(id_personal_evento)
);

-- Tabla Detalle_Pedidos
CREATE TABLE Detalle_Pedidos (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    producto VARCHAR(255),
    cantidad INT,
    valor_individual DECIMAL(10, 2),
    FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido)
);

-- Tabla Inventario_Tiendas
CREATE TABLE Inventario_Tiendas (
    id_inventario INT AUTO_INCREMENT PRIMARY KEY,
    id_tienda INT,
    nombre_producto VARCHAR(255),
    descripcion TEXT,
    fabricante VARCHAR(255),
    tipo VARCHAR(100),
    cantidad INT,
    precio DECIMAL(10, 2),
    FOREIGN KEY (id_tienda) REFERENCES Tiendas(id_tienda)
);

-- Tabla Restaurantes
CREATE TABLE Restaurantes (
    id_restaurante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    responsable INT,
    FOREIGN KEY (responsable) REFERENCES Personal_Eventos(id_personal_evento)
);

-- Tabla Menu_Restaurantes
CREATE TABLE Menu_Restaurantes (
    id_menu INT AUTO_INCREMENT PRIMARY KEY,
    id_restaurante INT,
    nombre_plato VARCHAR(255),
    descripcion TEXT,
    tipo ENUM('Entrada', 'Bebida', 'Plato fuerte', "Postres", "Corrientazo", "Comida"),
    tiempo_preparacion INT,
    FOREIGN KEY (id_restaurante) REFERENCES Restaurantes(id_restaurante)
);

-- Tabla Inventario_Ingredientes
CREATE TABLE Inventario_Ingredientes (
    id_ingrediente INT AUTO_INCREMENT PRIMARY KEY,
    id_restaurante INT,
    nombre_ingrediente VARCHAR(255),
    cantidad INT,
    FOREIGN KEY (id_restaurante) REFERENCES Restaurantes(id_restaurante)
);

-- Tabla Actividades_Premios
CREATE TABLE Actividades_Premios (
    id_actividad_premio INT AUTO_INCREMENT PRIMARY KEY,
    id_actividad INT,
    id_premio INT,
    FOREIGN KEY (id_actividad) REFERENCES Actividades(id_actividad),
    FOREIGN KEY (id_premio) REFERENCES Premios(id_premio)
);

-- Tabla de Jurados
CREATE TABLE Jurados (
    id_jurado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    documento_identificacion VARCHAR(100) UNIQUE NOT NULL,
    fecha_nacimiento DATE,
    correo_electronico VARCHAR(255),
    numero_telefono VARCHAR(50),
    especialidad VARCHAR(255),
    id_evento INT,
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento)
);

-- Tabla Participantes
CREATE TABLE Participantes (
    id_participante INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    id_actividad INT,
    FOREIGN KEY (id_actividad) REFERENCES Actividades(id_actividad)
);

-- Tabla Calificaciones
CREATE TABLE Calificaciones (
    id_calificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_participante INT,
    id_jurado INT,
    puntuacion DECIMAL(3, 1) CHECK (puntuacion BETWEEN 0 AND 10),
    FOREIGN KEY (id_participante) REFERENCES Participantes(id_participante),
    FOREIGN KEY (id_jurado) REFERENCES Jurados(id_jurado)
);

-- Tabla Resultados de la actividad
CREATE TABLE Resultados_Actividad (
    id_resultado INT AUTO_INCREMENT PRIMARY KEY,
    id_actividad INT,
    id_participante INT,
    puntuacion_promedio DECIMAL(5, 2),
    FOREIGN KEY (id_actividad) REFERENCES Actividades(id_actividad),
    FOREIGN KEY (id_participante) REFERENCES Participantes(id_participante)
);


-- Tabla Reportes
CREATE TABLE Reportes (
    id_reporte INT AUTO_INCREMENT PRIMARY KEY,
    nombre_reporte VARCHAR(255),
    tipo_reporte ENUM('General', 'Evento', 'Tienda', 'Restaurante', 'Actividad'),
    descripcion TEXT,
    fecha_generacion DATE,
    datos_reporte JSON,
    id_evento INT,
    id_tienda INT,
    id_restaurante INT,
    id_actividad INT,
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento),
    FOREIGN KEY (id_tienda) REFERENCES Tiendas(id_tienda),
    FOREIGN KEY (id_restaurante) REFERENCES Restaurantes(id_restaurante),
    FOREIGN KEY (id_actividad) REFERENCES Actividades(id_actividad)
);

-- Tabla de Cateogria Cosplay
CREATE TABLE Categorias_Cosplay (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(255) NOT NULL
);

CREATE TABLE Cosplay_Participantes (
    id_cosplay_participante INT AUTO_INCREMENT PRIMARY KEY,
    id_participante INT,
    id_categoria INT,
    puntaje DECIMAL(5, 2),
    FOREIGN KEY (id_participante) REFERENCES Participantes(id_participante),
    FOREIGN KEY (id_categoria) REFERENCES Categorias_Cosplay(id_categoria)
);

CREATE TABLE Preguntas (
    id_pregunta INT AUTO_INCREMENT PRIMARY KEY,
    pregunta TEXT NOT NULL,
    respuesta_correcta VARCHAR(255) NOT NULL,
    categoria VARCHAR(255) NOT NULL,
    dificultad ENUM('Fácil', 'Intermedio', 'Difícil') NOT NULL
);

CREATE TABLE Rondas (
    id_ronda INT AUTO_INCREMENT PRIMARY KEY,
    id_actividad INT,
    ronda_numero INT,
    FOREIGN KEY (id_actividad) REFERENCES Actividades(id_actividad)
);

CREATE TABLE Enfrentamientos (
    id_enfrentamiento INT AUTO_INCREMENT PRIMARY KEY,
    id_ronda INT,
    id_participante1 INT,
    id_participante2 INT,
    ganador INT,
    FOREIGN KEY (id_ronda) REFERENCES Rondas(id_ronda),
    FOREIGN KEY (id_participante1) REFERENCES Participantes(id_participante),
    FOREIGN KEY (id_participante2) REFERENCES Participantes(id_participante),
    FOREIGN KEY (ganador) REFERENCES Participantes(id_participante)
);

CREATE TABLE Categorías_Preguntas (
    id_categoria_pregunta INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(255) NOT NULL
);

CREATE TABLE Inventario_Preguntas (
    id_pregunta INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria_pregunta INT,
    pregunta TEXT NOT NULL,
    respuesta_correcta VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_categoria_pregunta) REFERENCES Categorías_Preguntas(id_categoria_pregunta)
);

show tables;

# Verificar información de alguna tabla
select * from Eventos; 
# Se cambia el nombre "Eventos"  se pone el nombre de la tabla que se desea ver la información