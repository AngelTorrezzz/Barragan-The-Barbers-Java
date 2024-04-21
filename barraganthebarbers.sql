-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-04-2024 a las 23:54:27
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `barraganthebarbers`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agenda`
--

CREATE TABLE `agenda` (
  `id_agenda` int(11) NOT NULL,
  `nombre_cliente` varchar(50) NOT NULL,
  `id_barbero` int(11) NOT NULL,
  `id_servicio` int(11) NOT NULL,
  `confirmar` varchar(10) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Volcado de datos para la tabla `agenda`
--

INSERT INTO `agenda` (`id_agenda`, `nombre_cliente`, `id_barbero`, `id_servicio`, `confirmar`, `fecha`, `hora`) VALUES
(1, 'Jose', 5, 12, 'no', '2023-06-26', '17:30'),
(2, 'Ramon', 5, 13, 'no', '2023-06-26', '15:00'),
(3, 'Ruben', 5, 14, 'no', '2023-06-26', '19:00'),
(4, 'Alvarado', 5, 16, 'no', '2023-06-26', '20:00'),
(5, 's', 5, 14, 'no', '2023-06-26', '22:00'),
(6, 'H', 6, 12, 'si', '2023-06-26', '17:00'),
(7, 'Pelon', 7, 12, 'no', '2023-06-26', '20:00'),
(8, 'Eduardo', 6, 12, 'no', '2023-06-27', '13:30'),
(9, 'P', 6, 14, 'no', '2023-06-26', '18:00'),
(10, 'Owen', 5, 12, 'no', '2023-07-02', '15:00'),
(11, 'Pelon', 5, 13, 'no', '2023-07-02', '9:30'),
(12, 'Nena', 6, 13, 'no', '2024-01-30', '15:30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barberos`
--

CREATE TABLE `barberos` (
  `id_barbero` int(11) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `contraseña` varchar(30) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `tipo_u` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Volcado de datos para la tabla `barberos`
--

INSERT INTO `barberos` (`id_barbero`, `nombre_usuario`, `contraseña`, `nombres`, `apellidos`, `edad`, `direccion`, `tipo_u`) VALUES
(0, '...', '', '', '', 0, '', ''),
(1, 'Carlos Barragan', '12345', 'Carlos', 'Barrgan', 30, 'Calle 5 de mayo', 'Administrador'),
(5, 'Angel', '12345', 'Angel', 'Cruz Oropeza', 23, 'Vista Hermosa', 'Barbero'),
(6, 'Wacho', '12345', 'Albores', 'Sin definir', 25, 'Alta Vista', 'Barbero'),
(7, 'Carlos', '12345', 'Carlos', 'Barragan', 30, 'Centro', 'Barbero'),
(8, 'jose guada', '123', 'jose', 'robles', 12, 'ignaci', 'Barbero'),
(9, 'Xacho', '33323', 'albures', 'FFDFB', 34, 'JDJDJDD', 'Barbero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `producto` varchar(50) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `producto`, `precio`) VALUES
(0, '...', 0),
(7, 'Polvo Fijador', 280.5),
(8, 'Cera 4x4', 90.5),
(9, 'Polvo Fijador 2', 250),
(10, 'Ego Gel', 75),
(11, 'Atomizador', 38);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `id_servicio` int(11) NOT NULL,
  `servicio` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `duracion` varchar(10) NOT NULL,
  `dur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id_servicio`, `servicio`, `precio`, `duracion`, `dur`) VALUES
(0, '...', 0, '0', 0),
(12, 'Taper', 100, '60 min', 2),
(13, 'Casquete Corto', 80, '30 min', 1),
(14, 'Ceja', 45, '30 min', 1),
(15, 'Taper con Barba', 210, '120 min', 4),
(16, 'Mullet', 150, '90 min', 3),
(17, 'Pelon', 130, '60 min', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventasproductos`
--

CREATE TABLE `ventasproductos` (
  `id_venta` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_barbero` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL,
  `precio_eventual` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Volcado de datos para la tabla `ventasproductos`
--

INSERT INTO `ventasproductos` (`id_venta`, `id_producto`, `id_barbero`, `fecha`, `hora`, `precio_eventual`) VALUES
(1, 10, 5, '2023-06-26', '14:45', 75),
(2, 10, 6, '2023-06-26', '14:46', 75),
(3, 8, 6, '2023-06-26', '14:46', 90.5),
(4, 11, 7, '2023-06-26', '14:46', 38),
(5, 8, 6, '2023-06-26', '14:47', 90.5),
(6, 8, 7, '2023-06-26', '14:47', 90.5),
(7, 7, 5, '2023-06-26', '14:47', 280.5),
(8, 9, 6, '2023-06-26', '14:47', 250),
(9, 8, 5, '2023-07-02', '16:34', 90.5),
(10, 8, 5, '2023-07-02', '16:35', 90.5),
(11, 7, 6, '2023-07-02', '16:51', 280.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventasservicios`
--

CREATE TABLE `ventasservicios` (
  `id_venta` int(11) NOT NULL,
  `id_servicio` int(11) NOT NULL,
  `id_barbero` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL,
  `precio_eventual` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_bin;

--
-- Volcado de datos para la tabla `ventasservicios`
--

INSERT INTO `ventasservicios` (`id_venta`, `id_servicio`, `id_barbero`, `fecha`, `hora`, `precio_eventual`) VALUES
(1, 12, 5, '2023-06-26', '14:43', 100),
(2, 12, 5, '2023-06-26', '14:43', 100),
(3, 14, 5, '2023-06-26', '14:45', 45),
(4, 15, 6, '2023-06-26', '14:45', 210),
(5, 14, 6, '2023-06-26', '14:46', 45),
(6, 16, 7, '2023-06-26', '14:46', 150),
(7, 15, 5, '2023-06-26', '14:47', 210),
(8, 16, 6, '2023-06-26', '14:47', 150),
(9, 13, 5, '2023-07-02', '16:34', 80),
(10, 14, 5, '2023-07-02', '16:35', 45),
(11, 12, 6, '2023-07-02', '16:51', 100);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`id_agenda`);

--
-- Indices de la tabla `barberos`
--
ALTER TABLE `barberos`
  ADD PRIMARY KEY (`id_barbero`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`id_servicio`);

--
-- Indices de la tabla `ventasproductos`
--
ALTER TABLE `ventasproductos`
  ADD PRIMARY KEY (`id_venta`);

--
-- Indices de la tabla `ventasservicios`
--
ALTER TABLE `ventasservicios`
  ADD PRIMARY KEY (`id_venta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `agenda`
--
ALTER TABLE `agenda`
  MODIFY `id_agenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `barberos`
--
ALTER TABLE `barberos`
  MODIFY `id_barbero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `id_servicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `ventasproductos`
--
ALTER TABLE `ventasproductos`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `ventasservicios`
--
ALTER TABLE `ventasservicios`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
