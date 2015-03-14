package lcec.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class LesionModel implements Serializable { // extends Patient {
	
	private Patient patient;
	private static final long serialVersionUID = 1L;
	
	public LesionModel(Patient patient)
	{
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

	
	private Date DateofReferral;
	
	private float packYears;
	private String asbestosExposure;
	private int yearquit;
	private String silicaExposure;
	private boolean personalLungCancer;
	private boolean fatherMotherLungCancer;
	private boolean otherFamilyLungCancer;
	private boolean personalOtherCancer;
	private boolean fatherMotherOtherCancer;
	private boolean otherFamilyOtherCancer;
	
	private float fev;
	private float fvc;
	private float fev_fvc;
	
	
	public Date getDateofReferral() {
		return DateofReferral;
	}
	public void setDateofReferral(Date dateofReferral) {
		DateofReferral = dateofReferral;
	}
	public float getPackYears() {
		return packYears;
	}
	public void setPackYears(float packYears) {
		this.packYears = packYears;
	}
	public String getAsbestosExposure() {
		return asbestosExposure;
	}
	public void setAsbestosExposure(String asbestosExposure) {
		this.asbestosExposure = asbestosExposure;
	}
	public int getYearquit() {
		return yearquit;
	}
	public void setYearquit(int yearquit) {
		this.yearquit = yearquit;
	}
	public String getSilicaExposure() {
		return silicaExposure;
	}
	public void setSilicaExposure(String silicaExposure) {
		this.silicaExposure = silicaExposure;
	}
	public boolean isPersonalLungCancer() {
		return personalLungCancer;
	}
	public void setPersonalLungCancer(boolean personalLungCancer) {
		this.personalLungCancer = personalLungCancer;
	}
	public boolean isFatherMotherLungCancer() {
		return fatherMotherLungCancer;
	}
	public void setFatherMotherLungCancer(boolean fatherMotherLungCancer) {
		this.fatherMotherLungCancer = fatherMotherLungCancer;
	}
	public boolean isOtherFamilyLungCancer() {
		return otherFamilyLungCancer;
	}
	public void setOtherFamilyLungCancer(boolean otherFamilyLungCancer) {
		this.otherFamilyLungCancer = otherFamilyLungCancer;
	}
	public boolean isPersonalOtherCancer() {
		return personalOtherCancer;
	}
	public void setPersonalOtherCancer(boolean personalOtherCancer) {
		this.personalOtherCancer = personalOtherCancer;
	}
	public boolean isFatherMotherOtherCancer() {
		return fatherMotherOtherCancer;
	}
	public void setFatherMotherOtherCancer(boolean fatherMotherOtherCancer) {
		this.fatherMotherOtherCancer = fatherMotherOtherCancer;
	}
	public boolean isOtherFamilyOtherCancer() {
		return otherFamilyOtherCancer;
	}
	public void setOtherFamilyOtherCancer(boolean otherFamilyOtherCancer) {
		this.otherFamilyOtherCancer = otherFamilyOtherCancer;
	}
	public float getFev() {
		return fev;
	}
	public void setFev(float fev) {
		this.fev = fev;
	}
	public float getFvc() {
		return fvc;
	}
	public void setFvc(float fvc) {
		this.fvc = fvc;
	}
	public float getFev_fvc() {
		return fev_fvc;
	}
	public void setFev_fvc(float fev_fvc) {
		this.fev_fvc = fev_fvc;
	}
	

	private ArrayList<Lesion> lesionList;

	public ArrayList<Lesion> getLesionList() {
		return lesionList;
	}
	public void setLesionList(ArrayList<Lesion> lesionList) {
		this.lesionList = lesionList;
	}
}
