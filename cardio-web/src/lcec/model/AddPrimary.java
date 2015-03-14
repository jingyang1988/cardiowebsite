package lcec.model;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("lcec.model.addprimary.converter")
public final class  AddPrimary implements Serializable, Converter {
	
	private static final long serialVersionUID = 1L;


	//patient
	private String treating;
	private String title;
	private String groupname;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String office;



	
	public AddPrimary(){
		
	}
	
	public AddPrimary(AddPrimary addreferring){
		this.treating = addreferring.getTreating();
		this.title = addreferring.getTitle();
		this.groupname = addreferring.getGroupname();
		this.address = addreferring.getAddress();
		this.city = addreferring.getCity();
		this.state = addreferring.getState();
		this.zip = addreferring.getZip();
		this.office = addreferring.getOffice();
		
	}
	
	public AddPrimary(String referring, String title, String groupname, String address, String city, String state,String zip,String office){
		this.treating = referring;
		this.title = title;
		this.groupname = groupname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.office = office;
	
	}
	
	
	
		
	public String getTreating() {
		return treating;
	}

	public String getTitle() {
		return title;
	}

	public String getGroupname() {
		return groupname;
	}

	public String getOffice() {
		return office;
	}
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	
	public String getAddress() {
		return address;
	}
	public void setTreating(String referring) {
		this.treating = referring;
	}
	
	public void setTitle(String name) {
		this.title = name;
	}
	
	public void setGroupname(String workupStatus) {
		this.groupname = workupStatus;
	}
	
	public void setAddress(String lcecStatus) {
		this.address = lcecStatus;
	}



	public void setCity(String lcecId) {
		this.city = lcecId;
	}
	public void setState(String lcecId) {
		this.state = lcecId;
	}

	public void setZip(String lcecId) {
		this.zip = lcecId;
	}
	public void setOffice(String lcecId) {
		this.office = lcecId;
	}


	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value)
			throws ConverterException {
		// TODO Auto-generated method stub
		if(value == null)
			return null;
		String[] searchResult =  value.split(";");
		if(searchResult.length==8)
			return new AddPrimary(
							  searchResult[0].trim(), 
							   searchResult[1].trim(), 
							   searchResult[2].trim(), 
							   searchResult[3].trim(), 
							   searchResult[4].trim(), 
							   searchResult[5].trim(),
							   searchResult[6].trim(),
							   searchResult[7].trim()
							  );
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value)
			throws ConverterException {
		// TODO Auto-generated method stub
		if(value == null)
			return "";
	
		AddPrimary addReferring = (AddPrimary) value;
		return addReferring.treating+
				addReferring.title+
				addReferring.groupname+
				addReferring.address+
				addReferring.city+
				addReferring.state+
				addReferring.zip+
				addReferring.office;
    }
	
}
