package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;

public class AdminUserPage {
	public WebDriver driver;
	PageUtility page = new PageUtility();
	public AdminUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath="//a[@onclick='click_button(2)']") private WebElement searchButton;
	@FindBy(id="un") private WebElement usernameForSearch;
	@FindBy(id="ut") private WebElement usertypeForSearch;
	@FindBy(xpath="//button[@name='Search']") private WebElement adminUserSearchButton;
	
	
	@FindBy(id="username") private WebElement username;
	@FindBy(id="password") private WebElement password;
	@FindBy(id="user_type") private WebElement usertype;
	@FindBy(xpath="//button[@name='Create']") private WebElement savebutton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement successMessage;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") private WebElement username1;
	
	
	public AdminUserPage clickNewButton()
	{
		newButton.click();
		return this;
		
	}
	
	public AdminUserPage enterUsername(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
		return this;
	}
	
	public AdminUserPage enterPassword(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
	}
	
	public AdminUserPage selectUserType()
	{
		page.selectDragDropWithIndex(usertype, 1);
		//Select s = new Select(usertype);
	//	s.selectByIndex(1);
		return this;
	}
	
	public AdminUserPage clickSaveButton()
	{
		savebutton.click();
		return this;
	}
	
	public AdminUserPage clickSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public AdminUserPage enterUsernameForSearch(String usernameForSearchValue)
	{
		usernameForSearch.sendKeys(usernameForSearchValue);
		return this;
		
	}
	
	
	public AdminUserPage selectUserTypeForSearch()
	{
		page.selectDragDropWithIndex(usertypeForSearch,1);
		// s = new Select(usertypeForSearch);
		//s.selectByIndex(1);
		return this;
		
	}
	
	public AdminUserPage clickAdminUserSearchButton()
	{
		adminUserSearchButton.click();
		return this;
	}
	
	public boolean isSuccessAlertDisplayed()
	{
		return successMessage.isDisplayed();
		
	}
	
	public String isUsername1Displayed()
	{
		return username1.getText();
	}

}
