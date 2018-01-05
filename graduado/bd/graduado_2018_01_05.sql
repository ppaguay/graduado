-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-01-2018 a las 14:41:33
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `graduado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aplicar_oferta`
--

CREATE TABLE `aplicar_oferta` (
  `cod_graduado` int(11) NOT NULL,
  `cod_ofertalaboral` int(11) NOT NULL,
  `fecha_aplica` bigint(20) DEFAULT NULL,
  `contrato` varchar(2) DEFAULT NULL,
  `fecha_inicio` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aplicar_oferta`
--

INSERT INTO `aplicar_oferta` (`cod_graduado`, `cod_ofertalaboral`, `fecha_aplica`, `contrato`, `fecha_inicio`) VALUES
(1, 1, 1512709200000, 'si', 1512709200000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capacitacion`
--

CREATE TABLE `capacitacion` (
  `codigo` int(11) NOT NULL,
  `cod_tipocapacitacion` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  `caracteristica` varchar(150) DEFAULT NULL,
  `fecha` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `capacitacion`
--

INSERT INTO `capacitacion` (`codigo`, `cod_tipocapacitacion`, `nombre`, `horas`, `caracteristica`, `fecha`) VALUES
(1, 3, 'Redes informáticas', 40, 'Aprobación', 1326344400000),
(2, 2, 'Programación en Java', 20, 'Aprobación', 1275368400000),
(3, 1, 'Tributación', 40, 'Aprobación', 1442293200000),
(4, 3, 'Mantenimiento de computadores', 40, 'Aprobación', 1361336400000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursado`
--

CREATE TABLE `cursado` (
  `cod_graduado` int(11) NOT NULL,
  `cod_capacitacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cursado`
--

INSERT INTO `cursado` (`cod_graduado`, `cod_capacitacion`) VALUES
(1, 1),
(1, 2),
(1, 4),
(2, 1),
(2, 4),
(3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `codigo` int(11) NOT NULL,
  `cod_tipoactividad` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `pertenece` varchar(2) DEFAULT NULL,
  `clave` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`codigo`, `cod_tipoactividad`, `nombre`, `direccion`, `telefono`, `usuario`, `pertenece`, `clave`) VALUES
(1, 1, 'TIA S.A.', 'Avenida Bolívar y Lalama - Ambato', '032457890', 'alex', 'si', '12345'),
(2, 5, 'Plasticaucho S.A.', 'Fábrica sector La península', '032445566', 'Julia Peralta', 'si', 'julia123'),
(3, 4, 'El Huerto', 'Avenida 12 de noviembre y Tomás Sevilla', '032453672', 'Milton Sánchez', 'no', 'milton123'),
(4, 1, 'Distribuidora Mejía', 'Avenida El Condor sector mercado mayorista', '032654783', 'Patricia Carvajal', 'si', 'patricia123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_civil`
--

CREATE TABLE `estado_civil` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado_civil`
--

INSERT INTO `estado_civil` (`codigo`, `nombre`) VALUES
(1, 'Soltero'),
(2, 'Casado'),
(3, 'Divorciado'),
(4, 'Viudo'),
(5, 'Union Libre'),
(6, 'Union de Hecho');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `graduado`
--

CREATE TABLE `graduado` (
  `codigo` int(11) NOT NULL,
  `cod_estadocivil` int(11) DEFAULT NULL,
  `cod_tipolicencia` int(11) DEFAULT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `ci` varchar(10) DEFAULT NULL,
  `fecha_nac` bigint(20) DEFAULT NULL,
  `ciudad_actual` varchar(50) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `celular1` varchar(10) DEFAULT NULL,
  `celular2` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `facebook` varchar(100) DEFAULT NULL,
  `clave` varchar(100) DEFAULT NULL,
  `foto` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `graduado`
--

INSERT INTO `graduado` (`codigo`, `cod_estadocivil`, `cod_tipolicencia`, `nombre`, `ci`, `fecha_nac`, `ciudad_actual`, `direccion`, `telefono`, `celular1`, `celular2`, `email`, `facebook`, `clave`, `foto`) VALUES
(1, 5, 2, 'Henry Bucheli', '0604950725', 797317200000, 'Ambato1', 'Avenida Corazón Cdla. 12 de Noviembre', '032456789', '0987234567', '0981234567', 'henryb@hotmail.com', 'Henry Bucheli', '12345', '/img/foto/img1515159335337avatar-1.jpg'),
(2, 1, 3, 'Carlos Aguayo', '0604950726', 783061200000, 'Ambato', 'Avenida Quito frente a la cruz roja', '032451234', '0988132457', '0981368291', 'kyke_aguayo@yahoo.es', 'Kyke Aguayo', '12345', '/img/graduado.png'),
(3, 2, 4, 'Jenny Rivera', '0604950727', 555829200000, 'Quito', 'Sector villaflora', '023943856', '0985653801', '0996101293', 'jennyr1985@gmail.com', 'Negrita Rivera', '12345', '/img/graduado.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia_laboral`
--

CREATE TABLE `historia_laboral` (
  `codigo` int(11) NOT NULL,
  `cod_graduado` int(11) DEFAULT NULL,
  `cod_tipocausasalida` int(11) DEFAULT NULL,
  `cod_tipocargo` int(11) DEFAULT NULL,
  `fechainicio` bigint(20) DEFAULT NULL,
  `fechafin` bigint(20) DEFAULT NULL,
  `empresa` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `historia_laboral`
--

INSERT INTO `historia_laboral` (`codigo`, `cod_graduado`, `cod_tipocausasalida`, `cod_tipocargo`, `fechainicio`, `fechafin`, `empresa`) VALUES
(1, 3, 1, 3, 1425186000000, 1456808400000, 'Distribuidora Mejía'),
(2, 1, 5, 2, 1412139600000, 1434344400000, 'Plasticaucho S.A.'),
(3, 1, 1, 4, 1446354000000, 1477976400000, 'TIA S.A.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta_laboral`
--

CREATE TABLE `oferta_laboral` (
  `codigo` int(11) NOT NULL,
  `cod_empresa` int(11) DEFAULT NULL,
  `cod_tipocargo` int(11) DEFAULT NULL,
  `cod_tiposueldo` int(11) DEFAULT NULL,
  `caract_cargo` varchar(200) DEFAULT NULL,
  `experiencia` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `oferta_laboral`
--

INSERT INTO `oferta_laboral` (`codigo`, `cod_empresa`, `cod_tipocargo`, `cod_tiposueldo`, `caract_cargo`, `experiencia`) VALUES
(1, 1, 3, 1, 'Encargado(a) de administrar el locar de westerm union en TIA de la avenida Tomás Sevilla y Juan Benigno Vela  ', '2 años o más en cargos similares'),
(2, 3, 5, 1, 'Se requiere un vendedor externo de insumos agrícolas', '2 años o más en cargos similares'),
(3, 1, 4, 1, 'Se requiere un técnico en mantenimiento de equipos de cómputo', '2 años o más en cargos similares');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametro`
--

CREATE TABLE `parametro` (
  `codigo` int(11) NOT NULL,
  `valor` int(11) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `codigo` int(11) NOT NULL,
  `cod_tipopersonal` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personal`
--

INSERT INTO `personal` (`codigo`, `cod_tipopersonal`, `nombre`, `clave`) VALUES
(1, 1, 'admin', '123'),
(2, 4, 'henryb', 'henry123'),
(3, 4, 'jennyr', 'jenny123'),
(4, 4, 'carlosa', 'carlos123'),
(5, 3, 'carolinab', 'carolina123'),
(6, 3, 'juliap', 'julia123'),
(7, 3, 'miltons', 'milton123'),
(8, 3, 'patriciac', 'patricia123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_actividad`
--

CREATE TABLE `tipo_actividad` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_actividad`
--

INSERT INTO `tipo_actividad` (`codigo`, `nombre`) VALUES
(1, 'Comercialización de varios productos'),
(2, 'Comercialización de productos alimenticios'),
(3, 'Mega ferretería'),
(4, 'Comercializadora de insumos agrícolas'),
(5, 'Fábrica de calzado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_capacitacion`
--

CREATE TABLE `tipo_capacitacion` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_capacitacion`
--

INSERT INTO `tipo_capacitacion` (`codigo`, `nombre`) VALUES
(1, 'Seminario'),
(2, 'Taller'),
(3, 'Curso'),
(4, 'Curso virtual');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cargo`
--

CREATE TABLE `tipo_cargo` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_cargo`
--

INSERT INTO `tipo_cargo` (`codigo`, `nombre`) VALUES
(1, 'Administrador de base de datos'),
(2, 'Programador Java'),
(3, 'Administrador de tienda'),
(4, 'Técnico en mantenimiento de computadores'),
(5, 'Vendedor'),
(6, 'Auxiliar contable');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_causa_salida`
--

CREATE TABLE `tipo_causa_salida` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_causa_salida`
--

INSERT INTO `tipo_causa_salida` (`codigo`, `nombre`) VALUES
(1, 'término de contrato'),
(5, 'conflictos con el jefe superior o empleador'),
(7, 'otros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_licencia`
--

CREATE TABLE `tipo_licencia` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_licencia`
--

INSERT INTO `tipo_licencia` (`codigo`, `nombre`) VALUES
(1, 'TIPO A'),
(2, 'TIPO B'),
(3, 'TIPO C'),
(4, 'Ninguna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_personal`
--

CREATE TABLE `tipo_personal` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_personal`
--

INSERT INTO `tipo_personal` (`codigo`, `nombre`) VALUES
(1, 'Administrador'),
(3, 'Empresa'),
(4, 'Graduado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_sueldo`
--

CREATE TABLE `tipo_sueldo` (
  `codigo` int(11) NOT NULL,
  `rango` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_sueldo`
--

INSERT INTO `tipo_sueldo` (`codigo`, `rango`) VALUES
(1, 'de 380 a 500 usd'),
(2, 'de 501 a 750 usd'),
(3, 'de 751 a 1000 usd'),
(4, 'de 1001 usd a 1250 usd'),
(5, 'de 1251 a 1500 usd'),
(6, 'de 1501 usd en adelante');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aplicar_oferta`
--
ALTER TABLE `aplicar_oferta`
  ADD PRIMARY KEY (`cod_graduado`,`cod_ofertalaboral`),
  ADD KEY `fk_aplicaroferta_ofertalaboral` (`cod_ofertalaboral`);

--
-- Indices de la tabla `capacitacion`
--
ALTER TABLE `capacitacion`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_capacitacion_tipocapacitacion` (`cod_tipocapacitacion`);

--
-- Indices de la tabla `cursado`
--
ALTER TABLE `cursado`
  ADD PRIMARY KEY (`cod_graduado`,`cod_capacitacion`),
  ADD KEY `fk_cursado_capacitacion` (`cod_capacitacion`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_empresa_tipoactividad` (`cod_tipoactividad`);

--
-- Indices de la tabla `estado_civil`
--
ALTER TABLE `estado_civil`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `graduado`
--
ALTER TABLE `graduado`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_graduado_tipoestadocivil` (`cod_estadocivil`),
  ADD KEY `fk_graduado_tipolicencia` (`cod_tipolicencia`);

--
-- Indices de la tabla `historia_laboral`
--
ALTER TABLE `historia_laboral`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_historialaboral_graduado` (`cod_graduado`),
  ADD KEY `fk_historialaboral_tipocargo` (`cod_tipocargo`),
  ADD KEY `fk_historialaboral_tipocausasalida` (`cod_tipocausasalida`);

--
-- Indices de la tabla `oferta_laboral`
--
ALTER TABLE `oferta_laboral`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_ofertalaboral_empresa` (`cod_empresa`),
  ADD KEY `fk_ofertalaboral_tipocargo` (`cod_tipocargo`),
  ADD KEY `fk_ofertalaboral_tiposueldo` (`cod_tiposueldo`);

--
-- Indices de la tabla `parametro`
--
ALTER TABLE `parametro`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_personal_tipopersonal` (`cod_tipopersonal`);

--
-- Indices de la tabla `tipo_actividad`
--
ALTER TABLE `tipo_actividad`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tipo_capacitacion`
--
ALTER TABLE `tipo_capacitacion`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tipo_cargo`
--
ALTER TABLE `tipo_cargo`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tipo_causa_salida`
--
ALTER TABLE `tipo_causa_salida`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tipo_licencia`
--
ALTER TABLE `tipo_licencia`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tipo_personal`
--
ALTER TABLE `tipo_personal`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tipo_sueldo`
--
ALTER TABLE `tipo_sueldo`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `capacitacion`
--
ALTER TABLE `capacitacion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `estado_civil`
--
ALTER TABLE `estado_civil`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `graduado`
--
ALTER TABLE `graduado`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `historia_laboral`
--
ALTER TABLE `historia_laboral`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `oferta_laboral`
--
ALTER TABLE `oferta_laboral`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `parametro`
--
ALTER TABLE `parametro`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `tipo_actividad`
--
ALTER TABLE `tipo_actividad`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipo_capacitacion`
--
ALTER TABLE `tipo_capacitacion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_cargo`
--
ALTER TABLE `tipo_cargo`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tipo_causa_salida`
--
ALTER TABLE `tipo_causa_salida`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tipo_licencia`
--
ALTER TABLE `tipo_licencia`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_personal`
--
ALTER TABLE `tipo_personal`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_sueldo`
--
ALTER TABLE `tipo_sueldo`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aplicar_oferta`
--
ALTER TABLE `aplicar_oferta`
  ADD CONSTRAINT `fk_aplicaroferta_graduado` FOREIGN KEY (`cod_graduado`) REFERENCES `graduado` (`codigo`),
  ADD CONSTRAINT `fk_aplicaroferta_ofertalaboral` FOREIGN KEY (`cod_ofertalaboral`) REFERENCES `oferta_laboral` (`codigo`);

--
-- Filtros para la tabla `capacitacion`
--
ALTER TABLE `capacitacion`
  ADD CONSTRAINT `fk_capacitacion_tipocapacitacion` FOREIGN KEY (`cod_tipocapacitacion`) REFERENCES `tipo_capacitacion` (`codigo`);

--
-- Filtros para la tabla `cursado`
--
ALTER TABLE `cursado`
  ADD CONSTRAINT `fk_cursado_capacitacion` FOREIGN KEY (`cod_capacitacion`) REFERENCES `capacitacion` (`codigo`),
  ADD CONSTRAINT `fk_cursado_graduado` FOREIGN KEY (`cod_graduado`) REFERENCES `graduado` (`codigo`);

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `fk_empresa_tipoactividad` FOREIGN KEY (`cod_tipoactividad`) REFERENCES `tipo_actividad` (`codigo`);

--
-- Filtros para la tabla `graduado`
--
ALTER TABLE `graduado`
  ADD CONSTRAINT `fk_graduado_tipoestadocivil` FOREIGN KEY (`cod_estadocivil`) REFERENCES `estado_civil` (`codigo`),
  ADD CONSTRAINT `fk_graduado_tipolicencia` FOREIGN KEY (`cod_tipolicencia`) REFERENCES `tipo_licencia` (`codigo`);

--
-- Filtros para la tabla `historia_laboral`
--
ALTER TABLE `historia_laboral`
  ADD CONSTRAINT `fk_historialaboral_graduado` FOREIGN KEY (`cod_graduado`) REFERENCES `graduado` (`codigo`),
  ADD CONSTRAINT `fk_historialaboral_tipocargo` FOREIGN KEY (`cod_tipocargo`) REFERENCES `tipo_cargo` (`codigo`),
  ADD CONSTRAINT `fk_historialaboral_tipocausasalida` FOREIGN KEY (`cod_tipocausasalida`) REFERENCES `tipo_causa_salida` (`codigo`);

--
-- Filtros para la tabla `oferta_laboral`
--
ALTER TABLE `oferta_laboral`
  ADD CONSTRAINT `fk_ofertalaboral_empresa` FOREIGN KEY (`cod_empresa`) REFERENCES `empresa` (`codigo`),
  ADD CONSTRAINT `fk_ofertalaboral_tipocargo` FOREIGN KEY (`cod_tipocargo`) REFERENCES `tipo_cargo` (`codigo`),
  ADD CONSTRAINT `fk_ofertalaboral_tiposueldo` FOREIGN KEY (`cod_tiposueldo`) REFERENCES `tipo_sueldo` (`codigo`);

--
-- Filtros para la tabla `personal`
--
ALTER TABLE `personal`
  ADD CONSTRAINT `fk_personal_tipopersonal` FOREIGN KEY (`cod_tipopersonal`) REFERENCES `tipo_personal` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
