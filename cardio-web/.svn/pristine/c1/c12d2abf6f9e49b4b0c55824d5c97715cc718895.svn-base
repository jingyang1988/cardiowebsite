package lcec.controller;



import java.io.Serializable;  
import java.util.ArrayList;
import lcec.controller.QueryBean;
import org.primefaces.model.chart.CartesianChartModel;  
import org.primefaces.model.chart.ChartSeries; 
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

	  
@ManagedBean
@RequestScoped
	public class ChartBean implements Serializable {  
	  
	    private CartesianChartModel categoryModel;  
	  
	    public ChartBean() {  
	    	//System.out.println("Inside constructor");
	        //createCategoryModel();  
	    }  
	  
	    public CartesianChartModel getCategoryModel() {  
	    	
	    	//System.out.println("Inside getCategoryModel()");
	        return categoryModel;  
	    }  
	  
	    @PostConstruct
	   public void init() {
//	    private void createCategoryModel() {  
	    	
	    	//System.out.println("Inside init()");
	    	categoryModel = new CartesianChartModel(); 
	    	
	    	
	    	//System.out.println("Inside Function Category Model");
	    	
	    	QueryBean obj = new QueryBean();
	    	
	    	ArrayList<Integer> patientage = obj.getPatientAge();
	    	
	    	//System.out.println("After accessing QueryBean");
	    	
	    	ArrayList<Integer> grp1 = new ArrayList<Integer>();
	    	ArrayList<Integer> grp2 = new ArrayList<Integer>();
	    	ArrayList<Integer> grp3 = new ArrayList<Integer>();
	    	ArrayList<Integer> grp4 = new ArrayList<Integer>();
	    	ArrayList<Integer> grp5 = new ArrayList<Integer>();
	    	ArrayList<Integer> grp6 = new ArrayList<Integer>();
	    	ArrayList<Integer> grp7 = new ArrayList<Integer>();
	    	
	    	for(Integer i : patientage)
	    		{
	    		//System.out.println("Patient age is :"+ i);	
	    		if(i.intValue() > 0 && i.intValue() <= 20 )
	    			{
	    			grp1.add(i);
	    			}
	    		else if(i.intValue() > 20  && i.intValue() <= 40 )
    				{
	    			grp2.add(i);
    				}
	    		else if(i.intValue() > 40 && i.intValue() <= 50 )
	    			{
	    			grp3.add(i);
	    			}
	    		else if(i.intValue() > 50 && i.intValue() <= 60 )
	    			{
	    			grp4.add(i);
	    			}
	    		else if(i.intValue() > 60 && i.intValue() <= 70 )
	    			{
	    			grp5.add(i);
	    			}
	    		else if(i.intValue() > 70 && i.intValue() <= 80 )
	    			{
	    			grp6.add(i);
	    			}
	    		else if(i.intValue() > 80) 
	    			{
	    			grp7.add(i);
	    			}
	    		}
	    
	    	int size1 = grp1.size();
	    	//System.out.println("Size 1 value"+size1);
	    	int size2 = grp2.size();
	    	//System.out.println("Size 2 value"+size2);
	    	int size3 = grp3.size();
	    	//System.out.println("Size 3 value"+size3);
	    	int size4 = grp4.size();
	    	//System.out.println("Size 4 value"+size4);
	    	int size5 = grp5.size();
	    	//System.out.println("Size 5 value"+size5);
	    	int size6 = grp6.size();
	    	//System.out.println("Size 6 value"+size6);
	    	int size7 = grp7.size();
	    	//System.out.println("Size 7 value"+size7);
	    	//System.out.print("After inserting into groups");
	        ChartSeries patient = new ChartSeries();  
	        
	        patient.setLabel("Patients");  
	  
	        patient.set("0-20", size1);  
	        patient.set("21-40", size2);  
	        patient.set("41-50", size3);  
	        patient.set("51-60", size4);  
	        patient.set("61-70", size5);  
	        patient.set("71-80", size6);
	        patient.set("80+", size7);
	        
	        categoryModel.addSeries(patient);  
	          
	    }  
	}  
	                      	
	

