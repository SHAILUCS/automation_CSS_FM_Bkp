package or.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.reporting.Reporter;
import com.reporting.STATUS;
import com.selenium.ReactTable;
import com.selenium.SeleniumMethods;
import com.selenium.webdriver.DriverFactory;

public class VendorListing {

	private SeleniumMethods com;
	public static String title = "admin/vendors";

	public VendorListing() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}

	@FindBy(name = "key")
	private WebElement txt_Name;

	public void performSearch(String data) {

		com.wait(2);
		com.sendKeys(txt_Name, data, Keys.RETURN);

		com.wait(2);
		com.sendKeys(txt_Name, Keys.RETURN);

		com.wait(2);
		ReactTable tab = new ReactTable(By.className("rt-table"));

		int rowNum = tab.getRowWithCellText(data);

		if (rowNum > 0) {
			Reporter.report(STATUS.PASS, "Search succeeded");
		} else {
			Reporter.report(STATUS.FAIL, "Search failed");
		}
	}

}
