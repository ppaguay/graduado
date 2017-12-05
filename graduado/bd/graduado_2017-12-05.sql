/*
SQLyog Community Edition- MySQL GUI v8.05 
MySQL - 5.5.5-10.1.25-MariaDB : Database - graduado
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`graduado` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `graduado`;

/*Table structure for table `aplicar_oferta` */

DROP TABLE IF EXISTS `aplicar_oferta`;

CREATE TABLE `aplicar_oferta` (
  `cod_graduado` int(11) NOT NULL,
  `cod_ofertalaboral` int(11) NOT NULL,
  `fecha_aplica` bigint(20) DEFAULT NULL,
  `contrato` varchar(2) DEFAULT NULL,
  `fecha_inicio` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cod_graduado`,`cod_ofertalaboral`),
  KEY `fk_aplicaroferta_ofertalaboral` (`cod_ofertalaboral`),
  CONSTRAINT `fk_aplicaroferta_graduado` FOREIGN KEY (`cod_graduado`) REFERENCES `graduado` (`codigo`),
  CONSTRAINT `fk_aplicaroferta_ofertalaboral` FOREIGN KEY (`cod_ofertalaboral`) REFERENCES `oferta_laboral` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `aplicar_oferta` */

/*Table structure for table `capacitacion` */

DROP TABLE IF EXISTS `capacitacion`;

CREATE TABLE `capacitacion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_tipocapacitacion` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  `caracteristica` varchar(150) DEFAULT NULL,
  `fecha` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_capacitacion_tipocapacitacion` (`cod_tipocapacitacion`),
  CONSTRAINT `fk_capacitacion_tipocapacitacion` FOREIGN KEY (`cod_tipocapacitacion`) REFERENCES `tipo_capacitacion` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `capacitacion` */

/*Table structure for table `cursado` */

DROP TABLE IF EXISTS `cursado`;

CREATE TABLE `cursado` (
  `cod_graduado` int(11) NOT NULL ,
  `cod_capacitacion` int(11) NOT NULL,
  PRIMARY KEY (`cod_graduado`,`cod_capacitacion`),
  KEY `fk_cursado_capacitacion` (`cod_capacitacion`),
  CONSTRAINT `fk_cursado_capacitacion` FOREIGN KEY (`cod_capacitacion`) REFERENCES `capacitacion` (`codigo`),
  CONSTRAINT `fk_cursado_graduado` FOREIGN KEY (`cod_graduado`) REFERENCES `graduado` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cursado` */

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_tipoactividad` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `pertenece` varchar(2) DEFAULT NULL,
  `clave` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_empresa_tipoactividad` (`cod_tipoactividad`),
  CONSTRAINT `fk_empresa_tipoactividad` FOREIGN KEY (`cod_tipoactividad`) REFERENCES `tipo_actividad` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `empresa` */

/*Table structure for table `estado_civil` */

DROP TABLE IF EXISTS `estado_civil`;

CREATE TABLE `estado_civil` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `estado_civil` */

/*Table structure for table `graduado` */

DROP TABLE IF EXISTS `graduado`;

CREATE TABLE `graduado` (
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
  `clave` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_graduado_tipoestadocivil` (`cod_estadocivil`),
  KEY `fk_graduado_tipolicencia` (`cod_tipolicencia`),
  CONSTRAINT `fk_graduado_tipoestadocivil` FOREIGN KEY (`cod_estadocivil`) REFERENCES `estado_civil` (`codigo`),
  CONSTRAINT `fk_graduado_tipolicencia` FOREIGN KEY (`cod_tipolicencia`) REFERENCES `tipo_licencia` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `graduado` */

/*Table structure for table `historia_laboral` */

DROP TABLE IF EXISTS `historia_laboral`;

CREATE TABLE `historia_laboral` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_graduado` int(11) DEFAULT NULL,
  `cod_tipocausasalida` int(11) DEFAULT NULL,
  `cod_tipocargo` int(11) DEFAULT NULL,
  `fechainicio` bigint(20) DEFAULT NULL,
  `fechafin` bigint(20) DEFAULT NULL,
  `empresa` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_historialaboral_graduado` (`cod_graduado`),
  KEY `fk_historialaboral_tipocargo` (`cod_tipocargo`),
  KEY `fk_historialaboral_tipocausasalida` (`cod_tipocausasalida`),
  CONSTRAINT `fk_historialaboral_graduado` FOREIGN KEY (`cod_graduado`) REFERENCES `graduado` (`codigo`),
  CONSTRAINT `fk_historialaboral_tipocargo` FOREIGN KEY (`cod_tipocargo`) REFERENCES `tipo_cargo` (`codigo`),
  CONSTRAINT `fk_historialaboral_tipocausasalida` FOREIGN KEY (`cod_tipocausasalida`) REFERENCES `tipo_causa_salida` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `historia_laboral` */

/*Table structure for table `oferta_laboral` */

DROP TABLE IF EXISTS `oferta_laboral`;

CREATE TABLE `oferta_laboral` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_empresa` int(11) DEFAULT NULL,
  `cod_tipocargo` int(11) DEFAULT NULL,
  `cod_tiposueldo` int(11) DEFAULT NULL,
  `caract_cargo` varchar(200) DEFAULT NULL,
  `experiencia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_ofertalaboral_empresa` (`cod_empresa`),
  KEY `fk_ofertalaboral_tipocargo` (`cod_tipocargo`),
  KEY `fk_ofertalaboral_tiposueldo` (`cod_tiposueldo`),
  CONSTRAINT `fk_ofertalaboral_empresa` FOREIGN KEY (`cod_empresa`) REFERENCES `empresa` (`codigo`),
  CONSTRAINT `fk_ofertalaboral_tipocargo` FOREIGN KEY (`cod_tipocargo`) REFERENCES `tipo_cargo` (`codigo`),
  CONSTRAINT `fk_ofertalaboral_tiposueldo` FOREIGN KEY (`cod_tiposueldo`) REFERENCES `tipo_sueldo` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `oferta_laboral` */

/*Table structure for table `parametro` */

DROP TABLE IF EXISTS `parametro`;

CREATE TABLE `parametro` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `valor` int(11) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `parametro` */

/*Table structure for table `personal` */

DROP TABLE IF EXISTS `personal`;

CREATE TABLE `personal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_tipopersonal` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_personal_tipopersonal` (`cod_tipopersonal`),
  CONSTRAINT `fk_personal_tipopersonal` FOREIGN KEY (`cod_tipopersonal`) REFERENCES `tipo_personal` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `personal` */

/*Table structure for table `tipo_actividad` */

DROP TABLE IF EXISTS `tipo_actividad`;

CREATE TABLE `tipo_actividad` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_actividad` */

/*Table structure for table `tipo_capacitacion` */

DROP TABLE IF EXISTS `tipo_capacitacion`;

CREATE TABLE `tipo_capacitacion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_capacitacion` */

/*Table structure for table `tipo_cargo` */

DROP TABLE IF EXISTS `tipo_cargo`;

CREATE TABLE `tipo_cargo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_cargo` */

/*Table structure for table `tipo_causa_salida` */

DROP TABLE IF EXISTS `tipo_causa_salida`;

CREATE TABLE `tipo_causa_salida` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_causa_salida` */

/*Table structure for table `tipo_licencia` */

DROP TABLE IF EXISTS `tipo_licencia`;

CREATE TABLE `tipo_licencia` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_licencia` */

/*Table structure for table `tipo_personal` */

DROP TABLE IF EXISTS `tipo_personal`;

CREATE TABLE `tipo_personal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_personal` */

/*Table structure for table `tipo_sueldo` */

DROP TABLE IF EXISTS `tipo_sueldo`;

CREATE TABLE `tipo_sueldo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `rango` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_sueldo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
