package lcec.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import lcec.model.Patient;

@ManagedBean(name = "automrn")
@RequestScoped
public class automrn {
	
	public automrn(){
		
		
	}
	
	
	public String generatemrn(){
		
		
		Patient obj = new Patient();
		obj.autoMRN();
		return "NewPatient.xhtml";	
	}

}
