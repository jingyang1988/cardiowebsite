package lcec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.Patient;
import lcec.model.PatientDataModel;
import lcec.model.Users;
import lcec.model.Visit;

@ManagedBean(name="patientDataBean")
@ViewScoped
public class PatientDataBean implements Serializable{	
	private static Logger logger = LogManager.getLogger(PatientDataBean.class
		.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;
	
	PatientDataModel patientData;
	private Users cur_user;
	
	
	public boolean patientCreated;

	public Users getCur_user() {
		return cur_user;
	}

	public void setCur_user(Users cur_user) {
		this.cur_user = cur_user;
	}

	public Patient getPatient(){
		if(patient == null)
			patient = new Patient();
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public PatientDataModel getPatientData() {
		if(patientData == null)
			patientData = new PatientDataModel();
		return patientData;
	}
	
	public void setPatientData(PatientDataModel patientData) {
		this.patientData = patientData;
	}

	@PostConstruct
	public void init() {
		patientCreated = false;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			if(patient!=null){
				this.patientData = adapter.getPatientData(this.patient);
				this.patientData.setOldMrn(this.patient.getMrn());
			logger.debug ("init: "+this.patient.getMrn ( ));
			}
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void savePatientData(){
		if(!canModify()){ 
			logger.debug ("SavePatientData: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				if(this.patientData.getOldMrn() != this.patientData.getMrn() ) {
					
					adapter.savePatientDataNewMrn(patientData);
					this.patientData = adapter.getPatientData(this.patient);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
				}
				else {
				adapter.savePatientData(patientData);
				this.patientData = adapter.getPatientData(this.patient);
				logger.debug ("SavePatientData: "+this.patient.getMrn ( ));
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
				}
			}catch(Exception ex){
				logger.error (ex, ex);
			}
		}
		
	
	boolean canModify() {
		if(cur_user.getRole().equals("Readonly User")){
			return false;
		}
		return true;
	}
	public void createPatient(){
		if(!canModify()){ 
			logger.debug ("cratePatient: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			//return "NewPatient.xhtml";
		}
		else if (!checkDuplicateMrn()) { 
			this.setPatientCreated(false);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Patient Creation Failed", "Duplicate MRN"));
			//return "NewPatient.xhtml";
			logger.debug ("cratePatient: Failed! Duplicated MRN");
		}
		else {
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				System.out.println("Patient mrn in create patient " + patientData.getPatient().getMrn());
			adapter.createPatient(patientData);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Patient Creation Status", "Created Successfully !!"));
			//this.patientData = adapter.getPatientData(this.patient);
			this.setPatientCreated(true);
			logger.debug ("cratePatient: Successfull!-"+ this.patientData.getPatient().getMrn());
			
			}
			catch(Exception ex){
				logger.error (ex, ex);
			}
		}
		//return null;
	}
	//returns false if mrn already exists
	public boolean checkDuplicateMrn() {
		ArrayList<String> mrnList = new ArrayList<String> (); 
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			mrnList = adapter.getMrnList();
			if(mrnList.contains(this.patientData.getMrn())) {
			
			return false;
			}
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		return true;
	}
	
	public String reset(){
		this.setPatientData(null);
		this.setPatient(null);
		return "NewPatient.xhtml";
	}
	
	/*Changes by Abhinav*/
	public String autoMRN() {
		
		
		String mrn = null;
		
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			logger.debug ("automrn");
			mrn = Integer.toString(adapter.autoMRN());
			System.out.println("MRN as string:"+ mrn);
			
		} catch (Exception ex) {
			logger.error (ex, ex);
		}
	return mrn;


	}
	
public void generatemrn(){
		
		String mrn = null;
		
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			logger.debug ("automrn");
			mrn = Integer.toString(adapter.autoMRN());
		} catch (Exception ex) {
			logger.error (ex, ex);
		}
		
		patientData.getPatient().setMrn(mrn);
		
	}
	
	//Added by sun
	public String deletePatient(){
		if(!canModify()){ 
			logger.debug ("deletePatient: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return "mainMenu.xhtml";
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.deletePatient(patient);
			reset();
			logger.debug ("deltePatient: successfull!-"+this.patient.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		return "mainMenu.xhtml";
	}

	public boolean isPatientCreated() {
		return patientCreated;
	}

	public void setPatientCreated(boolean patientCreated) {
		this.patientCreated = patientCreated;
	}
	
	
}
