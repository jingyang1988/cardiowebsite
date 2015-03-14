-- MySQL dump 10.13  Distrib 5.6.19, for Win64 (x86_64)
--
-- Host: localhost    Database: movedb
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `chartstatus`
--

DROP TABLE IF EXISTS `chartstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chartstatus` (
  `MRN` int(11) NOT NULL,
  `noChart` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`MRN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chartstatus`
--

LOCK TABLES `chartstatus` WRITE;
/*!40000 ALTER TABLE `chartstatus` DISABLE KEYS */;
INSERT INTO `chartstatus` VALUES (1,0);
/*!40000 ALTER TABLE `chartstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasememo`
--

DROP TABLE IF EXISTS `databasememo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databasememo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CreatedBy` varchar(255) DEFAULT NULL,
  `CreatedDate` datetime DEFAULT NULL,
  `Closed` tinyint(1) DEFAULT '0',
  `ClosedDate` datetime DEFAULT NULL,
  `MemoField` longtext,
  PRIMARY KEY (`ID`),
  KEY `ClosedDate` (`ClosedDate`,`CreatedDate`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasememo`
--

LOCK TABLES `databasememo` WRITE;
/*!40000 ALTER TABLE `databasememo` DISABLE KEYS */;
INSERT INTO `databasememo` VALUES (1,'Dan','2020-08-12 00:00:00',1,'2020-08-27 00:00:00','This is the new MEMO');
/*!40000 ALTER TABLE `databasememo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databaseuser`
--

DROP TABLE IF EXISTS `databaseuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databaseuser` (
  `UserName` varchar(255) DEFAULT NULL,
  `UserPassword` varchar(255) DEFAULT NULL,
  `UserId` varchar(45) NOT NULL,
  `RoleId` int(11) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databaseuser`
--

LOCK TABLES `databaseuser` WRITE;
/*!40000 ALTER TABLE `databaseuser` DISABLE KEYS */;
INSERT INTO `databaseuser` VALUES ('Sunday','pass4admin','admin',1,'Sunday.Campolo-Athans@stonybrookmedicine.edu');
/*!40000 ALTER TABLE `databaseuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dummymrn`
--

DROP TABLE IF EXISTS `dummymrn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dummymrn` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NextDummyMRN` int(11) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dummymrn`
--

LOCK TABLES `dummymrn` WRITE;
/*!40000 ALTER TABLE `dummymrn` DISABLE KEYS */;
INSERT INTO `dummymrn` VALUES (1,99999220),(2,1000);
/*!40000 ALTER TABLE `dummymrn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list  -treatmentsite`
--

DROP TABLE IF EXISTS `list  -treatmentsite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list  -treatmentsite` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `List-TreatmentSite` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list  -treatmentsite`
--

LOCK TABLES `list  -treatmentsite` WRITE;
/*!40000 ALTER TABLE `list  -treatmentsite` DISABLE KEYS */;
INSERT INTO `list  -treatmentsite` VALUES (100,'SBUH'),(200,'MSCKCC-Comack'),(300,'MSCKCC-NYC'),(400,'NSUH'),(500,'Winthrop'),(600,'Private MD'),(700,'Not Applicable'),(800,'Other');
/*!40000 ALTER TABLE `list  -treatmentsite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - alcohol`
--

DROP TABLE IF EXISTS `list - alcohol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - alcohol` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Alcohol` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - alcohol`
--

LOCK TABLES `list - alcohol` WRITE;
/*!40000 ALTER TABLE `list - alcohol` DISABLE KEYS */;
INSERT INTO `list - alcohol` VALUES (1,'Never'),(2,'<1 week'),(3,'weekly'),(4,'daily');
/*!40000 ALTER TABLE `list - alcohol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - biopsy types`
--

DROP TABLE IF EXISTS `list - biopsy types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - biopsy types` (
  `BiopsyNumber` int(11) NOT NULL DEFAULT '0',
  `BiopsyType` varchar(50) NOT NULL,
  PRIMARY KEY (`BiopsyNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - biopsy types`
--

LOCK TABLES `list - biopsy types` WRITE;
/*!40000 ALTER TABLE `list - biopsy types` DISABLE KEYS */;
INSERT INTO `list - biopsy types` VALUES (600,'Bronchoscopy (rigid/flexible)'),(700,'Wedge resection'),(750,'Wedge - thoracoscopic'),(770,'Surgical biopsy-not resection'),(800,'Lobectomy'),(810,'Bilobectomy'),(820,'Lobecotomy - Thoracoscopic'),(850,'Pneumonectomy'),(855,'Esophagectomy'),(860,'Thoracic Surgery - Other'),(900,'Mediastinoscopy'),(920,'Pericardial window/drainage'),(950,'Chamberlain\'s'),(1000,'Transthoracic Aspirate'),(1100,'Transthoracic Biopsy'),(1150,'PleurEx'),(1200,'Thoracentesis'),(1250,'Chest Tube/Pleurodesis'),(1300,'Needle Aspirate - Extrathoracic'),(1400,'Needle Biopsy - Extrathoracic'),(1500,'Sputum Cytology'),(1550,'EUS - Biopsy'),(1600,'Other - non-thoracic surgery'),(1700,'RFA'),(1800,'Cryotherapy'),(1900,'Stereotactic RT'),(2000,'Radiotherapy - chest'),(2100,'Radiotherapy - brain'),(2200,'Radiotherapy - other'),(2300,'Chemotheraphy'),(2400,'Bronchoscopy (rigid)'),(2500,'Bronchoscopy (flexible)');
/*!40000 ALTER TABLE `list - biopsy types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - biopsyaccuracy`
--

DROP TABLE IF EXISTS `list - biopsyaccuracy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - biopsyaccuracy` (
  `Biopsy Accuracy Number` int(11) NOT NULL DEFAULT '0',
  `Biopsy Accuracy` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Biopsy Accuracy Number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - biopsyaccuracy`
--

LOCK TABLES `list - biopsyaccuracy` WRITE;
/*!40000 ALTER TABLE `list - biopsyaccuracy` DISABLE KEYS */;
INSERT INTO `list - biopsyaccuracy` VALUES (1,'Unknown'),(100,'True Positive'),(200,'True Negative'),(400,'False Negative'),(500,'False Positive'),(600,'No biopsy');
/*!40000 ALTER TABLE `list - biopsyaccuracy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - biopsyresult`
--

DROP TABLE IF EXISTS `list - biopsyresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - biopsyresult` (
  `Biopsy Result ID` int(11) NOT NULL DEFAULT '0',
  `BiopsyResult` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Biopsy Result ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - biopsyresult`
--

LOCK TABLES `list - biopsyresult` WRITE;
/*!40000 ALTER TABLE `list - biopsyresult` DISABLE KEYS */;
INSERT INTO `list - biopsyresult` VALUES (1,'Diagnostic- Cancer'),(50,'No Biopsy'),(100,'Nondiagnostic'),(200,'Nondiagnostic - susp/atypia'),(300,'Nondiagnostic - inflammatory'),(400,'Nondiagnostic'),(500,'Diagnostic- Bengin'),(600,'Other');
/*!40000 ALTER TABLE `list - biopsyresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - bronch types`
--

DROP TABLE IF EXISTS `list - bronch types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - bronch types` (
  `BronchNumber` int(11) NOT NULL DEFAULT '0',
  `Bronch Type` varchar(50) NOT NULL,
  PRIMARY KEY (`BronchNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - bronch types`
--

LOCK TABLES `list - bronch types` WRITE;
/*!40000 ALTER TABLE `list - bronch types` DISABLE KEYS */;
INSERT INTO `list - bronch types` VALUES (50,'Bronchoscopy'),(100,'Wang Aspirate'),(200,'Wang Biopsy'),(300,'Transbronchial Bx'),(400,'Endobronchial Bx'),(500,'Brushing'),(550,'Wash'),(600,'BAL'),(700,'Flow cytometry'),(1800,'Brachytherapy'),(1900,'ERBE'),(1950,'Cautery/Snare'),(2000,'Rigid Palliation'),(2100,'Stent Placement'),(2200,'Balloon Dilation'),(2300,'Laser'),(2400,'Foreign Body'),(2500,'Trach change'),(3000,'other'),(3300,'Rigid Bronch');
/*!40000 ALTER TABLE `list - bronch types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - cancer status`
--

DROP TABLE IF EXISTS `list - cancer status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - cancer status` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `PatientCancerStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - cancer status`
--

LOCK TABLES `list - cancer status` WRITE;
/*!40000 ALTER TABLE `list - cancer status` DISABLE KEYS */;
INSERT INTO `list - cancer status` VALUES (100,'Alive - no evidence of cancer'),(200,'Alive - with suspected cancer'),(300,'Alive - with proven cancer'),(400,'Dead - cancer related'),(500,'Dead - non-cancer related');
/*!40000 ALTER TABLE `list - cancer status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - cancer therapy`
--

DROP TABLE IF EXISTS `list - cancer therapy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - cancer therapy` (
  `ID` int(11) DEFAULT '0',
  `Planned Cancer Treatment` varchar(50) DEFAULT NULL,
  UNIQUE KEY `ID` (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - cancer therapy`
--

LOCK TABLES `list - cancer therapy` WRITE;
/*!40000 ALTER TABLE `list - cancer therapy` DISABLE KEYS */;
INSERT INTO `list - cancer therapy` VALUES (100,'Surgical Resection alone'),(200,'Surgery with Neoadjuv/RT'),(300,'Surgery with Postadj/RT'),(400,'Chemo/RT'),(500,'Chemotherapy'),(600,'Palliative RT'),(700,'None'),(800,'Other'),(350,'SBRT'),(320,'RFA'),(330,'Cryo');
/*!40000 ALTER TABLE `list - cancer therapy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - cancer types`
--

DROP TABLE IF EXISTS `list - cancer types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - cancer types` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `TypeOfCancer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `TypeOfCancer` (`TypeOfCancer`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - cancer types`
--

LOCK TABLES `list - cancer types` WRITE;
/*!40000 ALTER TABLE `list - cancer types` DISABLE KEYS */;
INSERT INTO `list - cancer types` VALUES (100,'Non-small cell Lung'),(150,'Carcinoid'),(200,'Small cell lung cancer'),(300,'Non-Hodgkin\'s Lymphoma'),(400,'Hodgkin\'s Lymphoma'),(450,'Mesothelioma'),(500,'Metastatic Breast Cancer'),(600,'Metastatic GI Cancer'),(700,'Metastatic Other Cancer'),(800,'Other');
/*!40000 ALTER TABLE `list - cancer types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - cancerhisto`
--

DROP TABLE IF EXISTS `list - cancerhisto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - cancerhisto` (
  `Histology` varchar(50) NOT NULL,
  PRIMARY KEY (`Histology`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - cancerhisto`
--

LOCK TABLES `list - cancerhisto` WRITE;
/*!40000 ALTER TABLE `list - cancerhisto` DISABLE KEYS */;
INSERT INTO `list - cancerhisto` VALUES ('Adenocarcinoma'),('Adenosquamous'),('Bronchoalveolar carcinoma'),('Carcinoid'),('Carcinoid - Atypical'),('Clear cell carcinoma'),('Giant cell'),('Hodgkin\'s Lymphoma'),('Large cell'),('Mesothelioma'),('Neuroendocrine carcinoma'),('Non Small Cell'),('Non-Hodgkin\'s Lymphoma'),('Poorly differentiated'),('Renal cell carcinoma'),('Small cell carcinoma'),('Squamous cell'),('Transitional cell carcinoma');
/*!40000 ALTER TABLE `list - cancerhisto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - cancertxplan`
--

DROP TABLE IF EXISTS `list - cancertxplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - cancertxplan` (
  `CancerTherapyNum` int(11) NOT NULL AUTO_INCREMENT,
  `CancerTherapy` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CancerTherapyNum`),
  KEY `CancerTherapyNum` (`CancerTherapyNum`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - cancertxplan`
--

LOCK TABLES `list - cancertxplan` WRITE;
/*!40000 ALTER TABLE `list - cancertxplan` DISABLE KEYS */;
INSERT INTO `list - cancertxplan` VALUES (1,'Not evaluated'),(2,'Evaluted - not offered'),(3,'Treated'),(4,'Indicated - not candidate'),(5,'Indicated - declined'),(6,'Other');
/*!40000 ALTER TABLE `list - cancertxplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - complication`
--

DROP TABLE IF EXISTS `list - complication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - complication` (
  `Complication` varchar(50) DEFAULT NULL,
  KEY `Complication` (`Complication`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - complication`
--

LOCK TABLES `list - complication` WRITE;
/*!40000 ALTER TABLE `list - complication` DISABLE KEYS */;
INSERT INTO `list - complication` VALUES ('Cardiac Complication'),('Death'),('Hemoptysis'),('Other'),('Outpatient -> Admission'),('Pneumothorax and Chest Tube'),('Pneumothorax, no Chest Tube'),('Requiring ICU admission'),('Respiratory Failure');
/*!40000 ALTER TABLE `list - complication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - dailysupplements`
--

DROP TABLE IF EXISTS `list - dailysupplements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - dailysupplements` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Supplements` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - dailysupplements`
--

LOCK TABLES `list - dailysupplements` WRITE;
/*!40000 ALTER TABLE `list - dailysupplements` DISABLE KEYS */;
INSERT INTO `list - dailysupplements` VALUES (1,'None'),(2,'1-2 daily'),(3,'Multiple');
/*!40000 ALTER TABLE `list - dailysupplements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - education`
--

DROP TABLE IF EXISTS `list - education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - education` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Education` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - education`
--

LOCK TABLES `list - education` WRITE;
/*!40000 ALTER TABLE `list - education` DISABLE KEYS */;
INSERT INTO `list - education` VALUES (1,'<8'),(2,'8-11'),(3,'High School Grad'),(4,'Some College'),(5,'College Grad'),(6,'Mater\'s'),(7,'Doctorate');
/*!40000 ALTER TABLE `list - education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - foodtime`
--

DROP TABLE IF EXISTS `list - foodtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - foodtime` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FoodTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - foodtime`
--

LOCK TABLES `list - foodtime` WRITE;
/*!40000 ALTER TABLE `list - foodtime` DISABLE KEYS */;
INSERT INTO `list - foodtime` VALUES (1,'more than 1/day'),(2,'1/day'),(3,'2-3/week'),(4,'1 week'),(5,'<1 week');
/*!40000 ALTER TABLE `list - foodtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - groundzero`
--

DROP TABLE IF EXISTS `list - groundzero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - groundzero` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GroundZero` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - groundzero`
--

LOCK TABLES `list - groundzero` WRITE;
/*!40000 ALTER TABLE `list - groundzero` DISABLE KEYS */;
INSERT INTO `list - groundzero` VALUES (1,'On 9/11'),(2,'At Cleanup'),(3,'No Ground Zero');
/*!40000 ALTER TABLE `list - groundzero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - insurance`
--

DROP TABLE IF EXISTS `list - insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - insurance` (
  `InsurCo` varchar(50) NOT NULL,
  `Phone Number1` varchar(50) DEFAULT NULL,
  `Phone Number2` varchar(50) DEFAULT NULL,
  `Phone Number3` varchar(50) DEFAULT NULL,
  `Comment` varchar(50) DEFAULT NULL,
  `CTPrecert` varchar(50) DEFAULT 'Some',
  `PETPrecert` varchar(50) DEFAULT 'Some',
  `PFTPrecert` varchar(50) DEFAULT 'Some',
  `VisitReferral` varchar(50) DEFAULT 'Some',
  PRIMARY KEY (`InsurCo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - insurance`
--

LOCK TABLES `list - insurance` WRITE;
/*!40000 ALTER TABLE `list - insurance` DISABLE KEYS */;
INSERT INTO `list - insurance` VALUES ('1199',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Aetna',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Affinity',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Beech',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Blue  Shield Senior Care',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Blue Shield Basic',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Blue Shield Commercial',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Cap Healthfirst',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Cap US Health',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Cigna HMO',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Cigna PPO',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Commercial Insurance',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Empire Blue Cross',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Empire Blue HMO',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Empire Blue PPO',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Empire Blue Senior',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('First Health',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('GHI',NULL,NULL,NULL,NULL,'All','All','Some','Some'),('Health First FFS',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Health Net',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('HealthCare Partners',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('HealthFirst',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('HIP',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('HIP VIP',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Horizon Healthcare',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Island Group Admin',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('JJ Newman',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Magnacare',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('MDNY',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Medicaid Managed Care',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Medicare',NULL,NULL,NULL,NULL,'Never','Never','Never','Never'),('Medicare:Coordinate Care',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Met Empire',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('MMIS',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('New Island',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('NYLCare',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('OTHER',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Oxford',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Oxford Medicare',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Self Pay',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Sierra',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('State Agency',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Suffolk Health Plan',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('United AmeriChoice Govt',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('United HealthCare',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('United HealthCare NonPar',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('UP and UP/America\'s',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('US Health Global',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('US Healthcare',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Vytra VHLIVHS',NULL,NULL,NULL,NULL,'Some','Some','Some','Some'),('Workman\'s Comp',NULL,NULL,NULL,NULL,'Some','Some','Some','Some');
/*!40000 ALTER TABLE `list - insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - lesionclassification`
--

DROP TABLE IF EXISTS `list - lesionclassification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - lesionclassification` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `LesionClassification` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `LesionClassification` (`LesionClassification`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - lesionclassification`
--

LOCK TABLES `list - lesionclassification` WRITE;
/*!40000 ALTER TABLE `list - lesionclassification` DISABLE KEYS */;
INSERT INTO `list - lesionclassification` VALUES (100,'Nodule <= 4mm'),(200,'Nodule >4-6 mm'),(250,'Nodule >6-8 mm'),(300,'Nodule >8-14 mm'),(400,'Nodule >14-29 mm'),(500,'Mass >29 mm'),(550,'GroundGlass 4-6 mm'),(560,'GroundGlass >6-8 mm'),(570,'GroundGlass >8 mm'),(600,'Multiple nodules'),(700,'Mediastinal nodes'),(750,'Mediastinal mass'),(800,'Hilar nodes'),(900,'Effusion'),(1000,'Post-resection'),(1100,'Infiltrate'),(1200,'Airway Lesion'),(1300,'Known lung cancer'),(1400,'Ctrax undefined'),(1500,'Other'),(410,'Nodule 8mm-2cm'),(420,'Nodule 2cm-3cm'),(430,'Nodule 3cm-7cm'),(440,'Nodule > 7cm');
/*!40000 ALTER TABLE `list - lesionclassification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - lesionctcharac`
--

DROP TABLE IF EXISTS `list - lesionctcharac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - lesionctcharac` (
  `CT Characteristic` varchar(50) NOT NULL,
  PRIMARY KEY (`CT Characteristic`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - lesionctcharac`
--

LOCK TABLES `list - lesionctcharac` WRITE;
/*!40000 ALTER TABLE `list - lesionctcharac` DISABLE KEYS */;
INSERT INTO `list - lesionctcharac` VALUES ('Cavitary'),('Densely Calcified'),('Ground Glass opacity'),('Infiltrate'),('Necrotic'),('Nodular'),('Partially calcified'),('Smooth'),('Spiculated');
/*!40000 ALTER TABLE `list - lesionctcharac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - lesiondiagnosis`
--

DROP TABLE IF EXISTS `list - lesiondiagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - lesiondiagnosis` (
  `LesionDiagnosisNumber` int(11) NOT NULL DEFAULT '0',
  `LesionDiagnosis` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`LesionDiagnosisNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - lesiondiagnosis`
--

LOCK TABLES `list - lesiondiagnosis` WRITE;
/*!40000 ALTER TABLE `list - lesiondiagnosis` DISABLE KEYS */;
INSERT INTO `list - lesiondiagnosis` VALUES (100,'Stable at 2 year follow-up'),(150,'PostResection F/U'),(200,'Pathologically bengin'),(300,'Non-small cell cancer'),(350,'Small cell cancer'),(380,'Metastatic carcinoma'),(400,'Inflammatory lesion'),(500,'Pneumonic residua'),(600,'Granulomatous infection'),(700,'Vasculitis'),(800,'Other');
/*!40000 ALTER TABLE `list - lesiondiagnosis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - lesionrisk`
--

DROP TABLE IF EXISTS `list - lesionrisk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - lesionrisk` (
  `LesionRiskNum` int(11) NOT NULL DEFAULT '0',
  `LesionRiskStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`LesionRiskNum`),
  KEY `LesionRiskNum` (`LesionRiskNum`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - lesionrisk`
--

LOCK TABLES `list - lesionrisk` WRITE;
/*!40000 ALTER TABLE `list - lesionrisk` DISABLE KEYS */;
INSERT INTO `list - lesionrisk` VALUES (100,'Low Risk'),(200,'Medium Risk'),(300,'High Risk');
/*!40000 ALTER TABLE `list - lesionrisk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - location`
--

DROP TABLE IF EXISTS `list - location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - location` (
  `Biopsy Location Number` int(11) NOT NULL DEFAULT '0',
  `Biopsy Location` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Biopsy Location Number`),
  KEY `Biopsy Location` (`Biopsy Location`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - location`
--

LOCK TABLES `list - location` WRITE;
/*!40000 ALTER TABLE `list - location` DISABLE KEYS */;
INSERT INTO `list - location` VALUES (50,'RUL'),(70,'RML'),(100,'RLL'),(200,'R hilum'),(300,'R bronchus'),(400,'LUL'),(500,'L lingula'),(600,'LLL'),(700,'L hilum'),(800,'L bronchus'),(820,'Carina'),(850,'Trachea'),(880,'Bilateral Lung'),(900,'Node R paratracheal'),(1000,'Node L paratracheal'),(1050,'Node Precarinal'),(1100,'Node Subcarinal'),(1200,'Node Subsubcarinal'),(1300,'Node R upper hilum'),(1400,'Node R lower hilum'),(1500,'Node L hilum'),(1510,'Node AP window'),(1520,'Mediastinum'),(1550,'Pleural - Right'),(1580,'Pleural - Left'),(1600,'Other N2 - Node'),(1700,'Other N3 - Node'),(1800,'Other Thoracic'),(1900,'Other Extrathoracic'),(1750,'Esophagus'),(1780,'Thymus'),(2000,'Diaphragm');
/*!40000 ALTER TABLE `list - location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - medicationdoseunit`
--

DROP TABLE IF EXISTS `list - medicationdoseunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - medicationdoseunit` (
  `DoseUnitID` int(11) NOT NULL DEFAULT '0',
  `Dose Unit` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`DoseUnitID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - medicationdoseunit`
--

LOCK TABLES `list - medicationdoseunit` WRITE;
/*!40000 ALTER TABLE `list - medicationdoseunit` DISABLE KEYS */;
INSERT INTO `list - medicationdoseunit` VALUES (0,'Applicatorfuls'),(1,'Bags'),(2,'Bars'),(3,'Capsules'),(4,'Doses'),(5,'Dropperfuls'),(6,'Drops'),(7,'Grams(g)'),(8,'Inhalations'),(9,'Lozenges'),(10,'Micrograms(mcg)'),(11,'Milligrams(mg)'),(12,'Milliliters(ml)'),(13,'Packets'),(14,'Pads'),(15,'Patches'),(16,'Percent(%)'),(17,'Puffs'),(18,'Scoops'),(19,'Shots'),(20,'Sprays'),(21,'Suppositories'),(22,'Syringe'),(23,'Tablespoons(tbsp)'),(24,'Tablets'),(25,'Teaspoons(tsp)');
/*!40000 ALTER TABLE `list - medicationdoseunit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - medicationhowtaken`
--

DROP TABLE IF EXISTS `list - medicationhowtaken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - medicationhowtaken` (
  `HowTakenID` int(11) NOT NULL DEFAULT '0',
  `How Taken` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`HowTakenID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - medicationhowtaken`
--

LOCK TABLES `list - medicationhowtaken` WRITE;
/*!40000 ALTER TABLE `list - medicationhowtaken` DISABLE KEYS */;
INSERT INTO `list - medicationhowtaken` VALUES (0,'By injection'),(1,'By mouth'),(2,'in the ear'),(3,'in the eye'),(4,'in the nose(spray/drops)'),(5,'Inhaled'),(6,'Rectal'),(7,'Through a feeding tube'),(8,'Through an intravenous(IV) line'),(9,'Through the skin'),(10,'Under the tongue'),(11,'Vaginal');
/*!40000 ALTER TABLE `list - medicationhowtaken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - medicationstrengthunit`
--

DROP TABLE IF EXISTS `list - medicationstrengthunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - medicationstrengthunit` (
  `StrengthUnitID` int(11) NOT NULL DEFAULT '0',
  `Strength Unit` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`StrengthUnitID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - medicationstrengthunit`
--

LOCK TABLES `list - medicationstrengthunit` WRITE;
/*!40000 ALTER TABLE `list - medicationstrengthunit` DISABLE KEYS */;
INSERT INTO `list - medicationstrengthunit` VALUES (0,'Colony forming units per milliliter (cfu/ml)'),(1,'International unit (iu)'),(3,'Milliequivalent (meq)'),(4,'Milliequivalent per milliliter (meq/ml)'),(5,'Milligram (mg)'),(6,'Milligram per milliliter (mg/ml)'),(7,'Milliliter (ml)'),(8,'Percent (%)'),(9,'Unit (unt)'),(10,'Units per milliliter (unt/ml)');
/*!40000 ALTER TABLE `list - medicationstrengthunit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - medicinegiventype`
--

DROP TABLE IF EXISTS `list - medicinegiventype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - medicinegiventype` (
  `GivenTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `Given Type` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`GivenTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - medicinegiventype`
--

LOCK TABLES `list - medicinegiventype` WRITE;
/*!40000 ALTER TABLE `list - medicinegiventype` DISABLE KEYS */;
INSERT INTO `list - medicinegiventype` VALUES (1,'Over The Counter'),(2,'Prescribed OTC'),(3,'Prescribed');
/*!40000 ALTER TABLE `list - medicinegiventype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - patientstatus`
--

DROP TABLE IF EXISTS `list - patientstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - patientstatus` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `Active-Inactive` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - patientstatus`
--

LOCK TABLES `list - patientstatus` WRITE;
/*!40000 ALTER TABLE `list - patientstatus` DISABLE KEYS */;
INSERT INTO `list - patientstatus` VALUES (10,'Not yet seen'),(50,'Active'),(100,'Inactive - Xray F/U complete'),(150,'Inactive - No lung cancer, referred'),(200,'Inactive - Resected F/U complete'),(300,'Patient left practice'),(400,'Moved out of state'),(500,'Expired'),(600,'Other'),(700,'Never LCEC - seen as inpatient'),(800,'Never LCEC - outside MD'),(900,'Never LCEC - other');
/*!40000 ALTER TABLE `list - patientstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - physician-referring`
--

DROP TABLE IF EXISTS `list - physician-referring`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - physician-referring` (
  `Referring Physican` varchar(50) NOT NULL,
  `Title` varchar(2) DEFAULT 'MD',
  `Group Name` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(2) DEFAULT 'NY',
  `Zip` varchar(50) DEFAULT NULL,
  `Office Phone` varchar(50) DEFAULT NULL,
  `Additional Phone` varchar(50) DEFAULT NULL,
  `Fax` varchar(50) DEFAULT NULL,
  `RequestFax` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`Referring Physican`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - physician-referring`
--

LOCK TABLES `list - physician-referring` WRITE;
/*!40000 ALTER TABLE `list - physician-referring` DISABLE KEYS */;
INSERT INTO `list - physician-referring` VALUES ('Smith, John',NULL,NULL,'123 Main St','New York','NY','11111','(111) 111-1111',NULL,NULL,1);
/*!40000 ALTER TABLE `list - physician-referring` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - physicians-lcec`
--

DROP TABLE IF EXISTS `list - physicians-lcec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - physicians-lcec` (
  `LCEC - Physician` varchar(50) NOT NULL,
  PRIMARY KEY (`LCEC - Physician`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - physicians-lcec`
--

LOCK TABLES `list - physicians-lcec` WRITE;
/*!40000 ALTER TABLE `list - physicians-lcec` DISABLE KEYS */;
INSERT INTO `list - physicians-lcec` VALUES ('Smith, John');
/*!40000 ALTER TABLE `list - physicians-lcec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - physicians-treating`
--

DROP TABLE IF EXISTS `list - physicians-treating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - physicians-treating` (
  `Treating Physican` varchar(50) NOT NULL,
  `Title` varchar(2) DEFAULT 'MD',
  `Group` varchar(50) DEFAULT NULL,
  `StonyBrook?` tinyint(1) DEFAULT '0',
  `Address` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(2) DEFAULT 'NY',
  `Zip` varchar(50) DEFAULT NULL,
  `Office Phone` varchar(50) DEFAULT NULL,
  `Additional Phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Treating Physican`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - physicians-treating`
--

LOCK TABLES `list - physicians-treating` WRITE;
/*!40000 ALTER TABLE `list - physicians-treating` DISABLE KEYS */;
INSERT INTO `list - physicians-treating` VALUES ('Smith, John','MD',NULL,0,NULL,NULL,'NY',NULL,NULL,NULL);
/*!40000 ALTER TABLE `list - physicians-treating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - plan made at visit`
--

DROP TABLE IF EXISTS `list - plan made at visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - plan made at visit` (
  `AutoNumber` int(11) NOT NULL DEFAULT '0',
  `Plan Made At Visit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AutoNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - plan made at visit`
--

LOCK TABLES `list - plan made at visit` WRITE;
/*!40000 ALTER TABLE `list - plan made at visit` DISABLE KEYS */;
INSERT INTO `list - plan made at visit` VALUES (100,'Xray - Serial Follow-Up'),(150,'PET scan'),(200,'Biopsy'),(220,'Preop testing'),(250,'Chemo/RT referral'),(260,'Neoadjuvant referral'),(300,'Resection'),(350,'Post-resection follow-up'),(400,'Xray - Short-term follow-up'),(500,'Discharge from Clinic'),(600,'Discuss with other MD'),(700,'Obtain Old Films'),(800,'PFT\'s/Stress Test'),(900,'Other');
/*!40000 ALTER TABLE `list - plan made at visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - race`
--

DROP TABLE IF EXISTS `list - race`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - race` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `RaceName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - race`
--

LOCK TABLES `list - race` WRITE;
/*!40000 ALTER TABLE `list - race` DISABLE KEYS */;
INSERT INTO `list - race` VALUES (1,'White'),(2,'Black'),(3,'Hispanic'),(4,'Native American'),(5,'Asian'),(6,'Other');
/*!40000 ALTER TABLE `list - race` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - researchproject`
--

DROP TABLE IF EXISTS `list - researchproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - researchproject` (
  `ResearchProjNum` int(11) NOT NULL AUTO_INCREMENT,
  `ReserachProject` varchar(50) DEFAULT NULL,
  `PI` varchar(50) DEFAULT NULL,
  `CORIHS number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ResearchProjNum`),
  KEY `ResearchProjNum` (`ResearchProjNum`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - researchproject`
--

LOCK TABLES `list - researchproject` WRITE;
/*!40000 ALTER TABLE `list - researchproject` DISABLE KEYS */;
INSERT INTO `list - researchproject` VALUES (3,'Lung Cancer Registry','Baram',NULL);
/*!40000 ALTER TABLE `list - researchproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - screening`
--

DROP TABLE IF EXISTS `list - screening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - screening` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Screening` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - screening`
--

LOCK TABLES `list - screening` WRITE;
/*!40000 ALTER TABLE `list - screening` DISABLE KEYS */;
INSERT INTO `list - screening` VALUES (1,'UpToDate'),(2,'Not UpToDate'),(3,'N/A');
/*!40000 ALTER TABLE `list - screening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - smokingstatus`
--

DROP TABLE IF EXISTS `list - smokingstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - smokingstatus` (
  `SmokingStatusNum` int(11) NOT NULL AUTO_INCREMENT,
  `SmokingStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SmokingStatusNum`),
  KEY `SmokingStatusNum` (`SmokingStatusNum`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - smokingstatus`
--

LOCK TABLES `list - smokingstatus` WRITE;
/*!40000 ALTER TABLE `list - smokingstatus` DISABLE KEYS */;
INSERT INTO `list - smokingstatus` VALUES (1,'Smoker'),(2,'Smoker - trying to quit'),(3,'Ex-smoker'),(4,'Never smoker');
/*!40000 ALTER TABLE `list - smokingstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - stage m`
--

DROP TABLE IF EXISTS `list - stage m`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - stage m` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `M - stage` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - stage m`
--

LOCK TABLES `list - stage m` WRITE;
/*!40000 ALTER TABLE `list - stage m` DISABLE KEYS */;
INSERT INTO `list - stage m` VALUES (100,'M0 - no mets'),(200,'M1 - mets'),(300,'Mx - not assessed');
/*!40000 ALTER TABLE `list - stage m` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - stage n`
--

DROP TABLE IF EXISTS `list - stage n`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - stage n` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `N - stage` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - stage n`
--

LOCK TABLES `list - stage n` WRITE;
/*!40000 ALTER TABLE `list - stage n` DISABLE KEYS */;
INSERT INTO `list - stage n` VALUES (100,'N0 - no nodes'),(200,'N1 - ipsilateral hilar'),(300,'N2 - ipsilateral mediastinal'),(400,'N3 - contralateral/supraclav'),(500,'Nx - not assessed');
/*!40000 ALTER TABLE `list - stage n` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - stage t`
--

DROP TABLE IF EXISTS `list - stage t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - stage t` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `T - stage` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - stage t`
--

LOCK TABLES `list - stage t` WRITE;
/*!40000 ALTER TABLE `list - stage t` DISABLE KEYS */;
INSERT INTO `list - stage t` VALUES (100,'*T1 - <3cm'),(200,'*T2 - >3cm'),(210,'*T2 - Main bronchus'),(220,'*T2 - Lobar atelectasis'),(230,'*T2 - To visceral pleura'),(300,'*T3 - Chest wall/diaphragm'),(310,'*T3 - Into visceral pleural'),(320,'*T3 - Into pericardium'),(330,'*T3 - Main bronchus'),(340,'*T3 - Lung atlectasis'),(400,'*T4 - carinal'),(410,'*T4 - malignant effusion'),(420,'*T4 - into mediastinum'),(430,'*T4 - into great vessels'),(450,'*T4 - nodule in same lobe'),(500,'*Tis - in site, non-invasive'),(600,'*Tx - not assessed'),(101,'T1a - tumor <=2cm'),(102,'T1b - tumor >2cm but <=3cm'),(231,'T2a - (>3cm but <=5cm) involves main bronchus/ >=2cm distal to carina'),(232,'T2a - (>3cm bur <=5cm) invades visceral pleura'),(233,'T2a - (>3cm but <=5cm) atelectasis/obstructive pneumonitis'),(234,'T2b - (>5cm <=7cm) involves main bronchus/>=2cm distal to carina'),(235,'T2b - (>5cm <=7cm) invades visceral pleura'),(236,'T2b - (>5cm <=7cm) atelectasis/obstructive pneumonitis'),(341,'T3 - tumor > 7cm'),(342,'T3 - directly invaades parietal pleura'),(343,'T3 - directly invades chest wall/superior sulcas'),(344,'T3 - directly invades diaphragm/phrenic nerv'),(345,'T3 - directly invades mediastinal pleura / parietal pericardium'),(346,'T3 - atelectasis/pneumonitis entire lung'),(347,'T3 - in main bronchus'),(348,'T3 - separate tumor in same lobe'),(451,'T4 - any size invading heart / mediastinum/great vessels'),(452,'T4 - any size invading trachea/esophagus/vertebral body/carina'),(453,'T4 - separate nodule(s) in different ipsilateral lobe');
/*!40000 ALTER TABLE `list - stage t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - stagetnm`
--

DROP TABLE IF EXISTS `list - stagetnm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - stagetnm` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `Stage - TNM` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - stagetnm`
--

LOCK TABLES `list - stagetnm` WRITE;
/*!40000 ALTER TABLE `list - stagetnm` DISABLE KEYS */;
INSERT INTO `list - stagetnm` VALUES (100,'*IA - T1N0M0'),(200,'*IB - T2N0M0'),(300,'*IIA - T1N1M0'),(400,'*IIB - T2N1M0'),(420,'*IIB - T3N0M0'),(500,'*IIIA - T1N2M0'),(520,'*IIIA - T2N2M0'),(530,'*IIIA - T3N1M0'),(540,'*IIIA - T3N2M0'),(600,'*IIIB - T4NxM0'),(610,'*IIIB - TxN3M0'),(700,'*IV - TxNxM1'),(101,'IA - T1aN0M0'),(102,'IA - T1bN0M0'),(201,'IB - T2aN0M0'),(301,'IIA - T2bN0M0'),(302,'IIA - T1aN1M0'),(303,'IIA - T1bN1M0'),(304,'IIA - T2aN1M0'),(421,'IIB - T2bN1M0'),(422,'IIB - T3N0M0'),(541,'IIIA - T1aN2M0'),(542,'IIIA - T1bN2M0'),(543,'IIIA - T2aN2M0'),(544,'IIIA - T2bN2M0'),(545,'IIIA - T3N1M0'),(546,'IIIA - T3N2M0'),(547,'IIIA - T4N0M0'),(548,'IIIA - T4N1M0'),(612,'IIIB - T1aN3M0'),(613,'IIIB - T1bN3M0'),(614,'IIIB - T2aN3M0'),(615,'IIIB - T2bN3M0'),(616,'IIIB - T3N3M0'),(617,'IIIB - T4N2M0'),(618,'IIIB - T4N3M0'),(701,'IV - AnyTAnyNM1a'),(702,'IV - AnyTAnyNM1b');
/*!40000 ALTER TABLE `list - stagetnm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - testtypes`
--

DROP TABLE IF EXISTS `list - testtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - testtypes` (
  `Autonumber` int(11) NOT NULL DEFAULT '0',
  `TestingType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Autonumber`),
  UNIQUE KEY `TestingType` (`TestingType`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - testtypes`
--

LOCK TABLES `list - testtypes` WRITE;
/*!40000 ALTER TABLE `list - testtypes` DISABLE KEYS */;
INSERT INTO `list - testtypes` VALUES (100,'CT - Chest'),(110,'CT Chest - contrast'),(150,'CT - NonChest'),(200,'PET'),(250,'Chest Xray'),(255,'Xray-Bone Films'),(300,'Cardiac ECHO'),(400,'Cardiac Stress'),(500,'Cardiac Cath'),(550,'Cardiac CABG'),(600,'PFT'),(610,'PFT-ABG'),(700,'CPX'),(750,'Blood - CBC'),(760,'Blood - Chem8'),(770,'Blood - Hepatic'),(772,'Blood - Tumor Markers'),(775,'Blood - Inflammatory Profile'),(780,'Blood - Coags'),(790,'Sputum Micro'),(800,'MRI Brain'),(820,'MRI - Thorax'),(850,'MRI - Spine'),(860,'MRI - Other'),(900,'MRA'),(1000,'Four quadrant perfusion'),(1050,'Bone Scan'),(1100,'Ultrasound'),(1150,'Doppler'),(1200,'PreOp Testing'),(1210,'Consult-Cards'),(1220,'Consult-GI'),(1225,'Consult-Pulm'),(1227,'Consult-ID'),(1230,'Consult-Surgery'),(1235,'Consult-Plastics'),(1240,'Consult-Rheum'),(1245,'Consult-Neuro'),(1250,'Consult-Nsurg'),(1260,'Colonoscopy'),(1270,'EGD'),(1280,'Consult-ENT'),(1285,'Consult-Other'),(1300,'PPD'),(1310,'Pulmonary Rehab'),(1350,'Visit - Pleurx'),(1360,'Visit - Stent'),(1370,'Visit - Other'),(1390,'Get Old Records'),(1400,'Other'),(120,'CT chest 10W dose'),(130,'CT chest super');
/*!40000 ALTER TABLE `list - testtypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - visttypes`
--

DROP TABLE IF EXISTS `list - visttypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - visttypes` (
  `TypeNumber` int(11) NOT NULL DEFAULT '0',
  `Visit Type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TypeNumber`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - visttypes`
--

LOCK TABLES `list - visttypes` WRITE;
/*!40000 ALTER TABLE `list - visttypes` DISABLE KEYS */;
INSERT INTO `list - visttypes` VALUES (100,'New Consultation'),(200,'Second Opinion'),(400,'Follow Up  Xray Results'),(450,'Follow Up Biopsy Result'),(500,'Discussion with Family'),(600,'Hospital Follow-Up'),(700,'PreOperative'),(800,'Post-Op Visit'),(820,'Support Group'),(850,'Inpatient Encounter'),(900,'Other');
/*!40000 ALTER TABLE `list - visttypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list - workupstatus`
--

DROP TABLE IF EXISTS `list - workupstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list - workupstatus` (
  `WorkUpStatusNum` int(11) NOT NULL DEFAULT '0',
  `WorkUpStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`WorkUpStatusNum`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list - workupstatus`
--

LOCK TABLES `list - workupstatus` WRITE;
/*!40000 ALTER TABLE `list - workupstatus` DISABLE KEYS */;
INSERT INTO `list - workupstatus` VALUES (100,'Not Yet Seen'),(200,'Initial Workup'),(225,'PRIORITY LIST'),(250,'Xray F/U'),(300,'Neoadjuvant'),(400,'Preoperative'),(450,'Getting 2nd opinion'),(500,'Chemo/RT referral'),(550,'Tracheal stenosis'),(600,'Post-op with adjuvant'),(700,'Post-op no adjuvant'),(710,'post cryo/RFA/SBRT'),(720,'Post-op, no cancer'),(750,'Off Therapy/Hospice'),(800,'Expired'),(850,'Lost to follow-up'),(900,'Inactive');
/*!40000 ALTER TABLE `list - workupstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listtestresult`
--

DROP TABLE IF EXISTS `listtestresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listtestresult` (
  `AutoNum` int(11) NOT NULL AUTO_INCREMENT,
  `TestingType` int(11) DEFAULT '0',
  `TestingTypeSortNum` int(11) DEFAULT '0',
  `Result` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AutoNum`),
  KEY `TestingType` (`TestingType`,`TestingTypeSortNum`),
  KEY `TestingTypeSortNum` (`TestingTypeSortNum`)
) ENGINE=MyISAM AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listtestresult`
--

LOCK TABLES `listtestresult` WRITE;
/*!40000 ALTER TABLE `listtestresult` DISABLE KEYS */;
INSERT INTO `listtestresult` VALUES (1,1280,100,'Performed'),(2,1280,200,'Lesion seen'),(3,1280,300,'Procedure planned'),(7,750,100,'Normal / unchanged'),(8,750,200,'Other'),(9,200,100,'No  uptake'),(10,200,200,'SUV >0 but <2 in lesion'),(11,200,300,'SUV > 2 in lesion'),(12,200,400,'SUV 0-2 in multiple lesions'),(13,200,500,'SUV >2 in multiple lesions'),(14,200,600,'(+)SUV in lesion and nodes'),(15,200,700,'(+) SUV in lesion and outside of chest'),(16,200,800,'uptake only outside of chest'),(17,300,100,'Normal'),(18,300,200,'Mildly reduced LV Function'),(19,300,300,'Severely reduced LV function'),(20,300,400,'Regional wall motion abnormalities'),(21,300,500,'Valvular'),(24,600,200,'obstructed'),(25,600,300,'restricted'),(26,700,100,'VO2max<10ml/min (Enter as comment)'),(27,700,200,'VO2max 10-15ml/min (Enter as comment)'),(28,700,300,'VO2max >15 ml/min (Enter as comment)'),(29,400,100,'Normal'),(30,400,200,'Mild Reversible'),(31,400,300,'Mod Reversible'),(32,400,400,'Irreversible'),(33,500,100,'normal'),(34,500,200,'CAD, stent'),(35,500,300,'CAD, no stent'),(36,500,400,'needs CABG'),(37,500,500,'Valvular disease'),(40,1000,100,'Equal perfusion all lobes'),(41,100,100,'No change in lesion'),(42,100,200,'Possible change - larger/more dense?'),(43,100,300,'New lesion'),(44,100,400,'Growth in nodule/mass'),(45,100,500,'Evidence of new nodes/mets'),(46,100,600,'Evidence of airway disease/COPD'),(47,100,700,'Other (enter comment)'),(48,150,100,'No evidence of cancer'),(49,150,200,'Stable mets'),(50,150,300,'Non-malignant lesions'),(51,150,400,'Other'),(57,250,100,'No significant change'),(58,250,200,'Evidence of CHF/cardiac disease'),(59,250,300,'Pneumothorax'),(60,250,400,'Pneumonia'),(61,250,500,'Other'),(62,760,100,'Normal'),(63,760,200,'Stable renal failure'),(64,760,300,'New/worsened renal function'),(65,760,400,'Abnormal electrolytes'),(66,770,100,'Normal'),(67,770,200,'Abnormal LFT\'s'),(68,770,300,'Other'),(72,772,100,'Normal'),(73,772,200,'Mild elevation'),(74,772,300,'Severe elevation'),(75,775,100,'normal'),(76,775,200,'ANCA +'),(77,775,300,'RF/ANA +'),(78,775,400,'Other +'),(79,780,100,'Normal'),(80,780,200,'INR 1.3-2.0'),(81,780,300,'INR >2.0'),(82,780,400,'INR nl, but PTT abnl'),(83,780,500,'Other'),(84,800,100,'Normal'),(85,800,200,'1 Met'),(86,800,300,'Multiple mets'),(87,800,400,'Non-malignant: CVA'),(88,800,500,'Non-malignant: other'),(89,800,600,'Brain tumor'),(90,800,700,'Non-malignant'),(91,850,100,'Normal'),(92,850,200,'Brachial plexus involvement'),(93,850,300,'Chest wall involvement'),(94,850,400,'Other'),(95,820,100,'Normal'),(96,820,200,'Other'),(97,1000,200,'Other'),(98,1050,100,'Normal'),(99,1050,200,'Uptake c/w cancer'),(100,1050,300,'Uptake ?cancer'),(101,1050,400,'Uptake not c/w cancer'),(102,1050,500,'Other'),(103,1200,100,'Clearance given'),(104,1200,200,'Not cleared'),(105,1200,300,'Other'),(106,1210,100,'OK'),(107,1210,200,'Further testing needed'),(108,600,100,'Normal'),(109,600,250,'COPD - Emphysema'),(110,600,220,'COPD - Normal Diffusion'),(111,1300,100,'Negative'),(112,1300,200,'Positive - CXR normal'),(113,1300,300,'Positive - active TB'),(114,1300,400,'Positive - old TB'),(115,1300,500,'Positive - workup in progress'),(117,1400,10,'Normal'),(118,1400,20,'Abnormal'),(119,255,100,'Normal'),(120,255,200,'Bone mets'),(121,255,300,'Other'),(122,550,100,'Performed'),(123,550,200,'Other'),(124,610,100,'Normal'),(125,610,200,'Hypercapnic'),(126,610,300,'Other'),(127,860,100,'Normal'),(128,860,200,'Abnormal'),(129,1100,100,'Normal'),(130,1100,200,'Abnormal'),(131,1150,100,'No DVT'),(132,1150,200,'DVT'),(133,1150,300,'Arterial disease'),(134,1220,100,'Normal / cleared'),(135,1220,200,'Procedure planned'),(136,1225,100,'Performed'),(137,1225,200,'Accepted into clinic'),(138,1227,100,'Performed'),(140,1230,100,'Procedure planned'),(141,1230,200,'Seen'),(142,1235,100,'Seen in consult'),(143,1240,100,'Seen in consult'),(144,1240,200,'Will follow'),(145,1245,100,'Consult'),(146,1250,100,'Consult performed'),(147,1250,200,'Procedure planned'),(148,1260,100,'Normal'),(149,1260,200,'Lesion seen'),(150,1270,100,'Normal'),(151,1270,200,'Lesion seen'),(152,1285,100,'Seen'),(153,1285,200,'See comment'),(154,1310,100,'In process'),(155,1310,200,'Finished'),(156,100,150,'Stable'),(158,600,400,'Other'),(159,700,400,'Other'),(160,100,650,'Resolved'),(161,110,100,'No change in nodule'),(162,110,150,'Stable'),(163,110,300,'Possible change/more dense'),(164,110,400,'Growth in nodule'),(165,110,500,'New nodules/mets'),(166,110,600,'Emphysema/COPD'),(167,110,650,'Resolved'),(168,110,700,'Other (specify)'),(169,100,640,'Resolving'),(170,110,640,'Resolving'),(171,760,150,'Mild renal insufficiency'),(172,100,250,'Decreased size'),(173,110,250,'Decreased size'),(174,110,200,'Possible larger/denser'),(175,790,10,'No growth'),(176,790,20,'Multiple bacteria'),(177,790,30,'AFB smear/culture positive'),(178,790,40,'AFB smear negative/culture positive'),(179,300,600,'Other'),(180,200,350,'Uptake in lymph nodes only'),(181,200,900,'other'),(182,400,500,'Other');
/*!40000 ALTER TABLE `listtestresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listtreatment`
--

DROP TABLE IF EXISTS `listtreatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `listtreatment` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `Treatment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listtreatment`
--

LOCK TABLES `listtreatment` WRITE;
/*!40000 ALTER TABLE `listtreatment` DISABLE KEYS */;
INSERT INTO `listtreatment` VALUES (200,'SBRT'),(400,'RT - spot'),(500,'RT - curative'),(600,'Chemo - neoadjuvant'),(700,'Chemo - adjuvant'),(800,'Chemo - non-surgical'),(1300,'Other');
/*!40000 ALTER TABLE `listtreatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nextregistrynum`
--

DROP TABLE IF EXISTS `nextregistrynum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nextregistrynum` (
  `RegistryNumAutoNum` int(11) NOT NULL AUTO_INCREMENT,
  `NextRegistryNumber` int(11) DEFAULT '0',
  PRIMARY KEY (`RegistryNumAutoNum`),
  KEY `RegistryNumAutoNum` (`RegistryNumAutoNum`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nextregistrynum`
--

LOCK TABLES `nextregistrynum` WRITE;
/*!40000 ALTER TABLE `nextregistrynum` DISABLE KEYS */;
INSERT INTO `nextregistrynum` VALUES (1,285);
/*!40000 ALTER TABLE `nextregistrynum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paste errors`
--

DROP TABLE IF EXISTS `paste errors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paste errors` (
  `Field0` longtext,
  `Field1` longtext,
  `Field2` longtext,
  `Field3` longtext,
  `Field4` longtext,
  `Field5` longtext,
  `Field6` longtext,
  `Field7` longtext
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paste errors`
--

LOCK TABLES `paste errors` WRITE;
/*!40000 ALTER TABLE `paste errors` DISABLE KEYS */;
INSERT INTO `paste errors` VALUES ('Smith, John','MD          ','Center','123 Main St.','New York','NY','11111-1111','(111) 111-1111');
/*!40000 ALTER TABLE `paste errors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `MRN` varchar(50) NOT NULL,
  `Name (Last,First)` varchar(50) DEFAULT NULL,
  `Date Of Birth` datetime DEFAULT NULL,
  `Date of Referral` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Gender` varchar(10) DEFAULT NULL,
  `SocSecNumber` varchar(50) DEFAULT NULL,
  `Referring MD` varchar(50) DEFAULT NULL,
  `Primary Care Physician` varchar(50) DEFAULT NULL,
  `Additional MD` varchar(50) DEFAULT NULL,
  `WorkUp Status` int(11) DEFAULT '100',
  `LCEC Status` int(11) DEFAULT '10',
  `LCEC Chart` tinyint(1) DEFAULT '0',
  `InactiveDate` datetime DEFAULT NULL,
  `Insurance` varchar(50) DEFAULT NULL,
  `InsurComment` varchar(50) DEFAULT NULL,
  `InsurancePhone` varchar(50) DEFAULT NULL,
  `InsuranceID` varchar(50) DEFAULT NULL,
  `Secondary Insurance` varchar(50) DEFAULT NULL,
  `Secondary InsurID` varchar(50) DEFAULT NULL,
  `CT Precert` varchar(50) DEFAULT 'Some',
  `PET Precert` varchar(50) DEFAULT 'Some',
  `PFT Precert` varchar(50) DEFAULT 'Some',
  `Referral Needed` varchar(50) DEFAULT 'Some',
  `SchedFUwithMD` tinyint(1) DEFAULT '0',
  `Address` varchar(255) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `StateOrProvince` varchar(2) DEFAULT 'NY',
  `PostalCode` varchar(50) DEFAULT NULL,
  `PhoneNumber` varchar(30) DEFAULT NULL,
  `Alternative Phone` varchar(30) DEFAULT NULL,
  `EmailAddress` varchar(50) DEFAULT NULL,
  `Date of Data Entry` datetime DEFAULT NULL,
  `PackYears` float DEFAULT '0',
  `Year quit` int(11) DEFAULT '0',
  `SmokerStatusEntry` int(11) DEFAULT '0',
  `SmokerStatusCurrent` int(11) DEFAULT '0',
  `FEV-1 (L)` float DEFAULT NULL,
  `FEV-1 %Pred` float DEFAULT NULL,
  `FVC (L)` float DEFAULT NULL,
  `FVC %Pred` float DEFAULT NULL,
  `FEV-1/FVC %` float DEFAULT NULL,
  `VO2max` float DEFAULT NULL,
  `DLCOAct` float DEFAULT '0',
  `DLCO (% Pred)` float DEFAULT NULL,
  `CAD` tinyint(1) DEFAULT '0',
  `LVEF < 40%` tinyint(1) DEFAULT '0',
  `CVA` tinyint(1) DEFAULT '0',
  `Asbestos Exposure` varchar(50) DEFAULT 'None',
  `Silica Exposure` varchar(50) DEFAULT 'None',
  `TB/PPD History` varchar(50) DEFAULT 'None',
  `CABG (last 3 years)` tinyint(1) DEFAULT '0',
  `Major Surgery (last 3  years)` tinyint(1) DEFAULT '0',
  `MajorSurgery Comment` varchar(200) DEFAULT NULL,
  `Personal Lung Cancer` tinyint(1) DEFAULT '0',
  `Comment-HxLungCancer` varchar(150) DEFAULT NULL,
  `Fath/Moth Lung Cancer` tinyint(1) DEFAULT '0',
  `Other Family Lung Cancer` tinyint(1) DEFAULT '0',
  `Comment-FamLungCancer` varchar(150) DEFAULT NULL,
  `Personal Other Cancer` tinyint(1) DEFAULT '0',
  `Personal Other Cancer Comment` varchar(150) DEFAULT NULL,
  `Fath/Moth Other Cancer` tinyint(1) DEFAULT '0',
  `Other Fam Other Cancer` tinyint(1) DEFAULT '0',
  `Comment-FamilyCancer` varchar(150) DEFAULT NULL,
  `Aspirin` tinyint(1) DEFAULT '0',
  `Plavix` tinyint(1) DEFAULT '0',
  `Coumadin` tinyint(1) DEFAULT '0',
  `OtherAntiCoag` tinyint(1) DEFAULT '0',
  `MedicationList` varchar(250) DEFAULT NULL,
  `AllergyList` varchar(100) DEFAULT NULL,
  `DetailComment` varchar(250) DEFAULT NULL,
  `AsbestosExposure` tinyint(1) DEFAULT '0',
  `SilicaExposure` tinyint(1) DEFAULT '0',
  `WTC` tinyint(1) DEFAULT '0',
  `StartYear` int(11) DEFAULT '0',
  `EndYear` int(11) DEFAULT '0',
  PRIMARY KEY (`MRN`),
  KEY `Date of Referral` (`Date of Referral`),
  KEY `FEV-1 %Pred` (`FEV-1 %Pred`),
  KEY `InsuranceID` (`InsuranceID`),
  KEY `LCEC Status` (`LCEC Status`),
  KEY `LCEC Status_2` (`LCEC Status`),
  KEY `Name (Last,First)` (`Name (Last,First)`),
  KEY `Name (Last,First)_2` (`Name (Last,First)`,`Date Of Birth`),
  KEY `Name (Last,First)_3` (`Name (Last,First)`,`MRN`),
  KEY `Other Family Lung Cancer` (`Other Family Lung Cancer`),
  KEY `Personal Lung Cancer` (`Personal Lung Cancer`),
  KEY `Referring MD` (`Referring MD`),
  KEY `Secondary InsurID` (`Secondary InsurID`),
  KEY `SmokerStatusEntry` (`SmokerStatusEntry`),
  KEY `WorkUp Status` (`WorkUp Status`),
  KEY `WorkUp Status_2` (`WorkUp Status`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('000000001','Smith, Judy','1900-12-28 00:00:00','2018-08-12 04:00:00','Female',NULL,'Smith, John',NULL,NULL,800,500,1,NULL,'MMIS',NULL,NULL,NULL,NULL,NULL,'Some','Some','Some','Some',0,'123 Acme Drive','New York','NY','1111-','111-111-1111',NULL,NULL,'2018-08-12 00:00:00',35,0,1,1,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,0,0,0,'None','None','None',0,0,NULL,0,NULL,0,0,NULL,1,'colon',0,0,NULL,0,0,0,0,'vicodin','codeine','test',0,0,0,0,0);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-biopsy`
--

DROP TABLE IF EXISTS `patient-biopsy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-biopsy` (
  `MRN` varchar(50) DEFAULT NULL,
  `AutoNum` int(11) NOT NULL AUTO_INCREMENT,
  `ScheduleDate` datetime DEFAULT NULL,
  `ProcedureDate` datetime DEFAULT NULL,
  `PerformedBy` varchar(50) DEFAULT NULL,
  `ProcedureType` int(11) DEFAULT NULL,
  `BiopsyTaken` tinyint(1) DEFAULT '0',
  `BiopsyLocationCode` varchar(50) DEFAULT NULL,
  `LocationComment` varchar(50) DEFAULT NULL,
  `Result-Diagnostic` varchar(50) DEFAULT NULL,
  `Biopsy Result` varchar(50) DEFAULT NULL,
  `BiopsyAccuracy` varchar(50) DEFAULT NULL,
  `LinkToLesion` int(11) DEFAULT '0',
  `LinkToCancer` int(11) DEFAULT '0',
  `Culture` varchar(50) DEFAULT NULL,
  `Complication` varchar(50) DEFAULT NULL,
  `Comment` varchar(200) DEFAULT NULL,
  `ORTime` int(11) DEFAULT '0',
  `NodesSampled` varchar(50) DEFAULT NULL,
  `LOSdays` int(11) DEFAULT '0',
  `Discharge` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AutoNum`),
  KEY `BiopsyLocationCode` (`BiopsyLocationCode`),
  KEY `LinkToCancer` (`LinkToCancer`),
  KEY `LinkToLesion` (`LinkToLesion`),
  KEY `MRN` (`MRN`,`ScheduleDate`),
  KEY `PerformedBy` (`PerformedBy`),
  KEY `ProcedureDate` (`ProcedureDate`),
  KEY `Result-Diagnostic` (`Result-Diagnostic`),
  KEY `ScheduleDate` (`ScheduleDate`)
) ENGINE=MyISAM AUTO_INCREMENT=6536 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-biopsy`
--

LOCK TABLES `patient-biopsy` WRITE;
/*!40000 ALTER TABLE `patient-biopsy` DISABLE KEYS */;
INSERT INTO `patient-biopsy` VALUES ('000000001',1,'2016-01-12 00:00:00','2016-01-12 00:00:00','Smith,Dr',800,1,'RLL',' adeno/IA/T1N0M0','Diagnostic- Cancer','adenocarcinoma','True Positive',593,99,NULL,NULL,'pt f/u @ MSKCC',NULL,'7, 8R, 9R',6,'Home');
/*!40000 ALTER TABLE `patient-biopsy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-bronch`
--

DROP TABLE IF EXISTS `patient-bronch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-bronch` (
  `BiopsyNum` int(11) DEFAULT '0',
  `BronchAutoNum` int(11) NOT NULL AUTO_INCREMENT,
  `BronchType` int(11) DEFAULT NULL,
  `LocationCode` varchar(50) DEFAULT NULL,
  `BiopsyResult` varchar(50) DEFAULT NULL,
  `Diagnostic` varchar(50) DEFAULT NULL,
  `Accuracy` varchar(50) DEFAULT NULL,
  `Lymphocytes` tinyint(1) DEFAULT '0',
  `ROSE` tinyint(1) DEFAULT '0',
  `NumPasses` int(11) DEFAULT '0',
  `Culture` varchar(50) DEFAULT NULL,
  `Comment` varchar(50) DEFAULT NULL,
  `EBUS` tinyint(1) DEFAULT NULL,
  `EMN` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`BronchAutoNum`),
  KEY `Accuracy` (`Accuracy`),
  KEY `LocationCode` (`LocationCode`),
  KEY `BiopsyNum` (`BiopsyNum`),
  KEY `BronchAutoNum` (`BronchAutoNum`),
  KEY `BronchType` (`BronchType`),
  KEY `BronchType_2` (`BronchType`)
) ENGINE=MyISAM AUTO_INCREMENT=1566 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-bronch`
--

LOCK TABLES `patient-bronch` WRITE;
/*!40000 ALTER TABLE `patient-bronch` DISABLE KEYS */;

INSERT INTO `patient-bronch` VALUES (1299,2,200,'Node R paratracheal','non-diagnostic','Nondiagnostic','True Negative',0,0,NULL,NULL,'s/p med',NULL,NULL);
/*!40000 ALTER TABLE `patient-bronch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-cancer`
--

DROP TABLE IF EXISTS `patient-cancer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-cancer` (
  `PatientMRN` varchar(50) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date of 1st Diagnosis` datetime DEFAULT NULL,
  `Date of Final Staging` datetime DEFAULT NULL,
  `Date of Tumor Board` datetime DEFAULT NULL,
  `Date 1st relapse` datetime DEFAULT NULL,
  `CancerType` int(11) NOT NULL,
  `CancerHisto` varchar(50) DEFAULT NULL,
  `CancerTypeComment` varchar(100) DEFAULT NULL,
  `Stage - T Clinical` int(11) DEFAULT '0',
  `Stage - N Clinical` varchar(50) DEFAULT NULL,
  `Stage - M Clinical` varchar(50) DEFAULT NULL,
  `Stage - TNM Clinical` int(11) DEFAULT '0',
  `Stage - T Pathologic` int(11) DEFAULT '0',
  `Stage - N Pathologic` varchar(50) DEFAULT NULL,
  `Stage - M Pathologic` varchar(50) DEFAULT NULL,
  `Stage - TNM Pathologic` int(11) DEFAULT '0',
  `Stage - T Restage` int(11) DEFAULT '0',
  `Stage - N Restage` varchar(50) DEFAULT NULL,
  `Stage - M Restage` varchar(50) DEFAULT NULL,
  `Stage - TNM Restage` int(11) DEFAULT '0',
  `NeoChemo` tinyint(1) DEFAULT '0',
  `NeoChemoPlan` varchar(50) DEFAULT NULL,
  `NeoChemoMD` varchar(50) DEFAULT NULL,
  `NeoChemoStartDate` datetime DEFAULT NULL,
  `NeoChemoEndDate` datetime DEFAULT NULL,
  `NeoRT` tinyint(1) DEFAULT '0',
  `NeoRTPlan` varchar(50) DEFAULT NULL,
  `NeoRTMD` varchar(50) DEFAULT NULL,
  `NeoRTStartDate` datetime DEFAULT NULL,
  `NeoRTEndDate` datetime DEFAULT NULL,
  `Surgery` tinyint(1) DEFAULT '0',
  `SurgeryPlan` varchar(50) DEFAULT NULL,
  `SurgeryMD` varchar(50) DEFAULT NULL,
  `SurgeryDate` datetime DEFAULT NULL,
  `Chemo` tinyint(1) DEFAULT '0',
  `ChemoPlan` varchar(50) DEFAULT NULL,
  `ChemoMD` varchar(50) DEFAULT NULL,
  `ChemoStartDate` datetime DEFAULT NULL,
  `ChemoEndDate` datetime DEFAULT NULL,
  `RT` tinyint(1) DEFAULT '0',
  `RTPlan` varchar(50) DEFAULT NULL,
  `RTMD` varchar(50) DEFAULT NULL,
  `RTStartDate` datetime DEFAULT NULL,
  `RTEndDate` datetime DEFAULT NULL,
  `OtherTherapy` tinyint(1) DEFAULT '0',
  `Status 1 year` varchar(50) DEFAULT NULL,
  `Status 2 year` varchar(50) DEFAULT NULL,
  `Status 3 year` varchar(50) DEFAULT NULL,
  `Status 4 year` varchar(50) DEFAULT NULL,
  `Status 5 year` varchar(50) DEFAULT NULL,
  `Comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PatientMRN`,`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `CancerHisto` (`CancerHisto`),
  KEY `CancerType` (`CancerType`),
  KEY `CancerType_2` (`CancerType`),
  KEY `Date of 1st Diagnosis` (`Date of 1st Diagnosis`),
  KEY `NeoChemoMD` (`NeoChemoMD`),
  KEY `Stage - T Clinical` (`Stage - T Clinical`),
  KEY `Stage - TNM Clinical` (`Stage - TNM Clinical`),
  KEY `Stage - TNM Clinical_2` (`Stage - TNM Clinical`),
  KEY `Stage - TNM Pathologic` (`Stage - TNM Pathologic`),
  KEY `Status 1 year` (`Status 1 year`),
  KEY `Status 2 year` (`Status 2 year`),
  KEY `Status 3 year` (`Status 3 year`),
  KEY `Status 4 year` (`Status 4 year`),
  KEY `Status 5 year` (`Status 5 year`)
) ENGINE=MyISAM AUTO_INCREMENT=1859 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-cancer`
--

LOCK TABLES `patient-cancer` WRITE;
/*!40000 ALTER TABLE `patient-cancer` DISABLE KEYS */;
INSERT INTO `patient-cancer` VALUES ('0111111111',498,'2016-11-01 00:00:00','2006-11-01 00:00:00','2006-11-01 00:00:00',NULL,800,NULL,'Thyroid cancer - papillary',230,'N1 - hilar nodes','M1 - mets',701,0,NULL,NULL,0,0,NULL,NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,0,'Treated','WEISS, TAMARA','2007-02-07 00:00:00',NULL,0,'Alive - with suspected cancer',NULL,NULL,NULL,NULL,'(+) nodal disease. Likely lung mets.  Formally tissue staged I 3/1/08');

/*!40000 ALTER TABLE `patient-cancer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-distress`
--

DROP TABLE IF EXISTS `patient-distress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-distress` (
  `DistressAutoNum` int(11) NOT NULL AUTO_INCREMENT,
  `MRN` varchar(255) DEFAULT NULL,
  `DistressDate` datetime DEFAULT NULL,
  `DistressLevel` float DEFAULT NULL,
  `Childcare` tinyint(1) DEFAULT '0',
  `Housing` tinyint(1) DEFAULT '0',
  `Money` tinyint(1) DEFAULT '0',
  `Transport` tinyint(1) DEFAULT '0',
  `WorkSchool` tinyint(1) DEFAULT '0',
  `FamilyPartner` tinyint(1) DEFAULT '0',
  `FamilyChildren` tinyint(1) DEFAULT '0',
  `Depression` tinyint(1) DEFAULT '0',
  `Fears` tinyint(1) DEFAULT '0',
  `Nervousness` tinyint(1) DEFAULT '0',
  `Sadness` tinyint(1) DEFAULT '0',
  `Worry` tinyint(1) DEFAULT '0',
  `Anger` tinyint(1) DEFAULT '0',
  `LossFaith` tinyint(1) DEFAULT '0',
  `RelatingGod` tinyint(1) DEFAULT '0',
  `LossofMeaning` tinyint(1) DEFAULT '0',
  `Pain` tinyint(1) DEFAULT '0',
  `Nausea` tinyint(1) DEFAULT '0',
  `Fatigue` tinyint(1) DEFAULT '0',
  `Sleep` tinyint(1) DEFAULT '0',
  `GettingAround` tinyint(1) DEFAULT '0',
  `BathingDressing` tinyint(1) DEFAULT '0',
  `Breathing` tinyint(1) DEFAULT '0',
  `MouthSores` tinyint(1) DEFAULT '0',
  `Eating` tinyint(1) DEFAULT '0',
  `Indigestion` tinyint(1) DEFAULT '0',
  `Constipation` tinyint(1) DEFAULT '0',
  `Diarrhea` tinyint(1) DEFAULT '0',
  `Urination` tinyint(1) DEFAULT '0',
  `Fever` tinyint(1) DEFAULT '0',
  `Skin DryItchy` tinyint(1) DEFAULT '0',
  `Nose DryCongestion` tinyint(1) DEFAULT '0',
  `TinglingHands` tinyint(1) DEFAULT '0',
  `MemoryConcentrate` tinyint(1) DEFAULT '0',
  `FeelingSwollen` tinyint(1) DEFAULT '0',
  `SexualIssues` tinyint(1) DEFAULT '0',
  `HotFlushes` tinyint(1) DEFAULT '0',
  `Comment` varchar(255) DEFAULT NULL,
  `TypeOfVisit` varchar(255) DEFAULT NULL,
  `CurrentStatus` varchar(255) DEFAULT NULL,
  `CancerStage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DistressAutoNum`),
  KEY `MRN` (`MRN`,`DistressDate`)
) ENGINE=MyISAM AUTO_INCREMENT=295 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-distress`
--

LOCK TABLES `patient-distress` WRITE;
/*!40000 ALTER TABLE `patient-distress` DISABLE KEYS */;
INSERT INTO `patient-distress` VALUES (2,'111111','2019-01-09 00:00:00',4,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'Distress about Pending surgery','Initial Visit','Initial Workup',NULL);

/*!40000 ALTER TABLE `patient-distress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-inpatient`
--

DROP TABLE IF EXISTS `patient-inpatient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-inpatient` (
  `InpatientRecordID` int(11) NOT NULL AUTO_INCREMENT,
  `MRN` varchar(50) NOT NULL,
  `AdmitDate` datetime DEFAULT NULL,
  `DischargeDate` datetime DEFAULT NULL,
  `Service` varchar(255) DEFAULT NULL,
  `Room` varchar(255) DEFAULT NULL,
  `Reason` varchar(255) DEFAULT NULL,
  `Comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`InpatientRecordID`),
  KEY `MRN` (`MRN`)
) ENGINE=MyISAM AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-inpatient`
--

LOCK TABLES `patient-inpatient` WRITE;
/*!40000 ALTER TABLE `patient-inpatient` DISABLE KEYS */;
INSERT INTO `patient-inpatient` VALUES (21,'11111111','2008-11-18 00:00:00','2008-11-29 00:00:00',NULL,NULL,'Airway palliation','Awaiting HOSPICE?');

/*!40000 ALTER TABLE `patient-inpatient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-lesion`
--

DROP TABLE IF EXISTS `patient-lesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-lesion` (
  `PatientMRN` varchar(50) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date1stFollowedLCEC` datetime DEFAULT NULL,
  `LesionClassification` int(11) DEFAULT '0',
  `RiskClassification` int(11) DEFAULT '0',
  `Location` varchar(50) DEFAULT NULL,
  `LocationComment` varchar(50) DEFAULT NULL,
  `CT Characteristic` varchar(50) DEFAULT NULL,
  `PET SUV` varchar(50) DEFAULT NULL,
  `LinkToCancer` int(11) DEFAULT '0',
  `LesionDiagnosis` int(11) DEFAULT '0',
  `Comments` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PatientMRN`,`ID`),
  KEY `CT Characteristic` (`CT Characteristic`),
  KEY `Date1stFollowedLCEC` (`Date1stFollowedLCEC`),
  KEY `LesionDiagnosis` (`LesionDiagnosis`),
  KEY `LinkToCancer` (`LinkToCancer`),
  KEY `Location` (`Location`),
  KEY `ID` (`ID`),
  KEY `PET SUV` (`PET SUV`),
  KEY `RiskClassification` (`RiskClassification`),
  KEY `RiskClassification_2` (`RiskClassification`)
) ENGINE=MyISAM AUTO_INCREMENT=6299 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-lesion`
--

LOCK TABLES `patient-lesion` WRITE;
/*!40000 ALTER TABLE `patient-lesion` DISABLE KEYS */;
INSERT INTO `patient-lesion` VALUES ('00001525',4053,'2008-08-12 00:00:00',200,0,'RUL',NULL,NULL,'1.3',0,0,NULL);
/*!40000 ALTER TABLE `patient-lesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-medication`
--

DROP TABLE IF EXISTS `patient-medication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-medication` (
  `PatientMRN` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Medicine Name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Strength` varchar(45) DEFAULT NULL,
  `Strength Unit` int(11) DEFAULT '0',
  `Dose` varchar(45) DEFAULT NULL,
  `Dose Unit` int(11) DEFAULT '0',
  `How Often Taken` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `How Taken` int(11) DEFAULT '0',
  `Reason` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `Started Date` datetime DEFAULT NULL,
  `Stopped Date` datetime DEFAULT NULL,
  `Medication GivenType` int(11) DEFAULT '0',
  `Instructions` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `Prescribed Date` datetime DEFAULT NULL,
  `Prescription Quantity` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `Prescription Expire Date` datetime DEFAULT NULL,
  `Prescriptor` varchar(50) DEFAULT NULL,
  `Plavix` tinyint(1) DEFAULT '0',
  `Effient` tinyint(1) DEFAULT '0',
  `Agrylin` tinyint(1) DEFAULT '0',
  `Aggrenox` tinyint(1) DEFAULT '0',
  `Pletal` tinyint(1) DEFAULT '0',
  `Pradaxa` tinyint(1) DEFAULT '0',
  `Xarelto` tinyint(1) DEFAULT '0',
  `Coumadin` tinyint(1) DEFAULT '0',
  `Persantine` tinyint(1) DEFAULT '0',
  `Eliquis` tinyint(1) DEFAULT '0',
  `Brilinta` tinyint(1) DEFAULT '0',
  `Oral hypoglycemic` tinyint(1) DEFAULT '0',
  `Insulin` tinyint(1) DEFAULT '0',
  `Date Of Medicine` datetime DEFAULT NULL,
  `Allergies` varchar(500) DEFAULT NULL,
  `NKA` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-medication`
--

LOCK TABLES `patient-medication` WRITE;
/*!40000 ALTER TABLE `patient-medication` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient-medication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-pft`
--

DROP TABLE IF EXISTS `patient-pft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-pft` (
  `ID` int(11) NOT NULL DEFAULT '0',
  `FEV-1` float DEFAULT '0',
  `FEV%` float DEFAULT '0',
  `FVC` float DEFAULT '0',
  `FVC%` float DEFAULT '0',
  `FEV1Ratio` float DEFAULT '0',
  `DLCO` float DEFAULT '0',
  `DLCO%` float DEFAULT '0',
  `Interpretation` int(11) DEFAULT '0',
  `Comments` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-pft`
--

LOCK TABLES `patient-pft` WRITE;
/*!40000 ALTER TABLE `patient-pft` DISABLE KEYS */;
INSERT INTO `patient-pft` VALUES (3865,1.55,89,1.96,93,79.0816,NULL,81,108,NULL);
/*!40000 ALTER TABLE `patient-pft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-registry`
--

DROP TABLE IF EXISTS `patient-registry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-registry` (
  `RegistryDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `RegistryNum` int(11) NOT NULL AUTO_INCREMENT,
  `MRN` varchar(50) NOT NULL,
  `Age` int(11) DEFAULT '0',
  `DateOfBirth` datetime DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `Height` int(11) DEFAULT '0',
  `Weight` int(11) DEFAULT '0',
  `Race1` varchar(50) DEFAULT NULL,
  `Race2` varchar(50) DEFAULT NULL,
  `Race3` varchar(50) DEFAULT NULL,
  `RaceComment` varchar(50) DEFAULT NULL,
  `Education` varchar(50) DEFAULT NULL,
  `PriorLung` tinyint(1) DEFAULT '0',
  `PriorCancer` tinyint(1) DEFAULT '0',
  `PriorHistory` varchar(200) DEFAULT NULL,
  `SmokerStatus` varchar(50) DEFAULT NULL,
  `SmokerYearStart` int(11) DEFAULT '0',
  `SmokerYearQuit` int(11) DEFAULT '0',
  `SmokerPackDay` float DEFAULT '0',
  `SmokerComment` varchar(200) DEFAULT NULL,
  `SecondSmoke` tinyint(1) DEFAULT '0',
  `SecondSmokeChild` int(11) DEFAULT '0',
  `SecondSmokeSpouse` int(11) DEFAULT '0',
  `SecondSmokeWork` int(11) DEFAULT '0',
  `SecondComment` varchar(50) DEFAULT NULL,
  `FamLung` tinyint(1) DEFAULT '0',
  `LungCancerMother` int(11) DEFAULT '0',
  `LungCancerFather` int(11) DEFAULT '0',
  `LungCancerSister` int(11) DEFAULT '0',
  `LungCancerBrother` int(11) DEFAULT '0',
  `LungCancerGM` int(11) DEFAULT '0',
  `LungCancerGF` int(11) DEFAULT '0',
  `LungCancerOther` varchar(255) DEFAULT NULL,
  `FamilyCancer` tinyint(1) DEFAULT '0',
  `FamilyCancerComment` varchar(255) DEFAULT NULL,
  `Occupation` varchar(200) DEFAULT NULL,
  `Asbestos` tinyint(1) DEFAULT '0',
  `Metals` tinyint(1) DEFAULT '0',
  `Mining` tinyint(1) DEFAULT '0',
  `Chemicals` tinyint(1) DEFAULT '0',
  `ExposureComment` varchar(200) DEFAULT NULL,
  `GroundZero` varchar(50) DEFAULT NULL,
  `COPD` tinyint(1) DEFAULT '0',
  `Tuberculosis` tinyint(1) DEFAULT '0',
  `Fibrosis` tinyint(1) DEFAULT '0',
  `Pneumonia` tinyint(1) DEFAULT '0',
  `Bronchitis` tinyint(1) DEFAULT '0',
  `ChestRT` tinyint(1) DEFAULT '0',
  `DailyVitamins` varchar(50) DEFAULT NULL,
  `VitaminA` tinyint(1) DEFAULT '0',
  `VitaminB` tinyint(1) DEFAULT '0',
  `VitaminE` tinyint(1) DEFAULT '0',
  `Omega3` tinyint(1) DEFAULT '0',
  `RedMeat` varchar(50) DEFAULT NULL,
  `Fish` varchar(50) DEFAULT NULL,
  `Fruit` varchar(50) DEFAULT NULL,
  `Vegetable` varchar(50) DEFAULT NULL,
  `VegetableLeafy` varchar(50) DEFAULT NULL,
  `VegetableBroccoli` varchar(50) DEFAULT NULL,
  `PhysicalWork` int(11) DEFAULT '0',
  `PhysicalExercise` int(11) DEFAULT '0',
  `Alcohol` varchar(50) DEFAULT NULL,
  `AlcoholComment` varchar(200) DEFAULT NULL,
  `AlcoholRed` int(11) DEFAULT '0',
  `AlcoholWhite` int(11) DEFAULT '0',
  `AlcoholBeer` int(11) DEFAULT '0',
  `AlcoholLiquor` int(11) DEFAULT '0',
  `ScreeningPhysical` varchar(50) DEFAULT NULL,
  `ScreeningBreast` varchar(50) DEFAULT NULL,
  `ScreeningColon` varchar(50) DEFAULT NULL,
  `ScreeningPAP` varchar(50) DEFAULT NULL,
  `ScreeningProstate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MRN`),
  UNIQUE KEY `RegistryNum` (`RegistryNum`)
) ENGINE=MyISAM AUTO_INCREMENT=286 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-registry`
--

LOCK TABLES `patient-registry` WRITE;
/*!40000 ALTER TABLE `patient-registry` DISABLE KEYS */;
INSERT INTO `patient-registry` VALUES ('2017-07-13 04:00:00',13,'111111',66,'1961-02-09 00:00:00','Female',63,142,'White',NULL,NULL,NULL,'College Grad',0,0,NULL,'Never',NULL,NULL,NULL,NULL,0,0,0,0,NULL,0,0,0,0,0,0,0,NULL,0,NULL,NULL,0,0,0,0,NULL,NULL,0,0,0,0,0,0,'1-2 daily',0,0,0,1,'<1 week','1 week','1/day','1/day','1/day','1/day',0,3,'Never',NULL,0,0,0,0,'UpToDate','UpToDate','UpToDate','Not UpToDate','N/A');
/*!40000 ALTER TABLE `patient-registry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-research`
--

DROP TABLE IF EXISTS `patient-research`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-research` (
  `ResearchID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientMRN` varchar(50) DEFAULT NULL,
  `ConsentDate` datetime DEFAULT NULL,
  `ResearchProj` int(11) DEFAULT '0',
  `Comments` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ResearchID`),
  KEY `ResearchID` (`ResearchID`)
) ENGINE=MyISAM AUTO_INCREMENT=321 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-research`
--

LOCK TABLES `patient-research` WRITE;
/*!40000 ALTER TABLE `patient-research` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient-research` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-surgdiagnosis`
--

DROP TABLE IF EXISTS `patient-surgdiagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-surgdiagnosis` (
  `SurgDiagnosis` int(11) NOT NULL AUTO_INCREMENT,
  `STSNumber` int(11) DEFAULT '0',
  `DiagnosisCategory` int(11) DEFAULT '0',
  `Diagnosis` int(11) DEFAULT '0',
  `Primary` tinyint(1) DEFAULT '0',
  `Comment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SurgDiagnosis`),
  KEY `STSNumber` (`STSNumber`)
) ENGINE=MyISAM AUTO_INCREMENT=734 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-surgdiagnosis`
--

LOCK TABLES `patient-surgdiagnosis` WRITE;
/*!40000 ALTER TABLE `patient-surgdiagnosis` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient-surgdiagnosis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-surgerydata`
--

DROP TABLE IF EXISTS `patient-surgerydata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-surgerydata` (
  `BiopsyNum` int(11) NOT NULL DEFAULT '0',
  `RecComp` tinyint(1) DEFAULT '0',
  `Zubrod` tinyint(3) unsigned DEFAULT NULL,
  `HospitalZip` float DEFAULT '11794',
  `Hospital` varchar(50) DEFAULT 'Stony Brook University Hospital',
  `Race` int(11) DEFAULT '0',
  `Race2` int(11) DEFAULT '0',
  `Race3` int(11) DEFAULT '0',
  `HospAdmitDate` datetime DEFAULT NULL,
  `HeightCm` int(11) DEFAULT NULL,
  `WeightKg` int(11) DEFAULT NULL,
  `WtLoss3Kg` tinyint(3) unsigned DEFAULT NULL,
  `TobNone` tinyint(1) DEFAULT '0',
  `TobChew` tinyint(1) DEFAULT '0',
  `TobCig` tinyint(1) DEFAULT '0',
  `TobPipe` tinyint(1) DEFAULT '0',
  `TobOther` tinyint(1) DEFAULT '0',
  `PackYear` tinyint(3) unsigned DEFAULT NULL,
  `QuitSmoking` tinyint(3) unsigned DEFAULT NULL,
  `Category` int(11) DEFAULT NULL,
  `Infection` tinyint(3) unsigned DEFAULT NULL,
  `Trauma` int(11) DEFAULT '0',
  `NoComorb` tinyint(1) DEFAULT '0',
  `Hypertn` tinyint(1) DEFAULT '0',
  `Steroid` tinyint(1) DEFAULT '0',
  `CHF` tinyint(1) DEFAULT '0',
  `CAD` tinyint(1) DEFAULT '0',
  `PVD` tinyint(1) DEFAULT '0',
  `PrepChemo` tinyint(1) DEFAULT '0',
  `PreopChemoWhen` int(11) DEFAULT '0',
  `PreopXRT` tinyint(1) DEFAULT '0',
  `PreopXRTWhen` int(11) DEFAULT '0',
  `PriorCTS` tinyint(1) DEFAULT '0',
  `WhenPrior` tinyint(3) unsigned DEFAULT NULL,
  `OtherComorb` tinyint(1) DEFAULT '0',
  `OtherComment` varchar(50) DEFAULT NULL,
  `CerebroHx` tinyint(3) unsigned DEFAULT NULL,
  `DiabetesHx` tinyint(3) unsigned DEFAULT NULL,
  `RenalHx` tinyint(3) unsigned DEFAULT NULL,
  `ClinNA` tinyint(1) DEFAULT '0',
  `ClinT` tinyint(3) unsigned DEFAULT NULL,
  `ClinN` tinyint(3) unsigned DEFAULT NULL,
  `ClinM` tinyint(3) unsigned DEFAULT NULL,
  `ClinMAB` tinyint(3) unsigned DEFAULT NULL,
  `ClinStage` int(11) DEFAULT '0',
  `PFTNA` tinyint(1) DEFAULT '0',
  `FVCAct` float DEFAULT NULL,
  `FVCPred` tinyint(3) unsigned DEFAULT NULL,
  `FEVAct` float DEFAULT NULL,
  `FEVPred` tinyint(3) unsigned DEFAULT NULL,
  `DLCOAct` float DEFAULT NULL,
  `DLCOPred` tinyint(3) unsigned DEFAULT NULL,
  `ASA` tinyint(3) unsigned DEFAULT NULL,
  `Status` tinyint(3) unsigned DEFAULT NULL,
  `Consent` tinyint(1) DEFAULT '0',
  `OREntryT` datetime DEFAULT NULL,
  `SIStartT` datetime DEFAULT NULL,
  `SIStopT` datetime DEFAULT NULL,
  `AnesthStartT` datetime DEFAULT NULL,
  `AnesthStopT` datetime DEFAULT NULL,
  `ORExitT` datetime DEFAULT NULL,
  `MultiDay` tinyint(1) DEFAULT '0',
  `Robot` tinyint(1) DEFAULT '0',
  `Reoperation` tinyint(1) DEFAULT '0',
  `BloodTransfusionNum` int(11) DEFAULT NULL,
  `BloodTransfusionIntraop` tinyint(1) DEFAULT '0',
  `PrimaryProcedureNum` int(11) DEFAULT '0',
  `PrimaryOrganSys` int(11) DEFAULT '0',
  `PrimaryProcedure` int(11) DEFAULT '0',
  `PrimaryApproach` int(11) DEFAULT '0',
  `PrimaryLaterality` varchar(50) DEFAULT NULL,
  `NoPostop` tinyint(1) DEFAULT '0',
  `AirLeak5` tinyint(1) DEFAULT '0',
  `Atelectasis` tinyint(1) DEFAULT '0',
  `Pneumonia` tinyint(1) DEFAULT '0',
  `ARDS` tinyint(1) DEFAULT '0',
  `Bronchopleural` tinyint(1) DEFAULT '0',
  `PE` tinyint(1) DEFAULT '0',
  `Pnuemothorax` tinyint(1) DEFAULT '0',
  `Vent` tinyint(1) DEFAULT '0',
  `Reintube` tinyint(1) DEFAULT '0',
  `Trach` tinyint(1) DEFAULT '0',
  `OtherPul` tinyint(1) DEFAULT '0',
  `AtrialArryth` tinyint(1) DEFAULT '0',
  `VentArrtyh` tinyint(1) DEFAULT '0',
  `MI` tinyint(1) DEFAULT '0',
  `DVT` tinyint(1) DEFAULT '0',
  `OtherCV` tinyint(1) DEFAULT '0',
  `GastricOutlet` tinyint(1) DEFAULT '0',
  `Ileus` tinyint(1) DEFAULT '0',
  `AnastoMed` tinyint(1) DEFAULT '0',
  `AnastoSurg` tinyint(1) DEFAULT '0',
  `DilationEsoph` tinyint(1) DEFAULT '0',
  `OtherGI` tinyint(1) DEFAULT '0',
  `CentNeuroEvt` tinyint(1) DEFAULT '0',
  `RecLarynParesis` tinyint(1) DEFAULT '0',
  `OtherNeuro` tinyint(1) DEFAULT '0',
  `BleedOperate` tinyint(1) DEFAULT '0',
  `Transfusion` tinyint(1) DEFAULT '0',
  `RBCTransfusNum` int(11) DEFAULT NULL,
  `OtherHema` tinyint(1) DEFAULT '0',
  `UTI` tinyint(1) DEFAULT '0',
  `Empyema` tinyint(1) DEFAULT '0',
  `WoundInfect` tinyint(1) DEFAULT '0',
  `Sepsis` tinyint(1) DEFAULT '0',
  `OtherInfect` tinyint(1) DEFAULT '0',
  `NewRenalFail` tinyint(1) DEFAULT '0',
  `ChyloMed` tinyint(1) DEFAULT '0',
  `ChyloSurg` tinyint(1) DEFAULT '0',
  `Delirium` tinyint(1) DEFAULT '0',
  `OtherMed` tinyint(1) DEFAULT '0',
  `OtherSurg` tinyint(1) DEFAULT '0',
  `UnexpectICUAdmit` tinyint(1) DEFAULT '0',
  `DischDt` datetime DEFAULT NULL,
  `MtDCStat` tinyint(3) unsigned DEFAULT NULL,
  `Mt30Stat` tinyint(3) unsigned DEFAULT NULL,
  `MtDate` datetime DEFAULT NULL,
  `RequireReAdmit` tinyint(1) DEFAULT '0',
  `CTubeDuringAdmissioN` tinyint(1) DEFAULT '0',
  `DischargeWithCT` tinyint(1) DEFAULT '0',
  `CTubeOutDate` datetime DEFAULT NULL,
  `PathNA` tinyint(1) DEFAULT '0',
  `PathT` tinyint(3) unsigned DEFAULT NULL,
  `PathN` tinyint(3) unsigned DEFAULT NULL,
  `PathM` tinyint(3) unsigned DEFAULT NULL,
  `PathMAB` tinyint(3) unsigned DEFAULT NULL,
  `PathStage` int(11) DEFAULT '0',
  `Notes` longtext,
  `EnteredBy` varchar(50) DEFAULT NULL,
  `CompletionDate` datetime DEFAULT NULL,
  `NodesSampled` varchar(50) DEFAULT NULL,
  `DischargeTo` varchar(50) DEFAULT NULL,
  `STS Trial Link` int(11) DEFAULT NULL,
  `PatientZip` varchar(255) DEFAULT NULL,
  `RaceHispanic` tinyint(1) DEFAULT '0',
  `AdmitStatus` varchar(255) DEFAULT NULL,
  `Insurance` varchar(255) DEFAULT NULL,
  `PulmHtn` varchar(255) DEFAULT NULL,
  `CreatLevel` float DEFAULT NULL,
  `Hemoglobin` float DEFAULT NULL,
  `COPD` tinyint(1) DEFAULT '0',
  `ILD` tinyint(1) DEFAULT '0',
  `LungResection` varchar(255) DEFAULT NULL,
  `Disposition` varchar(255) DEFAULT NULL,
  `ICUDays` int(11) DEFAULT NULL,
  `LungCancerDocument` tinyint(1) DEFAULT '0',
  `EsophCancerDocument` tinyint(1) DEFAULT '0',
  `TClin` varchar(255) DEFAULT NULL,
  `NClin` varchar(255) DEFAULT NULL,
  `MClin` varchar(255) DEFAULT NULL,
  `HClin` varchar(255) DEFAULT NULL,
  `GClin` varchar(255) DEFAULT NULL,
  `TPath` varchar(255) DEFAULT NULL,
  `NPath` varchar(255) DEFAULT NULL,
  `MPath` varchar(255) DEFAULT NULL,
  `HPath` varchar(255) DEFAULT NULL,
  `GPath` varchar(255) DEFAULT NULL,
  `QAAbxOrdered` tinyint(1) DEFAULT '0',
  `QAAbx1Hour` varchar(255) DEFAULT NULL,
  `QACepha` varchar(255) DEFAULT NULL,
  `QAProphAbXDC` varchar(255) DEFAULT NULL,
  `QADVTProph` varchar(255) DEFAULT NULL,
  `QASmokeCessation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BiopsyNum`),
  KEY `BloodTransfusionNum` (`BloodTransfusionNum`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-surgerydata`
--

LOCK TABLES `patient-surgerydata` WRITE;
/*!40000 ALTER TABLE `patient-surgerydata` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient-surgerydata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-surgprocedure`
--

DROP TABLE IF EXISTS `patient-surgprocedure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-surgprocedure` (
  `SurgProcedure` int(11) NOT NULL AUTO_INCREMENT,
  `SurgeryNumber` int(11) DEFAULT '0',
  `STS-orgsys` int(11) DEFAULT '0',
  `Procedure` int(11) DEFAULT '0',
  `Primary` tinyint(1) DEFAULT '0',
  `Comment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SurgProcedure`),
  KEY `SurgeryNumber` (`SurgeryNumber`)
) ENGINE=MyISAM AUTO_INCREMENT=846 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-surgprocedure`
--

LOCK TABLES `patient-surgprocedure` WRITE;
/*!40000 ALTER TABLE `patient-surgprocedure` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient-surgprocedure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-testing`
--

DROP TABLE IF EXISTS `patient-testing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-testing` (
  `PatientMRN` varchar(50) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TestType` int(11) DEFAULT NULL,
  `RequiredDate` datetime DEFAULT NULL,
  `ScheduleDate` datetime DEFAULT NULL,
  `TestingDate` datetime DEFAULT NULL,
  `TestingResult` int(11) DEFAULT '0',
  `PatientAwareofResult` tinyint(1) DEFAULT '0',
  `OkToCallResults` tinyint(1) DEFAULT '0',
  `Cancelled/Deferred` tinyint(1) DEFAULT '0',
  `PerformedAtStonyBrook` tinyint(1) DEFAULT '0',
  `OrderedByLCEC` tinyint(1) DEFAULT '0',
  `PrecertNeeded` tinyint(1) DEFAULT '0',
  `PrecertNumber` varchar(50) DEFAULT NULL,
  `Comment` varchar(50) DEFAULT NULL,
  `Comment2` varchar(50) DEFAULT NULL,
  `FUwithMD` tinyint(1) DEFAULT '0',
  `FEV1` float(8,2) DEFAULT '0.00',
  `FVC` float(8,2) DEFAULT '0.00',
  `DLCO` float(8,2) DEFAULT '0.00',
  `FEVP` float(8,2) DEFAULT '0.00',
  `FVCP` float(8,2) DEFAULT '0.00',
  `DLCOP` float(8,2) DEFAULT '0.00',
  `FEV1FVC` float(8,2) DEFAULT '0.00',
  `Interpretation` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Cancelled/Deferred` (`Cancelled/Deferred`),
  KEY `PatientMRN` (`PatientMRN`,`TestingDate`,`ScheduleDate`,`RequiredDate`),
  KEY `RequiredDate` (`RequiredDate`),
  KEY `ScheduleDate` (`ScheduleDate`),
  KEY `TestingDate` (`TestingDate`),
  KEY `TestingDate_2` (`TestingDate`,`ScheduleDate`,`RequiredDate`),
  KEY `TestingDate_3` (`TestingDate`,`ScheduleDate`,`RequiredDate`),
  KEY `TestingDate_4` (`TestingDate`,`ScheduleDate`,`RequiredDate`),
  KEY `TestingResult` (`TestingResult`)
) ENGINE=MyISAM AUTO_INCREMENT=47724 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-testing`
--

LOCK TABLES `patient-testing` WRITE;
/*!40000 ALTER TABLE `patient-testing` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient-testing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-treatment`
--

DROP TABLE IF EXISTS `patient-treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-treatment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Cancer ID` int(11) DEFAULT '0',
  `TreatmentDate` datetime DEFAULT NULL,
  `TreatmentPhysician` varchar(50) DEFAULT NULL,
  `TreatmentSite` int(11) DEFAULT '1',
  `Treatment` int(11) DEFAULT '0',
  `Complication` varchar(50) DEFAULT NULL,
  `CompletionDate` datetime DEFAULT NULL,
  `Comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Cancer ID` (`Cancer ID`,`TreatmentDate`),
  KEY `Treatment` (`Treatment`),
  KEY `TreatmentSite` (`TreatmentSite`)
) ENGINE=MyISAM AUTO_INCREMENT=142 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-treatment`
--

LOCK TABLES `patient-treatment` WRITE;
/*!40000 ALTER TABLE `patient-treatment` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient-treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient-visit`
--

DROP TABLE IF EXISTS `patient-visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient-visit` (
  `MRN` varchar(50) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type of Visit` int(11) DEFAULT NULL,
  `Date Required` datetime DEFAULT NULL,
  `ReferralNeeded` tinyint(1) DEFAULT '0',
  `ReferralNumber` varchar(50) DEFAULT NULL,
  `Date Scheduled` datetime DEFAULT NULL,
  `Date of Actual Visit` datetime DEFAULT NULL,
  `To see/Seen by` varchar(50) DEFAULT NULL,
  `Seen by 2` varchar(50) DEFAULT NULL,
  `Seen by 3` varchar(50) DEFAULT NULL,
  `Seen by 4` varchar(50) DEFAULT NULL,
  `Refused` tinyint(1) DEFAULT '0',
  `PhoneCall` tinyint(1) DEFAULT '0',
  `SmokerStatus` int(11) DEFAULT '0',
  `SmokerCounselled` tinyint(1) DEFAULT '0',
  `Plan decided at visit` varchar(50) DEFAULT NULL,
  `Comment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Date of Actual Visit` (`Date of Actual Visit`),
  KEY `Date of Actual Visit_2` (`Date of Actual Visit`,`Date Scheduled`,`Date Required`),
  KEY `Date of Actual Visit_3` (`Date of Actual Visit`,`Date Scheduled`,`Date Required`),
  KEY `Date of Actual Visit_4` (`Date of Actual Visit`,`Date Scheduled`,`Date Required`),
  KEY `Date Required` (`Date Required`),
  KEY `Date Scheduled` (`Date Scheduled`),
  KEY `MRN` (`MRN`,`Date of Actual Visit`,`Date Scheduled`,`Date Required`),
  KEY `PhoneCall` (`PhoneCall`),
  KEY `Refused` (`Refused`),
  KEY `SmokerStatus` (`SmokerStatus`),
  KEY `To see/Seen by` (`To see/Seen by`)
) ENGINE=MyISAM AUTO_INCREMENT=15704 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient-visit`
--

LOCK TABLES `patient-visit` WRITE;
/*!40000 ALTER TABLE `patient-visit` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient-visit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `qrycancersperpatient`
--

DROP TABLE IF EXISTS `qrycancersperpatient`;
/*!50001 DROP VIEW IF EXISTS `qrycancersperpatient`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `qrycancersperpatient` AS SELECT 
 1 AS `MRN`,
 1 AS `CountOfID`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `qryprocedureperpatient`
--

DROP TABLE IF EXISTS `qryprocedureperpatient`;
/*!50001 DROP VIEW IF EXISTS `qryprocedureperpatient`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `qryprocedureperpatient` AS SELECT 
 1 AS `MRN`,
 1 AS `Name (Last,First)`,
 1 AS `Date of Referral`,
 1 AS `CountOfProcedureDate`,
 1 AS `Referring MD`,
 1 AS `Primary Care Physician`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `qrysurgeryperpatient`
--

DROP TABLE IF EXISTS `qrysurgeryperpatient`;
/*!50001 DROP VIEW IF EXISTS `qrysurgeryperpatient`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `qrysurgeryperpatient` AS SELECT 
 1 AS `MRN`,
 1 AS `CountOfProcedureDate`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sheet1`
--

DROP TABLE IF EXISTS `sheet1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sheet1` (
  `Referring Physician` varchar(255) NOT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Group Name` varchar(255) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `Zip` varchar(255) DEFAULT NULL,
  `Office Phone` varchar(255) DEFAULT NULL,
  `Additional Phone` varchar(255) DEFAULT NULL,
  `Fax` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Referring Physician`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sheet1`
--

LOCK TABLES `sheet1` WRITE;
/*!40000 ALTER TABLE `sheet1` DISABLE KEYS */;
/*!40000 ALTER TABLE `sheet1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-30 day discharge`
--

DROP TABLE IF EXISTS `sts-30 day discharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-30 day discharge` (
  `30daystatus` int(11) NOT NULL DEFAULT '0',
  `30daydefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`30daystatus`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-30 day discharge`
--

LOCK TABLES `sts-30 day discharge` WRITE;
/*!40000 ALTER TABLE `sts-30 day discharge` DISABLE KEYS */;
INSERT INTO `sts-30 day discharge` VALUES (1,'Alive'),(2,'Dead');
/*!40000 ALTER TABLE `sts-30 day discharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-air leak - not used`
--

DROP TABLE IF EXISTS `sts-air leak - not used`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-air leak - not used` (
  `airleakmeasures` int(11) DEFAULT '0',
  `airleakdefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-air leak - not used`
--

LOCK TABLES `sts-air leak - not used` WRITE;
/*!40000 ALTER TABLE `sts-air leak - not used` DISABLE KEYS */;
INSERT INTO `sts-air leak - not used` VALUES (NULL,NULL),(10,'No Air Leak Control Measures'),(20,'Additional Sutures'),(30,'Stapling'),(40,'Fibrin Glue'),(50,'Pericardial Strips'),(60,'FocalSeal-L Lung Sealant'),(70,'Muscle Flap Transposition'),(777,'Other Air Leak Control Measures');
/*!40000 ALTER TABLE `sts-air leak - not used` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-approach`
--

DROP TABLE IF EXISTS `sts-approach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-approach` (
  `Approach` int(11) NOT NULL DEFAULT '0',
  `apprdefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Approach`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-approach`
--

LOCK TABLES `sts-approach` WRITE;
/*!40000 ALTER TABLE `sts-approach` DISABLE KEYS */;
INSERT INTO `sts-approach` VALUES (4,'Thoracoscopy'),(5,'Thoracotomy'),(6,'Thoracoabdominal'),(7,'Median Sternotomy'),(8,'Partial Sternotomy'),(9,'Transverse Sternotomy'),(10,'Laparotomy'),(11,'Laparoscopy'),(12,'Cervical'),(13,'Subxyphoid'),(777,'Other Approach');
/*!40000 ALTER TABLE `sts-approach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-asa`
--

DROP TABLE IF EXISTS `sts-asa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-asa` (
  `ASA` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `ASADefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ASA`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-asa`
--

LOCK TABLES `sts-asa` WRITE;
/*!40000 ALTER TABLE `sts-asa` DISABLE KEYS */;
INSERT INTO `sts-asa` VALUES (1,'I'),(2,'II'),(3,'III'),(4,'IV'),(5,'V');
/*!40000 ALTER TABLE `sts-asa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-category`
--

DROP TABLE IF EXISTS `sts-category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-category` (
  `Category` int(11) NOT NULL DEFAULT '0',
  `catdefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Category`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-category`
--

LOCK TABLES `sts-category` WRITE;
/*!40000 ALTER TABLE `sts-category` DISABLE KEYS */;
INSERT INTO `sts-category` VALUES (2,'Trachea - Malignant'),(6,'Trachea - Benign'),(10,'Lung - Primary'),(20,'Lung - Benign'),(30,'Lung - Infection'),(40,'Mediastinum'),(50,'Metastases - Lung'),(60,'Metastases - Other'),(70,'Pleura -- Neoplastic'),(80,'Pleura -- Infection'),(90,'Pleura -- Other'),(100,'Esophagus - Primary'),(110,'Esophagus - Benign'),(120,'Primary Chest Wall'),(130,'Trauma'),(777,'Miscellaneous'),(140,'Larynx'),(150,'Thyroid'),(160,'Diaphragm'),(170,'Cardiovascular');
/*!40000 ALTER TABLE `sts-category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-cerebrohx`
--

DROP TABLE IF EXISTS `sts-cerebrohx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-cerebrohx` (
  `cerebroHx` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `cerebroHxDefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cerebroHx`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-cerebrohx`
--

LOCK TABLES `sts-cerebrohx` WRITE;
/*!40000 ALTER TABLE `sts-cerebrohx` DISABLE KEYS */;
INSERT INTO `sts-cerebrohx` VALUES (1,'No CVD history'),(2,'Any reversible event'),(3,'Any irreversible event');
/*!40000 ALTER TABLE `sts-cerebrohx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-clinm`
--

DROP TABLE IF EXISTS `sts-clinm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-clinm` (
  `ClinM` tinyint(3) unsigned DEFAULT '0',
  `ClinMDefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-clinm`
--

LOCK TABLES `sts-clinm` WRITE;
/*!40000 ALTER TABLE `sts-clinm` DISABLE KEYS */;
INSERT INTO `sts-clinm` VALUES (NULL,NULL),(1,'1'),(2,'X'),(3,'O');
/*!40000 ALTER TABLE `sts-clinm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-clinmab`
--

DROP TABLE IF EXISTS `sts-clinmab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-clinmab` (
  `ClinMab` tinyint(3) unsigned DEFAULT '0',
  `ClinMabDefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-clinmab`
--

LOCK TABLES `sts-clinmab` WRITE;
/*!40000 ALTER TABLE `sts-clinmab` DISABLE KEYS */;
INSERT INTO `sts-clinmab` VALUES (NULL,NULL),(1,'A'),(2,'B');
/*!40000 ALTER TABLE `sts-clinmab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-clinn`
--

DROP TABLE IF EXISTS `sts-clinn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-clinn` (
  `ClinN` tinyint(3) unsigned DEFAULT '0',
  `ClinNDefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-clinn`
--

LOCK TABLES `sts-clinn` WRITE;
/*!40000 ALTER TABLE `sts-clinn` DISABLE KEYS */;
INSERT INTO `sts-clinn` VALUES (NULL,NULL),(1,'1'),(2,'2'),(3,'3'),(4,'X'),(5,'O');
/*!40000 ALTER TABLE `sts-clinn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-clint`
--

DROP TABLE IF EXISTS `sts-clint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-clint` (
  `ClinT` tinyint(3) unsigned DEFAULT '0',
  `ClinTDefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-clint`
--

LOCK TABLES `sts-clint` WRITE;
/*!40000 ALTER TABLE `sts-clint` DISABLE KEYS */;
INSERT INTO `sts-clint` VALUES (NULL,NULL),(1,'1'),(2,'2'),(3,'3'),(4,'4'),(5,'X'),(6,'O'),(7,'S');
/*!40000 ALTER TABLE `sts-clint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-diabeteshx`
--

DROP TABLE IF EXISTS `sts-diabeteshx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-diabeteshx` (
  `diabeteshx` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `diabeteshxDefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`diabeteshx`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-diabeteshx`
--

LOCK TABLES `sts-diabeteshx` WRITE;
/*!40000 ALTER TABLE `sts-diabeteshx` DISABLE KEYS */;
INSERT INTO `sts-diabeteshx` VALUES (1,'No diabetes'),(2,'Diet controlled'),(3,'Oral hypoglycemics'),(4,'Insulin');
/*!40000 ALTER TABLE `sts-diabeteshx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-diagcategory`
--

DROP TABLE IF EXISTS `sts-diagcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-diagcategory` (
  `Category` int(11) NOT NULL DEFAULT '0',
  `catdefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Category`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-diagcategory`
--

LOCK TABLES `sts-diagcategory` WRITE;
/*!40000 ALTER TABLE `sts-diagcategory` DISABLE KEYS */;
INSERT INTO `sts-diagcategory` VALUES (10,'Trachea'),(40,'Lung'),(20,'Mediastinum'),(70,'Pleura'),(50,'Esophagus'),(80,'Chest Wall'),(100,'Trauma'),(777,'Miscellaneous'),(30,'Larynx'),(60,'Thyroid'),(90,'Diaphragm'),(110,'Cardiovascular');
/*!40000 ALTER TABLE `sts-diagcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-diagnosiscodes`
--

DROP TABLE IF EXISTS `sts-diagnosiscodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-diagnosiscodes` (
  `STSDiagCode` int(11) NOT NULL,
  `Diagnosis` varchar(255) DEFAULT NULL,
  `ICD9` varchar(10) DEFAULT NULL,
  `STSCategory` int(11) DEFAULT NULL,
  PRIMARY KEY (`STSDiagCode`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-diagnosiscodes`
--

LOCK TABLES `sts-diagnosiscodes` WRITE;
/*!40000 ALTER TABLE `sts-diagnosiscodes` DISABLE KEYS */;
INSERT INTO `sts-diagnosiscodes` VALUES (110,'Tracheomalacia-congenital','748.3',10),(120,'Tracheomalacia-acquired','519.1',10),(130,'Tracheostenosis-congential','748.3',10),(140,'Tracheostenosis-acquired','519.1',10),(150,'Tracheostomy-hemmorhage','519.09',10),(160,'Tracheostomy rel stenosis','519.02',10),(170,'Tracheal tumor-malignant','1620',10),(180,'Tracheal tumor-benign','212.2',10),(190,'Tracheal tumor-metastatic','1973',10),(200,'Mediastinitis','5192',20),(205,'Med nodes - metastatic','1961',20),(210,'Med nodes - benign','2290',20),(215,'Ant Med Tumor-primary','1642',20),(220,'Ant Med Tumor-metastatic','1971',20),(225,'Ant Med Tumor-benign','2125',20),(230,'Ant Med Tumor-Thymus','1640',20),(235,'Lymphoma-intrathoracic','1643',20),(240,'Post med malign primary','1643',20),(245,'Post med tumor-metastatic','1971',20),(300,'Subglottic stenosis-congen','7483',30),(310,'Subglottic stenosis-acquired','47884',30),(320,'Vocal cord paralysis','7483',30),(400,'Lung tumor, metastatic','1970',40),(405,'Lung tumor, benign','2123',40),(410,'Lung cancer, main','1622',40),(415,'Lung cancer, upper','1623',40),(420,'Lung cancer, middle','1624',40),(425,'Lung cancer, lower','1625',40),(430,'Lung cancer, other','1629',40),(435,'Lung abscess','5130',40),(440,'Pneumothorax','5128',40),(445,'Bronchiectasis','4940',40),(450,'Empyema with fistula','5100',40),(455,'Empyema without fistula','5109',40),(460,'Emphysema','4928',40),(465,'Emphsematous bleb','4920',40),(470,'Interstital Fibrosis','5163',40),(475,'Pneumonia','486',40),(480,'ARDS','5185',40),(485,'Hemothorax','5118',40),(490,'Lung nodule, benign','51889',40),(500,'Esophageal cancer -upper','1505',50),(505,'Esophageal cancer- mid','1504',50),(510,'Esophageal cancer-lower','1503',50),(515,'Esophageal cancer-GEJ','1510',50),(520,'Esophageal stricture','5303',50),(525,'Barrett\'s esophagus','53085',50),(530,'Achalasia','5300',50),(535,'Esophageal peforation','5304',50),(540,'Zenkers diverticulum','5306',50),(545,'Epiphrenic diverticulum','5304',50),(550,'GERD','53084',50),(555,'Acquired pyloric stenosis','5370',50),(560,'Acquired abs of esophagus','V4579',50),(600,'Goiter, nodular','2419',60),(610,'Thyroid neoplasm, malign','193',60),(620,'Thyroid neoplasm, benign','226',60),(255,'Myasthenia gravis','3580',20),(260,'Med cyst - bronchogenic','5193',20),(265,'Med cyst - foregut dupl','5193',20),(270,'Med cyst - pericardial','5193',20),(275,'Med cyst - thymic','5193',20),(700,'Pleural effusion - sterile','5119',70),(705,'Pleural effusion - infected','5119',70),(710,'Pleural effusion - malignant','1972',70),(715,'Pleural tumor - malignant','1639',70),(720,'Pleural tumor - benign','2124',70),(725,'Pleural thickening','511',70),(800,'Pectus excavatum','75481',80),(250,'Post med tumor-benign','2125',20),(805,'Pectus carinatum','75482',80),(810,'Sternal tumor - malign','1703',80),(815,'Sternal tumor - metastatic','1985',80),(820,'Sternal tumor - benign','2133',80),(825,'Rib tumor - malignant','1703',80),(830,'Rib tumor - metastatic','1985',80),(835,'Rib tumor - benign','2133',80),(840,'Thoracic outlet syndrome','3530',80),(900,'Diaphragmatic paralysis','5194',90),(905,'Diaphragm tumor - malign','1714',90),(910,'Diaphragm tumor - metast','19889',90),(915,'Diaphragm tumor - benign','2154',90),(1000,'Rib fracture','8070',100),(1005,'Sternal fracture','8072',100),(1010,'Flail chest','8074',100),(1015,'Tracheal injury','8075',100),(1020,'Traumatic Pneumothorax','8600',100),(1025,'Traumatic hemothoarx','8602',100),(1030,'Traumatic hemopneumo','8604',100),(1035,'Lung contusion','86121',100),(1040,'Lung laceration','86122',100),(1045,'Diaphragm injury','8620',100),(1050,'Esophageal injury','86222',100),(1055,'Bronchus injury','86221',100),(1100,'Pericarditis with effusion','42090',110),(1105,'Pericardial effusion, malig','19889',110),(1110,'SVC syndrome','4592',110),(1200,'Hyperhidrosis','70521',777),(1210,'Lymphadenopathy','7856',777),(1220,'Abnormal radiologic finding','7931',777);
/*!40000 ALTER TABLE `sts-diagnosiscodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-discharge location`
--

DROP TABLE IF EXISTS `sts-discharge location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-discharge location` (
  `DischargeLocation` varchar(255) NOT NULL,
  PRIMARY KEY (`DischargeLocation`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-discharge location`
--

LOCK TABLES `sts-discharge location` WRITE;
/*!40000 ALTER TABLE `sts-discharge location` DISABLE KEYS */;
INSERT INTO `sts-discharge location` VALUES ('Extended Care'),('Home'),('Hospice'),('Nursing Home'),('Other'),('Other Hosp');
/*!40000 ALTER TABLE `sts-discharge location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-discharge status`
--

DROP TABLE IF EXISTS `sts-discharge status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-discharge status` (
  `discstatus` int(11) NOT NULL DEFAULT '0',
  `discstatusdefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`discstatus`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-discharge status`
--

LOCK TABLES `sts-discharge status` WRITE;
/*!40000 ALTER TABLE `sts-discharge status` DISABLE KEYS */;
INSERT INTO `sts-discharge status` VALUES (1,'Alive'),(2,'Dead');
/*!40000 ALTER TABLE `sts-discharge status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-gender`
--

DROP TABLE IF EXISTS `sts-gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-gender` (
  `gender` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `genderdefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`gender`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-gender`
--

LOCK TABLES `sts-gender` WRITE;
/*!40000 ALTER TABLE `sts-gender` DISABLE KEYS */;
INSERT INTO `sts-gender` VALUES (1,'Male'),(2,'Female');
/*!40000 ALTER TABLE `sts-gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-hospital`
--

DROP TABLE IF EXISTS `sts-hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-hospital` (
  `HospCode` int(11) NOT NULL,
  `Hospital Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`HospCode`),
  KEY `HospCode` (`HospCode`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-hospital`
--

LOCK TABLES `sts-hospital` WRITE;
/*!40000 ALTER TABLE `sts-hospital` DISABLE KEYS */;
INSERT INTO `sts-hospital` VALUES (1,'University Hospital');
/*!40000 ALTER TABLE `sts-hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-infection`
--

DROP TABLE IF EXISTS `sts-infection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-infection` (
  `infection` tinyint(3) unsigned DEFAULT '0',
  `infectiondefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-infection`
--

LOCK TABLES `sts-infection` WRITE;
/*!40000 ALTER TABLE `sts-infection` DISABLE KEYS */;
INSERT INTO `sts-infection` VALUES (NULL,NULL),(1,'Gram-(+) bacteria'),(2,'Gram-(-) bacteria'),(3,'Fungal'),(4,'Mycobacterium Tuberculosis'),(5,'Multi-drug resistant tuberculosis'),(6,'Mycobacterium other than tuberculosis');
/*!40000 ALTER TABLE `sts-infection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-insurance`
--

DROP TABLE IF EXISTS `sts-insurance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-insurance` (
  `STSInsurance` varchar(255) NOT NULL,
  PRIMARY KEY (`STSInsurance`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-insurance`
--

LOCK TABLES `sts-insurance` WRITE;
/*!40000 ALTER TABLE `sts-insurance` DISABLE KEYS */;
INSERT INTO `sts-insurance` VALUES ('Commercial'),('Govt-IndianHealth'),('Govt-Medicaid'),('Govt-Medicare FFS'),('Govt-Medicare HIC'),('Govt-Military'),('Govt-StateSpecific'),('HMO'),('None/Self'),('NonUS Insured');
/*!40000 ALTER TABLE `sts-insurance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-mt30stat`
--

DROP TABLE IF EXISTS `sts-mt30stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-mt30stat` (
  `Mt30Stat` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `Mt30StatDefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Mt30Stat`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-mt30stat`
--

LOCK TABLES `sts-mt30stat` WRITE;
/*!40000 ALTER TABLE `sts-mt30stat` DISABLE KEYS */;
INSERT INTO `sts-mt30stat` VALUES (1,'Alive'),(2,'Dead');
/*!40000 ALTER TABLE `sts-mt30stat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-mtdcstat`
--

DROP TABLE IF EXISTS `sts-mtdcstat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-mtdcstat` (
  `MtDCStat` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `MtDCStatDefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MtDCStat`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-mtdcstat`
--

LOCK TABLES `sts-mtdcstat` WRITE;
/*!40000 ALTER TABLE `sts-mtdcstat` DISABLE KEYS */;
INSERT INTO `sts-mtdcstat` VALUES (1,'Alive'),(2,'Dead');
/*!40000 ALTER TABLE `sts-mtdcstat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-newgstage`
--

DROP TABLE IF EXISTS `sts-newgstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-newgstage` (
  `Gstage New` varchar(255) NOT NULL,
  PRIMARY KEY (`Gstage New`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-newgstage`
--

LOCK TABLES `sts-newgstage` WRITE;
/*!40000 ALTER TABLE `sts-newgstage` DISABLE KEYS */;
INSERT INTO `sts-newgstage` VALUES ('G1'),('G2'),('G3'),('G4'),('Gx');
/*!40000 ALTER TABLE `sts-newgstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-newhstage`
--

DROP TABLE IF EXISTS `sts-newhstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-newhstage` (
  `Hstage New` varchar(255) NOT NULL,
  PRIMARY KEY (`Hstage New`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-newhstage`
--

LOCK TABLES `sts-newhstage` WRITE;
/*!40000 ALTER TABLE `sts-newhstage` DISABLE KEYS */;
INSERT INTO `sts-newhstage` VALUES ('H1'),('H2');
/*!40000 ALTER TABLE `sts-newhstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-newmstage`
--

DROP TABLE IF EXISTS `sts-newmstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-newmstage` (
  `Mstage New` varchar(255) NOT NULL,
  PRIMARY KEY (`Mstage New`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-newmstage`
--

LOCK TABLES `sts-newmstage` WRITE;
/*!40000 ALTER TABLE `sts-newmstage` DISABLE KEYS */;
INSERT INTO `sts-newmstage` VALUES ('M0'),('M1'),('M1a'),('M1b');
/*!40000 ALTER TABLE `sts-newmstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-newnstage`
--

DROP TABLE IF EXISTS `sts-newnstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-newnstage` (
  `Nstage New` varchar(255) NOT NULL,
  PRIMARY KEY (`Nstage New`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-newnstage`
--

LOCK TABLES `sts-newnstage` WRITE;
/*!40000 ALTER TABLE `sts-newnstage` DISABLE KEYS */;
INSERT INTO `sts-newnstage` VALUES ('N0'),('N1'),('N1a'),('N1b'),('N2'),('N3');
/*!40000 ALTER TABLE `sts-newnstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-newtstage`
--

DROP TABLE IF EXISTS `sts-newtstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-newtstage` (
  `Tstage New` varchar(255) NOT NULL,
  PRIMARY KEY (`Tstage New`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-newtstage`
--

LOCK TABLES `sts-newtstage` WRITE;
/*!40000 ALTER TABLE `sts-newtstage` DISABLE KEYS */;
INSERT INTO `sts-newtstage` VALUES ('T0'),('T1a'),('T1b'),('T2a'),('T2b'),('T3'),('T4'),('T4a'),('T4b'),('Tis');
/*!40000 ALTER TABLE `sts-newtstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-orgsys`
--

DROP TABLE IF EXISTS `sts-orgsys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-orgsys` (
  `orgsys1` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `orgsysDefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`orgsys1`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-orgsys`
--

LOCK TABLES `sts-orgsys` WRITE;
/*!40000 ALTER TABLE `sts-orgsys` DISABLE KEYS */;
INSERT INTO `sts-orgsys` VALUES (1,'Chest Wall'),(2,'Mediastinum/Neck'),(3,'Tracheobronchial'),(4,'Pulmonary'),(5,'Esophagogastric'),(6,'Cardiac/Pericardium/Great Vessels'),(7,'Diaphragm'),(8,'Pleura'),(9,'Air Leak Control Measure'),(11,'Chest Wall'),(12,'Trachea and Bronchi'),(13,'VATS'),(14,'Pleural Space and Lung'),(15,'Bronchscopy'),(16,'Lung Other'),(17,'Thymus'),(18,'Mediastinum/Diaphragm'),(19,'Esophagus'),(20,'Esophagoscopy'),(21,'Miscellaneous');
/*!40000 ALTER TABLE `sts-orgsys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-pathm`
--

DROP TABLE IF EXISTS `sts-pathm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-pathm` (
  `PathM` tinyint(3) unsigned DEFAULT '0',
  `PathMDefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-pathm`
--

LOCK TABLES `sts-pathm` WRITE;
/*!40000 ALTER TABLE `sts-pathm` DISABLE KEYS */;
INSERT INTO `sts-pathm` VALUES (NULL,NULL),(1,'1'),(2,'X'),(3,'O');
/*!40000 ALTER TABLE `sts-pathm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-pathmab`
--

DROP TABLE IF EXISTS `sts-pathmab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-pathmab` (
  `PathMab` tinyint(3) unsigned DEFAULT '0',
  `PathMabDefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-pathmab`
--

LOCK TABLES `sts-pathmab` WRITE;
/*!40000 ALTER TABLE `sts-pathmab` DISABLE KEYS */;
INSERT INTO `sts-pathmab` VALUES (NULL,NULL),(1,'A'),(2,'B');
/*!40000 ALTER TABLE `sts-pathmab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-pathn`
--

DROP TABLE IF EXISTS `sts-pathn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-pathn` (
  `PathN` tinyint(3) unsigned DEFAULT '0',
  `PathNDefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-pathn`
--

LOCK TABLES `sts-pathn` WRITE;
/*!40000 ALTER TABLE `sts-pathn` DISABLE KEYS */;
INSERT INTO `sts-pathn` VALUES (NULL,NULL),(1,'1'),(2,'2'),(3,'3'),(4,'X'),(5,'O');
/*!40000 ALTER TABLE `sts-pathn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-patht`
--

DROP TABLE IF EXISTS `sts-patht`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-patht` (
  `PathT` tinyint(3) unsigned DEFAULT '0',
  `PathTDefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-patht`
--

LOCK TABLES `sts-patht` WRITE;
/*!40000 ALTER TABLE `sts-patht` DISABLE KEYS */;
INSERT INTO `sts-patht` VALUES (NULL,NULL),(1,'1'),(2,'2'),(3,'3'),(4,'4'),(5,'X'),(6,'O'),(7,'S');
/*!40000 ALTER TABLE `sts-patht` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-patientinfo`
--

DROP TABLE IF EXISTS `sts-patientinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-patientinfo` (
  `PatID` int(11) NOT NULL AUTO_INCREMENT,
  `MedRecN` varchar(20) DEFAULT NULL,
  `PatFName` varchar(20) DEFAULT NULL,
  `PatMInit` varchar(1) DEFAULT NULL,
  `PatLName` varchar(25) DEFAULT NULL,
  `SSN` varchar(12) DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `PostalCode` varchar(10) DEFAULT NULL,
  `Gender` tinyint(3) unsigned DEFAULT NULL,
  `Race` int(11) DEFAULT NULL,
  PRIMARY KEY (`PatID`),
  KEY `Gender` (`Gender`),
  KEY `Race` (`Race`),
  KEY `PostalCode` (`PostalCode`),
  KEY `PatID` (`PatID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-patientinfo`
--

LOCK TABLES `sts-patientinfo` WRITE;
/*!40000 ALTER TABLE `sts-patientinfo` DISABLE KEYS */;
INSERT INTO `sts-patientinfo` VALUES (1,'11111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'1111','Daniel',NULL,'Baram','123123123','1923-02-21 00:00:00','11733',1,1);
/*!40000 ALTER TABLE `sts-patientinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-procedure master list`
--

DROP TABLE IF EXISTS `sts-procedure master list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-procedure master list` (
  `sysproc` int(11) NOT NULL DEFAULT '0',
  `sysprocdefn` varchar(45) DEFAULT NULL,
  `orgsys` tinyint(3) unsigned DEFAULT '0',
  `orgsysdefn` varchar(35) DEFAULT NULL,
  `CPT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sysproc`),
  KEY `sysproc` (`sysproc`),
  KEY `orgsys` (`orgsys`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-procedure master list`
--

LOCK TABLES `sts-procedure master list` WRITE;
/*!40000 ALTER TABLE `sts-procedure master list` DISABLE KEYS */;
INSERT INTO `sts-procedure master list` VALUES (110,'Mediastinal LN Biopsy',2,'Mediastinum/Neck',NULL),(120,'Mediastinoscopy',2,'Mediastinum/Neck',NULL),(130,'Anterior Mediastinotomy',2,'Mediastinum/Neck',NULL),(140,'Extended Cervical Mediastinoscopy',2,'Mediastinum/Neck',NULL),(150,'Mediastinal Lymph Node Dissection',2,'Mediastinum/Neck',NULL),(160,'Mediastinal Lymph Node Sampling',2,'Mediastinum/Neck',NULL),(170,'Biopsy, Mediastinal Mass',2,'Mediastinum/Neck',NULL),(180,'Resection, Mediastinal Mass',2,'Mediastinum/Neck',NULL),(190,'Thymectomy',2,'Mediastinum/Neck',NULL),(200,'Sympathectomy',2,'Mediastinum/Neck',NULL),(210,'Thoracic duct ligation',2,'Mediastinum/Neck',NULL),(220,'Other Mediastinal/Neck procedure',2,'Mediastinum/Neck',NULL),(230,'Flexible Bronchoscopy',3,'Tracheobronchial',NULL),(240,'Rigid Bronchoscopy',3,'Tracheobronchial',NULL),(250,'Removal of Foreign Body (Tracheobronchial)',3,'Tracheobronchial',NULL),(260,'Endobronchial ablation, laser/PDT/ERBE',3,'Tracheobronchial',NULL),(265,'Endobronchial ablation, mechanical',3,'Tracheobronchial',NULL),(270,'Tracheal/Bronchial Stent',3,'Tracheobronchial',NULL),(280,'Tracheostomy',3,'Tracheobronchial',NULL),(290,'Tracheal Repair',3,'Tracheobronchial',NULL),(300,'Tracheal Stricture Resection',3,'Tracheobronchial',NULL),(310,'Tracheal Tumor Resection',3,'Tracheobronchial',NULL),(320,'Carinal Resection',3,'Tracheobronchial',NULL),(330,'Bronchotomy',3,'Tracheobronchial',NULL),(340,'Bronchial Repair',3,'Tracheobronchial',NULL),(350,'Bronchoplasty',3,'Tracheobronchial',NULL),(370,'TE Fistula Repair',3,'Tracheobronchial',NULL),(380,'Other Tracheobroncial procedure',3,'Tracheobronchial',NULL),(390,'Wedge Resection, single',4,'Pulmonary',NULL),(400,'Wedge Resection, multiple',4,'Pulmonary',NULL),(410,'Segmentectomy',4,'Pulmonary',NULL),(420,'Lobectomy',4,'Pulmonary',NULL),(425,'Sleeve lobectomy',4,'Pulmonary',NULL),(430,'Bilobectomy',4,'Pulmonary',NULL),(440,'Pneumonectomy, standard',4,'Pulmonary',NULL),(445,'Pneumonectomy, carinal',4,'Pulmonary',NULL),(450,'Completion pneumonectomy',4,'Pulmonary',NULL),(452,'Cryotherapy',4,'Pulmonary',NULL),(455,'RFA',4,'Pulmonary',NULL),(460,'Extrapleural pneumonectomy',4,'Pulmonary',NULL),(470,'Pneumonectomy, intrapericardial',4,'Pulmonary',NULL),(480,'Lung Volume Reduction',4,'Pulmonary',NULL),(490,'Bullectomy / repair',4,'Pulmonary',NULL),(500,'Hydatid Cyst Resection',4,'Pulmonary',NULL),(510,'Single Lung Transplant',4,'Pulmonary',NULL),(520,'Double Lung Transplant',4,'Pulmonary',NULL),(530,'Lung Donor Harvest',4,'Pulmonary',NULL),(540,'Other Lung procedure',4,'Pulmonary',NULL),(550,'Esophagoscopy, flexible',5,'Esophagogastric',NULL),(560,'Esophagoscopy, rigid',5,'Esophagogastric',NULL),(570,'Removal of Foreign Body (Esophagogastric)',5,'Esophagogastric',NULL),(580,'Dilation of Esophagus',5,'Esophagogastric',NULL),(590,'Esophageal Tumor Ablation, Laser/PDT',5,'Esophagogastric',NULL),(600,'Stent Placement',5,'Esophagogastric',NULL),(610,'Cervical esophagostomy',5,'Esophagogastric',NULL),(620,'Anterior Thoracic Esophagostomy',5,'Esophagogastric',NULL),(630,'Zenker\'s Diverticulum Repair',5,'Esophagogastric',NULL),(640,'Myotocomy, cricopharyngeal',5,'Esophagogastric',NULL),(650,'Myotomy, esophageal (long)',5,'Esophagogastric',NULL),(660,'Myotomy, cardia (short)',5,'Esophagogastric',NULL),(670,'Resection, intrathoracic diverticulum',5,'Esophagogastric',NULL),(680,'Resection, esophagus (esophagectomy)',5,'Esophagogastric',NULL),(2001,'Muscle Flap, Neck',11,'Chest Wall',NULL),(690,'Resection, esophageal wall lesion',5,'Esophagogastric',NULL),(692,'Repair, performation of esophagus-Iatrogenic',5,'Esophagogastric',NULL),(694,'Repair, performation of esophagus-Malignant',5,'Esophagogastric',NULL),(696,'Repair, performation of esophagus-Other',5,'Esophagogastric',NULL),(700,'Fundoplication, circumferentia',5,'Esophagogastric',NULL),(710,'Fundoplication, partial',5,'Esophagogastric',NULL),(720,'Gastroplasty',5,'Esophagogastric',NULL),(730,'Pyloroplasty',5,'Esophagogastric',NULL),(740,'Pyloromyotomy',5,'Esophagogastric',NULL),(750,'Gastrectomy',5,'Esophagogastric',NULL),(760,'Gastrostomy',5,'Esophagogastric',NULL),(770,'Jejunostomy',5,'Esophagogastric',NULL),(780,'Conduit, gastric',5,'Esophagogastric',NULL),(790,'Conduit, colon',5,'Esophagogastric',NULL),(800,'Conduit, jejunum',5,'Esophagogastric',NULL),(810,'Conduit, other',5,'Esophagogastric',NULL),(820,'Anastomosis, neck',5,'Esophagogastric',NULL),(830,'Anastomosis, chest',5,'Esophagogastric',NULL),(840,'Other Esophageal procedure',5,'Esophagogastric',NULL),(850,'Other GI procedure',5,'Esophagogastric',NULL),(860,'Pericardial Window',6,'Heart/Pericardium/Great Vessels',NULL),(870,'Pericardiectomy',6,'Heart/Pericardium/Great Vessels',NULL),(880,'Repair Cardiac Laceration',6,'Heart/Pericardium/Great Vessels',NULL),(890,'Other Pericardial Procedure',6,'Heart/Pericardium/Great Vessels',NULL),(900,'Repair / Reconstruction, thoracic aorta',6,'Heart/Pericardium/Great Vessels',NULL),(910,'Repair / Reconstruction, abd aorta',6,'Heart/Pericardium/Great Vessels',NULL),(920,'Repair / Reconstruction, SVC',6,'Heart/Pericardium/Great Vessels',NULL),(930,'Repair / Reconstruction, IVC',6,'Heart/Pericardium/Great Vessels',NULL),(940,'Repair / Reconstruction, pulmonary artery',6,'Heart/Pericardium/Great Vessels',NULL),(950,'Repair / Reconstruction, pulmonary vein(s)',6,'Heart/Pericardium/Great Vessels',NULL),(960,'Repair / Reconstruction, left atrium',6,'Heart/Pericardium/Great Vessels',NULL),(970,'Cardiopulmonary Bypass',6,'Heart/Pericardium/Great Vessels',NULL),(980,'Other Cardiac procedure',6,'Heart/Pericardium/Great Vessels',NULL),(990,'Plication of Diaphragm',7,'Diaphragm',NULL),(1000,'Diaphragmatic Hernia Repair, acute',7,'Diaphragm',NULL),(1010,'Diaphragmatic Hernia Repair, chronic',7,'Diaphragm',NULL),(1020,'Resection of Diaphragm',7,'Diaphragm',NULL),(1030,'Reconstruction of Diaphragm',7,'Diaphragm',NULL),(1040,'Other Diaphragm procedure',7,'Diaphragm',NULL),(1050,'Pleural Drainage Procedure -- Open',8,'Pleura',NULL),(1060,'Pleural Drainage Procedure -- Closed',8,'Pleura',NULL),(1070,'Pleural Biopsy',8,'Pleura',NULL),(1080,'Pleurodesis',8,'Pleura',NULL),(1090,'Pleurectomy',8,'Pleura',NULL),(1100,'Decortication',8,'Pleura',NULL),(1110,'Clagett Procedure',8,'Pleura',NULL),(1120,'Other Pleural procedure',8,'Pleura',NULL),(1130,'Fibrin glue',9,'Air Leak Control Measure',NULL),(1140,'Pericardial strips',9,'Air Leak Control Measure',NULL),(1150,'Lung sealant',9,'Air Leak Control Measure',NULL),(1160,'Pleural tent',9,'Air Leak Control Measure',NULL),(1170,'Other air leak control measure',9,'Air Leak Control Measure',NULL),(2002,'Muscle Flap, Trunk',11,'Chest Wall',NULL),(2003,'Excis Chest Wall Tumor, Ribs',11,'Chest Wall',NULL),(2004,'Excis Chest Wall Tumor, Ribs/Reconst',11,'Chest Wall',NULL),(2005,'Excis tumor, neck/thorax, SubQ',11,'Chest Wall',NULL),(2006,'Excis tumor, neck/thorax, deep',11,'Chest Wall',NULL),(2007,'Radical resecion of tumor neck/thorax',11,'Chest Wall',NULL),(2008,'Excision of rib, partial',11,'Chest Wall',NULL),(2009,'Excision of 1st/cervical rib',11,'Chest Wall',NULL),(2010,'Excision of 1/cerv rib, sympathectomy',11,'Chest Wall',NULL),(2011,'Radical resection of Sternum',11,'Chest Wall',NULL),(2012,'Radical resetion sternum, lymphaden',11,'Chest Wall',NULL),(2013,'Hyoid myotomy/resuspension',11,'Chest Wall',NULL),(2014,'Division of Scalenus Anterior w/o rib',11,'Chest Wall',NULL),(2015,'Division of Scalenus Anterior w/ rib',11,'Chest Wall',NULL),(2016,'Reconstruc of pectus  open',11,'Chest Wall',NULL),(2017,'Reconstruc of pectus  minim',11,'Chest Wall',NULL),(2018,'Reconstruc of pectus  via scope',11,'Chest Wall',NULL),(2019,'Open treatment of Sternum',11,'Chest Wall',NULL),(2020,'Unlisted procedure',11,'Chest Wall',NULL),(10,'Chest Wall Biopsy',1,'Chest Wall',NULL),(20,'Rib Resection (single)',1,'Chest Wall',NULL),(30,'First/Cervical Rib Resection',1,'Chest Wall',NULL),(40,'Chest Wall Resection',1,'Chest Wall',NULL),(50,'Chest Wall Reconstruction',1,'Chest Wall',NULL),(60,'Thoracoplasty',1,'Chest Wall',NULL),(70,'Pectus Repair',1,'Chest Wall',NULL),(80,'Sternectomy, complete',1,'Chest Wall',NULL),(90,'Sternectomy, partial',1,'Chest Wall',NULL),(95,'Muscle flap',1,'Chest Wall',NULL),(100,'Other Chest Wall Repair',1,'Chest Wall',NULL),(2100,'Tracheoplasty, cervical',12,'Trachea and Bronchi',NULL),(2101,'Tracheoplasty, intrathoracic',12,'Trachea and Bronchi',NULL),(2102,'Carinal reconstruction',12,'Trachea and Bronchi',NULL),(2103,'Bronchoplasty, excision and anast',12,'Trachea and Bronchi',NULL),(2104,'Excis trach stenosis/anast cervical',12,'Trachea and Bronchi',NULL),(2105,'Excis trach steno/anast, cervicothorac',12,'Trachea and Bronchi',NULL),(2106,'Excision tracheal tumor, cervical',12,'Trachea and Bronchi',NULL),(2107,'Excision tracheal tumor, thoracic',12,'Trachea and Bronchi',NULL),(2108,'Suture of tracheal wound, cervical',12,'Trachea and Bronchi',NULL),(2109,'Suture of tracheal wound, thoracic',12,'Trachea and Bronchi',NULL),(2200,'Thoracoscopy, diagnostic no biopsy',13,'VATS',NULL),(2201,'Thoracoscopy, with biopsy',13,'VATS',NULL),(2202,'Thoracoscopy, pericardial, no biopsy',13,'VATS',NULL),(2203,'Thoracoscopy, pericardial, biopsy',13,'VATS',NULL),(2204,'Thoracoscopy, mediastinal, no biopsy',13,'VATS',NULL),(2205,'Thoracoscopy, mediastinal, biopsy',13,'VATS',NULL),(2206,'Thoracoscopy, pleurodesis',13,'VATS',NULL),(2207,'Thoracoscopy, partial decoritcation',13,'VATS',NULL),(2250,'Thoracostomy, rib resection for empyema',14,'Pleural Space and Lung',NULL),(2251,'Thoracostomy, open flap empyema',14,'Pleural Space and Lung',NULL),(2252,'Thoracotomy, limited for biopsy',14,'Pleural Space and Lung',NULL),(2253,'Thoracotomy, major for explor/biopsy',14,'Pleural Space and Lung',NULL),(2254,'Thoracotomy, major for bleeding/tear',14,'Pleural Space and Lung',NULL),(2255,'Thoracotomy, major for post op',14,'Pleural Space and Lung',NULL),(2256,'Thoracotomy, excision bullae',14,'Pleural Space and Lung',NULL),(2257,'Thoracotomy, intrapleural foreign body',14,'Pleural Space and Lung',NULL),(2258,'Thoracotomy, open heart massage',14,'Pleural Space and Lung',NULL),(2259,'Pleural scarification for pneumothorax',14,'Pleural Space and Lung',NULL),(2260,'Decortication, total',14,'Pleural Space and Lung',NULL),(2261,'Decortication, partial',14,'Pleural Space and Lung',NULL),(2262,'Decortication, parietal',14,'Pleural Space and Lung',NULL),(2263,'Decortication and pleurectomy',14,'Pleural Space and Lung',NULL),(2264,'Biopsy pleura open',14,'Pleural Space and Lung',NULL),(2265,'Pneumonectomy',14,'Pleural Space and Lung',NULL),(2266,'Sleeve/carinal pneumonectomy',14,'Pleural Space and Lung',NULL),(2267,'Extrapleural pneumonectomy',14,'Pleural Space and Lung',NULL),(2268,'Removal of single lobe',14,'Pleural Space and Lung',NULL),(2269,'Removal of two lobes',14,'Pleural Space and Lung',NULL),(2270,'Removal of segment',14,'Pleural Space and Lung',NULL),(2271,'Sleeve lobectomy',14,'Pleural Space and Lung',NULL),(2272,'Completion pneumonectomy',14,'Pleural Space and Lung',NULL),(2273,'Lung volume reduction',14,'Pleural Space and Lung',NULL),(2274,'Removal of lung, wedge',14,'Pleural Space and Lung',NULL),(2275,'Resect/repair of bronchus',14,'Pleural Space and Lung',NULL),(2276,'Pancoast - without reconstruction',14,'Pleural Space and Lung',NULL),(2277,'Pancoast - with reconstruction',14,'Pleural Space and Lung',NULL),(2278,'Extrapleural enucleation of empyema',14,'Pleural Space and Lung',NULL),(2300,'Scope via established tracheostomy',15,'Bronchoscopy',NULL),(2301,'EBUS',15,'Bronchoscopy',NULL),(2302,'Bronchoscopy, diagnostic',15,'Bronchoscopy',NULL),(2303,'Bronchoscopy, brush',15,'Bronchoscopy',NULL),(2304,'Bronchoscopy, BAL',15,'Bronchoscopy',NULL),(2305,'Bronchoscopy, biopsy',15,'Bronchoscopy',NULL),(2306,'Bronchoscopy, transbronch',15,'Bronchoscopy',NULL),(2307,'Bronchoscopy, TBNA',15,'Bronchoscopy',NULL),(2308,'Bronchoscopy, dilation',15,'Bronchoscopy',NULL),(2309,'Bronchoscopy, trach stent',15,'Bronchoscopy',NULL),(2310,'Bronchoscopy, addition transbronch',15,'Bronchoscopy',NULL),(2311,'Bronchoscopy, additional needle',15,'Bronchoscopy',NULL),(2312,'Bronchoscopy, foreign body',15,'Bronchoscopy',NULL),(2313,'Bronchoscopy, bronchial stent',15,'Bronchoscopy',NULL),(2314,'Bronchoscopy, addition bronch stent',15,'Bronchoscopy',NULL),(2315,'Bronchoscopy, revision of stent',15,'Bronchoscopy',NULL),(2316,'Bronchoscopy, excision of tumor',15,'Bronchoscopy',NULL),(2317,'Bronchoscopy, brachy',15,'Bronchoscopy',NULL),(2318,'Bronchoscopy, therapeutic aspiration',15,'Bronchoscopy',NULL),(2319,'Bronchoscopy, subseq aspiration',15,'Bronchoscopy',NULL),(2208,'VATS, pulm decortication total',13,'VATS',NULL),(2209,'VATS, removal foreign body',13,'VATS',NULL),(2210,'VATS, control of bleeding',13,'VATS',NULL),(2211,'VATS, bullae plication/excision',13,'VATS',NULL),(2212,'VATS, parietal pleurectomy',13,'VATS',NULL),(2213,'VATS, wedge of lung',13,'VATS',NULL),(2214,'VATS, removal clot pericardial',13,'VATS',NULL),(2215,'VATS, percaridal window',13,'VATS',NULL),(2216,'VATS, pericardiectomy',13,'VATS',NULL),(2217,'VATS, pericardial cyst',13,'VATS',NULL),(2218,'VATS, mediastinal cyst',13,'VATS',NULL),(2219,'VATS, lobectomy',13,'VATS',NULL),(2220,'VATS, thoracic sympathectomy',13,'VATS',NULL),(2221,'VATS, esophagomyotomy (Heller)',13,'VATS',NULL),(2400,'Tunneled pleural catheter',16,'Lung Other',NULL),(2401,'Repair lung hernia through chest',16,'Lung Other',NULL),(2402,'Cloure of chest wall follow flap',16,'Lung Other',NULL),(2403,'Major reconstruction posttrauma',16,'Lung Other',NULL),(2404,'Thoracoplasty, BPF',16,'Lung Other',NULL),(2405,'Total lung lavage PAP',16,'Lung Other',NULL),(2406,'Single lung transplant',16,'Lung Other',NULL),(2407,'Single lung  tranplant on CPB',16,'Lung Other',NULL),(2408,'Double lung transplant',16,'Lung Other',NULL),(2409,'Double lung transplant on CPB',16,'Lung Other',NULL),(2410,'Unlisted Procedure, lung',16,'Lung Other',NULL),(2500,'Thymectomy, transcervical',17,'Thymus',NULL),(2501,'Thymectomy, transthoracic',17,'Thymus',NULL),(2502,'Thymectomy, transthoracic, radical',17,'Thymus',NULL),(2503,'Thymectomy, VATS',17,'Thymus',NULL),(2600,'Thoracic lymphadenectomy',18,'Mediastinum/Diaphragm',NULL),(2601,'Mediastinotomy exploration, cervical',18,'Mediastinum/Diaphragm',NULL),(2602,'Mediastinotomy exploration, thoracic',18,'Mediastinum/Diaphragm',NULL),(2603,'Excision mediastinal cyst',18,'Mediastinum/Diaphragm',NULL),(2604,'Excision of medastinal tumor',18,'Mediastinum/Diaphragm',NULL),(2605,'Mediastinoscopy',18,'Mediastinum/Diaphragm',NULL),(2606,'Unlisted procedure',18,'Mediastinum/Diaphragm',NULL),(2607,'Repair diaphragm laceration',18,'Mediastinum/Diaphragm',NULL),(2608,'Repair paraesoph hiatal hernia',18,'Mediastinum/Diaphragm',NULL),(2609,'Repair diaphragm hernia, trauma acute',18,'Mediastinum/Diaphragm',NULL),(2610,'Repair diaphragm hernia, trauma chron',18,'Mediastinum/Diaphragm',NULL),(2611,'Imbrication/Plication',18,'Mediastinum/Diaphragm',NULL),(2612,'Resection of diaphragm',18,'Mediastinum/Diaphragm',NULL),(2613,'Resction with complex repair',18,'Mediastinum/Diaphragm',NULL),(2614,'Unlisted procedure',18,'Mediastinum/Diaphragm',NULL),(2700,'Esophagus procedure',19,'Esophagus',NULL),(2800,'Esophagoscopy',20,'Esophagoscopy',NULL),(2900,'Partial laryngecotmy',21,'Miscellaneous',NULL),(2901,'Ligation thoracic duct',21,'Miscellaneous',NULL),(2902,'Intraoperative Jejunostomy',21,'Miscellaneous',NULL),(2903,'Omental flap',21,'Miscellaneous',NULL),(2904,'Transthoracic thyroidectomy',21,'Miscellaneous',NULL),(2905,'Removal substernal thyroid',21,'Miscellaneous',NULL),(2906,'Tube pericardiostomy',21,'Miscellaneous',NULL),(2907,'Pericardial window',21,'Miscellaneous',NULL),(2908,'SVC resection/reconstruction',21,'Miscellaneous',NULL),(2909,'Other',21,'Miscellaneous',NULL),(2801,'Esopagoscopy with biopsy',20,'Esophagoscopy','43202'),(2802,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `sts-procedure master list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-race`
--

DROP TABLE IF EXISTS `sts-race`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-race` (
  `Race` int(11) NOT NULL DEFAULT '0',
  `Racedefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Race`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-race`
--

LOCK TABLES `sts-race` WRITE;
/*!40000 ALTER TABLE `sts-race` DISABLE KEYS */;
INSERT INTO `sts-race` VALUES (1,'Caucasian'),(2,'Black'),(3,'Hispanic'),(4,'Asian'),(5,'Native American'),(777,'Other'),(800,NULL);
/*!40000 ALTER TABLE `sts-race` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-renalhx`
--

DROP TABLE IF EXISTS `sts-renalhx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-renalhx` (
  `renalhx` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `renalhxDefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`renalhx`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-renalhx`
--

LOCK TABLES `sts-renalhx` WRITE;
/*!40000 ALTER TABLE `sts-renalhx` DISABLE KEYS */;
INSERT INTO `sts-renalhx` VALUES (1,'No renal insufficiency'),(2,'Creatinine >= 2'),(3,'Dialysis of any type');
/*!40000 ALTER TABLE `sts-renalhx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-smoking history`
--

DROP TABLE IF EXISTS `sts-smoking history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-smoking history` (
  `quitsmoking` tinyint(3) unsigned DEFAULT NULL,
  `smokinghx` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-smoking history`
--

LOCK TABLES `sts-smoking history` WRITE;
/*!40000 ALTER TABLE `sts-smoking history` DISABLE KEYS */;
INSERT INTO `sts-smoking history` VALUES (NULL,NULL),(1,'Never Smoker (<100 cigs/lifetime)'),(2,'Current smoker, quit <14 days pre-op'),(3,'quit >14 days; <= 1 month pre-op'),(4,'quit >1 month; <= 12 months pre-op'),(5,'quit > 12 months pre-op');
/*!40000 ALTER TABLE `sts-smoking history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-status`
--

DROP TABLE IF EXISTS `sts-status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-status` (
  `Status` tinyint(3) unsigned NOT NULL,
  `StatusDefn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Status`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-status`
--

LOCK TABLES `sts-status` WRITE;
/*!40000 ALTER TABLE `sts-status` DISABLE KEYS */;
INSERT INTO `sts-status` VALUES (1,'Emergent'),(2,'Urgent'),(3,'Elective');
/*!40000 ALTER TABLE `sts-status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-timing`
--

DROP TABLE IF EXISTS `sts-timing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-timing` (
  `STSTiming` int(11) NOT NULL DEFAULT '0',
  `Timing` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`STSTiming`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-timing`
--

LOCK TABLES `sts-timing` WRITE;
/*!40000 ALTER TABLE `sts-timing` DISABLE KEYS */;
INSERT INTO `sts-timing` VALUES (100,'None'),(200,'Same - within 6 months'),(300,'Unrelated- within 6 months'),(400,'Unrelated- >6 months'),(250,'Same - >6 months');
/*!40000 ALTER TABLE `sts-timing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-trauma`
--

DROP TABLE IF EXISTS `sts-trauma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-trauma` (
  `STSTrauma` int(11) NOT NULL DEFAULT '0',
  `Trauma` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`STSTrauma`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-trauma`
--

LOCK TABLES `sts-trauma` WRITE;
/*!40000 ALTER TABLE `sts-trauma` DISABLE KEYS */;
INSERT INTO `sts-trauma` VALUES (10,'Not OR Intervention'),(20,'If yes, Penetrating'),(30,'If yes, Non-penetrating');
/*!40000 ALTER TABLE `sts-trauma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-upin`
--

DROP TABLE IF EXISTS `sts-upin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-upin` (
  `UPIN` varchar(20) NOT NULL,
  `surgeon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UPIN`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-upin`
--

LOCK TABLES `sts-upin` WRITE;
/*!40000 ALTER TABLE `sts-upin` DISABLE KEYS */;
INSERT INTO `sts-upin` VALUES ('1','Thomas Bilfinger'),('2','Allison McLarty');
/*!40000 ALTER TABLE `sts-upin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-whenprior`
--

DROP TABLE IF EXISTS `sts-whenprior`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-whenprior` (
  `whenprior` tinyint(3) unsigned DEFAULT NULL,
  `whenpriordefn` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-whenprior`
--

LOCK TABLES `sts-whenprior` WRITE;
/*!40000 ALTER TABLE `sts-whenprior` DISABLE KEYS */;
INSERT INTO `sts-whenprior` VALUES (NULL,NULL),(1,'prior admission'),(2,'current admission');
/*!40000 ALTER TABLE `sts-whenprior` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sts-zubrod`
--

DROP TABLE IF EXISTS `sts-zubrod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sts-zubrod` (
  `STSZubrod` int(11) NOT NULL DEFAULT '0',
  `ZubrodDescription` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`STSZubrod`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sts-zubrod`
--

LOCK TABLES `sts-zubrod` WRITE;
/*!40000 ALTER TABLE `sts-zubrod` DISABLE KEYS */;
INSERT INTO `sts-zubrod` VALUES (0,'0  Asymptomatic'),(1,'1  Ambulatory but symptomatic'),(2,'2  <50% in bed during the day'),(3,'3  >50% in bed, but not bedbound'),(4,'4  Bedbound'),(5,'5  Dead');
/*!40000 ALTER TABLE `sts-zubrod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tmpbronchtable`
--

DROP TABLE IF EXISTS `tmpbronchtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tmpbronchtable` (
  `BiopsyNum` int(11) DEFAULT '0',
  `BronchAutoNum` int(11) NOT NULL AUTO_INCREMENT,
  `BronchType` int(11) DEFAULT NULL,
  `LocationCode` varchar(50) DEFAULT NULL,
  `BiopsyResult` varchar(50) DEFAULT NULL,
  `Diagnostic` int(11) DEFAULT '0',
  `Accuracy` int(11) DEFAULT '0',
  `Lymphocytes` tinyint(1) DEFAULT '0',
  `ROSE` tinyint(1) DEFAULT '0',
  `NumPasses` int(11) DEFAULT '0',
  `Culture` varchar(50) DEFAULT NULL,
  `Comment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BronchAutoNum`),
  KEY `LocationCode` (`LocationCode`),
  KEY `BiopsyNum` (`BiopsyNum`),
  KEY `BronchAutoNum` (`BronchAutoNum`)
) ENGINE=MyISAM AUTO_INCREMENT=557 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmpbronchtable`
--

LOCK TABLES `tmpbronchtable` WRITE;
/*!40000 ALTER TABLE `tmpbronchtable` DISABLE KEYS */;
/*!40000 ALTER TABLE `tmpbronchtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroles` (
  `RoleId` int(11) DEFAULT NULL,
  `RoleName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (1,'Administrator'),(2,'Webuser'),(3,'Readonly');
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `qrycancersperpatient`
--

/*!50001 DROP VIEW IF EXISTS `qrycancersperpatient`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `qrycancersperpatient` AS select `patient`.`MRN` AS `MRN`,count(`patient-cancer`.`ID`) AS `CountOfID` from (`patient` left join `patient-cancer` on((`patient`.`MRN` = `patient-cancer`.`PatientMRN`))) group by `patient`.`MRN` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `qryprocedureperpatient`
--

/*!50001 DROP VIEW IF EXISTS `qryprocedureperpatient`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `qryprocedureperpatient` AS select `patient`.`MRN` AS `MRN`,`patient`.`Name (Last,First)` AS `Name (Last,First)`,`patient`.`Date of Referral` AS `Date of Referral`,count(`patient-biopsy`.`ProcedureDate`) AS `CountOfProcedureDate`,`patient`.`Referring MD` AS `Referring MD`,`patient`.`Primary Care Physician` AS `Primary Care Physician` from (`patient` left join `patient-biopsy` on((`patient`.`MRN` = `patient-biopsy`.`MRN`))) group by `patient`.`MRN`,`patient`.`Name (Last,First)`,`patient`.`Date of Referral`,`patient`.`Referring MD`,`patient`.`Primary Care Physician` order by count(`patient-biopsy`.`ProcedureDate`) desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `qrysurgeryperpatient`
--

/*!50001 DROP VIEW IF EXISTS `qrysurgeryperpatient`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = cp850 */;
/*!50001 SET character_set_results     = cp850 */;
/*!50001 SET collation_connection      = cp850_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `qrysurgeryperpatient` AS select `patient`.`MRN` AS `MRN`,count(`patient-biopsy`.`ProcedureDate`) AS `CountOfProcedureDate` from (`patient` left join `patient-biopsy` on((`patient`.`MRN` = `patient-biopsy`.`MRN`))) where ((`patient-biopsy`.`ProcedureType` > 600) and (`patient-biopsy`.`ProcedureType` < 900)) group by `patient`.`MRN` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-19 17:45:25



