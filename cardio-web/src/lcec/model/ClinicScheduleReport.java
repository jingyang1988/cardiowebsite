package lcec.model;

import java.util.Date;

public class ClinicScheduleReport implements java.io.Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mrn;
	private String name;
	private int smokerStatusEntry;
	private int smokerStatusCurrent;
	private String alternativePhone;
	private String phoneNumber;
	private Date dob;
	private String insurance;
	private String insurancePhone;
	private String insuranceID;
	private String secInsurance;
	private String secInsurID;
	private String referralNeeded;
	private Date dateRequired;
	private Date dateScheduled;
	private String toSee;
	private String refNo;
	
	
	public String getMrn() {
		return mrn;
	}
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSmokerStatusEntry() {
		return smokerStatusEntry;
	}
	public void setSmokerStatusEntry(int smokerStatusEntry) {
		this.smokerStatusEntry = smokerStatusEntry;
	}
	public int getSmokerStatusCurrent() {
		return smokerStatusCurrent;
	}
	public void setSmokerStatusCurrent(int smokerStatusCurrent) {
		this.smokerStatusCurrent = smokerStatusCurrent;
	}
	public String getAlternativePhone() {
		return alternativePhone;
	}
	public void setAlternativePhone(String alternativePhone) {
		this.alternativePhone = alternativePhone;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getInsurancePhone() {
		return insurancePhone;
	}
	public void setInsurancePhone(String insurancePhone) {
		this.insurancePhone = insurancePhone;
	}
	public String getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
	public String getSecInsurance() {
		return secInsurance;
	}
	public void setSecInsurance(String secInsurance) {
		this.secInsurance = secInsurance;
	}
	public String getSecInsurID() {
		return secInsurID;
	}
	public void setSecInsurID(String secInsurID) {
		this.secInsurID = secInsurID;
	}
	public String getReferralNeeded() {
		return referralNeeded;
	}
	public void setReferralNeeded(String referralNeeded) {
		this.referralNeeded = referralNeeded;
	}
	public Date getDateRequired() {
		return dateRequired;
	}
	public void setDateRequired(Date dateRequired) {
		this.dateRequired = dateRequired;
	}
	public Date getDateScheduled() {
		return dateScheduled;
	}
	public void setDateScheduled(Date dateScheduled) {
		this.dateScheduled = dateScheduled;
	}
	public String getToSee() {
		return toSee;
	}
	public void setToSee(String toSee) {
		this.toSee = toSee;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	

}
