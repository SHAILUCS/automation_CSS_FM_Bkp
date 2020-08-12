package com.reporting.pojos;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
	
	private List<Scenario> testList;
	
	private static String suiteName;
	private String testName;
	private String environment;
	private String className;
	private String methodName;
	private String priority;
	private String group;
	private String dependsOn;

	
	private String status;
	
	private String srNo;
	private String scenario;
	private String description;
	private static String inParallel;
	private static String threadCount;
	private String snapshotURL;
	private String timeStamp;
	private long startTime_Scenario;
	private long endTime_Scenario;
	private String executionTime_Scenario;
	private String browser;
	private String platform;
	private static long testExecutionStartDate=0l;
	private static long testExecutionEndDate=0l;
	private static String testExecutionTime;
	private static long totalScenario=0;
	private static long passedScenario=0;
	private static long failedScenario=0;
	private static long skippedScenario=0;
	private static long errorScenario=0;
	private static long warningScenario=0;
	private static long fatalScenario=0;
	
	private static double passingPercent=0;
	private static double failurePercent=0;
	private static double skipPercent=0;
	
	private static long totalStep=0;
	private static long passedStep=0;
	private static long failedStep=0;
	private static long skippedStep=0;
	private static long errorStep=0;
	private static long warningStep=0;
	private static long fatalStep=0;
	
	public String toString(){
		return "{"+scenario+", "+description+", "+status+", "+testList+"}\n";
	}
	
	public List<Scenario> getList() {
		if (testList==null) {
			testList=new ArrayList<Scenario>();
		}
		return testList;
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getDependsOn() {
		return dependsOn;
	}
	public void setDependsOn(String dependsOn) {
		this.dependsOn = dependsOn;
	}
	
	public String getSrNo() {
		if (srNo==null) {
			return "";
		}
		return srNo;
	}
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	public String getTestNG_MethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
		
	public static String getTestNG_SuiteName() {
		return suiteName;
	}
	public static void setTestNG_SuiteName(String suiteName) {
		Scenario.suiteName = suiteName;
	}
	public String getTestNG_TestName() {
		return testName;
	}
	public void setTestNG_TestName(String testName) {
		this.testName = testName;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public static long getTotalStep() {
		return totalStep;
	}
	public static void setTotalStep(long totalStep) {
		Scenario.totalStep = totalStep;
	}
	public static long getPassedStep() {
		return passedStep;
	}
	public static void setPassedStep(long passedStep) {
		Scenario.passedStep = passedStep;
	}
	public static long getFailedStep() {
		return failedStep;
	}
	public static void setFailedStep(long failedStep) {
		Scenario.failedStep = failedStep;
	}
	public static long getSkippedStep() {
		return skippedStep;
	}
	public static void setSkippedStep(long skippedStep) {
		Scenario.skippedStep = skippedStep;
	}
	public static long getErrorStep() {
		return errorStep;
	}
	public static void setErrorStep(long errorStep) {
		Scenario.errorStep = errorStep;
	}
	public static long getWarningStep() {
		return warningStep;
	}
	public static void setWarningStep(long warningStep) {
		Scenario.warningStep = warningStep;
	}
	public static long getFatalStep() {
		return fatalStep;
	}
	public static void setFatalStep(long fatalStep) {
		Scenario.fatalStep = fatalStep;
	}
	public static long getErrorScenario() {
		return errorScenario;
	}
	public static void setErrorScenario(long errorScenario) {
		Scenario.errorScenario = errorScenario;
	}
	public static long getWarningScenario() {
		return warningScenario;
	}
	public static void setWarningScenario(long warningScenario) {
		Scenario.warningScenario = warningScenario;
	}
	public static long getFatalScenario() {
		return fatalScenario;
	}
	public static void setFatalScenario(long fatalScenario) {
		Scenario.fatalScenario = fatalScenario;
	}
	
	public static double getPassingPercent() {
		return passingPercent;
	}

	public static void setPassingPercent(double passingPercent) {
		Scenario.passingPercent = passingPercent;
	}

	public static double getFailurePercent() {
		return failurePercent;
	}

	public static void setFailurePercent(double failurePercent) {
		Scenario.failurePercent = failurePercent;
	}

	public static double getSkipPercent() {
		return skipPercent;
	}

	public static void setSkipPercent(double skipPercent) {
		Scenario.skipPercent = skipPercent;
	}
	
	public long getEndTime_Scenario() {
		return endTime_Scenario;
	}
	public void setEndTime_Scenario(long endTime) {
		this.endTime_Scenario = endTime;
	}
	public String getSnapshotURL() {
		if (snapshotURL==null) {
			return "";
		}
		return snapshotURL;
	}
	public void setSnapshotURL(String snapshotURL) {
		this.snapshotURL = snapshotURL;
	}
	public static String getTestExecutionTime() {
		
		return testExecutionTime;
	}
	public static void setTestExecutionTime(String testExecutionTime) {
		Scenario.testExecutionTime = testExecutionTime;
	}
	public static String getInParallel() {
		return inParallel;
	}
	public static void setInParallel(String inParallel) {
		Scenario.inParallel = inParallel;
	}
	public String getStatus() {
		return status;
	}
	public String getScenario() {
		return scenario;
	}
	public String getDescription() {
		return description;
	}
	public long getStartTime_Scenario() {
		return startTime_Scenario;
	}
	public static long getTestExecutionStartDate() {
		return testExecutionStartDate;
	}
	public static long getTestExecutionEndDate() {
		return testExecutionEndDate;
	}
	public String getBrowser() {
		if (browser==null) {
			return "";
		}
		return browser;
	}
	public String getPlatform() {
		if (platform==null) {
			return "";
		}
		return platform;
	}
	public static long getTotalScenario() {
		return totalScenario;
	}
	public static long getPassedScenario() {
		return passedScenario;
	}
	public static long getFailedScenario() {
		return failedScenario;
	}
	public static long getSkippedScenario() {
		return skippedScenario;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStartTime_Scenario(long l) {
		this.startTime_Scenario = l;
	}
	public static void setTestExecutionStartDate(long l) {
		if(Scenario.testExecutionStartDate==0l){
			Scenario.testExecutionStartDate = l;
		}
	}
	public static void setTestExecutionEndDate(long l) {
		Scenario.testExecutionEndDate = l;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public static void setTotalScenario(long totalScenario) {
		Scenario.totalScenario = totalScenario;
	}
	public static void setPassedScenario(long passedScenario) {
		Scenario.passedScenario = passedScenario;
	}
	public static void setFailedScenario(long failedScenario) {
		Scenario.failedScenario = failedScenario;
	}
	public static void setSkippedScenario(long skippedScenario) {
		Scenario.skippedScenario = skippedScenario;
	}
	public String getExecutionTime_Scenario() {
		if (executionTime_Scenario==null) {
			return "";
		}
		return executionTime_Scenario;
	}
	public void setExecutionTime_Scenario(String executionTime_Scenario) {
		this.executionTime_Scenario = executionTime_Scenario;
	}
	public String getTestNG_Priority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return
	 */
	public static void setThreadCount(String threadCount) {
		Scenario.threadCount = threadCount;
	}
	public static String getThreadCount() {
		if(threadCount == null)
			return "";
		return threadCount;
	}
	
}