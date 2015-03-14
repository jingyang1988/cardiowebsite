package lcec.controller;
import java.util.Date;
import java.util.Calendar;
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
import lcec.model.PatientDataModel;
import lcec.model.PatientTesting;
import lcec.model.PatientTestingDataModel;
import lcec.model.Users;

@ManagedBean(name="testBean")
@ViewScoped
public class PatientTestingBean  {
	private static Logger logger = LogManager.getLogger(PatientTestingBean.class
		.getName());
	public PatientDataModel getPatientData() {
		return patientData;
	}

	public void setPatientData(PatientDataModel patientData) {
		this.patientData = patientData;
	}

	@ManagedProperty("#{mainMenuBean.selectedPatient}")
	Patient patient;

	public void onTestTypePFT(PatientTesting pt) {
		pt.handleTypePFT();
	}

	PatientTesting test;

	public Patient getPatient(){
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	PatientTestingDataModel testData;

	public PatientTestingDataModel getTestData() {
		return testData;
	}

	public void setTestData(PatientTestingDataModel testData) {
		this.testData = testData;
	}	

	public PatientTesting getTest() {
		if(test == null) {
			//System.out.println("Creating new patient testing");
			test = new PatientTesting();
		}
		return test;
	}

	public void setTest(PatientTesting Test) {
		this.test = Test;
	}

	// Required start date variables
	
	Date startDate1, startDate2, startDate3, startDate4, startDate5, startDate6;
	Date startDate7, startDate8, startDate9, startDate10, startDate11, startDate12;



	public PatientDataModel patientData;



	private Users cur_user;
	
	public Date getStartDate1() {
		return startDate1;
	}
	
	public void setStartDate1(Date startDate1) {
		this.startDate1 = startDate1;
	}
	
	public Date getStartDate2() {
		return startDate2;
	}
	
	public void setStartDate2(Date startDate2) {
		this.startDate2 = startDate2;
	}

	public Date getStartDate3() {
		return startDate3;
	}

	public void setStartDate3(Date startDate3) {
		this.startDate3 = startDate3;
	}

	public Date getStartDate4() {
		return startDate4;
	}

	public void setStartDate4(Date startDate4) {
		this.startDate4 = startDate4;
	}

	public Date getStartDate5() {
		return startDate5;
	}

	public void setStartDate5(Date startDate5) {
		this.startDate5 = startDate5;
	}

	public Date getStartDate6() {
		return startDate6;
	}

	public void setStartDate6(Date startDate6) {
		this.startDate6 = startDate6;
	}

	public Date getStartDate7() {
		return startDate7;
	}

	public void setStartDate7(Date startDate7) {
		this.startDate7 = startDate7;
	}

	public Date getStartDate8() {
		return startDate8;
	}

	public void setStartDate8(Date startDate8) {
		this.startDate8 = startDate8;
	}

	public Date getStartDate9() {
		return startDate9;
	}

	public void setStartDate9(Date startDate9) {
		this.startDate9 = startDate9;
	}

	public Date getStartDate10() {
		return startDate10;
	}

	public void setStartDate10(Date startDate10) {
		this.startDate10 = startDate10;
	}

	public Date getStartDate11() {
		return startDate11;
	}

	public void setStartDate11(Date startDate11) {
		this.startDate11 = startDate11;
	}

	public Date getStartDate12() {
		return startDate12;
	}

	public void setStartDate12(Date startDate12) {
		this.startDate12 = startDate12;
	}

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			this.testData = adapter.getTestData(patient);
			this.patientData = adapter.getPatientData(this.patient);
			logger.debug ("init: "+this.patient.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		if(this.testData.getTestList()!=null) {
		for (PatientTesting pt : this.testData.getTestList())
			
			pt.handleTypePFT();
		}
	}

	public void addTest() {
		if(!canModify()){ 
			logger.debug ("addTest: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("addTest: "+this.patient.getMrn ( ));
			adapter.addTest(patient.getMrn(), test);
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}		
		for (PatientTesting pt : this.testData.getTestList())
			pt.handleTypePFT();
	}

	public String deleteTest(PatientTesting test) {
		if(!canModify()){ 
			logger.debug ("deleteTest: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return "scheduleTest.xhtml";
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			logger.debug ("deleteTest: "+test.getID());
			adapter.deleteTest(test.getID());
			//this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
		return "scheduleTest.xhtml";
	}
	
	
	public void saveTestData(){
		if(!canModify()){ 
			logger.debug ("saveTestData: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.saveTestData(this.testData);
			logger.debug ("saveTestData: "+this.testData.getMrn ( ));
			adapter.savePatientData(patientData);
			this.testData = adapter.getTestData(patient);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "JFYI", "Changes are Saved !!"));
			init();
		}catch(Exception ex){
			logger.error (ex, ex);
		}		
	}
	
	public void add_Nodule_less_4mm() {	
		if(!canModify()){ 
			logger.debug ("add_Nodule_less_4mm: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate1);
			test.setTestType(100);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("12mo CT, <= 4mm protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, <= 4mm protocol");
			adapter.addTest(patient.getMrn(), test);
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
			logger.debug ("add_Nodule_less_4mm: "+this.testData.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}	
	}
	
	public void add_Nodule_more_4_6mm() {	
		
		if(!canModify()){ 
			logger.debug ("add_Nodule_more_4_6mm: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate2);
			test.setTestType(100);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("6mo CT, >4-6 mm protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo CT, >4-6 mm protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, >4-6 mm protocol");
			adapter.addTest(patient.getMrn(), test);			
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
			logger.debug ("add_Nodule_more_4_6mm: "+this.testData.getMrn ( ));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_Nodule_more_6_8mm() {
		if(!canModify()){ 
			logger.debug("add_Nodule_more_6_8mm: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate3);
			test.setTestType(100);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("3mo CT, >6-8 mm protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("9mo CT, >6-8 mm protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,15);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, >6-8 mm protocol");
			adapter.addTest(patient.getMrn(), test);	
			logger.debug("add_Nodule_more_6_8mm: "+this.testData.getMrn ( ));
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_Nodule_more_8mm() {	
		if(!canModify()){ 
			logger.debug ("add_Nodule_more_8mm: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate4);
			test.setTestType(100);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("3mo CT, > 8mm protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("9mo CT, > 8mm protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,15);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, > 8mm protocol");
			adapter.addTest(patient.getMrn(), test);	
			logger.debug ("add_Nodule_more_8mm: "+this.testData.getMrn ( ));
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}		
	}
	
	public void add_Lung_Mass() {
		if(!canModify()){ 
			logger.debug ("add_Lung_Mass: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate5);
			test.setTestType(100);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("3mo CT, lung mass protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo CT, lung mass protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo CT, lung mass protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, lung mass protocol");
			adapter.addTest(patient.getMrn(), test);
			logger.debug ("add_Lung_Mass: "+this.testData.getMrn ( ));
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_GroundGlass_more_4_6mm() {	
		if(!canModify()){
			logger.debug ("add_GroundGlass_more_4_6mm: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate6);
			test.setTestType(100);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("6mo CT, >4-6mm GGO protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo CT, >4-6mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, >4-6mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("3yr CT, >4-6mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("4yr CT, >4-6mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("5yr CT, >4-6mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			logger.debug ("add_GroundGlass_more_4_6mm: "+this.testData.getMrn ( ));
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_GroundGlass_more_6_8mm() {
		if(!canModify()){ 
			logger.debug("add_GroundGlass_more_6_8mm: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate7);
			test.setTestType(100);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("3mo CT, >6-8mm GGO protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("9mo CT, >6-8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,15);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, >6-8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("3yr CT, >6-8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("4yr CT, >6-8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("5yr CT, >6-8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			logger.debug("add_GroundGlass_more_6_8mm: "+this.testData.getMrn ( ));
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_GroundGlass_more_8mm() {	
		if(!canModify()){ 
			logger.debug ("add_GroundGlass_more_8mm: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate8);
			test.setTestType(100);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("3mo CT, >=8mm GGO protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo CT, >=8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo CT, >=8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, >=8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("3yr CT, >=8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("4yr CT, >=8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			test.setRequiredDate(cal.getTime());
			test.setComment("5yr CT, >=8mm GGO protocol");
			adapter.addTest(patient.getMrn(), test);
			logger.debug ("add_GroundGlass_more_8mm: "+this.testData.getMrn ( ));
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_PostResection_curative_RT() {	
		if(!canModify()){ 
			logger.debug ("add_PostResection_curative_RT: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate9);
			test.setTestType(100);
			cal.add(Calendar.MONTH,1);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("1mo CT, post-resection protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,5);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo CT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("18mo CT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);			
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("2yr CT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("3yr CT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("4yr CT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("5yr CT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);
			test.setTestType(200);
			cal.add(Calendar.MONTH,-48);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo PET, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);
			test.setTestType(600);
			cal.add(Calendar.MONTH,-6);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo PFT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo PFT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);		
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo PFT, post-resection protocol");
			adapter.addTest(patient.getMrn(), test);	
			logger.debug ("add_PostResection_curative_RT: "+this.testData.getMrn ( ));
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_RFA_Cyro_SBRT() {	
		if(!canModify()){ 
			logger.debug ("add_RFA_Cyro_SBRT: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate10);
			test.setTestType(100);
			cal.add(Calendar.MONTH,1);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("1mo CT, RFA/Cryo/SBRT protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,2);
			test.setRequiredDate(cal.getTime());
			test.setComment("3mo CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("18mo CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("3yr CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("4yr CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("5yr CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);			
			test.setTestType(200);
			cal.add(Calendar.MONTH,-54);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo PET, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo PET, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo PET, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);			
			test.setTestType(600);
			cal.add(Calendar.MONTH,-23);
			test.setRequiredDate(cal.getTime());
			test.setComment("1mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,2);
			test.setRequiredDate(cal.getTime());
			test.setComment("3mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);		
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			logger.debug ("add_RFA_Cyro_SBRT: "+this.testData.getMrn());
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_Typical_Carcinoid() {	
		if(!canModify()){ 
			logger.debug ("add_Typical_Carcinoid: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate11);
			test.setTestType(100);
			cal.add(Calendar.MONTH,1);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("1mo CT, Carcinoid protocol");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,11);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo CT, Carcinoid protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, Carcinoid protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("3yr CT, Carcinoid protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("4yr CT, Carcinoid protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("5yr CT, Carcinoid protocol");
			adapter.addTest(patient.getMrn(), test);	
			test.setTestType(600);
			cal.add(Calendar.MONTH,-48);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo PFT, Carcinoid protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo PFT, Carcinoid protocol");
			adapter.addTest(patient.getMrn(), test);
			logger.debug ("add_Typical_Carcinoid: "+this.testData.getMrn ( ));
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void add_Renal_No_Contrast() {	
		if(!canModify()){ 
			logger.debug ("add_Renal_No_Contrast: You are not allowed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "JFYI", "You aren't allowed to modify data !!"));
			return;
		}
		Calendar cal = Calendar.getInstance();
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			cal.setTime(startDate12);
			test.setTestType(100);
			cal.add(Calendar.MONTH,1);
			test.setRequiredDate(cal.getTime());
			test.setScheduledDate(null);
			test.setTestingDate(null);
			test.setTestingResult(0);
			test.setComment("1mo CT, RFA/Cryo/SBRT protocol. Renal-No contrast");
			test.setCancelled(false);
			test.setOrderByLCEC(true);
			test.setFUwithMD(false);
			test.setPrecertNumber("");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,2);
			test.setRequiredDate(cal.getTime());
			test.setComment("3mo CT, RFA/Cryo/SBRT protocol. Renal-No contrast");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo CT, RFA/Cryo/SBRT protocol. Renal-No contrast");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo CT, RFA/Cryo/SBRT protocol. Renal-No contrast");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("18mo CT, RFA/Cryo/SBRT protocol. Renal-No contrast");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo CT, RFA/Cryo/SBRT protocol. Renal-No contrast");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("3yr CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("4yr CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("5yr CT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);	
			test.setTestType(200);
			cal.add(Calendar.MONTH,-54);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo PET, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo PET, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo PET, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);						
			test.setTestType(600);
			cal.add(Calendar.MONTH,-23);
			test.setRequiredDate(cal.getTime());
			test.setComment("1mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,2);
			test.setRequiredDate(cal.getTime());
			test.setComment("3mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);		
			cal.add(Calendar.MONTH,3);
			test.setRequiredDate(cal.getTime());
			test.setComment("6mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);	
			cal.add(Calendar.MONTH,6);
			test.setRequiredDate(cal.getTime());
			test.setComment("12mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			cal.add(Calendar.MONTH,12);
			test.setRequiredDate(cal.getTime());
			test.setComment("24mo PFT, RFA/Cryo/SBRT protocol");
			adapter.addTest(patient.getMrn(), test);
			logger.debug ("add_Renal_No_Contrast: "+this.testData.getMrn());
			this.testData.setTestList(adapter.getTestList(patient.getMrn()));
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
