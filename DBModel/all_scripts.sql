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
INSERT INTO `bai_xe` VALUES (1,'Eco Bách Khoa','1 Hai Bà Trưng Hà Nội',300),(2,'Eco Meo','1 Hoàng Thái Hà Nội',300),(3,'bai B','12 Thái Thịnh Hà Nội',300),(5,'bai A','dia chi 1',10);
/*!40000 ALTER TABLE `bai_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giao_dich_thanh_toan`
--

DROP TABLE IF EXISTS `giao_dich_thanh_toan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giao_dich_thanh_toan` (
  `id_giao_dich_thanh_toan` int NOT NULL,
  `id_the` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `thoi_gian_tao` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `so_tien` int NOT NULL,
  `noi_dung` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_giao_dich_thanh_toan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giao_dich_thanh_toan`
--

LOCK TABLES `giao_dich_thanh_toan` WRITE;
/*!40000 ALTER TABLE `giao_dich_thanh_toan` DISABLE KEYS */;
INSERT INTO `giao_dich_thanh_toan` VALUES (0,'118131_group11_2020','2020-12-19 21:11:42',10,'testing'),(1,'118131_group11_2020','2020-12-19 21:17:41',10,'testing'),(2,'118131_group11_2020','2020-12-19 21:17:51',-10,'testing'),(3,'118131_group11_2020','2020-12-19 23:24:34',-280000,'thue'),(4,'118131_group11_2020','2020-12-19 23:24:36',279999,'thue'),(5,'118131_group11_2020','2020-12-19 23:25:36',-280000,'thue'),(6,'118131_group11_2020','2020-12-19 23:25:38',279999,'thue'),(7,'118131_group11_2020','2020-12-19 23:29:19',-280000,'thue'),(8,'118131_group11_2020','2020-12-19 23:29:21',279999,'thue'),(9,'118131_group11_2020','2020-12-19 23:31:56',-280000,'thue'),(10,'118131_group11_2020','2020-12-19 23:31:57',279999,'tra'),(11,'118131_group11_2020','2020-12-19 23:32:55',-280000,'thue'),(12,'118131_group11_2020','2020-12-19 23:32:56',279999,'tra'),(13,'118131_group11_2020','2020-12-19 23:40:51',-280000,'thue'),(14,'118131_group11_2020','2020-12-19 23:40:52',279999,'tra'),(15,'118131_group11_2020','2020-12-19 23:44:36',-280000,'thue'),(16,'118131_group11_2020','2020-12-19 23:44:38',279999,'tra');
/*!40000 ALTER TABLE `giao_dich_thanh_toan` ENABLE KEYS */;
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
  `id_bai_xe_thue` int NOT NULL,
  `id_bai_xe_tra` int DEFAULT NULL,
  `id_thanh_toan_thue` int NOT NULL,
  `id_thanh_toan_tra` int DEFAULT NULL,
  `so_tien` int DEFAULT NULL,
  PRIMARY KEY (`id_giao_dich_thue_xe`),
  KEY `id_bai_xe_idx` (`id_bai_xe_thue`,`id_bai_xe_tra`),
  KEY `id_xe_idx` (`id_xe`),
  KEY `id_bai_xe_tra_idx` (`id_bai_xe_tra`),
  KEY `id_thanh_toan_thue_idx` (`id_thanh_toan_thue`),
  KEY `id_thanh_toan_tra_idx` (`id_thanh_toan_tra`),
  CONSTRAINT `id_bai_xe_thue` FOREIGN KEY (`id_bai_xe_thue`) REFERENCES `bai_xe` (`id_bai_xe`),
  CONSTRAINT `id_bai_xe_tra` FOREIGN KEY (`id_bai_xe_tra`) REFERENCES `bai_xe` (`id_bai_xe`),
  CONSTRAINT `id_thanh_toan_thue` FOREIGN KEY (`id_thanh_toan_thue`) REFERENCES `giao_dich_thanh_toan` (`id_giao_dich_thanh_toan`),
  CONSTRAINT `id_thanh_toan_tra` FOREIGN KEY (`id_thanh_toan_tra`) REFERENCES `giao_dich_thanh_toan` (`id_giao_dich_thanh_toan`),
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
-- Table structure for table `loai_xe`
--

DROP TABLE IF EXISTS `loai_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_xe` (
  `id_loai_xe` int NOT NULL,
  `ten_loai_xe` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `gia_tri` int NOT NULL,
  `gia_30p_dau` int NOT NULL,
  `gia_moi_15p` int NOT NULL,
  PRIMARY KEY (`id_loai_xe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_xe`
--

LOCK TABLES `loai_xe` WRITE;
/*!40000 ALTER TABLE `loai_xe` DISABLE KEYS */;
INSERT INTO `loai_xe` VALUES (1,'Xe đạp thường',400000,10000,3000),(2,'Xe đạp đôi',550000,15000,4500),(3,'Xe đạp điện',700000,15000,4500);
/*!40000 ALTER TABLE `loai_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoi_dung`
--

DROP TABLE IF EXISTS `nguoi_dung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoi_dung` (
  `id_nguoi_dung` int NOT NULL,
  PRIMARY KEY (`id_nguoi_dung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_dung`
--

LOCK TABLES `nguoi_dung` WRITE;
/*!40000 ALTER TABLE `nguoi_dung` DISABLE KEYS */;
INSERT INTO `nguoi_dung` VALUES (1);
/*!40000 ALTER TABLE `nguoi_dung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguoi_dung_giao_dich_thue_xe`
--

DROP TABLE IF EXISTS `nguoi_dung_giao_dich_thue_xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoi_dung_giao_dich_thue_xe` (
  `id_nguoi_dung_giao_dich_thue_xe` int NOT NULL,
  `id_nguoi_dung` int NOT NULL,
  `id_giao_dich_thue_xe` int DEFAULT NULL,
  PRIMARY KEY (`id_nguoi_dung_giao_dich_thue_xe`),
  KEY `id_nguoi_dung_idx` (`id_nguoi_dung`),
  KEY `id_giao_dich_thue_xe_idx` (`id_giao_dich_thue_xe`),
  CONSTRAINT `id_giao_dich_thue_xe` FOREIGN KEY (`id_giao_dich_thue_xe`) REFERENCES `giao_dich_thue_xe` (`id_giao_dich_thue_xe`),
  CONSTRAINT `id_nguoi_dung` FOREIGN KEY (`id_nguoi_dung`) REFERENCES `nguoi_dung` (`id_nguoi_dung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_dung_giao_dich_thue_xe`
--

LOCK TABLES `nguoi_dung_giao_dich_thue_xe` WRITE;
/*!40000 ALTER TABLE `nguoi_dung_giao_dich_thue_xe` DISABLE KEYS */;
/*!40000 ALTER TABLE `nguoi_dung_giao_dich_thue_xe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xe`
--

DROP TABLE IF EXISTS `xe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xe` (
  `id_xe` int NOT NULL,
  `id_loai_xe` int NOT NULL,
  `bien_so_xe` varchar(6) COLLATE utf8_unicode_ci NOT NULL,
  `id_bai_xe` int NOT NULL,
  `trang_thai` int NOT NULL,
  `pin` int DEFAULT NULL,
  PRIMARY KEY (`id_xe`),
  KEY `id_bai_xe_idx` (`id_bai_xe`),
  KEY `id_loai_xe_idx` (`id_loai_xe`),
  CONSTRAINT `id_bai_xe` FOREIGN KEY (`id_bai_xe`) REFERENCES `bai_xe` (`id_bai_xe`),
  CONSTRAINT `id_loai_xe` FOREIGN KEY (`id_loai_xe`) REFERENCES `loai_xe` (`id_loai_xe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xe`
--

LOCK TABLES `xe` WRITE;
/*!40000 ALTER TABLE `xe` DISABLE KEYS */;
INSERT INTO `xe` VALUES (1,1,'000001',1,0,NULL),(2,3,'121001',2,0,50),(5,3,'123346',1,0,90),(7,3,'112456',1,0,75),(9,1,'109856',2,0,NULL),(11,3,'112246',3,0,86);
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

-- Dump completed on 2020-12-19 23:46:35
