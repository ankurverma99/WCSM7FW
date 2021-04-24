package Org.testPom;

import org.testng.annotations.Test;

import Org.Genric.BaseTest;
import Org.Genric.Xl;
import Org.Pom.ActiTImeLogin;
import Org.Pom.EnterTimeTracker;

public class ActimeLogin extends BaseTest {

	@Test
	public void validLogin() throws Exception {
		sheetName = Xl.readConfig(proFile, "XLsheet");// login
		fileName = Xl.readConfig(proFile, "XlFile");// framwork.xlsx
		String user = Xl.readCell(xl_path + fileName, sheetName, 1, 0);
		String pass = Xl.readCell(xl_path + fileName, sheetName, 2, 1);
		ActiTImeLogin al = new ActiTImeLogin(driver);
		al.sendUser(user);
		al.sendpass(pass);
		al.loginClick();
		EnterTimeTracker ett = new EnterTimeTracker(driver);
		ett.isHomePageDisplyed(driver);
	}

}
