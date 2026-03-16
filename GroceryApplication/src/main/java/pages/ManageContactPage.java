package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	public WebDriver driver;
	public ManageContactPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@role='button']") private WebElement editButton;
	@FindBy(id="phone") private WebElement contactUsPhone;
	@FindBy(id="email") private WebElement contactUsEmail;
	@FindBy(xpath="//textarea[@name='address']") private WebElement contactUsAddress;
	@FindBy(xpath="//button[@name='Update']") private WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement successMessage;
	
	public ManageContactPage clickEditButton()
	{
		editButton.click();
		return this;
	}
	
	public ManageContactPage enterPhone(String phoneValue)
	{
		contactUsPhone.clear();
		contactUsPhone.sendKeys(phoneValue);
		return this;
	}
	public ManageContactPage enterEmail(String emailValue)
	{
		contactUsEmail.clear();
		contactUsEmail.sendKeys(emailValue);
		return this;
	}
	public ManageContactPage enterAddress(String addressValue)
	{
		contactUsAddress.clear();
		contactUsAddress.sendKeys(addressValue);
		return this;
	}
	public ManageContactPage clickUpdateButton()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", updateButton);
		return this;
	}
	public boolean isSuccessAlertDisplayed()
	{
		return successMessage.isDisplayed();
		
	}
	
	

}
