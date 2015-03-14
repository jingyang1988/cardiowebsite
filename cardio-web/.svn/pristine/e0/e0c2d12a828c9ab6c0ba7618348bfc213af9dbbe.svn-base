package lcec.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slamb.axamol.library.LibraryConnection;
import org.slamb.axamol.library.SqlUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@FacesConverter("lcec.model.patient.converter")
public final class  Patient implements Serializable, Converter {
	
	private static final long serialVersionUID = 1L;
	//patient
	private String mrn;
	private String oldmrn;
	private String name;
	private String workupStatus;
	private String lcecStatus;
	private int workUpId;
	private int lcecId;
	private static Logger logger = LogManager.getLogger(DataAdapter.class
			.getName());
	private static LibraryConnection lc = null;
	public Users cur_user = null;
	
	public Patient(){
		
		//this.mrn = getMrn();
		
	}
	
	public Patient(Patient patient){
		this.mrn = patient.getMrn();
		this.name = patient.getName();
		this.workupStatus = patient.getWorkupStatus();
		this.lcecStatus = patient.getLcecStatus();
		this.workUpId = patient.getWorkUpId();
		this.lcecId = patient.getLcecId();
	}
	
	public Patient(String mrn, String name, String workup, String lcec, int workUpId, int lcecId){
		this.mrn = mrn;
		this.name = name;
		this.workupStatus = workup;
		this.lcecStatus = lcec;
		this.workUpId = workUpId;
		this.lcecId = lcecId;
	}
	
	
	
		
	public String getName() {
		return name;
	}

	public String getMrn() {
		return mrn;
	}

	public String getWorkupStatus() {
		return workupStatus;
	}

	public String getLcecStatus() {
		return lcecStatus;
	}
	
	public void setMrn(String mrn) {
		System.out.println("In patient set mrn" + mrn);
		this.mrn = mrn;
		//autoMRN();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWorkupStatus(String workupStatus) {
		this.workupStatus = workupStatus;
	}
	
	public void setLcecStatus(String lcecStatus) {
		this.lcecStatus = lcecStatus;
	}

	public int getWorkUpId() {
		return workUpId;
	}

	public void setWorkUpId(int workUpId) {
		this.workUpId = workUpId;
	}

	public int getLcecId() {
		return lcecId;
	}

	public void setLcecId(int lcecId) {
		this.lcecId = lcecId;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if(value == null)
			return null;
		String[] patientData =  value.split(";");
		if(patientData.length==6)
			return new Patient(patientData[0].trim(), patientData[1].trim(), patientData[2].trim(), patientData[3].trim(), Integer.parseInt(patientData[4].trim()), Integer.parseInt(patientData[5].trim()));
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null)
			return "";
		Patient patient = (Patient) value;
		return patient.mrn +";"+ patient.name +";"+ patient.workupStatus +";"+ patient.lcecStatus +";"+ patient.workUpId +";"+ patient.lcecId;
	}

	public String getOldmrn() {
		return oldmrn;
	}

	public void setOldmrn(String oldmrn) {
		this.oldmrn = oldmrn;
	}
	
	public void autoMRN() {
		
			
			
				System.out.println("before getting data");
				try (IDataAdapter adapter = DataAdapter.getDataAdapter()) {
					logger.debug ("automrn");
					mrn = Integer.toString(adapter.autoMRN());
					System.out.println("MRN as string:"+ mrn);
					//setMrn(mrn);
				} catch (Exception ex) {
					logger.error (ex, ex);
				}
			
			
			//return quartLungResec;
		}

		
	
	
}
