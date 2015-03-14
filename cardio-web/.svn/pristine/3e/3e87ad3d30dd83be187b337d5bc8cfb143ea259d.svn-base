package lcec.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import lcec.model.DataAdapter;
import lcec.model.IDataAdapter;
import lcec.model.Patient;

@ManagedBean(name="utilBean")
@RequestScoped
public class UtilBean {

	// Array Lists
	private ArrayList<SelectItem> mdList = null;
	private ArrayList<String> RefMDListByName = null;
	private ArrayList<SelectItem> insuranceList = null;
	private ArrayList<SelectItem> genderList = null;
	private ArrayList<SelectItem> workupList = null;
	private ArrayList<SelectItem> lcecStatusList = null;
	private ArrayList<SelectItem> lesionClassificaitonList = null;
	private ArrayList<SelectItem> biopsyTypesList = null;
	private ArrayList<SelectItem> biopsyAccuracyList = null;
	private ArrayList<SelectItem> resultDiagnosticList = null;
	private ArrayList<SelectItem> complicationList = null;
	private ArrayList<SelectItem> lcecPhysiciansList = null;
	private ArrayList<SelectItem> locationList = null;
	private ArrayList<SelectItem> visittypeList = null;
	private ArrayList<SelectItem> smokestatusList = null;
	private ArrayList<SelectItem> testTypeList = null;
	private ArrayList<SelectItem> testResultListByType = null;
	private ArrayList<SelectItem> lesionCtCharacteristic = null;
	private ArrayList<SelectItem> researchProjList = null;
	private ArrayList<SelectItem> lesionDignosisList=null;
	private ArrayList<SelectItem> roleList=null;

	// added
	private ArrayList<SelectItem> cancerTypeList = null;
	private ArrayList<SelectItem> histList = null;
	private ArrayList<SelectItem> stageTList = null;
	private ArrayList<SelectItem> stageNList = null;
	private ArrayList<SelectItem> stageMList = null;
	private ArrayList<SelectItem> stageTNMList = null;
	private ArrayList<SelectItem> cancerTxList = null;	
	
	//for medication use
	private ArrayList<SelectItem> medicineNameList = null;
	private ArrayList<SelectItem> strengthUnitList = null;
	private ArrayList<SelectItem> doseUnitList = null;
	private ArrayList<SelectItem> howTakenList = null;
	private ArrayList<SelectItem> givenTypeList = null;
	private ArrayList<SelectItem> bronchTypeList = null;
	
	private ArrayList<SelectItem> raceList = null;
	private ArrayList<SelectItem> educationList = null;
	private ArrayList<SelectItem> groundZeroList = null;
	private ArrayList<SelectItem> dailySupplements = null;
	private ArrayList<SelectItem> foodTime = null;
	private ArrayList<SelectItem> intake = null;
	private ArrayList<SelectItem> screening = null;
	
	public ArrayList<SelectItem> getScreening(){
		if(this.screening == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.screening = adapter.getScreening();
				//logger.debug ("getScreening: " + this.screening.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.screening;
	}

	
	public ArrayList<SelectItem> getIntake(){
		if(this.intake == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.intake = adapter.getIntake();
				//logger.debug ("getIntake: " + this.intake.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.intake;
	}
	
	public ArrayList<SelectItem> getFoodTime(){
		if(this.foodTime == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.foodTime = adapter.getFoodTime();
				//logger.debug ("getFoodTime: " + this.foodTime.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.foodTime;
	}
	
	public ArrayList<SelectItem> getDailySupplements(){
		if(this.dailySupplements == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.dailySupplements = adapter.getDailySupplements();
				//logger.debug ("getDailySupplements: " + this.dailySupplements.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.dailySupplements;
	}
	
	public ArrayList<SelectItem> getGroundZeroList(){
		if(this.groundZeroList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.groundZeroList = adapter.getGroundZeroList();
				//logger.debug ("getGroundZeroList: " + this.groundZeroList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.groundZeroList;
	}
	
	public ArrayList<SelectItem> getBronchTypeList(){
		if(this.bronchTypeList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.bronchTypeList = adapter.getBronchTypeList();
				//logger.debug ("getBronchTypeList: " + this.bronchTypeList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.bronchTypeList;
	}


	public ArrayList<SelectItem> getRoleList() {
		if(this.roleList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.roleList = adapter.getRoleList();
				//logger.debug ("getRoleList: " + this.roleList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.roleList;
	}


	public ArrayList<SelectItem> getMDList() {
		if(this.mdList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.mdList = adapter.getMDList();
				//logger.debug ("getMDList: " + this.mdList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.mdList;
	}
	
	public ArrayList<String> getRefMDListByName(String name) {
		if(this.RefMDListByName == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.RefMDListByName = adapter.getRefMdListByName(name);
				//logger.debug ("getRefMDListByName: " + this.RefMDListByName.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.RefMDListByName;
	}
	
	public ArrayList<SelectItem> getMdListByName(String name) {
		if(this.mdList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.mdList = adapter.getMdListByName(name);
				//logger.debug ("getMdListByName: " + this.mdList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.mdList;
	}
	

	public ArrayList<SelectItem> getInsuranceList() {
		if(this.insuranceList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				this.insuranceList = adapter.getInsuranceList();
				//logger.debug ("getInsuranceList: " + this.insuranceList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return insuranceList;
	}

	public ArrayList<SelectItem> getGenderList() {
		if(this.genderList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.genderList = adapter.getGenderList();
				//logger.debug ("getGenderList: " + this.genderList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return genderList;
	}

	public ArrayList<SelectItem> getWorkupList() {
		if(this.workupList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.workupList = adapter.getWorkupList();
				//logger.debug ("getWorkupList: " + this.workupList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return workupList;
	}

	public ArrayList<SelectItem> getLcecStatusList() {
		if(this.lcecStatusList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.lcecStatusList = adapter.getLCECStatusList();
				//logger.debug ("getLcecStatusList: " + this.lcecStatusList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return lcecStatusList;
	}

	public ArrayList<SelectItem> getLesionClassificaitonList() {
		if(this.lesionClassificaitonList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.lesionClassificaitonList = adapter.getLesionClassificaitonList();
				//logger.debug ("getLesionClassificaitonList: " + this.lesionClassificaitonList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.lesionClassificaitonList;
	}

	public ArrayList<SelectItem> getBiopsyTypesList() {
		if(this.biopsyTypesList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.biopsyTypesList = adapter.getBiopsyTypesList();
				//logger.debug ("getBiopsyTypesList: " + this.biopsyTypesList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.biopsyTypesList;
	}

	public ArrayList<SelectItem> getBiopsyAccuracyList() {
		if(this.biopsyAccuracyList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.biopsyAccuracyList = adapter.getBiopsyAccuracyList();
				//logger.debug ("getBiopsyAccuracyList: " + this.biopsyAccuracyList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.biopsyAccuracyList;
	}

	public ArrayList<SelectItem> getResultDiagnosticList() {
		if(this.resultDiagnosticList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.resultDiagnosticList = adapter.getResultDiagnosticList();
				//logger.debug ("getResultDiagnosticList: " + this.resultDiagnosticList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.resultDiagnosticList;
	}
	public ArrayList<SelectItem> getLesionDignosisList() {
		if(this.lesionDignosisList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.lesionDignosisList = adapter.getLesionDignosisList();
				//logger.debug ("getLesionDignosisList: " + this.lesionDignosisList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.lesionDignosisList;
	}

	public ArrayList<SelectItem> getComplicationList() {
		if(this.complicationList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.complicationList = adapter.getComplicationList();
				//logger.debug ("getComplicationList: " + this.complicationList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.complicationList;
	}

	public ArrayList<SelectItem> getLcecPhysiciansList() {
		if(this.lcecPhysiciansList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.lcecPhysiciansList = adapter.getLcecPhysiciansList();
				//logger.debug ("getLcecPhysiciansList: " + this.complicationList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.lcecPhysiciansList;
	}

	public ArrayList<SelectItem> getLocationList() {
		if(this.locationList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.locationList = adapter.getLocationList();
				//logger.debug ("getLocationList: " + this.locationList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.locationList;
	}

	public ArrayList<SelectItem> getVisittypeList() {
		if(this.visittypeList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.visittypeList = adapter.getVisittypeList();
				//logger.debug ("getVisittypeList: " + this.visittypeList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.visittypeList;
	}

	public ArrayList<SelectItem> getSmokestatusList() {
		if(this.smokestatusList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.smokestatusList = adapter.getSmokestatusList();
				//logger.debug ("getSmokestatusList: " + this.smokestatusList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.smokestatusList;
	}

	public ArrayList<SelectItem> getTestTypeList() {
		if(this.testTypeList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.testTypeList = adapter.getTestTypeList();
				//logger.debug ("getTestTypeList: " + this.testTypeList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.testTypeList;
	}
	public ArrayList<SelectItem> getTestResultListByType(int resultType) {
		if(this.testResultListByType == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.testResultListByType = adapter.getTestResultListByType(resultType);
				//logger.debug ("getTestResultListByType: " + this.testResultListByType.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.testResultListByType;
	}

	public ArrayList<SelectItem> getLesionCtCharacteristic() {
		if(this.lesionCtCharacteristic == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.lesionCtCharacteristic = adapter.getLesionCtCharacteristic();
				//logger.debug ("getLesionCtCharacteristic: " + this.lesionCtCharacteristic.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.lesionCtCharacteristic;

	}
	public ArrayList<SelectItem> getResearchProjList() {
		if(this.researchProjList  == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.researchProjList = adapter.getResearchProjList();
				//logger.debug ("getResearchProjList: " + this.researchProjList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.researchProjList;
	}

	public ArrayList<SelectItem> getCancerTypeList() {
		if(this.cancerTypeList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				this.cancerTypeList = adapter.getCancerTypeList();
				//logger.debug ("getCancerTypeList: " + this.cancerTypeList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.cancerTypeList;
	}	
	public ArrayList<SelectItem> getHistList() {
		if(this.histList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.histList = adapter.getHistList();
				//logger.debug ("getHistList: " + this.histList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.histList;
	}
	public ArrayList<SelectItem> getStageTList() {
		if(this.stageTList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.stageTList = adapter.getStageTList();
				//logger.debug ("getStageTList: " + this.stageTList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.stageTList;
	}
	public ArrayList<SelectItem> getStageNList() {
		if(this.stageNList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.stageNList = adapter.getStageNList();
				//logger.debug ("getStageNList: " + this.stageNList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.stageNList;
	}
	public ArrayList<SelectItem> getStageMList() {
		if(this.stageMList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.stageMList = adapter.getStageMList();
				//logger.debug ("getStageMList: " + this.stageMList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.stageMList;
	}
	public ArrayList<SelectItem> getStageTNMList() {
		if(this.stageTNMList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.stageTNMList = adapter.getStageTNMList();
				//logger.debug ("getStageTNMList: " + this.stageTNMList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.stageTNMList;
	}
	public ArrayList<SelectItem> getCancerTxList() {
		if(this.cancerTxList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.cancerTxList = adapter.getCancerTxList();
				//logger.debug ("getCancerTxList: " + this.cancerTxList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.cancerTxList;
	}
	
	
	public ArrayList<SelectItem> getMedicineNameList() {
		if(this.medicineNameList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.medicineNameList = adapter.getMedicineNameList();
				//logger.debug ("getMedicineNameList: " + this.medicineNameList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.medicineNameList;
	}
	
	public ArrayList<SelectItem> getStrengthUnitList() {
		if(this.strengthUnitList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.strengthUnitList = adapter.getStrengthUnitList();
				//logger.debug ("getStrengthUnitList: " + this.strengthUnitList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.strengthUnitList;
	}
	
	public ArrayList<SelectItem> getDoseUnitList() {
		if(this.doseUnitList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.doseUnitList = adapter.getDoseUnitList();
				//logger.debug ("getDoseUnitList: " + this.doseUnitList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.doseUnitList;
	}
	
	public ArrayList<SelectItem> getHowTakenList() {
		if(this.howTakenList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				
				this.howTakenList = adapter.getHowTakenList();
				//logger.debug ("getHowTakenList: " + this.howTakenList.toString ( ));
			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.howTakenList;
	}
	
	public ArrayList<SelectItem> getGivenTypeList() {
		if(this.givenTypeList == null){
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()){
				this.givenTypeList = adapter.getGivenTypeList();
				//logger.debug ("getGivenTypeList: " + this.givenTypeList.toString ( ));

			}catch(Exception ex){
				//logger.error (ex, ex);
			}
		}
		return this.givenTypeList;
	}
	
	public ArrayList<SelectItem> getRaceList() {
		if(this.raceList == null) {
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				
				this.raceList = adapter.getRaceList();
				//logger.debug ("getRaceList: " + this.raceList.toString ( ));
			}catch(Exception e) {
				e.printStackTrace();
				//logger.error (e, e);
			}
		}
		return this.raceList;
	}
	
	public ArrayList<SelectItem> getEducationList() {
		if(this.educationList == null) {
			try(IDataAdapter adapter = DataAdapter.getDataAdapter()) {
				
				this.educationList = adapter.getEducationList();
				//logger.debug ("getEducationList: " + this.educationList.toString ( ));
			}catch(Exception e) {
				e.printStackTrace();
				//logger.error (e, e);
			}
		}
		return this.educationList;
	}
	
}


