package lcec.model;

import java.io.Serializable;
import java.util.Date;

public class Visit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Visit(){
		this.ID = -1;
	}
	
	// visit details
	
	private int ID;
	private Date RequiredDate;
	private Date ScheduledDate;
	private Date ActualVisitDate;
	private int TypeOfVisit;
	
	private String PrimaryMD;
	private String ScheduledToSee2;
	private String ScheduledToSee3;	
	private int TobaccoStatus;
	
	private boolean ReferralNeeded;
	private String Referral;
	private boolean HandledByPhone;
	private boolean Counselled;
	private boolean Refused;	
	private boolean editable;
	
	private String Plan;
	private String Comment;	
	
	// getters and setters
	
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		this.ID = id;
	}	
	public Date getRequiredDate() {
		return RequiredDate;
	}
	public void setRequiredDate(Date requiredDate) {
		this.RequiredDate = requiredDate;
	}
	public Date getScheduledDate() {
		return ScheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		this.ScheduledDate = scheduledDate;
	}
	public Date getActualVisitDate() {
		return ActualVisitDate;
	}
	public void setActualVisitDate(Date actualVisitDate) {
		this.ActualVisitDate = actualVisitDate;
	}
	public int getTypeOfVisit() {
		return TypeOfVisit;
	}
	public void setTypeOfVisit(int typeOfVisit) {
		this.TypeOfVisit = typeOfVisit;
	}
	public String getPrimaryMD() {
		return PrimaryMD;
	}
	public void setPrimaryMD(String primaryMD) {
		this.PrimaryMD = primaryMD;
	}
	public String getScheduledToSee2() {
		return ScheduledToSee2;
	}
	public void setScheduledToSee2(String scheduledToSee2) {
		this.ScheduledToSee2 = scheduledToSee2;
	}
	public String getScheduledToSee3() {
		return ScheduledToSee3;
	}
	public void setScheduledToSee3(String scheduledToSee3) {
		this.ScheduledToSee3 = scheduledToSee3;
	}
	public int getTobaccoStatus() {
		return TobaccoStatus;
	}
	public void setTobaccoStatus(int tobaccoStatus) {
		this.TobaccoStatus = tobaccoStatus;
	}
	public boolean getReferralNeeded() {
		return ReferralNeeded;
	}
	public void setReferralNeeded(boolean referralNeeded) {
		this.ReferralNeeded = referralNeeded;
	}
	public String getReferral() {
		return Referral;
	}
	public void setReferral(String referral) {
		this.Referral = referral;
	}
	public boolean getHandledByPhone() {
		return HandledByPhone;
	}
	public void setHandledByPhone(boolean handledByPhone) {
		this.HandledByPhone = handledByPhone;
	}
	public boolean getCounselled() {
		return Counselled;
	}
	public void setCounselled(boolean counselled) {
		this.Counselled = counselled;
	}
	public boolean getRefused() {
		return Refused;
	}
	public void setRefused(boolean refused) {
		this.Refused = refused;
	}
	public boolean getEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String getPlan() {
		return Plan;
	}
	public void setPlan(String plan) {
		this.Plan = plan;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		this.Comment = comment;
	}
}
