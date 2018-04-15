CREATE DATABASE  IF NOT EXISTS `internation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `internation`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: internation
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `videoname` text,
  `content` text,
  `timepause` time DEFAULT NULL,
  `image` longblob,
  `link` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'Learn English - Greetings in English','Learn English - Greetings in English, how to Answer the Question \"How are you?\"',NULL,NULL,'https://www.youtube.com/watch?https://www.youtube.com/watch?v=dmOKZLeFKCM&list=PL4C632FCF5FCB9C21'),(2,'Learn English - Asking About Occupations, What is your Job?','Learn English - Asking About Occupations, What is your Job?',NULL,NULL,'https://www.youtube.com/watch?v=GnQ2iCIpOmE&list=PL4C632FCF5FCB9C21&index=2'),(3,'Learn English - Asking About Hobbies, What do you do for fun?','Learn English - Asking About Hobbies, What do you do for fun?',NULL,NULL,'https://www.youtube.com/watch?v=nMFrC3UGtek&index=3&list=PL4C632FCF5FCB9C21'),(4,'Learn English - Asking \'Where are you from?\'','Learn English - Asking \'Where are you from?\'',NULL,NULL,'https://www.youtube.com/watch?v=gE9XU5YE9Dk&index=4&list=PL4C632FCF5FCB9C21');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 19:40:03
