package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtilities;

public class ManageNewsTest extends Base {
	HomePage home ;
	ManageNewsPage news;
	
	@Test(description="Verify if the user is able to add and save new news")
	public void verifyIfUserIsAbleToAddnewNews() throws IOException
	{
		String usernameValue = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue);
		home = login.clickSignInButton();
		
		
		news = home.clickManageNewsMoreInfoButton();
		
		String newsValue= ExcelUtilities.getStringData(0, 0, "ManageNewsPage");
		news.clickNewButton().enterNews(newsValue).clickSaveButton();
		
		boolean isAlertDisplayed = news.isSuccessAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constant.UNABLETOADDNEWSERROR);
		
	}
	
	@Test(description="Verify if the user is able to search news")
	public void verifyWhetheUserCanSearchNews() throws IOException 
	{
		String usernameValue = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue);
		home = login.clickSignInButton();
		
		
		news = home.clickManageNewsMoreInfoButton();
		
		String newsForSearchValue = ExcelUtilities.getStringData(0, 0, "ManageNewsPage");
		news.clickSearchButton().enterSearchNews(newsForSearchValue).clickSearchNewsButton();
		
		String expected = "Womens day";
		String actual = news.isNewsDisplayed();
		Assert.assertEquals(actual, expected,Constant.SEARCHNEWSERROR);
		
	}
	

}
