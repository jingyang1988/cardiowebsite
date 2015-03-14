package lcec.model;

import java.util.*;

public class QueryLesions implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Patient m_cPatient;
	private Lesion m_cLesion;
	
	public QueryLesions(){
		m_cPatient = new Patient();
		m_cLesion = new Lesion();
	}
	
	public void setMrn(String mrn){
		m_cPatient.setMrn(mrn);
	}
	
	public String getMrn(){
		return m_cPatient.getMrn();
	}
	
	public void setName(String name){
		m_cPatient.setName(name);
	}
	
	public String getName(){
		return m_cPatient.getName();
	}
	
	public void setDateFollowedLCEC(Date date){
		m_cLesion.setDate1stFollowedLCEC(date);
	}
	
	public Date getDateFollowedLCEC(){
		return m_cLesion.getDate1stFollowedLCEC();
	}
	
	public void setLesionClassification(int lesionClassification){
		m_cLesion.setLessionClassification(lesionClassification);
	}
	
	public int getLesionClassification(){
		return m_cLesion.getLessionClassification();
	}
	
	public void setLocation(String location){
		m_cLesion.setLocation(location);
	}
	
	public String getLocation(){
		return m_cLesion.getLocation();
	}
	
	public void setComments(String comments){
		m_cLesion.setComments(comments);
	}
	
	public String getComments(){
		return m_cLesion.getComments();
	}
	
	public void setCtCharacteristic(String cTCharacteristic){
		m_cLesion.setCTCharacteristic(cTCharacteristic);
	}
	
	public String getCtCharacteristic(){
		return m_cLesion.getCTCharacteristic();
	}
	
	public void setPetSUV(String petSUV){
		m_cLesion.setPetSUV(petSUV);
	}
	
	public String getPetSUV(){
		return m_cLesion.getPetSUV();
	}

}
