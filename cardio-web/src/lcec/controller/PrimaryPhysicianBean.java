package lcec.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.AddPrimary;
@ManagedBean(name="primaryPhysicianBean")
public class PrimaryPhysicianBean {

	private String title = null;
	private String groupname = null;
	private String address = null;
	private String city = null;
	private String state = null;
	private String zip = null;
	private String office = null;
	

	private static Logger logger = LogManager.getLogger(PrimaryPhysicianBean.class.getName());

	private String treating = null;
	public String getTreating() {
		return treating;
	}




	public void setTreating(String treating) {
		this.treating = treating;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getGroupname() {
		return groupname;
	}




	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getZip() {
		return zip;
	}




	public void setZip(String zip) {
		this.zip = zip;
	}




	public String getOffice() {
		return office;
	}




	public void setOffice(String office) {
		this.office = office;
	}




	
	
	public void addReferPhysician(){
		
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
	
			AddPrimary test=new AddPrimary(treating ,title ,groupname,address ,city,state,zip,office);
			adapter.addPrimaryMD(test);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Primary Phyisican Creation Status", "Created Successfully !!"));
			}
			catch(Exception ex){
				logger.error (ex, ex);
			}
	}
	
}