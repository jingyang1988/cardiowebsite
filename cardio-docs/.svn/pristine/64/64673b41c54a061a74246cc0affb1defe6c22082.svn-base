create view qryCancersperPatient as
SELECT Patient.MRN, Count(`Patient-Cancer`.ID) AS CountOfID
FROM Patient LEFT JOIN `Patient-Cancer` ON Patient.MRN = `Patient-Cancer`.PatientMRN
GROUP BY Patient.MRN;

create view qryProcedurePerPatient as
SELECT Patient.MRN, Patient.`Name (Last,First)`, Patient.`Date of Referral`, Count(`Patient-Biopsy`.ProcedureDate) AS CountOfProcedureDate, Patient.`Referring MD`, Patient.`Primary Care Physician`
FROM Patient LEFT JOIN `Patient-Biopsy` ON Patient.MRN = `Patient-Biopsy`.MRN
GROUP BY Patient.MRN, Patient.`Name (Last,First)`, Patient.`Date of Referral`, Patient.`Referring MD`, Patient.`Primary Care Physician`
ORDER BY Count(`Patient-Biopsy`.ProcedureDate) DESC;

create view qrySurgeryPerPatient as
SELECT Patient.MRN, Count(`Patient-Biopsy`.ProcedureDate) AS CountOfProcedureDate
FROM Patient LEFT JOIN `Patient-Biopsy` ON Patient.MRN = `Patient-Biopsy`.MRN
WHERE (((`Patient-Biopsy`.ProcedureType)>600 And (`Patient-Biopsy`.ProcedureType)<900))
GROUP BY Patient.MRN;
