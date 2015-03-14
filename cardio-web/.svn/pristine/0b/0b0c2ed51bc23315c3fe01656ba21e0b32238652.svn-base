package lcec.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;

import lcec.model.InsuranceDataModel;
@ManagedBean(name="insuranceBean")
public class InsuranceBean {
	private static Logger logger = LogManager.getLogger(InsuranceBean.class.getName());

	String insurCo = null;
	String phoneNumber1 = null;
	String phoneNumber2 = null;
	String phoneNumber3 = null;
	String comment = null;
	String ctPrecert = null;
	String petPrecert = null;
	String pftPrecert = null;
	String visitReferral = null;
	
	public void addInsurance(){
		
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			InsuranceDataModel insurance = new InsuranceDataModel();
			insurance.setInsurCo(insurCo);
			insurance.setPhoneNumber1(phoneNumber1);
			insurance.setPhoneNumber2(phoneNumber2);
			insurance.setPhoneNumber3(phoneNumber3);
			insurance.setComment(comment);
			insurance.setCtPrecert(ctPrecert);
			insurance.setPetPrecert(petPrecert);
			insurance.setPftPrecert(pftPrecert);
			insurance.setVisitReferral(visitReferral);
			//AddReferring test=new AddReferring(referring ,title ,groupname,address ,city,state,zip,office ,fax );
			adapter.addInsurance(insurance);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Insurance Creation Status", "Created Successfully !!"));
			}
			catch(Exception ex){
				logger.error (ex, ex);
			}
	}

	public String getInsurCo() {
		return insurCo;
	}

	public void setInsurCo(String insurCo) {
		this.insurCo = insurCo;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneNumber3() {
		return phoneNumber3;
	}

	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCtPrecert() {
		return ctPrecert;
	}

	public void setCtPrecert(String ctPrecert) {
		this.ctPrecert = ctPrecert;
	}

	public String getPetPrecert() {
		return petPrecert;
	}

	public void setPetPrecert(String petPrecert) {
		this.petPrecert = petPrecert;
	}

	public String getPftPrecert() {
		return pftPrecert;
	}

	public void setPftPrecert(String pftPrecert) {
		this.pftPrecert = pftPrecert;
	}

	public String getVisitReferral() {
		return visitReferral;
	}

	public void setVisitReferral(String visitReferral) {
		this.visitReferral = visitReferral;
	}
	
}