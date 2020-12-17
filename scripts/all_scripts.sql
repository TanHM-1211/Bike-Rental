-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: capstone_project
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `bai_xe`
--

DROP TABLE IF EXISTS `bai_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bai_xe` (
  `id_bai_xe` int NOT NULL,
  `ten_bai_xe` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dia_chi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `dien_tich` int NOT NULL,
  PRIMARY KEY (`id_bai_xe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bai_xe`
--

LOCK TABLES `bai_xe` WRITE;
/*!40000 ALTER TABLE `bai_xe` DISABLE KEYS */;
INSERT INTO `bai_xe` VALUES (1,'Eco Bách Khoa','1 Hai Bà Trưng Hà Nội',300),(2,'Eco Meo','1 Hoàng Thái Hà Nội',300),(3,'Eco Thai','12 Thái Thịnh Hà Nội',300);
/*!40000 ALTER TABLE `bai_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giao_dich_thue_xe`
--

DROP TABLE IF EXISTS `giao_dich_thue_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giao_dich_thue_xe` (
  `id_giao_dich_thue_xe` int NOT NULL,
  `id_xe` int NOT NULL,
  `id_nguoi_dung` int NOT NULL,
  `so_tien` int NOT NULL,
  `id_bai_xe_thue` int NOT NULL,
  `id_bai_xe_tra` int NOT NULL,
  `thoi_diem_thue` datetime NOT NULL,
  `thoi_diem_tra` datetime NOT NULL,
  `id_the_giao_dich` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `cach_thue` int NOT NULL,
  PRIMARY KEY (`id_giao_dich_thue_xe`),
  KEY `id_bai_xe_idx` (`id_bai_xe_thue`,`id_bai_xe_tra`),
  KEY `id_xe_idx` (`id_xe`),
  KEY `id_bai_xe_tra_idx` (`id_bai_xe_tra`),
  CONSTRAINT `id_bai_xe_thue` FOREIGN KEY (`id_bai_xe_thue`) REFERENCES `bai_xe` (`id_bai_xe`),
  CONSTRAINT `id_bai_xe_tra` FOREIGN KEY (`id_bai_xe_tra`) REFERENCES `bai_xe` (`id_bai_xe`),
  CONSTRAINT `id_xe` FOREIGN KEY (`id_xe`) REFERENCES `xe` (`id_xe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giao_dich_thue_xe`
--

LOCK TABLES `giao_dich_thue_xe` WRITE;
/*!40000 ALTER TABLE `giao_dich_thue_xe` DISABLE KEYS */;
/*!40000 ALTER TABLE `giao_dich_thue_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xe`
--

DROP TABLE IF EXISTS `xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xe` (
  `id_xe` int NOT NULL,
  `loai_xe` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `bien_so_xe` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `id_bai_xe` int NOT NULL,
  `tien_coc` int NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `pin` int DEFAULT NULL,
  PRIMARY KEY (`id_xe`),
  KEY `id_bai_xe_idx` (`id_bai_xe`),
  CONSTRAINT `id_bai_xe` FOREIGN KEY (`id_bai_xe`) REFERENCES `bai_xe` (`id_bai_xe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xe`
--

LOCK TABLES `xe` WRITE;
/*!40000 ALTER TABLE `xe` DISABLE KEYS */;
INSERT INTO `xe` VALUES (1,'Xe đạp thường','000001',1,500000,_binary '',NULL),(2,'Xe đạp điện','121001',2,450000,_binary '\0',50),(5,'Xe đạp điện','123346',1,600000,_binary '\0',90),(7,'Xe đạp điện','112456',1,630000,_binary '\0',75),(9,'Xe đạp thường','109856',2,430000,_binary '',NULL),(11,'Xe đạp điện','112246',3,450000,_binary '\0',86);
/*!40000 ALTER TABLE `xe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-17 16:09:11
