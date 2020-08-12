package com.reporting.pojos;

import java.util.ArrayList;
import java.util.List;

import com.reporting.STATUS;

public class TestNGSuite_POJO {
	
	public TestNGSuite_POJO(String suiteName) {
		this.suiteName = suiteName;
		this.status = STATUS.PASS.value;
	}
	
	List<TestNGTests_POJO> testList;

	private String suiteName;
	private String status;
	
	public String getSuiteName() {
		return suiteName;
	}

	public TestNGTests_POJO addTests(String testName) {
		if(testList == null) {
			initTestList();
		}
		
		TestNGTests_POJO testNGTests = new TestNGTests_POJO(testName);
		testList.add(testNGTests);
		return testNGTests;
	}
	
	public List<TestNGTests_POJO> getTestList() {
		return testList;
	}

	public void initTestList() {
		this.testList = new ArrayList<TestNGTests_POJO>();
	}

	/**
	 * @param testNgTest
	 * @return
	 */
	public TestNGTests_POJO containsTest(String testNgTest) {
		if(testList !=null) {
			for (TestNGTests_POJO testNGTest : testList) {
				if (testNGTest.getTestName().equalsIgnoreCase(testNgTest)) {
					return testNGTest;
				}
			}
		}
		return null;
	}
	

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
