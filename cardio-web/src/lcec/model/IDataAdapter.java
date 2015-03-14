package lcec.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public interface IDataAdapter extends AutoCloseable {

	// login bean
	String isValidUser(String username, String password);

	// user control bean
	ArrayList<String> getEmail(String username, String password);

	ArrayList<Users> getUsersData(String string);

	String getCurrentPassword(String id);

	public void savePassword(String userId, String password3);

	Users getCurUserData(String id);

	void saveEmail(String id, String pw);

	void adduser(String name, String id, String pw, String email, int role);

	void removeuser(String id);

	// main menu bean
	// PatientListModel searchPatient(String input, boolean isMRN);
	List<Patient> searchPatient(String input, boolean isMRN);

	void savePatient(Patient patient);

	// patient data bean
	PatientDataModel getPatientData(Patient patient);

	void savePatientData(PatientDataModel patientData);

	// Added by rjosan : createPatient
	void createPatient(PatientDataModel patientData);

	// Added by sun
	void deletePatient(Patient patient);
	
	// surgery biopsy data bean
	SurBiopsyDataModel getSurBiopsyData(Patient patient);

	void saveSurBiopsyData(SurBiopsyDataModel surBiopsyData);

	ArrayList<Biopsy> getBiopsyList(String mrn);

	void addSurBiopsy(String mrn, Biopsy biopsy);

	// visit data bean
	PatientVisitsModel getVisitData(Patient patient);

	void saveVisitData(PatientVisitsModel VisitData);

	ArrayList<Visit> getVisitList(String mrn);

	void addVisit(String mrn, Visit visit);

	// cancer info bean
	CancerInfoModel getCancerData(Patient patient);

	// modified by Sun
	void saveCancerData(CancerInfoModel cancerInfoData, boolean add, String mrn);
	
	// schedule data bean
	PatientTestingDataModel getTestData(Patient patient);

	ArrayList<SelectItem> getTestResultListByType(int resultType);

	void saveTestData(PatientTestingDataModel TestData);

	void addTest(String mrn, PatientTesting test);

	ArrayList<PatientTesting> getTestList(String mrn);

	// lesion data bean
	LesionModel getLesionData(Patient patient);

	public void addLesion(String mrn, Lesion lesion);

	public void saveLesionData(LesionModel lesionData);

	ArrayList<Lesion> getlesionList(String mrn);

	// history data bean
	historyDataModel getHistoryData(Patient patient);

	void saveHistoryData(historyDataModel historyData);

	// research data bean
	ResearchModel getResearchData(Patient patient);

	void addResearch(String mrn, Research research);

	ArrayList<Research> getResearchList(String mrn);



	// PatientMedication
	PatientMedicationModel getMedicationData(Patient patient);

	void saveMedicationData(PatientMedicationModel medicationData);

	ArrayList<PatientMedication> getPatientMedicationList(String mrn);

	void addMedication(String mrn, PatientMedication medication);

	void deleteMedicationData(PatientMedication medication);

	// utility methods
	ArrayList<SelectItem> getMDList();

	ArrayList<SelectItem> getInsuranceList();

	ArrayList<SelectItem> getGenderList();

	ArrayList<SelectItem> getWorkupList();

	ArrayList<SelectItem> getLCECStatusList();

	ArrayList<SelectItem> getLesionClassificaitonList();

	ArrayList<SelectItem> getBiopsyTypesList();

	ArrayList<SelectItem> getBiopsyAccuracyList();

	ArrayList<SelectItem> getResultDiagnosticList();

	ArrayList<SelectItem> getComplicationList();

	ArrayList<SelectItem> getLcecPhysiciansList();

	ArrayList<SelectItem> getLocationList();

	ArrayList<SelectItem> getVisittypeList();

	ArrayList<SelectItem> getSmokestatusList();

	ArrayList<SelectItem> getTestTypeList();

	ArrayList<SelectItem> getLesionCtCharacteristic();

	ArrayList<SelectItem> getResearchProjList();

	ArrayList<SelectItem> getLesionDignosisList();

	ArrayList<SelectItem> getRoleList();

	ArrayList<SelectItem> getCancerTypeList();

	ArrayList<SelectItem> getHistList();

	ArrayList<SelectItem> getStageTList();

	ArrayList<SelectItem> getStageNList();

	ArrayList<SelectItem> getStageTNMList();

	ArrayList<SelectItem> getStageMList();

	ArrayList<SelectItem> getCancerTxList();
	
	ArrayList<SelectItem> getRaceList();

	// for Medication
	ArrayList<SelectItem> getMedicineNameList();

	ArrayList<SelectItem> getStrengthUnitList();

	ArrayList<SelectItem> getDoseUnitList();

	ArrayList<SelectItem> getHowTakenList();

	ArrayList<SelectItem> getGivenTypeList();

	// for databaseQuery
	ArrayList<PatientDataModel> getPatiendQueryData();

	ArrayList<TestingReportEntry> getPatientTestingData();

	ArrayList<SurBiopsyReportEntry> getSurBiopsyReport();

	ArrayList<QueryVisits> getQueryVisitsList();

	ArrayList<CancerInfoModel> getCancerQueryData();

	ArrayList<QueryLesions> getQueryLesionsList();

	ArrayList<QueryPendingProcedures> getPendingProceduresList();

	// For Reports : Added by rjosan
	ArrayList<QuartReport> getQuartCancerDiag();

	ArrayList<QuartReport> getQuartNewRefs();

	ArrayList<ClinicScheduleReport> getClinicSchedule();

	ArrayList<VisitReport> getVisitReport();
	/*Added by Abhinav*/


	ArrayList<QuartReport> getQuartLungResec();

	ArrayList<Integer> getPatientAge();
	boolean getChartStatus();
	int autoMRN();
	boolean setState();
	void saveState();
	void saveState0();

	// For Reports : Added by srikanth
	ArrayList<QuartReport> getQuartPETScans();

	ArrayList<QuartReport> getQuartRFACryo();

	ArrayList<QuartReport> getYearlyRFACryo();

	ArrayList<QuartReport> getCasesPerTown();

	// for reports: added by sai
	ArrayList<QuartReport> getQuartNewConsults();

	ArrayList<YearlyConsultsModel> getYearlyNewConsults();

	ArrayList<QuartReport> getQuartProcedures();

	ArrayList<QuartReport> getYearlyProcedures();

	ArrayList<QuartReport> getYearlyPETScans();

	ArrayList<QuartReport> getYearlyNewRefs();

	ArrayList<rptPreOpsModel> getrptPreOps();

	ArrayList<rptVisitTestingModel> getrptVisitTesting();
	
	void addReferringMD(AddReferring doctor1);
	
	void addPrimaryMD(AddPrimary doctor1);
	
	boolean addLcecDoctor(String name);
	
	public ArrayList<AddReferring> getReferringMDList();
	
	public ArrayList<AddPrimary> getPrimaryMDList();

	// ADD by yongxin
	ArrayList<PrimaryMDReportModel> getQueryPrimaryMDReprotList();

	ArrayList<PatientListModel> searchPrimaryPatientList(
			String primaryCarePhysician);

	ArrayList<PrimaryMDReportModel> getQueryReferringMDReprotList();

	ArrayList<PatientListModel> searchReferringPatientList(
			String referringPhysician);

	ArrayList<SelectItem> getBronchTypeList();

	ArrayList<Bronch> getBronchList(int autoNum);


	void saveBronch(ArrayList<Bronch> b, int autoNum);

	void saveBiopsyData(Biopsy b, String mrn);

	void deleteBiopsyData(Biopsy b);

	void deleteBronchData(Bronch b, int bronchAutoNum);

	void addNewBronch(Bronch newBronch, int autoNum);

	RegistryInfo getRegistryInfo(Patient patient);

	ArrayList<SelectItem> getEducationList();

	ArrayList<SelectItem> getGroundZeroList();

	ArrayList<SelectItem> getDailySupplements();

	ArrayList<SelectItem> getFoodTime();

	ArrayList<SelectItem> getIntake();

	ArrayList<SelectItem> getScreening();

	void deleteTest(int i);
	
	void deleteLesion(int i);
	
	void deleteVisit(int i);
	
	// added by Sun
	String findCancerModelByMRN(String mrn);
	
	// added by Sun
	void deleteResearch(Research r, Patient p);

	void saveRegistryInfo(RegistryInfo registryInfo);

	void saveResearchData(ResearchModel researchData);

	ArrayList<ClinicScheduleReport> getClinicScheduleForToday();

	ArrayList<ClinicScheduleReport> getClinicScheduleForYesterday();

	ArrayList<ClinicScheduleReport> getclinicSchedRepForTomorrow();
	
	ArrayList<ClinicScheduleReport> getClinicSchedRepForLastMonth();
	
	ArrayList<ClinicScheduleReport> getClinicSchedRepForThisMonth();
	
	ArrayList<ClinicScheduleReport> getClinicSchedRepForNextMonth();
	
	ArrayList<ClinicScheduleReport> getClinicSchedRepForLastWeek();
 	
	ArrayList<ClinicScheduleReport> getClinicSchedRepForThisWeek();
	
	ArrayList<ClinicScheduleReport> getClinicSchedRepForNextWeek();

	void savePatientDataNewMrn(PatientDataModel patientData);

	ArrayList<String> getMrnList();

	ArrayList<String> getRefMdListByName(String name);

	ArrayList<SelectItem> getMdListByName(String name);

	ArrayList<InsuranceDataModel> getInsuranceQueryData();

	void addInsurance(InsuranceDataModel insurance);

	boolean addTestType(String name);

	

	



}

