package lcec.model;

public class rptPreOpsModel implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int MRN;
	private String name;
	private int workupstatus;
	private String phonenumber;
	
	
	public int getMRN()
	{
		return MRN;
	}
	
	public String getname()
	{
		return name;
	}
	
	public int getworkupstatus()
	{
		return workupstatus;
	}
	public String getphonenumber()
	{
		return phonenumber;
	}
	
	public void setMRN(int mrn)
	{
		this.MRN = mrn;
	}
	
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public void setworkupstatus(int workupstatus)
	{
		this.workupstatus = workupstatus;
	}
	
	public void setphonenumber(String phonenumber)
	{
		this.phonenumber = phonenumber;
	}
	
}
