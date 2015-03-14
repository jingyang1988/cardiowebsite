package lcec.model;

import java.util.Date;
import java.io.*;

public class PatientDataModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Patient patient;
	// patient info
	private String ssn;
	private String gender;
	private Date dob;

	public PatientDataModel(Patient patient) {
		this.patient = patient;
	}

	public PatientDataModel() {
		this.patient = new Patient();
	}
	
	//Added by rjosan TEST
	public Patient getPatient() {
		if(patient == null)
			patient = new Patient();
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	//End of Addition
	
	public String getName() {
		return this.patient.getName();
	}

	public String getMrn() {
		return this.patient.getMrn();
	}

	public String getWorkupStatus() {
		return this.patient.getWorkupStatus();
	}

	public String getLcecStatus() {
		return this.patient.getLcecStatus();
	}
	
	public void setMrn(String mrn) {
		this.patient.setMrn(mrn);
	}
	
	public void setName(String name) {
		this.patient.setName(name);
	}
	
	public void setWorkupStatus(String workupStatus) {
		this.patient.setWorkupStatus(workupStatus);
	}
	
	public void setLcecStatus(String lcecStatus) {
		this.patient.setLcecStatus(lcecStatus);
	}

	public int getWorkUpId() {
		return this.patient.getWorkUpId();
	}

	public void setWorkUpId(int workUpId) {
		this.patient.setWorkUpId(workUpId);
	}

	public int getLcecId() {
		return this.patient.getLcecId();
	}

	public void setLcecId(int lcecId) {
		this.patient.setLcecId(lcecId);
	}

	
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	// address
	private String address;
	private String city;
	private String state;
	private String pincode;
	private String phoneNum;
	private String AltPhoneNum;
	private String email;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAltPhoneNum() {
		return AltPhoneNum;
	}

	public void setAltPhoneNum(String altPhoneNum) {
		AltPhoneNum = altPhoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// insurance info
	private String insuranceCompany;
	private String insuranceId;
	private String insurancePhoneNum;
	private String insuranceComment;

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsurancePhoneNum() {
		return insurancePhoneNum;
	}

	public void setInsurancePhoneNum(String insurancePhoneNum) {
		this.insurancePhoneNum = insurancePhoneNum;
	}

	public String getInsuranceComment() {
		return insuranceComment;
	}

	public void setInsuranceComment(String insuranceComment) {
		this.insuranceComment = insuranceComment;
	}

	// referral info
	private Date referralDate;
	private String referringMD;
	private String primaryCare;
	private String additionalMD;

	public Date getReferralDate() {
		return referralDate;
	}

	public void setReferralDate(Date referralDate) {
		this.referralDate = referralDate;
	}

	public String getReferringMD() {
		return referringMD;
	}

	public void setReferringMD(String referringMD) {
		this.referringMD = referringMD;
	}

	public String getPrimaryCare() {
		return primaryCare;
	}

	public void setPrimaryCare(String primaryCare) {
		this.primaryCare = primaryCare;
	}

	public String getAdditionalMD() {
		return additionalMD;
	}

	public void setAdditionalMD(String additionalMD) {
		this.additionalMD = additionalMD;
	}

	// lcec status
	private boolean lcecChart;
	private Date inactiveDate;
	private boolean scheduledMD;

	public boolean getLcecChart() {
		return lcecChart;
	}

	public void setLcecChart(boolean lcecChart) {
		this.lcecChart = lcecChart;
	}

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date interactiveDate) {
		this.inactiveDate = interactiveDate;
	}

	public boolean getScheduledMD() {
		return scheduledMD;
	}

	public void setScheduledMD(boolean scheuledMD) {
		this.scheduledMD = scheuledMD;
	}
	
	//
	// CT, PET, PFT status
		private String CT;
		private String PET;
		private String PFT;
		public String getCT() {
			return CT;
		}

		public void setCT(String cT) {
			CT = cT;
		}

		public String getPET() {
			return PET;
		}

		public void setPET(String pET) {
			PET = pET;
		}

		public String getPFT() {
			return PFT;
		}

		public void setPFT(String pFT) {
			PFT = pFT;
		}

		// Added by rjosan
		
		// Status fields
		private String referralVisit;
		//private String insurancePh;
		private String secInsurance;
		private String secInsuranceID;
		
		
		public String getReferralVisit() {
			return referralVisit;
		}

		public void setReferralVisit(String NreferralVisit) {
			referralVisit = NreferralVisit;
		}

//		public String getInsurancePh() {
//			return insurancePh;
//		}
//
//		public void setInsurancePh(String NinsurancePh) {
//			insurancePh = NinsurancePh;
//		}

		public String getSecInsurance() {
			return secInsurance;
		}

		public void setSecInsurance(String NsecInsurance) {
			secInsurance = NsecInsurance;
		}

		public String getSecInsuranceID() {
			return secInsuranceID;
		}

		public void setSecInsuranceID(String NsecInsuranceID) {
			secInsuranceID = NsecInsuranceID;
		}

		public String getOldMrn() {
			// TODO Auto-generated method stub
			return this.patient.getOldmrn();
			
		}
		public void setOldMrn(String oldmrn) {
			// TODO Auto-generated method stub
			this.patient.setOldmrn(oldmrn);
			
		}
		
		
}
