-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `authoriz_privilege`
--

DROP TABLE IF EXISTS `authoriz_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authoriz_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `privilege_desc` varchar(64) DEFAULT NULL,
  `privilege_name` varchar(32) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8DD01E0EAA12A0F` (`PARENT_ID`),
  CONSTRAINT `FK8DD01E0EAA12A0F` FOREIGN KEY (`PARENT_ID`) REFERENCES `authoriz_privilege` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authoriz_privilege`
--

LOCK TABLES `authoriz_privilege` WRITE;
/*!40000 ALTER TABLE `authoriz_privilege` DISABLE KEYS */;
INSERT INTO `authoriz_privilege` VALUES (1,'For display user gestion menu','UserMenu',NULL),(2,'Create new user','CreateUser',NULL),(3,'For display workflow management menu','WorkflowMenu',NULL),(4,'Create a new workflow collection','CreateWorkflow',NULL),(5,'Show workflow','ShowWorkflow',NULL),(6,'For displaying the authorization menu ','AuthorizationMenu',NULL),(7,'For display document menu','DocumentMenu',NULL),(8,'For display administrator\'s welcome menu','AdminWelcomeMenu',NULL),(9,'Show all users in the system','ShowAllUser',NULL),(10,'Show the table for modification','ModifyUser',NULL),(11,'','ShowAllPrivilege',NULL),(12,'','CreatePrivilege',NULL),(13,'','UpdatePrivilege',NULL),(14,'','ShowAllRole',NULL),(15,'','CreateRole',NULL),(16,'','UpdateRole',NULL),(17,'','TechnologiesMenu',NULL),(18,'','ModifyStep',NULL),(19,'','ShowDocument',NULL),(20,'','CreateDocument',NULL),(21,'','UserWelcomeMenu',NULL);
/*!40000 ALTER TABLE `authoriz_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authoriz_role`
--

DROP TABLE IF EXISTS `authoriz_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authoriz_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_desc` varchar(64) DEFAULT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authoriz_role`
--

LOCK TABLES `authoriz_role` WRITE;
/*!40000 ALTER TABLE `authoriz_role` DISABLE KEYS */;
INSERT INTO `authoriz_role` VALUES (1,'Administrator user','Administrator'),(2,'Root administrator has all privileges','RootAdministrator'),(3,'','Trader'),(4,'','Responsible');
/*!40000 ALTER TABLE `authoriz_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authoriz_role_privilege`
--

DROP TABLE IF EXISTS `authoriz_role_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authoriz_role_privilege` (
  `ROLE_ID` int(11) NOT NULL,
  `PRIVILEGE_ID` int(11) NOT NULL,
  KEY `FK2A55ECAB6325AAA8` (`PRIVILEGE_ID`),
  KEY `FK2A55ECABD8C7B2AC` (`ROLE_ID`),
  CONSTRAINT `FK2A55ECAB6325AAA8` FOREIGN KEY (`PRIVILEGE_ID`) REFERENCES `authoriz_privilege` (`id`),
  CONSTRAINT `FK2A55ECABD8C7B2AC` FOREIGN KEY (`ROLE_ID`) REFERENCES `authoriz_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authoriz_role_privilege`
--

LOCK TABLES `authoriz_role_privilege` WRITE;
/*!40000 ALTER TABLE `authoriz_role_privilege` DISABLE KEYS */;
INSERT INTO `authoriz_role_privilege` VALUES (1,1),(1,2),(1,3),(1,6),(1,5),(1,8),(1,9),(1,10),(1,4),(1,11),(1,14),(1,15),(1,16),(1,17),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(3,3),(3,5),(3,7),(3,19),(3,20),(3,21),(4,3),(4,5),(4,7),(4,19),(4,21);
/*!40000 ALTER TABLE `authoriz_role_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_admin`
--

DROP TABLE IF EXISTS `wkf_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_admin` (
  `ADMIN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADMIN_NAME` varchar(64) DEFAULT NULL,
  `ADMIN_EMAIL` varchar(64) DEFAULT NULL,
  `ADMIN_PASSWORD` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ADMIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_admin`
--

LOCK TABLES `wkf_admin` WRITE;
/*!40000 ALTER TABLE `wkf_admin` DISABLE KEYS */;
INSERT INTO `wkf_admin` VALUES (1,'admin','admin@admin.admin','admin');
/*!40000 ALTER TABLE `wkf_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_comment`
--

DROP TABLE IF EXISTS `wkf_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_comment` (
  `COMMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMENT` varchar(128) DEFAULT NULL,
  `NOTATION` varchar(8) DEFAULT NULL,
  `NOTICE` varchar(16) DEFAULT NULL,
  `AUTHOT_ID` int(11) DEFAULT NULL,
  `DOCUMENT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`COMMENT_ID`),
  KEY `FK297B2F3265EEDE0B` (`DOCUMENT_ID`),
  KEY `FK297B2F3223FF3B89` (`AUTHOT_ID`),
  CONSTRAINT `FK297B2F3223FF3B89` FOREIGN KEY (`AUTHOT_ID`) REFERENCES `wkf_user` (`USER_ID`),
  CONSTRAINT `FK297B2F3265EEDE0B` FOREIGN KEY (`DOCUMENT_ID`) REFERENCES `wkf_document` (`DOCUMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_comment`
--

LOCK TABLES `wkf_comment` WRITE;
/*!40000 ALTER TABLE `wkf_comment` DISABLE KEYS */;
INSERT INTO `wkf_comment` VALUES (1,'OK, Forward.','6.5','',3,1),(2,'Responsible validated.','6.5','',3,1),(3,'Attention','5','',5,2),(4,'','6.5','',1,3);
/*!40000 ALTER TABLE `wkf_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_document`
--

DROP TABLE IF EXISTS `wkf_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_document` (
  `DOCUMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `client` varchar(255) DEFAULT NULL,
  `resource` decimal(19,2) DEFAULT NULL,
  `STEPDATE` datetime DEFAULT NULL,
  `AUTHOR_ID` int(11) DEFAULT NULL,
  `CURRENTSTEP_ID` int(11) DEFAULT NULL,
  `RESPONSIBLE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DOCUMENT_ID`),
  KEY `FK5D2FAAA86FBECC94` (`CURRENTSTEP_ID`),
  KEY `FK5D2FAAA823FE52CB` (`AUTHOR_ID`),
  KEY `FK5D2FAAA8BE8CB180` (`RESPONSIBLE_ID`),
  CONSTRAINT `FK5D2FAAA823FE52CB` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `wkf_user` (`USER_ID`),
  CONSTRAINT `FK5D2FAAA86FBECC94` FOREIGN KEY (`CURRENTSTEP_ID`) REFERENCES `wkf_workflow_step` (`ID`),
  CONSTRAINT `FK5D2FAAA8BE8CB180` FOREIGN KEY (`RESPONSIBLE_ID`) REFERENCES `wkf_user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_document`
--

LOCK TABLES `wkf_document` WRITE;
/*!40000 ALTER TABLE `wkf_document` DISABLE KEYS */;
INSERT INTO `wkf_document` VALUES (1,15000.00,'Client 1',2000.00,'2016-10-28 09:08:54',1,6,8),(2,15000.00,'Client 2',2000.00,'2016-10-28 10:09:46',1,6,7),(3,15000.00,'Client 3',1500.00,'2016-10-28 11:05:38',1,3,3);
/*!40000 ALTER TABLE `wkf_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_history`
--

DROP TABLE IF EXISTS `wkf_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_history` (
  `HISTORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` datetime DEFAULT NULL,
  `MESSAGE` varchar(128) DEFAULT NULL,
  `DOCUMENT_ID` int(11) DEFAULT NULL,
  `NEXT_RESPONSIBLE_ID` int(11) DEFAULT NULL,
  `RESPONSIBLE_ID` int(11) DEFAULT NULL,
  `DECISION_ID` int(11) DEFAULT NULL,
  `STEP_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`HISTORY_ID`),
  KEY `FK2815256765EEDE0B` (`DOCUMENT_ID`),
  KEY `FK28152567E83438D7` (`DECISION_ID`),
  KEY `FK28152567975F04C` (`NEXT_RESPONSIBLE_ID`),
  KEY `FK28152567BE8CB180` (`RESPONSIBLE_ID`),
  KEY `FK2815256731BAF42D` (`STEP_ID`),
  CONSTRAINT `FK2815256731BAF42D` FOREIGN KEY (`STEP_ID`) REFERENCES `wkf_workflow_step` (`ID`),
  CONSTRAINT `FK2815256765EEDE0B` FOREIGN KEY (`DOCUMENT_ID`) REFERENCES `wkf_document` (`DOCUMENT_ID`),
  CONSTRAINT `FK28152567975F04C` FOREIGN KEY (`NEXT_RESPONSIBLE_ID`) REFERENCES `wkf_user` (`USER_ID`),
  CONSTRAINT `FK28152567BE8CB180` FOREIGN KEY (`RESPONSIBLE_ID`) REFERENCES `wkf_user` (`USER_ID`),
  CONSTRAINT `FK28152567E83438D7` FOREIGN KEY (`DECISION_ID`) REFERENCES `wkf_workflow_decision` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_history`
--

LOCK TABLES `wkf_history` WRITE;
/*!40000 ALTER TABLE `wkf_history` DISABLE KEYS */;
INSERT INTO `wkf_history` VALUES (1,'2016-10-27 17:30:39','This is a test document',2,3,1,1,2),(2,'2016-10-28 08:57:16','',1,3,1,1,2),(3,'2016-10-28 09:02:32','OK',1,4,3,2,2),(4,'2016-10-28 09:02:56','Second Ok',2,5,3,2,2),(5,'2016-10-28 09:08:54','Risk ok',1,8,4,3,2),(6,'2016-10-28 09:10:28','Attention risk',2,3,5,9,2),(7,'2016-10-28 10:07:18','OK',2,4,3,2,3),(8,'2016-10-28 10:09:46','Risk ok',2,7,4,3,4),(9,'2016-10-28 11:05:38','',3,3,1,1,2);
/*!40000 ALTER TABLE `wkf_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_intervenor_document`
--

DROP TABLE IF EXISTS `wkf_intervenor_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_intervenor_document` (
  `DOCUMENT_ID` int(11) NOT NULL,
  `INTERVENOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`DOCUMENT_ID`,`INTERVENOR_ID`),
  KEY `FK26A0C32765EEDE0B` (`DOCUMENT_ID`),
  KEY `FK26A0C3274FD7D410` (`INTERVENOR_ID`),
  CONSTRAINT `FK26A0C3274FD7D410` FOREIGN KEY (`INTERVENOR_ID`) REFERENCES `wkf_user` (`USER_ID`),
  CONSTRAINT `FK26A0C32765EEDE0B` FOREIGN KEY (`DOCUMENT_ID`) REFERENCES `wkf_document` (`DOCUMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_intervenor_document`
--

LOCK TABLES `wkf_intervenor_document` WRITE;
/*!40000 ALTER TABLE `wkf_intervenor_document` DISABLE KEYS */;
INSERT INTO `wkf_intervenor_document` VALUES (1,1),(1,3),(1,4),(2,1),(2,3),(2,4),(2,5),(3,1);
/*!40000 ALTER TABLE `wkf_intervenor_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_lector_document`
--

DROP TABLE IF EXISTS `wkf_lector_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_lector_document` (
  `DOCUMENT_ID` int(11) NOT NULL,
  `LECTOR_ID` int(11) NOT NULL,
  PRIMARY KEY (`DOCUMENT_ID`,`LECTOR_ID`),
  KEY `FKEAD873E065EEDE0B` (`DOCUMENT_ID`),
  KEY `FKEAD873E0960C8209` (`LECTOR_ID`),
  CONSTRAINT `FKEAD873E065EEDE0B` FOREIGN KEY (`DOCUMENT_ID`) REFERENCES `wkf_document` (`DOCUMENT_ID`),
  CONSTRAINT `FKEAD873E0960C8209` FOREIGN KEY (`LECTOR_ID`) REFERENCES `wkf_user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_lector_document`
--

LOCK TABLES `wkf_lector_document` WRITE;
/*!40000 ALTER TABLE `wkf_lector_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `wkf_lector_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_user`
--

DROP TABLE IF EXISTS `wkf_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AGENCE` varchar(16) DEFAULT NULL,
  `JOB` varchar(32) DEFAULT NULL,
  `REGION` varchar(16) DEFAULT NULL,
  `SITE` varchar(16) DEFAULT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  `PASSWORD` varchar(32) DEFAULT NULL,
  `MANAGER_ID` int(11) DEFAULT NULL,
  `PARTNER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `FK49CF73F860C31969` (`MANAGER_ID`),
  KEY `FK49CF73F8D62C726E` (`PARTNER_ID`),
  CONSTRAINT `FK49CF73F860C31969` FOREIGN KEY (`MANAGER_ID`) REFERENCES `wkf_user` (`USER_ID`),
  CONSTRAINT `FK49CF73F8D62C726E` FOREIGN KEY (`PARTNER_ID`) REFERENCES `wkf_user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_user`
--

LOCK TABLES `wkf_user` WRITE;
/*!40000 ALTER TABLE `wkf_user` DISABLE KEYS */;
INSERT INTO `wkf_user` VALUES (1,'Agency1','Trader','Region1','Site1','First Trader','123',3,2),(2,'Agency1','Trader','Region1','Site1','Second Trader','123',3,1),(3,'Agency1','Responsible','Region1','Site1','First Responsible','123',NULL,NULL),(4,'Agency1','Risk control officer','Region1','Site1','first risk','123',NULL,NULL),(5,'Agency1','Risk control officer','Region1','Site1','second risk','123',NULL,NULL),(6,'Agency1','Trader','Region1','Site1','fi','123',NULL,NULL),(7,'Agency1','Back office','Region1','Site1','first backoffice','123',NULL,NULL),(8,'Agency1','Back office','Region1','Site1','second backoffice','123',NULL,NULL),(9,'Agency1','Trader','Region1','Site1','Admin','admin',NULL,NULL),(10,'Agency1','Trader','Region1','Site1','RootAdmin','initial',NULL,NULL);
/*!40000 ALTER TABLE `wkf_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_user_role`
--

DROP TABLE IF EXISTS `wkf_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_user_role` (
  `USER_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  KEY `FK24C44C7DD8C7B2AC` (`ROLE_ID`),
  KEY `FK24C44C7DC345608B` (`USER_ID`),
  CONSTRAINT `FK24C44C7DC345608B` FOREIGN KEY (`USER_ID`) REFERENCES `wkf_user` (`USER_ID`),
  CONSTRAINT `FK24C44C7DD8C7B2AC` FOREIGN KEY (`ROLE_ID`) REFERENCES `authoriz_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_user_role`
--

LOCK TABLES `wkf_user_role` WRITE;
/*!40000 ALTER TABLE `wkf_user_role` DISABLE KEYS */;
INSERT INTO `wkf_user_role` VALUES (7,1),(9,1),(10,2),(1,3),(3,3),(3,4);
/*!40000 ALTER TABLE `wkf_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_workflow`
--

DROP TABLE IF EXISTS `wkf_workflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_workflow` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DECISION` varchar(64) DEFAULT NULL,
  `NEXT_STEP_ID` int(11) DEFAULT NULL,
  `CONDITIONN` varchar(64) DEFAULT NULL,
  `PHASE` varchar(64) DEFAULT NULL,
  `STEP_ID` varchar(8) DEFAULT NULL,
  `STEP_NAME` varchar(64) DEFAULT NULL,
  `AUTORITY` varchar(16) DEFAULT NULL,
  `SERVICE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK2BEEB14CA5BA839F` (`NEXT_STEP_ID`),
  CONSTRAINT `FK2BEEB14CA5BA839F` FOREIGN KEY (`NEXT_STEP_ID`) REFERENCES `wkf_workflow` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_workflow`
--

LOCK TABLES `wkf_workflow` WRITE;
/*!40000 ALTER TABLE `wkf_workflow` DISABLE KEYS */;
INSERT INTO `wkf_workflow` VALUES (1,'Send to responsible',10,'','Montage','01','Create and montage document','Agency','Trader'),(2,'Answer the question to responsible',10,'','Montage','02','Answer the question of responsible','Agency','Trader'),(10,'Return to trader',2,'','Analysis metier','10','Validat by responsible','Agency','Responsible'),(11,'Send to risk control officer',20,'','Analysis metier','10','Validat by responsible','Agency','Responsible'),(20,'Send to back office',30,'','Analysis risk','20','Validat by risk control officer','Site','Risk control officer'),(21,'Send to trader',1,'','Analysis risk','20','Validat by risk control officer','Site','Risk control officer'),(30,'Validat',32,'','Back office','30','Validat by back office','Site','Back office'),(31,'Return to trader',1,'','Back office','30','Validat by back office',NULL,'Back office'),(32,'Validat',30,'','Back office','40','Final back office',NULL,'Back office'),(33,'Return to back office',30,'','Back office','40','Final back office',NULL,'Back office');
/*!40000 ALTER TABLE `wkf_workflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_workflow_decision`
--

DROP TABLE IF EXISTS `wkf_workflow_decision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_workflow_decision` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONDITIONN` varchar(64) DEFAULT NULL,
  `DECISION` varchar(64) DEFAULT NULL,
  `DECISION_ID` varchar(8) DEFAULT NULL,
  `NEXT_STEP_ID` int(11) DEFAULT NULL,
  `NEXT_STEP_NAME_ID` varchar(255) DEFAULT NULL,
  `STEP_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKD3F3656F31BAF42D` (`STEP_ID`),
  CONSTRAINT `FKD3F3656F31BAF42D` FOREIGN KEY (`STEP_ID`) REFERENCES `wkf_workflow_step` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_workflow_decision`
--

LOCK TABLES `wkf_workflow_decision` WRITE;
/*!40000 ALTER TABLE `wkf_workflow_decision` DISABLE KEYS */;
INSERT INTO `wkf_workflow_decision` VALUES (1,'','Send to responsible','1',3,'10',2),(2,'','Send to risk control officer','2',4,'20',3),(3,'','Send to backoffice','3',6,'40',4),(4,'','Debloger','4',5,'00',6),(5,'','Return to risk control officer','5',4,'20',6),(6,'','Return to responsible','6',3,'10',6),(7,'','Return to trader','7',2,'01',6),(8,'','Return to trader','8',2,'01',3),(9,'','Return to responsible','9',3,'10',4),(10,'','Return to trader','10',2,'01',4);
/*!40000 ALTER TABLE `wkf_workflow_decision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wkf_workflow_step`
--

DROP TABLE IF EXISTS `wkf_workflow_step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wkf_workflow_step` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AUTORITY` varchar(16) DEFAULT NULL,
  `PHASE` varchar(64) DEFAULT NULL,
  `SERVICE` varchar(32) DEFAULT NULL,
  `STEP_ID` varchar(8) DEFAULT NULL,
  `STEP_NAME` varchar(64) DEFAULT NULL,
  `VERSION` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wkf_workflow_step`
--

LOCK TABLES `wkf_workflow_step` WRITE;
/*!40000 ALTER TABLE `wkf_workflow_step` DISABLE KEYS */;
INSERT INTO `wkf_workflow_step` VALUES (2,NULL,'Montage','Trader','01','Create and montage document','France_v_0'),(3,NULL,'Analysis metier','Responsible','10','Validat by responsible','France_v_0'),(4,NULL,'Analysis risk','Risk control officer','20','Validat by risk','France_v_0'),(5,NULL,'Init','','00','Initial step','France_v_0'),(6,NULL,'Backoffice','Back office','40','Validat by backoffice','France_v_0');
/*!40000 ALTER TABLE `wkf_workflow_step` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-22 10:25:59
