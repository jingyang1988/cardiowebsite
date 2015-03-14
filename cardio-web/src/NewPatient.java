

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.model.SelectItem;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.Serializable;

import lcec.controller.LoginBean;

@ManagedBean
@SessionScoped
public class NewPatient implements Serializable{
	Logger logger = null;
	public NewPatient() {
		super();
	logger = LogManager.getLogger(NewPatient.class
				.getName());
	}



	private static final long serialVersionUID = 1L;

	public String SearchMRN;
	public String SearchName;

	// address and contact information
	public String MRN;
	public String Name;
	public String Address;
	public String City;
	public String State;
	public String PostalCode;
	public String PhoneNumber;
	public String AltPhone;
	public String Email;
	public String DOB;
	public String Gender;
	public String SSN;

	//Insurance Information
	public String InsuranceCo;
	public String InsuranceID;
	public String Comment;
	public String CT;
	public String PET;
	public String PFT;
	public String ReferralVisit;
	public String InsurancePh;
	public String SecInsurance;
	public String SecInsuranceID;

	//Referral Information
	public String ReferralDate;
	public String ReferringMD;
	public String PrimaryCareMD;
	public String AdditionalMD;
	public boolean LCECChart;
	public int WorkupStatus;
	public int LCECStatus;
	public String InactiveDate;
	public boolean ScheduleMD;

	// Array Lists
	public ArrayList<SelectItem> PatientList = null;
	public ArrayList<SelectItem> MRNList = null;
	public ArrayList<SelectItem> MDList = null;
	public ArrayList<SelectItem> InsuranceList = null;
	public ArrayList<SelectItem> GenderList = null;
	public ArrayList<SelectItem> WorkupList;
	public ArrayList<SelectItem> LCECStatusList;

	//getter/setter methods

	public ArrayList<SelectItem> getPatientList() throws SQLException{
		PatientList = new ArrayList<SelectItem>();	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from test.`patient`";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String s = rs.getString("Name (Last,First)");
				PatientList.add(new SelectItem(s,s));
			}
		}
		catch(Exception ex){
			logger.error(ex, ex);
		}
		return PatientList;
	}	 

	public void setPatientList(ArrayList<SelectItem> PatientList){
		this.PatientList = PatientList;
	}

	public ArrayList<SelectItem> getMRNList() throws SQLException{
		MRNList = new ArrayList<SelectItem>();	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from test.`patient`";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String s = rs.getString("MRN");
				MRNList.add(new SelectItem(s,s));
			}
		}
		catch(Exception ex){
			logger.error(ex, ex);
		}
		return MRNList;
	}	

	public void setMRNList(ArrayList<SelectItem> MRNList){
		this.MRNList = MRNList;
	}   

	public ArrayList<SelectItem> getMDList() throws SQLException{
		MDList = new ArrayList<SelectItem>();	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from test.`list - physician-referring`";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String s = rs.getString("Referring Physican");
				MDList.add(new SelectItem(s,s));
			}
		}
		catch(Exception ex){
			logger.error(ex, ex);
		}
		return MDList;
	}	

	public void setMDList(ArrayList<SelectItem> MDList){
		this.MDList = MDList;
	}

	public ArrayList<SelectItem> getInsuranceList() throws SQLException{
		InsuranceList = new ArrayList<SelectItem>();
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from test.`list - insurance`";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String s = rs.getString("InsurCo");
				InsuranceList.add(new SelectItem(s,s));
			}
		}
		catch(Exception ex){
			logger.error(ex, ex);
		}
		return InsuranceList;
	}	

	public void setInsuranceList(ArrayList<SelectItem> InsuranceList){
		this.InsuranceList = InsuranceList;
	}

	public ArrayList<SelectItem> getGenderList() throws SQLException{
		GenderList = new ArrayList<SelectItem>();
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from test.`sts-gender`";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String s = rs.getString("genderdefn");
				GenderList.add(new SelectItem(s,s));
			}
		}
		catch(Exception ex){
			logger.error(ex, ex);
		}
		return GenderList;
	}	

	public void setGenderList(ArrayList<SelectItem> GenderList){
		this.GenderList = GenderList;
	}

	public ArrayList<SelectItem> getWorkupList() throws SQLException{
		WorkupList = new ArrayList<SelectItem>();
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from test.`list - workupstatus`";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String s = rs.getString("WorkUpStatus");
				int v = rs.getInt("WorkUpStatusNum");
				WorkupList.add(new SelectItem(v,s));
			}
		}
		catch(Exception ex){
			logger.error(ex, ex);
		}
		return WorkupList;
	}	

	public void setWorkupList(ArrayList<SelectItem> WorkupList){
		this.WorkupList = WorkupList;
	}

	public ArrayList<SelectItem> getLCECStatusList() throws SQLException{
		LCECStatusList = new ArrayList<SelectItem>();	
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();
			String query = "select * from test.`list - patientstatus`";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String s = rs.getString("Active-Inactive");
				int v = rs.getInt("ID");
				LCECStatusList.add(new SelectItem(v,s));
			}
		}
		catch(Exception ex){
			logger.error(ex, ex);
		}
		return LCECStatusList;
	}	 

	public void setLCECStatusList(ArrayList<SelectItem> LCECStatusList){
		this.LCECStatusList = LCECStatusList;
	}

	public String getSearchMRN() {
		return SearchMRN;
	}
	public void setSearchMRN(String SearchMRN) {
		this.SearchMRN = SearchMRN;
	}     
	public String getSearchName() {
		return SearchName;
	}
	public void setSearchName(String SearchName) {
		this.SearchName = SearchName;
	}
	public String getMRN() {
		return MRN;
	}
	public void setMRN(String MRN) {
		this.MRN = MRN;
	} 
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		this.City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		this.State = state;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		this.PostalCode = postalCode;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}
	public String getAltPhone() {
		return AltPhone;
	}
	public void setAltPhone(String altPhone) {
		this.AltPhone = altPhone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	public String getInsuranceCo() {
		return InsuranceCo;
	}
	public void setInsuranceCo(String insuranceCo) {
		this.InsuranceCo = insuranceCo;
	}
	public String getInsuranceID() {
		return InsuranceID;
	}
	public void setInsuranceID(String insuranceID) {
		this.InsuranceID = insuranceID;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		this.Comment = comment;
	}
	public String getCT() {
		return CT;
	}
	public void setCT(String cT) {
		this.CT = cT;
	}
	public String getPET() {
		return PET;
	}
	public void setPET(String pET) {
		this.PET = pET;
	}
	public String getPFT() {
		return PFT;
	}
	public void setPFT(String pFT) {
		this.PFT = pFT;
	}
	public String getReferralVisit() {
		return ReferralVisit;
	}
	public void setReferralVisit(String referralVisit) {
		this.ReferralVisit = referralVisit;
	}
	public String getInsurancePh() {
		return InsurancePh;
	}
	public void setInsurancePh(String insurancePh) {
		this.InsurancePh = insurancePh;
	}
	public String getSecInsurance() {
		return SecInsurance;
	}
	public void setSecInsurance(String secInsurance) {
		this.SecInsurance = secInsurance;
	}
	public String getSecInsuranceID() {
		return SecInsuranceID;
	}
	public void setSecInsuranceID(String secInsuranceID) {
		this.SecInsuranceID = secInsuranceID;
	}
	public String getReferralDate() {
		return ReferralDate;
	}
	public void setReferralDate(String ReferralDate) {
		this.ReferralDate = ReferralDate;
	}
	public String getReferringMD() {
		return ReferringMD;
	}
	public void setReferringMD(String ReferringMD) {
		this.ReferringMD = ReferringMD;
	}
	public String getPrimaryCareMD() {
		return PrimaryCareMD;
	}
	public void setPrimaryCareMD(String PrimaryCareMD) {
		this.PrimaryCareMD = PrimaryCareMD;
	}
	public String getAdditionalMD() {
		return AdditionalMD;
	}
	public void setAdditionalMD(String AdditionalMD) {
		this.AdditionalMD = AdditionalMD;
	}
	public boolean getLCECChart() {
		return LCECChart;
	}
	public void setLCECChart(boolean LCECChart) {
		this.LCECChart = LCECChart;
	}
	public int getWorkupStatus() {
		return WorkupStatus;
	}
	public void setWorkupStatus(int WorkupStatus) {
		this.WorkupStatus = WorkupStatus;
	}	
	public int getLCECStatus() {
		return LCECStatus;
	}
	public void setLCECStatus(int LCECStatus) {
		this.LCECStatus = LCECStatus;
	}
	public String getInactiveDate() {
		return InactiveDate;
	}
	public void setInactiveDate(String InactiveDate) {
		this.InactiveDate = InactiveDate;
	}
	public boolean getScheduleMD() {
		return ScheduleMD;
	}
	public void setScheduleMD(boolean ScheduleMD) {
		this.ScheduleMD = ScheduleMD;
	}

	public String addPatient() throws SQLException{
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();

			String query = 
					"insert into test.patient(`MRN`,`Name (Last,First)`,`Date of Referral`,"+
							"`Gender`,`SocSecNumber`,`Referring MD`,`Primary Care Physician`,"+
							"`Additional MD`,`Workup Status`,`LCEC Status`,`LCEC Chart`,`InactiveDate`,"+
							"`Insurance`,`InsurComment`,`InsurancePhone`,`InsuranceID`,`Secondary Insurance`,"+
							"`Secondary InsurID`,`CT Precert`,`PET Precert`,`PFT Precert`,`Referral Needed`,"+	
							"`SchedFUwithMD`,`Address`,`City`,`StateOrProvince`,`PostalCode`,`PhoneNumber`,"+
							"`Alternative Phone`,`EmailAddress`)"+

				"values('"+MRN+"','"+Name+"',str_to_date('"+ReferralDate+"','%M/%d/%Y'),'"
				+Gender+"','"+SSN+"','"+ReferringMD+"','"+PrimaryCareMD+"','"
				+AdditionalMD+"',"+WorkupStatus+","+LCECStatus+","+LCECChart
				+",str_to_date('"+InactiveDate+"','%M/%d/%Y'),'"+InsuranceCo+"','"
				+Comment+"','"+InsurancePh+"','"+InsuranceID+"','"+SecInsurance+"','"
				+SecInsuranceID+"','"+CT+"','"+PET+"','"+PFT+"','"+ReferralVisit+"',"
				+ScheduleMD+",'"+Address+"','"+City+"','"+State+"','"+PostalCode+"','"
				+PhoneNumber+"','"+AltPhone+"','"+Email+"')";

			
			stmt.executeUpdate(query);
		}
		catch(Exception ex){
			logger.error(ex, ex);
			return "failure";
		}
		return "success";
	}

	public void searchPatient() throws SQLException{
		try{
			Dbconn dbcon = new Dbconn();
			Connection conn = dbcon.getLocalConnection();
			Statement stmt = conn.createStatement();

			String query = 
					"select `MRN`,`Name (Last,First)`,`Date of Birth`,`Date of Referral`,"+
							"`Gender`,`SocSecNumber`,`Referring MD`,`Primary Care Physician`,"+
							"`Additional MD`,`Workup Status`,`LCEC Status`,`LCEC Chart`,`InactiveDate`,"+
							"`Insurance`,`InsurComment`,`InsurancePhone`,`InsuranceID`,`Secondary Insurance`,"+
							"`Secondary InsurID`,`CT Precert`,`PET Precert`,`PFT Precert`,`Referral Needed`,"+	
							"`SchedFUwithMD`,`Address`,`City`,`StateOrProvince`,`PostalCode`,`PhoneNumber`,"+
							"`Alternative Phone`,`EmailAddress` from test.patient where "+
							"`MRN` = '"+SearchMRN+"'";

			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				setMRN(rs.getString("MRN"));
				setName(rs.getString("Name (Last,First)"));
				setAddress(rs.getString("Address"));
				setCity(rs.getString("City"));
				setState(rs.getString("StateOrProvince"));
				setPostalCode(rs.getString("PostalCode"));
				setPhoneNumber(rs.getString("PhoneNumber"));
				setAltPhone(rs.getString("Alternative Phone"));
				setEmail(rs.getString("EmailAddress"));
				setDOB(rs.getString("Date of Birth"));
				setGender(rs.getString("Gender"));
				setSSN(rs.getString("SocSecNumber"));
				setInsuranceCo(rs.getString("Insurance"));
				setInsuranceID(rs.getString("InsuranceID"));
				setComment(rs.getString("InsurComment"));
				setCT(rs.getString("CT Precert"));
				setPET(rs.getString("PET Precert"));
				setPFT(rs.getString("PFT Precert"));
				setReferralVisit(rs.getString("Referral Needed"));
				setInsurancePh(rs.getString("InsurancePhone"));
				setSecInsurance(rs.getString("Secondary Insurance"));
				setSecInsuranceID(rs.getString("Secondary InsurID"));
				setReferralDate(rs.getString("Date of Referral"));
				setReferringMD(rs.getString("Referring MD"));
				setPrimaryCareMD(rs.getString("Primary Care Physician"));
				setAdditionalMD(rs.getString("Additional MD"));
				setWorkupStatus(rs.getInt("Workup Status"));
				setLCECStatus(rs.getInt("LCEC Status"));
				setInactiveDate(rs.getString("InactiveDate"));
				setScheduleMD(rs.getBoolean("SchedFUwithMD"));
				setLCECChart(rs.getBoolean("LCEC Chart"));
			}
		}
		catch(Exception ex){
			logger.error(ex, ex);
		}
	}



	public String searchPatientByName(String s) throws SQLException{

		Dbconn dbcon = new Dbconn();
		Connection conn = dbcon.getLocalConnection();
		Statement stmt = conn.createStatement();

		String query = 
				"select `MRN`,`Name (Last,First)`,`Date of Birth`,`Date of Referral`,"+
						"`Gender`,`SocSecNumber`,`Referring MD`,`Primary Care Physician`,"+
						"`Additional MD`,`Workup Status`,`LCEC Status`,`LCEC Chart`,`InactiveDate`,"+
						"`Insurance`,`InsurComment`,`InsurancePhone`,`InsuranceID`,`Secondary Insurance`,"+
						"`Secondary InsurID`,`CT Precert`,`PET Precert`,`PFT Precert`,`Referral Needed`,"+	
						"`SchedFUwithMD`,`Address`,`City`,`StateOrProvince`,`PostalCode`,`PhoneNumber`,"+
						"`Alternative Phone`,`EmailAddress` from test.patient where "+
						"`Name (Last,First)` = '"+s+"'";

		
		ResultSet rs = stmt.executeQuery(query);

		return rs.getString("Insurance");
	}
}
