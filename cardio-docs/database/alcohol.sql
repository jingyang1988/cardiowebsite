DROP TABLE IF EXISTS `list - alcohol`;

create table `list - alcohol` (
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`Alcohol` varchar(20) DEFAULT NULL,
	PRIMARY KEY (`ID`)
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
INSERT INTO `list - alcohol` (`ID`, `Alcohol`) VALUES ('1', 'Never');
INSERT INTO `list - alcohol` (`ID`, `Alcohol`) VALUES ('2', '<1 week');
INSERT INTO `list - alcohol` (`ID`, `Alcohol`) VALUES ('3', 'weekly');
INSERT INTO `list - alcohol` (`ID`, `Alcohol`) VALUES ('4', 'daily');

