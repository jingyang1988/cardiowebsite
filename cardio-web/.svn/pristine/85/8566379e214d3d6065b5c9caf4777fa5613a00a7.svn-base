package lcec.model;


import java.io.Serializable;
import java.util.Date;

public class PatientTesting implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientTesting(){
		this.ID = 3;
	}
	
	// Test details	
	private String MRN;
	private int ID;
	// added TestTypeName;
	private String TestTypeName;
	private int TestType;
	private Date RequiredDate;
	private Date ScheduledDate;
	private Date TestingDate;
	private int TestingResult;
	private String Comment;
	
	
	private Boolean Cancelled;
	private Boolean OrderByLCEC;
	
	private String PrecertNumber;
	private Boolean FUwithMD;
	private int AutoNum;
	
	private float Fev1;
	private float FevPer;
	private float Fvc;
	private float FvcPer;
	private float Dlco;
	private float DlcoPer;
	private float Fev1OrFvc;
	private String Interpretation;
	private boolean TypePFT = false;
	
	public boolean isTypePFT() {
		return TypePFT;
	}
	public void handleTypePFT() {
		TypePFT = (getTestType()==600) ? true : false;
	}
	public int getAutoNum() {
		return AutoNum;
	}
	public void setAutoNum(int autoNum) {
		AutoNum = autoNum;
	}
	public String getMRN() {
		return MRN;
	}
	public void setMRN(String mRN) {
		MRN = mRN;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTestTypeName() {
		return TestTypeName;
	}
	public void setTestTypeName(String testTypeName) {
		TestTypeName = testTypeName;
	}	
	public int getTestType() {
		return TestType;
	}
	public void setTestType(int testType) {
		TestType = testType;
	}
	public Date getRequiredDate() {
		return RequiredDate;
	}
	public void setRequiredDate(Date requiredDate) {
		RequiredDate = requiredDate;
	}
	public Date getScheduledDate() {
		return ScheduledDate;
	}
	public void setScheduledDate(Date scheduledDate) {
		ScheduledDate = scheduledDate;
	}
	public Date getTestingDate() {
		return TestingDate;
	}
	public void setTestingDate(Date testingDate) {
		TestingDate = testingDate;
	}
	public int getTestingResult() {
		return TestingResult;
	}
	public void setTestingResult(int testingResult) {
		TestingResult = testingResult;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	
	public Boolean getCancelled() {
		return Cancelled;
	}
	public void setCancelled(Boolean cancelled) {
		Cancelled = cancelled;
	}
	public Boolean getOrderByLCEC() {
		return OrderByLCEC;
	}
	public void setOrderByLCEC(Boolean orderByLCEC) {
		OrderByLCEC = orderByLCEC;
	}
	
	public String getPrecertNumber() {
		return PrecertNumber;
	}
	public void setPrecertNumber(String precertNumber) {
		PrecertNumber = precertNumber;
	}
	public Boolean getFUwithMD() {
		return FUwithMD;
	}
	public void setFUwithMD(Boolean fUwithMD) {
		FUwithMD = fUwithMD;
	}
	public float getFev1() {
		return Fev1;
	}
	public void setFev1(float fev1) {
		Fev1 = fev1;
	}
	public float getFevPer() {
		return FevPer;
	}
	public void setFevPer(float fevPer) {
		FevPer = fevPer;
	}
	public float getFvc() {
		return Fvc;
	}
	public void setFvc(float fvc) {
		Fvc = fvc;
	}
	public float getFvcPer() {
		return FvcPer;
	}
	public void setFvcPer(float fvcPer) {
		FvcPer = fvcPer;
	}
	public float getDlco() {
		return Dlco;
	}
	public void setDlco(float dlco) {
		Dlco = dlco;
	}
	public float getDlcoPer() {
		return DlcoPer;
	}
	public void setDlcoPer(float dlcoPer) {
		DlcoPer = dlcoPer;
	}
	public String getInterpretation() {
		return Interpretation;
	}
	public void setInterpretation(String interpretation) {
		Interpretation = interpretation;
	}
	public float getFev1OrFvc() {
		return Fev1OrFvc;
	}
	public void setFev1OrFvc(float fev1OrFvc) {
		Fev1OrFvc = fev1OrFvc;
	}
	
}
