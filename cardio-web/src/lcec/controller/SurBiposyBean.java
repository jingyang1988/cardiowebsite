package lcec.controller;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.context.RequestContext;
import com.sun.faces.facelets.tag.jsf.core.ViewHandler;
import lcec.model.Biopsy;
import lcec.model.Bronch;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.Patient;
import lcec.model.PatientMedication;
import lcec.model.SurBiopsyDataModel;
import lcec.model.Users;

@ManagedBean(name="surBiposyDataBean")
@SessionScoped
public class SurBiposyBean implements java.io.Serializable{
		
	private static Logger logger = LogManager.getLogger(SurBiposyBean.class
		.getName());

	public MainMenuBean getMainMenuBean() {
		return mainMenuBean;
	}

	public void setMainMenuBean(MainMenuBean mainMenuBean) {
		this.mainMenuBean = mainMenuBean;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;
	
	@ManagedProperty(value = "#{mainMenuBean}")
	MainMenuBean mainMenuBean;
	Biopsy  biopsy;
	Biopsy  bronchBiopsy;
	ArrayList<Bronch> bronchList = new ArrayList<Bronch>();
	Bronch newBronch = new Bronch();
	
	public Bronch getNewBronch() {
		return newBronch;
	}

	public void setNewBronch(Bronch newBronch) {
		this.newBronch = newBronch;
	}

	public Biopsy getBronchBiopsy() {
		return bronchBiopsy;
	}

	public void setBronchBiopsy(Biopsy bronchBiopsy) {
		this.bronchBiopsy = bronchBiopsy;
	}

	
	
	public ArrayList<Bronch> getBronchList() {
		return bronchList;
	}

	public void setBronchList(int autoNum) {
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			this.bronchList = adapter.getBronchList(autoNum);
			logger.debug ("setBronchList:" + autoNum);
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}

	public Patient getPatient(){
		return this.patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	SurBiopsyDataModel surBiopsyData;
	private Users cur_user;
	
	public SurBiopsyDataModel getSurBiopsyData() {
		return surBiopsyData;
	}
	
	public void setSurBiopsyData(SurBiopsyDataModel surBiopsyData) {
		this.surBiopsyData = surBiopsyData;
	}

	public Biopsy getBiopsy() {
		if(biopsy == null)
			biopsy = new Biopsy();
		return biopsy;
	}

	public void setBiopsy(Biopsy biopsy) {
		this.biopsy = biopsy;
	}

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
		
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			if(patient!=null)
				this.surBiopsyData = adapter.getSurBiopsyData(patient);
			logger.debug ("init:" + patient.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	

	
	
	
	
	public String addSurBiopsy(){
		if(!canModify()){ 
			logger.debug ("addSurBiopsy: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.addSurBiopsy(patient.getMrn(), biopsy);
			this.surBiopsyData = adapter.getSurBiopsyData(patient);
			logger.debug ("addSurBiopsy: "+patient.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		
		return "surBiopsyData.xhtml";
	}
	
	
	
	public void saveSurBiopsyData(){
		if(!canModify()){ 
			logger.debug ("saveSurBiopsyData: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("saveSurBiopsyData: "+patient.getMrn ( ));
			adapter.saveSurBiopsyData(this.surBiopsyData);
			this.surBiopsyData = adapter.getSurBiopsyData(patient);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	
	// Added by sun
	public String deleteSurBiopsyData(Biopsy b){
		if(!canModify()){ 
			logger.debug ("deleteSurBiopsyData: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return "surBiopsyData.xhtml";
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("saveSurBiopsyData: "+b.getAutoNum ( ));
			adapter.deleteBiopsyData(b);
			this.surBiopsyData = adapter.getSurBiopsyData(patient);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error (ex, ex);
		}
		return "surBiopsyData.xhtml";
	} // ---
	
	public String ifBronch(Biopsy bronchBiopsy){
		this.bronchBiopsy = bronchBiopsy;
		setBronchList(bronchBiopsy.getAutoNum());
		if(bronchBiopsy.getProcedureTypeId()!=2400 && bronchBiopsy.getProcedureTypeId() != 2500 && bronchBiopsy.getProcedureTypeId() != 600 )
			return "surBiopsyData.xhtml";
		return "bronch.xhtml";
	}
	
	public void addBronch(){
		if(!canModify()){ 
			logger.debug ("addBronch: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.addNewBronch(this.newBronch,this.bronchBiopsy.getAutoNum());
			setBronchList(this.bronchBiopsy.getAutoNum());
			logger.debug ("addBronch: "+this.bronchBiopsy.getAutoNum ( ));
			
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public String handleBack() {
		
		if(mainMenuBean.isFromQuery()) {
			return "queryProcedure.xhtml";
		}
		else
			return "mainMenu.xhtml";
		
	
		
	}
	
	public String deleteBronch(Bronch b) {
		if(!canModify()){ 
			logger.debug ("deleteBronch: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()) {
			logger.debug ("deleteBronch: "+b.getBiopsyAutoNum ( ));
			adapter.deleteBronchData(b, b.getBronchAutoNum());
		}catch (Exception e) {
			logger.error (e, e);
			e.printStackTrace();
		}
		bronchList.remove(b);
		return null;
	}
	
	//added by sun
	public String saveBronchData(){
		if(!canModify()){ 
			logger.debug ("saveBronchData: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("saveBronchData: Changes are saved!");
			adapter.saveBronch(bronchList, bronchBiopsy.getAutoNum());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
		}catch(Exception e){
			e.printStackTrace();
			logger.error (e, e);
		}
		return "bronch.xhtml";
	} // ---
	
	boolean canModify() {
		if(cur_user.getRole().equals("Readonly User")){
			return false;
		}
		return true;
	}
}
