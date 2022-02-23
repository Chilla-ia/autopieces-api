-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: api_pataproute_db
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `article_name` varchar(100) NOT NULL,
  `article_price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'Embrayage',557),(2,'Culasse',124),(3,'Turbo',1568),(4,'Injecteur',725),(5,'Démarreur',326),(6,'Filtre à air',57),(7,'Bougie',33),(8,'Filtre à carburant',70),(9,'Pot catalytique',743),(10,'Cardans',213),(11,'Amortisseurs',885),(12,'Pneus',281),(13,'Verre de phare',25),(14,'Ampoule',13),(15,'Compresseur',189),(16,'Radiateur',369),(17,'Pare-choc avant',636),(18,'Rétroviseurs',176);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `clients_id` int NOT NULL AUTO_INCREMENT,
  `clients_name` varchar(100) NOT NULL,
  `contrat_id` int NOT NULL,
  PRIMARY KEY (`clients_id`),
  KEY `fk_contrat` (`contrat_id`),
  CONSTRAINT `fk_contrat` FOREIGN KEY (`contrat_id`) REFERENCES `contrat` (`contrat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (26,'Dupont',1),(27,'Metivier',3),(28,'Fraudeau',2),(29,'Martin',4),(30,'Barbeau',1),(31,'Guill',2),(32,'Babin',2),(33,'Delahaye',4),(34,'Rousselin',3),(35,'Caravatti',5),(36,'Pambou',5),(37,'Paco',2),(38,'Delhoume-Daudé',4),(39,'Caunes',1),(40,'Pouqine',3),(41,'Jabouille',3),(42,'Ramiarinirina',5),(43,'Gomez',2),(44,'Albou',1),(45,'Prevost',4),(46,'Garnier',5),(47,'Gallet',1),(48,'De La Fouchardiere',5),(49,'Brunet',3),(50,'Audin',3);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande` (
  `commande_id` int NOT NULL AUTO_INCREMENT,
  `commande_date` datetime NOT NULL,
  `clients_id` int NOT NULL,
  `article_id` int NOT NULL,
  PRIMARY KEY (`commande_id`),
  KEY `fk_clients` (`clients_id`),
  KEY `fk_article` (`article_id`),
  CONSTRAINT `fk_article` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `fk_clients` FOREIGN KEY (`clients_id`) REFERENCES `clients` (`clients_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrat`
--

DROP TABLE IF EXISTS `contrat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrat` (
  `contrat_id` int NOT NULL AUTO_INCREMENT,
  `contrat_marge` int NOT NULL,
  PRIMARY KEY (`contrat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrat`
--

LOCK TABLES `contrat` WRITE;
/*!40000 ALTER TABLE `contrat` DISABLE KEYS */;
INSERT INTO `contrat` VALUES (1,5),(2,10),(3,15),(4,20),(5,25);
/*!40000 ALTER TABLE `contrat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-23 14:45:58
