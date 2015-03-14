package lcec.model;

import java.util.Date;

public class VisitReport implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mrn;
	private Date dateRequired;
	private Date dateActVisit;
	private String toSeenBy;
	private String seenBy2;
	private  boolean smokerStatus;
	private boolean phoneCall;
	public String getMrn() {
		return mrn;
	}
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	public Date getDateRequired() {
		return dateRequired;
	}
	public void setDateRequired(Date dateRequired) {
		this.dateRequired = dateRequired;
	}
	public String getToSeenBy() {
		return toSeenBy;
	}
	public void setToSeenBy(String toSeenBy) {
		this.toSeenBy = toSeenBy;
	}
	public String getSeenBy2() {
		return seenBy2;
	}
	public void setSeenBy2(String seenBy2) {
		this.seenBy2 = seenBy2;
	}
	public boolean isSmokerStatus() {
		return smokerStatus;
	}
	public void setSmokerStatus(boolean smokerStatus) {
		this.smokerStatus = smokerStatus;
	}
	public boolean isPhoneCall() {
		return phoneCall;
	}
	public void setPhoneCall(boolean phoneCall) {
		this.phoneCall = phoneCall;
	}
	public Date getDateActVisit() {
		return dateActVisit;
	}
	public void setDateActVisit(Date dateAcgtVisit) {
		this.dateActVisit = dateAcgtVisit;
	}
	

}
