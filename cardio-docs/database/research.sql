INSERT INTO `list - testtypes`(Autonumber, TestingType)
VALUES ('120', 'CT chest 10W dose');

INSERT INTO `list - testtypes`(Autonumber, TestingType)
VALUES ('130', 'CT chest super');

DELETE FROM `list - researchproject` WHERE `ResearchProjNum` = 1;

DELETE FROM `list - researchproject` WHERE `ResearchProjNum` = 2;

ALTER TABLE `patient-registry` 
CHANGE COLUMN `RegistryNum` `RegistryNum` INT(11) NOT NULL AUTO_INCREMENT ;

alter table `patient-registry` modify column RegistryNum int auto_increment;
