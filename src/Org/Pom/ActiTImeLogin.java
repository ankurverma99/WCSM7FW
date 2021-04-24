package Org.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTImeLogin {
	@FindBy(id = "username")
	private WebElement username;

	@FindBy(name = "pwd")
	private WebElement password;

	@FindBy(xpath = "//a[@id='loginButton']")
	private WebElement login;

	@FindBy(linkText = "Forgot your password?")
	private WebElement forgotPassword;

	@FindBy(partialLinkText = "actiTIME Inc.")
	private WebElement actiTIMEInc;

	public ActiTImeLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendUser(String name) {
		username.sendKeys(name);
	}

	public void sendpass(String pass) {
		password.sendKeys(pass);
	}

	public void loginClick() {
		login.click();
	}

	public void forgotPassClick() {
		forgotPassword.click();
	}

	public void actiTimeInc() {
		actiTIMEInc.click();
	}

}
