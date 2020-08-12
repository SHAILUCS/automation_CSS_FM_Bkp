package or.common;

import com.reporting.Reporter;
import com.reporting.STATUS;
import com.selenium.SeleniumMethods;
import com.util.Constant;
import com.xl.ExcelManager;

public class LoginHelper {
	
	public static String performLogin(Object username, Object pwd, Object btn, String type) {
		SeleniumMethods com = new SeleniumMethods();
		
		String SHEET_NAME = Constant.getEnvironmentInfoSheet();
		String user = "";
		String pass = "";

		ExcelManager DataTable = new ExcelManager(Constant.getTestDataFilePath(), SHEET_NAME);
		int rowCount = DataTable.getRowCount();
		int credentialsRow = -1;
		for (int row = 1; row < rowCount; row++) {
			String userType = DataTable.getValue(row, "user type");
			if (type.equalsIgnoreCase(userType)) {
				credentialsRow = row;
				break;
			}
		}

		if (credentialsRow != -1) {
			user = DataTable.getValue(credentialsRow, "username");
			pass = DataTable.getValue(credentialsRow, "password");
		} else {
			Reporter.report(STATUS.FAIL,
					"Passsed user type '" + type + "' is not present in the test data sheet " + SHEET_NAME);
		}

		com.sendKeys("Username", username, user);
		com.sendKeys(pwd, pass);
		com.click(btn, "Login button");
		com.wait(5);
		
		return user;
	}
}
