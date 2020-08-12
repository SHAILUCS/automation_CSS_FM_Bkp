package or.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.SeleniumMethods;
import com.selenium.webdriver.DriverFactory;

public class AddManualStatement {
	
	private SeleniumMethods com;
	public static String title = "add_statement";

	
	@FindBy(css = "i[class*='plus']")
	private WebElement icon_Plus;
	
	
	public AddManualStatement() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}
	
	public void addTranactionRow() {
		com.click(icon_Plus, "icon_Plus");
		
	}

	
}
