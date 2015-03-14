package lcec.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.primefaces.model.chart.CartesianChartModel;  
import org.primefaces.model.chart.ChartSeries;
import java.util.ArrayList;
import lcec.controller.QueryBean;
import lcec.model.QuartReport;

@ManagedBean(name = "charts")
@ViewScoped
public class Charts implements java.io.Serializable{
	private static Logger logger = LogManager.getLogger(Charts.class
		.getName());
	private static final long serialVersionUID = 1L;
	
	//Charts by rjosan
	private CartesianChartModel quartCancerDiagModel = null; 
	private CartesianChartModel quartNewRefModel = null; 
	private CartesianChartModel yearlyPetScans = null;
	private CartesianChartModel yearlyNewRefs = null;
	//End of Charts by rjosan
	//Added by sai
	private CartesianChartModel quartNewConsults = null;
	private CartesianChartModel quartProcedures = null;
	private CartesianChartModel quartPetscans = null;
	private CartesianChartModel quartLungresection = null;
	private CartesianChartModel quartRfacryo = null;
	private CartesianChartModel yearlyprocedures = null;
	public Charts() {   
	}  
	
	//Quart Cancer Diag
	public CartesianChartModel getQuartCancerDiagModel() { 
		
		 if (quartCancerDiagModel == null){
			 createQuartCancerDiagModel();
		 }
	        return quartCancerDiagModel;  
	    }  
	
	 private void createQuartCancerDiagModel() {  
		 
		
		 	quartCancerDiagModel = new CartesianChartModel();
	        QueryBean queryBean = new QueryBean();
	        ArrayList<QuartReport> data = queryBean.getQuartCancerDiag();
	  
	        ChartSeries qcd = new ChartSeries();  
	        
	        qcd.setLabel("Quarterly Cancer Diagnosis");  
	        
	        for (int i = 0 ; i< data.size();i++)
	        {
	        qcd.set(Integer.toString(data.get(i).getYear()) + " Q" + Integer.toString(data.get(i).getQuarter()) , data.get(i).getCount()); 
	        }

	        quartCancerDiagModel.addSeries(qcd);
	        logger.debug ("create Quart Cancer Diag Model");
	    }
	 
	 
	 
	 	//Quart New Refs
		public CartesianChartModel getQuartNewRefs() { 
			
			 if (quartNewRefModel == null){
				 createQuartNewRefs();
			 }
		        return quartNewRefModel;  
		    }  
		
		 private void createQuartNewRefs() {  
			 
			
			 	quartNewRefModel = new CartesianChartModel();
		        QueryBean queryBean = new QueryBean();
		        ArrayList<QuartReport> data = queryBean.getQuartNewRefs();
		  
		        ChartSeries qcd = new ChartSeries();  
		        
		        qcd.setLabel("Quarterly New Referrals");  
		        
		        for (int i = 0 ; i< data.size();i++)
		        {
		        qcd.set(Integer.toString(data.get(i).getYear()) + " Q" + Integer.toString(data.get(i).getQuarter()) , data.get(i).getCount()); 
		        }

		        quartNewRefModel.addSeries(qcd);
		        logger.debug ("create Quart New Refs");
		    }
	 
		//Added by sai
		 // quart new consults
			public CartesianChartModel getQuartNewConsults() { 
				
				 if (quartNewConsults == null){
					 createQuartNewConsults();
				 }
			        return quartNewConsults;  
			    }  
			
			 private void createQuartNewConsults() {  
				 
				
				 	quartNewConsults = new CartesianChartModel();
			        QueryBean queryBean = new QueryBean();
			        ArrayList<QuartReport> data = queryBean.getQuartNewConsults();
			  
			        ChartSeries qcd = new ChartSeries();  
			        
			        qcd.setLabel("Quarterly New Consults");  
			        
			        for (int i = 0 ; i< data.size();i++)
			        {
			        qcd.set(Integer.toString(data.get(i).getYear()) + " Q" + Integer.toString(data.get(i).getQuarter()) , data.get(i).getCount()); 
			        }

			        quartNewConsults.addSeries(qcd);
			        logger.debug ("create Quart New Consults");
			    }
			 //added by sai
			 //quart pet scans
			 public CartesianChartModel getQuartpetscans() { 
					
				 if (quartPetscans == null){
					 createQuartPetscans();
				 }
			        return quartPetscans;  
			    }  
			
			 private void createQuartPetscans() {  
				 
				
				 	quartPetscans = new CartesianChartModel();
			        QueryBean queryBean = new QueryBean();
			        ArrayList<QuartReport> data = queryBean.getQuartPETScans();
			  
			        ChartSeries qcd = new ChartSeries();  
			        
			        qcd.setLabel("Quarterly PET Scans");  
			        
			        for (int i = 0 ; i< data.size();i++)
			        {
			        qcd.set(Integer.toString(data.get(i).getYear()) + " Q" + Integer.toString(data.get(i).getQuarter()) , data.get(i).getCount()); 
			        }

			        quartPetscans.addSeries(qcd);
			        logger.debug ("create Quart Petscans");
			    }
			 //added by sai
			 //quart lung resection
			 public CartesianChartModel getQuartLungresection() { 
					
				 if (quartLungresection == null){
					 createQuartLungresection();
				 }
			        return quartLungresection;  
			    }  
			
			 private void createQuartLungresection() {  
				 
				
				 	quartLungresection = new CartesianChartModel();
			        QueryBean queryBean = new QueryBean();
			        ArrayList<QuartReport> data = queryBean.getQuartLungResec();
			  
			        ChartSeries qcd = new ChartSeries();  
			        
			        qcd.setLabel("Quarterly Lung Resection");  
			        
			        for (int i = 0 ; i< data.size();i++)
			        {
			        qcd.set(Integer.toString(data.get(i).getYear()) + " Q" + Integer.toString(data.get(i).getQuarter()) , data.get(i).getCount()); 
			        }

			        quartLungresection.addSeries(qcd);
			        logger.debug ("create Quart Lungre section");
			    }

			 //added by sai
			 //quart rfacryo
			 public CartesianChartModel getQuartRfacryo() { 
					
				 if (quartRfacryo == null){
					 createQuartRfacryo();
				 }
			        return quartRfacryo;  
			    }  
			
			 private void createQuartRfacryo() {  
				 
				
				 	quartRfacryo = new CartesianChartModel();
			        QueryBean queryBean = new QueryBean();
			        ArrayList<QuartReport> data = queryBean.getQuartRFACryo();
			  
			        ChartSeries qcd = new ChartSeries();  
			        
			        qcd.setLabel("Quarterly RFA Cryo");  
			        
			        for (int i = 0 ; i< data.size();i++)
			        {
			        qcd.set(Integer.toString(data.get(i).getYear()) + " Q" + Integer.toString(data.get(i).getQuarter()) , data.get(i).getCount()); 
			        }

			        quartRfacryo.addSeries(qcd);
			        logger.debug ("create Quart Rfacryo");
			    }


			//Added by sai
			 // quart Procedures
				public CartesianChartModel getQuartProcedures() { 
					
					 if (quartProcedures == null){
						 createQuartProcedures();
					 }
				        return quartProcedures;  
				    }  
				
				 private void createQuartProcedures() {  
					 
					
					 	quartProcedures = new CartesianChartModel();
				        QueryBean queryBean = new QueryBean();
				        ArrayList<QuartReport> data = queryBean.getQuartProcedures();
				  
				        ChartSeries qcd = new ChartSeries();  
				        
				        qcd.setLabel("Quarterly Procedures");  
				        
				        for (int i = 0 ; i< data.size();i++)
				        {
				        qcd.set(Integer.toString(data.get(i).getYear()) + " Q" + Integer.toString(data.get(i).getQuarter()) , data.get(i).getCount()); 
				        }

				        quartProcedures.addSeries(qcd);
				        logger.debug ("create Quart Procedures");
				    }
 
		//Yearly PET Scans
			public CartesianChartModel getYearlyPetScans() { 
				
				 if (yearlyPetScans == null){
					 createYearlyPetScans();
				 }
			        return yearlyPetScans;  
			    }  
			
			 private void createYearlyPetScans() {  
				 
				
				 	yearlyPetScans = new CartesianChartModel();
			        QueryBean queryBean = new QueryBean();
			        ArrayList<QuartReport> data = queryBean.getYearlyPETScans();
			  
			        ChartSeries qcd = new ChartSeries();  
			        
			        qcd.setLabel("Yearly PET Scans");  
			        
			        for (int i = 0 ; i< data.size();i++)
			        {
			        qcd.set(Integer.toString(data.get(i).getYear()) , data.get(i).getCount()); 
			        }

			        yearlyPetScans.addSeries(qcd);
			        logger.debug ("create Yearly Pet Scans");
			    }
	 
			 
			 
				//Yearly New Referrals
				public CartesianChartModel getYearlyNewRefs() { 
					
					 if (yearlyNewRefs == null){
						 createYearlyNewRefs();
					 }
				        return yearlyNewRefs;  
				    }  
				
				 private void createYearlyNewRefs() {  
					 
					
					 yearlyNewRefs = new CartesianChartModel();
				        QueryBean queryBean = new QueryBean();
				        ArrayList<QuartReport> data = queryBean.getYearlyNewRefs();
				  
				        ChartSeries qcd = new ChartSeries();  
				        
				        qcd.setLabel("Yearly New  Referrals");  
				        
				        for (int i = 0 ; i< data.size();i++)
				        {
				        qcd.set(Integer.toString(data.get(i).getYear()) , data.get(i).getCount()); 
				        }

				        yearlyNewRefs.addSeries(qcd);
				        logger.debug ("create Yearly New Refs");
				    }
				 //added by sai
				//Yearly procedures
					public CartesianChartModel getYearlyprocedures() { 
						
						 if (yearlyprocedures == null){
							 createYearlyprocedures();
						 }
					        return yearlyprocedures;  
					    }  
					
					 private void createYearlyprocedures() {  
						 
						
						 yearlyprocedures = new CartesianChartModel();
					        QueryBean queryBean = new QueryBean();
					        ArrayList<QuartReport> data = queryBean.getyearlyProcedures();
					  
					        ChartSeries qcd = new ChartSeries();  
					        
					        qcd.setLabel("Yearly Procedures");  
					        
					        for (int i = 0 ; i< data.size();i++)
					        {
					        qcd.set(Integer.toString(data.get(i).getYear()) , data.get(i).getCount()); 
					        }

					        yearlyprocedures.addSeries(qcd);
					        logger.debug ("create Yearly procedures");
					    }
	}  

