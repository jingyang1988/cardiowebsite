package lcec.model;

import java.io.Serializable;
import java.util.Date;

public class PatientLesion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date lesionDate;
	private int lesionId;
	private int  lesionClassificationId;
	private String leasionClassification;
	private String location;
	public Date getLesionDate() {
		return lesionDate;
	}
	public void setLesionDate(Date lesionDate) {
		this.lesionDate = lesionDate;
	}
	
	public int getLesionId() {
		return lesionId;
	}
	public void setLesionId(int lesionId) {
		this.lesionId = lesionId;
	}
	public int getLesionClassificationId() {
		return lesionClassificationId;
	}
	public void setLesionClassificationId(int lesionClassificationId) {
		this.lesionClassificationId = lesionClassificationId;
	}
	public String getLeasionClassification() {
		return leasionClassification;
	}
	public void setLeasionClassification(String leasionClassification) {
		this.leasionClassification = leasionClassification;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
