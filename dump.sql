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
INSERT INTO `estacionamento` VALUES
(50,1,'Javalet Salto',5,50,10,800,300),
(35,2,'Javalet Indaiatuba',4,40,7.5,700,250);
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
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento_veiculo_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `evento_veiculo_seq` VALUES
(1);
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
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `servico_seq` VALUES
(1);
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
INSERT INTO `usuario` VALUES
('111.111.111-11','porteiro@javalet.com',1,'Poeur Teiro','senha','PORTEIRO'),
('222.222.222-22','diretor@javalet.com',2,'Dirê Torr','senha','DIRETOR'),
('333.333.333-33','cliente@email.com',3,'Cli Enti','senha','CLIENTE');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
INSERT INTO `veiculo` VALUES
(3,'Vermelho',NULL,1,'Toyota Prius','TST5000','CARRO'),
(3,'Amarelo',NULL,2,'Beetle','ESK3001','CARRO');
