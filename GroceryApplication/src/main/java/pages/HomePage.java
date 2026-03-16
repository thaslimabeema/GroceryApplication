package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public WebDriver driver;
	public HomePage( WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(xpath = "//a[@data-toggle='dropdown' and @class='nav-link']") private WebElement adminButton;
	@FindBy(linkText="Logout") private WebElement logoutButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") private WebElement adminUsersMoreInfoButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']") private WebElement manageContactMoreInfoButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") private WebElement manageNewsMoreInfoButton;
	
	public HomePage clickAdminButton()
	{
		adminButton.click();
		return this;
	}
	
	public LoginPage clickLogoutButton()
	{
		logoutButton.click();
		return new LoginPage(driver);
		
	}
	
	public AdminUserPage clickAdminUsersMoreInfoButton()
	{
		adminUsersMoreInfoButton.click();
		return new AdminUserPage(driver);
	}
	
	public ManageContactPage clickManageContactMoreInfoButton()
	{
		manageContactMoreInfoButton.click();
		return new ManageContactPage(driver);
	}
	
	public ManageNewsPage clickManageNewsMoreInfoButton()
	{
		manageNewsMoreInfoButton.click();
		return new ManageNewsPage(driver);
	}
	

}
