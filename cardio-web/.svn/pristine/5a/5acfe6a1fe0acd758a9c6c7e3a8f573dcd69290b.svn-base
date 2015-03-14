package lcec.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.Patient;
import lcec.model.PatientDataModel;
import lcec.model.Users;
import lcec.model.Visit;

@ManagedBean(name="pageLogBean")
@SessionScoped

public class PageLogBean implements Serializable
{
	private static Logger logger = LogManager.getLogger(PageLogBean.class
		.getName());
	private Users cur_user;

	public PageLogBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		cur_user = (Users) httpSession.getAttribute("cur_user");

	}
	
	public String logger(String page){
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: "+page);
		return page;
	}
	
	public String surBiopsyDatalogger(){
		logger.debug("User: "+cur_user.getUserId ( )+" logged page: surBiopsyData.xhtml");
		return "surBiopsyData.xhtml";
	}

}