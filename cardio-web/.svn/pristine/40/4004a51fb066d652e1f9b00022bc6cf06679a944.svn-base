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
import lcec.model.Lesion;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.LesionModel;
import lcec.model.Patient;
import lcec.model.Users;

@ManagedBean(name = "lesionBean")
@ViewScoped
public class LesionBean {
	private static Logger logger = LogManager.getLogger(LesionBean.class
		.getName());
	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;
	Lesion lesion;
	LesionModel lesionData;
	private Users cur_user;

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LesionModel getLesionData() {
		return lesionData;
	}

	public void setLesionData(LesionModel lesionData) {
		this.lesionData = lesionData;
	}

	public Lesion getLesion() {
		if (lesion == null)
			lesion = new Lesion();
		return lesion;
	}

	public void setLesion(Lesion lesion) {
		this.lesion = lesion;
	}

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			if (patient != null)
				this.lesionData = adapter.getLesionData(patient);
			logger.debug ("Lesion Bean initiated for patient: "+patient.getMrn ( )+patient.getName ( ));
		} catch (Exception ex) {
			logger.error (ex, ex);
		}
	}

	public void addLesion() {
		if(!canModify()){ 
			logger.debug("add Lesion is not allowded!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
		return;
		}
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			adapter.addLesion(patient.getMrn(), lesion);
			this.lesionData.setLesionList(adapter.getlesionList(patient
					.getMrn()));
			logger.debug ("Lesion is added for patient: "+patient.getMrn ( )+patient.getName ( ));
			
		} catch (Exception ex) {
			logger.error (ex, ex);
		}
	}

	public String deleteLesion(Lesion lesion) {
		if(!canModify()){ 
			logger.debug("Delete Lesion is not allowded!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
		return "Lesion.xhtml";
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.deleteLesion(lesion.getAutoNum());
			logger.debug ("Lesion is deleted : "+ lesion.getAutoNum ( ));
			
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		return "Lesion.xhtml";
	}
	
	public void saveLesionData() {
		if(!canModify()){ 
			logger.debug("Save Lesion is not allowded!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
		return;
		}
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			adapter.saveLesionData(this.lesionData);
			this.lesionData = adapter.getLesionData(patient);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
			logger.debug ("Lesion is saved for patient: "+patient.getMrn ( )+patient.getName ( ));
		} catch (Exception ex) {
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
