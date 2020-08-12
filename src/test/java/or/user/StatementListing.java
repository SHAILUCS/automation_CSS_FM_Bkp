package or.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.SeleniumMethods;
import com.selenium.webdriver.DriverFactory;

public class StatementListing {
	private SeleniumMethods com;
	public static String title = "bank_statement";

	@FindBy(xpath = "//button[.='Add Statement']")
	private WebElement btn_AddStmt;
	
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement btn_Submit;
	
	public StatementListing() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}


	public void openAddManualStatementForm() {
		com.click(btn_AddStmt, "btn_AddStmt");
		com.wait(1);
		
		com.navigateToAndVerifyPageUrl(btn_Submit, AddManualStatement.title);
	}

}
