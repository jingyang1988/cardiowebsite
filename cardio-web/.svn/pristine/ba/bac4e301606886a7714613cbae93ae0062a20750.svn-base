package lcec.model;

import java.util.ArrayList;
import java.io.Serializable;

public class SurBiopsyDataModel implements Serializable { // extends Patient {
	
	private Patient patient;
	private static final long serialVersionUID = 1L;
	
	public SurBiopsyDataModel(Patient patient) {
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

	//patient table
	private boolean aspirin;
	private boolean plavix;
	private boolean coumadin;
	private boolean otheranticoag;
	private String medicationlist;

	public boolean isAspirin() {
		return aspirin;
	}
	public void setAspirin(boolean aspirin) {
		this.aspirin = aspirin;
	}
	public boolean isPlavix() {
		return plavix;
	}
	public void setPlavix(boolean plavix) {
		this.plavix = plavix;
	}
	public boolean isCoumadin() {
		return coumadin;
	}
	public void setCoumadin(boolean coumadin) {
		this.coumadin = coumadin;
	}
	public boolean isOtheranticoag() {
		return otheranticoag;
	}
	public void setOtheranticoag(boolean otheranticoag) {
		this.otheranticoag = otheranticoag;
	}
	public String getMedicationlist() {
		return medicationlist;
	}
	public void setMedicationlist(String medicationlist) {
		this.medicationlist = medicationlist;
	}	
	
	// list of biposy or surgeries performed
	private ArrayList<Biopsy> biopsyList;

	public ArrayList<Biopsy> getBiopsyList() {
		return biopsyList;
	}
	public void setBiopsyList(ArrayList<Biopsy> biopsyList) {
		this.biopsyList = biopsyList;
	}
	
	private ArrayList<PatientLesion> lesionList;

	public ArrayList<PatientLesion> getLesionList() {
		return lesionList;
	}
	public void setLesionList(ArrayList<PatientLesion> lesionList) {
		this.lesionList = lesionList;
	}

}
