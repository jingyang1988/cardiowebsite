package lcec.controller;

import java.io.IOException;
import java.util.ArrayList;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.Users;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean  {
	private static Logger logger = LogManager.getLogger(LoginBean.class
		.getName());
	private Users cur_user;
	private String username;
	private String password;
	private String role;
	private String newEmail1;
	private String newEmail2;
	private boolean correct_cpw=false;
	private boolean correct_pw=false;
	private boolean correct_email=false;
	private String userId;
	private String password1;  
	private String password2="1";
	private String password3="]";
	ArrayList<Users> usersList;

	private String newusername;
	private String newuserId;
	private String newuserpassword2="1";
	private String newuserpassword3="]";
	private String newuserEmail;
	private int newuserRole;
	private boolean newUserOk=false;

	public int getNewuserRole() {
		return newuserRole;
	}

	public void setNewuserRole(int newuserRole) {
		this.newuserRole = newuserRole;
	}

	public boolean isNewUserOk() {
		return newUserOk;
	}

	public void setNewUserOk(boolean newUserOk) {
		this.newUserOk = newUserOk;
	}

	public String getNewusername() {
		return newusername;
	}

	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}

	public String getNewuserId() {
		return newuserId;
	}

	public void setNewuserId(String newuserId) {
		this.newuserId = newuserId;
	}

	public String getNewuserpassword2() {
		return newuserpassword2;
	}

	public void setNewuserpassword2(String newuserpassword2) {
		this.newuserpassword2 = newuserpassword2;
	}

	public String getNewuserpassword3() {
		return newuserpassword3;
	}

	public void setNewuserpassword3(String newuserpassword3) {
		this.newuserpassword3 = newuserpassword3;
	}

	public String getNewuserEmail() {
		return newuserEmail;
	}

	public void setNewuserEmail(String newuserEmail) {
		this.newuserEmail = newuserEmail;
	}


	public String getNewEmail1() {
		return newEmail1;
	}

	public void setNewEmail1(String newEmail1) {
		this.newEmail1 = newEmail1;
	}

	public String getNewEmail2() {
		return newEmail2;
	}

	public void setNewEmail2(String newEmail2) {
		this.newEmail2 = newEmail2;
	}

	public String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}


	public String getRole() {
		return role;
	}

	public Users getCur_user() {
		return cur_user;
	}

	public void setCur_user(Users cur_user) {
		this.cur_user = cur_user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String id) {

		this.userId = id;
	}

	public boolean isCorrect_cpw() {
		return correct_cpw;
	}

	public void setCorrect_cpw(boolean correct_pw) {
		this.correct_cpw = correct_pw;
	}

	public boolean isCorrect_pw() {
		return correct_pw;
	}

	public void setCorrect_pw(boolean correct_pw) {
		this.correct_pw = correct_pw;
	}

	public String getPassword1() {  
		return password1;  
	}  

	public void setPassword1(String password1) {  

		this.password1 = password1;  
	}  

	public String getPassword2() {  

		return password2;  
	}  

	public void setPassword2(String password2) {  
		this.password2 = password2;  
	}  

	public String getPassword3() {  
		return password3;  
	}  

	public void setPassword3(String password3) {  

		this.password3 = password3;  
	}  

	public ArrayList<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(ArrayList<Users> usersData) {
		this.usersList=usersData;
	}

	public boolean isCorrect_email() {
		return correct_email;
	}

	public void setCorrect_email(boolean correct_email) {
		this.correct_email = correct_email;
	}

	public void isLogged(){
		if(this.role==null){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error (e, e);
			}  
		}
	}

	public String login() throws ValidatorException{	
		this.cur_user=new Users();
		this.cur_user.setUserId(this.username);
		this.cur_user.setPassword(this.password);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		httpSession.setAttribute("cur_user", this.cur_user);
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			String role = adapter.isValidUser(this.username, this.password);
			if(role.equals("Webuser"))
				this.role = "User";
			else if(role.equals("Readonly"))
				this.role = "Readonly User";
			else this.role = role;
			cur_user.setRole(this.role);
			
			if(role != null){
				
				this.cur_user.setEmail(adapter.getEmail(this.username, this.password).get(0));
				this.cur_user.setUsername(adapter.getEmail(this.username, this.password).get(1));
				if(role.equalsIgnoreCase("Administrator"))
					this.showAnotherUsers();
				logger.debug ("login: "+role + this.username+" is logged!");
				return "mainMenu.xhtml";
			}
			
		}		
		catch(Exception e){
			e.printStackTrace();
			logger.error (e, e);
		}
		this.username = null;
		this.password = null;	
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Login Failed"));
		logger.debug ("login: "+role + this.username+" Login Failed!");
		return "index.xhtml";
	}



	public String logOut(){
		this.username=null;
		this.password=null;
		this.setCorrect_cpw(false);
		this.setCorrect_pw(false);
		this.setPassword1(null);
		this.setPassword2("1");
		this.setPassword3("]");
		this.setUserId(null);
		this.setCorrect_email(false);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession httpSession = (HttpSession)facesContext.getExternalContext().getSession(false);
		
		httpSession.invalidate();
		logger.debug ("User logout!");
		return "index.xhtml";
	}

	public void validateNewUserbyAdmin() {
		FacesMessage message;

		if(this.newusername==null||(this.newusername!=null&&this.newusername.trim().length()==0)){
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "User name cannot be empty");
			this.setNewUserOk(false);
			FacesContext.getCurrentInstance().addMessage("form:newusername", message);
			logger.debug ("validateNewUserbyAdmin: User name cannot be empty");
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "User name Ok");
			logger.debug ("validateNewUserbyAdmin: User name Ok");
			FacesContext.getCurrentInstance().addMessage("form:newusername", message);
			if(this.newuserId==null||(this.newuserId!=null&&this.newuserId.trim().length()==0)){
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "User Id cannot be empty");
				logger.debug ("validateNewUserbyAdmin: User Id cannot be empty");
				this.setNewUserOk(false);
				FacesContext.getCurrentInstance().addMessage("form:newuserId", message);
			}
			else{
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "User Id Ok");
				logger.debug ("validateNewUserbyAdmin: User Id Ok");
				FacesContext.getCurrentInstance().addMessage("form:newuserId", message);
				if(!this.newuserpassword2.equals(this.newuserpassword3)){
					message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "New Password is different");
					logger.debug ("validateNewUserbyAdmin: New Password is different");
					this.setNewUserOk(false);
					FacesContext.getCurrentInstance().addMessage("form:pwd10", message);
				}
				else{
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "New Password ok");
					logger.debug ("validateNewUserbyAdmin: New Password ok");
					FacesContext.getCurrentInstance().addMessage("form:pwd10", message);
					this.setNewUserOk(true);
				}
			}
		}
	}

	public void addUser(){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){

			adapter.adduser(this.newusername, this.newuserId, this.newuserpassword3, this.newuserEmail,this.newuserRole);
			this.usersList = adapter.getUsersData(this.getCur_user().getUserId());
			this.setNewusername("");
			this.setNewuserId("");
			this.setNewuserpassword2("");
			this.setNewuserpassword3("");
			this.setNewuserEmail("");
			this.setNewUserOk(false);
			this.setNewuserRole(2);
			logger.debug ("addUser: New user is added: "+this.newuserId);
		}catch(Exception ex){
			logger.error (ex, ex);
		}		

	}

	public void removeUser(){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){

			adapter.removeuser(this.userId);
			this.usersList = adapter.getUsersData(this.getCur_user().getUserId());
			logger.debug ("removeUser: New user is removed: "+this.newuserId);
		}catch(Exception ex){
			logger.error (ex, ex);
		}		

	}

	public void validatePasswordbyAdmin() {
		FacesMessage message;
		if(!this.password2.equals(this.password3)){
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "New Password is different");
			logger.debug ("validatePasswordbyAdmin: New Password is different");
			this.setCorrect_pw(false);
			FacesContext.getCurrentInstance().addMessage("form:pwd4", message);
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "New Password ok");
			logger.debug ("validatePasswordbyAdmin: New Password is Ok");
			FacesContext.getCurrentInstance().addMessage("form:pwd4", message);
			this.setCorrect_pw(true);
		}
	}

	public void validatePassword() {
		FacesMessage message;
		if(!this.password2.equals(this.password3)){
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "New Password is different");
			logger.debug ("validatePassword: New Password is different");
			this.setCorrect_pw(false);
			FacesContext.getCurrentInstance().addMessage("form:pwd2", message);
		}
		else{
			if(this.correct_cpw==true){
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "New Password ok");
				logger.debug ("validatePassword: New Password is Ok");
				FacesContext.getCurrentInstance().addMessage("form:pwd2", message);
				this.setCorrect_pw(true);
			}
			else {
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Current Password is different");
				logger.debug ("validatePassword: Current Password is different");
				this.setCorrect_cpw(false);
				FacesContext.getCurrentInstance().addMessage("form:password", message);
			}
		}
	}

	public void validateCurrentPassword() {
		FacesMessage message;
		IDataAdapter adapter = DataAdapter.getDataAdapter();
		if(!this.password1.equals(adapter.getCurrentPassword(userId))){
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Current Password is different");
			logger.debug ("validateCurrentPassword: Current Password is different");
			this.setCorrect_cpw(false);
			FacesContext.getCurrentInstance().addMessage("form:password", message);
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Current Password ok");
			logger.debug ("validateCurrentPassword: Current Password is ok");
			FacesContext.getCurrentInstance().addMessage("form:password", message);
			this.setCorrect_cpw(true);
		}
	}

	public void savePassword(){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.savePassword(this.userId, this.password3);
			this.usersList = adapter.getUsersData(this.getCur_user().getUserId());
			this.setCorrect_cpw(false);
			this.setCorrect_pw(false);
			this.setPassword1(null);
			this.setPassword2("1");
			this.setPassword3("]");
			this.setUserId(null);
			logger.debug ("savePassword: password is saved for user: "+this.userId);
		}catch(Exception ex){
			logger.error (ex, ex);
		}		

	}

	public void savePassword(String newPw){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.savePassword(this.getCur_user().getUserId(),newPw );
			this.setCur_user(adapter.getCurUserData(this.getCur_user().getUserId()));
			this.setCorrect_cpw(false);
			this.setCorrect_pw(false);
			this.setPassword1(null);
			this.setPassword2("1");
			this.setPassword3("]");
			logger.debug ("savePassword: password is saved for user: "+this.getCur_user().getUserId());
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}
	
	public void showAnotherUsers() {
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			this.usersList=adapter.getUsersData(this.getCur_user().getUserId());
			logger.debug("showAnotherUsers: ");
		}catch(Exception ex){
			logger.error (ex, ex);
		}
	}

	public void validateEamil() {
		FacesMessage message;
		if(!this.newEmail1.equals(this.newEmail2)){
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "New Email is different");
			logger.debug ("validateEmail: New Eamil is different");
			this.setCorrect_email(false);
			FacesContext.getCurrentInstance().addMessage("form:pwd6", message);
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "New Email ok");
			logger.debug ("validateEmail: New Eamil is ok");
			FacesContext.getCurrentInstance().addMessage("form:pwd6", message);
			this.setCorrect_email(true);
		}
	}

	public void validateEamilbyAdmin() {
		FacesMessage message;
		if(!this.newEmail1.equals(this.newEmail2)){
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "New Email is different");
			logger.debug ("validateEmailbyAdmin: New Eamil is different");
			this.setCorrect_email(false);
			FacesContext.getCurrentInstance().addMessage("form:pwd8", message);
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "New Email ok");
			logger.debug ("validateEmailbyAdmin: New Eamil is ok");
			FacesContext.getCurrentInstance().addMessage("form:pwd8", message);
			this.setCorrect_email(true);
		}
	}

	public void saveEmail(){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.saveEmail(this.userId, this.newEmail2);
			this.usersList = adapter.getUsersData(this.getCur_user().getUserId());
			this.setNewEmail1(null);
			this.setNewEmail2(null);
			this.setUserId(null);
			this.setCorrect_email(false);
			logger.debug("saveEmail: saved for user: "+this.userId+" for the email: "+this.newEmail2);
		}catch(Exception ex){
			logger.error (ex, ex);
		}		


	}

	public void saveEmail(String newEmail){
		try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
			adapter.saveEmail(this.getCur_user().getUserId(), newEmail );
			this.setCur_user(adapter.getCurUserData(this.getCur_user().getUserId()));
			this.setNewEmail1(null);
			this.setNewEmail2(null);
			this.setUserId(null);
			this.setCorrect_email(false);
			logger.debug("saveEmail: saved for user: "+this.getCur_user().getUserId()+" for the email: "+newEmail);
		}catch(Exception ex){
			logger.error (ex, ex);
		}

	}



}
