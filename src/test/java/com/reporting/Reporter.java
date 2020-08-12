package com.reporting;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.listener.TestNGKeys;
import com.reporting.pojos.Scenario;
import com.reporting.snapshot.SnapshotManager;
import com.util.Constant;
import com.util.Util;

public class Reporter {
	private static int testCounter=1;
	static Map<Integer, List<Scenario>> testMap = new HashMap<Integer, List<Scenario>>();
	private static List<ArrayList<Scenario>> listOfList;

	public static void initialize() {
		listOfList = new ArrayList<ArrayList<Scenario>>();
	}

	public static synchronized List<ArrayList<Scenario>> getListOfList() {
		return listOfList;
	}

	public static void onStart(HashMap<TestNGKeys, String> testDataMap) {
		Scenario.setInParallel(testDataMap.get(TestNGKeys.parallel));
		Scenario.setThreadCount(testDataMap.get(TestNGKeys.threadCount));
		Scenario.setTestNG_SuiteName(testDataMap.get(TestNGKeys.suite));
		//TODO Test.setTestNG_TestName(testDataMap.get(TestNGKeys.test));
		Scenario.setTestExecutionStartDate((new Date()).getTime());
	}

	public static synchronized void onExecutionFinish() {
		File file=new File(Constant.getResultFolderPath());
		deleteDirectory(file);
		long time_start = Long.MAX_VALUE;
		long time_end = Long.MIN_VALUE;
		//System.out.println("Finished: ");
		Scenario.setTestExecutionEndDate((new Date()).getTime());
		time_start = Math.min(Scenario.getTestExecutionStartDate(), time_start);
		time_end = Math.max(Scenario.getTestExecutionEndDate(), time_end);
		Scenario.setTestExecutionTime(Util.timeConversion((time_end - time_start)));
		
		//Discontinued on 15 Jan 2019
		//CustomReportHTML_NonXL.createHTML_NonXl(); 

		CustomReportHTML_Redesign.createHTML();

	}

	
	public static synchronized void onTestStart(HashMap<TestNGKeys, String> testDataMap) {

		// Adding this logic, becoz report failed to run on local
		String env = "";
		env = Constant.getEnvironmentInfoSheet();
		
		Scenario r = new Scenario();
		r.setStatus(STATUS.PASS.value);
		r.setTestNG_TestName(testDataMap.get(TestNGKeys.test));
		r.setEnvironment(env);
		r.setScenario(testDataMap.get(TestNGKeys.description));
		r.setDescription("");
		r.setStartTime_Scenario((new Date()).getTime());
		r.setBrowser(testDataMap.get(TestNGKeys.browser));
		r.setPlatform(testDataMap.get(TestNGKeys.platform));
		r.setTimeStamp(Util.convertToHHMMSS((new Date()).getTime()));
		r.setClassName(testDataMap.get(TestNGKeys.className));
		r.setMethodName(testDataMap.get(TestNGKeys.methodName));
		r.setPriority(testDataMap.get(TestNGKeys.priority));
		r.setDependsOn(testDataMap.get(TestNGKeys.dependsOn));
		r.setGroup(testDataMap.get(TestNGKeys.group));
		System.out.println("****************************************************************************************");
		System.out.println(testCounter++ + "/" + Scenario.getTotalScenario() + " | "
				+ Util.convertToHHMMSS(new Date().getTime()) + " | " + Thread.currentThread().getId() + " | "
				+ "Scenario: " + testDataMap.get(TestNGKeys.description) + "| Browser: "
				+ testDataMap.get(TestNGKeys.browser) + "| Platform: " + testDataMap.get(TestNGKeys.platform)
				+ "| Priority: " + testDataMap.get(TestNGKeys.priority)
				+ "| TestNG-Test: " + testDataMap.get(TestNGKeys.test)
				+ "| Environement: " + testDataMap.get(TestNGKeys.environment)
				);
		getCurrentThreadTestList_FromMap().add(r);
	}

	public static synchronized void onTestEnd_NonXl(String testExecutionMoviePath) {
		Scenario rs=getCurrentThreadTestList_FromMap().get(0);
		long time2=(new Date()).getTime();
		rs.setEndTime_Scenario(time2);
		long time1=rs.getStartTime_Scenario();
		rs.setExecutionTime_Scenario(Util.timeConversion(time2 - time1));
		if (testExecutionMoviePath!=null) {
			rs.setSnapshotURL(testExecutionMoviePath);
		}
		listOfList.add((ArrayList<Scenario>) getCurrentThreadTestList_FromMap());
		testMap.remove((int) (long) (Thread.currentThread().getId()));
	}

	//called by @test methods
	private static List<Scenario> getCurrentThreadTestList_FromMap(){
		List<Scenario> tempListObj=testMap.get((int) (long) (Thread.currentThread().getId()));
		if(tempListObj==null){
			tempListObj= new ArrayList<Scenario>();
			testMap.put((int) (long) (Thread.currentThread().getId()), tempListObj);
			//System.out.println("Created an ArrayList for storing the results thread: "+Thread.currentThread().getId());
		}else{
			//System.out.println("Existing ArrayList size: "+tempListObj.size()+" for storing the results thread: "+Thread.currentThread().getId());
		}
		return tempListObj; 
	}

	/**@author shailendra.rajawat
	 * Use this method to add the snapshot of passed web element object in Report
	 * */
	public static synchronized void report(String Constan, String description, Object element){
		//SessionId session = ((ChromeDriver)BaseTest.getDriver()).getSessionId();
		if(Constant.enableConsoleLogs){
			System.out.println(Thread.currentThread().getId()+" | "+Constan+" | "+description);
		}
		String url="";
		Scenario r = new Scenario();
		r.setTimeStamp(Util.convertToHHMMSS((new Date()).getTime()));
		r.setStatus(Constan);
		r.setDescription(description);
		r.setScenario("");

		if(Constan.equalsIgnoreCase(STATUS.FAIL.value) || Constan.equalsIgnoreCase(STATUS.FATAL.value)){
			url=SnapshotManager.takeSnapShot("failure");
			r.setSnapshotURL(url);
		}else if(element!=null){
			url=SnapshotManager.takeSnapShot("",element);
			r.setSnapshotURL(url);
		}
		//System.out.println("List Size "+customTestList.size()+" for Thread: "+Thread.currentThread().getId());
		getCurrentThreadTestList_FromMap().add(r);
		logExtentTest(Constan, description, url);
		manageAssertions(Constan, description);
	}

	public static synchronized void report_ExitCurrentNode(STATUS status, String description){
		if(Constant.enableConsoleLogs){
			System.out.println(Util.convertToHHMMSS(new Date().getTime())+" | "+Thread.currentThread().getId()+" | "+status.value+" | "+description);
		}
		String url="";

		Scenario r = new Scenario();
		r.setTimeStamp(Util.convertToHHMMSS((new Date()).getTime()));
		r.setStatus(status.value);
		r.setDescription(description);
		r.setScenario("");
		if(status.value.equalsIgnoreCase(STATUS.FAIL.value) || status.value.equalsIgnoreCase(STATUS.FATAL.value) ){
			url=SnapshotManager.takeSnapShot("failure");
			r.setSnapshotURL(url);
		}
		//System.out.println("List Size "+customTestList.size()+" for Thread: "+Thread.currentThread().getId());
		getCurrentThreadTestList_FromMap().add(r);

		logExtentTest(status.value, description, url);
		manageAssertions(status.value, description);
	}

	/**
	 * This method will add an Step to the Test. Which will then displayed in the
	 * HTML Report
	 * @param Status any of the Constants provided by STATUS enum
	 * @param description Detailed note about the step 
	 * @author shailendra.rajawat 05 Jan 2018 
	 */
	public static synchronized void report(STATUS Status, String description){
		//SessionId session = ((ChromeDriver)BaseTest.getDriver()).getSessionId();
		String Constan=Status.value;
		try{
			if(Constant.enableConsoleLogs){
				System.out.println(Util.convertToHHMMSS(new Date().getTime())+" | "+Thread.currentThread().getId()+" | "+Constan+" | "+description);
			}
			String url="";
			List<Scenario> customResultsList=getCurrentThreadTestList_FromMap();

			Scenario r = new Scenario();
			r.setTimeStamp(Util.convertToHHMMSS((new Date()).getTime()));
			r.setStatus(Constan);
			r.setDescription(description);
			r.setScenario("");
			if(Constan.equalsIgnoreCase(STATUS.FAIL.value) || Constan.equalsIgnoreCase(STATUS.FATAL.value)  || Constan.equalsIgnoreCase(STATUS.ERROR.value)){
				url=SnapshotManager.takeSnapShot("failure");
				r.setSnapshotURL(url);
			}
			
			int size=customResultsList.size();
			Scenario t=customResultsList.get(size-1);
			String status=t.getStatus();
			if (status.equalsIgnoreCase(STATUS.NODE.value)) {
				List<Scenario> nodeList=t.getList();
				nodeList.add(r);
			}else{
				//System.out.println("List Size "+customTestList.size()+" for Thread: "+Thread.currentThread().getId());
				customResultsList.add(r);
			}

			logExtentTest(Constan, description, url);
			manageAssertions(Constan, description);
		}catch (Exception e) {
		}
	}

	public static synchronized void createNode(String description) {
		//SessionId session = ((ChromeDriver)BaseTest.getDriver()).getSessionId();
		if(Constant.enableConsoleLogs){
			System.out.println(Util.convertToHHMMSS(new Date().getTime())+" | "+Thread.currentThread().getId()+" | "+STATUS.NODE.value+" | "+description);
		}
		
		Scenario r = new Scenario();
		r.setTimeStamp(Util.convertToHHMMSS((new Date()).getTime()));
		r.setStatus(STATUS.NODE.value);
		r.setDescription(description);
		r.setScenario("");

		//System.out.println("List Size "+customTestList.size()+" for Thread: "+Thread.currentThread().getId());
		getCurrentThreadTestList_FromMap().add(r);
		ExtentManager.createNode(description);
	}


	private static void logExtentTest(String Constan, String description,String url){
		try {
			ExtentTest test=ExtentManager.GetExtentTest();
			if(Constan.equalsIgnoreCase(STATUS.FAIL.value) || Constan.equalsIgnoreCase(STATUS.FATAL.value) || Constan.equalsIgnoreCase(STATUS.ERROR.value) ){
				if(url==null || "".equals(url)){
					test.log(ExtentManager.getStatus(Constan), description);
				}else{
					test.log(ExtentManager.getStatus(Constan), description,MediaEntityBuilder.createScreenCaptureFromPath(url).build());
				}
			}else{
				test.log(ExtentManager.getStatus(Constan), description);
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}

	private static void manageAssertions(String Constan, String description) {
		if(Constant.enableAssertions){
			if(Constan.equalsIgnoreCase(STATUS.FAIL.value) || Constan.equalsIgnoreCase(STATUS.FATAL.value) || Constan.equalsIgnoreCase(STATUS.ERROR.value)){
				Assert.fail(description);
			}
		}
	}

	private static  boolean deleteDirectory(File dir) {
		boolean bool=false;
		if (dir.isDirectory()) { 
			File[] children = dir.listFiles();
			for (int i = 0; i < children.length; i++) { 
				boolean success = deleteDirectory(children[i]);
				if (!success) { 
					return false; 
				} 
			} 
		} 
		// either file or an empty directory
		if(dir.getName().equals(Constant.reportFolderName)){
			//System.out.println("Skipping file or directory : " + dir.getName());
			bool=true;
		}else{
			//System.out.println("Removing file or directory : " + dir.getName());
			bool=dir.delete();
		}
		return bool;
	}

	


}
