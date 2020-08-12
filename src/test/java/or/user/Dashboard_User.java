package or.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.SeleniumMethods;
import com.selenium.webdriver.DriverFactory;

public class Dashboard_User {
	public static final String url = "user/dashboard";

	@FindBy(linkText =  "Bank Statement")
	public WebElement link_BankStatement;
	
	@FindBy(linkText =  "Invoice Statement")
	public WebElement link_InvoiceStatement;

	SeleniumMethods com;

	public Dashboard_User() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}

}
