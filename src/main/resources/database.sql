-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: journaldb
-- ------------------------------------------------------
-- Server version	5.7.20-log

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

DROP TABLE IF EXISTS `schooldays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schooldays` (
  `idschoolday` int(11) NOT NULL AUTO_INCREMENT,
  `day` varchar(20) DEFAULT NULL,
  `class` int(11) DEFAULT NULL,
  PRIMARY KEY (`idschoolday`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `idsubject` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(40) DEFAULT NULL,
  `homework` varchar(100) DEFAULT NULL,
  `mark` int(11) DEFAULT NULL,
  `idschoolday` int(11) DEFAULT NULL,
  `numlesson` int(11) DEFAULT NULL,
  PRIMARY KEY (`idsubject`),
  KEY `fksd_idx` (`idschoolday`),
  CONSTRAINT `fksd` FOREIGN KEY (`idschoolday`) REFERENCES `schooldays` (`idschoolday`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `login` varchar(20) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `login` varchar(20) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schooldays`
--

LOCK TABLES `schooldays` WRITE;
/*!40000 ALTER TABLE `schooldays` DISABLE KEYS */;
INSERT INTO `schooldays` VALUES (1,'Понедельник',1),(4,'Суббота',11),(6,'Пятница',1),(7,'Четверг',4),(9,'Среда',10),(17,'Суббота',8),(18,'Понедельник',11),(19,'Вторник',1);
/*!40000 ALTER TABLE `schooldays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES ('333',1,'33'),('hi',3,'hi'),('pepe',4,'123'),('hdf',5,'hdhdjv'),('5555',6,'11111'),('zzzz',7,'zzzz');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (6,'Русский язык','ррр',2,1,2),(9,'Литература','ллл',5,1,3),(38,'Литература',' vvcvcb',NULL,9,1),(53,'Физика','ввв',NULL,1,5),(54,'Математика','ттт',NULL,1,6),(84,'Математика','1111111111111111',1,7,1),(85,'Математика','111111111111',5,7,2),(86,'Математика','1111111111111111',4,7,3),(87,'Математика','11111111111',3,7,4),(88,'Математика','11111111111111111',2,7,5),(89,'Математика','111111111111111',5,7,6),(102,'Русский язык','лал',NULL,17,1),(103,'Математика','Математика',NULL,17,2),(104,'Литература','лал',NULL,17,3),(105,'Математика','лал',NULL,17,4),(106,'Химия','лал',NULL,17,5),(107,'Химия','лал',NULL,17,6),(108,'Математика','222222222222',NULL,18,1),(109,'Математика','2222222222',NULL,18,2),(110,'Математика','222222222',NULL,18,3),(111,'Математика','222222222',NULL,18,4),(112,'Математика','222222222',NULL,18,5),(113,'Математика','22222222222222',NULL,18,6),(114,'Русский язык','1',5,19,1),(115,'Литература','2',4,19,2),(116,'Русский язык','4',NULL,19,3),(117,'Химия','5',NULL,19,4),(118,'Физика','6',NULL,19,5),(119,'Литература','7',NULL,19,6),(120,'История','ппп',5,1,1),(121,'Химия','хххх',5,1,4);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES ('3333333333333333',4,'33333333333333333'),('dedpihto',14,'dedpihto'),('1',15,'1');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-09 22:03:52

