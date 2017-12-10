-- MySQL dump 10.13  Distrib 5.6.38, for Linux (x86_64)
--
-- Host: localhost    Database: graduado
-- ------------------------------------------------------
-- Server version	5.6.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aplicar_oferta`
--

DROP TABLE IF EXISTS `aplicar_oferta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aplicar_oferta`
--

LOCK TABLES `aplicar_oferta` WRITE;
/*!40000 ALTER TABLE `aplicar_oferta` DISABLE KEYS */;
INSERT INTO `aplicar_oferta` VALUES (1,1,1512709200000,'si',1512709200000);
/*!40000 ALTER TABLE `aplicar_oferta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `capacitacion`
--

DROP TABLE IF EXISTS `capacitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capacitacion`
--

LOCK TABLES `capacitacion` WRITE;
/*!40000 ALTER TABLE `capacitacion` DISABLE KEYS */;
INSERT INTO `capacitacion` VALUES (1,3,'Redes informáticas',40,'Aprobación',1326344400000),(2,2,'Programación en Java',20,'Aprobación',1275368400000),(3,1,'Tributación',40,'Aprobación',1442293200000),(4,3,'Mantenimiento de computadores',40,'Aprobación',1361336400000);
/*!40000 ALTER TABLE `capacitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursado`
--

DROP TABLE IF EXISTS `cursado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursado` (
  `cod_graduado` int(11) NOT NULL,
  `cod_capacitacion` int(11) NOT NULL,
  PRIMARY KEY (`cod_graduado`,`cod_capacitacion`),
  KEY `fk_cursado_capacitacion` (`cod_capacitacion`),
  CONSTRAINT `fk_cursado_capacitacion` FOREIGN KEY (`cod_capacitacion`) REFERENCES `capacitacion` (`codigo`),
  CONSTRAINT `fk_cursado_graduado` FOREIGN KEY (`cod_graduado`) REFERENCES `graduado` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursado`
--

LOCK TABLES `cursado` WRITE;
/*!40000 ALTER TABLE `cursado` DISABLE KEYS */;
INSERT INTO `cursado` VALUES (1,1),(2,1),(1,2),(3,3),(1,4),(2,4);
/*!40000 ALTER TABLE `cursado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,1,'TIA S.A.','Avenida Bolívar y Lalama - Ambato','032457890','cbastidas','si','carolina123'),(2,5,'Plasticaucho S.A.','Fábrica sector La península','032445566','Julia Peralta','si','julia123'),(3,4,'El Huerto','Avenida 12 de noviembre y Tomás Sevilla','032453672','Milton Sánchez','no','milton123'),(4,1,'Distribuidora Mejía','Avenida El Condor sector mercado mayorista','032654783','Patricia Carvajal','si','patricia123');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_civil`
--

DROP TABLE IF EXISTS `estado_civil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_civil` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_civil`
--

LOCK TABLES `estado_civil` WRITE;
/*!40000 ALTER TABLE `estado_civil` DISABLE KEYS */;
INSERT INTO `estado_civil` VALUES (1,'Soltero'),(2,'Casado'),(3,'Divorciado'),(4,'Viudo'),(5,'Union Libre'),(6,'Union de Hecho');
/*!40000 ALTER TABLE `estado_civil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `graduado`
--

DROP TABLE IF EXISTS `graduado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `graduado`
--

LOCK TABLES `graduado` WRITE;
/*!40000 ALTER TABLE `graduado` DISABLE KEYS */;
INSERT INTO `graduado` VALUES (1,5,2,'Henry Bucheli','1802456789',797317200000,'Ambato','Avenida Corazón Cdla. 12 de Noviembre','032456789','0987234567','0981234567','henryb@hotmail.com','Henry Bucheli','henry123'),(2,1,3,'Carlos Aguayo','1804567123',783061200000,'Ambato','Avenida Quito frente a la cruz roja','032451234','0988132457','0981368291','kyke_aguayo@yahoo.es','Kyke Aguayo','carlos123'),(3,2,4,'Jenny Rivera','1802834967',555829200000,'Quito','Sector villaflora','023943856','0985653801','0996101293','jennyr1985@gmail.com','Negrita Rivera','jenny123');
/*!40000 ALTER TABLE `graduado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historia_laboral`
--

DROP TABLE IF EXISTS `historia_laboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historia_laboral`
--

LOCK TABLES `historia_laboral` WRITE;
/*!40000 ALTER TABLE `historia_laboral` DISABLE KEYS */;
INSERT INTO `historia_laboral` VALUES (1,3,1,3,1425186000000,1456808400000,'Distribuidora Mejía'),(2,1,5,2,1412139600000,1434344400000,'Plasticaucho S.A.'),(3,1,1,4,1446354000000,1477976400000,'TIA S.A.');
/*!40000 ALTER TABLE `historia_laboral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oferta_laboral`
--

DROP TABLE IF EXISTS `oferta_laboral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oferta_laboral`
--

LOCK TABLES `oferta_laboral` WRITE;
/*!40000 ALTER TABLE `oferta_laboral` DISABLE KEYS */;
INSERT INTO `oferta_laboral` VALUES (1,1,3,1,'Encargado(a) de administrar el locar de westerm union en TIA de la avenida Tomás Sevilla y Juan Benigno Vela  ','2 años o más en cargos similares'),(2,3,5,1,'Se requiere un vendedor externo de insumos agrícolas','2 años o más en cargos similares'),(3,1,4,1,'Se requiere un técnico en mantenimiento de equipos de cómputo','2 años o más en cargos similares');
/*!40000 ALTER TABLE `oferta_laboral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `valor` int(11) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_tipopersonal` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_personal_tipopersonal` (`cod_tipopersonal`),
  CONSTRAINT `fk_personal_tipopersonal` FOREIGN KEY (`cod_tipopersonal`) REFERENCES `tipo_personal` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (1,1,'admin','123'),(2,4,'henryb','henry123'),(3,4,'jennyr','jenny123'),(4,4,'carlosa','carlos123'),(5,3,'carolinab','carolina123'),(6,3,'juliap','julia123'),(7,3,'miltons','milton123'),(8,3,'patriciac','patricia123');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_actividad`
--

DROP TABLE IF EXISTS `tipo_actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_actividad` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_actividad`
--

LOCK TABLES `tipo_actividad` WRITE;
/*!40000 ALTER TABLE `tipo_actividad` DISABLE KEYS */;
INSERT INTO `tipo_actividad` VALUES (1,'Comercialización de varios productos'),(2,'Comercialización de productos alimenticios'),(3,'Mega ferretería'),(4,'Comercializadora de insumos agrícolas'),(5,'Fábrica de calzado');
/*!40000 ALTER TABLE `tipo_actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_capacitacion`
--

DROP TABLE IF EXISTS `tipo_capacitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_capacitacion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_capacitacion`
--

LOCK TABLES `tipo_capacitacion` WRITE;
/*!40000 ALTER TABLE `tipo_capacitacion` DISABLE KEYS */;
INSERT INTO `tipo_capacitacion` VALUES (1,'Seminario'),(2,'Taller'),(3,'Curso'),(4,'Curso virtual');
/*!40000 ALTER TABLE `tipo_capacitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cargo`
--

DROP TABLE IF EXISTS `tipo_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_cargo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cargo`
--

LOCK TABLES `tipo_cargo` WRITE;
/*!40000 ALTER TABLE `tipo_cargo` DISABLE KEYS */;
INSERT INTO `tipo_cargo` VALUES (1,'Administrador de base de datos'),(2,'Programador Java'),(3,'Administrador de tienda'),(4,'Técnico en mantenimiento de computadores'),(5,'Vendedor'),(6,'Auxiliar contable');
/*!40000 ALTER TABLE `tipo_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_causa_salida`
--

DROP TABLE IF EXISTS `tipo_causa_salida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_causa_salida` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_causa_salida`
--

LOCK TABLES `tipo_causa_salida` WRITE;
/*!40000 ALTER TABLE `tipo_causa_salida` DISABLE KEYS */;
INSERT INTO `tipo_causa_salida` VALUES (1,'término de contrato'),(5,'conflictos con el jefe superior o empleador'),(7,'otros');
/*!40000 ALTER TABLE `tipo_causa_salida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_licencia`
--

DROP TABLE IF EXISTS `tipo_licencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_licencia` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_licencia`
--

LOCK TABLES `tipo_licencia` WRITE;
/*!40000 ALTER TABLE `tipo_licencia` DISABLE KEYS */;
INSERT INTO `tipo_licencia` VALUES (1,'TIPO A'),(2,'TIPO B'),(3,'TIPO C'),(4,'Ninguna');
/*!40000 ALTER TABLE `tipo_licencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_personal`
--

DROP TABLE IF EXISTS `tipo_personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_personal` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_personal`
--

LOCK TABLES `tipo_personal` WRITE;
/*!40000 ALTER TABLE `tipo_personal` DISABLE KEYS */;
INSERT INTO `tipo_personal` VALUES (1,'Administrador'),(3,'Empresa'),(4,'Graduado');
/*!40000 ALTER TABLE `tipo_personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_sueldo`
--

DROP TABLE IF EXISTS `tipo_sueldo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_sueldo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `rango` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_sueldo`
--

LOCK TABLES `tipo_sueldo` WRITE;
/*!40000 ALTER TABLE `tipo_sueldo` DISABLE KEYS */;
INSERT INTO `tipo_sueldo` VALUES (1,'de 380 a 500 usd'),(2,'de 501 a 750 usd'),(3,'de 751 a 1000 usd'),(4,'de 1001 usd a 1250 usd'),(5,'de 1251 a 1500 usd'),(6,'de 1501 usd en adelante');
/*!40000 ALTER TABLE `tipo_sueldo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-10  0:25:01
