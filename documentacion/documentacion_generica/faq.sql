CREATE DATABASE  IF NOT EXISTS `db_hospital` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_hospital`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: db_hospital
-- ------------------------------------------------------
-- Server version	5.5.24

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
-- Table structure for table `pagina`
--

DROP TABLE IF EXISTS `pagina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagina` (
  `ID_PAGINA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_PAGINA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagina`
--

LOCK TABLES `pagina` WRITE;
/*!40000 ALTER TABLE `pagina` DISABLE KEYS */;
INSERT INTO `pagina` VALUES (1,'Antecedentes Personales'),(2,'Exploracion'),(3,'Paciente');
/*!40000 ALTER TABLE `pagina` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`ID_CAMPO`),
  KEY `FK3CEDDEECB7CAE7D` (`ID_PAGINA`),
  CONSTRAINT `FK3CEDDEECB7CAE7D` FOREIGN KEY (`ID_PAGINA`) REFERENCES `pagina` (`ID_PAGINA`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campo`
--

LOCK TABLES `campo` WRITE;
/*!40000 ALTER TABLE `campo` DISABLE KEYS */;
INSERT INTO `campo` VALUES (1,'Epilepsia',1,'epilepsia','com.upsam.hospital.model.beans.AntecedentesPersonales'),(2,'Tipo Epilepsia',1,'tipoEpilepsia','com.upsam.hospital.model.beans.AntecedentesPersonales'),(3,'Cadera Flexion Izquierda',2,'caderaFlexionIzquierda','com.upsam.hospital.model.beans.Exploracion'),(4,'Cadera Inflexion Derecha',2,'caderaInflexionDerecha','com.upsam.hospital.model.beans.Exploracion'),(5,'Cadera Inflexion Izquierda',2,'caderaInflexionIzquierda','com.upsam.hospital.model.beans.Exploracion'),(6,'Apellidos',3,'apellidos','com.upsam.hospital.model.beans.Paciente'),(7,'Curso',3,'curso','com.upsam.hospital.model.beans.Paciente'),(8,'Examinador',3,'examinador','com.upsam.hospital.model.beans.Paciente');
/*!40000 ALTER TABLE `campo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-14 23:33:38
