package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username") private WebElement username;
	@FindBy(name="password") private WebElement pass;
	@FindBy(xpath="//button[@type='submit']") private WebElement signInButton;
	@FindBy(xpath="//p[text()='Dashboard']") private WebElement dashboardText;
	@FindBy(xpath="//b[text()='7rmart supermarket']") private WebElement Text;
	
	public LoginPage enterUsername(String usernameValue)
	{
		username.sendKeys(usernameValue);
		return this;
	}
	
	public LoginPage enterPassword(String passwordValue)
	{
		pass.sendKeys(passwordValue);
		return this;
	}
	
	public HomePage clickSignInButton()
	{
		wait.waitUntilElementToBeClickable(driver, signInButton);
		signInButton.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed()
	{
		return dashboardText.isDisplayed();
	}
	
	public String isTextDisplayed()
	{
		return Text.getText();
	}
	

}


