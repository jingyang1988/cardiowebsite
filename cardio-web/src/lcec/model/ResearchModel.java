package lcec.model;

import java.io.Serializable;
import java.util.ArrayList;


public class ResearchModel implements Serializable{//extends Patient 

private static final long serialVersionUID = 1L;
	
	private Patient patient;
	public ResearchModel(Patient patient) {
		this.patient = patient;
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

	// Research List	
	private ArrayList<Research> researchList;

	public ArrayList<Research> getResearchList() {
		return researchList;
	}
	public void setResearchList(ArrayList<Research> researchList) {
		this.researchList = researchList;
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
