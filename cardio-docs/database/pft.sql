alter table `patient-testing` add column FEV1 float(8, 2) default 0, add column FVC float(8, 2) default 0,
add column DLCO float(8, 2) default 0, add column FEVP float(8, 2) default 0, add column FVCP float(8, 2) default 0,
add column DLCOP float(8, 2) default 0, add column FEV1FVC float(8, 2) default 0, add column Interpretation varchar(20);