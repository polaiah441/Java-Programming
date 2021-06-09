package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement logoutLink;
	
	
	//Action methods
	public void setUsername(String username) {
		email.clear();
		email.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickOnLogin() {
		loginBtn.click();
	}
	
	public void clickOnLogout() {
		logoutLink.click();
	}
	
	
	
	
}
