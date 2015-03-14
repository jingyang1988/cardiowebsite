/*
 * This will show every medication info
 * for the a specific Patient;
 * */
package lcec.model;

import java.util.*;
import java.io.*;

public class PatientMedication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public PatientMedication() {
		this.ID = -1;
	}
	
	private int ID;
//	private int medication;
	private String medicationName;
	private	String strength;   
	private int strengthUnit;	//list
	private String dose;       
	private int doseUnit;	//list
	private String howOftenTaken; 
	private int howTaken;   //list
	private String reasonTaking;
	private Date dateStarted;
	private Date dateStopped;
	private int medicineGivenType;    //list
	private String instruction;
	private String prescriptor;
	private Date prescribedDate;
	private String prescriptionQuantity;
	private Date prescriptionExpireDate;
	private String allergies;
	
	public int getID() {
		return this.ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	//The name of function in this page should be same with
	//those on the page you want to display
	
	//list should be initiated as int 
	//filling in value should be initiated as string
	
	//Medication here is the list of medication Stored in the medication table
//	public int getMedication() {
//		return this.medication;
//	}
//	
//	public void setMedication(int name) {
//		this.medication = name;
//	}
	
	public String getMedicationName() {
		return this.medicationName;
	}
	
	public void setMedicationName(String name) {
		this.medicationName = name;
	}

	public String getStrength() {
		return this.strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}
	
	public int getStrengthUnit() {
		return this.strengthUnit;
	}
	
	public void setStrengthUnit(int strengthUnit) {
		this.strengthUnit = strengthUnit;
	}

	public String getDose() {
		return this.dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}
	
	public int getDoseUnit() {
		return this.doseUnit;
	}
	
	public void setDoseUnit(int doseUnit) {
		this.doseUnit = doseUnit;
	}

	public String getHowOftenTaken() {
		return this.howOftenTaken;
	}

	public void setHowOftenTaken(String howOftenTaken) {
		this.howOftenTaken = howOftenTaken;
	}

	public int getHowTaken() {
		return this.howTaken;
	}

	public void setHowTaken(int howTaken) {
		this.howTaken = howTaken;
	}

	// String reasonTaking;
	public String getReasonTaking() {
		return this.reasonTaking;
	}

	public void setReasonTaking(String reasonTaking) {
		this.reasonTaking = reasonTaking;
	}

	public Date getDateStarted() {
		return this.dateStarted;
	}

	public void setDateStarted(Date date) {
		this.dateStarted = date;
	}

	public Date getDateStopped() {
		return this.dateStopped;
	}

	public void setDateStopped(Date date) {
		this.dateStopped = date;
	}

	public int getMedicineGivenType() {
		return this.medicineGivenType;
	}

	public void setMedicineGivenType(int medicineGivenType) {
		this.medicineGivenType = medicineGivenType;
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getPrescriptor() {
		return this.prescriptor;
	}

	public void setPrescriptor(String prescriptor) {
		this.prescriptor = prescriptor;
	}

	public Date getPrescribedDate() {
		return this.prescribedDate;
	}

	public void setPrescribedDate(Date date) {
		this.prescribedDate = date;
	}

	public String getPrescriptionQuantity() {
		return this.prescriptionQuantity;
	}

	public void setPrescriptionQuantity(String quantity) {
		this.prescriptionQuantity = quantity;
	}

	public Date getPrescriptionExpireDate() {
		return this.prescriptionExpireDate;
	}

	public void setPrescriptionExpireDate(Date date) {
		this.prescriptionExpireDate = date;
	}
	
	private boolean plavix;
	private boolean effient;
	private boolean agrylin;
	private boolean aggrenox;
	private boolean pletal;
	private boolean pradaxa;
	private boolean xarelto;
	private boolean coumadin;
	private boolean persantine;
	private boolean eliquis;
	private boolean brilinta;
	private boolean oralHypoglycemic;
	private boolean insulin;

	public boolean getPlavix() {return plavix;}
	public void setPlavix(boolean plavix) {this.plavix = plavix;}
	
	public boolean getEffient() {return effient;}
	public void setEffient(boolean effient) {this.effient = effient;}
	
	public boolean getAgrylin() {return agrylin;}
	public void setAgrylin(boolean agrylin) {this.agrylin = agrylin;}
	
	public boolean getAggrenox() {return aggrenox;}
	public void setAggrenox(boolean aggrenox) {this.aggrenox = aggrenox;}
	
	public boolean getPletal() {return pletal;}
	public void setPletal(boolean pletal) {this.pletal = pletal;}
	
	public boolean getPradaxa() {return pradaxa;}
	public void setPradaxa(boolean pradaxa) {this.pradaxa = pradaxa;}
	
	public boolean getXarelto() {return xarelto;}
	public void setXarelto(boolean xarelto) {this.xarelto = xarelto;}
	
	public boolean getCoumadin() {return coumadin;}
	public void setCoumadin(boolean coumadin) {this.coumadin = coumadin;}
	
	public boolean getPersantine() {return persantine;}
	public void setPersantine(boolean persantine) {this.persantine = persantine;}
	
	public boolean getEliquis() {return eliquis;}
	public void setEliquis(boolean eliquis) {this.eliquis = eliquis;}
	
	public boolean getBrilinta() {return brilinta;}
	public void setBrilinta(boolean brilinta) {this.brilinta = brilinta;}
	
	public boolean getOralHypoglycemic() {return oralHypoglycemic;}
	public void setOralHypoglycemic(boolean oralHypoglycemic) {this.oralHypoglycemic = oralHypoglycemic;}
	
	public boolean getInsulin() {return insulin;}
	public void setInsulin(boolean insulin) {this.insulin = insulin;}
	
	private Date additionDate;
	public Date getAdditionDate() {
		return this.additionDate;
	}
	public void setAdditionDate(Date date) {this.additionDate = date;}
	
	public String getAllergies() {
		return this.allergies;
	}
	
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	private boolean nka;
	
	public boolean getNka() {
		return this.nka;
	}
	public void setNka(boolean nka) {
		this.nka = nka;
	}
}
