package Org.Pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EnterTimeTracker {

	@FindBy(id = "addTaskButtonId")
	private WebElement New;

	public void isHomePageDisplyed(WebDriver driver) {
		WebDriverWait ww = new WebDriverWait(driver, 10);
		try {
			ww.until(ExpectedConditions.titleContains("Enter"));
			Reporter.log("Home Page is displayed", true);
		} catch (Exception e) {
			Reporter.log("Home page is not displayed", true);
			Assert.fail();
			e.printStackTrace();
		}
	}

	public EnterTimeTracker(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void newClick() {
		New.click();
	}

}
