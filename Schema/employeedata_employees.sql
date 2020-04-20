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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `idEmployees` int NOT NULL,
  `password` varchar(45) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Mobile Number` varchar(45) DEFAULT NULL,
  `Role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEmployees`),
  UNIQUE KEY `idEmployees_UNIQUE` (`idEmployees`),
  UNIQUE KEY `Mobile Number_UNIQUE` (`Mobile Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
<<<<<<< HEAD
INSERT INTO `employees` VALUES (1001,'pass','Edwin Shattock','10 Marstons road','07498661115','Appointments Manager'),(1002,'pass','Jason Statham','19 Whiteladies Road','09081174123','Consultant Clerk'),(1003,'pass','Lisa Kudrick','23 Clifton Village','08023116456',''),(1004,'pass','Margot Robbie','13 Cousins way','07923434235','Consultant'),(1005,'pass','Diane Nguyen','32 Dibden Close','08030060079',''),(1006,'pass','Zachary Willis','419 Ikorodou-Crescent Street','09058042037','Consultant'),(1007,'pass','Jesus Navas','135 College Road','07432163634','Consultant Clerk'),(1008,'pass','Cheryl Cole','13 Coulston Road','07137857642','Senior Manager'),(1009,'pass','Chloe Moretz','22b Stokes Lane','08520034561','Financial Clerk'),(1010,'pass','Viktor Vayghn','34 Westerleigh Road','09378234538',NULL),(1011,'pass','Michael Dumile','9 Robertson Road','07023111465',NULL),(1012,'pass','Natalie Klepacova','15 Dowend Road','09060360426','Financial Clerk');
=======
INSERT INTO `employees` VALUES (1001,'pass','Edwin Shattock','10 Marstons road','07498661115','AP'),(1002,'pass','Jason Statham','19 Whiteladies Road','09081174123','FC'),(1003,'pass','Lisa Kudrick','23 Clifton Village','08023116456','GP'),(1004,'pass','Margot Robbie','13 Cousins way','07923434235','CS'),(1005,'pass','Diane Nguyen','32 Dibden Close','08030060079','GP'),(1006,'pass','Zachary Willis','419 Ikorodou-Crescent Street','09058042037','FC'),(1007,'pass','Jesus Navas','135 College Road','07432163634','CS'),(1008,'pass','Cheryl Cole','13 Coulston Road','07137857642','CSC'),(1009,'pass','Chloe Moretz','22b Stokes Lane','08520034561','GP'),(1010,'pass','Viktor Vayghn','34 Westerleigh Road','09378234538','CSC'),(1011,'pass','Michael Dumile','9 Robertson Road','07023111465','GP'),(1012,'pass','Natalie Klepacova','15 Dowend Road','09060360426','SM');
>>>>>>> a78b64d9d9275c40f4c5644cd7c541253b0494df
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-20 13:41:50
