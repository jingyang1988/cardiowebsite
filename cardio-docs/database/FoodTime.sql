DROP TABLE IF EXISTS `list - foodtime`;

create table `list - foodtime` (
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`FoodTime` varchar(20) DEFAULT NULL,
	PRIMARY KEY (`ID`)
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
INSERT INTO `list - foodtime` (`ID`, `FoodTime`) VALUES ('1', 'more than 1/day');
INSERT INTO `list - foodtime` (`ID`, `FoodTime`) VALUES ('2', '1/day');
INSERT INTO `list - foodtime` (`ID`, `FoodTime`) VALUES ('3', '2-3/week');
INSERT INTO `list - foodtime` (`ID`, `FoodTime`) VALUES ('4', '1 week');
INSERT INTO `list - foodtime` (`ID`, `FoodTime`) VALUES ('5', '<1 week');
