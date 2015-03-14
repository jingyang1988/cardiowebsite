package lcec.controller;

import java.io.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.Patient;
import lcec.model.PatientMedicationModel;
import lcec.model.PatientMedication;
import lcec.model.Users;


@ManagedBean(name="medicationBean")
@ViewScoped
public class PatientMedicationBean implements Serializable{
	private static Logger logger = LogManager.getLogger(PatientMedicationBean.class
		.getName());
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;
	PatientMedication medication;
	PatientMedicationModel medicationData;

	private Users cur_user;
	
	public Patient getPatient(){
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public PatientMedicationModel getMedicationData() {
		return this.medicationData;
	}
	
	public void setMedicationData(PatientMedicationModel medicationData) {
		this.medicationData = medicationData;
	}	
	
	public PatientMedication getMedication() {
		if(medication == null)
			medication = new PatientMedication();
		return medication;
	}
	
	public void setMedication(PatientMedication medication) {
		this.medication = medication;
	}
	
	public void getMedicationId(PatientMedication m) {
		//System.out.println(m.getID());
	}
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("init: "+patient.getMrn ( ));
			this.medicationData = adapter.getMedicationData(patient);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error (ex, ex);
		}
	}
	
	public void addMedication() {
		if(!canModify()){ 
			logger.debug ("addMedication: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("addMedication: "+patient.getMrn ( ));
			adapter.addMedication(patient.getMrn(), medication);
			this.medicationData.setPatientMedicationList(adapter.getPatientMedicationList(patient.getMrn()));
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error (ex, ex);
		}		
	}
	
	public void saveMedicationData(){
		if(!canModify()){ 
			logger.debug ("saveMedicationData: You are not allowed");
			FacesContext.getCurrentInstance().addMessage("messages2", new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}	
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("saveMedicationData: "+patient.getMrn ( ));
			adapter.saveMedicationData(this.medicationData);
			this.medicationData = adapter.getMedicationData(patient);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error (ex, ex);
		}		
	
	}
	
	public String deleteMedicationData(PatientMedication m) {
		if(!canModify()){ 
			logger.debug ("deleteMedicationData: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return "PatientMedications.xhtml";
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			adapter.deleteMedicationData(m);
			logger.debug ("deleteMedicationData: "+m.getID ( ));
		}catch (Exception e) {
			e.printStackTrace();
			logger.error (e, e);
		}
		
		return "PatientMedications.xhtml";
	}
	boolean canModify() {
		if(cur_user.getRole().equals("Readonly User")){
			return false;
		}
		return true;
	}
}
