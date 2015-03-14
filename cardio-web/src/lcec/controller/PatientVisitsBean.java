package lcec.controller;

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
import lcec.model.PatientVisitsModel;
import lcec.model.Users;
import lcec.model.Visit;

@ManagedBean(name="visitBean")
@ViewScoped
public class PatientVisitsBean {
	private static Logger logger = LogManager.getLogger(PatientVisitsBean.class
		.getName());
	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;
	Visit visit;
	
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
			logger.debug ("init: "+this.visitData.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void addVisit() {
		if(!canModify()){ 
			logger.debug ("addVisit: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.addVisit(patient.getMrn(), visit);
			this.visitData.setVisitList(adapter.getVisitList(patient.getMrn()));
			logger.debug ("addVisit: "+this.visitData.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}		
	}
	
	public String deleteVisit(Visit visit) {
		if(!canModify()){ 
			logger.debug ("deleteVisit: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return "PatientVisits.xhtml";
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.deleteVisit(visit.getID());
			logger.debug ("deleteVisit: "+visit.getID ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		return "PatientVisits.xhtml";
	}
	
	public void saveVisitData(){
		if(!canModify()){ 
			logger.debug ("saveVisitData: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.saveVisitData(this.visitData);
			this.visitData = adapter.getVisitData(patient);
			logger.debug ("saveVisitData: "+ this.visitData.getMrn ( ));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
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
