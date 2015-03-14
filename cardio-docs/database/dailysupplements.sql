DROP TABLE IF EXISTS `list - dailysupplements`;

create table `list - dailysupplements` (
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`Supplements` varchar(20) DEFAULT NULL,
	PRIMARY KEY (`ID`)
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
INSERT INTO `list - dailysupplements` (`ID`, `Supplements`) VALUES ('1', 'None');
INSERT INTO `list - dailysupplements` (`ID`, `Supplements`) VALUES ('2', '1-2 daily');
INSERT INTO `list - dailysupplements` (`ID`, `Supplements`) VALUES ('3', 'Multiple');

