
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.Serializable;

import lcec.controller.LoginBean;
import lcec.model.Patient;

@ManagedBean
@ViewScoped
public class CancerInfo implements Serializable{
	
	private Logger logger;

	public CancerInfo() {
		super();
		logger = LogManager.getLogger(CancerInfo.class
				.getName());
	}

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	public Patient selectedMRN;	
	
	public Patient getSelectedMRN() {
		return selectedMRN;
	}

	public void setSelectedMRN(Patient selectedMRN) {
		this.selectedMRN = selectedMRN;
	}

	// variables
	public String WorkupStatus;
	public String LCECStatus;
	public Date InactiveDate;
	public boolean LCECChart;

	public Date DiagnosisDate;
	public Date StagingDate;
	public Date TumorDate;
	public String CancerType;
	public String Histology;
	public String Comment;
	
	public String Clinical_T;
	public String Pathological_T;
	public String PostNeo_T;
	public String Clinical_N;
	public String Pathological_N;
	public String PostNeo_N;
	public String Clinical_M;
	public String Pathological_M;
	public String PostNeo_M;
	public String Clinical_TNM;
	public String Pathological_TNM;
	public String PostNeo_TNM;
	
	public String Status_1year;
	public String Status_2year;
	public String Status_3year;
	public String Status_4year;
	public String Status_5year;
	
	public String Comment1;
	public Date RelapseDate;
	
	public String NAChemoStatus;
	public String NARTStatus;
	public String SBRTStatus;
	public String ChemotherapyStatus;
	public String RadtherapyStatus;
	public String NAChemoMD;
	public String NARTMD;
	public String SBRTMD;
	public String ChemotherapyMD;
	public String RadtherapyMD;
	public Date NAChemoDate;
	public Date NARTDate;
	public Date SBRTDate;
	public Date ChemotherapyDate;
	public Date RadtherapyDate;

	// Array Lists
	public ArrayList<SelectItem> CancerTypeList = null;
	public ArrayList<SelectItem> HistList = null;
	public ArrayList<SelectItem> StageTList = null;
	public ArrayList<SelectItem> StageNList = null;
	public ArrayList<SelectItem> StageMList = null;
	public ArrayList<SelectItem> StageTNMList = null;
	public ArrayList<SelectItem> CancerTxList = null;
	public ArrayList<SelectItem> MDList = null;
	
	@PostConstruct
	public void loadData() {
		try{
			this.cancer(selectedMRN.getMrn());
		}catch(SQLException ex){	
		}		
	}
	
	// Getter-Setter Methods

	public String getWorkupStatus() {
		return WorkupStatus;
	}
	public void setWorkupStatus(String workupStatus) {
		WorkupStatus = workupStatus;
	}
	public String getLCECStatus() {
		return LCECStatus;
	}
	public void setLCECStatus(String lCECStatus) {
		LCECStatus = lCECStatus;
	}
	public Date getInactiveDate() {
		return InactiveDate;
	}
	public void setInactiveDate(Date inactiveDate) {
		InactiveDate = inactiveDate;
	}
	public boolean isLCECChart() {
		return LCECChart;
	}
	public void setLCECChart(boolean lCECChart) {
		LCECChart = lCECChart;
	}
	public String getClinical_T() {
		return Clinical_T;
	}
	public void setClinical_T(String Clinical_T) {
		this.Clinical_T = Clinical_T;
	}
	public String getPathological_T() {
		return Pathological_T;
	}
	public void setPathological_T(String Pathological_T) {
		this.Pathological_T = Pathological_T;
	}
	public String getPostNeo_T() {
		return PostNeo_T;
	}
	public void setPostNeo_T(String PostNeo_T) {
		this.PostNeo_T = PostNeo_T;
	}
	public String getClinical_N() {
		return Clinical_N;
	}
	public void setClinical_N(String Clinical_N) {
		this.Clinical_N = Clinical_N;
	}
	public String getPathological_N() {
		return Pathological_N;
	}
	public void setPathological_N(String Pathological_N) {
		this.Pathological_N = Pathological_N;
	}
	public String getPostNeo_N() {
		return PostNeo_N;
	}
	public void setPostNeo_N(String PostNeo_N) {
		this.PostNeo_N = PostNeo_N;
	}
	public String getClinical_M() {
		return Clinical_M;
	}
	public void setClinical_M(String Clinical_M) {
		this.Clinical_M = Clinical_M;
	}
	public String getPathological_M() {
		return Pathological_M;
	}
	public void setPathological_M(String Pathological_M) {
		this.Pathological_M = Pathological_M;
	}
	public String getPostNeo_M() {
		return PostNeo_M;
	}
	public void setPostNeo_M(String PostNeo_M) {
		this.PostNeo_M = PostNeo_M;
	}
	public String getClinical_TNM() {
		return Clinical_TNM;
	}
	public void setClinical_TNM(String Clinical_TNM) {
		this.Clinical_TNM = Clinical_TNM;
	}
	public String getPathological_TNM() {
		return Pathological_TNM;
	}
	public void setPathological_TNM(String Pathological_TNM) {
		this.Pathological_TNM = Pathological_TNM;
	}
	public String getPostNeo_TNM() {
		return PostNeo_TNM;
	}
	public void setPostNeo_TNM(String PostNeo_TNM) {
		this.PostNeo_TNM = PostNeo_TNM;
	}
	public String getStatus_1year() {
		return Status_1year;
	}
	public void setStatus_1year(String status_1year) {
		Status_1year = status_1year;
	}
	public String getStatus_2year() {
		return Status_2year;
	}
	public void setStatus_2year(String status_2year) {
		Status_2year = status_2year;
	}
	public String getStatus_3year() {
		return Status_3year;
	}
	public void setStatus_3year(String status_3year) {
		Status_3year = status_3year;
	}
	public String getStatus_4year() {
		return Status_4year;
	}
	public void setStatus_4year(String status_4year) {
		Status_4year = status_4year;
	}
	public String getStatus_5year() {
		return Status_5year;
	}
	public void setStatus_5year(String status_5year) {
		Status_5year = status_5year;
	}	
	public String getComment1() {
		return Comment1;
	}
	public void setComment1(String comment1) {
		Comment1 = comment1;
	}
	public Date getRelapseDate() {
		return RelapseDate;
	}
	public void setRelapseDate(Date relapseDate) {
		RelapseDate = relapseDate;
	}
	public Date getDiagnosisDate() {
		return DiagnosisDate;
	}
	public void setDiagnosisDate(Date diagnosisDate) {
		DiagnosisDate = diagnosisDate;
	}
	public Date getStagingDate() {
		return StagingDate;
	}
	public void setStagingDate(Date stagingDate) {
		StagingDate = stagingDate;
	}
	public Date getTumorDate() {
		return TumorDate;
	}
	public void setTumorDate(Date tumorDate) {
		TumorDate = tumorDate;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public String getCancerType() {
		return CancerType;
	}
	public void setHistology(String Histology) {
		this.Histology = Histology;
	}
	public String getHistology() {
		return Histology;
	}
	public void setCancerType(String CancerType) {
		this.CancerType = CancerType;
	}	
	public String getNAChemoStatus() {
		return NAChemoStatus;
	}
	public void setNAChemoStatus(String NAChemoStatus) {
		this.NAChemoStatus = NAChemoStatus;
	}	
	public String getNARTStatus() {
		return NARTStatus;
	}
	public void setNARTStatus(String NARTStatus) {
		this.NARTStatus = NARTStatus;
	}
	public String getSBRTStatus() {
		return SBRTStatus;
	}
	public void setSBRTStatus(String SBRTStatus) {
		this.SBRTStatus = SBRTStatus;
	}	
	public String getChemotherapyStatus() {
		return ChemotherapyStatus;
	}
	public void setChemotherapyStatus(String ChemotherapyStatus) {
		this.ChemotherapyStatus = ChemotherapyStatus;
	}
	public String getRadtherapyStatus() {
		return RadtherapyStatus;
	}
	public void setRadtherapyStatus(String RadtherapyStatus) {
		this.RadtherapyStatus = RadtherapyStatus;
	}	
    public String getNAChemoMD() {
		return NAChemoMD;
	}
	public void setNAChemoMD(String nAChemoMD) {
		NAChemoMD = nAChemoMD;
	}
	public String getNARTMD() {
		return NARTMD;
	}
	public void setNARTMD(String nARTMD) {
		NARTMD = nARTMD;
	}
	public String getSBRTMD() {
		return SBRTMD;
	}
	public void setSBRTMD(String sBRTMD) {
		SBRTMD = sBRTMD;
	}
	public String getChemotherapyMD() {
		return ChemotherapyMD;
	}
	public void setChemotherapyMD(String chemotherapyMD) {
		ChemotherapyMD = chemotherapyMD;
	}
	public String getRadtherapyMD() {
		return RadtherapyMD;
	}
	public void setRadtherapyMD(String radtherapyMD) {
		RadtherapyMD = radtherapyMD;
	}
	public Date getNAChemoDate() {
		return NAChemoDate;
	}
	public void setNAChemoDate(Date nAChemoDate) {
		NAChemoDate = nAChemoDate;
	}
	public Date getNARTDate() {
		return NARTDate;
	}
	public void setNARTDate(Date nARTDate) {
		NARTDate = nARTDate;
	}
	public Date getSBRTDate() {
		return SBRTDate;
	}
	public void setSBRTDate(Date sBRTDate) {
		SBRTDate = sBRTDate;
	}
	public Date getChemotherapyDate() {
		return ChemotherapyDate;
	}
	public void setChemotherapyDate(Date chemotherapyDate) {
		ChemotherapyDate = chemotherapyDate;
	}
	public Date getRadtherapyDate() {
		return RadtherapyDate;
	}
	public void setRadtherapyDate(Date radtherapyDate) {
		RadtherapyDate = radtherapyDate;
	}

	public ArrayList<SelectItem> getCancerTypeList() throws SQLException{
    	CancerTypeList = new ArrayList<SelectItem>();	
    	try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
    		String query = "select * from `list - cancer types`";
    		//System.out.println("query is: " + query);
    		ResultSet rs = stmt.executeQuery(query);
    		while(rs.next()){
    			String s = rs.getString("TypeOfCancer");
    			CancerTypeList.add(new SelectItem(s,s));
    		}
    		conn.close();
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
        return CancerTypeList;
    }	 
    
    public void setCancerTypeList(ArrayList<SelectItem> CancerTypeList){
    	this.CancerTypeList = CancerTypeList;
    }

    public ArrayList<SelectItem> getHistList() throws SQLException{
    	HistList = new ArrayList<SelectItem>();	
    	try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
    		String query = "select * from `list - cancerhisto`";
    		//System.out.println("query is: " + query);
    		ResultSet rs = stmt.executeQuery(query);
    		while(rs.next()){
    			String s = rs.getString("Histology");
    			HistList.add(new SelectItem(s,s));
    		}
    		conn.close();
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
        return HistList;
    }	 
    
    public void setHistList(ArrayList<SelectItem> HistList){
    	this.HistList = HistList;
    }    
    
    public ArrayList<SelectItem> getStageTList() throws SQLException{
    	StageTList = new ArrayList<SelectItem>();	
    	try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
    		String query = "select * from `list - stage t`";
    		//System.out.println("query is: " + query);
    		ResultSet rs = stmt.executeQuery(query);
    		while(rs.next()){
    			String s = rs.getString("T - stage");
    			StageTList.add(new SelectItem(s,s));
    		}
    		conn.close();
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
        return StageTList;
    }	 
    
    public void setStageTList(ArrayList<SelectItem> StageTList){
    	this.StageTList = StageTList;
    }
    
    public ArrayList<SelectItem> getStageNList() throws SQLException{
    	StageNList = new ArrayList<SelectItem>();	
    	try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
    		String query = "select * from `list - stage n`";
    		//System.out.println("query is: " + query);
    		ResultSet rs = stmt.executeQuery(query);
    		while(rs.next()){
    			String s = rs.getString("N - stage");
    			StageNList.add(new SelectItem(s,s));
    		}
    		conn.close();
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
        return StageNList;
    }	 
    
    public void setStageNList(ArrayList<SelectItem> StageMList){
    	this.StageMList = StageMList;
    }
    
    public ArrayList<SelectItem> getStageMList() throws SQLException{
    	StageMList = new ArrayList<SelectItem>();	
    	try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
    		String query = "select * from `list - stage m`";
    		//System.out.println("query is: " + query);
    		ResultSet rs = stmt.executeQuery(query);
    		while(rs.next()){
    			String s = rs.getString("M - stage");
    			StageMList.add(new SelectItem(s,s));
    		}
    		conn.close();
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
        return StageMList;
    }	 
    
    public void setStageMList(ArrayList<SelectItem> StageMList){
    	this.StageMList = StageMList;
    }
    
    public ArrayList<SelectItem> getStageTNMList() throws SQLException{
    	StageTNMList = new ArrayList<SelectItem>();	
    	try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
    		String query = "select * from `list - stagetnm`";
    		//System.out.println("query is: " + query);
    		ResultSet rs = stmt.executeQuery(query);
    		while(rs.next()){
    			String s = rs.getString("Stage - TNM");
    			StageTNMList.add(new SelectItem(s,s));
    		}
    		conn.close();
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
        return StageTNMList;
    }	 
    
    public void setStageTNMList(ArrayList<SelectItem> StageTNMList){
    	this.StageTNMList = StageTNMList;
    }

    public ArrayList<SelectItem> getCancerTxList() throws SQLException{
    	CancerTxList = new ArrayList<SelectItem>();	
    	try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
    		String query = "select * from `list - cancertxplan`";
    		//System.out.println("query is: " + query);
    		ResultSet rs = stmt.executeQuery(query);
    		while(rs.next()){
    			String s = rs.getString("CancerTherapy");
    			CancerTxList.add(new SelectItem(s,s));
    		}	
    		conn.close();
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
    	return CancerTxList;
    }	  

    public void setCancerTxList(ArrayList<SelectItem> CancerTxList){
    	this.CancerTxList = CancerTxList;
    }    

    public void setMDList(ArrayList<SelectItem> MDList){
    	this.MDList = MDList;
    }
 
    public ArrayList<SelectItem> getMDList() throws SQLException{
    	MDList = new ArrayList<SelectItem>();	
    	try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
    		String query = "select * from `list - physicians-treating`";
    		//System.out.println("query is: " + query);
    		ResultSet rs = stmt.executeQuery(query);
    		while(rs.next()){
    			String s = rs.getString("Treating Physican");
    			MDList.add(new SelectItem(s,s));
    		}	
    		conn.close();
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
    	return MDList;
    }	     
    
	public String searchWorkUpStatus() throws SQLException{		
		String result = "";	
		int wstatus = 0;
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Workup Status` from patient where "+
								"`MRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					wstatus = rs.getInt("Workup Status");
				}
				
				query = "select WorkUpStatus " + 
						"from `list - workupstatus` " +
						"where WorkUpStatusNum = " + wstatus;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("WorkUpStatus");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
    
	public String searchLCECStatus() throws SQLException{		
		String result = "";	
		int lstatus = 0;
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `LCEC Status` from patient where "+
								"`MRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					lstatus = rs.getInt("LCEC Status");
				}
				
				query = "select `Active-Inactive` " + 
						"from `list - patientstatus` " +
						"where ID = " + lstatus;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Active-Inactive");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchInDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `InactiveDate` from patient where "+
								"`MRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("InactiveDate");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public boolean searchLCECChart() throws SQLException{		
		boolean result = false;	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `LCEC Chart` from patient where "+
								"`MRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getBoolean("LCEC Chart");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchDiagDate(String mrn) throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Date of 1st Diagnosis` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Date of 1st Diagnosis");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchStageDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Date of Final Staging` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Date of Final Staging");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchTumorDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Date of Tumor Board` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Date of Tumor Board");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchCancerType() throws SQLException{	
		int Cancertype = 0;
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `CancerType` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					Cancertype = rs.getInt("CancerType");
				}
				
				query = "select `TypeOfCancer` " + 
						"from `list - cancer types` " +
						"where ID = " + Cancertype;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("TypeOfCancer");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}	
	
	public String searchHistology() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `CancerHisto` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("CancerHisto");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}	
	
	public String searchCancerComment() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `CancerTypeComment` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("CancerTypeComment");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}	

	public String searchClinicalT() throws SQLException{
		int StageTC = 0;
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - T Clinical` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					StageTC = rs.getInt("Stage - T Clinical");
				}
				
				query = "select `T - stage` " + 
						"from `list - stage t` " +
						"where ID = "+StageTC;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("T - stage");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchClinicalN() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - N Clinical` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - N Clinical");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchClinicalM() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - M Clinical` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - M Clinical");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchClinicalTNM() throws SQLException{
		int StageTNMC = 0;
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - TNM Clinical` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					StageTNMC = rs.getInt("Stage - TNM Clinical");
				}
				
				query = "select `Stage - TNM` " + 
						"from `list - stagetnm` " +
						"where ID = "+StageTNMC;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - TNM");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchPathologicT() throws SQLException{
		int StageTP = 0;
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - T Pathologic` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					StageTP = rs.getInt("Stage - T Pathologic");
				}
				
				query = "select `T - stage` " + 
						"from `list - stage t` " +
						"where ID = "+StageTP;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("T - stage");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchPathologicN() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - N Pathologic` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - N Pathologic");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchPathologicM() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - M Pathologic` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - M Pathologic");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchPathologicTNM() throws SQLException{
		int StageTNMP = 0;
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - TNM Pathologic` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					StageTNMP = rs.getInt("Stage - TNM Pathologic");
				}
				
				query = "select `Stage - TNM` " + 
						"from `list - stagetnm` " +
						"where ID = "+StageTNMP;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - TNM");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			
		}
		return result;
	}
	
	public String searchRestageT() throws SQLException{
		int stageTR = 0;
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - T Restage` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					stageTR = rs.getInt("Stage - T Restage");
				}
				
				query = "select `T - stage` " + 
						"from `list - stage t` " +
						"where ID = "+stageTR;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("T - stage");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchRestageN() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - N Restage` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - N Restage");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchRestageM() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - M Restage` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - M Restage");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchRestageTNM() throws SQLException{	
		int StageTNMR = 0;
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Stage - TNM Restage` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					StageTNMR = rs.getInt("Stage - TNM Restage");
				}
				
				query = "select `Stage - TNM` " + 
						"from `list - stagetnm` " +
						"where ID = "+StageTNMR;
				//System.out.println("Query is: " + query);
				rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Stage - TNM");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchComment() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Comment` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Comment");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
		
	public String searchRelapseDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Date 1st Relapse` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Date 1st Relapse");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchStatus1year() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Status 1 year` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Status 1 year");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchStatus2year() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Status 2 year` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Status 2 year");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchStatus3year() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Status 3 year` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Status 3 year");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchStatus4year() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Status 4 year` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Status 4 year");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchStatus5year() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `Status 5 year` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("Status 5 year");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchNeoChemoPlan() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `NeoChemoPlan` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("NeoChemoPlan");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchNeoChemoMD() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `NeoChemoMD` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("NeoChemoMD");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchNeoChemoStartDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `NeoChemoStartDate` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("NeoChemoStartDate");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchNeoRTPlan() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `NeoRTPlan` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("NeoRTPlan");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchNeoRTMD() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `NeoRTMD` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("NeoRTMD");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchNeoRTStartDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `NeoRTStartDate` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("NeoRTStartDate");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchSurgeryPlan() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `SurgeryPlan` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("SurgeryPlan");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchSurgeryMD() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `SurgeryMD` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("SurgeryMD");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchSurgeryDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `SurgeryDate` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("SurgeryDate");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public String searchChemoPlan() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `ChemoPlan` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("ChemoPlan");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchChemoMD() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `ChemoMD` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("ChemoMD");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchChemoDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `ChemoDate` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("ChemoDate");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchRTPlan() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `RTPlan` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("RTPlan");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}	
	
	public String searchRTMD() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `RTMD` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("RTMD");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}

	public String searchRTDate() throws SQLException{		
		String result = "";	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();			
			if(!(selectedMRN.getMrn()).equals(""))
			{	
				String query = 
						"select `RTDate` from `patient-cancer` where "+
								"`PatientMRN` = '"+selectedMRN.getMrn()+"'";				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					result = rs.getString("RTDate");
				}
			}
			conn.close();
		}
		catch(Exception ex){
			logger.error(ex,ex);
			return result;
		}
		return result;
	}
	
	public void cancer(String mrn) throws SQLException {
		try{
    		Dbconn dbcon = new Dbconn();
    		Connection conn = dbcon.getLocalConnection();
    		Statement stmt = conn.createStatement();
			String query = 
					"select `LCEC Chart`,`InactiveDate`"+
					" from patient where "+
					"`MRN` = '"+mrn+"'";
			//System.out.println("Query is: " + query);
			ResultSet rs = stmt.executeQuery(query);			
			while(rs.next()){
        		setInactiveDate(rs.getDate("InactiveDate"));
        		setLCECChart(rs.getBoolean("LCEC Chart"));
    		}		
			
			query = 
					"select "+
					"`Date of 1st Diagnosis`,`Date of Final Staging`,`Date of Tumor Board`,"+
					"`CancerTypeComment`,`Comment`,`Date 1st Relapse`,"+
					"`NeoChemoStartDate`,"+
					"`NeoRTStartDate`,"+
					"`SurgeryDate`,"+
					"`ChemoStartDate`,"+
					"`RTStartDate`"+
					" from `patient-cancer` where "+
					"`PatientMRN` = '"+mrn+"'";
			//System.out.println("Query is: " + query);
			rs = stmt.executeQuery(query);
			while(rs.next()){
				setDiagnosisDate(rs.getDate("Date of 1st Diagnosis"));
				setStagingDate(rs.getDate("Date of Final Staging"));
				setTumorDate(rs.getDate("Date of Tumor Board"));
				setComment(rs.getString("CancerTypeComment"));
				setComment1(rs.getString("Comment"));
				setRelapseDate(rs.getDate("Date 1st Relapse"));
				setNAChemoDate(rs.getDate("NeoChemoStartDate"));
				setNARTDate(rs.getDate("NeoRTStartDate"));
				setSBRTDate(rs.getDate("SurgeryDate"));
				setChemotherapyDate(rs.getDate("ChemoStartDate"));
				setRadtherapyDate(rs.getDate("RTStartDate"));
    		}
    	}
    	catch(Exception ex){
    		logger.error(ex,ex);
    	}
	}
	
	public void updateStatus() throws SQLException {
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();

			int wstatus = 0, lstatus = 0, cancertype = 0;
			int ct = 0, pt = 0, rt = 0, ctnm = 0, ptnm = 0, rtnm = 0;
			String query = "";
			
			if(!(selectedMRN.getMrn()).equals(""))
			{			
				query = "select WorkUpStatusNum " + 
						"from `list - workupstatus` " +
						"where WorkUpStatus = " + WorkupStatus;
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					wstatus = rs.getInt("WorkUpStatusNum");
				}
			}			
			if(!(selectedMRN.getMrn()).equals(""))
			{				
				query = "select ID " + 
						"from `list - patientstatus` " +
						"where `Active-Inactive` = '" + LCECStatus + "'";
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					lstatus = rs.getInt("ID");
				}
			}	
			if(!(selectedMRN.getMrn()).equals(""))
			{				
				query = "select `ID` " + 
						"from `list - cancer types` " +
						"where `TypeOfCancer` = " + CancerType;
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					cancertype = rs.getInt("ID");
				}
			}	
			if(!(selectedMRN.getMrn()).equals(""))
			{				
				query = "select ID " + 
						"from `list - stage t` " +
						"where `T - stage` = "+Clinical_T;
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					ct = rs.getInt("ID");
				}
			}		
			if(!(selectedMRN.getMrn()).equals(""))
			{				
				query = "select ID " + 
						"from `list - stage t` " +
						"where `T - stage` = "+Pathological_T;
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					pt = rs.getInt("ID");
				}
			}
			if(!(selectedMRN.getMrn()).equals(""))
			{				
				query = "select ID " + 
						"from `list - stage t` " +
						"where `T - stage` = "+PostNeo_T;
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					rt = rs.getInt("ID");
				}
			}
			if(!(selectedMRN.getMrn()).equals(""))
			{				
				query = "select ID " + 
						"from `list - stagetnm` " +
						"where `Stage - TNM` = "+Clinical_TNM;
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					ctnm = rs.getInt("ID");
				}
			}
			if(!(selectedMRN.getMrn()).equals(""))
			{				
				query = "select ID " + 
						"from `list - stagetnm` " +
						"where `Stage - TNM` = "+Pathological_TNM;
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					ptnm = rs.getInt("ID");
				}
			}
			if(!(selectedMRN.getMrn()).equals(""))
			{				
				query = "select ID " + 
						"from `list - stagetnm` " +
						"where `Stage - TNM` = "+PostNeo_TNM;
				//System.out.println("Query is: " + query);
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					rtnm = rs.getInt("ID");
				}
			}			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String inactivedate = sdf.format(InactiveDate);
			String diagnosisdate = sdf.format(DiagnosisDate);
			String stagingdate = sdf.format(StagingDate);
			String tumordate = sdf.format(TumorDate);
			String relapsedate = sdf.format(RelapseDate);
			String nachemodate = sdf.format(NAChemoDate);
			String nartdate = sdf.format(NARTDate);
			String sbrtdate = sdf.format(SBRTDate);
			String chemodate = sdf.format(ChemotherapyDate);
			String raddate = sdf.format(RadtherapyDate);
			
			// update begins
			query = 
					"update `patient` set" +
					" `WorkUp Status` = '" + wstatus +
					"', `LCEC Status` = " + lstatus +
					"', `InactiveDate` = " + inactivedate +
					" where MRN = '" + selectedMRN.getMrn() + "'"; 			
			//System.out.println("Query is: " + query);
			stmt.executeUpdate(query);			
			query = 
					"update `patient-cancer` set" + 
					" `Date of 1st Diagnosis` = '" + diagnosisdate +
					"', `Date of Final Staging` = '" + stagingdate +
					"', `Date of Tumor Board` = '" + tumordate +
					"', `CancerType` = " + cancertype +
					" , `CancerHisto` = '" + Histology +
					"', `CancerTypeComment` = '" + Comment +
					"', `Stage - T Clinical` = " + ct +
					" , `Stage - T Pathologic` = " + pt +
					" , `Stage - T Restage` = " + rt +
					" , `Stage - N Clinical` = '" + Clinical_N +
					"', `Stage - N Pathologic` = '" + Pathological_N +
					"', `Stage - N Restage` = '" + PostNeo_N +
					"', `Stage - M Clinical` = '" + Clinical_M +
					"', `Stage - M Pathologic` = '" + Pathological_M +
					"', `Stage - M Restage` = '" + PostNeo_M +
					"', `Stage - TNM Clinical` = " + ctnm +
					" , `Stage - TNM Pathologic` = " + ptnm +
					" , `Stage - TNM Restage` = " + rtnm +
					" , `Status 1 year` = '" + Status_1year +
					"', `Status 2 year` = '" + Status_2year +
					"', `Status 3 year` = '" + Status_3year +
					"', `Status 4 year` = '" + Status_4year +
					"', `Status 5 year` = '" + Status_5year +
					"', `Comment` = '" + Comment1 +
					"', `Date 1st Relapse` = '" + relapsedate +
					"', `NeoChemoPlan` = '" + NAChemoStatus +
					"', `NeoChemoMD` = '" + NAChemoMD +
					"', `NeoChemoEndDate` = '" + nachemodate +
					"', `NeoRTPlan` = '" + NARTStatus +
					"', `NeoRTMD` = '" + NARTMD +
					"', `NeoRTEndDate` = '" + nartdate +
					"', `SurgeryPlan` = '" + SBRTStatus +
					"', `SurgeryMD` = '" + SBRTMD +
					"', `SurgeryDate` = '" + sbrtdate +
					"', `ChemoPlan` = '" + ChemotherapyStatus +
					"', `ChemoMD` = '" + ChemotherapyMD +
					"', `ChemoEndDate` = '" + chemodate +
					"', `RTPlan` = '" + RadtherapyStatus +
					"', `RTMD` = '" + RadtherapyMD +
					"', `RTEndDate` = '" + raddate +
					"' where PatientMRN = '" + selectedMRN.getMrn() + "'";	
			//System.out.println("Query is: " + query);
			stmt.executeUpdate(query);
		}
		catch(Exception ex){
			logger.error(ex,ex);
		}
	}
}
