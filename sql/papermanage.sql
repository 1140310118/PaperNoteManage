-- MySQL dump 10.13  Distrib 5.7.15, for Win64 (x86_64)
--
-- Host: localhost    Database: papermanage
-- ------------------------------------------------------
-- Server version	5.7.15

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
-- Table structure for table `paper`
--

DROP TABLE IF EXISTS `paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper` (
  `paperNickName` varchar(255) DEFAULT NULL,
  `paperOrigin` varchar(255) DEFAULT NULL,
  `paperWebFilePath` varchar(255) DEFAULT NULL,
  `paperExteriorURL` varchar(255) DEFAULT NULL,
  `paperRemark` varchar(255) DEFAULT NULL,
  `uploadDate` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper`
--

LOCK TABLES `paper` WRITE;
/*!40000 ALTER TABLE `paper` DISABLE KEYS */;
INSERT INTO `paper` VALUES ('dfg','','null','null','null','null'),('fasfsdf','','null','null','null','null'),('test','','null','null','null','null'),('pppp','ooo','null','null','null','null'),('pppp','oooo','null','null','null','null'),('pppp','oooo','null','null','null','null'),('pppp','oooo','null','null','null','null'),('poiuytre','ertyui','null','null','null','null'),('你好我是论文','哈尔滨工业大学','null','null','null','null'),('你好我是论文','哈尔滨工业大学','null','null','null','null'),('发送到福','曹德福','null','null','阿斯顿发顺丰到付','null'),('发送到福','曹德福','null','null','阿斯顿发顺丰到付','null'),('舒服撒水电费','的说法是打发发生的','null','null','是打发斯蒂芬是打发斯蒂芬','null'),('舒服撒水电费','的说法是打发发生的','null','null','是打发斯蒂芬是打发斯蒂芬','null'),('dfg达哥','上打广告方式','null','null','是个大范甘迪发','null'),('dfg达哥','上打广告方式','null','null','是个大范甘迪发','2016-11-07 20:27:04'),('dfg达哥否','曹德福','null','null','爱上对方法萨芬的','2016-11-07 20:27:24'),('规范dfg达哥否','哈尔滨工业大学','d:upload1140310115-Lab2-report.doc','null','梵蒂冈和对方回复的恢复规划规范','2016-11-07 20:31:47'),('bu规范dfg达哥否','哈尔滨工业大学','d:upload1140310115-Lab2-report.doc','null','梵蒂冈和对方回复的恢复规划规范','2016-11-07 20:31:47'),('bu规范dfg达哥否','哈尔滨工业大学','d:\\upload\\1140310115-Lab2-report.doc','null','梵蒂冈和对方回复的恢复规划规范','2016-11-07 20:31:47'),('规范dfg达哥否','哈尔滨工业大学','d:/upload/1140310115-Lab2-report.doc','null','梵蒂冈和对方回复的恢复规划规范','2016-11-07 20:37:22'),('dfg达哥否否','曹德福','d:/upload/1140310115-Lab2-report.doc','null','阿斯顿发生打发打发','2016-11-07 20:37:46');
/*!40000 ALTER TABLE `paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample`
--

DROP TABLE IF EXISTS `sample`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sample` (
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample`
--

LOCK TABLES `sample` WRITE;
/*!40000 ALTER TABLE `sample` DISABLE KEYS */;
/*!40000 ALTER TABLE `sample` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('zorenv@163.com','4321005','zorenv'),('test@test.com','testpassword','testnickname'),('zv@163.com','4321005','zv');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-15 21:15:18
