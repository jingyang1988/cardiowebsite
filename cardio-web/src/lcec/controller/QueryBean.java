package lcec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.primefaces.json.JSONArray;

import lcec.model.AddPrimary;
import lcec.model.AddReferring;
import lcec.model.CancerInfoModel;
import lcec.model.ClinicScheduleReport;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.InsuranceDataModel;
import lcec.model.PatientDataModel;
import lcec.model.QuartReport;
import lcec.model.QueryLesions;
import lcec.model.QueryPendingProcedures;
import lcec.model.QuartReport;
import lcec.model.QueryLesions;
import lcec.model.QueryPendingProcedures;
//import lcec.model.PatientVisitsModel;
import lcec.model.VisitReport;
import lcec.model.QueryVisits;
import lcec.model.SurBiopsyReportEntry;
import lcec.model.TestingReportEntry;
import lcec.model.YearlyConsultsModel;
import lcec.model.rptPreOpsModel;
import lcec.model.rptVisitTestingModel;

@ManagedBean(name = "queryBean")
@ViewScoped
public class QueryBean implements java.io.Serializable{
	private static Logger logger = LogManager.getLogger(QueryBean.class
		.getName());
	private static final long serialVersionUID = 1L;
	
	// PatientModel List
	private ArrayList<PatientDataModel> patientDataModelList;
	private ArrayList<InsuranceDataModel> insuranceDataModelList;
	private ArrayList<PatientDataModel> filteredPatientDataReport;
	private ArrayList<SurBiopsyReportEntry> surBiopsyReport;
	private ArrayList<SurBiopsyReportEntry> filteredSurBiopsyReport;
	// Added by rjosan
	private ArrayList<QueryVisits> queryVisitsList;
	private ArrayList<QueryVisits> filteredQueryVisitsList;
	// End of add

	
	
	/*Additions for Reports by rjosan*/
	private ArrayList<QuartReport> quartCancerDiag;
	private ArrayList<QuartReport> quartNewRefs;
	private ArrayList<ClinicScheduleReport> clinicSchedRep;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForToday;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForYesterday;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForTomorrow;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForLastMonth;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForThisMonth;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForNextMonth;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForLastWeek;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForThisWeek;
	private ArrayList<ClinicScheduleReport> clinicSchedRepForNextWeek;
	
/*Additions for reports by Abhinav*/
	
	private ArrayList<QuartReport> quartLungResec;
	private ArrayList<Integer> patientage;
	private boolean chartstatus;
	private boolean setState;
	
	
	/*Additions for Reports by srikanth*/
	private ArrayList<QuartReport> quartPETScans;
	private ArrayList<QuartReport> quartRFACryo;
	private ArrayList<QuartReport> yearlyRFACryo;
	private ArrayList<QuartReport> casesPerTown;
	private JSONArray townsJSON;
	/*Additions for Reports by sai*/
	private ArrayList<QuartReport> quartNewConsults;
	private ArrayList<YearlyConsultsModel> yearlyNewConsults;
	private ArrayList<QuartReport> quartProcedures;
	private ArrayList<QuartReport> yearlyProcedures;
	private ArrayList<QuartReport> yearlyPETScans;
	private ArrayList<QuartReport> yearlyNewRefs;
	private ArrayList<rptPreOpsModel> rptPreOps ;
	private ArrayList<rptVisitTestingModel> rptVisitTesting ;
	private ArrayList<AddReferring> referringMDList;
	private ArrayList<AddPrimary> primaryMDList;
	
	ArrayList<QueryLesions> queryLesionsList;
	ArrayList<QueryLesions> filteredQueryLesionsList;
	
	private ArrayList<QueryPendingProcedures> queryPendingProceduresList;
	private ArrayList<QueryPendingProcedures> filteredQueryPendingProceduresList;

	public ArrayList<PatientDataModel> getFilteredPatientDataReport() {
		return filteredPatientDataReport;
	}

	public void setFilteredPatientDataReport(
			ArrayList<PatientDataModel> filteredPatientDataReport) {
		this.filteredPatientDataReport = filteredPatientDataReport;
	}

	public ArrayList<PatientDataModel> getPatientDataModelList() {
		if (patientDataModelList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.patientDataModelList = adapter.getPatiendQueryData();
			} catch (Exception ex) {

			}
		}

		return patientDataModelList;
	}
	public ArrayList<InsuranceDataModel> getInsuranceDataModelList() {
		if (insuranceDataModelList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.insuranceDataModelList = adapter.getInsuranceQueryData();
			} catch (Exception ex) {

			}
		}

		return insuranceDataModelList;
	}

	public void setPatientDataModelList(
			ArrayList<PatientDataModel> patientDataModelList) {
		this.patientDataModelList = patientDataModelList;
	}

	private ArrayList<TestingReportEntry> patientTestingReport;
	private ArrayList<TestingReportEntry> filteredpatientTestingReport;

	public ArrayList<TestingReportEntry> getPatientTestingReport() {
		if (patientTestingReport == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.patientTestingReport = adapter.getPatientTestingData();
				logger.debug ("getPatientTestingReport");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		return patientTestingReport;
	}

	public void setPatientTestingReport(
			ArrayList<TestingReportEntry> patientTestingReport) {
		this.patientTestingReport = patientTestingReport;
		logger.debug ("setPatientTestingReport");
	}

	public ArrayList<TestingReportEntry> getFilteredpatientTestingReport() {
		logger.debug ("getFilteredpatientTestingReport");
		return filteredpatientTestingReport;
	}

	public void setFilteredpatientTestingReport(
			ArrayList<TestingReportEntry> filteredpatientTestingReport) {
		this.filteredpatientTestingReport = filteredpatientTestingReport;
		logger.debug ("setFilteredpatientTestingReport");
	}

	public ArrayList<SurBiopsyReportEntry> getSurBiopsyModelList() {
		if (surBiopsyReport == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.surBiopsyReport = adapter.getSurBiopsyReport();
				logger.debug ("getSurBiopsyModelList");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return surBiopsyReport;
	}

	public ArrayList<SurBiopsyReportEntry> getFilteredSurBiopsyReport() {
		logger.debug ("getFilteredSurBiopsyReport");
		return filteredSurBiopsyReport;
	}

	public void setFilteredSurBiopsyReport(
			ArrayList<SurBiopsyReportEntry> filteredSurBiopsyReport) {
		this.filteredSurBiopsyReport = filteredSurBiopsyReport;
		logger.debug ("setFilteredSurBiopsyReport");
	}

	// Added By rjosan

	public ArrayList<QueryVisits> getQueryVisitsList() {
		if (queryVisitsList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.queryVisitsList = adapter.getQueryVisitsList();
				logger.debug ("getQueryVisitsList");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return queryVisitsList;
	}
	private ArrayList<VisitReport> visitReport;


	public ArrayList<VisitReport> getVisitReport() {
		if (visitReport == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.visitReport = adapter.getVisitReport();
				logger.debug ("getVisitReport");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return visitReport;
	}

	public ArrayList<QueryVisits> getFilteredQueryVisitsList() {
		logger.debug ("getFilteredQueryVisitsList");
		return filteredQueryVisitsList;
		
	}

	public void setFilteredQueryVisitsList(
			ArrayList<QueryVisits> filteredQueryVisitsList) {
		this.filteredQueryVisitsList = filteredQueryVisitsList;
		logger.debug ("setFilteredQueryVisitsList");
	}
	
	
	// Additions for reports
	
	public ArrayList<QuartReport> getQuartCancerDiag() {
		if (quartCancerDiag == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQuartCancerDiag");
				this.quartCancerDiag = adapter.getQuartCancerDiag();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return quartCancerDiag;
	}
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRep() {
		if (clinicSchedRep == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.clinicSchedRep = adapter.getClinicSchedule();
				logger.debug ("getClinicSchedRep");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return clinicSchedRep;
	}
	
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForToday() {
		if (clinicSchedRepForToday == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.clinicSchedRepForToday = adapter.getClinicScheduleForToday();
				logger.debug ("getClinicSchedRepForToday");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return clinicSchedRepForToday;
	}
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForYesterday() {
		if (clinicSchedRepForYesterday == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.clinicSchedRepForYesterday = adapter.getClinicScheduleForYesterday();
				logger.debug ("getClinicSchedRepForYesterday");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return clinicSchedRepForYesterday;
	}
	
	
	
	public ArrayList<ClinicScheduleReport> getclinicSchedRepForTomorrow() {
		if (clinicSchedRepForYesterday == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				this.clinicSchedRepForTomorrow = adapter.getclinicSchedRepForTomorrow();
				logger.debug ("getclinicSchedRepForTomorrow");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return clinicSchedRepForTomorrow;
	}
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForLastMonth(){
		if(clinicSchedRepForLastMonth == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				logger.debug ("getClinicSchedRepForLastMonth");
				this.clinicSchedRepForLastMonth = adapter.getClinicSchedRepForLastMonth();
			}catch(Exception ex){
				logger.error (ex, ex);
			}
		}
		return clinicSchedRepForLastMonth;
	}
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForThisMonth(){
		if(clinicSchedRepForThisMonth == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				logger.debug ("getClinicSchedRepForThisMonth");
				this.clinicSchedRepForThisMonth = adapter.getClinicSchedRepForThisMonth();
			}catch(Exception ex){
				logger.error (ex, ex);
			}
		}
		return clinicSchedRepForThisMonth;
	}
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForNextMonth(){
		if(clinicSchedRepForNextMonth == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				logger.debug ("getClinicSchedRepForNextMonth");
				this.clinicSchedRepForNextMonth = adapter.getClinicSchedRepForNextMonth();
			}catch(Exception ex){
				logger.error (ex, ex);
			}
		}
		return clinicSchedRepForNextMonth;
	}

	
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForLastWeek(){
		if(clinicSchedRepForLastWeek == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				logger.debug ("getClinicSchedRepForLastWeek");
				this.clinicSchedRepForLastWeek = adapter.getClinicSchedRepForLastWeek();
			}catch(Exception ex){
				logger.error (ex, ex);
			}
		}
		return clinicSchedRepForLastWeek;
	}
	
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForThisWeek(){
		if(clinicSchedRepForThisWeek == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				logger.debug ("getClinicSchedRepForThisWeek");
				this.clinicSchedRepForThisWeek = adapter.getClinicSchedRepForThisWeek();
			}catch(Exception ex){
				logger.error (ex, ex);
			}
		}
		return clinicSchedRepForThisWeek;
	}
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForNextWeek(){
		if(clinicSchedRepForNextWeek == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				logger.debug ("getClinicSchedRepForNextWeek");
				this.clinicSchedRepForNextWeek = adapter.getClinicSchedRepForNextWeek();
			}catch(Exception ex){
				logger.error (ex, ex);
			}
		}
		return clinicSchedRepForNextWeek;
	}
	
	
	
	public ArrayList<QuartReport> getQuartNewRefs() {
		if (quartNewRefs == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQuartNewRefs");
				this.quartNewRefs = adapter.getQuartNewRefs();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return quartNewRefs;
	}
	
	
	// End of Addition by rjosan
	
	
/*Addition of reports by Abhinav*/
	
	public ArrayList<QuartReport> getQuartLungResec() {
		
		if (quartLungResec == null) {
			//System.out.println("before getting data");
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQuartLungResec");
				this.quartLungResec = adapter.getQuartLungResec();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return quartLungResec;
	}
	

public boolean setState() {
	
	try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
		logger.debug ("set checkbox state");
		System.out.println("Returned state from DataAdapter"+adapter.setState());
		this.setState = adapter.setState();
	} catch (Exception ex) {
		logger.error (ex, ex);
	}
	return setState;
}

public void saveState() {
	
	try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
		logger.debug ("set checkbox state to 1");
		System.out.println("Calling Data adapter to save state to 1");
		adapter.saveState();
	} catch (Exception ex) {
		logger.error (ex, ex);
	}
	//return setState;
}

public void saveState0() {
	
	try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
		logger.debug ("set checkbox state to 0");
		System.out.println("Calling Data adapter to save state to 0");
		adapter.saveState0();
	} catch (Exception ex) {
		logger.error (ex, ex);
	}
	//return setState;
}	
public ArrayList<Integer> getPatientAge() {
		
		if (patientage == null) {
			//System.out.println("before getting data");
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getPatientAge");
				this.patientage = adapter.getPatientAge();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return patientage;
	}

public boolean getChartStatus() {
	
	try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
		logger.debug ("getChartStatus");
		this.chartstatus = adapter.getChartStatus();
	} catch (Exception ex) {
		logger.error (ex, ex);
	}
	return chartstatus;
}
	/*End of changes by Abhinav*/
	
	
	
	//beginning of reports added by sai
	public ArrayList<QuartReport> getYearlyNewRefs() {
		if (quartNewRefs == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getYearlyNewRefs");
				this.yearlyNewRefs = adapter.getYearlyNewRefs();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return yearlyNewRefs;
	}
	public ArrayList<rptPreOpsModel> getrptPreOps() {
		if (rptPreOps == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getrptPreOps");
				this.rptPreOps = adapter.getrptPreOps();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return rptPreOps;
	}
	public ArrayList<rptVisitTestingModel> getrptVisitTesting() {
		if (rptVisitTesting == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getrptVisitTesting");
				this.rptVisitTesting = adapter.getrptVisitTesting();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return rptVisitTesting;
	}
	public ArrayList<QuartReport> getQuartNewConsults() {
		if (quartNewConsults == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQuartNewConsults");
				this.quartNewConsults = adapter.getQuartNewConsults();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return quartNewConsults;
	}

	public ArrayList<YearlyConsultsModel> getyearlyNewConsults() {
		if (yearlyNewConsults == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getyearlyNewConsults");
				this.yearlyNewConsults = adapter.getYearlyNewConsults();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return yearlyNewConsults;
	}
	public ArrayList<QuartReport> getQuartProcedures() {
		if (quartProcedures == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQuartProcedures");
				this.quartProcedures = adapter.getQuartProcedures();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return quartProcedures;
	}
	
	public ArrayList<QuartReport> getyearlyProcedures() {
		if (yearlyProcedures == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getyearlyProcedures");
				this.yearlyProcedures = adapter.getYearlyProcedures();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return yearlyProcedures;
	}
	
	public ArrayList<QuartReport> getYearlyPETScans() {
		if (yearlyPETScans == null) {
			
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getYearlyPETScans");
				this.yearlyPETScans = adapter.getYearlyPETScans();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		
		return yearlyPETScans;
	}
	
	public ArrayList<AddReferring> getReferringMDList() {
		if (referringMDList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				
				this.referringMDList = adapter.getReferringMDList();
				logger.debug ("getReferringMDList");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return referringMDList;
	}
	
	public ArrayList<AddPrimary> getPrimaryMDList() {
		if (primaryMDList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				
				this.primaryMDList = adapter.getPrimaryMDList();
				logger.debug ("getPrimaryMDList");
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return primaryMDList;
	}
	
	//end of reports added by sai
	
	//Added by Srikanth
	
		public ArrayList<QuartReport> getQuartPETScans() {
			if (quartPETScans == null) {
				//System.out.println("Inside Bean");
				try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
					logger.debug ("getQuartPETScans");
					this.quartPETScans = adapter.getQuartPETScans();
				} catch (Exception ex) {
					logger.error (ex, ex);
				}
			}
			
			return quartPETScans;
		}
		
		public ArrayList<QuartReport> getQuartRFACryo() {
			if (quartRFACryo == null) {
				//System.out.println("Inside Bean");
				try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
					logger.debug ("getQuartRFACryo");
					this.quartPETScans = adapter.getQuartPETScans();
				} catch (Exception ex) {
					logger.error (ex, ex);
				}
			}
			
			return quartPETScans;
		}
		
		public ArrayList<QuartReport> getYearlyRFACryo() {
			if (yearlyRFACryo == null) {
				//System.out.println("Inside Bean");
				try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
					logger.debug ("getYearlyRFACryo");
					this.yearlyRFACryo = adapter.getYearlyRFACryo();
				} catch (Exception ex) {
					logger.error (ex, ex);
				}
			}
			
			return yearlyRFACryo;
		}
		
		public ArrayList<QuartReport> getCasesPerTown() {
			if (casesPerTown == null) {
				//System.out.println("Inside Bean");
				try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
					logger.debug ("getCasesPerTown");
					this.casesPerTown = adapter.getCasesPerTown();
				} catch (Exception ex) {
					logger.error (ex, ex);
				}
			}
			
			return casesPerTown;
		}
		
		public JSONArray getTownsJSON() {
			ArrayList<QuartReport> sample = getCasesPerTown();
			List<String> sample1 = new ArrayList<String>();
			
			for(int i =0;i<11;i++){
				sample1.add(sample.get(i).getCity() +"|"+ sample.get(i).getName());				
			}
			
			townsJSON = new JSONArray(sample1);
			logger.debug ("getTownsJSON");
			return townsJSON;
		}

		
		//End of addition by srikanth

	private ArrayList<CancerInfoModel> cancerInfoModelList;
	private ArrayList<CancerInfoModel> filteredCancerInfoReport;

	public ArrayList<CancerInfoModel> getCancerInfoModelList() {
		if (cancerInfoModelList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getCancerInfoModelList");
				this.cancerInfoModelList = adapter.getCancerQueryData();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}
		return cancerInfoModelList;
	}

	public void setCancerInfoModelList(
			ArrayList<CancerInfoModel> cancerInfoModelList) {
		this.cancerInfoModelList = cancerInfoModelList;
		logger.debug ("setCancerInfoModelList");
	}

	public ArrayList<CancerInfoModel> getFilteredCancerInfoReport() {
		logger.debug ("getFilteredCancerInfoReport");
		return filteredCancerInfoReport;
	}

	public void setFilteredCancerInfoReport(
			ArrayList<CancerInfoModel> filteredCancerInfoReport) {
		this.filteredCancerInfoReport = filteredCancerInfoReport;
		logger.debug ("setFilteredCancerInfoReport");
	}

	public ArrayList<QueryLesions> getQueryLesionsList() {
		if (queryLesionsList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQueryLesionsList");
				this.queryLesionsList = adapter.getQueryLesionsList();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return queryLesionsList;
	}

	/*
	 * public void setQueryLesionsList( ArrayList<QueryLesions>
	 * queryLesionsList){ this.queryLesionsList = queryLesionsList; }
	 */

	public ArrayList<QueryLesions> getFilteredQueryLesionsList() {
		logger.debug ("getFilteredQueryLesionsList");
		return filteredQueryLesionsList;
	}

	public void setFilteredQueryLesionsList(
			ArrayList<QueryLesions> filteredQueryLesionsList) {
		this.filteredQueryLesionsList = filteredQueryLesionsList;
	}
	
	/*QueryProcedure*/
	public ArrayList<QueryPendingProcedures> getQueryPendingProceduresList() {
		if (queryPendingProceduresList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQueryPendingProceduresList");
				this.queryPendingProceduresList = adapter.getPendingProceduresList();
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.error (ex, ex);
			}
		}

		return queryPendingProceduresList;
	}
	
	public void setQueryPendingProceduresList(ArrayList<QueryPendingProcedures> queryPendingProceduresList) {
		this.queryPendingProceduresList = queryPendingProceduresList;
	}
	
	public ArrayList<QueryPendingProcedures> getFilteredQueryPendingProceduresList() {
		return this.filteredQueryPendingProceduresList;
	}
	public void setFilteredQueryPendingProceduresList(ArrayList<QueryPendingProcedures> filteredQueryPendingProceduresList) {
		
		this.filteredQueryPendingProceduresList = filteredQueryPendingProceduresList;
	}
	
	
}
