package lcec.controller;

/**
 * @author Abhinav Mishra
 * Returns Dummy MRN
 */
import java.io.Serializable;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



	  
@ManagedBean
@RequestScoped


public class DummyMRN implements Serializable {
	private static Logger logger = LogManager.getLogger(DummyMRN.class
		.getName());
	private int mrn;
	public DummyMRN() {
		 	
		 logger.debug ("DummyMRN: Inside constructor");
	}
	
	
	 public int getMrn() {  
		 	logger.debug ("getMrn: "+mrn);
	        return mrn;  
	    }  
	
	 @PostConstruct
	   public void init() {
		
		Random r = new Random();
		int Low = 10;
		int High = 10000;
		 mrn = r.nextInt(High-Low) + Low;
		 logger.debug ("init: "+mrn);
	}

}
