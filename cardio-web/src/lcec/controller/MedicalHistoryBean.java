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
import lcec.model.Users;
import lcec.model.historyDataModel;

@ManagedBean(name="medicalHistoryBean")
@ViewScoped
public class MedicalHistoryBean  {
	private static Logger logger = LogManager.getLogger(MedicalHistoryBean.class
		.getName());
	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;


	public Patient getPatient(){
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	historyDataModel historyData;
	private Users cur_user;

	public historyDataModel getHistoryData() {
		return historyData;
	}

	public void setHistoryData(historyDataModel historyData) {
		this.historyData = historyData;
	}	



	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			this.historyData = adapter.getHistoryData(patient);
			logger.debug ("init: "+patient.getMrn ( )+patient.getName ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}

	public void saveHistoryData(){
		if(!canModify()){ 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			logger.debug ("saveHistoryData: you are not anllowed to");
			return;
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.saveHistoryData(historyData);
			this.historyData = adapter.getHistoryData(this.patient);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
			logger.debug ("saveHistoryData: change saved for patient: "+this.patient.getMrn ( )+ this.patient.getName ( ));
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
