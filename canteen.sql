-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: canteendb
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orderdetails` (
  `idOrderDetails` int(11) NOT NULL AUTO_INCREMENT,
  `idOrderTransaction` int(11) DEFAULT NULL,
  `idProductMaster` int(11) DEFAULT NULL,
  `OrderQuantity` int(11) DEFAULT NULL,
  `OrderPrice` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`idOrderDetails`),
  KEY `idProductMaster_idx` (`idProductMaster`),
  KEY `idOrderTransaction_idx` (`idOrderTransaction`),
  CONSTRAINT `idOrderTransaction` FOREIGN KEY (`idOrderTransaction`) REFERENCES `ordertransaction` (`idordertransaction`),
  CONSTRAINT `idProductMasterFK` FOREIGN KEY (`idProductMaster`) REFERENCES `productmaster` (`idproductmaster`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordertransaction`
--

DROP TABLE IF EXISTS `ordertransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ordertransaction` (
  `idOrderTransaction` int(11) NOT NULL AUTO_INCREMENT,
  `idUserMaster` int(11) DEFAULT NULL,
  `OrderDate` datetime DEFAULT NULL,
  `DeliverToTable` int(11) DEFAULT NULL,
  `DeliveredStatus` tinyint(4) DEFAULT NULL,
  `DeliverToFloor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrderTransaction`),
  KEY `idUserMaster_idx` (`idUserMaster`),
  CONSTRAINT `idUserMasterFK` FOREIGN KEY (`idUserMaster`) REFERENCES `usermaster` (`idusermaster`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordertransaction`
--

LOCK TABLES `ordertransaction` WRITE;
/*!40000 ALTER TABLE `ordertransaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordertransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymenttransaction`
--

DROP TABLE IF EXISTS `paymenttransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paymenttransaction` (
  `idPaymentTransaction` int(11) NOT NULL AUTO_INCREMENT,
  `idUserMaster` int(11) DEFAULT NULL,
  `Amount` decimal(10,0) DEFAULT NULL,
  `PaymentDate` datetime DEFAULT NULL,
  `PaymentTransactionRemarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idPaymentTransaction`),
  KEY `idUserMaster_idx` (`idUserMaster`),
  CONSTRAINT `idUserMaster` FOREIGN KEY (`idUserMaster`) REFERENCES `usermaster` (`idusermaster`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymenttransaction`
--

LOCK TABLES `paymenttransaction` WRITE;
/*!40000 ALTER TABLE `paymenttransaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymenttransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productlist`
--

DROP TABLE IF EXISTS `productlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productlist` (
  `idTransaction` int(11) DEFAULT NULL,
  `ProductId` int(11) DEFAULT NULL,
  `OrderQty` int(11) DEFAULT NULL,
  `OrderPric` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productlist`
--

LOCK TABLES `productlist` WRITE;
/*!40000 ALTER TABLE `productlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `productlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productmaster`
--

DROP TABLE IF EXISTS `productmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productmaster` (
  `idProductMaster` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(45) DEFAULT NULL,
  `ProductPrice` decimal(10,0) DEFAULT NULL,
  `IsActive` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idProductMaster`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmaster`
--

LOCK TABLES `productmaster` WRITE;
/*!40000 ALTER TABLE `productmaster` DISABLE KEYS */;
INSERT INTO `productmaster` VALUES (1,'Tea',10,1),(2,'Coffee',20,1),(3,'Vada-Paav',15,1),(4,'Roti-Subji',40,1),(5,'Noodles',35,1),(6,'Fried Rice',45,1),(7,'Sandwich',25,1),(8,'Bread-Pakoda',20,1),(11,'Pani Puri',45,1),(12,'Sev Puri',45,1);
/*!40000 ALTER TABLE `productmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todaysmenu`
--

DROP TABLE IF EXISTS `todaysmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `todaysmenu` (
  `idTodaysMenu` int(11) NOT NULL,
  `idProductMaster` int(11) DEFAULT NULL,
  `MenuDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idTodaysMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todaysmenu`
--

LOCK TABLES `todaysmenu` WRITE;
/*!40000 ALTER TABLE `todaysmenu` DISABLE KEYS */;
INSERT INTO `todaysmenu` VALUES (11,45,'2018-09-29 09:52:41'),(12,45,'2018-09-29 09:58:42');
/*!40000 ALTER TABLE `todaysmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usermaster` (
  `idUserMaster` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `MiddleName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `FloorNumber` int(11) DEFAULT NULL,
  `TableNumber` varchar(15) DEFAULT NULL,
  `idUserTypeMaster` int(11) DEFAULT NULL,
  `UserName` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUserMaster`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`),
  KEY `idUserTypeMaster_idx` (`idUserTypeMaster`),
  CONSTRAINT `idUserTypeMaster` FOREIGN KEY (`idUserTypeMaster`) REFERENCES `usertypemaster` (`idusertypemaster`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (1,'Apurva','A','A',2,'5',2,'Apurva','Apurva'),(2,'Bilva','B','B',3,'6',1,'Bilva','Bilva');
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertypemaster`
--

DROP TABLE IF EXISTS `usertypemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usertypemaster` (
  `idUserTypeMaster` int(11) NOT NULL AUTO_INCREMENT,
  `UserTypeName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUserTypeMaster`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertypemaster`
--

LOCK TABLES `usertypemaster` WRITE;
/*!40000 ALTER TABLE `usertypemaster` DISABLE KEYS */;
INSERT INTO `usertypemaster` VALUES (1,'Admin'),(2,'Customer');
/*!40000 ALTER TABLE `usertypemaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-11 18:46:39
