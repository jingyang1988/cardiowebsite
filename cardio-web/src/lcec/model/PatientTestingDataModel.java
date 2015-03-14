package lcec.model;
import java.io.Serializable;
import java.util.ArrayList;

public class PatientTestingDataModel implements Serializable{// extends Patient {
	
	private Patient patient;
	private static final long serialVersionUID = 1L;
	
	public PatientTestingDataModel(Patient patient) {
		this.patient = patient;
	}

	public PatientTestingDataModel() {
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

	// Test List	
	public ArrayList<PatientTesting> patientTestingList;

	public ArrayList<PatientTesting> getTestList() {
		return patientTestingList;
	}
	public void setTestList(ArrayList<PatientTesting> patientTestingList) {
		this.patientTestingList = patientTestingList;
	}
	
	// LesionList
	private ArrayList<PatientLesion> lesionList;

	public ArrayList<PatientLesion> getLesionList() {
		return lesionList;
	}
	public void setLesionList(ArrayList<PatientLesion> lesionList) {
		this.lesionList = lesionList;
	}
}
