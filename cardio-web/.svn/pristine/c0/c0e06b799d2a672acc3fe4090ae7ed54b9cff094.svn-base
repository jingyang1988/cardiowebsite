package lcec.controller;

import javax.annotation.PostConstruct;
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
import lcec.model.PatientVisitsModel;
import lcec.model.Users;
import lcec.model.Visit;
import lcec.model.PatientDataModel;

@ManagedBean(name="newPatientBean")
@ViewScoped
public class NewPatientBean {
	private static Logger logger = LogManager.getLogger(NewPatientBean.class
		.getName());
	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;
	Visit visit;
	
	//Added by rjosan
	PatientDataModel patientDataModel;
	public PatientDataModel getPatientDataModel(){
		return this.patientDataModel;
	}
	
	public void setPatientDataModel(Patient patient) {
		this.patientDataModel = patientDataModel;
	}	
	
	
	
	public Patient getPatient(){
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	PatientVisitsModel visitData;
	private Users cur_user;
	
	public PatientVisitsModel getVisitData() {
		return visitData;
	}
	
	public void setVisitData(PatientVisitsModel visitData) {
		this.visitData = visitData;
	}	
	
	public Visit getVisit() {
		if(visit == null)
			visit = new Visit();
		return visit;
	}
	
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			this.visitData = adapter.getVisitData(patient);
			logger.debug ("init: "+patient.getMrn ( )+patient.getName ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void addVisit() {
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.addVisit(patient.getMrn(), visit);
			this.visitData.setVisitList(adapter.getVisitList(patient.getMrn()));
			logger.debug ("addVisit: "+patient.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}		
	}
	
	public void saveVisitData(){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.saveVisitData(this.visitData);
			this.visitData = adapter.getVisitData(patient);
			logger.debug ("saveVisitData: "+patient.getMrn ( ));
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
}
