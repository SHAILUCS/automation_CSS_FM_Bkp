package or.admin1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.reporting.Reporter;
import com.reporting.STATUS;
import com.selenium.SeleniumMethods;
import com.selenium.webdriver.DriverFactory;
import com.util.Constant;
import com.xl.ExcelManager;

import or.common.LoginHelper;

public class Login {

	private static final String title = "Finance Manager";

	private static final String SHEET_NAME = Constant.getEnvironmentInfoSheet();

	@FindBy(id = "txtUsername")
	private WebElement text_Email;

	@FindBy(id = "txtPassword")
	private WebElement text_Password;

	@FindBy(id = "btnLogin")
	private WebElement button_Login;

	SeleniumMethods com;

	public Login() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}

	
	public void performLogin(String type) {
		
		String user = LoginHelper.performLogin(text_Email, text_Password, button_Login, type);
		
		if (com.verifyPageUrl(Dashboard.url)) {
			Reporter.report(STATUS.PASS, "Login succeed with user id: " + type + " and username: " + user);
		} else {
			Reporter.report(STATUS.PASS,
					"Login Failed with user mapping id: " + type + " and username: " + user);
			Assert.fail("Login Failed with user mapping id: " + type + " and username: " + user);
		}
	}

	public Login load_App_URL() {

		Reporter.createNode("Loading " + title + " URL");

		ExcelManager dataTable = new ExcelManager(Constant.getTestDataFilePath(), SHEET_NAME);
		String baseUrl = dataTable.getValue(1, "url");
		com.get(baseUrl);
		Reporter.report(STATUS.INFO, "Fired up url: " + "<br/><b style='font-size: small;'>" + baseUrl + "</b>");

		return this;
	}

}
