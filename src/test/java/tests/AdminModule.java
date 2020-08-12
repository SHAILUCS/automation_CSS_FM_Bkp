package tests;

import org.testng.annotations.Test;

import com.reporting.Reporter;
import com.reporting.STATUS;

import or.admin.Login_Admin;

public class AdminModule {
	
	@Test
	private void DemoTest1() {
		Login_Admin login = new Login_Admin();
		login.load_App_URL();
		login.performLogin("SSR");
	}
	
	@Test
	private void DemoTest2() {
		Login_Admin login = new Login_Admin();
		login.load_App_URL();
		login.performLogin("SSR");
		
		Reporter.report(STATUS.PASS, "");
	}
}
