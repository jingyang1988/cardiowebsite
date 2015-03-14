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
import lcec.model.CancerInfoModel;
import lcec.model.Users;

@ManagedBean(name="cancerInfoBean")
@ViewScoped
public class CancerInfoBean {

	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;
	private static Logger logger = LogManager.getLogger(CancerInfoBean.class
		.getName());
	public Patient getPatient(){
		return this.patient;
	}	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}	
	
	CancerInfoModel cancerInfoData;
	private Users cur_user;

	public CancerInfoModel getCancerInfoData() {
		if(cancerInfoData == null)
			cancerInfoData = new CancerInfoModel();
		return cancerInfoData;
	}	
	
	public void setCancerInfoData(CancerInfoModel cancerInfoData) {
		this.cancerInfoData = cancerInfoData;
	} 
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			if(patient!=null){
				this.cancerInfoData = adapter.getCancerData(this.patient);
				logger.debug ("init: CancerInfo initiatied for patient-" + this.patient.getMrn ()+" "+this.patient.getName ( ));
			}else
				logger.debug("init: Patient is null!");
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}	
	public void saveCancerInfoData(){
		if(!canModify()){ 
			logger.debug ("saveCancerInfoData: Not Allowded");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
			
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			if(adapter.findCancerModelByMRN(patient.getMrn()) == null)
				adapter.saveCancerData(cancerInfoData, true, patient.getMrn());
			else
				adapter.saveCancerData(cancerInfoData, false, cancerInfoData.getMrn());
			this.cancerInfoData = adapter.getCancerData(this.patient);
			logger.debug ("saveCancerInfoData: "+this.cancerInfoData.getMrn());
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
