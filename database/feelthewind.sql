-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: feelthewind
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `action_`
--

DROP TABLE IF EXISTS `action_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `action_` (
  `actionid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `actionname` varchar(20) DEFAULT NULL,
  `actiontime` varchar(20) DEFAULT NULL,
  `creditchange` int(11) DEFAULT NULL,
  `actiondetail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`actionid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_`
--

LOCK TABLES `action_` WRITE;
/*!40000 ALTER TABLE `action_` DISABLE KEYS */;
INSERT INTO `action_` VALUES (5,'admin','lunch','2020-04-29 01:19:19',1,''),(6,'qindan','lunch','2020-04-29 03:54:43',1,''),(7,'qindan','lunch','2020-04-29 03:56:42',1,''),(8,'qindan','lunch','2020-04-29 03:59:18',1,''),(9,'qindan','supper','2020-04-29 04:05:38',1,''),(10,'qindan','supper','2020-04-29 04:08:12',1,''),(11,'qindan','supper','2020-04-29 04:10:28',1,''),(12,'admin','supper','2020-04-29 04:25:59',1,''),(13,'qindan','supper','2020-04-29 05:41:44',1,''),(14,'qindan','supper','2020-04-29 05:49:37',1,''),(15,'qindan','sleep','2020-04-29 05:49:39',-1,''),(16,'qindan','getup','2020-04-29 05:49:40',-1,''),(17,'qindan','supper','2020-04-29 05:59:00',1,''),(18,'qindan','sleep','2020-04-29 05:59:08',-1,''),(19,'qindan','supper','2020-04-29 05:59:10',1,''),(20,'qindan','getup','2020-04-29 05:59:11',-1,''),(21,'admin','supper','2020-04-29 06:03:55',1,''),(22,'qindan','supper','2020-04-29 06:05:38',1,''),(23,'qindan','supper','2020-04-29 06:09:19',1,''),(24,'qindan','supper','2020-04-29 06:09:25',1,''),(25,'qindan','supper','2020-04-29 06:10:36',1,'');
/*!40000 ALTER TABLE `action_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_`
--

DROP TABLE IF EXISTS `user_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `usertype` varchar(10) NOT NULL,
  `credit` int(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_`
--

LOCK TABLES `user_` WRITE;
/*!40000 ALTER TABLE `user_` DISABLE KEYS */;
INSERT INTO `user_` VALUES ('admin','tst123','admin',50),('qindan','qindan','user',0);
/*!40000 ALTER TABLE `user_` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-29 18:36:20
