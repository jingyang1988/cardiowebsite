package lcec.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean(name="ResearchBean")
@RequestScoped
public class Research implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;

	public Research(){
		this.ID = -1;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	//needs to be list
	private Date consentDate;
	private int researchProj;
	private String comments;
	
	public Date getConsentDate() {
		return consentDate;
	}
	public void setConsentDate(Date consentDate) {
		this.consentDate = consentDate;
	}
	public int getResearchProj() {
		return researchProj;
	}
	public void setResearchProj(int researchProj) {
		this.researchProj = researchProj;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}