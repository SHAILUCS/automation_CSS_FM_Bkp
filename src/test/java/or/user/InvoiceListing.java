package or.user;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reporting.Reporter;
import com.reporting.STATUS;
import com.selenium.SeleniumMethods;
import com.selenium.webdriver.DriverFactory;

public class InvoiceListing {
	private SeleniumMethods com;
	public static String title = "invoice_statement";

	@FindBy(name = "search")
	private WebElement txt_Search;
	

	
	public InvoiceListing() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}

	public void verifySearch(String data) {
		com.sendKeys("txt_Search", txt_Search, data, Keys.ENTER);
		
		String vendorData = com.getText(By.xpath("//div[@class='rt-td'][contains(.,'"+data+"')]"));
		
		if(vendorData.contains(data)) {
			Reporter.report(STATUS.PASS, data+" found");
		}else {
			Reporter.report(STATUS.FAIL, data+" not found");
		}
		
	}

	
}
