package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(id="news") private WebElement newsTextArea;
	@FindBy(xpath="//button[@type='submit']") private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement successAlert;
	@FindBy(xpath="//a[@onclick='click_button(2)']") private WebElement searchButton;
	@FindBy(name="un") private WebElement searchNewsTextArea;
	@FindBy(xpath="//button[@type='submit']") private WebElement searchNewsButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]") private WebElement searchNewsResult;
	
	public ManageNewsPage clickNewButton()
	{
		newButton.click();
		return this;
	
	}
	
	public ManageNewsPage enterNews(String newsValue)
	{
		newsTextArea.sendKeys(newsValue);
		return this;
	}

	public ManageNewsPage clickSaveButton()
	{
		saveButton.click();
		return this;
	
	}
	
	public boolean isSuccessAlertDisplayed()
	{
		return successAlert.isDisplayed();
	}
	public ManageNewsPage clickSearchButton()
	{
		searchButton.click();
		return this;
		
	
	}
	public ManageNewsPage enterSearchNews(String newsValue)
	{
		searchNewsTextArea.sendKeys(newsValue);
		return this;
	}
	
	public ManageNewsPage clickSearchNewsButton()
	{
		searchNewsButton.click();
		return this;
	
	}
	public String isNewsDisplayed()
	{
		return searchNewsResult.getText();
	}
	
}
