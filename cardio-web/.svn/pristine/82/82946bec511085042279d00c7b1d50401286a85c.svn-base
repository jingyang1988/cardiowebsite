package lcec.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import lcec.model.PatientDataModel;
import lcec.model.RegistryInfo;
import lcec.model.Research;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.ResearchModel;
import lcec.model.Patient;
import lcec.model.Users;

@ManagedBean(name = "researchBean")
@SessionScoped
public class ResearchBean {

	public PatientDataModel getPatientData() {
		return patientData;
	}

	public void setPatientData(PatientDataModel patientData) {
		this.patientData = patientData;
	}
	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;
	PatientDataModel patientData;
	Research research;
	RegistryInfo registryInfo = null;
	Logger logger;
    public	ResearchBean() {
		logger = LogManager.getLogger(ResearchBean.class
				.getName());
	}
	public  Logger getLogger() {
		return logger;
	}

	public  void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	public RegistryInfo getRegistryInfo() {
		return registryInfo;
	}

	public void setRegistryInfo(RegistryInfo registryInfo) {
		this.registryInfo = registryInfo;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	ResearchModel researchData;
	private Users cur_user;

	public ResearchModel getResearchData() {
		return researchData;
	}

	public void setresearchData(ResearchModel researchData) {
		this.researchData = researchData;
	}

	public Research getResearch() {
		if (research == null)
			research = new Research();
		return research;
	}

	public void setResearch(Research research) {
		this.research = research;
	}

@PostConstruct
	public void init() {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
	cur_user = (Users) httpSession.getAttribute("cur_user");
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			if (patient != null) {
				this.researchData = adapter.getResearchData(this.patient);
				this.patientData = adapter.getPatientData(this.patient);
				this.registryInfo = adapter.getRegistryInfo(this.patient);
				if(this.registryInfo.getRegistryNum() == -1) {
				registryInfo.setMrn(this.patient.getMrn());
				registryInfo.setDob(this.patientData.getDob());
				registryInfo.setGender(this.patientData.getGender());
				registryInfo.setAge(calculateAgeFromDob(this.patientData.getDob().toString()));
				}
			}
			logger.debug("init : mrn =  " + this.registryInfo.getMrn());
			
		} catch (Exception ex) {
			logger.error (ex, ex);
		}
		
	}

public String init(Patient patient) {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
	cur_user = (Users) httpSession.getAttribute("cur_user");
	if(patient.getMrn() != this.patient.getMrn()) {
	try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			this.patient = patient;
			this.researchData = adapter.getResearchData(patient);
			this.patientData = adapter.getPatientData(patient);
			this.registryInfo = adapter.getRegistryInfo(patient);
			if(this.registryInfo.getRegistryNum() == -1) {
				registryInfo.setMrn(this.patient.getMrn());
				registryInfo.setDob(this.patientData.getDob());
				registryInfo.setGender(this.patientData.getGender());
				registryInfo.setAge(calculateAgeFromDob(this.patientData.getDob().toString()));
				}
			logger.debug("init : mrn =  " + registryInfo.getMrn());
			
			
			
		
		
		
	} catch (Exception ex) {
		ex.printStackTrace();
		logger.error (ex, ex);
	}
	return "Research.xhtml?faces-redirect=true";
	}
return null;
	
}


	public void addResearch() {
		if(!canModify()){ 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			if (this.researchData.getResearchList().size() == 0)
				research.setID(-1);
			adapter.addResearch(patient.getMrn(), research);
			this.researchData.setResearchList(adapter.getResearchList(patient
					.getMrn()));
		} catch (Exception ex) {
			logger.error (ex, ex);
		}
	}

	public void saveResearchData() {
		if(!canModify()){ 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			adapter.saveResearchData(this.researchData);
			this.researchData = adapter.getResearchData(patient);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
		} catch (Exception ex) {
			logger.error (ex, ex);
		}
	}

	
	// Added by Sun
	public String deleteRegistry(Research r){
		if(!canModify()){ 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return "Research.xhtml";
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.deleteResearch(r, patient);
			saveResearchData();
			//<Nikhil>Reset data so that user does not view stale information when adding registry info 
			//just after deletion
			this.registryInfo = adapter.getRegistryInfo(this.patient);
			this.registryInfo.setMrn(this.patient.getMrn());
			this.registryInfo.setDob(this.patientData.getDob());
			this.registryInfo.setGender(this.patientData.getGender());
			this.registryInfo.setAge(calculateAgeFromDob(this.patientData.getDob().toString()));
		} catch (Exception ex){
			logger.error (ex, ex);
		}
		return "Research.xhtml";
	}

//Added by utpal,
	public void saveRegistryInfo() {
		if(!canModify()){ 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			logger.debug("saveRegistryInfo() : Registry Num : " + this.registryInfo.getRegistryNum() + this.registryInfo.getMrn());
			adapter.saveRegistryInfo(this.registryInfo);
			//<Nikhil> If registry information is saved for the first time then update the bean info
			if (registryInfo.getRegistryNum() == -1)
				this.registryInfo = adapter.getRegistryInfo(this.patient);	
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	
	
	public String handleRegistry(Research research) {
		
			/*try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				 this.registryInfo = adapter.getRegistryInfo(this.patient);
				if (this.registryInfo.registryNum == -1) {
					
					registryInfo.setMrn(this.patient.getMrn());
					registryInfo.setDob(this.patientData.getDob());
					registryInfo.setGender(this.patientData.getGender());
					registryInfo.setAge(calculateAgeFromDob(this.patientData.getDob().toString()));
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}*/
			this.research = research;
			
			
			logger.debug("handleREgistry: RegistryNum = " + registryInfo.getRegistryNum() +  "   " + registryInfo.getMrn());
			return "RegistryInfo.xhtml";
	
	}
	
	int calculateAgeFromDob(String dob) {
		

		int yearDOB = Integer.parseInt(dob.substring(0, 4));
		int monthDOB = Integer.parseInt(dob.substring(5, 7));
		int dayDOB = Integer.parseInt(dob.substring(8, 10));

		// CALCULATE THE CURRENT YEAR, MONTH AND DAY
		// INTO SEPERATE VARIABLES
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		java.util.Date date = new java.util.Date();
		int thisYear = Integer.parseInt(dateFormat.format(date));

		dateFormat = new SimpleDateFormat("MM");
		date = new java.util.Date();
		int thisMonth = Integer.parseInt(dateFormat.format(date));

		dateFormat = new SimpleDateFormat("dd");
		date = new java.util.Date();
		int thisDay = Integer.parseInt(dateFormat.format(date));

		// CREATE AN AGE VARIABLE TO HOLD THE CALCULATED AGE
		// TO START WILL 锟� SET THE AGE EQUEL TO THE CURRENT YEAR MINUS
		// THE YEAR
		// OF THE DOB
		int age = thisYear - yearDOB;
		// IF THE CURRENT MONTH IS LESS THAN THE DOB MONTH
		// THEN REDUCE THE DOB BY 1 AS THEY HAVE NOT HAD THEIR
		// BIRTHDAY YET THIS YEAR
		if (thisMonth < monthDOB) {
			age = age - 1;
		}

		// IF THE MONTH IN THE DOB IS EQUEL TO THE CURRENT MONTH
		// THEN CHECK THE DAY TO FIND OUT IF THEY HAVE HAD THEIR
		// BIRTHDAY YET. IF THE CURRENT DAY IS LESS THAN THE DAY OF THE
		// DOB
		// THEN REDUCE THE DOB BY 1 AS THEY HAVE NOT HAD THEIR
		// BIRTHDAY YET THIS YEAR
		if (thisMonth == monthDOB && thisDay < dayDOB) {
			age = age - 1;
		}
		return age;
		
	}
	boolean canModify() {
		if(cur_user.getRole().equals("Readonly User")){
			return false;
		}
		return true;
	}

}
