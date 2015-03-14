DROP TABLE IF EXISTS `list - medicationDoseUnit`;

CREATE TABLE `list - medicationDoseUnit` (
  `DoseUnitID` int(11) NOT NULL DEFAULT '0',
  `Dose Unit` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`DoseUnitID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `list - medicationHowTaken`;

CREATE TABLE `list - medicationHowTaken` (
  `HowTakenID` int(11) NOT NULL DEFAULT '0',
  `How Taken` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`HowTakenID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `list - medicationStrengthUnit`;

CREATE TABLE `list - medicationStrengthUnit` (
  `StrengthUnitID` int(11) NOT NULL DEFAULT '0',
  `Strength Unit` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`StrengthUnitID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `list - medicineGivenType`;

CREATE TABLE `list - medicineGivenType` (
  `GivenTypeID` int(11) NOT NULL AUTO_INCREMENT,
  `Given Type` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`GivenTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `patient-medication`;

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
  `Allergies` VARCHAR(500) NULL DEFAULT NULL,
  NKA INTEGER,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

ALTER TABLE `patient` 
ADD COLUMN `AsbestosExposure` TINYINT(1) NULL DEFAULT '0' AFTER `DetailComment`;

ALTER TABLE `patient` 
ADD COLUMN `SilicaExposure` TINYINT(1) NULL DEFAULT '0' AFTER `AsbestosExposure`;

ALTER TABLE `patient` 
ADD COLUMN `WTC` TINYINT(1) NULL DEFAULT '0' AFTER `SilicaExposure`;
