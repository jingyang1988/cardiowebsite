package lcec.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class SelectBooleanView {
	
	private boolean value1 = false;
	
	public SelectBooleanView() {  
    	
    }  
	public boolean getValue1() {  
    	
		QueryBean obj = new QueryBean();
		if(obj.setState()==true){
			System.out.println("If clause success"+obj.setState());
			this.value1 = true;
		}
        return value1;  
    }  
	
public void setValue1(boolean value1) {  
    	
		if(this.value1==false){
			System.out.println("Checkbox checked");
			QueryBean obj = new QueryBean();
			obj.saveState();
			
		}
		else if(this.value1==true){
			System.out.println("Checkbox Unchecked");
			QueryBean obj = new QueryBean();
			obj.saveState0();
		}
		
        this.value1=value1;  
    } 
	@PostConstruct
	public void init() {
		
		/*if(this.value1 == true)
		{
			this.value1 = true;
		}
		
		else{*/
		/*QueryBean obj = new QueryBean();
		if(obj.getChartStatus()==false)
			this.value1 = true;
		else this.value1=false;*/
		//}
	}

}
