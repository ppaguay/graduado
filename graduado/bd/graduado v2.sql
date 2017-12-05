-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-12-2017 a las 16:55:45
-- Versión del servidor: 5.7.19
-- Versión de PHP: 5.6.31

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

DROP TABLE IF EXISTS `aplicar_oferta`;
CREATE TABLE IF NOT EXISTS `aplicar_oferta` (
  `cod_graduado` int(11) NOT NULL,
  `cod_ofertalaboral` int(11) NOT NULL,
  `fecha_aplica` bigint(20) DEFAULT NULL,
  `contrato` varchar(2) DEFAULT NULL,
  `fecha_inicio` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cod_graduado`,`cod_ofertalaboral`),
  KEY `fk_aplicaroferta_ofertalaboral` (`cod_ofertalaboral`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capacitacion`
--

DROP TABLE IF EXISTS `capacitacion`;
CREATE TABLE IF NOT EXISTS `capacitacion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_tipocapacitacion` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  `caracteristica` varchar(150) DEFAULT NULL,
  `fecha` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_capacitacion_tipocapacitacion` (`cod_tipocapacitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursado`
--

DROP TABLE IF EXISTS `cursado`;
CREATE TABLE IF NOT EXISTS `cursado` (
  `cod_graduado` int(11) NOT NULL,
  `cod_capacitacion` int(11) NOT NULL,
  PRIMARY KEY (`cod_graduado`,`cod_capacitacion`),
  KEY `fk_cursado_capacitacion` (`cod_capacitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE IF NOT EXISTS `empresa` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_tipoactividad` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `pertenece` varchar(2) DEFAULT NULL,
  `clave` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_empresa_tipoactividad` (`cod_tipoactividad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_civil`
--

DROP TABLE IF EXISTS `estado_civil`;
CREATE TABLE IF NOT EXISTS `estado_civil` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `graduado`
--

DROP TABLE IF EXISTS `graduado`;
CREATE TABLE IF NOT EXISTS `graduado` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
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
  `clave` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_graduado_tipoestadocivil` (`cod_estadocivil`),
  KEY `fk_graduado_tipolicencia` (`cod_tipolicencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historia_laboral`
--

DROP TABLE IF EXISTS `historia_laboral`;
CREATE TABLE IF NOT EXISTS `historia_laboral` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_graduado` int(11) DEFAULT NULL,
  `cod_tipocausasalida` int(11) DEFAULT NULL,
  `cod_tipocargo` int(11) DEFAULT NULL,
  `cod_empresa` int(11) DEFAULT NULL,
  `fechainicio` bigint(20) DEFAULT NULL,
  `fechafin` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_historialaboral_empresa` (`cod_empresa`),
  KEY `fk_historialaboral_graduado` (`cod_graduado`),
  KEY `fk_historialaboral_tipocargo` (`cod_tipocargo`),
  KEY `fk_historialaboral_tipocausasalida` (`cod_tipocausasalida`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta_laboral`
--

DROP TABLE IF EXISTS `oferta_laboral`;
CREATE TABLE IF NOT EXISTS `oferta_laboral` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_empresa` int(11) DEFAULT NULL,
  `cod_tipocargo` int(11) DEFAULT NULL,
  `cod_tiposueldo` int(11) DEFAULT NULL,
  `caract_cargo` varchar(200) DEFAULT NULL,
  `experiencia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_ofertalaboral_empresa` (`cod_empresa`),
  KEY `fk_ofertalaboral_tipocargo` (`cod_tipocargo`),
  KEY `fk_ofertalaboral_tiposueldo` (`cod_tiposueldo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametro`
--

DROP TABLE IF EXISTS `parametro`;
CREATE TABLE IF NOT EXISTS `parametro` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `valor` int(11) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

DROP TABLE IF EXISTS `personal`;
CREATE TABLE IF NOT EXISTS `personal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_tipopersonal` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_personal_tipopersonal` (`cod_tipopersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_actividad`
--

DROP TABLE IF EXISTS `tipo_actividad`;
CREATE TABLE IF NOT EXISTS `tipo_actividad` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_capacitacion`
--

DROP TABLE IF EXISTS `tipo_capacitacion`;
CREATE TABLE IF NOT EXISTS `tipo_capacitacion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cargo`
--

DROP TABLE IF EXISTS `tipo_cargo`;
CREATE TABLE IF NOT EXISTS `tipo_cargo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_causa_salida`
--

DROP TABLE IF EXISTS `tipo_causa_salida`;
CREATE TABLE IF NOT EXISTS `tipo_causa_salida` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_licencia`
--

DROP TABLE IF EXISTS `tipo_licencia`;
CREATE TABLE IF NOT EXISTS `tipo_licencia` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_personal`
--

DROP TABLE IF EXISTS `tipo_personal`;
CREATE TABLE IF NOT EXISTS `tipo_personal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_personal`
--

INSERT INTO `tipo_personal` (`codigo`, `nombre`) VALUES
(1, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_sueldo`
--

DROP TABLE IF EXISTS `tipo_sueldo`;
CREATE TABLE IF NOT EXISTS `tipo_sueldo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `rango` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD CONSTRAINT `fk_historialaboral_empresa` FOREIGN KEY (`cod_empresa`) REFERENCES `empresa` (`codigo`),
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
