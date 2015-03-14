alter table `patient-bronch` add `EBUS` tinyint(1);
alter table `patient-bronch` add `EMN` tinyint(1);
update `patient-bronch` set `EBUS` = 1 where `patient-bronch`.`BronchType` = 3100;
update `patient-bronch` set `EMN` = 1 where `patient-bronch`.`BronchType` = 3200;
DELETE FROM `list - bronch types` WHERE `BronchNumber`='3100';
DELETE FROM `list - bronch types` WHERE `BronchNumber`='3200';
