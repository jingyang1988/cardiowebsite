package lcec.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.slamb.axamol.library.Library;
import org.slamb.axamol.library.LibraryConnection;
import org.slamb.axamol.library.SqlUtils;

public final class DataAdapter implements IDataAdapter, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Timer timer = new Timer();
	private static DataAdapter adapter;
	private static Connection dbConnection;
	private static Library library = new Library(DataAdapter.class,
			"queries/library.xml");
	private static Logger logger = LogManager.getLogger(DataAdapter.class
			.getName());
	private static LibraryConnection lc = null;
	public static String name = "jdbc";
	public static DAOProperties properties = new DAOProperties(name);
	public static final String PROPERTY_URL = "url";
	public static final String PROPERTY_DRIVER = "driver";
	public static final String PROPERTY_USERNAME = "username";
	public static final String PROPERTY_PASSWORD = "password";
	public Users cur_user = null;
	static {
		String url = properties.getProperty(PROPERTY_URL, true);
		String password = properties.getProperty(PROPERTY_PASSWORD, false);
		String username = properties.getProperty(PROPERTY_USERNAME,
				password != null);

		try {

			String driverClassName = properties.getProperty(PROPERTY_DRIVER,
					false);

			Class.forName(driverClassName);
			dbConnection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e, e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e, e);
		}

		lc = new LibraryConnection(library, dbConnection);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				try {

					Statement createStatement = dbConnection.createStatement();
					createStatement
							.execute("/* ping */ SELECT 1 from dummymrn");
					logger.debug("Executing the dummy query");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					logger.error(e, e);
				}
			}
		}, new Date(), 7 * 60 * 60 * 1000); // Query every 7 hrs. Assuming
											// wait_timeout of 8 hrs in
											// database.
	}

	public DataAdapter(String server, String username, String password) {
		try {

			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession httpSession = (HttpSession) facesContext
					.getExternalContext().getSession(false);
			cur_user = (Users) httpSession.getAttribute("cur_user");
			if (name == null) {
				throw new DAOConfigurationException("Database name is null.");
			}

		} catch (Exception e) {

			logger.error(e, e);
		}
	}

	public static IDataAdapter getDataAdapter() {

		String url = properties.getProperty(PROPERTY_URL, true);
		String password = properties.getProperty(PROPERTY_PASSWORD, false);
		String username = properties.getProperty(PROPERTY_USERNAME,
				password != null);

		adapter = new DataAdapter(url, username, password);

		return adapter;
	}

	@Override
	public String isValidUser(String username, String password) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("isValidUser", params);
			if (rs.next())
				return rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e, e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<String> getEmail(String username, String password) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);

		ArrayList<String> result = new ArrayList<String>();
		ResultSet rs = null;
		try {

			logger.debug("userid:" + cur_user.getUserId());
			rs = lc.executeQuery("getEmailandUserName", params);

			if (rs.next()) {
				result.add(0, rs.getString(1));
				result.add(1, rs.getString(2));
			}
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return result;
	}

	@Override
	public ArrayList<Users> getUsersData(String Id) {

		ArrayList<Users> usersList = new ArrayList<Users>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", Id);
		ResultSet rs = null;
		try {

			logger.debug("userid:" + cur_user.getUserId());
			rs = lc.executeQuery("getUsersData", params);

			while (rs.next()) {
				Users users = new Users();
				users.setUserId(rs.getString("UserId"));
				users.setPassword(rs.getString("UserPassword"));
				users.setEmail(rs.getString("Email"));
				users.setUsername(rs.getString("UserName"));
				usersList.add(users);
			}

			return usersList;

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public Users getCurUserData(String id) {

		Users curUser = new Users();

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		ResultSet rs = null;
		try {

			logger.debug("userid:" + cur_user.getUserId());
			rs = lc.executeQuery("getCurrentUserData", params);
			if (rs.next()) {
				curUser.setUserId(rs.getString("UserId"));
				curUser.setUsername(rs.getString("UserName"));
				curUser.setPassword(rs.getString("UserPassword"));
				curUser.setEmail(rs.getString("Email"));
			}

			return curUser;

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public String getCurrentPassword(String id) {
		String pw = null;

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		ResultSet rs = null;
		try {

			logger.debug("userid:" + cur_user.getUserId());
			rs = lc.executeQuery("getCurrentPassword", params);
			if (rs.next()) {
				pw = rs.getString("UserPassword");
			}
			SqlUtils.close(rs);
			return pw;

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public void savePassword(String id, String pw) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("pw", pw);
		try {

			logger.debug("userid:" + cur_user.getUserId());
			lc.executeUpdate("savePassword", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public void saveEmail(String id, String pw) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("pw", pw);
		try {

			logger.debug("userid:" + cur_user.getUserId());
			lc.executeUpdate("saveEmail", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public void adduser(String name, String id, String pw, String email,
			int role) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		params.put("id", id);
		params.put("pw", pw);
		params.put("email", email);
		params.put("role", role);
		try {

			logger.debug("userid:" + cur_user.getUserId());
			lc.executeUpdate("adduser", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public void removeuser(String id) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		try {

			logger.debug("userid:" + cur_user.getUserId());
			lc.executeUpdate("removeuser", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public ArrayList<SelectItem> getRoleList() {

		ArrayList<SelectItem> roleList = new ArrayList<SelectItem>();
		ResultSet rs = null;
		try {

			logger.debug("userid:" + cur_user.getUserId());
			rs = lc.executeQuery("getRoleList", null);
			while (rs.next())
				roleList.add(new SelectItem(rs.getInt("RoleId"), rs
						.getString("RoleName")));
			return roleList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public void savePatient(Patient patient) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("workupId", patient.getWorkUpId());
		params.put("lcecid", patient.getLcecId());
		params.put("mrn", patient.getMrn());
		try {

			logger.debug("userid:" + cur_user.getUserId());
			lc.executeUpdate("savePatient", params);
		} catch (SQLException e) {
			logger.error(cur_user, e);
		} catch (Exception e) {

			logger.error(cur_user, e);
		} finally {

		}

	}

	@Override
	// public PatientListModel searchPatient(String input, boolean isMRN) {
	public List<Patient> searchPatient(String input, boolean isMRN) {

		List<Patient> patients = new ArrayList<Patient>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("input", input + "%");
		ResultSet rs = null;
		logger.debug("userid:" + cur_user.getUserId());
		try {

			if (isMRN)
				rs = lc.executeQuery("searchPatientByMRN", params);
			else
				rs = lc.executeQuery("searchPatientByName", params);

			while (rs.next())
				patients.add(new Patient(rs.getString("MRN"), rs
						.getString("Name (Last,First)"), rs
						.getString("Workup Status"), rs
						.getString("LCEC Status"), rs.getInt("WorkUpId"), rs
						.getInt("LCECId")));
			return patients;

		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getMDList() {

		ArrayList<SelectItem> mdList = new ArrayList<SelectItem>();
		ResultSet rs = null;
		logger.debug("userid:" + cur_user.getUserId());
		try {

			rs = lc.executeQuery("getMDList", null);
			while (rs.next())
				mdList.add(new SelectItem(rs.getString("Referring Physican")
						.toLowerCase(), rs.getString("Referring Physican")));
			return mdList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}
	
	public ArrayList<String> getRefMdListByName(String name) {

		ArrayList<String> mdList = new ArrayList<String>();
		ResultSet rs = null;
		HashMap<String, String> params = new HashMap<String, String> ();
		params.put("mdName", name+"%");
		logger.debug("userid:" + cur_user.getUserId());
		try {

			rs = lc.executeQuery("getRefMDListByName", params);
			while (rs.next())
				mdList.add(rs.getString("Referring Physican"));
			return mdList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}
	
	@Override
	public ArrayList<SelectItem> getInsuranceList() {

		ArrayList<SelectItem> insuranceList = new ArrayList<SelectItem>();
		ResultSet rs = null;
		logger.debug("userid:" + cur_user.getUserId());
		try {

			rs = lc.executeQuery("getInsuranceList", null);
			while (rs.next())
				insuranceList.add(new SelectItem(rs.getString("InsurCo")
						.toLowerCase(), rs.getString("InsurCo")));
			return insuranceList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getGenderList() {

		ArrayList<SelectItem> genderList = new ArrayList<SelectItem>();
		ResultSet rs = null;
		logger.debug("userid:" + cur_user.getUserId());
		try {

			rs = lc.executeQuery("getGenderList", null);
			while (rs.next())
				genderList.add(new SelectItem(rs.getString("GenderDefn")
						.toLowerCase(), rs.getString("GenderDefn")));
			return genderList;
		} catch (SQLException e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getWorkupList() {

		ArrayList<SelectItem> workupList = new ArrayList<SelectItem>();
		ResultSet rs = null;
		try {

			logger.debug("userid:" + cur_user.getUserId());
			rs = lc.executeQuery("getWorkupList", null);
			while (rs.next())
				workupList.add(new SelectItem(rs.getInt("WorkUpStatusNum"), rs
						.getString("WorkUpStatus")));
			return workupList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getLCECStatusList() {
		ArrayList<SelectItem> lcecStatusList = new ArrayList<SelectItem>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getLCECStatusList", null);
			while (rs.next())
				lcecStatusList.add(new SelectItem(rs.getInt("LCECId"), rs
						.getString("LCECStatus")));
			return lcecStatusList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getLesionClassificaitonList() {
		ArrayList<SelectItem> lesionClassificaitonList = new ArrayList<SelectItem>();
		lesionClassificaitonList.add(new SelectItem(-1, "")); //set empty------
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getLesionClassificaitonList", null);
			while (rs.next())
				lesionClassificaitonList.add(new SelectItem(rs.getInt("ID"), rs
						.getString("LesionClassification")));
			return lesionClassificaitonList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getBiopsyTypesList() {

		ArrayList<SelectItem> biopsyTypesList = new ArrayList<SelectItem>();
		biopsyTypesList.add(new SelectItem(-1, ""));  //set empty------
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getBiopsyTypesList", null);
			while (rs.next())
				biopsyTypesList.add(new SelectItem(rs.getInt("BiopsyNumber"),
						rs.getString("BiopsyType")));
			return biopsyTypesList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getBiopsyAccuracyList() {

		ResultSet rs = null;
		ArrayList<SelectItem> biopsyAccuracyList = new ArrayList<SelectItem>();

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getBiopsyAccuracyList", null);
			while (rs.next())
				biopsyAccuracyList.add(new SelectItem(rs
						.getString("Biopsy Accuracy"), rs
						.getString("Biopsy Accuracy")));
			return biopsyAccuracyList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getLesionDignosisList() {

		ArrayList<SelectItem> lesionDignosisList = new ArrayList<SelectItem>();
		lesionDignosisList.add(new SelectItem("", "")); //set empty-----
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getLesionDignosisList", null);
			while (rs.next())
				lesionDignosisList.add(new SelectItem(rs
						.getInt("LesionDiagnosisNumber"), rs
						.getString("LesionDiagnosis")));
			return lesionDignosisList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getResultDiagnosticList() {

		ArrayList<SelectItem> resultDiagnosticList = new ArrayList<SelectItem>();
		resultDiagnosticList.add(new SelectItem("", "")); //set empty------
		ResultSet rs = null; 
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getResultDiagnosticList", null);
			while (rs.next())
				resultDiagnosticList.add(new SelectItem(rs
						.getString("BiopsyResult"), rs
						.getString("BiopsyResult")));
			return resultDiagnosticList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getComplicationList() {

		ArrayList<SelectItem> complicationList = new ArrayList<SelectItem>();
		complicationList.add(new SelectItem("", "")); //set empty------
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getComplicationList", null);
			while (rs.next())
				complicationList.add(new SelectItem(rs
						.getString("Complication"), rs
						.getString("Complication")));
			return complicationList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getLcecPhysiciansList() {

		ArrayList<SelectItem> lcecPhysiciansList = new ArrayList<SelectItem>();
		lcecPhysiciansList.add(new SelectItem("", "")); //set empty------
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getLcecPhysiciansList", null);
			while (rs.next())
				lcecPhysiciansList.add(new SelectItem(rs
						.getString("LCEC - Physician"), rs
						.getString("LCEC - Physician")));
			return lcecPhysiciansList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getLocationList() {

		ArrayList<SelectItem> locationList = new ArrayList<SelectItem>();
		locationList.add(new SelectItem("", ""));  //set empty--------
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			// rs = lc.executeQuery("getLocationList", null);
			// while (rs.next())
			// locationList.add(new SelectItem(
			// rs.getString("Biopsy Location"), rs
			// .getString("Biopsy Location")));
			// locationList.add(new SelectItem(rs.getString("Biopsy Location"),
			// rs.getString("Biopsy Location")));
			locationList.add(new SelectItem("RUL", "RUL"));
			locationList.add(new SelectItem("RML", "RML"));
			locationList.add(new SelectItem("RLL", "RLL"));
			locationList.add(new SelectItem("R hilum", "R hilum"));
			locationList.add(new SelectItem("R bronchus", "R bronchus"));
			locationList.add(new SelectItem("LUL", "LUL"));
			locationList.add(new SelectItem("L lingula", "L lingula"));
			locationList.add(new SelectItem("LLL", "LLL"));
			locationList.add(new SelectItem("L hilum", "L hilum"));
			locationList.add(new SelectItem("L bronchus", "L bronchus"));
			locationList.add(new SelectItem("Carina", "Carina"));
			locationList.add(new SelectItem("Trachea", "Trachea"));
			locationList
					.add(new SelectItem("Bilateral Lung", "Bilateral Lung"));
			locationList.add(new SelectItem("Node R paratracheal",
					"Node R paratracheal"));
			locationList.add(new SelectItem("Node L paratracheal",
					"Node L paratracheal"));
			locationList.add(new SelectItem("Node Precarinal",
					"Node Precarinal"));
			locationList.add(new SelectItem("Node Subcarinal",
					"Node Subcarinal"));
			locationList.add(new SelectItem("Node Subsubcarinal",
					"Node Subsubcarinal"));
			locationList.add(new SelectItem("Node R upper hilum",
					"Node R upper hilum"));
			locationList.add(new SelectItem("Node R lower hilum",
					"Node R lower hilum"));
			locationList.add(new SelectItem("Node L hilum", "Node L hilum"));
			locationList
					.add(new SelectItem("Node AP window", "Node AP window"));
			locationList.add(new SelectItem("Mediastinum", "Mediastinum"));
			locationList.add(new SelectItem("Pleural - Right",
					"Pleural - Right"));
			locationList
					.add(new SelectItem("Pleural - Left", "Pleural - Left"));
			locationList.add(new SelectItem("Other N2 - Node",
					"Other N2 - Node"));
			locationList.add(new SelectItem("Other N3 - Node",
					"Other N3 - Node"));
			locationList.add(new SelectItem("Esophagus", "Esophagus"));
			locationList.add(new SelectItem("Thymus", "Thymus"));
			locationList
					.add(new SelectItem("Other Thoracic", "Other Thoracic"));
			locationList.add(new SelectItem("Other Extrathoracic",
					"Other Extrathoracic"));
			locationList.add(new SelectItem("Diaphragm", "Diaphragm"));

			return locationList;
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;

	}

	@Override
	public ArrayList<SelectItem> getVisittypeList() {
		ArrayList<SelectItem> visittypeList = new ArrayList<SelectItem>();
		visittypeList.add(new SelectItem(-1, "")); //set empty------
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getVisittypeList", null);
			while (rs.next())
				visittypeList.add(new SelectItem(rs.getInt("TypeNumber"), rs
						.getString("Visit Type")));
			return visittypeList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getSmokestatusList() {
		ArrayList<SelectItem> smokestatusList = new ArrayList<SelectItem>();
		smokestatusList.add(new SelectItem(-1, "")); //set empty------
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getSmokestatusList", null);
			while (rs.next())
				smokestatusList.add(new SelectItem(rs
						.getInt("SmokingStatusNum"), rs
						.getString("SmokingStatus")));
			return smokestatusList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getTestTypeList() {
		ArrayList<SelectItem> testList = new ArrayList<SelectItem>();
		testList.add(new SelectItem(-1, ""));  //set empty--------
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());
			/*
			 * rs = lc.executeQuery("getTestTypeList", null); while (rs.next())
			 * { if (!rs.getString("TestingType").startsWith("Blood - C") &&
			 * !rs.getString("TestingType").startsWith("Consult-") &&
			 * !rs.getString("TestingType").startsWith("Blood - H") &&
			 * !rs.getString("TestingType").startsWith("Blood - I") &&
			 * !rs.getString("TestingType").startsWith("Bone") &&
			 * !rs.getString("TestingType").startsWith( "Cardiac CABG") &&
			 * !rs.getString("TestingType").startsWith("Ch") &&
			 * !rs.getString("TestingType").startsWith("D") &&
			 * !rs.getString("TestingType").startsWith("E") &&
			 * !rs.getString("TestingType").startsWith("F") &&
			 * !rs.getString("TestingType").startsWith("MRA") &&
			 * !rs.getString("TestingType").startsWith("MRI - S") &&
			 * !rs.getString("TestingType").startsWith("MRI - T") &&
			 * !rs.getString("TestingType").startsWith("Pre") &&
			 * !rs.getString("TestingType").startsWith("U") &&
			 * !rs.getString("TestingType").startsWith("X")) { testList.add(new
			 * SelectItem(rs.getInt("Autonumber"), rs
			 * .getString("TestingType"))); } }
			 */
			// modify order
			testList.add(new SelectItem(100, "CT - Chest"));
			testList.add(new SelectItem(130, "CT chest super"));
			testList.add(new SelectItem(110, "CT Chest - contrast"));
			testList.add(new SelectItem(120, "CT chest 10W dose"));
			testList.add(new SelectItem(150, "CT - NonChest"));
			testList.add(new SelectItem(200, "PET"));
			testList.add(new SelectItem(600, "PFT"));
			testList.add(new SelectItem(610, "PFT-ABG"));
			testList.add(new SelectItem(700, "CPX"));
			testList.add(new SelectItem(400, "Cardiac Stress"));
			testList.add(new SelectItem(300, "Cardiac ECHO"));
			testList.add(new SelectItem(500, "Cardiac Cath"));
			testList.add(new SelectItem(800, "MRI Brain"));
			testList.add(new SelectItem(860, "MRI - Other"));
			testList.add(new SelectItem(1260, "Colonoscopy"));

			testList.add(new SelectItem(772, "Blood - Tumor Markers"));
			testList.add(new SelectItem(1300, "PPD"));
			testList.add(new SelectItem(1310, "Pulmonary Rehab"));
			testList.add(new SelectItem(790, "Sputum Micro"));
			testList.add(new SelectItem(1350, "Visit - Pleurx"));
			testList.add(new SelectItem(1360, "Visit - Stent"));
			testList.add(new SelectItem(1370, "Visit - Other"));

			testList.add(new SelectItem(1390, "Get Old Records"));
			testList.add(new SelectItem(1400, "Other"));

			return testList;
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getLesionCtCharacteristic() {
		ArrayList<SelectItem> characteristicList = new ArrayList<SelectItem>();
		characteristicList.add(new SelectItem("")); //set empty-----
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getLesionCtCharacteristic", null);
			while (rs.next()) {

				characteristicList.add(new SelectItem(rs
						.getString("CT Characteristic")));

			}
			return characteristicList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getTestResultListByType(int resultType) {

		ArrayList<SelectItem> testResultList = new ArrayList<SelectItem>();
		testResultList.add(new SelectItem(-1, "")); //set empty-------
		ResultSet rs = null;

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("testType", resultType);
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getTestResultListByType", params);

			while (rs.next()) {

				testResultList.add(new SelectItem(rs.getInt("AutoNum"), rs
						.getString("Result")));

			}
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return testResultList;
	}

	@Override
	public ArrayList<SelectItem> getResearchProjList() {
		ArrayList<SelectItem> researchProjList = new ArrayList<SelectItem>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getResearchProjList", null);
			while (rs.next())
				researchProjList.add(new SelectItem(rs
						.getInt("ResearchProjNum"), rs
						.getString("ReserachProject")));
			return researchProjList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getCancerTypeList() {
		ArrayList<SelectItem> cancerTypeList = new ArrayList<SelectItem>();
		cancerTypeList.add(new SelectItem(-1, ""));

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getCancerTypeList", null);
			while (rs.next())
				cancerTypeList.add(new SelectItem(rs.getInt("ID"), rs
						.getString("TypeOfCancer")));

		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return cancerTypeList;
	}

	@Override
	public ArrayList<SelectItem> getHistList() {
		ArrayList<SelectItem> histList = new ArrayList<SelectItem>();
		histList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getHistList", null);
			while (rs.next())
				histList.add(new SelectItem(rs.getString("Histology")));

		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return histList;
	}

	@Override
	public ArrayList<SelectItem> getStageTList() {
		ArrayList<SelectItem> stageTList = new ArrayList<SelectItem>();
		stageTList.add(new SelectItem(-1, ""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getStageTList", null);
			while (rs.next())
				stageTList.add(new SelectItem(rs.getInt("ID"), rs
						.getString("T - stage")));
			return stageTList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return stageTList;
	}

	@Override
	public ArrayList<SelectItem> getStageNList() {
		ArrayList<SelectItem> stageNList = new ArrayList<SelectItem>();
		stageNList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getStageNList", null);
			while (rs.next())
				stageNList.add(new SelectItem(rs.getString("N - stage")));

		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return stageNList;
	}

	@Override
	public ArrayList<SelectItem> getStageTNMList() {
		ArrayList<SelectItem> stageTNMList = new ArrayList<SelectItem>();
		stageTNMList.add(new SelectItem(-1, ""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getStageTNMList", null);
			while (rs.next())
				stageTNMList.add(new SelectItem(rs.getInt("ID"), rs
						.getString("Stage - TNM")));
			return stageTNMList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return stageTNMList;
	}

	@Override
	public ArrayList<SelectItem> getStageMList() {
		ArrayList<SelectItem> stageMList = new ArrayList<SelectItem>();
		stageMList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getStageMList", null);
			while (rs.next())
				stageMList.add(new SelectItem(rs.getString("M - stage")));
			return stageMList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return stageMList;
	}

	@Override
	public ArrayList<SelectItem> getCancerTxList() {
		ArrayList<SelectItem> cancerTxList = new ArrayList<SelectItem>();
		cancerTxList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getCancerTxList", null);
			while (rs.next())
				cancerTxList.add(new SelectItem(rs.getString("CancerTherapy")));
			return cancerTxList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return cancerTxList;
	}

	// medication list

	public ArrayList<SelectItem> getDoseUnitList() {
		ArrayList<SelectItem> doseUnitList = new ArrayList<SelectItem>();
		doseUnitList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getDoseList", null);
			while (rs.next())
				doseUnitList.add(new SelectItem(rs.getInt("DoseUnitID"), rs
						.getString("Dose Unit")));

		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return doseUnitList;
	}

	// not been yet used, coz no medicine names in the database
	public ArrayList<SelectItem> getMedicineNameList() {
		ArrayList<SelectItem> medicineNameList = new ArrayList<SelectItem>();
		medicineNameList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getMedicineNameList", null);
			while (rs.next())
				medicineNameList.add(new SelectItem(rs
						.getString("Medicine Name")));

		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return medicineNameList;
	}

	public ArrayList<SelectItem> getStrengthUnitList() {
		ArrayList<SelectItem> strengthUnitList = new ArrayList<SelectItem>();
		strengthUnitList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getStrengthList", null);
			while (rs.next())
				strengthUnitList.add(new SelectItem(
						rs.getInt("StrengthUnitID"), rs
								.getString("Strength Unit")));

		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return strengthUnitList;
	}

	public ArrayList<SelectItem> getHowTakenList() {
		ArrayList<SelectItem> howTakenList = new ArrayList<SelectItem>();
		howTakenList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getHowTakenList", null);
			while (rs.next())
				howTakenList.add(new SelectItem(rs.getInt("HowTakenID"), rs
						.getString("How Taken")));

		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return howTakenList;
	}

	public ArrayList<SelectItem> getGivenTypeList() {
		ArrayList<SelectItem> givenTypeList = new ArrayList<SelectItem>();
		givenTypeList.add(new SelectItem(""));
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getGivenTypeList", null);
			while (rs.next())
				givenTypeList.add(new SelectItem(rs.getInt("GivenTypeID"), rs
						.getString("Given Type")));
			return givenTypeList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return givenTypeList;
	}

	// medication list end

	@Override
	public PatientDataModel getPatientData(Patient patient) {
		PatientDataModel patientData = new PatientDataModel(patient);
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getPatientData", params);
			if (rs.next()) {
				// `WorkUpId`, `Workup Status`,`LCECId`, `LCEC Status`
				patientData.setWorkUpId(rs.getInt("WorkUpId"));
				patientData.setWorkupStatus(rs.getString("Workup Status"));
				patientData.setLcecId(rs.getInt("LCECId"));
				patientData.setLcecStatus(rs.getString("LCEC Status"));

				// `Gender`, `SocSecNumber`, `Date Of Birth`,
				patientData.setGender(rs.getString("Gender") != null ? rs
						.getString("Gender").toLowerCase() : null);
				patientData.setSsn(rs.getString("SocSecNumber"));
				patientData.setDob(rs.getDate("Date Of Birth"));

				// `Address`, `City`, `StateOrProvince`, `PostalCode`,
				// `PhoneNumber`, `Alternative Phone`, `EmailAddress`,
				patientData.setAddress(rs.getString("Address"));
				patientData.setCity(rs.getString("City"));
				patientData.setState(rs.getString("StateOrProvince"));
				patientData.setPincode(rs.getString("PostalCode"));
				patientData.setPhoneNum(rs.getString("PhoneNumber"));
				patientData.setAltPhoneNum(rs.getString("Alternative Phone"));
				patientData.setEmail(rs.getString("EmailAddress"));

				// `Insurance`, `InsuranceID`, `InsurancePhone`, `InsurComment`,
				patientData
						.setInsuranceCompany(rs.getString("Insurance") != null ? rs
								.getString("Insurance").toLowerCase() : null);
				patientData.setInsuranceId(rs.getString("InsuranceID"));
				patientData
						.setInsurancePhoneNum(rs.getString("InsurancePhone"));
				patientData.setInsuranceComment(rs.getString("InsurComment"));

				// `Date of Referral`, `Referring MD`, `Primary Care Physician`,
				// `Additional MD`,
				patientData.setReferralDate(rs.getDate("Date of Referral"));
				patientData
						.setReferringMD(rs.getString("Referring MD") != null ? rs
								.getString("Referring MD").toLowerCase() : null);
				patientData.setPrimaryCare(rs
						.getString("Primary Care Physician") != null ? rs
						.getString("Primary Care Physician").toLowerCase()
						: null);
				patientData.setAdditionalMD(rs.getString("Additional MD"));

				// `LCEC Chart`, `InactiveDate`, `SchedFUwithMD`
				patientData.setLcecChart(rs.getBoolean("LCEC Chart"));
				patientData.setInactiveDate(rs.getDate("InactiveDate"));
				patientData.setScheduledMD(rs.getBoolean("SchedFUwithMD"));

				// `CT`, `PET`, `PFT`
				patientData.setCT(rs.getString("CT Precert"));
				patientData.setPET(rs.getString("PET Precert"));
				patientData.setPFT(rs.getString("PFT Precert"));

			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return patientData;
	}

	@Override
	public ArrayList<PatientDataModel> getPatiendQueryData() {

		ArrayList<PatientDataModel> patientList = new ArrayList<PatientDataModel>();
		Map<String, String> params = new HashMap<String, String>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getAllPatientData", params);

			while (rs.next()) {
				PatientDataModel patientData = new PatientDataModel();

				patientData.setMrn(rs.getString("MRN"));
				patientData.setName(rs.getString("Name (Last,First)"));
				patientData.setWorkupStatus(rs.getString("Workup Status"));

				patientData.setLcecStatus(rs.getString("LCEC Status"));
				patientData.setReferralDate(rs.getDate("Date of Referral"));
				patientData
						.setReferringMD(rs.getString("Referring MD") != null ? rs
								.getString("Referring MD").toLowerCase() : null);
				patientData.setPrimaryCare(rs
						.getString("Primary Care Physician") != null ? rs
						.getString("Primary Care Physician").toLowerCase()
						: null);

				patientList.add(patientData);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return patientList;
	}

	@Override
	public ArrayList<TestingReportEntry> getPatientTestingData() {

		ArrayList<TestingReportEntry> patientTestList = new ArrayList<TestingReportEntry>();
		Map<String, String> params = new HashMap<String, String>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getAllPatientTestingData", params);

			while (rs.next()) {
				TestingReportEntry patientTestingData = new TestingReportEntry();

				patientTestingData.setMrn(rs.getString("MRN"));
				patientTestingData.setName(rs.getString("Name (Last,First)"));
				patientTestingData.setWorkupStatus(rs
						.getString("Workup Status"));
				patientTestingData.setLcecStatus(rs.getString("LCEC Status"));
				patientTestingData.setWorkUpId(rs.getInt("WorkUpId"));
				patientTestingData.setLcecId(rs.getInt("LCECId"));

				patientTestingData.setID(rs.getInt("ID"));
				patientTestingData.setRequiredDate(rs.getDate("RequiredDate"));
				patientTestingData.setTestingDate(rs.getDate("TestingDate"));
				patientTestingData.setTestType(rs.getInt("TestType"));
				patientTestingData.setTestTypeName(rs.getString("TestingType"));
				patientTestingData.setComment(rs.getString("Comment"));
				patientTestingData.setMRN(rs.getString("MRN"));
				patientTestingData.setOrderByLCEC(rs
						.getBoolean("OrderedByLCEC"));

				patientTestList.add(patientTestingData);
			}
			return patientTestList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return patientTestList;
	}

	@Override
	public void savePatientData(PatientDataModel patientData) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", patientData.getName());
		params.put("mrn", patientData.getMrn());
		params.put("gender", patientData.getGender());
		params.put("ssn", patientData.getSsn());
		params.put("dob", patientData.getDob());
		params.put("address", patientData.getAddress());
		params.put("city", patientData.getCity());
		params.put("state", patientData.getState());
		params.put("postcode", patientData.getPincode());
		params.put("phonenum", patientData.getPhoneNum());
		params.put("altphnum", patientData.getAltPhoneNum());
		params.put("email", patientData.getEmail());
		params.put("insurance", patientData.getInsuranceCompany());
		params.put("insuranceid", patientData.getInsuranceId());
		params.put("insuranceph", patientData.getInsurancePhoneNum());
		params.put("insurancecomment", patientData.getInsuranceComment());
		params.put("dateofref", patientData.getReferralDate());
		params.put("refMD", patientData.getReferringMD());
		params.put("primaryCare", patientData.getPrimaryCare());
		params.put("addMD", patientData.getAdditionalMD());
		params.put("workupId", patientData.getWorkUpId());
		params.put("lcecid", patientData.getLcecId());
		params.put("lcecChart", patientData.getLcecChart());
		params.put("inactivedate", patientData.getInactiveDate());
		params.put("schedfuwithMD", patientData.getScheduledMD());
		params.put("CT", patientData.getCT());
		params.put("PFT", patientData.getPFT());
		params.put("PET", patientData.getPET());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("savePatientData", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}


	@Override
	public void savePatientDataNewMrn(PatientDataModel patientData) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", patientData.getName());
		params.put("mrn", patientData.getMrn());
		params.put("oldmrn", patientData.getOldMrn());
		params.put("gender", patientData.getGender());
		params.put("ssn", patientData.getSsn());
		params.put("dob", patientData.getDob());
		params.put("address", patientData.getAddress());
		params.put("city", patientData.getCity());
		params.put("state", patientData.getState());
		params.put("postcode", patientData.getPincode());
		params.put("phonenum", patientData.getPhoneNum());
		params.put("altphnum", patientData.getAltPhoneNum());
		params.put("email", patientData.getEmail());
		params.put("insurance", patientData.getInsuranceCompany());
		params.put("insuranceid", patientData.getInsuranceId());
		params.put("insuranceph", patientData.getInsurancePhoneNum());
		params.put("insurancecomment", patientData.getInsuranceComment());
		params.put("dateofref", patientData.getReferralDate());
		params.put("refMD", patientData.getReferringMD());
		params.put("primaryCare", patientData.getPrimaryCare());
		params.put("addMD", patientData.getAdditionalMD());
		params.put("workupId", patientData.getWorkUpId());
		params.put("lcecid", patientData.getLcecId());
		params.put("lcecChart", patientData.getLcecChart());
		params.put("inactivedate", patientData.getInactiveDate());
		params.put("schedfuwithMD", patientData.getScheduledMD());
		params.put("CT", patientData.getCT());
		params.put("PFT", patientData.getPFT());
		params.put("PET", patientData.getPET());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("savePatientDataNewMrn", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
		updateTablesWithMRN(patientData.getOldMrn(), patientData.getMrn());
	}
	
	//Added by Nikhil: updateTablesWithMRN
	
	long mrnLastUpdate = 0;
	
	void updateTablesWithMRN(String oldMrn, String newMrn){
		/* 	The calling function that invokes this function is called multiple times for the same update,
		 	prevent updates to MRN for 5 seconds so that all the tables are not re-written for the same MRN
		 */
		if (System.currentTimeMillis() - mrnLastUpdate < 5 * 1000)
			return;
		// Begin Update
		ResultSet rs = null;
		String sql;
		Statement st=null;
		Map <String, String> tableMrnColumns = new HashMap<String, String> ();
		// Get all the tables that have an MRN column
		try {
			st = dbConnection.createStatement();
			sql = "select TABLE_NAME, COLUMN_NAME " +
						"from information_schema.COLUMNS " + 
						"where TABLE_SCHEMA='test' " + 
						"and COLUMN_NAME like '%MRN%' ";
			rs = st.executeQuery(sql);
			while (rs.next()){
				tableMrnColumns.put(rs.getString("TABLE_NAME"), rs.getString("COLUMN_NAME"));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		// Remove the tables from the map which should not be updated
		tableMrnColumns.remove("dummymrn");
		tableMrnColumns.remove("patient");
		tableMrnColumns.remove("qrysurgeryperpatient");
		tableMrnColumns.remove("qrycancersperpatient");
		tableMrnColumns.remove("qryprocedureperpatient");
		// Update the MRN columns to the new MRN
		try {
			st = dbConnection.createStatement();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		for (String tableName: tableMrnColumns.keySet()){
			sql = "update `" + tableName + "` set " + tableMrnColumns.get(tableName) + " = "
					+newMrn +" where " +tableMrnColumns.get(tableName) + " = " + oldMrn;
			
			try{
				st.executeUpdate(sql);
			}catch (SQLException e){
				logger.error(e.getMessage(), e);
				
			}
		}

		mrnLastUpdate = System.currentTimeMillis();
	}
	
	// Added by rjosan : Create Patient

	@Override
	public void createPatient(PatientDataModel patientData) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mrn", patientData.getMrn());
		params.put("gender", patientData.getGender());
		params.put("ssn", patientData.getSsn());
		params.put("dob", patientData.getDob());
		params.put("address", patientData.getAddress());
		params.put("city", patientData.getCity());
		params.put("state", patientData.getState());
		params.put("postcode", patientData.getPincode());
		params.put("phonenum", patientData.getPhoneNum());
		params.put("altphnum", patientData.getAltPhoneNum());
		params.put("email", patientData.getEmail());
		params.put("insurance", patientData.getInsuranceCompany());
		params.put("insuranceid", patientData.getInsuranceId());
		params.put("insuranceph", patientData.getInsurancePhoneNum());
		params.put("insurancecomment", patientData.getInsuranceComment());
		params.put("dateofref", patientData.getReferralDate());
		params.put("refMD", patientData.getReferringMD());
		params.put("primaryCare", patientData.getPrimaryCare());
		params.put("addMD", patientData.getAdditionalMD());

		params.put("workupId", patientData.getWorkUpId());

		params.put("lcecid", patientData.getLcecId());
		params.put("lcecChart", patientData.getLcecChart());
		params.put("inactivedate", patientData.getInactiveDate());
		params.put("schedfuwithMD", patientData.getScheduledMD());
		// New Additions by rjosan
		params.put("name", patientData.getName());
		params.put("referralVisit", patientData.getReferralVisit());
		// params.put("insurancePh", patientData.getInsurancePh());
		params.put("secInsurance", patientData.getSecInsurance());
		params.put("secInsuranceID", patientData.getSecInsuranceID());

		params.put("CT", patientData.getCT());
		params.put("PET", patientData.getPET());
		params.put("PFT", patientData.getPFT());
		// End of new additions

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("createPatient", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	// End of addition by rjosan

	// Added by sun
	public void deletePatient(Patient patient) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mrn", patient.getMrn());
		params.put("name", patient.getName());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("deletePatient", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public ArrayList<SurBiopsyReportEntry> getSurBiopsyReport() {
		ArrayList<SurBiopsyReportEntry> surBiopsyReport = new ArrayList<SurBiopsyReportEntry>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getSurBiopsyReport", null);

			while (rs.next()) {
				SurBiopsyReportEntry reportEntry = new SurBiopsyReportEntry();
				reportEntry.setMrn(rs.getString("MRN"));
				reportEntry.setName(rs.getString("Name (Last,First)"));
				reportEntry.setWorkupStatus(rs.getString("Workup Status"));
				reportEntry.setLcecStatus(rs.getString("LCEC Status"));
				reportEntry.setWorkUpId(rs.getInt("WorkUpId"));
				reportEntry.setLcecId(rs.getInt("LCECId"));
				reportEntry.setProcedureName(rs.getString("ProcedureName"));
				reportEntry.setScheduleDate(rs.getDate("ScheduleDate"));
				reportEntry.setProcedureDate(rs.getDate("ProcedureDate"));
				reportEntry.setPerformedBy(rs.getString("PerformedBy"));
				reportEntry.setBiopsyLocation(rs
						.getString("BiopsyLocationCode"));
				reportEntry.setLocationComment(rs.getString("LocationComment"));
				reportEntry.setComment(rs.getString("Complication"));
				reportEntry.setBiopsyResult(rs.getString("Biopsy Result"));
				reportEntry.setDiagnostic(rs.getString("Result-Diagnostic"));
				reportEntry.setAccuracy(rs.getString("BiopsyAccuracy"));
				reportEntry.setComment(rs.getString("Comment"));
				surBiopsyReport.add(reportEntry);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return surBiopsyReport;
	}

	@Override
	public SurBiopsyDataModel getSurBiopsyData(Patient patient) {
		SurBiopsyDataModel surBiopsyData = new SurBiopsyDataModel(patient);
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getPatientMedicineData", params);
			if (rs.next()) {
				// `Aspirin`, `Plavix`, `Coumadin`, `OtherAntiCoag`,
				// `MedicationList`
				surBiopsyData.setWorkUpId(rs.getInt("WorkUpId"));
				surBiopsyData.setWorkupStatus(rs.getString("Workup Status"));
				surBiopsyData.setLcecId(rs.getInt("LCECId"));
				surBiopsyData.setLcecStatus(rs.getString("LCEC Status"));
				surBiopsyData.setAspirin(rs.getBoolean("Aspirin"));
				surBiopsyData.setPlavix(rs.getBoolean("Plavix"));
				surBiopsyData.setCoumadin(rs.getBoolean("Coumadin"));
				surBiopsyData.setOtheranticoag(rs.getBoolean("OtherAntiCoag"));
				surBiopsyData.setMedicationlist(rs.getString("MedicationList"));
			}
			SqlUtils.close(rs);

			rs = lc.executeQuery("getPatientLesionData", params);
			ArrayList<PatientLesion> lesionList = new ArrayList<PatientLesion>();
			while (rs.next()) {
				PatientLesion patientLesion = new PatientLesion();
				patientLesion.setLesionId(rs.getInt("LesionID"));
				patientLesion.setLesionDate(rs.getDate("Date1stFollowedLCEC"));
				patientLesion
						.setLesionClassificationId(rs.getInt("LesClassId"));
				patientLesion.setLeasionClassification(rs
						.getString("LesionClassification"));
				patientLesion.setLocation(rs.getString("Location"));
				lesionList.add(patientLesion);
			}
			surBiopsyData.setLesionList(lesionList);
			SqlUtils.close(rs);
			surBiopsyData.setBiopsyList(getBiopsyList(patient.getMrn()));
			return surBiopsyData;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return surBiopsyData;
	}

	@Override
	public void saveSurBiopsyData(SurBiopsyDataModel surBiopsyData) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("Aspirin", surBiopsyData.isAspirin());
		params.put("Coumadin", surBiopsyData.isCoumadin());
		params.put("Plavix", surBiopsyData.isPlavix());
		params.put("OtherAntiCoag", surBiopsyData.isOtheranticoag());
		params.put("MedicationList", surBiopsyData.getMedicationlist());
		params.put("workupId", surBiopsyData.getWorkUpId());
		params.put("lcecid", surBiopsyData.getLcecId());
		params.put("mrn", surBiopsyData.getMrn());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("savePatientMedicineData", params);
			for (Biopsy biopsy : surBiopsyData.getBiopsyList()) {
				this.addSurBiopsy(surBiopsyData.getMrn(), biopsy);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	// Added by utpal
	public void saveBiopsyData(Biopsy b, String mrn) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ProcedureType", b.getProcedureTypeId());
		params.put("ScheduleDate", b.getScheduleDate());
		params.put("ProcedureDate", b.getProcedureName());
		params.put("PerformedBy", b.getPerformedBy());
		params.put("BiopsyLocationCode", b.getBiopsyLocation());
		params.put("LocationComment", b.getLocationComment());
		params.put("Complication", b.getComplication());
		params.put("Result-Diagnostic", b.getDiagnostic());
		params.put("BiopsyAccuracy", b.getAccuracy());
		params.put("Comment", b.getComment());
		params.put("AutoNum", b.getAutoNum());
		params.put("Biopsy Result", b.getBiopsyResult());
		params.put("mrn", mrn);

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("updateBiopsyData", params);

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	// Added by Utpal
	public void deleteBiopsyData(Biopsy b) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("AutoNum", b.getAutoNum());
		// System.out.println("b.getAutoNum() = " + b.getAutoNum());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("deleteBiopsyData", params);

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}

	}

	public ArrayList<Biopsy> getBiopsyList(String mrn) {
		ArrayList<Biopsy> biopsyList = new ArrayList<Biopsy>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", mrn);
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getSurBiopsyData", params);
			while (rs.next()) {
				Biopsy biopsy = new Biopsy();
				biopsy.setProcedureTypeId(rs.getInt("ProcedureType"));
				biopsy.setScheduleDate(rs.getDate("ScheduleDate"));
				biopsy.setProcedureDate(rs.getDate("ProcedureDate"));
				biopsy.setPerformedBy(rs.getString("PerformedBy"));
				biopsy.setBiopsyLocation(rs.getString("BiopsyLocationCode"));
				biopsy.setLocationComment(rs.getString("LocationComment"));
				biopsy.setComment(rs.getString("Complication"));
				biopsy.setBiopsyResult(rs.getString("Biopsy Result"));
				biopsy.setDiagnostic(rs.getString("Result-Diagnostic"));
				biopsy.setAccuracy(rs.getString("BiopsyAccuracy"));
				biopsy.setComment(rs.getString("Comment"));
				biopsy.setAutoNum(rs.getInt("AutoNum"));
				biopsyList.add(biopsy);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return biopsyList;
	}

	@Override
	public void addSurBiopsy(String mrn, Biopsy biopsy) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mrn", mrn);
		params.put("ProcedureType", biopsy.getProcedureTypeId());
		params.put("ScheduleDate", biopsy.getScheduleDate());
		params.put("ProcedureDate", biopsy.getProcedureDate());
		params.put("PerformedBy", biopsy.getPerformedBy());
		params.put("BiopsyLocationCode", biopsy.getBiopsyLocation());
		params.put("LocationComment", biopsy.getLocationComment());
		params.put("Complication", biopsy.getComplication());
		params.put("Biopsy Result", biopsy.getBiopsyResult());
		params.put("Result-Diagnostic", biopsy.getDiagnostic());
		params.put("BiopsyAccuracy", biopsy.getAccuracy());
		params.put("Comment", biopsy.getComment());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			if (biopsy.getAutoNum() == -1)
				lc.executeUpdate("addBiopsyData", params);
			else {
				params.put("AutoNum", biopsy.getAutoNum());
				lc.executeUpdate("updateBiopsyData", params);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public PatientVisitsModel getVisitData(Patient patient) {
		PatientVisitsModel visitData = new PatientVisitsModel(patient);

		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getPatientLesionData", params);
			ArrayList<PatientLesion> lesionList = new ArrayList<PatientLesion>();
			while (rs.next()) {
				PatientLesion patientLesion = new PatientLesion();
				patientLesion.setLesionId(rs.getInt("LesionID"));
				patientLesion.setLesionDate(rs.getDate("Date1stFollowedLCEC"));
				patientLesion
						.setLesionClassificationId(rs.getInt("LesClassId"));
				patientLesion.setLeasionClassification(rs
						.getString("LesionClassification"));
				patientLesion.setLocation(rs.getString("Location"));
				lesionList.add(patientLesion);
			}
			visitData.setLesionList(lesionList);
			SqlUtils.close(rs);

			rs = lc.executeQuery("getVisitData", params);
			ArrayList<Visit> visitList = new ArrayList<Visit>();
			while (rs.next()) {
				Visit visit = new Visit();
				visit.setRequiredDate(rs.getDate("Date Required"));
				visit.setScheduledDate(rs.getDate("Date Scheduled"));
				visit.setActualVisitDate(rs.getDate("Date of Actual Visit"));
				visit.setTypeOfVisit(rs.getInt("Type of Visit"));
				visit.setPrimaryMD(rs.getString("To see/Seen by"));
				visit.setScheduledToSee2(rs.getString("Seen by 2"));
				visit.setScheduledToSee3(rs.getString("Seen by 3"));
				visit.setTobaccoStatus(rs.getInt("SmokerStatus"));
				visit.setReferralNeeded(rs.getBoolean("ReferralNeeded"));
				visit.setReferral(rs.getString("ReferralNumber"));
				visit.setHandledByPhone(rs.getBoolean("PhoneCall"));
				visit.setCounselled(rs.getBoolean("SmokerCounselled"));
				visit.setRefused(rs.getBoolean("Refused"));
				visit.setPlan(rs.getString("Plan decided at visit"));
				visit.setComment(rs.getString("Comment"));
				visit.setID(rs.getInt("ID"));
				visitList.add(visit);
			}
			visitData.setVisitList(visitList);
			SqlUtils.close(rs);

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return visitData;
	}

	@Override
	public void saveVisitData(PatientVisitsModel VisitData) {
		for (Visit visit : VisitData.getVisitList()) {
			this.addVisit(VisitData.getMrn(), visit);
		}
	}

	@Override
	public CancerInfoModel getCancerData(Patient patient) {
		CancerInfoModel cancerinfo = new CancerInfoModel(patient);
		Map<String, String> params = new HashMap<String, String>();
		// System.out.println(cancerinfo.getMrn());
		params.put("mrn", patient.getMrn());
		// System.out.println(patient.getMrn());
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getCancerData", params);
			while (rs.next()) {

				cancerinfo.setInactiveDate(rs.getDate("InactiveDate"));
				cancerinfo.setlCECChart(rs.getBoolean("LCEC Chart"));

				cancerinfo.setClinical_T(rs.getInt("Stage - T Clinical"));
				cancerinfo.setPathological_T(rs.getInt("Stage - T Pathologic"));
				cancerinfo.setPostNeo_T(rs.getInt("Stage - T Restage"));
				cancerinfo.setClinical_N(rs.getString("Stage - N Clinical"));
				cancerinfo.setPathological_N(rs
						.getString("Stage - N Pathologic"));
				cancerinfo.setPostNeo_N(rs.getString("Stage - N Restage"));
				cancerinfo.setClinical_M(rs.getString("Stage - M Clinical"));
				cancerinfo.setPathological_M(rs
						.getString("Stage - M Pathologic"));
				cancerinfo.setPostNeo_M(rs.getString("Stage - M Restage"));
				cancerinfo.setClinical_TNM(rs.getInt("Stage - TNM Clinical"));
				cancerinfo.setPathological_TNM(rs
						.getInt("Stage - TNM Pathologic"));
				cancerinfo.setPostNeo_TNM(rs.getInt("Stage - TNM Restage"));

				cancerinfo.setStatus_1year(rs.getString("Status 1 year"));
				cancerinfo.setStatus_2year(rs.getString("Status 2 year"));
				cancerinfo.setStatus_3year(rs.getString("Status 3 year"));
				cancerinfo.setStatus_4year(rs.getString("Status 4 year"));
				cancerinfo.setStatus_5year(rs.getString("Status 5 year"));

				cancerinfo.setComment1(rs.getString("CancerTypeComment"));

				cancerinfo.setRelapseDate(rs.getDate("Date 1st relapse"));
				cancerinfo
						.setDiagnosisDate(rs.getDate("Date of 1st Diagnosis"));
				cancerinfo.setStagingDate(rs.getDate("Date of Final Staging"));
				cancerinfo.setTumorDate(rs.getDate("Date of Tumor Board"));

				cancerinfo.setComment(rs.getString("Comment"));
				cancerinfo.setCancerType(rs.getInt("CancerType"));
				cancerinfo
						.setHistology(rs.getString("CancerHisto") != null ? rs
								.getString("CancerHisto") : "");

				cancerinfo
						.setNaChemoStatus(rs.getString("NeoChemoPlan") != null ? rs
								.getString("NeoChemoPlan") : "");
				cancerinfo.setNartStatus(rs.getString("NeoRTPlan") != null ? rs
						.getString("NeoRTPlan") : "");
				cancerinfo
						.setSbrtStatus(rs.getString("SurgeryPlan") != null ? rs
								.getString("SurgeryPlan") : "");
				cancerinfo
						.setChemotherapyStatus(rs.getString("ChemoPlan") != null ? rs
								.getString("ChemoPlan") : "");
				cancerinfo
						.setRadtherapyStatus(rs.getString("RTPlan") != null ? rs
								.getString("RTPlan") : "");

				cancerinfo.setNaChemoMD(rs.getString("NeoChemoMD") != null ? rs
						.getString("NeoChemoMD").toLowerCase() : "");
				cancerinfo.setNartMD(rs.getString("NeoRTMD") != null ? rs
						.getString("NeoRTMD").toLowerCase() : "");
				// System.out.println(rs.getString("SurgeryMD"));
				cancerinfo.setSbrtMD(rs.getString("SurgeryMD") != null ? rs
						.getString("SurgeryMD").toLowerCase() : "");
				// System.out.println(rs.getString("ChemoMD"));
				cancerinfo
						.setChemotherapyMD(rs.getString("ChemoMD") != null ? rs
								.getString("ChemoMD").toLowerCase() : "");
				cancerinfo.setRadtherapyMD(rs.getString("RTMD") != null ? rs
						.getString("RTMD").toLowerCase() : "");

				cancerinfo.setNaChemoDate(rs.getDate("NeoChemoEndDate"));
				cancerinfo.setNartDate(rs.getDate("NeoRTEndDate"));
				cancerinfo.setSbrtDate(rs.getDate("SurgeryDate"));
				cancerinfo.setChemotherapyDate(rs.getDate("ChemoEndDate"));
				cancerinfo.setRadtherapyDate(rs.getDate("RTEndDate"));

				return cancerinfo;
			}
			SqlUtils.close(rs);
		} catch (SQLException e) {
			logger.error(e, e);
			return null;
		} catch (Exception e) {

			logger.error(e, e);
			return null;
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public void saveCancerData(CancerInfoModel cancerInfoData, boolean add,
			String mrn) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mrn", mrn);
		params.put("diagnosisDate", cancerInfoData.getDiagnosisDate());
		params.put("stagingDate", cancerInfoData.getStagingDate());
		params.put("tumorDate", cancerInfoData.getTumorDate());
		params.put("cancerType", cancerInfoData.getCancerType());
		params.put("histology", cancerInfoData.getHistology());
		params.put("comment", cancerInfoData.getComment());
		params.put("clinical_T", cancerInfoData.getClinical_T());
		params.put("pathological_T", cancerInfoData.getPathological_T());
		params.put("postNeo_T", cancerInfoData.getPostNeo_T());
		params.put("clinical_N", cancerInfoData.getClinical_N());
		params.put("pathological_N", cancerInfoData.getPathological_N());
		params.put("postNeo_N", cancerInfoData.getPostNeo_N());
		params.put("clinical_M", cancerInfoData.getClinical_M());
		params.put("pathological_M", cancerInfoData.getPathological_M());
		params.put("postNeo_M", cancerInfoData.getPostNeo_M());
		params.put("clinical_TNM", cancerInfoData.getClinical_TNM());
		params.put("pathological_TNM", cancerInfoData.getPathological_TNM());
		params.put("postNeo_TNM", cancerInfoData.getPostNeo_TNM());
		params.put("status_1year", cancerInfoData.getStatus_1year());
		params.put("status_2year", cancerInfoData.getStatus_2year());
		params.put("status_3year", cancerInfoData.getStatus_3year());
		params.put("status_4year", cancerInfoData.getStatus_4year());
		params.put("status_5year", cancerInfoData.getStatus_5year());
		params.put("comment1", cancerInfoData.getComment1());
		params.put("relapseDate", cancerInfoData.getRelapseDate());
		params.put("nAChemoStatus", cancerInfoData.getNaChemoStatus());
		params.put("nARTStatus", cancerInfoData.getNartStatus());
		params.put("sBRTStatus", cancerInfoData.getSbrtStatus());
		params.put("chemotherapyStatus", cancerInfoData.getChemotherapyStatus());
		params.put("radtherapyStatus", cancerInfoData.getRadtherapyStatus());
		params.put("nAChemoMD", cancerInfoData.getNaChemoMD());
		params.put("nARTMD", cancerInfoData.getNartMD());
		params.put("sBRTMD", cancerInfoData.getSbrtMD());
		params.put("chemotherapyMD", cancerInfoData.getChemotherapyMD());
		params.put("radtherapyMD", cancerInfoData.getRadtherapyMD());
		params.put("nAChemoDate", cancerInfoData.getNaChemoDate());
		params.put("nARTDate", cancerInfoData.getNartDate());
		params.put("sBRTDate", cancerInfoData.getSbrtDate());
		params.put("chemotherapyDate", cancerInfoData.getChemotherapyDate());
		params.put("radtherapyDate", cancerInfoData.getRadtherapyDate());
		try {
			logger.debug("userid:" + cur_user.getUserId());
			if (add == false)
				lc.executeUpdate("saveCancerData", params);
			else
				lc.executeUpdate("addCancerData", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	public ArrayList<Visit> getVisitList(String mrn) {
		ArrayList<Visit> visitList = new ArrayList<Visit>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", mrn);
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getVisitData", params);
			while (rs.next()) {
				Visit visit = new Visit();
				visit.setRequiredDate(rs.getDate("Date Required"));
				visit.setScheduledDate(rs.getDate("Date Scheduled"));
				visit.setActualVisitDate(rs.getDate("Date of Actual Visit"));
				visit.setTypeOfVisit(rs.getInt("Type of Visit"));
				visit.setPrimaryMD(rs.getString("To see/Seen by"));
				visit.setScheduledToSee2(rs.getString("Seen by 2"));
				visit.setScheduledToSee3(rs.getString("Seen by 3"));
				visit.setTobaccoStatus(rs.getInt("SmokerStatus"));
				visit.setReferralNeeded(rs.getBoolean("ReferralNeeded"));
				visit.setReferral(rs.getString("ReferralNumber"));
				visit.setHandledByPhone(rs.getBoolean("PhoneCall"));
				visit.setCounselled(rs.getBoolean("SmokerCounselled"));
				visit.setRefused(rs.getBoolean("Refused"));
				visit.setPlan(rs.getString("Plan decided at visit"));
				visit.setComment(rs.getString("Comment"));
				visit.setID(rs.getInt("ID"));
				visitList.add(visit);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return visitList;
	}

	public void addVisit(String mrn, Visit visit) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("mrn", mrn);
		params.put("RequiredDate", visit.getRequiredDate());
		params.put("ScheduledDate", visit.getScheduledDate());
		params.put("ActualVisitDate", visit.getActualVisitDate());
		params.put("TypeOfVisit", visit.getTypeOfVisit());
		params.put("PrimaryMD", visit.getPrimaryMD());
		params.put("ScheduledToSee2", visit.getScheduledToSee2());
		params.put("ScheduledToSee3", visit.getScheduledToSee3());
		params.put("TobaccoStatus", visit.getTobaccoStatus());
		params.put("ReferralNeeded", visit.getReferralNeeded());
		params.put("Referral", visit.getReferral());
		params.put("HandledByPhone", visit.getHandledByPhone());
		params.put("Counselled", visit.getCounselled());
		params.put("Refused", visit.getRefused());
		params.put("Plan", visit.getPlan());
		params.put("Comment", visit.getComment());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			if (visit.getID() == -1)
				lc.executeUpdate("addVisitData", params);
			else {
				params.put("ID", visit.getID());
				lc.executeUpdate("updateVisitData", params);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public PatientTestingDataModel getTestData(Patient patient) {
		PatientTestingDataModel testData = new PatientTestingDataModel(patient);
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getPatientLesionData", params);
			ArrayList<PatientLesion> lesionList = new ArrayList<PatientLesion>();
			while (rs.next()) {
				PatientLesion patientLesion = new PatientLesion();
				patientLesion.setLesionId(rs.getInt("LesionID"));
				patientLesion.setLesionDate(rs.getDate("Date1stFollowedLCEC"));
				patientLesion
						.setLesionClassificationId(rs.getInt("LesClassId"));
				patientLesion.setLeasionClassification(rs
						.getString("LesionClassification"));
				patientLesion.setLocation(rs.getString("Location"));
				lesionList.add(patientLesion);
			}
			testData.setLesionList(lesionList);
			SqlUtils.close(rs);

			rs = lc.executeQuery("getTestData", params);
			ArrayList<PatientTesting> testList = new ArrayList<PatientTesting>();
			while (rs.next()) {
				PatientTesting temp = new PatientTesting();
				temp.setID(rs.getInt("ID"));
				temp.setTestType(rs.getInt("TestType"));
				temp.setRequiredDate(rs.getDate("RequiredDate"));
				temp.setScheduledDate(rs.getDate("ScheduleDate"));
				temp.setTestingDate(rs.getDate("TestingDate"));
				temp.setComment(rs.getString("Comment"));
				temp.setPrecertNumber(rs.getString("PrecertNumber"));
				temp.setTestingResult(rs.getInt("TestingResult"));
				temp.setOrderByLCEC((rs.getBoolean("OrderedByLCEC")));
				temp.setFUwithMD(rs.getBoolean("FUwithMD"));
				temp.setCancelled(rs.getBoolean("Cancelled/Deferred"));
				temp.setFev1(rs.getFloat("FEV1"));
				temp.setFvc(rs.getFloat("FVC"));
				temp.setDlco(rs.getFloat("DLCO"));
				temp.setFevPer(rs.getFloat("FEVP"));
				temp.setFvcPer(rs.getFloat("FVCP"));
				temp.setDlcoPer(rs.getFloat("DLCOP"));
				temp.setFev1OrFvc(rs.getFloat("FEV1FVC"));
				temp.setInterpretation(rs.getString("Interpretation"));
				testList.add(temp);
			}
			testData.setTestList(testList);
			SqlUtils.close(rs);

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return testData;
	}

	@Override
	public void saveTestData(PatientTestingDataModel TestData) {
		for (PatientTesting test : TestData.getTestList()) {
			this.addTest(TestData.getMrn(), test);
		}
	}

	public void deleteTest(int ID) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("ID", ID);
		// System.out.println("deleting ID= " + ID);

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("deleteTestData", params);

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	public void deleteVisit(int ID) {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("ID", ID);
		// System.out.println("deleting ID= " + ID);

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("deleteVisitData", params);

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	public void deleteLesion(int AutoNum) {// ???????
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("AutoNum", AutoNum);// ??????

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("deleteLesionData", params);

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}

	}

	public ArrayList<PatientTesting> getTestList(String mrn) {
		ArrayList<PatientTesting> testList = new ArrayList<PatientTesting>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", mrn);
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getTestData", params);
			while (rs.next()) {
				PatientTesting temp = new PatientTesting();
				temp.setID(rs.getInt("ID"));
				temp.setTestType(rs.getInt("TestType"));
				temp.setRequiredDate(rs.getDate("RequiredDate"));
				temp.setScheduledDate(rs.getDate("ScheduleDate"));
				temp.setTestingDate(rs.getDate("TestingDate"));
				temp.setComment(rs.getString("Comment"));
				temp.setPrecertNumber(rs.getString("PrecertNumber"));
				temp.setTestingResult(rs.getInt("TestingResult"));

				temp.setOrderByLCEC((rs.getBoolean("OrderedByLCEC")));
				temp.setFUwithMD(rs.getBoolean("FUwithMD"));
				temp.setCancelled(rs.getBoolean("Cancelled/Deferred"));
				testList.add(temp);
			}
			return testList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return testList;
	}

	@Override
	public void addTest(String mrn, PatientTesting test) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("mrn", mrn);
		params.put("RequiredDate", test.getRequiredDate());
		params.put("ScheduledDate", test.getScheduledDate());
		params.put("TestingDate", test.getTestingDate());
		params.put("TestType", test.getTestType());
		params.put("Comment", test.getComment());
		params.put("TestingResult", test.getTestingResult());
		params.put("OrderedByLCEC", test.getOrderByLCEC());
		params.put("FUwithMD", test.getFUwithMD());
		params.put("Cancelled/Deferred", test.getCancelled());
		params.put("PrecertNumber", test.getPrecertNumber());
		params.put("FEV1", test.getFev1());
		params.put("FEV1P", test.getFevPer());	
		params.put("FVC", test.getFvcPer());
		params.put("FVCP", test.getFvcPer());
		params.put("DLCO", test.getDlco());
		params.put("DLCOP", test.getDlcoPer());
		params.put("FEV1FVC", test.getFev1OrFvc());
		params.put("Interpretation", test.getInterpretation());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			if (test.getID() == 3)
				lc.executeUpdate("addTestData", params);
			else {
				params.put("ID", test.getID());
				lc.executeUpdate("updateTestData", params);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public historyDataModel getHistoryData(Patient patient) {
		historyDataModel historyData = new historyDataModel(patient);
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getHistoryData", params);

			if (rs.next()) {

				historyData
						.setDateofDataEntry(rs.getDate("Date of Data Entry"));
				historyData.setPackYears(rs.getFloat("PackYears"));
				historyData.setYearQuit(rs.getInt("Year quit"));
				historyData.setSmokeStatusEntry(rs.getInt("SmokerStatusEntry"));
				historyData.setSmokeStatusCurrent(rs
						.getInt("SmokerStatusCurrent"));
				historyData.setFev1l(rs.getFloat("FEV-1 (L)"));
				historyData.setFev1pred(rs.getFloat("FEV-1 %Pred"));
				historyData.setFvcl(rs.getFloat("FVC (L)"));
				historyData.setFvcpred(rs.getFloat("FVC %Pred"));
				historyData.setFev1Fvc(rs.getFloat("FEV-1/FVC %"));
				historyData.setVo2max(rs.getFloat("VO2max"));
				historyData.setDlcoAct(rs.getFloat("DLCOAct"));
				historyData.setDlcopred(rs.getFloat("DLCO (% Pred)"));
				historyData.setCad(rs.getBoolean("CAD"));
				historyData.setLvef(rs.getBoolean("LVEF < 40%"));
				historyData.setCva(rs.getBoolean("CVA"));
				historyData.setAsbestos(rs.getString("Asbestos Exposure"));
				//
				historyData.setSilica(rs.getString("Silica Exposure"));
				//
				historyData.setTBPPD(rs.getString("TB/PPD History"));
				//
				historyData.setCabg(rs.getBoolean("CABG (last 3 years)"));
				// temp.setMajorSurgery(rs.getBoolean("Major Surgery (last 3 years)"));
				historyData.setMajorSurgeryComment(rs
						.getString("MajorSurgery Comment"));
				historyData.setPersonalLungCancer(rs
						.getBoolean("Personal Lung Cancer"));
				historyData.setPersonalLungCancerComment(rs
						.getString("Comment-HxLungCancer"));
				historyData.setFatherMotherLungCancer(rs
						.getBoolean("Fath/Moth Lung Cancer"));
				historyData.setOtherFamilyLungCancer(rs
						.getBoolean("Other Family Lung Cancer"));
				historyData.setCommentFamilyLungCancer(rs
						.getString("Comment-FamLungCancer"));
				historyData.setOtherCancer(rs
						.getBoolean("Personal Other Cancer"));
				historyData.setOtherCancerComment(rs
						.getString("Personal Other Cancer Comment"));
				historyData.setFatherMotherOtherCancer(rs
						.getBoolean("Fath/Moth Other Cancer"));
				historyData.setOtherFamilyOtherCancer(rs
						.getBoolean("Other Fam Other Cancer"));
				historyData.setCommentFamilyOtherCancer(rs
						.getString("Comment-FamilyCancer"));
				historyData.setAspirin(rs.getBoolean("Aspirin"));
				historyData.setPlavix(rs.getBoolean("Plavix"));
				historyData.setCoumadin(rs.getBoolean("Coumadin"));
				historyData.setOtherAntiCoag(rs.getBoolean("OtherAntiCoag"));
				historyData.setMedications(rs.getString("MedicationList"));
				historyData.setAllegies(rs.getString("AllergyList"));
				historyData.setComment(rs.getString("DetailComment"));
				historyData.setAsbestosExposure(rs
						.getBoolean("AsbestosExposure"));
				historyData.setSilicaExposure(rs.getBoolean("SilicaExposure"));
				historyData.setWtc(rs.getBoolean("WTC"));
				historyData.setStartYear(rs.getInt("StartYear"));
				historyData.setEndYear(rs.getInt("EndYear"));

			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return historyData;
	}

	@Override
	public void saveHistoryData(historyDataModel historyData) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("mrn", historyData.getMrn());
		params.put("dateofDataEntry", historyData.getDateofDataEntry());
		params.put("smokeStatusEntry", historyData.getSmokeStatusEntry());
		params.put("packYears", historyData.getPackYears());
		params.put("yearQuit", historyData.getYearQuit());
		params.put("smokeStatusCurrent", historyData.getSmokeStatusCurrent());
		params.put("fev1l", historyData.getFev1l());
		params.put("fvcl", historyData.getFvcl());
		params.put("fev1pred", historyData.getFev1pred());
		params.put("fvcpred", historyData.getFvcpred());
		params.put("fev1Fvc", historyData.getFev1Fvc());
		params.put("dlcoAct", historyData.getDlcoAct());
		params.put("vo2max", historyData.getVo2max());
		params.put("dlcopred", historyData.getDlcopred());
		params.put("cad", historyData.getCad());
		params.put("lvef", historyData.getLvef());
		params.put("cva", historyData.getCva());
		params.put("asbestos", historyData.getAsbestos());
		params.put("silica", historyData.getSilica());
		params.put("tbppd", historyData.getTBPPD());
		params.put("cabg", historyData.getCabg());
		params.put("majorSurgery", historyData.getMajorSurgery());
		params.put("majorSurgeryComment", historyData.getMajorSurgeryComment());
		params.put("personalLungCancer", historyData.getPersonalLungCancer());
		params.put("personalLungCancerComment",
				historyData.getPersonalLungCancerComment());
		params.put("fatherMotherLingCancer",
				historyData.getFatherMotherLungCancer());
		params.put("otherFamilyLungCancer",
				historyData.getOtherFamilyLungCancer());
		params.put("commentFamilyLungCancer",
				historyData.getCommentFamilyLungCancer());
		params.put("otherCancer", historyData.getOtherCancer());
		params.put("otherCancerComment", historyData.getOtherCancerComment());
		params.put("fatherMotherOtherCancer",
				historyData.getFatherMotherOtherCancer());
		params.put("otherFamilyOtherCancer",
				historyData.getOtherFamilyOtherCancer());
		params.put("commentFamilyOtherCancer",
				historyData.getCommentFamilyOtherCancer());
		params.put("aspirin", historyData.getAspirin());
		params.put("plavix", historyData.getPlavix());
		params.put("coumadin", historyData.getCoumadin());
		params.put("otherAntiCoag", historyData.getOtherAntiCoag());
		params.put("medications", historyData.getMedications());
		params.put("allegies", historyData.getAllegies());
		params.put("comment", historyData.getComment());
		params.put("asbestosExposure", historyData.getAsbestosExposure());
		params.put("silicaExposure", historyData.getSilicaExposure());
		params.put("wtc", historyData.getWtc());
		params.put("startYear", historyData.getStartYear());
		params.put("endYear", historyData.getEndYear());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("saveHistoryData", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public LesionModel getLesionData(Patient patient) {
		LesionModel lesionData = new LesionModel(patient);
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getLesionData", params);

			if (rs.next()) {

				lesionData.setDateofReferral(rs.getDate("Date of Referral"));
				lesionData.setPackYears(rs.getFloat("PackYears"));
				lesionData.setAsbestosExposure(rs
						.getString("Asbestos Exposure"));
				lesionData.setYearquit(rs.getInt("Year quit"));
				lesionData.setSilicaExposure(rs.getString("silica Exposure"));

				lesionData.setPersonalLungCancer(rs
						.getBoolean("Personal Lung Cancer"));
				lesionData.setFatherMotherLungCancer(rs
						.getBoolean("Fath/Moth Lung Cancer"));
				lesionData.setOtherFamilyLungCancer(rs
						.getBoolean("Other Family Lung Cancer"));

				lesionData.setPersonalOtherCancer(rs
						.getBoolean("Personal Other Cancer"));
				lesionData.setFatherMotherOtherCancer(rs
						.getBoolean("Fath/Moth Other Cancer"));
				lesionData.setOtherFamilyOtherCancer(rs
						.getBoolean("Other Fam Other Cancer"));

				lesionData.setFev(rs.getFloat("FEV-1 %Pred"));
				lesionData.setFvc(rs.getFloat("FVC %Pred"));
				lesionData.setFev_fvc(rs.getFloat("FEV-1/FVC %"));

			}
			SqlUtils.close(rs);

			lesionData.setLesionList(getlesionList(patient.getMrn()));

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return lesionData;
	}

	public ArrayList<Lesion> getlesionList(String mrn) {
		ArrayList<Lesion> testList = new ArrayList<Lesion>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", mrn);
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getLesionData2", params);
			while (rs.next()) {
				Lesion temp = new Lesion();
				temp.setLessionClassification(rs.getInt("LesionClassification"));
				temp.setDate1stFollowedLCEC(rs.getDate("Date1stFollowedLCEC"));
				temp.setLocation(rs.getString("Location"));
				temp.setCTCharacteristic(rs.getString("CT Characteristic"));
				temp.setPetSUV(rs.getString("PET SUV"));
				temp.setFinalDiagnosis(rs.getInt("LesionDiagnosis"));
				temp.setLinkToCancer(rs.getInt("LinkToCancer"));
				temp.setComments(rs.getString("Comments"));
				temp.setAutoNum(rs.getInt("ID"));

				testList.add(temp);
			}

			return testList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	@Override
	public void saveLesionData(LesionModel lesionData) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("mrn", lesionData.getMrn());
		params.put("Date of Referral", lesionData.getDateofReferral());
		params.put("PackYears", lesionData.getPackYears());
		params.put("Asbestos Exposure", lesionData.getAsbestosExposure());
		params.put("Year quit", lesionData.getYearquit());
		params.put("silica Exposure", lesionData.getSilicaExposure());
		params.put("Personal Lung Cancer", lesionData.isPersonalLungCancer());
		params.put("Fath/Moth Lung Cancer",
				lesionData.isFatherMotherLungCancer());
		params.put("Other Family Lung Cancer",
				lesionData.isOtherFamilyLungCancer());
		params.put("Personal Other Cancer", lesionData.isPersonalOtherCancer());
		params.put("Fath/Moth Other Cancer",
				lesionData.isFatherMotherOtherCancer());
		params.put("Other Fam Other Cancer",
				lesionData.isOtherFamilyOtherCancer());

		params.put("FEV-1 %Pred", lesionData.getFev());
		params.put("FVC %Pred", lesionData.getFvc());
		params.put("FEV-1/FVC %", lesionData.getFev_fvc());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("saveLesionData", params);
			for (Lesion lesion : lesionData.getLesionList()) {
				this.addLesion(lesionData.getMrn(), lesion);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public void addLesion(String mrn, Lesion lesion) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("mrn", mrn);
		params.put("date", lesion.getDate1stFollowedLCEC());
		params.put("LesionClassification", lesion.getLessionClassification());
		params.put("Location", lesion.getLocation());
		params.put("CT Characteristic", lesion.getCTCharacteristic());
		if (lesion.getPetSUV().trim().length() != 0)
			params.put("Pet SUV", lesion.getPetSUV());
		else
			params.put("Pet SUV", "0.0");
		params.put("LesionDiagnosis", lesion.getFinalDiagnosis());
		params.put("LinkToCancer", lesion.getLinkToCancer());
		params.put("Comments", lesion.getComments());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			if (lesion.getAutoNum() == -1)
				lc.executeUpdate("addLesionData", params);
			else {
				params.put("Id", lesion.getAutoNum());
				lc.executeUpdate("updatelesionData", params);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	@Override
	public ResearchModel getResearchData(Patient patient) {

		ResearchModel researchData = new ResearchModel(patient);
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());
		ResultSet rs = null;
		// LibraryConnection lc =null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getPatientLesionData", params);
			ArrayList<PatientLesion> lesionList = new ArrayList<PatientLesion>();
			while (rs.next()) {
				PatientLesion patientLesion = new PatientLesion();
				patientLesion.setLesionId(rs.getInt("LesionID"));
				patientLesion.setLesionDate(rs.getDate("Date1stFollowedLCEC"));
				patientLesion
						.setLesionClassificationId(rs.getInt("LesClassId"));
				patientLesion.setLeasionClassification(rs
						.getString("LesionClassification"));
				patientLesion.setLocation(rs.getString("Location"));
				lesionList.add(patientLesion);
			}
			researchData.setLesionList(lesionList);
			SqlUtils.close(rs);

			rs = lc.executeQuery("getResearchData", params);
			ArrayList<Research> researchList = new ArrayList<Research>();
			while (rs.next()) {
				Research research = new Research();
				research.setID(rs.getInt("ResearchID"));
				research.setConsentDate(rs.getDate("ConsentDate"));
				research.setResearchProj(rs.getInt("ResearchProj"));
				research.setComments(rs.getString("Comments"));
				researchList.add(research);
			}
			researchData.setResearchList(researchList);
			SqlUtils.close(rs);

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return researchData;
	}

	@Override
	public void addResearch(String mrn, Research research) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("mrn", mrn);
		params.put("ConsentDate", research.getConsentDate());
		params.put("ResearchProj", research.getResearchProj());
		params.put("Comments", research.getComments());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			if (research.getID() == -1)
				lc.executeUpdate("addResearchData", params);
			else {
				params.put("ID", research.getID());
				lc.executeUpdate("updateResearchData", params);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}

	}

	@Override
	public ArrayList<Research> getResearchList(String mrn) {
		ArrayList<Research> researchList = new ArrayList<Research>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", mrn);
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getResearchData", params);
			while (rs.next()) {
				Research temp = new Research();
				temp.setID(rs.getInt("ResearchID"));
				temp.setConsentDate(rs.getDate("ConsentDate"));
				temp.setResearchProj(rs.getInt("ResearchProj"));
				temp.setComments(rs.getString("Comments"));

				researchList.add(temp);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return researchList;
	}

	@Override
	public void saveResearchData(ResearchModel researchData) {
		for (Research research : researchData.getResearchList()) {
			this.addResearch(researchData.getMrn(), research);
		}

	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<QueryVisits> getQueryVisitsList() {
		ArrayList<QueryVisits> queryVisitsList = new ArrayList<QueryVisits>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getPatientVisitsReport", null);

			while (rs.next()) {
				QueryVisits queryVisits = new QueryVisits();
				queryVisits.setMrn(rs.getString("MRN"));
				queryVisits.setName(rs.getString("Name (Last,First)"));
				queryVisits.setActualVisitDate(rs
						.getDate("Date of Actual Visit"));
				queryVisits.setTypeOfVisit(rs.getInt("Type of Visit"));
				queryVisits.setPrimaryMD(rs.getString("To see/Seen by"));
				queryVisits.setScheduledToSee2(rs.getString("Seen by 2"));
				queryVisits.setRefused(rs.getBoolean("Refused"));
				queryVisits.setHandledByPhone(rs.getBoolean("PhoneCall"));
				queryVisits.setPlan(rs.getString("Plan decided at visit"));
				queryVisits.setComment(rs.getString("Comment"));
				queryVisitsList.add(queryVisits);
			}

			return queryVisitsList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return queryVisitsList;
	}

	@Override
	public ArrayList<CancerInfoModel> getCancerQueryData() {

		ArrayList<CancerInfoModel> cancerList = new ArrayList<CancerInfoModel>();
		Map<String, String> params = new HashMap<String, String>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getAllCancerData", params);

			while (rs.next()) {
				CancerInfoModel cancerData = new CancerInfoModel();

				cancerData.setMrn(rs.getString("PatientMRN"));
				cancerData.setName(rs.getString("Name (Last,First)"));
				cancerData.setInactiveDate(rs.getDate("InactiveDate"));
				cancerData.setlCECChart(rs.getBoolean("LCEC Chart"));
				cancerData.setClinical_T(rs.getInt("Stage - T Clinical"));
				cancerData.setPathological_T(rs.getInt("Stage - T Pathologic"));
				cancerData.setPostNeo_T(rs.getInt("Stage - T Restage"));
				cancerData.setClinical_N(rs.getString("Stage - N Clinical"));
				cancerData.setPathological_N(rs
						.getString("Stage - N Pathologic"));
				cancerData.setPostNeo_N(rs.getString("Stage - N Restage"));
				cancerData.setClinical_M(rs.getString("Stage - M Clinical"));
				cancerData.setPathological_M(rs
						.getString("Stage - M Pathologic"));
				cancerData.setPostNeo_M(rs.getString("Stage - M Restage"));
				cancerData.setClinical_TNM(rs.getInt("Stage - TNM Clinical"));
				cancerData.setPathological_TNM(rs
						.getInt("Stage - TNM Pathologic"));
				cancerData.setPostNeo_TNM(rs.getInt("Stage - TNM Restage"));
				cancerData.setStatus_1year(rs.getString("Status 1 year"));
				cancerData.setStatus_2year(rs.getString("Status 2 year"));
				cancerData.setStatus_3year(rs.getString("Status 3 year"));
				cancerData.setStatus_4year(rs.getString("Status 4 year"));
				cancerData.setStatus_5year(rs.getString("Status 5 year"));
				cancerData.setComment1(rs.getString("CancerTypeComment"));
				cancerData.setRelapseDate(rs.getDate("Date 1st relapse"));
				cancerData
						.setDiagnosisDate(rs.getDate("Date of 1st Diagnosis"));
				cancerData.setStagingDate(rs.getDate("Date of Final Staging"));
				cancerData.setTumorDate(rs.getDate("Date of Tumor Board"));
				cancerData.setComment(rs.getString("Comment"));
				cancerData.setCancerType(rs.getInt("CancerType"));
				cancerData
						.setHistology(rs.getString("CancerHisto") != null ? rs
								.getString("CancerHisto") : "");
				cancerData
						.setNaChemoStatus(rs.getString("NeoChemoPlan") != null ? rs
								.getString("NeoChemoPlan") : "");
				cancerData.setNartStatus(rs.getString("NeoRTPlan") != null ? rs
						.getString("NeoRTPlan") : "");
				cancerData
						.setSbrtStatus(rs.getString("SurgeryPlan") != null ? rs
								.getString("SurgeryPlan") : "");
				cancerData
						.setChemotherapyStatus(rs.getString("ChemoPlan") != null ? rs
								.getString("ChemoPlan") : "");
				cancerData
						.setRadtherapyStatus(rs.getString("RTPlan") != null ? rs
								.getString("RTPlan") : "");
				cancerData.setNaChemoMD(rs.getString("NeoChemoMD") != null ? rs
						.getString("NeoChemoMD").toLowerCase() : "");
				cancerData.setNartMD(rs.getString("NeoRTMD") != null ? rs
						.getString("NeoRTMD").toLowerCase() : "");
				cancerData.setSbrtMD(rs.getString("SurgeryMD") != null ? rs
						.getString("SurgeryMD").toLowerCase() : "");
				cancerData
						.setChemotherapyMD(rs.getString("ChemoMD") != null ? rs
								.getString("ChemoMD").toLowerCase() : "");
				cancerData.setRadtherapyMD(rs.getString("RTMD") != null ? rs
						.getString("RTMD").toLowerCase() : "");
				cancerData.setNaChemoDate(rs.getDate("NeoChemoEndDate"));
				cancerData.setNartDate(rs.getDate("NeoRTEndDate"));
				cancerData.setSbrtDate(rs.getDate("SurgeryDate"));
				cancerData.setChemotherapyDate(rs.getDate("ChemoEndDate"));
				cancerData.setRadtherapyDate(rs.getDate("RTEndDate"));

				cancerList.add(cancerData);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return cancerList;
	}

	@Override
	public ArrayList<QueryLesions> getQueryLesionsList() {
		ArrayList<QueryLesions> queryLesionsList = new ArrayList<QueryLesions>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getAllLesionsData", null);

			while (rs.next()) {
				QueryLesions queryLesions = new QueryLesions();
				queryLesions.setMrn(rs.getString("PatientMRN"));
				queryLesions.setName(rs.getString("Name (Last,First)"));
				queryLesions.setDateFollowedLCEC(rs
						.getDate("Date1stFollowedLCEC"));
				queryLesions.setLesionClassification(rs
						.getInt("LesionClassification"));
				queryLesions.setLocation(rs.getString("Location"));
				queryLesions.setComments(rs.getString("LocationComment"));
				queryLesions.setCtCharacteristic(rs
						.getString("CT Characteristic"));
				queryLesions.setPetSUV(rs.getString("PET SUV"));
				queryLesionsList.add(queryLesions);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return queryLesionsList;
	}

	public ArrayList<QueryPendingProcedures> getPendingProceduresList() {
		ArrayList<QueryPendingProcedures> queryPendingProceduresList = new ArrayList<QueryPendingProcedures>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			// The name of this query needed to be added to the query.xml
			rs = lc.executeQuery("queryPendingProcedures", null);

			while (rs.next()) {
				QueryPendingProcedures queryPendingProcedures = new QueryPendingProcedures();
				queryPendingProcedures.setPatientMrn(rs.getString("MRN"));
				queryPendingProcedures.setPatientName(rs
						.getString("Name (Last,First)"));
				queryPendingProcedures.setPatientBirthday(rs
						.getDate("Date Of Birth"));
				queryPendingProcedures.setPatientPhoneNumber(rs
						.getString("PhoneNumber"));
				queryPendingProcedures.setProcedureType(rs
						.getInt("ProcedureType"));
				queryPendingProcedures.setPerformedBy(rs
						.getString("PerformedBy"));
				queryPendingProcedures.setScheduleDate(rs
						.getDate("ScheduleDate"));

				queryPendingProceduresList.add(queryPendingProcedures);
			}

		} catch (SQLException e) {
			logger.error(e, e);

		} catch (Exception e) {
			logger.error(e, e);

		} finally {
			SqlUtils.close(rs);

		}

		return queryPendingProceduresList;
	}

	@Override
	public ArrayList<QuartReport> getQuartCancerDiag() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> quartCancerDiagList = new ArrayList<QuartReport>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetQuartCancerDiag", null);

			while (rs.next()) {
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));
				qcd.setQuarter(rs.getInt(2));
				qcd.setCount(rs.getInt(3));

				quartCancerDiagList.add(qcd);
			}

			return quartCancerDiagList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return quartCancerDiagList;
	}

	@Override
	public ArrayList<QuartReport> getQuartNewRefs() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> quartNewRefs = new ArrayList<QuartReport>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetQuartNewRef", null);

			while (rs.next()) {
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));
				qcd.setQuarter(rs.getInt(2));
				qcd.setCount(rs.getInt(3));

				quartNewRefs.add(qcd);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return quartNewRefs;
	}

	// added by sai for report
	@Override
	public ArrayList<QuartReport> getYearlyNewRefs() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> yearlyNewRefs = new ArrayList<QuartReport>();
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetYearlyNewRef", null);

			while (rs.next()) {
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(2));

				qcd.setCount(rs.getInt(1));

				yearlyNewRefs.add(qcd);
			}

			return yearlyNewRefs;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return yearlyNewRefs;
	}

	// added by sai for report
	@Override
	public ArrayList<rptPreOpsModel> getrptPreOps() {
		// TODO Auto-generated method stub

		ArrayList<rptPreOpsModel> rptPreOps = new ArrayList<rptPreOpsModel>();
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("rptPreOps", null);

			while (rs.next()) {
				rptPreOpsModel qcd = new rptPreOpsModel();

				qcd.setMRN(rs.getInt(1));
				qcd.setname(rs.getString(2));

				qcd.setworkupstatus(rs.getInt(3));
				qcd.setphonenumber(rs.getString(4));

				rptPreOps.add(qcd);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return rptPreOps;
	}

	// added by sai for report
	@Override
	public ArrayList<rptVisitTestingModel> getrptVisitTesting() {
		// TODO Auto-generated method stub

		ArrayList<rptVisitTestingModel> rptVisitTesting = new ArrayList<rptVisitTestingModel>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("rptVisitTesting", null);

			while (rs.next()) {
				rptVisitTestingModel qcd = new rptVisitTestingModel();

				qcd.setMRN(rs.getInt(1));
				qcd.settype(rs.getInt(2));

				qcd.setreqdate(rs.getDate(3));
				qcd.settestdate(rs.getDate(4));
				qcd.setresult(rs.getString(5));
				qcd.settestresult(rs.getInt(6));
				qcd.setok(rs.getInt(7));
				qcd.setcomment(rs.getString(8));

				rptVisitTesting.add(qcd);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return rptVisitTesting;
	}

	// added by sai for report
	@Override
	public ArrayList<YearlyConsultsModel> getYearlyNewConsults() {
		// TODO Auto-generated method stub

		ArrayList<YearlyConsultsModel> yearlyNewConsults = new ArrayList<YearlyConsultsModel>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetYearlyNewConsults", null);

			while (rs.next()) {
				YearlyConsultsModel qcd = new YearlyConsultsModel();

				qcd.setYear(rs.getInt(1));
				qcd.setType(rs.getString(2));
				qcd.setCount(rs.getInt(3));

				yearlyNewConsults.add(qcd);
			}

			return yearlyNewConsults;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return yearlyNewConsults;
	}

	/* Start of changes by Abhinav */
	public ArrayList<QuartReport> getQuartLungResec() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> quartLungResecList = new ArrayList<QuartReport>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetQuartLungResec", null);

			while (rs.next()) {
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));
				qcd.setQuarter(rs.getInt(2));
				qcd.setCount(rs.getInt(3));

				quartLungResecList.add(qcd);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return quartLungResecList;
	}

	public boolean getChartStatus() {
		// TODO Auto-generated method stub

		boolean chartstatus = false ;
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetChartStatus", null);

			while (rs.next()) {
				/*
				 * QuartReport qcd = new QuartReport();
				 * 
				 * qcd.setYear(rs.getInt(1)); qcd.setQuarter(rs.getInt(2));
				 * qcd.setCount(rs.getInt(3));
				 */

				String status = rs.getString(1);
				if(status == null)
				{
					chartstatus = true;
				}
				else{
					chartstatus = false;
				}

				
			}

			
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return chartstatus;

		
	}
	
	public ArrayList<Integer> getPatientAge() {
		// TODO Auto-generated method stub

		ArrayList<Integer> patientage = new ArrayList<Integer>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetPatientAge", null);

			while (rs.next()) {
				/*
				 * QuartReport qcd = new QuartReport();
				 * 
				 * qcd.setYear(rs.getInt(1)); qcd.setQuarter(rs.getInt(2));
				 * qcd.setCount(rs.getInt(3));
				 */

				String dob = rs.getString(1);

				int yearDOB = Integer.parseInt(dob.substring(0, 4));
				int monthDOB = Integer.parseInt(dob.substring(5, 7));
				int dayDOB = Integer.parseInt(dob.substring(8, 10));

				// CALCULATE THE CURRENT YEAR, MONTH AND DAY
				// INTO SEPERATE VARIABLES
				DateFormat dateFormat = new SimpleDateFormat("yyyy");
				java.util.Date date = new java.util.Date();
				int thisYear = Integer.parseInt(dateFormat.format(date));

				dateFormat = new SimpleDateFormat("MM");
				date = new java.util.Date();
				int thisMonth = Integer.parseInt(dateFormat.format(date));

				dateFormat = new SimpleDateFormat("dd");
				date = new java.util.Date();
				int thisDay = Integer.parseInt(dateFormat.format(date));

				// CREATE AN AGE VARIABLE TO HOLD THE CALCULATED AGE
				// TO START WILL � SET THE AGE EQUEL TO THE CURRENT YEAR MINUS
				// THE YEAR
				// OF THE DOB
				int age = thisYear - yearDOB;
				// IF THE CURRENT MONTH IS LESS THAN THE DOB MONTH
				// THEN REDUCE THE DOB BY 1 AS THEY HAVE NOT HAD THEIR
				// BIRTHDAY YET THIS YEAR
				if (thisMonth < monthDOB) {
					age = age - 1;
				}

				// IF THE MONTH IN THE DOB IS EQUEL TO THE CURRENT MONTH
				// THEN CHECK THE DAY TO FIND OUT IF THEY HAVE HAD THEIR
				// BIRTHDAY YET. IF THE CURRENT DAY IS LESS THAN THE DAY OF THE
				// DOB
				// THEN REDUCE THE DOB BY 1 AS THEY HAVE NOT HAD THEIR
				// BIRTHDAY YET THIS YEAR
				if (thisMonth == monthDOB && thisDay < dayDOB) {
					age = age - 1;
				}

				patientage.add(age);
			}

			return patientage;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return patientage;
	}
	
	public int autoMRN() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		int new_mrn = 1001;
		Map<String, Integer> params = new HashMap<String, Integer>();
		try {
			//logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("automrn", null);
			while (rs.next()) {
				
				int curr_mrn = rs.getInt(1);
			    new_mrn = curr_mrn + 1;
			}
			//Update mrn in database
			params.put("newmrn", new_mrn);
			lc.executeUpdate("updatemrn", params);
			
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return new_mrn;

		
	}
	
	public boolean setState() {
		// TODO Auto-generated method stub

		boolean setState = false ;
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetsetState", null);

			while (rs.next()) {
				
				String status = rs.getString(1);
				
				if(status.equals("0"))
				{
					
					setState = false;
				}
				else{
					
					setState = true;
				}	
			}

			
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return setState;

		
	}
	
	public void saveState() {
		// TODO Auto-generated method stub
		try {
			logger.debug("userid:" + cur_user.getUserId());
			System.out.println("Invoking query to change state to 1");
			lc.executeUpdate("SaveState", null);

			
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			//SqlUtils.close(rs);

		}
		//return setState;

		
	}
	
	public void saveState0() {
		// TODO Auto-generated method stub
		try {
			logger.debug("userid:" + cur_user.getUserId());
			System.out.println("Invoking query to change state to 0");
			lc.executeUpdate("SaveState0", null);

			
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			//SqlUtils.close(rs);

		}
		//return setState;

		
	}


	/* End of changes by Abhinav */

	// added by sai for report
	@Override
	public ArrayList<QuartReport> getQuartNewConsults() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> quartNewConsults = new ArrayList<QuartReport>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetQuartNewConsults", null);

			while (rs.next()) {
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));
				qcd.setQuarter(rs.getInt(2));
				qcd.setCount(rs.getInt(3));

				quartNewConsults.add(qcd);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return quartNewConsults;
	}

	// added by sai for report
	@Override
	public ArrayList<QuartReport> getQuartProcedures() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> quartProcedures = new ArrayList<QuartReport>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetQuartProcedures", null);

			while (rs.next()) {
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));
				qcd.setQuarter(rs.getInt(2));
				qcd.setCount(rs.getInt(3));

				quartProcedures.add(qcd);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return quartProcedures;
	}

	// added by sai for report
	@Override
	public ArrayList<QuartReport> getYearlyProcedures() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> yearlyProcedures = new ArrayList<QuartReport>();
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetYearlyProcedures", null);

			while (rs.next()) {
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));

				qcd.setCount(rs.getInt(2));

				yearlyProcedures.add(qcd);
			}

			return yearlyProcedures;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;
	}

	// added by sai
	@Override
	public ArrayList<QuartReport> getYearlyPETScans() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> yearlyPETScans = new ArrayList<QuartReport>();
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetYearlyPETScans", null);

			while (rs.next()) {
				
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));

				qcd.setCount(rs.getInt(2));

				yearlyPETScans.add(qcd);
			}

			return yearlyPETScans;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;
	}
	
	//added by sai
	
	public ArrayList<AddReferring> getReferringMDList() {
		// TODO Auto-generated method stub
		
		ArrayList<AddReferring> referringMDList = new ArrayList<AddReferring>(); 
		try {
			logger.debug("userid:" + cur_user.getUserId());
			ResultSet rs = null;
			rs = lc.executeQuery("addreferringmd", null);
			while (rs.next()) {
				AddReferring addReferring = new AddReferring();
				
				addReferring.setReferring(rs.getString(1));
				addReferring.setTitle(rs.getString(2));
				addReferring.setGroupname(rs.getString(3));
				addReferring.setAddress(rs.getString(4));
				addReferring.setCity(rs.getString(5));
				addReferring.setState(rs.getString(6));
				addReferring.setZip(rs.getString(7));
				addReferring.setOffice(rs.getString(8));
				addReferring.setFax(rs.getString(9));
				
				referringMDList.add(addReferring);
			}
		}
	 catch (SQLException e) {
		logger.error(e, e);
	}
		
		return referringMDList;
	}


	public ArrayList<AddPrimary> getPrimaryMDList() {
		// TODO Auto-generated method stub
		
		ArrayList<AddPrimary> referringMDList = new ArrayList<AddPrimary>(); 
		try {
			logger.debug("userid:" + cur_user.getUserId());
			ResultSet rs = null;
			rs = lc.executeQuery("addprimarymd", null);
			while (rs.next()) {
				AddPrimary addReferring = new AddPrimary();
				
				addReferring.setTreating(rs.getString(1));
				addReferring.setTitle(rs.getString(2));
				addReferring.setGroupname(rs.getString(3));
				addReferring.setAddress(rs.getString(4));
				addReferring.setCity(rs.getString(5));
				addReferring.setState(rs.getString(6));
				addReferring.setZip(rs.getString(7));
				addReferring.setOffice(rs.getString(8));
			
				
				referringMDList.add(addReferring);
				
				
			}
		}
	 catch (SQLException e) {
		logger.error(e, e);
	}
		
		return referringMDList;
	}

	

	public void addPrimaryMD(AddPrimary test) {
		Map<String, Object> params = new HashMap<String, Object>();

	
			     
		params.put("Treating", test.getTreating());
		params.put("Title", test.getTitle());
		params.put("Groupname", test.getGroupname());
		params.put("Address", test.getAddress());
		params.put("City", test.getCity());
		params.put("State", test.getState());
		params.put("Zip", test.getZip());
		params.put("Office", test.getOffice());
		

		try {
			logger.debug("userid:" + cur_user.getUserId());

		
				lc.executeUpdate("addprimarymdData", params);
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e, e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e, e);
		} finally {

		}
	}


	public void addReferringMD(AddReferring test) {
		Map<String, Object> params = new HashMap<String, Object>();

	
			     
		params.put("Referring", test.getReferring());
		params.put("Title", test.getTitle());
		params.put("Groupname", test.getGroupname());
		params.put("Address", test.getAddress());
		params.put("City", test.getCity());
		params.put("State", test.getState());
		params.put("Zip", test.getZip());
		params.put("Office", test.getOffice());
		params.put("Fax", test.getFax());
		

		try {
			logger.debug("userid:" + cur_user.getUserId());

		
				lc.executeUpdate("addreferringmdData", params);
			
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	public boolean addLcecDoctor(String name) {
		
		boolean addDoc = false;
		Map<String, String> params = new HashMap<String, String>();
			     
		params.put("Physicianname", name);
		
		try {
				lc.executeUpdate("addphysicianname", params);
				
				addDoc = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e, e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e, e);
		} finally {

		}
		return addDoc;
	}
	
	public boolean addTestType(String testType) {
		System.out.println("In data adapater for adding test type");
		boolean addTestType = false;
		Map<String, String> params = new HashMap<String, String>();
		Integer autoNumber = 0;
		params.put("TestType", testType);
		ResultSet rs;
		try {
				rs = lc.executeQuery("getMaxAutonumber", params);
				while (rs.next()){
					autoNumber = rs.getInt("Autonumber");
				}
				params.clear();
				autoNumber += 10;
				params.put("Autonumber", autoNumber.toString());
				params.put("TestingType", testType);
				lc.executeUpdate("addTestType", params);
				
				addTestType = true;			
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e, e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e, e);
		} finally {

		}
		return addTestType;
	}
	
	@Override
	public void addInsurance(InsuranceDataModel insurance) {
		Map<String, Object> params = new HashMap<String, Object>();
 
		params.put("Comment", insurance.getComment());
		params.put("CtPrecert", insurance.getCtPrecert());
		params.put("PetPrecert", insurance.getPetPrecert());
		params.put("PftPrecert", insurance.getPftPrecert());
		params.put("InsurCo", insurance.getInsurCo());
		params.put("Phonenumber1", insurance.phoneNumber1);
		params.put("Phonenumber2", insurance.phoneNumber2);
		params.put("Phonenumber3", insurance.phoneNumber3);
		params.put("visitReferral", insurance.visitReferral);
		

		try {
			logger.debug("userid:" + cur_user.getUserId());

		
				lc.executeUpdate("addInsurance", params);
			
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}


	@Override
	public ArrayList<QuartReport> getQuartPETScans() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> quartPETScans = new ArrayList<QuartReport>();
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetQuartPETScans", null);

			while (rs.next()) {
				
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));
				qcd.setQuarter(rs.getInt(2));
				qcd.setCount(rs.getInt(3));

				quartPETScans.add(qcd);
			}

			return quartPETScans;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;
	}

	@Override
	public ArrayList<QuartReport> getQuartRFACryo() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> quartRFACryo = new ArrayList<QuartReport>();
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetQuartRFACryo", null);

			while (rs.next()) {

				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));
				qcd.setQuarter(rs.getInt(2));
				qcd.setCount(rs.getInt(3));

				quartRFACryo.add(qcd);
			}

			return quartRFACryo;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;
	}

	@Override
	public ArrayList<QuartReport> getYearlyRFACryo() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> yearlyRFACryo = new ArrayList<QuartReport>();
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetYearlyRFACryo", null);

			while (rs.next()) {
				
				QuartReport qcd = new QuartReport();

				qcd.setYear(rs.getInt(1));
				// qcd.setQuarter(rs.getInt(2));
				qcd.setCount(rs.getInt(2));

				yearlyRFACryo.add(qcd);
			}

			return yearlyRFACryo;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;
	}

	@Override
	public ArrayList<QuartReport> getCasesPerTown() {
		// TODO Auto-generated method stub

		ArrayList<QuartReport> casesPerTown = new ArrayList<QuartReport>();
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("GetCasesPerTown", null);

			while (rs.next()) {
				
				QuartReport qcd = new QuartReport();

				qcd.setCity(rs.getString(1));
				// qcd.setQuarter(rs.getInt(2));
				qcd.setName(rs.getString(2));

				casesPerTown.add(qcd);
			}

			return casesPerTown;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	// End of srikanth

	// PatientMedication
	@Override
	public PatientMedicationModel getMedicationData(Patient patient) {
		PatientMedicationModel medicationData = new PatientMedicationModel(
				patient);
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());

		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			// should add query in the query xml! And the name of the query must
			// be "getMedicationData"
			rs = lc.executeQuery("getMedicationData", params);
			ArrayList<PatientMedication> patientMedicationList = new ArrayList<PatientMedication>();
			while (rs.next()) {
				PatientMedication patientMedication = new PatientMedication();
				patientMedication.setID(rs.getInt("ID"));
				patientMedication.setMedicationName(rs
						.getString("Medicine Name"));
				patientMedication.setDose(rs.getString("Dose"));
				patientMedication.setDoseUnit(rs.getInt("Dose Unit"));
				patientMedication.setStrength(rs.getString("Strength"));
				patientMedication.setStrengthUnit(rs.getInt("Strength Unit"));
				patientMedication.setHowTaken(rs.getInt("How Taken"));
				patientMedication.setHowOftenTaken(rs
						.getString("How Often Taken"));
				patientMedication.setReasonTaking(rs.getString("Reason"));
				patientMedication.setDateStarted(rs.getDate("Started Date"));
				patientMedication.setDateStopped(rs.getDate("Stopped Date"));
				patientMedication.setInstruction(rs.getString("Instructions"));
				patientMedication.setPrescriptionExpireDate(rs
						.getDate("Prescription Expire Date"));
				patientMedication.setPrescribedDate(rs
						.getDate("Prescribed Date"));
				patientMedication.setPrescriptionQuantity(rs
						.getString("Prescription Quantity"));
				patientMedication.setPrescriptor(rs.getString("Prescriptor"));
				patientMedication.setMedicineGivenType(rs
						.getInt("Medication GivenType"));
				patientMedication.setPlavix(rs.getBoolean("Plavix"));
				patientMedication.setPletal(rs.getBoolean("Pletal"));
				patientMedication.setEffient(rs.getBoolean("Effient"));
				patientMedication.setAgrylin(rs.getBoolean("Agrylin"));
				patientMedication.setAggrenox(rs.getBoolean("Aggrenox"));
				patientMedication.setPradaxa(rs.getBoolean("Pradaxa"));
				patientMedication.setXarelto(rs.getBoolean("Xarelto"));
				patientMedication.setCoumadin(rs.getBoolean("Coumadin"));
				patientMedication.setPersantine(rs.getBoolean("Persantine"));
				patientMedication.setEliquis(rs.getBoolean("Eliquis"));
				patientMedication.setBrilinta(rs.getBoolean("Brilinta"));
				patientMedication.setOralHypoglycemic(rs
						.getBoolean("Oral Hypoglycemic"));
				patientMedication.setInsulin(rs.getBoolean("Insulin"));
				patientMedication.setNka(rs.getBoolean("NKA"));
				patientMedication.setAdditionDate(rs
						.getDate("Date Of Medicine"));
				patientMedication.setAllergies(rs.getString("Allergies"));
				patientMedicationList.add(patientMedication);
			}
			medicationData.setPatientMedicationList(patientMedicationList);
			SqlUtils.close(rs);
			return medicationData;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public void saveMedicationData(PatientMedicationModel medicationData) {
		for (PatientMedication patientMedication : medicationData
				.getPatientMedicationList()) {
			this.addMedication(medicationData.getPatientMrn(),
					patientMedication);
		}
	}

	// @Override
	// public void saveVisitData(PatientVisitsModel VisitData){
	// for(Visit visit: VisitData.getVisitList()){
	// this.addVisit(VisitData.getMrn(), visit);
	// }
	// }

	// PatientMedicationModel getMedicationData(Patient patient);
	// void saveMedicationData(PatientMedicationModel MedicationData);
	// ArrayList<PatientMedication> getPatientMedicationList(String mrn);
	// void addMedication(String mrn, PatientMedication medication);
	@Override
	public ArrayList<PatientMedication> getPatientMedicationList(String mrn) {
		ArrayList<PatientMedication> patientMedicationList = new ArrayList<PatientMedication>();
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", mrn);

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());
			lc = new LibraryConnection(library, dbConnection);
			rs = lc.executeQuery("getMedicationData", params);
			while (rs.next()) {
				PatientMedication patientMedication = new PatientMedication();
				patientMedication.setID(rs.getInt("ID"));
				patientMedication.setMedicationName(rs
						.getString("Medicine Name"));
				patientMedication.setDose(rs.getString("Dose"));
				patientMedication.setDoseUnit(rs.getInt("Dose Unit"));
				patientMedication.setStrength(rs.getString("Strength"));
				patientMedication.setStrengthUnit(rs.getInt("Strength Unit"));
				patientMedication.setHowTaken(rs.getInt("How Taken"));
				patientMedication.setHowOftenTaken(rs
						.getString("How Often Taken"));
				patientMedication.setReasonTaking(rs.getString("Reason"));
				patientMedication.setDateStarted(rs.getDate("Started Date"));
				patientMedication.setDateStopped(rs.getDate("Stopped Date"));
				patientMedication.setInstruction(rs.getString("Instructions"));
				patientMedication.setPrescriptionExpireDate(rs
						.getDate("Prescription Expire Date"));
				patientMedication.setPrescribedDate(rs
						.getDate("Prescribed Date"));
				patientMedication.setPrescriptionQuantity(rs
						.getString("Prescription Quantity"));
				patientMedication.setPrescriptor(rs.getString("Prescriptor"));
				patientMedication.setMedicineGivenType(rs
						.getInt("Medication GivenType"));
				patientMedication.setPlavix(rs.getBoolean("Plavix"));
				patientMedication.setEffient(rs.getBoolean("Effient"));
				patientMedication.setAgrylin(rs.getBoolean("Agrylin"));
				patientMedication.setAggrenox(rs.getBoolean("Aggrenox"));
				patientMedication.setPletal(rs.getBoolean("Pletal"));
				patientMedication.setPradaxa(rs.getBoolean("Pradaxa"));
				patientMedication.setXarelto(rs.getBoolean("Xarelto"));
				patientMedication.setCoumadin(rs.getBoolean("Coumadin"));
				patientMedication.setPersantine(rs.getBoolean("Persantine"));
				patientMedication.setEliquis(rs.getBoolean("Eliquis"));
				patientMedication.setBrilinta(rs.getBoolean("Brilinta"));
				patientMedication.setOralHypoglycemic(rs
						.getBoolean("Oral Hypoglycemic"));
				patientMedication.setInsulin(rs.getBoolean("Insulin"));
				patientMedication.setNka(rs.getBoolean("NKA"));
				patientMedication.setAdditionDate(rs
						.getDate("Date Of Medicine"));
				patientMedication.setAllergies(rs.getString("Allergies"));
				patientMedicationList.add(patientMedication);
			}
			return patientMedicationList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	public void addMedication(String mrn, PatientMedication medication) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("mrn", mrn);
		params.put("medicationName", medication.getMedicationName());
		params.put("dose", medication.getDose());
		params.put("doseUnit", medication.getDoseUnit());
		params.put("strength", medication.getStrength());
		params.put("strengthUnit", medication.getStrengthUnit());
		params.put("howTaken", medication.getHowTaken());
		params.put("howOftenTaken", medication.getHowOftenTaken());
		params.put("medicineGivenType", medication.getMedicineGivenType());
		params.put("reasonTaking", medication.getReasonTaking());
		params.put("dateStarted", medication.getDateStarted());
		params.put("dateStopped", medication.getDateStopped());
		params.put("instruction", medication.getInstruction());
		params.put("prescriptionExpireDate",
				medication.getPrescriptionExpireDate());
		params.put("prescribedDate", medication.getPrescribedDate());
		params.put("prescriptionQuantity", medication.getPrescriptionQuantity());
		params.put("prescriptor", medication.getPrescriptor());
		params.put("plavix", medication.getPlavix());
		params.put("effient", medication.getEffient());
		params.put("agrylin", medication.getAgrylin());
		params.put("aggrenox", medication.getAggrenox());
		params.put("pletal", medication.getPletal());
		params.put("pradaxa", medication.getPradaxa());
		params.put("xarelto", medication.getXarelto());
		params.put("coumadin", medication.getCoumadin());
		params.put("persantine", medication.getPersantine());
		params.put("eliquis", medication.getEliquis());
		params.put("brilinta", medication.getBrilinta());
		params.put("oralHypoglycemic", medication.getOralHypoglycemic());
		params.put("insulin", medication.getInsulin());
		params.put("nka", medication.getNka());
		params.put("additionDate", medication.getAdditionDate());
		params.put("allergies", medication.getAllergies());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			if (medication.getID() == -1)
				// should add "addMedicationData" in the query xml
				lc.executeUpdate("addMedicationData", params);
			else {
				params.put("ID", medication.getID());

				// should add "updateMedicationData" in the query xml
				lc.executeUpdate("updateMedicationData", params);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	public void deleteMedicationData(PatientMedication medication) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("ID", medication.getID());
		// System.out.println(medication.getID());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			if (medication.getID() != -1) {
				lc.executeUpdate("deleteMedicationData", params);
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}

	}

	// PatientMedication end

	// add by yongxin query the primary MD report
	@Override
	public ArrayList<PrimaryMDReportModel> getQueryPrimaryMDReprotList() {
		ArrayList<PrimaryMDReportModel> queryPrimaryMDList = new ArrayList<PrimaryMDReportModel>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());
			lc = new LibraryConnection(library, dbConnection);
			rs = lc.executeQuery("getAllPrimaryMDData", null);
			while (rs.next()) {
				PrimaryMDReportModel primaryMDReport = new PrimaryMDReportModel();
				primaryMDReport.setPrimaryMdReport(rs
						.getString("Primary Care Physician"));
				primaryMDReport.setLastReferral(rs
						.getDate("MaxOfDate of Referral"));
				primaryMDReport.setNoOfReferrals(rs.getInt("CountOfMRN"));
				primaryMDReport.setNoOfProcedures(rs
						.getInt("SumOfCountOfProcedureDate"));
				primaryMDReport.setNoOfCancers(rs.getInt("SumOfCountOfID"));
				primaryMDReport.setNoOfResections(rs
						.getInt("SumOfCountOfProcedureDate1"));
				queryPrimaryMDList.add(primaryMDReport);
			}
			return queryPrimaryMDList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {
			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	// add by yongxin
	@Override
	public ArrayList<PatientListModel> searchPrimaryPatientList(
			String primaryCarePhysician) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("primaryCarePhysician", primaryCarePhysician);
		ArrayList<PatientListModel> patientList = new ArrayList<PatientListModel>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());
			lc = new LibraryConnection(library, dbConnection);
			rs = lc.executeQuery("getPrimaryPatientList", params);
			while (rs.next()) {
				PatientListModel onePatient = new PatientListModel();
				onePatient.setMrn(rs.getString("MRN"));
				onePatient.setName(rs.getString("Name (Last,First)"));
				onePatient.setReferralDate(rs.getDate("Date of Referral"));
				onePatient.setNoOfProcedures(rs.getInt("CountOfProcedureDate"));
				onePatient.setReferringMD(rs.getString("Referring MD"));
				onePatient.setPrimaryCarePhysician(rs
						.getString("Primary Care Physician"));
				patientList.add(onePatient);
			}
			return patientList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {
			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<PrimaryMDReportModel> getQueryReferringMDReprotList() {
		ArrayList<PrimaryMDReportModel> queryReferringMDList = new ArrayList<PrimaryMDReportModel>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());
			lc = new LibraryConnection(library, dbConnection);
			rs = lc.executeQuery("getAllReferringMDData", null);
			while (rs.next()) {
				PrimaryMDReportModel referringMDReport = new PrimaryMDReportModel();
				referringMDReport.setReferringMDReport(rs
						.getString("Referring MD"));
				referringMDReport.setLastReferral(rs
						.getDate("MaxOfDate of Referral"));
				referringMDReport.setNoOfReferrals(rs.getInt("CountOfMRN"));
				referringMDReport.setNoOfCancers(rs.getInt("SumOfCountOfID"));
				referringMDReport.setNoOfProcedures(rs
						.getInt("SumOfCountOfProcedureDate"));
				referringMDReport.setNoOfResections(rs
						.getInt("SumOfCountOfProcedureDate1"));
				queryReferringMDList.add(referringMDReport);
			}
			return queryReferringMDList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {
			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;

	}

	@Override
	public ArrayList<PatientListModel> searchReferringPatientList(
			String referringPhysician) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("referringPhysician", referringPhysician);
		ArrayList<PatientListModel> patientList = new ArrayList<PatientListModel>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());
			lc = new LibraryConnection(library, dbConnection);
			rs = lc.executeQuery("getReferringPatientList", params);
			while (rs.next()) {
				PatientListModel onePatient = new PatientListModel();
				onePatient.setMrn(rs.getString("MRN"));
				onePatient.setName(rs.getString("Name (Last,First)"));
				onePatient.setReferralDate(rs.getDate("Date of Referral"));
				onePatient.setNoOfProcedures(rs.getInt("CountOfProcedureDate"));
				onePatient.setReferringMD(rs.getString("Referring MD"));
				onePatient.setPrimaryCarePhysician(rs
						.getString("Primary Care Physician"));
				patientList.add(onePatient);
			}
			return patientList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {
			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<ClinicScheduleReport> getClinicSchedule() {
		// TODO Auto-generated method stub

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("ClinicSchedule", null);

			while (rs.next()) {
				ClinicScheduleReport csr = new ClinicScheduleReport();

				csr.setMrn(rs.getString(1));
				csr.setName(rs.getString(2));
				csr.setSmokerStatusEntry(rs.getInt(3));
				csr.setSmokerStatusCurrent(rs.getInt(4));
				csr.setAlternativePhone(rs.getString(5));
				csr.setPhoneNumber(rs.getString(6));
				csr.setDob(rs.getDate(7));
				csr.setInsurance(rs.getString(8));
				csr.setInsurancePhone(rs.getString(9));
				csr.setInsuranceID(rs.getString(10));

				csr.setSecInsurance(rs.getString(11));
				csr.setSecInsurID(rs.getString(12));
				csr.setReferralNeeded(rs.getString(13));
				csr.setDateRequired(rs.getDate(14));
				csr.setDateScheduled(rs.getDate(15));
				csr.setToSee(rs.getString(16));
				csr.setRefNo(rs.getString(17));

				scheduleList.add(csr);
			}

			return scheduleList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;
	}

	@Override
	public ArrayList<VisitReport> getVisitReport() {
		// TODO Auto-generated method stub

		ArrayList<VisitReport> visitList = new ArrayList<VisitReport>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getVisitReport", null);

			while (rs.next()) {
				VisitReport vr = new VisitReport();

				vr.setMrn(rs.getString(1));
				vr.setDateRequired(rs.getDate(2));
				vr.setDateActVisit(rs.getDate(3));
				vr.setToSeenBy(rs.getString(4));
				vr.setSeenBy2(rs.getString(5));
				vr.setSmokerStatus(rs.getBoolean(6));
				vr.setPhoneCall(rs.getBoolean(7));

				visitList.add(vr);
			}

			return visitList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}

		return null;

	}

	public ArrayList<SelectItem> getBronchTypeList() {
		ArrayList<SelectItem> bronchList = new ArrayList<SelectItem>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getBronchTypeList", null);
			while (rs.next())
				bronchList.add(new SelectItem(rs.getInt("BronchNumber"), rs
						.getString("Bronch Type")));
			return bronchList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;

	}

	public ArrayList<Bronch> getBronchList(int autoNum) {

		ArrayList<Bronch> bronchList = new ArrayList<Bronch>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("autoNum", autoNum);
		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getBronchList", params);
			while (rs.next()) {
				Bronch b = new Bronch();
				b.setBronchType(rs.getInt("BronchType"));
				b.setLocation(rs.getString("LocationCode"));
				b.setRose(rs.getInt("ROSE"));
				b.setNumberPasses(rs.getInt("NumPasses"));
				b.setLymph(rs.getInt("Lymphocytes"));
				b.setBiopsyResult(rs.getString("BiopsyResult"));
				b.setComment(rs.getString("Comment"));
				b.setDiagnostic(rs.getString("Diagnostic"));
				b.setAccuracy(rs.getString("Accuracy"));
				b.setCulture(rs.getString("Culture"));
				b.setBronchAutoNum(rs.getInt("BronchAutoNum"));
				b.setEBUS(rs.getBoolean("EBUS"));
				b.setEMN(rs.getBoolean("EMN"));
				bronchList.add(b);
			}
			return bronchList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return null;
	}

	public void addNewBronch(Bronch newBronch, int autoNum) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("BiopsyNum", autoNum);
		params.put("BronchType", newBronch.bronchType);
		params.put("LocationCode", newBronch.location);
		params.put("BiopsyResult", newBronch.biopsyResult);
		params.put("Diagnostic", newBronch.diagnostic);
		params.put("Accuracy", newBronch.accuracy);
		params.put("Lymphocytes", newBronch.lymph);
		params.put("ROSE", newBronch.rose);
		params.put("NumPasses", newBronch.numberPasses);
		params.put("Culture", newBronch.culture);
		params.put("Comment", newBronch.comment);
		params.put("EBUS", newBronch.EBUS);
		params.put("EMN", newBronch.EMN);
		
		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("addBronch", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	// Added by Utpal
	@Override
	public void saveBronch(ArrayList<Bronch> b, int autoNum) {
		// TODO Auto-generated method stub

		// System.out.println("Executing Save Bronch ");

		for (int i = 0; i < b.size(); i++) {
			// System.out.println(b.get(i).getBiopsyAutoNum());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("BronchAutoNum", b.get(i).getBronchAutoNum());
			params.put("BronchType", b.get(i).getBronchType());
			params.put("LocationCode", b.get(i).getLocation());
			params.put("BiopsyResult", b.get(i).getBiopsyResult());
			params.put("Diagnostic", b.get(i).getDiagnostic());
			params.put("Accuracy", b.get(i).getAccuracy());
			params.put("Lymphocytes", b.get(i).getLymph());
			params.put("ROSE", b.get(i).getRose());
			params.put("NumPasses", b.get(i).getNumberPasses());
			params.put("Culture", b.get(i).getCulture());
			params.put("Comment", b.get(i).getComment());
			params.put("EBUS", b.get(i).getEBUS());
			params.put("EMN", b.get(i).getEMN());

			try {
				logger.debug("userid:" + cur_user.getUserId());

				lc.executeUpdate("saveBronch", params);
			} catch (SQLException e) {
				logger.error(e, e);
			} catch (Exception e) {

				logger.error(e, e);
			} finally {

			}
		}

	}

	// Added by Utpal
	public void deleteBronchData(Bronch bronch, int autoNum) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("BronchAutoNum", autoNum);
		// System.out.println("Deleting BronchAutoNum :- " + autoNum);

		try {
			logger.debug("userid:" + cur_user.getUserId());

			lc.executeUpdate("deleteBronchData", params);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}

	}

	public RegistryInfo getRegistryInfo(Patient patient) {
		RegistryInfo registryInfo = new RegistryInfo();
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", patient.getMrn());

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getRegistryInfo", params);
			while (rs.next()) {
				registryInfo.setAge(rs.getInt("Age"));
				registryInfo.setAlcohol(rs.getString("Alcohol"));
				registryInfo.setAlcoholBeer(rs.getInt("AlcoholBeer"));
				registryInfo.setAlcoholComment(rs.getString("AlcoholComment"));
				registryInfo.setAlcoholLiquor(rs.getInt("AlcoholLiquor"));
				registryInfo.setAlcoholRed(rs.getInt("AlcoholRed"));
				registryInfo.setAlcoholWhite(rs.getInt("AlcoholWhite"));
				registryInfo.setAsbestos(rs.getBoolean("Asbestos"));
				registryInfo.setBronchitis(rs.getBoolean("Bronchitis"));
				registryInfo.setChemicals(rs.getBoolean("Chemicals"));
				registryInfo.setChestRT(rs.getBoolean("ChestRT"));
				registryInfo.setCopd(rs.getBoolean("COPD"));
				registryInfo.setDailyVitamins(rs.getString("DailyVitamins"));
				registryInfo.setDob(rs.getDate("DateOfBirth"));
				registryInfo.setEducation(rs.getString("Education"));
				registryInfo
						.setExposureComment(rs.getString("ExposureComment"));
				registryInfo.setFamilyCancer(rs.getBoolean("FamilyCancer"));
				registryInfo.setFamilyCancerComment(rs
						.getString("FamilyCancerComment"));
				registryInfo.setFamLung(rs.getBoolean("FamLung"));
				registryInfo.setFibrosis(rs.getBoolean("Fibrosis"));
				registryInfo.setFish(rs.getString("Fish"));
				registryInfo.setFruit(rs.getString("Fruit"));
				registryInfo.setGender(rs.getString("Gender"));
				registryInfo.setGroundZero(rs.getString("GroundZero"));
				registryInfo.setHeight(rs.getInt("Height"));
				registryInfo.setLungCancerBrother(rs
						.getInt("LungCancerBrother"));
				registryInfo.setLungCancerFather(rs.getInt("LungCancerFather"));
				registryInfo.setLungCancerGF(rs.getInt("LungCancerGF"));
				registryInfo.setLungCancerGM(rs.getInt("LungCancerGM"));
				registryInfo.setLungCancerMother(rs.getInt("LungCancerMother"));
				registryInfo
						.setLungCancerOther(rs.getString("LungCancerOther"));
				registryInfo.setLungCancerSister(rs.getInt("LungCancerSister"));
				registryInfo.setMetals(rs.getBoolean("Metals"));
				registryInfo.setMining(rs.getBoolean("Mining"));
				registryInfo.setMrn(rs.getString("MRN"));
				registryInfo.setOccupation(rs.getString("Occupation"));
				registryInfo.setOmega3(rs.getBoolean("Omega3"));
				registryInfo.setPhysicalExercise(rs.getInt("PhysicalExercise"));
				registryInfo.setPhysicalWork(rs.getInt("PhysicalWork"));
				registryInfo.setPneumonia(rs.getBoolean("Pneumonia"));
				registryInfo.setPriorCancer(rs.getBoolean("PriorCancer"));
				registryInfo.setPriorHistory(rs.getString("PriorHistory"));
				registryInfo.setPriorLung(rs.getBoolean("PriorLung"));
				registryInfo.setRace1(rs.getString("Race1"));
				registryInfo.setRace2(rs.getString("Race2"));
				registryInfo.setRace3(rs.getString("Race3"));
				registryInfo.setRaceComment(rs.getString("RaceComment"));
				registryInfo.setRedMeat(rs.getString("RedMeat"));
				registryInfo.setRegistryDate(rs.getDate("RegistryDate"));
				registryInfo.setRegistryNum(rs.getInt("RegistryNum"));
				registryInfo
						.setScreeningBreast(rs.getString("ScreeningBreast"));
				registryInfo.setScreeningColon(rs.getString("ScreeningColon"));
				registryInfo.setScreeningPAP(rs.getString("ScreeningPAP"));
				registryInfo.setScreeningPhysical(rs
						.getString("ScreeningPhysical"));
				registryInfo.setScreeningProstate(rs
						.getString("ScreeningProstate"));
				registryInfo.setSecondComment(rs.getString("SecondComment"));
				registryInfo.setSecondSmoke(rs.getBoolean("SecondSmoke"));
				registryInfo.setSecondSmokeChild(rs.getInt("SecondSmokeChild"));
				registryInfo.setSecondSmokeSpouse(rs
						.getInt("SecondSmokeSpouse"));
				registryInfo.setSecondSmokeWork(rs.getInt("SecondSmokeWork"));
				registryInfo.setSmokerComment(rs.getString("SmokerComment"));
				registryInfo.setSmokerPackDay(rs.getFloat("SmokerPackDay"));
				registryInfo.setSmokerStatus(rs.getString("SmokerStatus"));
				registryInfo.setSmokerYearQuit(rs.getInt("SmokerYearQuit"));
				registryInfo.setSmokerYearStart(rs.getInt("SmokerYearStart"));
				registryInfo.setTuberculosis(rs.getBoolean("Tuberculosis"));
				registryInfo.setVegetable(rs.getString("Vegetable"));
				registryInfo.setVegetableBroccoli(rs
						.getString("VegetableBroccoli"));
				registryInfo.setVegetableLeafy(rs.getString("VegetableLeafy"));
				registryInfo.setVitaminA(rs.getBoolean("VitaminA"));
				registryInfo.setVitaminB(rs.getBoolean("VitaminB"));
				registryInfo.setVitaminE(rs.getBoolean("VitaminE"));
				registryInfo.setWeight(rs.getInt("Weight"));
			}
			return registryInfo;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getRaceList() {
		ArrayList<SelectItem> raceList = new ArrayList<SelectItem>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getRaceList", null);
			while (rs.next())
				raceList.add(new SelectItem(rs.getString("RaceName"), rs
						.getString("RaceName")));
			raceList.add(new SelectItem(null, ""));
			return raceList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getEducationList() {
		ArrayList<SelectItem> educationList = new ArrayList<SelectItem>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getEducationList", null);
			while (rs.next())
				educationList.add(new SelectItem(rs.getString("Education"), rs
						.getString("Education")));
			educationList.add(new SelectItem(null, ""));
			return educationList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getGroundZeroList() {
		ArrayList<SelectItem> groundZeroList = new ArrayList<SelectItem>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getGroundZeroList", null);
			while (rs.next())
				groundZeroList.add(new SelectItem(rs.getString("GroundZero"),
						rs.getString("GroundZero")));
			groundZeroList.add(new SelectItem(null, ""));
			return groundZeroList;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getDailySupplements() {
		ArrayList<SelectItem> dailySupplements = new ArrayList<SelectItem>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getDailySupplements", null);
			while (rs.next())
				dailySupplements.add(new SelectItem(
						rs.getString("Supplements"), rs
								.getString("Supplements")));
			dailySupplements.add(new SelectItem(null, ""));
			return dailySupplements;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getFoodTime() {
		ArrayList<SelectItem> foodTime = new ArrayList<SelectItem>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getFoodTime", null);
			while (rs.next())
				foodTime.add(new SelectItem(rs.getString("FoodTime"), rs
						.getString("FoodTime")));
			foodTime.add(new SelectItem(null, ""));
			return foodTime;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getIntake() {
		ArrayList<SelectItem> intake = new ArrayList<SelectItem>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getIntake", null);
			while (rs.next())
				intake.add(new SelectItem(rs.getString("Alcohol"), rs
						.getString("Alcohol")));
			intake.add(new SelectItem(null, ""));
			return intake;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	@Override
	public ArrayList<SelectItem> getScreening() {
		ArrayList<SelectItem> screening = new ArrayList<SelectItem>();

		ResultSet rs = null;
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getScreening", null);
			while (rs.next())
				screening.add(new SelectItem(rs.getString("Screening"), rs
						.getString("Screening")));
			screening.add(new SelectItem(null, ""));
			return screening;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	// added by Sun
	public String findCancerModelByMRN(String mrn) {
		String exist = null;
		Map<String, String> params = new HashMap<String, String>();
		params.put("mrn", mrn);
		ResultSet rs = null;
		try {
			rs = lc.executeQuery("searchMRNinCancerInfo", params);
			while (rs.next())
				exist = rs.getString("PatientMRN");
			return exist;
		} catch (SQLException e) {

			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}
		return null;
	}

	// added by Sun
	public void deleteResearch(Research r, Patient p) {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, String> params2 = new HashMap<String, String>();
		params.put("ResearchID", r.getID());
		params2.put("patientMRN", p.getMrn());
		try {
			lc.executeUpdate("deleteResearchData", params);
			lc.executeUpdate("deleteRegistryData", params2);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

		}
	}

	public void saveRegistryInfo(RegistryInfo registryInfo) {
		// TODO Auto-generated method stub
		logger.debug("saveRegistryInfo()-  registryInfo.getMrn(),getRegistryNum() "
				+ registryInfo.getMrn() + registryInfo.getRegistryNum());
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("registryno", registryInfo.getRegistryNum());
		params.put("mrn", registryInfo.getMrn());
		params.put("age", (registryInfo.getAge()));
		params.put("dob", registryInfo.getDob());
		params.put("gender", registryInfo.getGender());
		params.put("height", (registryInfo.getHeight()));
		params.put("weight", (registryInfo.getWeight()));
		params.put("race1", registryInfo.getRace1());
		params.put("race2", registryInfo.getRace2());
		params.put("race3", registryInfo.getRace3());
		params.put("racecomment", registryInfo.getRaceComment());
		params.put("education", registryInfo.getEducation());
		params.put("priorlung", (registryInfo.priorLung));
		params.put("priorcancer", (registryInfo.priorCancer));
		params.put("priorhistory", registryInfo.getPriorHistory());
		params.put("smokerstatus", registryInfo.getSmokerStatus());
		params.put("smokeryearstart", (registryInfo.getSmokerYearStart()));
		params.put("smokeryearquit", (registryInfo.getSmokerYearQuit()));
		params.put("smokerpackday", (registryInfo.getSmokerPackDay()));
		params.put("smokercomment", registryInfo.getSmokerComment());
		params.put("secondsmoke", (registryInfo.secondSmoke));
		params.put("secondsmokechild", (registryInfo.getSecondSmokeChild()));
		params.put("secondsmokespouse", (registryInfo.getSecondSmokeSpouse()));
		params.put("secondsmokework", (registryInfo.getSecondSmokeWork()));
		params.put("secondcomment", registryInfo.getSecondComment());
		params.put("famlung", (registryInfo.famLung));
		params.put("lungcancermother", (registryInfo.getLungCancerMother()));
		params.put("lungcancerfather", (registryInfo.getLungCancerFather()));
		params.put("lungcancersister", (registryInfo.getLungCancerSister()));
		params.put("lungcancerbrother", (registryInfo.getLungCancerBrother()));
		params.put("lungcancergm", (registryInfo.getLungCancerGM()));
		params.put("lungcancergf", (registryInfo.getLungCancerGF()));
		params.put("lungcancerother", registryInfo.getLungCancerOther());
		params.put("familycancer", (registryInfo.familyCancer));
		params.put("familycancercomment", registryInfo.getFamilyCancerComment());
		params.put("occupation", registryInfo.getOccupation());
		params.put("asbestos", (registryInfo.asbestos));
		params.put("metals", (registryInfo.metals));
		params.put("mining", (registryInfo.mining));
		params.put("chemicals", (registryInfo.chemicals));
		params.put("exposurecomment", registryInfo.getExposureComment());

		params.put("groundzero", registryInfo.getGroundZero());
		params.put("copd", (registryInfo.copd));
		params.put("tuberculosis", (registryInfo.tuberculosis));
		params.put("fibrosis", (registryInfo.fibrosis));
		params.put("pneumonia", (registryInfo.pneumonia));
		params.put("bronchitis", (registryInfo.bronchitis));
		params.put("chestrt", (registryInfo.chestRT));
		params.put("dailyvitamins", registryInfo.dailyVitamins);
		params.put("vitamina", (registryInfo.vitaminA));
		params.put("vitaminb", (registryInfo.vitaminB));
		params.put("vitamine", (registryInfo.vitaminE));
		params.put("omega3", (registryInfo.omega3));
		params.put("redmeat", registryInfo.getRedMeat());
		params.put("fish", registryInfo.getFish());
		params.put("fruit", registryInfo.getFruit());
		params.put("vegetable", registryInfo.getVegetable());
		params.put("vegetableleafy", registryInfo.getVegetableLeafy());
		params.put("vegetablebroccoli", registryInfo.getVegetableBroccoli());
		params.put("physicalwork", (registryInfo.getPhysicalWork()));
		params.put("physicalexercise", (registryInfo.getPhysicalExercise()));
		params.put("alcohol", registryInfo.getAlcohol());
		params.put("alcoholcomment", registryInfo.getAlcoholComment());
		params.put("alcoholred", (registryInfo.getAlcoholRed()));
		params.put("alcoholwhite", (registryInfo.getAlcoholWhite()));
		params.put("alcoholbeer", (registryInfo.getAlcoholBeer()));
		params.put("alcoholliquor", (registryInfo.getAlcoholLiquor()));
		params.put("screeningphysical", registryInfo.getScreeningPhysical());
		params.put("screeningbreast", registryInfo.getScreeningBreast());
		params.put("screeningcolon", registryInfo.getScreeningColon());
		params.put("screeningpap", registryInfo.getScreeningPAP());
		params.put("screeningprostate", registryInfo.getScreeningProstate());

		try {

			logger.debug("userid:" + cur_user.getUserId());
			if (registryInfo.getRegistryNum() == -1) {
				logger.debug("DataAdapter registryInfo.getRegistryNum()"
						+ registryInfo.getRegistryNum());
				lc.executeUpdate("addRegistryInfo", params);
			} else {
				logger.debug("executing saveRegistryInfo");
				lc.executeUpdate("saveRegistryInfo", params);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e, e);
		}
	}

	@Override
	public ArrayList<ClinicScheduleReport> getClinicScheduleForToday() {
		// TODO Auto-generated method stub

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		ResultSet rs = null;
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("date", new Date());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("ClinicScheduleForToday", params);

			while (rs.next()) {
				ClinicScheduleReport csr = new ClinicScheduleReport();

				csr.setMrn(rs.getString(1));
				csr.setName(rs.getString(2));
				csr.setSmokerStatusEntry(rs.getInt(3));
				csr.setSmokerStatusCurrent(rs.getInt(4));
				csr.setAlternativePhone(rs.getString(5));
				csr.setPhoneNumber(rs.getString(6));
				csr.setDob(rs.getDate(7));
				csr.setInsurance(rs.getString(8));
				csr.setInsurancePhone(rs.getString(9));
				csr.setInsuranceID(rs.getString(10));

				csr.setSecInsurance(rs.getString(11));
				csr.setSecInsurID(rs.getString(12));
				csr.setReferralNeeded(rs.getString(13));
				csr.setDateRequired(rs.getDate(14));
				csr.setDateScheduled(rs.getDate(15));
				csr.setToSee(rs.getString(16));
				csr.setRefNo(rs.getString(17));

				scheduleList.add(csr);
			}

			return scheduleList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;

	}

	@Override
	public ArrayList<ClinicScheduleReport> getClinicScheduleForYesterday() {
		// TODO Auto-generated method stub

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		ResultSet rs = null;
		HashMap<String, Object> params = new HashMap<String, Object>();

		Calendar cal = Calendar.getInstance();

		
		// subtracting a day
		cal.add(Calendar.DATE, -1);

		
		params.put("date", cal.getTime());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("ClinicScheduleForToday", params);

			while (rs.next()) {
				ClinicScheduleReport csr = new ClinicScheduleReport();

				csr.setMrn(rs.getString(1));
				csr.setName(rs.getString(2));
				csr.setSmokerStatusEntry(rs.getInt(3));
				csr.setSmokerStatusCurrent(rs.getInt(4));
				csr.setAlternativePhone(rs.getString(5));
				csr.setPhoneNumber(rs.getString(6));
				csr.setDob(rs.getDate(7));
				csr.setInsurance(rs.getString(8));
				csr.setInsurancePhone(rs.getString(9));
				csr.setInsuranceID(rs.getString(10));

				csr.setSecInsurance(rs.getString(11));
				csr.setSecInsurID(rs.getString(12));
				csr.setReferralNeeded(rs.getString(13));
				csr.setDateRequired(rs.getDate(14));
				csr.setDateScheduled(rs.getDate(15));
				csr.setToSee(rs.getString(16));
				csr.setRefNo(rs.getString(17));

				scheduleList.add(csr);
			}

			return scheduleList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;

	}

	public ArrayList<ClinicScheduleReport> getclinicSchedRepForTomorrow() {
		// TODO Auto-generated method stub

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		ResultSet rs = null;
		HashMap<String, Object> params = new HashMap<String, Object>();

		Calendar cal = Calendar.getInstance();

		// adding a day
		cal.add(Calendar.DATE, +1);

		params.put("date", cal.getTime());
		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("ClinicScheduleForToday", params);

			while (rs.next()) {
				ClinicScheduleReport csr = new ClinicScheduleReport();

				csr.setMrn(rs.getString(1));
				csr.setName(rs.getString(2));
				csr.setSmokerStatusEntry(rs.getInt(3));
				csr.setSmokerStatusCurrent(rs.getInt(4));
				csr.setAlternativePhone(rs.getString(5));
				csr.setPhoneNumber(rs.getString(6));
				csr.setDob(rs.getDate(7));
				csr.setInsurance(rs.getString(8));
				csr.setInsurancePhone(rs.getString(9));
				csr.setInsuranceID(rs.getString(10));

				csr.setSecInsurance(rs.getString(11));
				csr.setSecInsurID(rs.getString(12));
				csr.setReferralNeeded(rs.getString(13));
				csr.setDateRequired(rs.getDate(14));
				csr.setDateScheduled(rs.getDate(15));
				csr.setToSee(rs.getString(16));
				csr.setRefNo(rs.getString(17));

				scheduleList.add(csr);
			}

			return scheduleList;
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;

	}

	public ArrayList<ClinicScheduleReport> getClinicSchedRepForLastWeek() {

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		Calendar cal = Calendar.getInstance();
		// Set the first day 7 days back
		cal.add(Calendar.DATE, -7);

		// iterate to check for all days in the past week
		for (int i = 0; i < 7; i++) {
			ClinicScheduleReport csr = this.getClinicSchedRepForTheDate(cal);
			if(csr != null)
				scheduleList.add(csr);
			cal.add(Calendar.DATE, +1);
		}

		return scheduleList;
	}

	public ArrayList<ClinicScheduleReport> getClinicSchedRepForLastMonth() {

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		Calendar cal = Calendar.getInstance();
		// Set the first day 30 days back
		cal.add(Calendar.DATE, -30);

		// iterate to check for all days in the past month
		for (int i = 0; i < 30; i++) {
			ClinicScheduleReport csr = this.getClinicSchedRepForTheDate(cal);
			if(csr != null)
				scheduleList.add(csr);
			cal.add(Calendar.DATE, +1);
		}

		return scheduleList;
	}

	public ArrayList<ClinicScheduleReport> getClinicSchedRepForThisMonth() {

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);

		for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			ClinicScheduleReport csr = this.getClinicSchedRepForTheDate(cal);
			if(csr != null)
				scheduleList.add(csr);
			cal.add(Calendar.DATE, +1);
		}

		return scheduleList;
	}
	
	
	public ArrayList<ClinicScheduleReport> getClinicSchedRepForThisWeek() {

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, 1);

		for (int i = 0; i < cal.getActualMaximum(Calendar.DAY_OF_WEEK); i++) {
			ClinicScheduleReport csr = this.getClinicSchedRepForTheDate(cal);
			if(csr != null)
				scheduleList.add(csr);
			cal.add(Calendar.DATE, +1);
		}

		return scheduleList;
	}

	public ArrayList<ClinicScheduleReport> getClinicSchedRepForNextWeek() {

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		Calendar cal = Calendar.getInstance();

		for (int i = 0; i < 7; i++) {
			ClinicScheduleReport csr = this.getClinicSchedRepForTheDate(cal);
			if(csr != null)
				scheduleList.add(csr);
			cal.add(Calendar.DATE, +1);
		}

		return scheduleList;

	}

	public ArrayList<ClinicScheduleReport> getClinicSchedRepForNextMonth() {

		ArrayList<ClinicScheduleReport> scheduleList = new ArrayList<ClinicScheduleReport>();

		Calendar cal = Calendar.getInstance();

		for (int i = 0; i < 30; i++) {
			ClinicScheduleReport csr = this.getClinicSchedRepForTheDate(cal);
			if(csr != null)
				scheduleList.add(csr);
			cal.add(Calendar.DATE, +1);
		}

		return scheduleList;

	}

	public ClinicScheduleReport getClinicSchedRepForTheDate(Calendar cal) {
		

		ResultSet rs = null;
		HashMap<String, Object> params = new HashMap<String, Object>();

		params.put("date", cal.getTime());

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("ClinicScheduleForToday", params);

			while (rs.next()) {
				ClinicScheduleReport csr = new ClinicScheduleReport();

				csr.setMrn(rs.getString(1));
				csr.setName(rs.getString(2));
				csr.setSmokerStatusEntry(rs.getInt(3));
				csr.setSmokerStatusCurrent(rs.getInt(4));
				csr.setAlternativePhone(rs.getString(5));
				csr.setPhoneNumber(rs.getString(6));
				csr.setDob(rs.getDate(7));
				csr.setInsurance(rs.getString(8));
				csr.setInsurancePhone(rs.getString(9));
				csr.setInsuranceID(rs.getString(10));

				csr.setSecInsurance(rs.getString(11));
				csr.setSecInsurID(rs.getString(12));
				csr.setReferralNeeded(rs.getString(13));
				csr.setDateRequired(rs.getDate(14));
				csr.setDateScheduled(rs.getDate(15));
				csr.setToSee(rs.getString(16));
				csr.setRefNo(rs.getString(17));

				return csr;
			}
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {

			SqlUtils.close(rs);
		}

		return null;

	}

	@Override
	public ArrayList<String> getMrnList() {
		// TODO Auto-generated method stub
		ArrayList<String> mrnList = new ArrayList<String>(); 
		try {
			logger.debug("userid:" + cur_user.getUserId());
			ResultSet rs = null;
			rs = lc.executeQuery("getMrnList", null);
			while (rs.next()) {
				mrnList.add(rs.getString("MRN"));
			}
		}
	 catch (SQLException e) {
		logger.error(e, e);
	}
		return mrnList;
		
	}

	@Override
	public ArrayList<SelectItem> getMdListByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}



@Override
	public ArrayList<InsuranceDataModel> getInsuranceQueryData() {
		// TODO Auto-generated method stub
		ArrayList<InsuranceDataModel> insuranceList = new ArrayList<InsuranceDataModel>();
		Map<String, String> params = new HashMap<String, String>();
		ResultSet rs = null;

		try {
			logger.debug("userid:" + cur_user.getUserId());

			rs = lc.executeQuery("getAllInsuranceData", params);

			while (rs.next()) {
				InsuranceDataModel insuranceData = new InsuranceDataModel();
				insuranceData.setInsurCo(rs.getString("InsurCo"));
				insuranceData.setPhoneNumber1(rs.getString("Phone Number1"));
				insuranceData.setPhoneNumber2(rs.getString("Phone Number2"));
				insuranceData.setPhoneNumber2(rs.getString("Phone Number3"));
				insuranceData.setComment(rs.getString("Comment"));
				insuranceData.setCtPrecert(rs.getString("CTPrecert"));
				insuranceData.setPetPrecert(rs.getString("PETPrecert"));
				insuranceData.setPftPrecert(rs.getString("PFTPrecert"));
				insuranceData.setVisitReferral(rs.getString("VisitReferral"));
				insuranceList.add(insuranceData);
			}

		} catch (SQLException e) {
			logger.error(e, e);
		} catch (Exception e) {

			logger.error(e, e);
		} finally {
			SqlUtils.close(rs);

		}
		return insuranceList;

	
	}

}
