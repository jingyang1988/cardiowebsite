package lcec.model;

import java.io.Serializable;
import java.util.Date;


public class QueryVisits implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Visit visit;
	Patient patient;
	
	
	public QueryVisits(){
		this.patient = new Patient();
		this.visit = new Visit();
	}
	
	public String getName() {
		return this.patient.getName();
	}

	public String getMrn() {
		return this.patient.getMrn();
	}
	
	public void setMrn(String mrn) {
		this.patient.setMrn(mrn);
	}
	
	public void setName(String name) {
		this.patient.setName(name);
	}
	
	public Date getActualVisitDate() {
		return this.visit.getActualVisitDate();
	}
	public void setActualVisitDate(Date actualVisitDate) {
		this.visit.setActualVisitDate(actualVisitDate);
	}
	
	public int getTypeOfVisit() {
		return this.visit.getTypeOfVisit();
	}
	public void setTypeOfVisit(int typeOfVisit) {
		this.visit.setTypeOfVisit(typeOfVisit);
	}
	
	public String getPrimaryMD() {
		return this.visit.getPrimaryMD();
	}
	public void setPrimaryMD(String primaryMD) {
		this.visit.setPrimaryMD(primaryMD);
	}
	
	public String getScheduledToSee2() {
		return this.visit.getScheduledToSee2();
	}
	public void setScheduledToSee2(String scheduledToSee2) {
		this.visit.setScheduledToSee2(scheduledToSee2);
	}
	
	public boolean getRefused() {
		return this.visit.getRefused();
	}
	public void setRefused(boolean refused) {
		this.visit.setRefused(refused);
	}
	
	public boolean getHandledByPhone() {
		return this.visit.getHandledByPhone();
	}
	public void setHandledByPhone(boolean handledByPhone) {
		this.visit.setHandledByPhone(handledByPhone);
	}
	
	public String getPlan() {
		return this.visit.getPlan();
	}
	public void setPlan(String plan) {
		this.visit.setPlan(plan);
	}
	public String getComment() {
		return this.visit.getComment();
	}
	public void setComment(String comment) {
		this.visit.setComment(comment);
	}
	
}
