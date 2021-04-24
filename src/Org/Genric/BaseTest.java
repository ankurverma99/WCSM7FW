package Org.Genric;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst {
	public WebDriver driver;
	public String browser;
	public String sheetName;
	public String fileName;

	@BeforeMethod
	public void openBrowser() throws Exception {
		FileInputStream fis = new FileInputStream(proFile);
		Properties p = new Properties();
		p.load(fis);
		browser = p.getProperty("Browser");//firefox
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(chrome_key, chrome_value);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(firefox_key, firefox_value);
			driver = new FirefoxDriver();
		} else {
			driver = null;
		}
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser(ITestResult testResult) throws IOException {
		int status = testResult.getStatus();//status of testcase
		String name = testResult.getName();//name of testcase
		if (status == 1) {
			Reporter.log("Testcase " + name + " is pass", true);
		} else {
			Reporter.log("Testcase " + name + " is fail", true);
			String path = img_path + name + ".png";
			ScreenS.takePic(driver, path);
		}
		driver.close();

	}

}
