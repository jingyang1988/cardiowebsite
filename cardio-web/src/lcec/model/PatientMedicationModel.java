/*
 * This will show the patient mrn name and status 
 * on the first several lines
 * 
 * */

package lcec.model;

import java.io.Serializable;
import java.util.*;

public class PatientMedicationModel implements Serializable {
	
	private Patient patient;
	
	private static final long serialVersionUID = 1L;
	//constructor get the patient selected
	public PatientMedicationModel(Patient patient) {
		this.patient = patient;
	}

	public String getPatientName() {
		return patient.getName();
	}
	
	public void setPatientName(String name) {
		this.patient.setName(name);
	}

	public String getPatientMrn() {
		return patient.getMrn();
	}
	
	public void setPatientMrn(String mrn) {
		this.patient.setMrn(mrn);
	}

	public String getPatientWorkUpStatus() {
		return patient.getWorkupStatus();
	}
	
	public void setPatientWorkUpStatus(String patientWorkUpStatus) {
		this.patient.setWorkupStatus(patientWorkUpStatus);
	}

	public String getPatientLcecStatus() {
		return patient.getLcecStatus();
	}
	
	public void setPatientLcecStatus(String patientLcecStatus) {
		this.patient.setLcecStatus(patientLcecStatus);
	}
	
	private ArrayList<PatientMedication> patientMedicationList;
	
	public ArrayList<PatientMedication> getPatientMedicationList() {
		return this.patientMedicationList;
	}
	
	public void setPatientMedicationList(ArrayList<PatientMedication> PatientMedicationList) {
		this.patientMedicationList = PatientMedicationList;
	}

}
