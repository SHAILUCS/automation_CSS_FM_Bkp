package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.reporting.Reporter;
import com.reporting.STATUS;
import com.selenium.SeleniumMethods;
import com.selenium.webdriver.DriverFactory;

import or.admin1.Dashboard;
import or.admin1.Login;

public class DemoTests {
	
	@Test(groups = {"regression","smoke"})
	private void browserLevelActionsDemo() {
		Login login = new Login();
		login.load_App_URL();
		login.performLogin("Admin");
		
		SeleniumMethods com = new SeleniumMethods();
	
		Dashboard d = new Dashboard();
		com.navigateToAndVerifyPageUrl(d.leave,"viewLeaveList");
		
		com.wait(2);
		
		com.navigateBack();
	
		com.wait(2);
		com.refresh();
		
		com.wait(2);
		com.navigateForward();
		
		com.wait(2);
		com.navigateTo("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}
	
	@Test(groups = {"smoke"})
	private void locatingDynamicObjectsDemo() {
		Login login = new Login();
		login.load_App_URL();
		login.performLogin("Admin");
		SeleniumMethods com = new SeleniumMethods();
		
		Dashboard d = new Dashboard();
		com.navigateToAndVerifyPageUrl(d.myInfo,"viewMyDetails");
		
	}
	
	@Test
	private void getCommandsDemo() {
		Login login = new Login();
		login.load_App_URL();
		login.performLogin("Admin");
		SeleniumMethods com = new SeleniumMethods();
		Dashboard d = new Dashboard();

		Reporter.createNode("GET CURRENT URL");
		Reporter.report(STATUS.INFO, com.getCurrentUrl());

		Reporter.createNode("GET ATTRIBUTE");
		Reporter.report(STATUS.INFO, com.getAttribute(d.leave, "href"));

		Reporter.createNode("GET PAGE SOURCE");
		Reporter.report(STATUS.INFO, com.getPageSource());

		Reporter.createNode("GET TEXT");
		Reporter.report(STATUS.INFO, com.getText(d.applyLeave));

		Reporter.createNode("GET TITLE");
		Reporter.report(STATUS.INFO, com.getTitle());

		Reporter.createNode("GET CURRENT WINDOW HANDLE");
		Reporter.report(STATUS.INFO, com.getWindowHandle());

		Reporter.createNode("GET OBJ HEIGHT");
		Reporter.report(STATUS.INFO, com.getHeight(d.recruitment)+"");
		
		Reporter.createNode("GET BY OBJ FROM WEB ELEMENT");
		Reporter.report(STATUS.INFO, com.getByObjectFromWebElement(d.recruitment)+"");
	}
	
	@Test
	private void closingTabDemo() {
		Login login = new Login();
		login.load_App_URL();
		login.performLogin("Admin");
		SeleniumMethods com = new SeleniumMethods();
		
		Dashboard d = new Dashboard();
		
		com.sendKeys(d.leave, Keys.chord(Keys.CONTROL,Keys.RETURN));
		
		String currentTab = com.getWindowHandle();
		
		com.switchTo_Tab_UrlContains("invoice_statement");
		
		com.close();
		
		com.switchTo_Window(currentTab);
		
		com.navigateToAndVerifyPageUrl(d.leave,"viewLeaveList");
		
	}
	
	@Test
	private void switchToFrameDemo() {
		SeleniumMethods com = new SeleniumMethods();
		com.get("https://www.w3schools.com/html/html_iframe.asp");

		com.switchTo_Frame(By.xpath("//iframe[@title='W3Schools HTML Tutorial']"));

		com.click(By.partialLinkText("Start learning HTML now"), "link Start learning HTML now");

		com.switchTo_DefaultContent();

		com.click(By.partialLinkText("HTML HOME"), "link HTML HOME");
	}

	@Test
	private void alertDemo() {
		SeleniumMethods com = new SeleniumMethods();
		com.get("file:///home/shailu/git/QA_Automation/DemoData/Result.html");

		// ********************************************
		Reporter.createNode("Alert Example 1");

		com.click(By.id("al1"), "Alert Example 1");

		com.wait(2);

		String txt = com.closeAlertAndGetItsText(true);
		Reporter.report(STATUS.PASS, "Accepted alert " + txt);

		com.wait(2);

		// ********************************************
		Reporter.createNode("Alert Example 2");
		com.click(By.id("al2"), "Alert Example 2");

		com.wait(2);

		txt = com.closeAlertAndGetItsText(true);
		Reporter.report(STATUS.PASS, "Accepted alert " + txt);

		com.wait(2);

		com.click(By.id("al2"), "Alert Example 2");

		com.wait(2);

		txt = com.closeAlertAndGetItsText(false);
		Reporter.report(STATUS.PASS, "Rejected alert " + txt);

		// ********************************************
		Reporter.createNode("Alert Example 3");
		com.click(By.id("al3"), "Alert Example 3");

		com.wait(2);

		txt = com.closeAlertAndGetItsText("AUTOMATION", true);
		Reporter.report(STATUS.PASS, "Accepted alert " + txt);

		com.wait(2);

		com.click(By.id("al3"), "Alert Example 3");

		com.wait(2);

		txt = com.closeAlertAndGetItsText("AUTOMATION", false);
		Reporter.report(STATUS.PASS, "Rejected alert " + txt);
	}

	@Test
	private void dropdownDemo() {
		SeleniumMethods com = new SeleniumMethods();
		com.get("file:///home/shailu/git/QA_Automation/DemoData/Result.html");

		// ********************************************
		Reporter.createNode("Select By index");
		com.selectByIndex(By.id("single"), 4);
		com.wait(2);

		// ********************************************
		Reporter.createNode("Select By value");
		com.selectByValue(By.id("single"), "C");
		com.wait(2);

		// ********************************************
		Reporter.createNode("Select By visible text");
		com.selectByVisibleText(By.id("single"), "USA");
		com.wait(2);

		// ********************************************
		Reporter.createNode("Select By Partial visible text");
		com.selectByPartialVisibleText(By.id("single"), "Cro");
		com.wait(2);

		// ********************************************
		Reporter.createNode("Deselecting the dropdown value");
		com.selectByIndex(By.id("single"), 0);
		com.wait(2);

		// ********************************************
		Reporter.createNode("Select By index");
		com.selectByIndex(By.id("shuttle"), 1);
		com.wait(2);

		// ********************************************
		Reporter.createNode("Select By value");
		com.selectByValue(By.id("shuttle"), "UK");
		com.wait(2);

		// ********************************************
		Reporter.createNode("Select By visible Text");
		com.selectByVisibleText(By.id("shuttle"), "USA");
		com.wait(2);

		// ********************************************
		Reporter.createNode("Select By partial visible Text");
		com.selectByPartialVisibleText(By.id("shuttle"), "Cro");
		com.wait(2);

		// ********************************************
		Reporter.createNode("DeSelect By partial visible Text");
		com.deselectByPartialVisibleText(By.id("shuttle"), "Cro");
		com.wait(2);

		// ********************************************
		Reporter.createNode("Deselect All");
		com.deselectAll(By.id("shuttle"));
		com.wait(2);

		// ********************************************
		Reporter.createNode("Select All");
		com.selectAll(By.id("shuttle"));
		com.wait(2);

	}

	@Test
	private void mouseActionsDemo() {

		SeleniumMethods com = new SeleniumMethods();
		com.get("file:///home/shailu/git/QA_Automation/DemoData/Result_Extentv3.html");

		// ********************************************
		Reporter.createNode("Select Fatal from menu");
		Actions act = new Actions(DriverFactory.getDriver());
		act.moveToElement(com.findElement(By.xpath("//a[contains(.,' Status')]"))).perform();
		com.wait(2);

		com.click(By.xpath("//a[contains(.,'Fatal')]"), "Fatal");
		com.wait(2);
	}

	@Test
	private void keyboardActionsDemo() {

	}

	@Test
	private void javascriptActionsDemo() {
		SeleniumMethods com = new SeleniumMethods();

		com.get("file:///home/shailu/git/QA_Automation/DemoData/Result.html");
		com.wait(2);

		// Java script click
		com.javaScript_Click(By.xpath("/html/body/center/table/tbody/tr[3]/td[4]/span/input"),
				"Selecting first chckbox using java script");
		com.wait(2);

		// Java script scroll into Middle view
		com.javaScript_ScrollIntoMIDDLEView_AndHighlight(By.id("shuttle"));
		com.wait(2);

		// Java script scroll into view and click
		com.javaScript_ScrollIntoBOTTOMView_AndHighlight_ThenClick(
				By.xpath("/html/body/center/table/tbody/tr[5]/td[4]/span/input"),
				"Scroll to bottom view highlight then click");
		com.wait(2);

	}

	@Test
	private void sendKeysDemo() {
		SeleniumMethods com = new SeleniumMethods();

		com.get("file:///home/shailu/git/QA_Automation/DemoData/Result.html");
		com.wait(2);

		
		com.sendKeys(By.id("txtar"),"MY TEXT");
		com.wait(2);
		
		
		com.clear(By.id("txtar"));
		com.wait(2);
		

		com.sendKeys("THIS WILL BE ADDED IN REPORT",By.id("txtar"),"MY TEXT");
		com.wait(2);
		
		com.clear(By.id("txtar"));
		com.wait(2);
		
		com.sendKeys("THIS WILL DEMO THE ENTER KEYS",By.id("txtar"), "MY TEXT" , Keys.ENTER, "AFTER ENTER");
		com.wait(2);
	}

	@Test
	private void fileUploadDownloadDemo() {
		SeleniumMethods com = new SeleniumMethods();

		com.get("http://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload");
		com.wait(2);
		
		com.sendKeys(By.cssSelector("input[name='file_upload']"), "/home/shailu/git/QA_Automation/DemoData/main-image2.jpg");
		com.wait(2);
		com.click(By.cssSelector("input[name='http_submit']"), "Upload button");
		com.wait(5);
		
		com.get("https://chromedriver.storage.googleapis.com/index.html?path=85.0.4183.38/");
		com.wait(2);
		
		com.click(By.linkText("chromedriver_win32.zip"), "chromedriver_win32.zip link");
		com.wait(20);
		
	}
}
