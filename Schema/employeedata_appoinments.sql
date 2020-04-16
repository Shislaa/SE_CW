-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: employeedata
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appoinments`
--

DROP TABLE IF EXISTS `appoinments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appoinments` (
  `idappoinments` int NOT NULL,
  `Time` datetime DEFAULT NULL,
  `idEmployees` varchar(45) NOT NULL,
  `idPatients` varchar(45) NOT NULL,
  `GP name` varchar(45) DEFAULT NULL,
  `patients name` varchar(45) DEFAULT NULL,
  `patients Insurrance Number` varchar (45) DEFAULT NULL,
  PRIMARY KEY (`idappoinments`,`idEmployees`,`idPatients`),
  UNIQUE KEY `idappoinments_UNIQUE` (`idappoinments`),
  UNIQUE KEY `idEmployees_UNIQUE` (`idEmployees`),
  UNIQUE KEY `idPatient_UNIQUE` (`idPatients`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appoinments`
--

LOCK TABLES `appoinments` WRITE;
/*!40000 ALTER TABLE `appoinments` DISABLE KEYS */;
INSERT INTO `appoinments` VALUES (100,'2020-04-16 03:00:00','1005','2','Diane Nguyen','Sage Elsesser',null),(200,'2020-04-23 02:15:00','1011','4','Michael Dumile','Similola Adepoju',null);
/*!40000 ALTER TABLE `appoinments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-15 12:25:42
