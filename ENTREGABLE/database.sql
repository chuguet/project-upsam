CREATE DATABASE  IF NOT EXISTS `db_hospital` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_hospital`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: db_hospital_2
-- ------------------------------------------------------
-- Server version	5.5.36

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
-- Table structure for table `angle`
--

DROP TABLE IF EXISTS `angle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `angle` (
  `ID_ANGLE` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `ID_TABLA_DATOS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ANGLE`),
  KEY `FK3B880B32FCD3140` (`ID_TABLA_DATOS`),
  CONSTRAINT `FK3B880B32FCD3140` FOREIGN KEY (`ID_TABLA_DATOS`) REFERENCES `tabla_datos` (`ID_TABLA_DATOS`)
) ENGINE=InnoDB AUTO_INCREMENT=221 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `antecedentes_personales`
--

DROP TABLE IF EXISTS `antecedentes_personales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antecedentes_personales` (
  `ID_ANTECEDENTES_PERSONALES` int(11) NOT NULL AUTO_INCREMENT,
  `ALERGIAS` varchar(255) DEFAULT NULL,
  `AUDICION` varchar(255) DEFAULT NULL,
  `CAIDAS` bit(1) DEFAULT NULL,
  `COMPRESION` varchar(255) DEFAULT NULL,
  `ENTIENDE_ORDENES_COMPLEJAS` bit(1) DEFAULT NULL,
  `ENTIENDE_ORDENES_SIMPLES` bit(1) DEFAULT NULL,
  `EPILEPSIA` bit(1) DEFAULT NULL,
  `EXPRESAR_NECESIDAD_DOLOR` bit(1) DEFAULT NULL,
  `FECHA_PENULTIMA_SESION` datetime DEFAULT NULL,
  `FECHA_ULTIMA_CAIDA` datetime DEFAULT NULL,
  `FECHA_ULTIMA_CONVULSION` datetime DEFAULT NULL,
  `FECHA_ULTIMA_CRISIS` datetime DEFAULT NULL,
  `FECHA_ULTIMA_SESION` datetime DEFAULT NULL,
  `LENGUAJE_COGNICION` bit(1) DEFAULT NULL,
  `LOCALIZACION_TRATAMIENTO` int(11) DEFAULT NULL,
  `NUMERO_CAIDAS` int(11) DEFAULT NULL,
  `NUMERO_CRISIS` int(11) DEFAULT NULL,
  `NUMERO_INYECCIONES` int(11) DEFAULT NULL,
  `TIPO_EPILEPSIA` varchar(255) DEFAULT NULL,
  `TRATAMIENTO` varchar(255) DEFAULT NULL,
  `VISION` varchar(255) DEFAULT NULL,
  `ID_EXPLORACION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ANTECEDENTES_PERSONALES`),
  UNIQUE KEY `ID_EXPLORACION` (`ID_EXPLORACION`),
  KEY `FK384B3438670BE6D7` (`ID_EXPLORACION`),
  CONSTRAINT `FK384B3438670BE6D7` FOREIGN KEY (`ID_EXPLORACION`) REFERENCES `exploracion` (`ID_EXPLORACION`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `antecedentes_quirurgicos_ortopedicos`
--

DROP TABLE IF EXISTS `antecedentes_quirurgicos_ortopedicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antecedentes_quirurgicos_ortopedicos` (
  `ID_ANTECEDENTES_QUIRURGICOS` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `ES_QUIRURGICO` bit(1) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `ID_ANTECEDENTES_PERSONALES` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ANTECEDENTES_QUIRURGICOS`),
  KEY `FKA8F923219127C0E4` (`ID_ANTECEDENTES_PERSONALES`),
  CONSTRAINT `FKA8F923219127C0E4` FOREIGN KEY (`ID_ANTECEDENTES_PERSONALES`) REFERENCES `antecedentes_personales` (`ID_ANTECEDENTES_PERSONALES`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `antecedentes_relacionados_pci`
--

DROP TABLE IF EXISTS `antecedentes_relacionados_pci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `antecedentes_relacionados_pci` (
  `ID_ANTECEDENTES_PERSONALES_PCI` int(11) NOT NULL AUTO_INCREMENT,
  `AYUDAS_MARCHA` int(11) DEFAULT NULL,
  `DEPORTES` varchar(255) DEFAULT NULL,
  `DIAGNOSTICO_ESPECIFICAR` varchar(255) DEFAULT NULL,
  `DISPOSITIVO_MAS_USADO` varchar(255) DEFAULT NULL,
  `EQUIPAMIENTO` varchar(255) DEFAULT NULL,
  `ETIOLOGIA` varchar(255) DEFAULT NULL,
  `exteriores` varchar(255) DEFAULT NULL,
  `FISIOTERAPIA_DURACION` varchar(255) DEFAULT NULL,
  `FISIOTERAPIA_SESIONES` int(11) DEFAULT NULL,
  `HIDROTERAPIA` varchar(255) DEFAULT NULL,
  `INTERIORES` varchar(255) DEFAULT NULL,
  `LG_DURACION` varchar(255) DEFAULT NULL,
  `LG_SESIONES` int(11) DEFAULT NULL,
  `LOCALIZACION` varchar(255) DEFAULT NULL,
  `ORTESIS_DIURNA` int(11) DEFAULT NULL,
  `ORTESIS_NOCTURNA` varchar(255) DEFAULT NULL,
  `OTRAS` varchar(255) DEFAULT NULL,
  `PRUEBAS_COMPLEMENTARIAS` varchar(255) DEFAULT NULL,
  `TERAPIA_OCUPACIONAL_DURACION` varchar(255) DEFAULT NULL,
  `TERAPIA_OCUPACIONAL_SESIONES` int(11) DEFAULT NULL,
  `TERAPIAS_HABITUALES` varchar(255) DEFAULT NULL,
  `TRATAMIENTO_ACTUAL` varchar(255) DEFAULT NULL,
  `ID_EXPLORACION` int(11) DEFAULT NULL,
  `OTRA_ORTESIS` varchar(255) DEFAULT NULL,
  `OTRAS_TERAPIAS` varchar(255) DEFAULT NULL,
  `TIPO_PCI` int(11) DEFAULT NULL,
  `GMFCS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_ANTECEDENTES_PERSONALES_PCI`),
  UNIQUE KEY `ID_EXPLORACION` (`ID_EXPLORACION`),
  KEY `FKAF783635670BE6D7` (`ID_EXPLORACION`),
  CONSTRAINT `FKAF783635670BE6D7` FOREIGN KEY (`ID_EXPLORACION`) REFERENCES `exploracion` (`ID_EXPLORACION`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `campo`
--

DROP TABLE IF EXISTS `campo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campo` (
  `ID_CAMPO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `ID_PAGINA` int(11) DEFAULT NULL,
  `REFLEXION_ATRIBUTO` varchar(255) DEFAULT NULL,
  `REFLEXION_CLASE` varchar(255) DEFAULT NULL,
  `MAX_VALUE` double DEFAULT NULL,
  `MIN_VALUE` double DEFAULT NULL,
  PRIMARY KEY (`ID_CAMPO`),
  KEY `FK3CEDDEECB7CAE7D` (`ID_PAGINA`),
  CONSTRAINT `FK3CEDDEECB7CAE7D` FOREIGN KEY (`ID_PAGINA`) REFERENCES `pagina` (`ID_PAGINA`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campo`
--

LOCK TABLES `campo` WRITE;
/*!40000 ALTER TABLE `campo` DISABLE KEYS */;
INSERT INTO `campo` VALUES (1,'Nombre',1,'nombre','com.upsam.hospital.model.beans.Paciente',NULL,NULL),(2,'Apellidos',1,'apellidos','com.upsam.hospital.model.beans.Paciente',NULL,NULL),(3,'Número de identificación',1,'numeroIdentificacion','com.upsam.hospital.model.beans.Paciente',NULL,NULL),(4,'Sexo',1,'sexo','com.upsam.hospital.model.beans.Paciente',1,0),(5,'Teléfono',1,'telefono','com.upsam.hospital.model.beans.Paciente',NULL,NULL),(6,'Fecha de nacimiento',1,'fechaNacimiento','com.upsam.hospital.model.beans.Paciente',NULL,NULL),(7,'Curso',1,'curso','com.upsam.hospital.model.beans.Paciente',NULL,NULL),(8,'Escolarización',1,'escolarizacion','com.upsam.hospital.model.beans.Paciente',NULL,NULL),(9,'Análisis observacional de la marcha',2,'analisisObservacionalMarcha','com.upsam.hospital.model.beans.Exploracion',NULL,NULL),(10,'Cadera flexión derecha',2,'caderaFlexionDerecha','com.upsam.hospital.model.beans.Exploracion',5,0),(11,'Cadera flexión izquierda',2,'caderaFlexionIzquierda','com.upsam.hospital.model.beans.Exploracion',5,0),(12,'Cadera inflexión derecha',2,'caderaInflexionDerecha','com.upsam.hospital.model.beans.Exploracion',5,0),(13,'Cadera inflexión izquierda',2,'caderaInflexionIzquierda','com.upsam.hospital.model.beans.Exploracion',5,0),(14,'Control motor selectivo',2,'controlMotorSelectivo','com.upsam.hospital.model.beans.Exploracion',2,0),(15,'Evaluación muscular',2,'evaluacionMuscular','com.upsam.hospital.model.beans.Exploracion',7,0),(16,'Longitud del miembro derecho',2,'longitudMiembroDerecho','com.upsam.hospital.model.beans.Exploracion',100,0),(17,'Longitud del miembro izquierdo',2,'longitudMiembroIzquierdo','com.upsam.hospital.model.beans.Exploracion',100,0),(18,'Puntuación 5 metros',2,'puntuacion5Metros','com.upsam.hospital.model.beans.Exploracion',8,1),(19,'Puntuación 50 metros',2,'puntuacion50Metros','com.upsam.hospital.model.beans.Exploracion',8,1),(20,'Puntuación 500 metros',2,'puntuacion500Metros','com.upsam.hospital.model.beans.Exploracion',8,1),(21,'Rodilla flexión derecha',2,'rodillaFlexionDerecha','com.upsam.hospital.model.beans.Exploracion',5,0),(22,'Rodilla flexión izquierda',2,'rodillaFlexionIzquierda','com.upsam.hospital.model.beans.Exploracion',5,0),(23,'Rodilla inflexión derecha',2,'rodillaInflexionDerecha','com.upsam.hospital.model.beans.Exploracion',5,0),(24,'Rodilla inflexión izquierda',2,'rodillaInflexionIzquierda','com.upsam.hospital.model.beans.Exploracion',5,0),(25,'Tobillo flexión derecha',2,'tobilloFlexionDerecha','com.upsam.hospital.model.beans.Exploracion',5,0),(26,'Tobillo flexión izquierda',2,'tobilloFlexionIzquierda','com.upsam.hospital.model.beans.Exploracion',5,0),(27,'Tobillo inflexión derecha',2,'tobilloInflexionDerecha','com.upsam.hospital.model.beans.Exploracion',5,0),(28,'Tobillo inflexión izquierda',2,'tobilloInflexionIzquierda','com.upsam.hospital.model.beans.Exploracion',5,0),(29,'Tiene epilepsia?',3,'epilepsia','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(30,'Tipo de epilepsia',3,'tipoEpilepsia','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(31,'Fecha de la última crisis',3,'fechaUltimaCrisis','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(32,'Fecha de la última convulsión',3,'fechaUltimaConvulsion','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(33,'Número de crisis',3,'numeroCrisis','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(34,'Sufre caídas?',3,'caidas','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(35,'Número de caídas',3,'numeroCaidas','com.upsam.hospital.model.beans.AntecedentesPersonales',10,0),(36,'Fecha de la última caída',3,'fechaUltimaCaida','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(37,'Audición',3,'audicion','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(38,'Visión',3,'vision','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(39,'Lenguaje y cognición?',3,'lenguajeCognicion','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(40,'Comprensión',3,'comprension','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(41,'Entiende órdenes simples?',3,'entiendeOrdenesSimples','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(42,'Entiende órdenes complejas?',3,'entiendeOrdenesComplejas','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(43,'Expresa la necesidad y el dolor',3,'expresarNecesidadDolor','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(44,'Número de inyecciones',3,'numeroInyecciones','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(45,'Fecha de la última sesión',3,'fechaUltimaSesion','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(46,'Fecha de la penúltima sesión',3,'fechaPenultimaSesion','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(47,'Localización del tratamiento',3,'localizacionTratamiento','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(48,'Alergias',3,'alergias','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(49,'Tratamiento',3,'tratamiento','com.upsam.hospital.model.beans.AntecedentesPersonales',NULL,NULL),(50,'Tipo de ayuda a la marcha',4,'ayudasMarcha','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(51,'Tipo de diagnóstico PCI',4,'tipoPCI','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(52,'Deportes',4,'deportes','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(53,'Especificar diagnóstico',4,'diagnosticoEspecificar','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(54,'Dispositivo más usado',4,'dispositivoMasUsado','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(55,'Equipamiento',4,'equipamiento','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(56,'Etiología',4,'etiologia','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(57,'Exteriores',4,'exteriores','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(58,'Duración de la fisioterapia',4,'fisioterapiaDuracion','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(59,'Sesiones de fisioterapia',4,'fisioterapiaSesiones','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(60,'GMFCS',4,'gmfcs','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(61,'Hidroterapia',4,'hidroterapia','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(62,'Otras terapias',4,'otrasTerapias','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(63,'Interiores',4,'interiores','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(64,'LG duración',4,'lgDuracion','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(65,'LG número de sesiones',4,'lgSesiones','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(66,'Localización',4,'localizacion','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(67,'Órtesis diurna',4,'ortesisDiurna','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(68,'Órtesis nocturna',4,'ortesisNocturna','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(69,'Otra Órtesis',4,'otraOrtesis','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(70,'Otras',4,'otras','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(71,'Pruebas complementarias',4,'pruebasComplementarias','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(72,'Duración de la terapia ocupacional',4,'terapiaOcupacionalDuracion','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(73,'Sesiones de la terapia ocupacional',4,'terapiaOcupacionalSesiones','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(74,'Terapias habituales',4,'terapiasHabituales','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(75,'Tratamiento actual',4,'tratamientoActual','com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI',NULL,NULL),(76,'En el suelo se pone de pie apóyandose en un banco alto',5,'var1','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(77,'De pie se mantiene sin apoyar los brazos durante 3 segundos',5,'var2','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(78,'De pie agarrado con una mano a un banco alto, levanta el pie derecho durante 3 segundos',5,'var3','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(79,'De pie agarrado con una mano a un banco alto, levanta el pie izquierdo durante 3 segundos',5,'var4','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(80,'De pie se mantiene sin apoyar los brazos durante 20 segundos',5,'var5','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(81,'De pie levanta el pie izquierdo sin apoyar los brazos durante 10 segundos',5,'var6','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(82,'De pie levanta el pie derecho sin apoyar los brazos durante 10 segundos',5,'var7','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(83,'Sentado en un banco bajo consigue ponerse de pie sin usar los brazos',5,'var8','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(84,'De rodillas consigue ponerse de pie apoyándose en la rodilla derecha sin usar los brazos',5,'var9','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(85,'De rodillas consigue ponerse de pie apoyándose en la rodilla izquierda sin usar los brazos',5,'var10','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(86,'De pie se agacha para sentarse en el suelo con control sin apoyar los brazos',5,'var11','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(87,'De pie consigue ponerse en cuclillas sin apoyar los brazos',5,'var12','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(88,'De pie coge un objeto del suelo y vuelve a ponerse de pie sin apoyar los brazos',5,'var13','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(89,'De pie con las 2 manos en un banco alto da 5 pasos hacia la derecha',5,'var14','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(90,'De pie con las 2 manos en un banco alto da 5 pasos hacia la izquierda',5,'var15','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(91,'De pie agarrado por las 2 manos camina 10 pasos hacia delante',5,'var16','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(92,'De pie agarrado por una mano camina 10 pasos hacia delante',5,'var17','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(93,'De pie camina 10 pasos hacia delante',5,'var18','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(94,'De pie camina 10 pasos hacia delante, se detiene, gira 180º y vuelve',5,'var19','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(95,'De pie camina 10 pasos hacia atrás',5,'var20','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(96,'De pie camina 10 pasos consecutivos hacia delante, llevando un objeto grande con las 2 manos',5,'var21','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(97,'De pie camina 10 pasos consecutivos hacia delante entre líneas paralelas separadas 20 cm',5,'var22','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(98,'De pie camina 10 pasos consecutivos hacia delante sobre una línea recta de 2 cm de ancho',5,'var23','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(99,'De pie pasa sobre un palo situado a nivel de sus rodillas, comenzando con el pie derecho',5,'var24','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(100,'De pie pasa sobre un palo situado a nivel de sus rodillas, comenzando con el pie izquierdo',5,'var25','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(101,'De pie corre 4, 5m, se detiene y regresa',5,'var26','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(102,'De pie da una patada a una pelota con el pie derecho',5,'var27','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(103,'De pie da una patada a una pelota con el pie izquierdo',5,'var28','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(104,'De pie salta 30 cm de altura con los dos pies a la vez',5,'var29','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(105,'De pie salta 30 cm hacia delante con los dos pies a la vez',5,'var30','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(106,'De pie sobre el pie derecho salta a la pata coja con el pie derecho 10 veces dentro de un círculo de 60 cm',5,'var31','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(107,'De pie sobre el pie izquierdo salta a la pata coja con el pie izquierdo 10 veces dentro de un círculo de 60 cm',5,'var32','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(108,'De pie agarrado a una barandilla sube 4 escalones alternando los pies agarrado a una barandilla',5,'var33','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(109,'De pie agarrando a una barandilla baja 4 escalones alternando los pies agarrado a una barandilla',5,'var34','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(110,'De pie sube 4 escalones alternando los pies',5,'var35','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(111,'De pie baja 4 escalones alternando los pies',5,'var36','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(112,'De pie sobre un escalón de 15 cm se baja de un salto con los dos pies a la vez',5,'var37','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(113,'Comentarios',5,'comentarios','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(114,'¿Ha sido una evaluación indicativa?',5,'evaluacionIndicativa','com.upsam.hospital.model.beans.GrossMotorFunctionDTO',NULL,NULL),(115,'Cadera Flexión Derecha ROM Activo',6,'var_1_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(116,'Cadera Flexión Izquierda MMT Pasivo',6,'var_1_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(117,'Cadera Flexión Ctrl motor sel.',6,'var_1_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(118,'Cadera Flexión ROM',6,'var_1_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(119,'Cadera Flexión MMT activo',6,'var_1_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(120,'Cadera Flexión Ctrl motor sel. Pasivo',6,'var_1_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(121,'Cadera Extensión Derecha ROM Activo',6,'var_2_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(122,'Cadera Extensión Izquierda MMT Pasivo',6,'var_2_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(123,'Cadera Extensión Ctrl motor sel.',6,'var_2_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(124,'Cadera Extensión ROM',6,'var_2_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(125,'Cadera Extensión MMT activo',6,'var_2_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(126,'Cadera Extensión Ctrl motor sel. Pasivo',6,'var_2_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(127,'Cadera Abducción (cadera flex) Derecha ROM Activo',6,'var_3_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(128,'Cadera Abducción (cadera flex) Izquierda MMT Pasivo',6,'var_3_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(129,'Cadera Abducción (cadera flex) Ctrl motor sel.',6,'var_3_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(130,'Cadera Abducción (cadera flex) ROM',6,'var_3_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(131,'Cadera Abducción (cadera flex) MMT activo',6,'var_3_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(132,'Cadera Abducción (cadera flex) Ctrl motor sel. Pasivo',6,'var_3_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(133,'Cadera Abducción (cadera ext) Derecha ROM Activo',6,'var_4_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(134,'Cadera Abducción (cadera ext) Izquierda MMT Pasivo',6,'var_4_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(135,'Cadera Abducción (cadera ext) Ctrl motor sel.',6,'var_4_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(136,'Cadera Abducción (cadera ext) ROM',6,'var_4_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(137,'Cadera Abducción (cadera ext) MMT activo',6,'var_4_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(138,'Cadera Abducción (cadera ext) Ctrl motor sel. Pasivo',6,'var_4_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(139,'Cadera Rotación Int Derecha ROM Activo',6,'var_5_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(140,'Cadera Rotación Int Izquierda MMT Pasivo',6,'var_5_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(141,'Cadera Rotación Int Ctrl motor sel.',6,'var_5_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(142,'Cadera Rotación Int ROM',6,'var_5_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(143,'Cadera Rotación Int MMT activo',6,'var_5_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(144,'Cadera Rotación Int Ctrl motor sel. Pasivo',6,'var_5_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(145,'Cadera Rotación Ext Derecha ROM Activo',6,'var_6_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(146,'Cadera Rotación Ext Izquierda MMT Pasivo',6,'var_6_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(147,'Cadera Rotación Ext Ctrl motor sel.',6,'var_6_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(148,'Cadera Rotación Ext ROM',6,'var_6_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(149,'Cadera Rotación Ext MMT activo',6,'var_6_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(150,'Cadera Rotación Ext Ctrl motor sel. Pasivo',6,'var_6_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(151,'Rodilla Flexión Derecha ROM Activo',6,'var_7_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(152,'Rodilla Flexión Izquierda MMT Pasivo',6,'var_7_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(153,'Rodilla Flexión Ctrl motor sel.',6,'var_7_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(154,'Rodilla Flexión ROM',6,'var_7_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(155,'Rodilla Flexión MMT activo',6,'var_7_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(156,'Rodilla Flexión Ctrl motor sel. Pasivo',6,'var_7_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(157,'Rodilla Extensión Derecha ROM Activo',6,'var_8_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(158,'Rodilla Extensión Izquierda MMT Pasivo',6,'var_8_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(159,'Rodilla Extensión Ctrl motor sel.',6,'var_8_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(160,'Rodilla Extensión ROM',6,'var_8_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(161,'Rodilla Extensión MMT activo',6,'var_8_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(162,'Rodilla Extensión Ctrl motor sel. Pasivo',6,'var_8_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(163,'Tobillo	Flex plantar Derecha ROM Activo',6,'var_9_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(164,'Tobillo	Flex plantar Izquierda MMT Pasivo',6,'var_9_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(165,'Tobillo	Flex plantar Ctrl motor sel.',6,'var_9_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(166,'Tobillo	Flex plantar ROM',6,'var_9_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(167,'Tobillo	Flex plantar MMT activo',6,'var_9_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(168,'Tobillo	Flex plantar Ctrl motor sel. Pasivo',6,'var_9_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(169,'Tobillo	Flex dorsal (rodilla ext) Derecha ROM Activo',6,'var_10_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(170,'Tobillo	Flex dorsal (rodilla ext) Izquierda MMT Pasivo',6,'var_10_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(171,'Tobillo	Flex dorsal (rodilla ext) Ctrl motor sel.',6,'var_10_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(172,'Tobillo	Flex dorsal (rodilla ext) ROM',6,'var_10_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(173,'Tobillo	Flex dorsal (rodilla ext) MMT activo',6,'var_10_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(174,'Tobillo	Flex dorsal (rodilla ext) Ctrl motor sel. Pasivo',6,'var_10_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(175,'Tobillo	Flex dorsal (rodilla 90º) Derecha ROM Activo',6,'var_11_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(176,'Tobillo	Flex dorsal (rodilla 90º) Izquierda MMT Pasivo',6,'var_11_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(177,'Tobillo	Flex dorsal (rodilla 90º) Ctrl motor sel.',6,'var_11_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(178,'Tobillo	Flex dorsal (rodilla 90º) ROM',6,'var_11_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(179,'Tobillo	Flex dorsal (rodilla 90º) MMT activo',6,'var_11_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(180,'Tobillo	Flex dorsal (rodilla 90º) Ctrl motor sel. Pasivo',6,'var_11_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(181,'Tobillo	Inversión Derecha ROM Activo',6,'var_12_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(182,'Tobillo	Inversión Izquierda MMT Pasivo',6,'var_12_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(183,'Tobillo	Inversión Ctrl motor sel.',6,'var_12_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(184,'Tobillo	Inversión ROM',6,'var_12_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(185,'Tobillo	Inversión MMT activo',6,'var_12_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(186,'Tobillo	Inversión Ctrl motor sel. Pasivo',6,'var_12_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(187,'Tobillo	Eversión Derecha ROM Activo',6,'var_13_1','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(188,'Tobillo	Eversión Izquierda MMT Pasivo',6,'var_13_2','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(189,'Tobillo	Eversión Ctrl motor sel.',6,'var_13_3','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(190,'Tobillo	Eversión ROM',6,'var_13_4','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(191,'Tobillo	Eversión MMT activo',6,'var_13_5','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL),(192,'Tobillo	Eversión Ctrl motor sel. Pasivo',6,'var_13_6','com.upsam.hospital.model.beans.ValoracionArticularMuscular',NULL,NULL);
/*!40000 ALTER TABLE `campo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campo_info`
--

DROP TABLE IF EXISTS `campo_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campo_info` (
  `ID_CAMPO_INFO` int(11) NOT NULL AUTO_INCREMENT,
  `OPERACION` int(11) DEFAULT NULL,
  `VALOR` double DEFAULT NULL,
  `ID_CAMPO` int(11) DEFAULT NULL,
  `ID_REGLA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CAMPO_INFO`),
  KEY `FKE771BC5F69E53081` (`ID_REGLA`),
  KEY `FKE771BC5F683AFA8B` (`ID_CAMPO`),
  CONSTRAINT `FKE771BC5F683AFA8B` FOREIGN KEY (`ID_CAMPO`) REFERENCES `campo` (`ID_CAMPO`),
  CONSTRAINT `FKE771BC5F69E53081` FOREIGN KEY (`ID_REGLA`) REFERENCES `regla` (`ID_REGLA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `campo_rellenado`
--

DROP TABLE IF EXISTS `campo_rellenado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campo_rellenado` (
  `ID_CAMPO_RELLENADO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CAMPO` int(11) DEFAULT NULL,
  `ID_REGLA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CAMPO_RELLENADO`),
  KEY `FK54151B1F69E53081` (`ID_REGLA`),
  KEY `FK54151B1F683AFA8B` (`ID_CAMPO`),
  CONSTRAINT `FK54151B1F683AFA8B` FOREIGN KEY (`ID_CAMPO`) REFERENCES `campo` (`ID_CAMPO`),
  CONSTRAINT `FK54151B1F69E53081` FOREIGN KEY (`ID_REGLA`) REFERENCES `regla` (`ID_REGLA`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `campo_sugerido`
--

DROP TABLE IF EXISTS `campo_sugerido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campo_sugerido` (
  `ID_CAMPO_SUGERIDO` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CAMPO` int(11) DEFAULT NULL,
  `ID_REGLA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CAMPO_SUGERIDO`),
  KEY `FKA7D422F369E53081` (`ID_REGLA`),
  KEY `FKA7D422F3683AFA8B` (`ID_CAMPO`),
  CONSTRAINT `FKA7D422F3683AFA8B` FOREIGN KEY (`ID_CAMPO`) REFERENCES `campo` (`ID_CAMPO`),
  CONSTRAINT `FKA7D422F369E53081` FOREIGN KEY (`ID_REGLA`) REFERENCES `regla` (`ID_REGLA`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exploracion`
--

DROP TABLE IF EXISTS `exploracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exploracion` (
  `ID_EXPLORACION` int(11) NOT NULL AUTO_INCREMENT,
  `CONTROL_MOTOR_SELECTIVO` varchar(255) DEFAULT NULL,
  `ID_PACIENTE` int(11) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `ID_USUARIO` int(11) DEFAULT NULL,
  `EVALUACION_MUSCULAR` int(11) DEFAULT NULL,
  `LONGITUD_MIEMBRO_DERECHO` int(11) DEFAULT NULL,
  `LONGITUD_MIEMBRO_IZQUIERDO` int(11) DEFAULT NULL,
  `PUNTUACION_500_METROS` int(11) DEFAULT NULL,
  `PUNTUACION_50_METROS` int(11) DEFAULT NULL,
  `PUNTUACION_5_METROS` int(11) DEFAULT NULL,
  `ANALISIS_OBSERVACIONAL_MARCHA` int(11) DEFAULT NULL,
  `CADERA_FLEXION_DERECHA` int(11) DEFAULT NULL,
  `CADERA_FLEXION_IZQUIERDA` int(11) DEFAULT NULL,
  `CADERA_INFLEXION_DERECHA` int(11) DEFAULT NULL,
  `CADERA_INFLEXION_IZQUIERDA` int(11) DEFAULT NULL,
  `RODILLA_FLEXION_DERECHA` int(11) DEFAULT NULL,
  `RODILLA_FLEXION_IZQUIERDA` int(11) DEFAULT NULL,
  `RODILLA_INFLEXION_DERECHA` int(11) DEFAULT NULL,
  `RODILLA_INFLEXION_IZQUIERDA` int(11) DEFAULT NULL,
  `TOBILLO_FLEXION_DERECHA` int(11) DEFAULT NULL,
  `TOBILLO_FLEXION_IZQUIERDA` int(11) DEFAULT NULL,
  `TOBILLO_INFLEXION_DERECHA` int(11) DEFAULT NULL,
  `TOBILLO_INFLEXION_IZQUIERDA` int(11) DEFAULT NULL,
  `FECHA_ACTUALIZACION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_EXPLORACION`),
  KEY `FK29CC47B4D15C8E13` (`ID_PACIENTE`),
  KEY `FK29CC47B4F409550B` (`ID_USUARIO`),
  CONSTRAINT `FK29CC47B4D15C8E13` FOREIGN KEY (`ID_PACIENTE`) REFERENCES `paciente` (`ID_PACIENTE`),
  CONSTRAINT `FK29CC47B4F409550B` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fichero_emt`
--

DROP TABLE IF EXISTS `fichero_emt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fichero_emt` (
  `ID_FICHERO_EMT` int(11) NOT NULL AUTO_INCREMENT,
  `CICLOS` int(11) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `TIPO_MEDIDA` int(11) DEFAULT NULL,
  `UNIDAD_MEDIDA` int(11) DEFAULT NULL,
  `ID_EXPLORACION` int(11) DEFAULT NULL,
  `ID_TABLA_DATOS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_FICHERO_EMT`),
  KEY `FK3738A6C72FCD3140` (`ID_TABLA_DATOS`),
  KEY `FK3738A6C7670BE6D7` (`ID_EXPLORACION`),
  CONSTRAINT `FK3738A6C72FCD3140` FOREIGN KEY (`ID_TABLA_DATOS`) REFERENCES `tabla_datos` (`ID_TABLA_DATOS`),
  CONSTRAINT `FK3738A6C7670BE6D7` FOREIGN KEY (`ID_EXPLORACION`) REFERENCES `exploracion` (`ID_EXPLORACION`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `fichero_mdx`
--

DROP TABLE IF EXISTS `fichero_mdx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fichero_mdx` (
  `ID_FICHERO_MDX` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` bigint(20) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `ID_PACIENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_FICHERO_MDX`),
  KEY `FK3738C3BCD15C8E13` (`ID_PACIENTE`),
  CONSTRAINT `FK3738C3BCD15C8E13` FOREIGN KEY (`ID_PACIENTE`) REFERENCES `paciente` (`ID_PACIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



DROP TABLE IF EXISTS `gross_motor_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gross_motor_function` (
  `ID_GROSS_MOTOR_FUNCTION` int(11) NOT NULL AUTO_INCREMENT,
  `COMENTARIOS` varchar(255) DEFAULT NULL,
  `EVALUACION_INDICATIVA` bit(1) DEFAULT NULL,
  `VAR_1` int(11) DEFAULT NULL,
  `VAR_10` int(11) DEFAULT NULL,
  `VAR_11` int(11) DEFAULT NULL,
  `VAR_12` int(11) DEFAULT NULL,
  `VAR_13` int(11) DEFAULT NULL,
  `VAR_14` int(11) DEFAULT NULL,
  `VAR_15` int(11) DEFAULT NULL,
  `VAR_16` int(11) DEFAULT NULL,
  `VAR_17` int(11) DEFAULT NULL,
  `VAR_18` int(11) DEFAULT NULL,
  `VAR_19` int(11) DEFAULT NULL,
  `VAR_2` int(11) DEFAULT NULL,
  `VAR_20` int(11) DEFAULT NULL,
  `VAR_21` int(11) DEFAULT NULL,
  `VAR_22` int(11) DEFAULT NULL,
  `VAR_23` int(11) DEFAULT NULL,
  `VAR_24` int(11) DEFAULT NULL,
  `VAR_25` int(11) DEFAULT NULL,
  `VAR_26` int(11) DEFAULT NULL,
  `VAR_27` int(11) DEFAULT NULL,
  `VAR_28` int(11) DEFAULT NULL,
  `VAR_29` int(11) DEFAULT NULL,
  `VAR_3` int(11) DEFAULT NULL,
  `VAR_30` int(11) DEFAULT NULL,
  `VAR_31` int(11) DEFAULT NULL,
  `VAR_32` int(11) DEFAULT NULL,
  `VAR_33` int(11) DEFAULT NULL,
  `VAR_34` int(11) DEFAULT NULL,
  `VAR_35` int(11) DEFAULT NULL,
  `VAR_36` int(11) DEFAULT NULL,
  `VAR_37` int(11) DEFAULT NULL,
  `VAR_4` int(11) DEFAULT NULL,
  `VAR_5` int(11) DEFAULT NULL,
  `VAR_6` int(11) DEFAULT NULL,
  `VAR_7` int(11) DEFAULT NULL,
  `VAR_8` int(11) DEFAULT NULL,
  `VAR_9` int(11) DEFAULT NULL,
  `ID_EXPLORACION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_GROSS_MOTOR_FUNCTION`),
  UNIQUE KEY `ID_EXPLORACION` (`ID_EXPLORACION`),
  KEY `FK3227C7FD670BE6D7` (`ID_EXPLORACION`),
  CONSTRAINT `FK3227C7FD670BE6D7` FOREIGN KEY (`ID_EXPLORACION`) REFERENCES `exploracion` (`ID_EXPLORACION`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `ID_PACIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `APELLIDOS` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `CURSO` varchar(255) DEFAULT NULL,
  `ESCOLARIZACION` int(11) DEFAULT NULL,
  `FECHA_NACIMIENTO` datetime DEFAULT NULL,
  `NUMERO_IDENTIFICACION` varchar(255) DEFAULT NULL,
  `SEXO` int(11) DEFAULT NULL,
  `FECHA_ULTIMA_EVALUACION` datetime DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  `EXAMINADOR` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_PACIENTE`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  UNIQUE KEY `NUMERO_IDENTIFICACION` (`NUMERO_IDENTIFICACION`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pagina`
--

DROP TABLE IF EXISTS `pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagina` (
  `ID_PAGINA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `INFO_PAGE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID_PAGINA`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagina`
--

LOCK TABLES `pagina` WRITE;
/*!40000 ALTER TABLE `pagina` DISABLE KEYS */;
INSERT INTO `pagina` VALUES (1,'Paciente',''),(2,'Exploración',''),(3,'Antecedentes Personales',''),(4,'Antecedentes Relacionados con PCI',''),(5,'Gross Motor Function',''),(6,'Valoración Articular Muscular','');
/*!40000 ALTER TABLE `pagina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `point`
--

DROP TABLE IF EXISTS `point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `point` (
  `ID_POINT` int(11) NOT NULL AUTO_INCREMENT,
  `COORD` varchar(255) DEFAULT NULL,
  `ID_ANGLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_POINT`),
  KEY `FK48C5D70680E4015` (`ID_ANGLE`),
  CONSTRAINT `FK48C5D70680E4015` FOREIGN KEY (`ID_ANGLE`) REFERENCES `angle` (`ID_ANGLE`)
) ENGINE=InnoDB AUTO_INCREMENT=22221 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `regla`
--

DROP TABLE IF EXISTS `regla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regla` (
  `ID_REGLA` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `MENSAJE` varchar(255) DEFAULT NULL,
  `TITULO` varchar(255) DEFAULT NULL,
  `TIPO_REGLA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_REGLA`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tabla_datos`
--

DROP TABLE IF EXISTS `tabla_datos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabla_datos` (
  `ID_TABLA_DATOS` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FICHERO_EMT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_TABLA_DATOS`),
  KEY `FK69CCEC67ABE5DA2` (`ID_FICHERO_EMT`),
  CONSTRAINT `FK69CCEC67ABE5DA2` FOREIGN KEY (`ID_FICHERO_EMT`) REFERENCES `fichero_emt` (`ID_FICHERO_EMT`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(200) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `rol_id` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `generate_token` datetime DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Pérez Alonso','dd@dd.com','Pedro','698d51a19d8a121ce581499d7b701668',0,'d','2014-04-09 20:59:06','c6a3c'),(2,'Gutierrez Maroto','n@at.com','Nuria','698d51a19d8a121ce581499d7b701668',1,'n','2014-04-27 17:49:30','a0323'),(3,'Murcia Cayo','murcia@gmail.com','Alfonso','0cc175b9c0f1b6a831c399e269772661',0,'a',NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoracion_articular_muscular`
--

DROP TABLE IF EXISTS `valoracion_articular_muscular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valoracion_articular_muscular` (
  `ID_VALORACION_ARTICULAR_MUSCULAR` int(11) NOT NULL AUTO_INCREMENT,
  `VAR_10_1` varchar(255) DEFAULT NULL,
  `VAR_10_2` varchar(255) DEFAULT NULL,
  `VAR_10_3` varchar(255) DEFAULT NULL,
  `VAR_10_4` varchar(255) DEFAULT NULL,
  `VAR_10_5` varchar(255) DEFAULT NULL,
  `VAR_10_6` varchar(255) DEFAULT NULL,
  `VAR_11_1` varchar(255) DEFAULT NULL,
  `VAR_11_2` varchar(255) DEFAULT NULL,
  `VAR_11_3` varchar(255) DEFAULT NULL,
  `VAR_11_4` varchar(255) DEFAULT NULL,
  `VAR_11_5` varchar(255) DEFAULT NULL,
  `VAR_11_6` varchar(255) DEFAULT NULL,
  `VAR_12_1` varchar(255) DEFAULT NULL,
  `VAR_12_2` varchar(255) DEFAULT NULL,
  `VAR_12_3` varchar(255) DEFAULT NULL,
  `VAR_12_4` varchar(255) DEFAULT NULL,
  `VAR_12_5` varchar(255) DEFAULT NULL,
  `VAR_12_6` varchar(255) DEFAULT NULL,
  `VAR_13_1` varchar(255) DEFAULT NULL,
  `VAR_13_2` varchar(255) DEFAULT NULL,
  `VAR_13_3` varchar(255) DEFAULT NULL,
  `VAR_13_4` varchar(255) DEFAULT NULL,
  `VAR_13_5` varchar(255) DEFAULT NULL,
  `VAR_13_6` varchar(255) DEFAULT NULL,
  `VAR_1_1` varchar(255) DEFAULT NULL,
  `VAR_1_2` varchar(255) DEFAULT NULL,
  `VAR_1_3` varchar(255) DEFAULT NULL,
  `VAR_1_4` varchar(255) DEFAULT NULL,
  `VAR_1_5` varchar(255) DEFAULT NULL,
  `VAR_1_6` varchar(255) DEFAULT NULL,
  `var_2_1` varchar(255) DEFAULT NULL,
  `VAR_2_2` varchar(255) DEFAULT NULL,
  `VAR_2_3` varchar(255) DEFAULT NULL,
  `VAR_2_4` varchar(255) DEFAULT NULL,
  `VAR_2_5` varchar(255) DEFAULT NULL,
  `VAR_2_6` varchar(255) DEFAULT NULL,
  `VAR_3_1` varchar(255) DEFAULT NULL,
  `VAR_3_2` varchar(255) DEFAULT NULL,
  `VAR_3_3` varchar(255) DEFAULT NULL,
  `VAR_3_4` varchar(255) DEFAULT NULL,
  `VAR_3_5` varchar(255) DEFAULT NULL,
  `VAR_3_6` varchar(255) DEFAULT NULL,
  `VAR_4_1` varchar(255) DEFAULT NULL,
  `VAR_4_2` varchar(255) DEFAULT NULL,
  `VAR_4_3` varchar(255) DEFAULT NULL,
  `VAR_4_4` varchar(255) DEFAULT NULL,
  `VAR_4_5` varchar(255) DEFAULT NULL,
  `VAR_4_6` varchar(255) DEFAULT NULL,
  `VAR_5_1` varchar(255) DEFAULT NULL,
  `VAR_5_2` varchar(255) DEFAULT NULL,
  `VAR_5_3` varchar(255) DEFAULT NULL,
  `VAR_5_4` varchar(255) DEFAULT NULL,
  `VAR_5_5` varchar(255) DEFAULT NULL,
  `VAR_5_6` varchar(255) DEFAULT NULL,
  `VAR_6_1` varchar(255) DEFAULT NULL,
  `VAR_6_2` varchar(255) DEFAULT NULL,
  `VAR_6_3` varchar(255) DEFAULT NULL,
  `VAR_6_4` varchar(255) DEFAULT NULL,
  `VAR_6_5` varchar(255) DEFAULT NULL,
  `VAR_6_6` varchar(255) DEFAULT NULL,
  `VAR_7_1` varchar(255) DEFAULT NULL,
  `VAR_7_2` varchar(255) DEFAULT NULL,
  `VAR_7_3` varchar(255) DEFAULT NULL,
  `VAR_7_4` varchar(255) DEFAULT NULL,
  `VAR_7_5` varchar(255) DEFAULT NULL,
  `VAR_7_6` varchar(255) DEFAULT NULL,
  `VAR_8_1` varchar(255) DEFAULT NULL,
  `VAR_8_2` varchar(255) DEFAULT NULL,
  `VAR_8_3` varchar(255) DEFAULT NULL,
  `VAR_8_4` varchar(255) DEFAULT NULL,
  `VAR_8_5` varchar(255) DEFAULT NULL,
  `VAR_8_6` varchar(255) DEFAULT NULL,
  `VAR_9_1` varchar(255) DEFAULT NULL,
  `VAR_9_2` varchar(255) DEFAULT NULL,
  `VAR_9_3` varchar(255) DEFAULT NULL,
  `VAR_9_4` varchar(255) DEFAULT NULL,
  `VAR_9_5` varchar(255) DEFAULT NULL,
  `VAR_9_6` varchar(255) DEFAULT NULL,
  `ID_EXPLORACION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_VALORACION_ARTICULAR_MUSCULAR`),
  UNIQUE KEY `ID_EXPLORACION` (`ID_EXPLORACION`),
  KEY `FKED92ADD7670BE6D7` (`ID_EXPLORACION`),
  CONSTRAINT `FKED92ADD7670BE6D7` FOREIGN KEY (`ID_EXPLORACION`) REFERENCES `exploracion` (`ID_EXPLORACION`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `ID_VIDEO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` longtext,
  `DURACION` varchar(20) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `ID_EXPLORACION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_VIDEO`),
  KEY `FK4DE1C5B670BE6D7` (`ID_EXPLORACION`),
  CONSTRAINT `FK4DE1C5B670BE6D7` FOREIGN KEY (`ID_EXPLORACION`) REFERENCES `exploracion` (`ID_EXPLORACION`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-08 21:16:05
