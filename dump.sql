-- MariaDB dump 10.19  Distrib 10.11.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: javalet
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estacionamento`
--

DROP TABLE IF EXISTS `estacionamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacionamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacidade` int DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `taxa_base` float NOT NULL,
  `taxa_diaria` float NOT NULL,
  `taxa_horaria` float NOT NULL,
  `taxa_mensal` float NOT NULL,
  `taxa_semanal` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacionamento`
--

LOCK TABLES `estacionamento` WRITE;
/*!40000 ALTER TABLE `estacionamento` DISABLE KEYS */;
INSERT INTO `estacionamento` VALUES
(50,1,'Javalet Salto',5,50,10,800,300),
(35,2,'Javalet Indaiatuba',4,40,7.5,700,250);
/*!40000 ALTER TABLE `estacionamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacionamento_eventos`
--

DROP TABLE IF EXISTS `estacionamento_eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacionamento_eventos` (
  `estacionamento_id` int NOT NULL,
  `eventos_id` int NOT NULL,
  UNIQUE KEY `UK_6m6saq48p646799s2f3bdvvui` (`eventos_id`),
  KEY `FKoexo7hir4ou6d6oimmen0v77v` (`estacionamento_id`),
  CONSTRAINT `FKci8gxjiohu4ghun31vkp45awg` FOREIGN KEY (`eventos_id`) REFERENCES `evento_veiculo` (`id`),
  CONSTRAINT `FKoexo7hir4ou6d6oimmen0v77v` FOREIGN KEY (`estacionamento_id`) REFERENCES `estacionamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacionamento_eventos`
--

LOCK TABLES `estacionamento_eventos` WRITE;
/*!40000 ALTER TABLE `estacionamento_eventos` DISABLE KEYS */;
/*!40000 ALTER TABLE `estacionamento_eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacionamento_servicos`
--

DROP TABLE IF EXISTS `estacionamento_servicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacionamento_servicos` (
  `estacionamento_id` int NOT NULL,
  `servicos_id` int NOT NULL,
  UNIQUE KEY `UK_cpvt1nv6l3oy4ntb8x0de1v2q` (`servicos_id`),
  KEY `FKmj0w3v2seqi60ru5nwwyb7slk` (`estacionamento_id`),
  CONSTRAINT `FK5tojm75osrlnx70wp08wr49ul` FOREIGN KEY (`servicos_id`) REFERENCES `servico` (`id`),
  CONSTRAINT `FKmj0w3v2seqi60ru5nwwyb7slk` FOREIGN KEY (`estacionamento_id`) REFERENCES `estacionamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacionamento_servicos`
--

LOCK TABLES `estacionamento_servicos` WRITE;
/*!40000 ALTER TABLE `estacionamento_servicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `estacionamento_servicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacionamento_veiculos`
--

DROP TABLE IF EXISTS `estacionamento_veiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estacionamento_veiculos` (
  `estacionamento_id` int NOT NULL,
  `veiculos_id` int NOT NULL,
  UNIQUE KEY `UK_6mia130jn7n1xioo3br5i6b50` (`veiculos_id`),
  KEY `FK74ghiunhydy3y5gd9vqjfbqfg` (`estacionamento_id`),
  CONSTRAINT `FK4vuxqiwc7yyxo66iuo88u5c7r` FOREIGN KEY (`veiculos_id`) REFERENCES `veiculo` (`id`),
  CONSTRAINT `FK74ghiunhydy3y5gd9vqjfbqfg` FOREIGN KEY (`estacionamento_id`) REFERENCES `estacionamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacionamento_veiculos`
--

LOCK TABLES `estacionamento_veiculos` WRITE;
/*!40000 ALTER TABLE `estacionamento_veiculos` DISABLE KEYS */;
/*!40000 ALTER TABLE `estacionamento_veiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_veiculo`
--

DROP TABLE IF EXISTS `evento_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_veiculo` (
  `id` int NOT NULL,
  `datahora` datetime(6) DEFAULT NULL,
  `tipo_evento` enum('ENTRADA','SAIDA') DEFAULT NULL,
  `estacionamento_id` int DEFAULT NULL,
  `veiculo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmc4ng4k1qc1n4nk4449744js6` (`estacionamento_id`),
  KEY `FK6iw523nl7kj05nbtjoer6yao5` (`veiculo_id`),
  CONSTRAINT `FK6iw523nl7kj05nbtjoer6yao5` FOREIGN KEY (`veiculo_id`) REFERENCES `veiculo` (`id`),
  CONSTRAINT `FKmc4ng4k1qc1n4nk4449744js6` FOREIGN KEY (`estacionamento_id`) REFERENCES `estacionamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_veiculo`
--

LOCK TABLES `evento_veiculo` WRITE;
/*!40000 ALTER TABLE `evento_veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento_veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_veiculo_seq`
--

DROP TABLE IF EXISTS `evento_veiculo_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_veiculo_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_veiculo_seq`
--

LOCK TABLES `evento_veiculo_seq` WRITE;
/*!40000 ALTER TABLE `evento_veiculo_seq` DISABLE KEYS */;
INSERT INTO `evento_veiculo_seq` VALUES
(1);
/*!40000 ALTER TABLE `evento_veiculo_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `id` int NOT NULL,
  `fim` datetime(6) DEFAULT NULL,
  `inicio` datetime(6) DEFAULT NULL,
  `tipo_servico` enum('DIARIA','HORARIA','MENSAL') DEFAULT NULL,
  `estacionamento_id` int DEFAULT NULL,
  `veiculo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkceyfh7693l8tqr2dnm85cw9r` (`estacionamento_id`),
  KEY `FKry9tnp4qo72bc4xkrt73a2asg` (`veiculo_id`),
  CONSTRAINT `FKkceyfh7693l8tqr2dnm85cw9r` FOREIGN KEY (`estacionamento_id`) REFERENCES `estacionamento` (`id`),
  CONSTRAINT `FKry9tnp4qo72bc4xkrt73a2asg` FOREIGN KEY (`veiculo_id`) REFERENCES `veiculo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico_seq`
--

DROP TABLE IF EXISTS `servico_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico_seq`
--

LOCK TABLES `servico_seq` WRITE;
/*!40000 ALTER TABLE `servico_seq` DISABLE KEYS */;
INSERT INTO `servico_seq` VALUES
(1);
/*!40000 ALTER TABLE `servico_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo` enum('CLIENTE','DIRETOR','PORTEIRO') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_692bsnqxa8m9fmx7m1yc6hsui` (`cpf`),
  UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES
('111.111.111-11','porteiro@javalet.com',1,'Poeur Teiro','senha','PORTEIRO'),
('222.222.222-22','diretor@javalet.com',2,'Dirê Torr','senha','DIRETOR'),
('333.333.333-33','cliente@email.com',3,'Cli Enti','senha','CLIENTE');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_servicos`
--

DROP TABLE IF EXISTS `usuario_servicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_servicos` (
  `usuario_id` int NOT NULL,
  `servicos_id` int NOT NULL,
  UNIQUE KEY `UK_q36gsj07yiwql79g1rw21x5gm` (`servicos_id`),
  KEY `FKmi42r8pmautg63j2kv6rdkd5u` (`usuario_id`),
  CONSTRAINT `FK216gotk2ecred6m2ync9gc2tn` FOREIGN KEY (`servicos_id`) REFERENCES `servico` (`id`),
  CONSTRAINT `FKmi42r8pmautg63j2kv6rdkd5u` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_servicos`
--

LOCK TABLES `usuario_servicos` WRITE;
/*!40000 ALTER TABLE `usuario_servicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_servicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_veiculos`
--

DROP TABLE IF EXISTS `usuario_veiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_veiculos` (
  `usuario_id` int NOT NULL,
  `veiculos_id` int NOT NULL,
  UNIQUE KEY `UK_pfuhmsskayamgfgcn9qobesho` (`veiculos_id`),
  KEY `FKfu2kxi62c8guegksd66moergh` (`usuario_id`),
  CONSTRAINT `FKfu2kxi62c8guegksd66moergh` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKgctdd44o80uj769t8wmtqvs02` FOREIGN KEY (`veiculos_id`) REFERENCES `veiculo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_veiculos`
--

LOCK TABLES `usuario_veiculos` WRITE;
/*!40000 ALTER TABLE `usuario_veiculos` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_veiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cor` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `tipo` enum('CAMINHAO','CARRO','MOTO') DEFAULT NULL,
  `cliente_id` int DEFAULT NULL,
  `estacionamento_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKepidt6ge9jf6907k1dd2w0k0k` (`cliente_id`),
  KEY `FKqkkwxg7dh25pytuju4fscc8s4` (`estacionamento_id`),
  CONSTRAINT `FKepidt6ge9jf6907k1dd2w0k0k` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKqkkwxg7dh25pytuju4fscc8s4` FOREIGN KEY (`estacionamento_id`) REFERENCES `estacionamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-06  9:26:06
