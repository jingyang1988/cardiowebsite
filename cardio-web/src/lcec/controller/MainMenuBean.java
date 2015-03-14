package lcec.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.Patient;
import lcec.model.Users;
/*
 * @author Utpal
 *
 */
@ManagedBean(name="mainMenuBean")
@SessionScoped
public class MainMenuBean implements Serializable{
	
	private Users cur_user;
	private static Logger logger = LogManager.getLogger(MainMenuBean.class
		.getName());
	public MainMenuBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
	}
	public boolean isFromQuery() {
		return fromQuery;
	}

	public void setFromQuery(boolean fromQuery) {
		this.fromQuery = fromQuery;
	}

	private Patient selectedPatient;// = new Patient();
	private boolean fromQuery;

	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public List<Patient> searchPatientByName(String name){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("searchPatientByName:" + name+" User ID: "+cur_user.getUserId ( ));
			FacesContext context = FacesContext.getCurrentInstance(); 
			context.getExternalContext().getSessionMap().remove("surBiposyDataBean");
			return adapter.searchPatient(name, false);
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		return null;
	}
	
	public List<Patient> searchPatientByMRN(String mrn){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("searchPatientByMRN:" + mrn);
			FacesContext context = FacesContext.getCurrentInstance(); 
			context.getExternalContext().getSessionMap().remove("surBiposyDataBean");
			return adapter.searchPatient(mrn, true);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error (ex, ex);
		}
		return null;
	}
	
	
	public void setSearchedPatient(String name){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("setSearchedPatient:" + name+" User ID: "+cur_user.getUserId ( ));
			selectedPatient= adapter.searchPatient(name, false).get(0);
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		
	}
	
	public void updateSeachedPatient(){
		if(!canModify()){ 
			logger.debug ("updateSeachedPatient: Not allowed!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
		return;
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("updateSeachedPatient: Excuted Successfully- "+this.selectedPatient.getMrn ( )+" "+this.selectedPatient.getName ( )+" User ID: "+cur_user.getUserId ( ));
			adapter.savePatient(this.selectedPatient);
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	// added by Sun
	public String deletePatient(){
		if(!canModify()){ 
			logger.debug ("deletePatient: Not allowed!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"+" User ID: "+cur_user.getUserId ( )));
		return "mainMenu.xhtml";
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("deletePatient: Excuted Successfully- "+this.selectedPatient.getMrn ( )+" "+this.selectedPatient.getName ( )+" User ID: "+cur_user.getUserId ( ));
			adapter.deletePatient(selectedPatient);
			this.selectedPatient = null;
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		return "mainMenu.xhtml";
	}
	
	public String CancerInfo(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: CancerInfo.xhtml");
		return "CancerInfo.xhtml";
	}
	public String ScheduleTest(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: scheduleTest.xhtml");
		return "scheduleTest.xhtml";
	} 
	public String Medications() {
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: PatientMedications.xhtml");
		return "PatientMedications.xhtml";
	}
	public String PatientData(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: patientData.xhtml");
		return "patientData.xhtml";
	}
	
	public String createNewPatient(){
		selectedPatient = null;
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: NewPatient.xhtml");
		return "NewPatient.xhtml";
	}
	 
	public String Visit(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: PatientVisits.xhtml");
		return "PatientVisits.xhtml";
	}
	
	public String surBiopsy(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: surBiopsyData.xhtml");
		return "surBiopsyData.xhtml";
	}
	public String surBiopsyFromQuery(){
		this.setFromQuery(true);
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: surBiopsyData.xhtml");
		return "surBiopsyData.xhtml";
	}
	

	public String lesion(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: Lesion.xhtml");

		return "Lesion.xhtml";
	}
	public String MedicalHistory(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: medicalHistory.xhtml");

		return "medicalHistory.xhtml";
	}

	public String TestSubmit(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: testResult.xhtml");

		return "testResult.xhtml";
	}
	public String AutoSchedule(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: AutoScheduler.xhtml");

		return "AutoScheduler.xhtml";
	}
	
	public String research(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: Research.xhtml");

		return "Research.xhtml";
	}
	
	public String Print(){
		if(selectedPatient == null)
			return "mainMenu.xhtml";
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: PrintPatientSummary.xhtml");

		return "PrintPatientSummary.xhtml";
	}
	
	public String Reports(){
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: Reports.xhtml");

			return "Reports.xhtml";
	}
	
	public String modifyDatabase() {
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: ModifyDatabase.xhtml");

			return "ModifyDatabase.xhtml";
	}
	
	boolean canModify() {
		if(cur_user.getRole().equals("Readonly User")){
			return false;
		}
		return true;
	}
	
	public String clearPatient() {
		if(selectedPatient != null) {
			selectedPatient = null;
			this.searchPatientByName("");
			this.searchPatientByMRN("");
		}
		return "mainMenu.xhtml";
	}
}
