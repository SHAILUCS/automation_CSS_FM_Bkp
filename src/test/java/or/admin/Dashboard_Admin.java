package or.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.SeleniumMethods;
import com.selenium.webdriver.DriverFactory;

public class Dashboard_Admin {
	public static final String url = "admin/dashboard";

	SeleniumMethods com;

	public Dashboard_Admin() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
		com = new SeleniumMethods();
	}
	
	@FindBy(linkText = "Vendors List")
	private WebElement link_VendorsList;
	
	public void navigateToVendorList() {
		com.navigateToAndVerifyPageUrl(link_VendorsList, VendorListing.title);
	}


}
