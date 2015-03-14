package lcec.model;

import java.io.Serializable;
import java.util.Date;

public class SurBiopsyReportEntry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Patient patient;
	Biopsy biopsy;
	
	public SurBiopsyReportEntry(){
		this.patient = new Patient();
		this.biopsy = new Biopsy();
	}
	
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
	
	public int getProcedureType() {
		return this.biopsy.getProcedureTypeId();
	}

	public void setProcedureType(int procedureType) {
		this.biopsy.setProcedureTypeId(procedureType);
	}

	public Date getScheduleDate() {
		return this.biopsy.getScheduleDate();
	}

	public void setScheduleDate(Date scheduleDate) {
		this.biopsy.setScheduleDate(scheduleDate);
	}

	public Date getProcedureDate() {
		return this.biopsy.getProcedureDate();
	}

	public void setProcedureDate(Date procedureDate) {
		this.biopsy.setProcedureDate(procedureDate);
	}
	
	public String getPerformedBy() {
		return this.biopsy.getPerformedBy();
	}

	public void setPerformedBy(String performedBy) {
		this.biopsy.setPerformedBy(performedBy);
	}

	public String getBiopsyLocation() {
		return this.biopsy.getBiopsyLocation();
	}

	public void setBiopsyLocation(String biopsyLocation) {
		this.biopsy.setBiopsyLocation(biopsyLocation);
	}

	public String getLocationComment() {
		return this.biopsy.getLocationComment();
	}

	public void setLocationComment(String locationComment) {
		this.biopsy.setLocationComment(locationComment);
	}
	
	
	public String getComplication() {
		return this.biopsy.getComplication();
	}

	public void setComplication(String complication) {
		this.biopsy.setComplication(complication);
	}

	public String getBiopsyResult() {
		return this.biopsy.getBiopsyResult();
	}

	public void setBiopsyResult(String biopsyResult) {
		this.biopsy.setBiopsyResult(biopsyResult);
	}

	public String getDiagnostic() {
		return this.biopsy.getDiagnostic();
	}

	public void setDiagnostic(String diagnostic) {
		this.biopsy.setDiagnostic(diagnostic);
	}

	public String getAccuracy() {
		return this.biopsy.getAccuracy();
	}

	public void setAccuracy(String accuracy) {
		this.biopsy.setAccuracy(accuracy);
	}

	public String getComment() {
		return this.biopsy.getComment();
	}

	public void setComment(String comment) {
		this.biopsy.setComment(comment);
	}
	
	public String getProcedureName() {
		return this.biopsy.getProcedureName() ;
	}

	public void setProcedureName(String procedureName) {
		this.biopsy.setProcedureName(procedureName);
	}

}
