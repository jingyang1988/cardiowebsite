package lcec.model;

import java.util.*;
import java.io.*;

public class QueryPendingProcedures implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Patient patient;
//	private Biopsy biopsy;
	private int procedureType;
	private Date scheduleDate;
	private String performedBy;
	private Date patientBirthday;
	private String phoneNumber;
	
	public QueryPendingProcedures() {
		patient = new Patient();
	}
	
	public String getPatientMrn() {
		
		return patient.getMrn();
	}
	public void setPatientMrn(String mrn) {
		this.patient.setMrn(mrn);
	}
	
	public String getPatientName() {
		return patient.getName();
	}
	public void setPatientName(String name) {
		this.patient.setName(name);
	}
	
	public Date getPatientBirthday() {
		return patientBirthday;
	}
	public void setPatientBirthday(Date birthday) {
		this.patientBirthday = birthday;
	}
	public String getPatientPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPatientPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getProcedureType() {
		return this.procedureType;
	}
	public void setProcedureType(int procedureType) {
		this.procedureType = procedureType;
	}
	
	public String getPerformedBy() {
		return this.performedBy;
	}
	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}
	
	public Date getScheduleDate() {
		return this.scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
}
