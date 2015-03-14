1. Use Bull Access 2 Mysql dump
save DB into all.sql
 
2. mysql -uroot -ppass4root 
drop database movedb

3. mysql -uroot -ppass4root movedb < all.sql

4. Updates:
mysql -uroot -ppass4root movedb < FoodTime.sql
mysql -uroot -ppass4root movedb < alcohol.sql
mysql -uroot -ppass4root movedb < bronch_update.sql
mysql -uroot -ppass4root movedb < chart.sql
mysql -uroot -ppass4root movedb < dailysupplements.sql
mysql -uroot -ppass4root movedb < dummymrn.sql
mysql -uroot -ppass4root movedb < fields.sql
mysql -uroot -ppass4root movedb < groundzero.sql
mysql -uroot -ppass4root movedb < lesion-changes.sql
mysql -uroot -ppass4root movedb < list-education.sql
mysql -uroot -ppass4root movedb < medications.sql
mysql -uroot -ppass4root movedb < pft.sql
mysql -uroot -ppass4root movedb < race.sql
mysql -uroot -ppass4root movedb < research.sql
mysql -uroot -ppass4root movedb < screening.sql
mysql -uroot -ppass4root movedb < viewsForReports.sql
mysql -uroot -ppass4root movedb < databaseuser.sql
mysql -uroot -ppass4root movedb < MedicationDoseUnitList.sql
mysql -uroot -ppass4root movedb < MedicationGivenTypeList.sql
mysql -uroot -ppass4root movedb < MedicationHowTakenList.sql
mysql -uroot -ppass4root movedb < MedicationStrengthUnitList.sql

6. Save DB:
mysqldump -uroot -ppass4root movedb > _dump.sql

-----
On the server:
1. save the user in a file:
mysqldump -uroot -ppass4root movedb databaseuser > databaseuser.sql

2. Drop the movedb:
mysql -uroot -ppass4root 
drop database movedb

3. upload and insert the dump
mysql -uroot -ppass4root movedb < _dump.sql

4. drop the databaseuser table
mysql -uroot -ppass4root movedb
drop table databaseuser;

5. update the users:
mysql -uroot -ppass4root movedb < databaseuser.sql
