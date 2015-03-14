package lcec.controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.PatientListModel;
import lcec.model.PrimaryMDReportModel;

@ManagedBean(name = "queryMDReportBean")
@SessionScoped
public class QueryMDReportBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(QueryMDReportBean.class
		.getName());
	public QueryMDReportBean() {
		// TODO Auto-generated constructor stub
	}
	
	//add by yongxin query primary care physician
	private ArrayList<PrimaryMDReportModel> queryReferringMDReportList;
	private ArrayList<PrimaryMDReportModel> filteredQueryReferringMDReportList;
	
	public ArrayList<PrimaryMDReportModel>	getFilteredQueryReferringMDReportList(){
		return filteredQueryReferringMDReportList;
	}
	
	public void setFilteredQueryReferringMDReportList(
			ArrayList<PrimaryMDReportModel>	filteredQueryReferringMDReportList){
		this.filteredQueryReferringMDReportList = filteredQueryReferringMDReportList;
	}

	public ArrayList<PrimaryMDReportModel> getQueryReferringMDReportList() {
		if (queryReferringMDReportList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQueryReferringMDReportList");
				this.queryReferringMDReportList = adapter.getQueryReferringMDReprotList();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error (e, e);
			}
		}
		return queryReferringMDReportList;
	}
	
	//add by yongxin query primary care physician
	private ArrayList<PrimaryMDReportModel> queryPrimaryMDReportList;
	private ArrayList<PrimaryMDReportModel> filteredQueryPrimaryMDReportList;
	
	public ArrayList<PrimaryMDReportModel>	getFilteredQueryPrimaryMDReportList(){
		return filteredQueryPrimaryMDReportList;
	}
	
	public void setFilteredQueryPrimaryMDReportList(
			ArrayList<PrimaryMDReportModel>	filteredQueryPrimaryMDReportList){
		this.filteredQueryPrimaryMDReportList = filteredQueryPrimaryMDReportList;
	}

	public ArrayList<PrimaryMDReportModel> getQueryPrimaryMDReportList() {
		if (queryPrimaryMDReportList == null) {
			try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				logger.debug ("getQueryPrimaryMDReportList");
				this.queryPrimaryMDReportList = adapter.getQueryPrimaryMDReprotList();
			} catch (Exception ex) {
				logger.error (ex, ex);
			}
		}

		return queryPrimaryMDReportList;
	}
	
	//show the patient list
	private ArrayList<PatientListModel> patientList;
	private ArrayList<PatientListModel> filteredPatientList;

	public String setPrimaryPatientList(String primaryCarePhysician){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("setPrimaryPatientList: "+primaryCarePhysician);
			patientList = adapter.searchPrimaryPatientList(primaryCarePhysician);
			if(patientList == null){
				//System.out.println("patientList is null");
				return "PrimaryMDReport.xhtml";
			}
			return "PatientList.xhtml";
		}catch(Exception e){
			e.printStackTrace();
			logger.error (e, e);
		}
		return null;
	}

	//Referring MD Report patient list
	public String setReferringPatientList(String referringPhysician){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("setReferringPatientList: "+referringPhysician);
			patientList = adapter.searchReferringPatientList(referringPhysician);
			if(patientList == null){
				//System.out.println("patientList is null");
				return "ReferringMDReport.xhtml";
			}
			return "PatientList.xhtml";
		}catch(Exception e){
			e.printStackTrace();
			logger.error (e, e);
		}
		return null;
	}
	
	public ArrayList<PatientListModel> getPatientList(){
		return this.patientList;
	}
	
	public ArrayList<PatientListModel>	getFilteredPatientList(){
		return filteredPatientList;
	}
	
	public void setFilteredPatientList(
			ArrayList<PatientListModel>	filteredPatientList){
		this.filteredPatientList = filteredPatientList;
	}
	
		
}
