package lcec.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;

@ManagedBean(name="doctorBean")
public class DoctorBean {
	private static Logger logger = LogManager.getLogger(QueryBean.class
			.getName());
	private String firstName = null;
	private String testType = null;
	
	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	private String lastName = null;
	private String name = null;
	private boolean addDoc = false;
	
	public boolean isAddDoc() {
		return addDoc;
	}

	public void setAddDoc(boolean addDoc) {
		this.addDoc = addDoc;
	}

	public String getFirstName() {
		
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addLcecDoctor(){
		
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			name = firstName +","+ lastName;
			adapter.addLcecDoctor(name);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Doctor Creation Status", "Created Successfully !!"));
			this.setAddDoc(true);
			}
			catch(Exception ex){
				logger.error (ex, ex);
			}
	}
	
	public void addTestType(){
		System.out.println("In add Test Type");
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			if (adapter.addTestType(testType))
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Test Type Addition", "Added Successfully !!"));
			else
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Test Type Addition", "Addition Failed! Contact Tech Support"));
			this.setAddDoc(true);
			}
			catch(Exception ex){
				logger.error (ex, ex);
			}
	}
}
